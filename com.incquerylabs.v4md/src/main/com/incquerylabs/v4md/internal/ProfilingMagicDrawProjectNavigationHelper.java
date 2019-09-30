package com.incquerylabs.v4md.internal;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.base.core.NavigationHelperContentAdapter;

import com.nomagic.uml2.ext.jmi.EventSupport;

public class ProfilingMagicDrawProjectNavigationHelper extends MagicDrawProjectNavigationHelper {

	public class StopWatch {
		
		long startedAt = 0;
		long stoppedElapsed = 0;
		boolean running = true;

		public void start() {
			startedAt = System.currentTimeMillis();
			running = true;
			
		}

		public void stop() {
			stoppedElapsed = getElapsed();
			running = false;
		}

		public long getElapsed() {
			return running ? System.currentTimeMillis() - startedAt + stoppedElapsed : stoppedElapsed;
		}
	

		public void resetTime() {
			startedAt = System.currentTimeMillis();
			stoppedElapsed = 0;
		}
		
	}
	
	long notificationCount;
	StopWatch watch;
	boolean isEnabled = false;
	
	public ProfilingMagicDrawProjectNavigationHelper(Notifier emfRoot, BaseIndexOptions options,
			EventSupport eventSupport, Logger logger) {
		super(emfRoot, options, eventSupport, logger);
		resetMeasurement();
		// In general it might be too late to replace the content adapter here, but in case V4MD nothing was indexed at this point
		// TODO replace this when a VIATRA version that fixes bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=547205 is available
		this.contentAdapter = new NavigationHelperContentAdapter(this) {

			boolean measurement = false;
			
			@Override
			public void notifyChanged(Notification notification) {
				// Handle possibility of reentrancy
				if (isEnabled && !measurement) {
					try {
						measurement = true;
						notificationCount++;
						watch.start();
						super.notifyChanged(notification);
					} finally {
						watch.stop();
						measurement = false;
					}
				} else {
					super.notifyChanged(notification);
				}
			}

			@Override
			public void setTarget(Notifier target) {
				// Handle possibility of reentrancy
				if (isEnabled && !measurement) {
					try {
						measurement = true;
						notificationCount++;
						watch.start();
						super.setTarget(target);
					} finally {
						watch.stop();
						measurement = false;
					}
				} else {
					super.setTarget(target);
				}
			}

			@Override
			public void unsetTarget(Notifier target) {
				// Handle possibility of reentrancy
				if (isEnabled && !measurement) {
					try {
						measurement = true;
						notificationCount++;
						watch.start();
						super.unsetTarget(target);
					} finally {
						watch.stop();
						measurement = false;
					}
				} else {
					super.unsetTarget(target);
				}
			}
			
		};
	}

	public long getNotificationCount() {
		return notificationCount;
	}

	public long getTotalMeasuredTimeInMS() {
		return watch.getElapsed();
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	public void resetMeasurement() {
		notificationCount = 0;
		watch.resetTime();
	}
}
