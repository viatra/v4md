package com.incquerylabs.v4md.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.base.api.filters.IBaseIndexObjectFilter;
import org.eclipse.viatra.query.runtime.base.api.filters.IBaseIndexResourceFilter;
import org.eclipse.viatra.query.runtime.base.core.NavigationHelperContentAdapter;
import org.eclipse.viatra.query.runtime.base.core.NavigationHelperImpl;
import org.eclipse.viatra.query.runtime.base.exception.ViatraBaseException;

import com.nomagic.uml2.ext.jmi.EventSupport;

/**
 * Customizes the NavigationHelperImpl by adding a new removeRoot method and support for deciding whether an element is already indexed or not
 *
 */
public class MagicDrawProjectNavigationHelper extends NavigationHelperImpl {

	/**
	 * TODO this logger wrapping is a very hacky solution, but until bug
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=549955 is fixed, it is not
	 * possible to overwrite the message any other way
	 */
	private static final class WrappedLogger extends Logger {
		private WrappedLogger(Logger source) {
			super(source.getName());
			parent = source;
			repository = source.getLoggerRepository();
		}

		@Override
		public void error(Object message) {
			if (message instanceof String && ((String)message).contains("This indicates some errors in underlying model representation.")) {
				super.debug(message);
			} else {
				super.error(message);
			}
		}
	}

	private Logger logger;

	public MagicDrawProjectNavigationHelper(Notifier emfRoot, BaseIndexOptions options, EventSupport eventSupport, Logger logger) {
		super(emfRoot, options, new WrappedLogger(logger));
		this.logger = logger;
		// TODO While this change helps avoiding some duplicate notifications, it causes
		// a regression when adding a new project usage to a local project: when the
		// usage is added, event firing is turned off, resulting in the added profile
		// not available in the index of the project
//		this.contentAdapter = new NavigationHelperContentAdapter(this) {
//			
//			@Override
//			public void notifyChanged(Notification notification) {
//				if (eventSupport.isEnableEventFiring()) {
//					super.notifyChanged(notification);
//				}
//			}
//			
//		};
	}
	
	Set<Notifier> getModelRoots() {
		return modelRoots;
	}
	
	public boolean isIndexed(EObject element) {
		return EcoreUtil.isAncestor(modelRoots, element);
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
        modelRoots.remove(root);
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