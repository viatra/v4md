package com.incquerylabs.v4md.test.snapshot;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.IQueryGroup;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.query.testing.core.SnapshotHelper;
import org.eclipse.viatra.query.testing.snapshot.QuerySnapshot;
import org.eclipse.viatra.query.testing.snapshot.SnapshotFactory;
import org.junit.Assert;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.tests.common.TestEnvironment;

public class SnapshotCreator implements ISnapshotManager {
	
	private void createAndSaveSnapshot(ViatraQueryEngine engine, IQueryGroup group,  String snapshotName) throws IOException {
		SnapshotHelper helper = new TestSnapshotHelperFactory().createSnapshotHelper();
		QuerySnapshot snap = SnapshotFactory.eINSTANCE.createQuerySnapshot();
		
		group.getSpecifications().forEach( spec -> helper.saveMatchesToSnapshot((ViatraQueryMatcher)engine.getMatcher(spec), snap));
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI(new File(TestEnvironment.getResourceDir(), snapshotLibrary + snapshotName +".snapshot").getAbsolutePath()));
		resource.getContents().add(snap);
		 
		resource.save(null);
	}

	@Override
	public void assertQueryResult(Project project, IQueryGroup queryGroup, String snapshotFileName) {
		try {
			ViatraQueryEngine engine = ViatraQueryAdapter.getOrCreateAdapter(project).getEngine();	
			createAndSaveSnapshot(engine, queryGroup, snapshotFileName);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		} 
	}

}
