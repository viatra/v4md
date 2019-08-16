package org.eclipse.viatra.query.runtime.base.core;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.viatra.query.runtime.base.core.NavigationHelperContentAdapter;
import org.eclipse.viatra.query.runtime.base.core.NavigationHelperImpl;

/*
 * TODO this is a temporary workaround about visibilities in VIATRA
 */
public final class V4MDNavigationHelperContentAdapter extends NavigationHelperContentAdapter {
	public V4MDNavigationHelperContentAdapter(NavigationHelperImpl navigationHelper) {
		super(navigationHelper);
	}

	@Override
	protected void removeAdapter(Notifier notifier) {
		if (notifier.eAdapters().contains(this)) {
			super.removeAdapter(notifier);
		}
	}

	@Override
	void removeAdapter(Notifier notifier, boolean additionalObjectContainerPossible,
			boolean additionalResourceContainerPossible) {
		if (notifier.eAdapters().contains(this)) {
			super.removeAdapter(notifier, additionalObjectContainerPossible, additionalResourceContainerPossible);
		}
	}
	
	
}