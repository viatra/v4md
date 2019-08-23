package com.incquerylabs.v4md.internal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.base.core.NavigationHelperImpl;

import com.nomagic.uml2.ext.jmi.EventSupport;

/**
 * Customizes the NavigationHelperImpl by adding a new removeRoot method and support for deciding whether an element is already indexed or not
 *
 */
public class MagicDrawProjectNavigationHelper extends NavigationHelperImpl {

	public MagicDrawProjectNavigationHelper(Notifier emfRoot, BaseIndexOptions options, EventSupport eventSupport, Logger logger) {
		super(emfRoot, options, logger);
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
	
	public boolean isIndexed(EObject element) {
		return EcoreUtil.isAncestor(getModelRoots().collect(Collectors.toSet()), element);
	}
	
	@Override
	public Stream<Notifier> getModelRoots() {
		// Override is used to update visibility
		return super.getModelRoots();
	}

	@Override
	public void removeRoot(Notifier root) {
        // Override is used to update visibility
		super.removeRoot(root);
	}

	@Override
	protected void logIncidentAdapterRemoval(Notifier notifier) {
		// Do not report such cases in MagicDraw
	}

	@Override
	protected void logIncidentFeatureTupleInsertion(Object value, EObject holder, Object featureKey) {
		// Do not report such cases in MagicDraw
	}

	@Override
	protected void logIncidentFeatureTupleRemoval(Object value, EObject holder, Object featureKey) {
		// Do not report such cases in MagicDraw
	}

	@Override
	protected void logIncidentInstanceInsertion(Object keyClass, EObject value) {
		// Do not report such cases in MagicDraw
	}

	@Override
	protected void logIncidentInstanceRemoval(Object keyClass, EObject value) {
		// Do not report such cases in MagicDraw
	}

	@Override
	protected void logIncidentStatRemoval(Object key) {
		// Do not report such cases in MagicDraw
	}
	
}