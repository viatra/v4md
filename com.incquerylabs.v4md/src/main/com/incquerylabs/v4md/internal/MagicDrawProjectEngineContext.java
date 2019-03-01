package com.incquerylabs.v4md.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.scope.IBaseIndex;
import org.eclipse.viatra.query.runtime.api.scope.IEngineContext;
import org.eclipse.viatra.query.runtime.api.scope.IIndexingErrorListener;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.base.api.NavigationHelper;
import org.eclipse.viatra.query.runtime.base.api.filters.IBaseIndexObjectFilter;
import org.eclipse.viatra.query.runtime.base.api.filters.IBaseIndexResourceFilter;
import org.eclipse.viatra.query.runtime.base.core.NavigationHelperImpl;
import org.eclipse.viatra.query.runtime.base.exception.ViatraBaseException;
import org.eclipse.viatra.query.runtime.emf.DynamicEMFQueryRuntimeContext;
import org.eclipse.viatra.query.runtime.emf.EMFBaseIndexWrapper;
import org.eclipse.viatra.query.runtime.emf.EMFQueryRuntimeContext;
import org.eclipse.viatra.query.runtime.matchers.ViatraQueryRuntimeException;
import org.eclipse.viatra.query.runtime.matchers.context.IQueryRuntimeContext;

import com.google.common.collect.Sets;
import com.incquerylabs.v4md.internal.MagicDrawProjectScope.IProjectChangedListener;

/**
 * Provides a specific engine context implementation for MagicDraw projects.
 * 
 * The implementation is based on EMFEngineContext from VIATRA 2.1.1
 */
class MagicDrawProjectEngineContext implements IEngineContext {

	private final MagicDrawProjectScope scope;
    ViatraQueryEngine engine;
    Logger logger;
    MagicDrawProjectNavigationHelper navHelper;
    IBaseIndex baseIndex;
    IIndexingErrorListener taintListener;
    private EMFQueryRuntimeContext runtimeContext;
    
    private IProjectChangedListener scopeListener = this::modelSetUpdated;
    
	private void modelSetUpdated() {
		Set<Notifier> customNotifiers = scope.getCustomNotifiers().collect(Collectors.toSet());
		Set<Notifier> projectRoots = scope.getProjectModels().collect(Collectors.toSet());
		MagicDrawProjectNavigationHelper navigationHelper = getNavHelper(true);
		Set<Notifier> actualModelRoots = navigationHelper.getModelRoots();
		
		Set<Notifier> rootsToAdd = Sets.difference(projectRoots, actualModelRoots);
		Set<Notifier> rootsToRemove = Sets.difference(Sets.difference(actualModelRoots, projectRoots), customNotifiers);
		
		try {
			navigationHelper.coalesceTraversals(() -> {
				while (!rootsToRemove.isEmpty()) {
					navigationHelper.removeRoot(rootsToRemove.iterator().next());
				}
				while (!rootsToAdd.isEmpty()) {
					navigationHelper.addRoot(rootsToAdd.iterator().next());
				}
			});
		} catch (InvocationTargetException e) {
			logger.fatal("Error while updating project", e);
		}
	}
	
	/**
	 * Customizes the NavigationHelperImpl by adding a new removeRoot method
	 *
	 */
	private class MagicDrawProjectNavigationHelper extends NavigationHelperImpl {

		public MagicDrawProjectNavigationHelper(Notifier emfRoot, BaseIndexOptions options, Logger logger) {
			super(emfRoot, options, logger);
		}
		
		Set<Notifier> getModelRoots() {
			return modelRoots;
		}
		
		public void removeRoot(Notifier root) {
	        if (!((root instanceof EObject) || (root instanceof Resource) || (root instanceof ResourceSet))) {
	            throw new ViatraBaseException(ViatraBaseException.INVALID_EMFROOT);
	        }
	        
	        if (!modelRoots.contains(root))
	            return;

	        if (root instanceof Resource) {
	            IBaseIndexResourceFilter resourceFilter = getBaseIndexOptions().getResourceFilterConfiguration();
	            if (resourceFilter != null && resourceFilter.isResourceFiltered((Resource) root))
	                return;
	        }
	        final IBaseIndexObjectFilter objectFilter = getBaseIndexOptions().getObjectFilterConfiguration();
	        if (objectFilter != null && objectFilter.isFiltered(root))
	            return;

	        // no veto by filters
	        modelRoots.add(root);
	        // TODO contentAdapter.removeAdapter(root); removeAdapter is not visible here
	        Method method;
			try {
				method = contentAdapter.getClass().getMethod("removeAdaper", Notifier.class);
				method.setAccessible(true);
				method.invoke(contentAdapter, root);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				logger.fatal("Error while updating project", e);
			}
	        notifyBaseIndexChangeListeners();
		}
	}
    
    public MagicDrawProjectEngineContext(MagicDrawProjectScope scope, ViatraQueryEngine engine, IIndexingErrorListener taintListener, Logger logger) {
        this.scope = scope;
        this.engine = engine;
        this.logger = logger;
        this.taintListener = taintListener;
        scope.addProjectChangeListener(scopeListener);
    }
    
    /**
     * @throws ViatraQueryRuntimeException thrown if the navigation helper cannot be initialized
     */
    public NavigationHelper getNavHelper() {
        return getNavHelper(true);
    }
    
    private MagicDrawProjectNavigationHelper getNavHelper(boolean ensureInitialized) {
        if (navHelper == null) {
            navHelper = new MagicDrawProjectNavigationHelper(null, this.scope.getOptions(), logger); 
            		

            getBaseIndex().addIndexingErrorListener(taintListener);
            if (ensureInitialized) {
                ensureIndexLoaded();
            }
        }
        return navHelper;
    }

    private void ensureIndexLoaded() {
        for (Notifier scopeRoot : this.scope.getScopeRoots()) {
            navHelper.addRoot(scopeRoot);
        }
    }

    @Override
    public IQueryRuntimeContext getQueryRuntimeContext() {
        NavigationHelper nh = getNavHelper(false);
        if (runtimeContext == null) {
            runtimeContext = 
                    scope.getOptions().isDynamicEMFMode() ?
                     new DynamicEMFQueryRuntimeContext(nh, logger, scope) :
                     new EMFQueryRuntimeContext(nh, logger, scope);
                     
             ensureIndexLoaded();
        }
        
        return runtimeContext;
    }
    
    @Override
    public void dispose() {
        if (runtimeContext != null) runtimeContext.dispose();
        if (navHelper != null) navHelper.dispose();
        
        scope.removeProjectChangeListener(scopeListener);
        
        this.baseIndex = null;
        this.engine = null;
        this.logger = null;
        this.navHelper = null;
    }
    
    
    @Override
    public IBaseIndex getBaseIndex() {
        if (baseIndex == null) {
            final NavigationHelper navigationHelper = getNavHelper();
            baseIndex = new EMFBaseIndexWrapper(navigationHelper);
        }
        return baseIndex;
    }
    
}