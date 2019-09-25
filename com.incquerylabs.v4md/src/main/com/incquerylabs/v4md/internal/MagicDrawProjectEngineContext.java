package com.incquerylabs.v4md.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.viatra.query.runtime.api.scope.IBaseIndex;
import org.eclipse.viatra.query.runtime.api.scope.IEngineContext;
import org.eclipse.viatra.query.runtime.api.scope.IIndexingErrorListener;
import org.eclipse.viatra.query.runtime.base.api.NavigationHelper;
import org.eclipse.viatra.query.runtime.emf.DynamicEMFQueryRuntimeContext;
import org.eclipse.viatra.query.runtime.emf.EMFBaseIndexWrapper;
import org.eclipse.viatra.query.runtime.emf.EMFQueryRuntimeContext;
import org.eclipse.viatra.query.runtime.matchers.ViatraQueryRuntimeException;
import org.eclipse.viatra.query.runtime.matchers.context.IQueryRuntimeContext;

/**
 * Provides a specific engine context implementation for MagicDraw projects.
 * 
 * The implementation is based on EMFEngineContext from VIATRA 2.1.1
 */
class MagicDrawProjectEngineContext implements IEngineContext {

	private final MagicDrawProjectScope scope;
	private final boolean enableProfiler;
    private Logger logger;
    private MagicDrawProjectNavigationHelper navHelper;
    private IBaseIndex baseIndex;
    private IIndexingErrorListener taintListener;
    private EMFQueryRuntimeContext runtimeContext;
    
    private IProjectChangedListener scopeListener = this::modelSetUpdated;
    
	private void modelSetUpdated() {
		Set<Notifier> customNotifiers = scope.getCustomNotifiers().collect(Collectors.toSet());
		Set<Notifier> projectRoots = scope.getProjectModels().collect(Collectors.toSet());
		MagicDrawProjectNavigationHelper navigationHelper = getNavHelper(true);
		Set<Notifier> actualModelRoots = navigationHelper.getModelRoots().collect(Collectors.toSet());
		
		Set<Notifier> rootsToAdd = new HashSet<>(projectRoots);
		rootsToAdd.removeAll(actualModelRoots);
		Set<Notifier> rootsToRemove = new HashSet<>(actualModelRoots);
		rootsToRemove.removeAll(projectRoots);
		rootsToRemove.removeAll(customNotifiers);
		
		try {
			navigationHelper.coalesceTraversals(() -> {
				rootsToRemove.forEach(navigationHelper::removeRoot);
				rootsToAdd.forEach(navigationHelper::addRoot);
			});
		} catch (InvocationTargetException e) {
			logger.fatal("Error while updating project", e);
		}
	}
	
	public MagicDrawProjectEngineContext(MagicDrawProjectScope scope, IIndexingErrorListener taintListener, boolean enableProfiler, Logger logger) {
        this.scope = scope;
		this.enableProfiler = enableProfiler;
        this.logger = logger;
        this.taintListener = taintListener;
        IProjectChangedListener.MANAGER.addProjectChangeListener(scope.getProject(), scopeListener);
    }
    
    /**
     * @throws ViatraQueryRuntimeException thrown if the navigation helper cannot be initialized
     */
    public NavigationHelper getNavHelper() {
        return getNavHelper(true);
    }
    
    private MagicDrawProjectNavigationHelper getNavHelper(boolean ensureInitialized) {
        if (navHelper == null) {
            navHelper = enableProfiler
            		? new ProfilingMagicDrawProjectNavigationHelper(null, this.scope.getOptions(), scope.getProject().getRepository().getEventSupport(), logger)
            		: new MagicDrawProjectNavigationHelper(null, this.scope.getOptions(), scope.getProject().getRepository().getEventSupport(), logger); 
            		

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
        
        IProjectChangedListener.MANAGER.removeProjectChangeListener(scope.getProject(), scopeListener);
        
        this.baseIndex = null;
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