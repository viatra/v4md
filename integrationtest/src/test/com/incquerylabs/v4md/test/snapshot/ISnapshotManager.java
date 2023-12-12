package com.incquerylabs.v4md.test.snapshot;

import org.eclipse.viatra.query.runtime.api.IQueryGroup;

import com.nomagic.magicdraw.core.Project;

public interface ISnapshotManager {
	final static String snapshotLibrary = "snapshots/";
	
	void assertQueryResult(Project project, IQueryGroup queryGroup, String snapshotFileName);
}
