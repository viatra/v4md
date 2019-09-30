package com.incquerylabs.v4md.internal;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.base.core.NavigationHelperContentAdapter;

import com.nomagic.uml2.ext.jmi.EventSupport;

public class ProfilingMagicDrawProjectNavigationHelper extends MagicDrawProjectNavigationHelper {

	public class StopWatch {

		private long currentStartTime = 0;
		private long totalElapsedTime = 0;
		private boolean running = true;

		/**
		 * Puts the timer in running state and saves the current time.
		 */
		public void start() {
			currentStartTime = System.currentTimeMillis();
			running = true;

		}

		/**
		 * Puts the the timer in stopped state and saves the total time spent in started
		 * state between the last reset and now
		 */
		public void stop() {
			totalElapsedTime = getTotalElapsedTime();
			running = false;
		}

		/**
		 * @return time between the last start and now
		 */
		public long getCurrentElapsedTime() {
			return System.currentTimeMillis() - currentStartTime;
		}

		/**
		 * @return the total time spent in started state between the last reset and now
		 */
		public long getTotalElapsedTime() {
			return isRunning() ? getCurrentElapsedTime() + totalElapsedTime : totalElapsedTime;
		}
		
		/**
		 * Saves the current time and resets all the time spent between the last reset and now.
		 */
		public void resetTime() {
			currentStartTime = System.currentTimeMillis();
			totalElapsedTime = 0;
		}
		
		/**
		 * @return internal state of the timer.
		 * 
		 * false: stopped
		 * true: running
		 */
		public boolean isRunning() {
			return running;
		}

	}

	long notificationCount;
	StopWatch watch;
	boolean isEnabled = false;

	public ProfilingMagicDrawProjectNavigationHelper(Notifier emfRoot, BaseIndexOptions options,
			EventSupport eventSupport, Logger logger) {
		super(emfRoot, options, eventSupport, logger);
		resetMeasurement();
		// In general it might be too late to replace the content adapter here, but in
		// case V4MD nothing was indexed at this point
		// TODO replace this when a VIATRA version that fixes bug
		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=547205 is available
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
		return watch.getTotalElapsedTime();
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
