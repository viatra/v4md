package com.incquerylabs.v4md.test.base;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.testing.snapshot.QuerySnapshot;
import org.eclipse.viatra.query.testing.snapshot.SnapshotPackage;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.tests.MagicDrawTestCase;
import com.nomagic.magicdraw.tests.common.TestEnvironment;

public abstract class TestWithQueryTest extends MagicDrawTestCase{
	
	protected static String snapshotLibrary = "snapshots/";
	protected Project project;
	protected String projectToUse;
	
	@Override
    protected void setUpTest() throws Exception
    {
        super.setUpTest();
        //do setup here
        project = loadProject(new File(TestEnvironment.getResourceDir(), projectToUse).getAbsolutePath());
        
    }
	
	protected EMFScope getScopeForProject(Project project) {
		ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
		AdvancedViatraQueryEngine engine = adapter.getEngine();
		//V4MD uses EMFScope instances
		return (EMFScope) engine.getScope();
	}
	/**
	 * 
	 * @param project that the snapshot was made with
	 * @param snapshotToUse name of the snapshot file
	 * @return loaded snapshot instance
	 * @throws IOException
	 */
	protected QuerySnapshot getSnapshotResource(Project project, String snapshotToUse) throws IOException {
		//initialize SnapshotPackage
		SnapshotPackage.eINSTANCE.getNsURI();
		String snapshotPath =  new File(TestEnvironment.getResourceDir(), snapshotLibrary + snapshotToUse).getCanonicalPath();
		URI uri = URI.createFileURI(snapshotPath);
		ResourceSet rs = project.getModel().eResource().getResourceSet();
		Resource r = rs.createResource(uri);
		r.load(null);
		
		return (QuerySnapshot) r.getContents().get(0);
	}
	
	@Override
	protected void tearDownTest() throws Exception {
		closeAllProjects();
		super.tearDownTest();
	}
}
