package com.incquerylabs.v4md.internal;

import com.google.common.collect.ArrayListMultimap;
import com.nomagic.magicdraw.core.Project;

public interface IProjectChangedListener {
	void modelSetUpdated();
	
	public static final Manager MANAGER = new Manager();
	
	public class Manager {
		ArrayListMultimap<Project, IProjectChangedListener> listenerMap = ArrayListMultimap.create();
		
		
		private Manager() {
			// Private constructor for singleton class
		}

		public void notifyProjectListeners(Project project) {
			for (IProjectChangedListener listener : listenerMap.get(project)) {
				listener.modelSetUpdated();
			}
		}
		
		public boolean addProjectChangeListener(Project project, IProjectChangedListener listener) {
			return listenerMap.put(project, listener);
		}
		
		public boolean removeProjectChangeListener(Project project, IProjectChangedListener listener) {
			return listenerMap.remove(project, listener);
		}
	}
}