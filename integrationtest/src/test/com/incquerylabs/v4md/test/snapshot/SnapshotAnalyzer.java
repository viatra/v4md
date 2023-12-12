package com.incquerylabs.v4md.test.snapshot;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.api.IQueryGroup;
import org.eclipse.viatra.query.testing.core.InitializedSnapshotMatchSetModelProvider;
import org.eclipse.viatra.query.testing.core.SnapshotHelper;
import org.eclipse.viatra.query.testing.core.ViatraQueryTestCase;
import org.eclipse.viatra.query.testing.snapshot.QuerySnapshot;
import org.eclipse.viatra.query.testing.snapshot.SnapshotPackage;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.incquerylabs.v4md.test.provider.V4MDPatternBasedMatchSetProvider;
import com.incquerylabs.v4md.test.queries.Non_Unique_Names;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.tests.common.TestEnvironment;

import org.junit.Assert;

public class SnapshotAnalyzer implements ISnapshotManager {
	
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
	
	private ViatraQueryTestCase createTestCaseForSnapshot(Project project, String snapshotName) throws IOException {
		QuerySnapshot snapshot = getSnapshotResource(project, snapshotName + ".snapshot");
		ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);	
		SnapshotHelper snapshotHelper = new TestSnapshotHelperFactory().createSnapshotHelper();
		ViatraQueryTestCase vqtc = new ViatraQueryTestCase(snapshotHelper);
		vqtc.addMatchSetModelProvider(new V4MDPatternBasedMatchSetProvider(adapter, snapshotHelper));
		vqtc.addMatchSetModelProvider(new InitializedSnapshotMatchSetModelProvider(snapshot));
		return vqtc;
	}

	@Override
	public void assertQueryResult(Project project, IQueryGroup queryGroup, String snapshotFileName) {
		ViatraQueryTestCase vqtc = null;
		try {
			vqtc = createTestCaseForSnapshot(project, snapshotFileName);
			vqtc.assertMatchSetsEqual(queryGroup);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		} finally {
			if(vqtc != null) {
				vqtc.dispose();
			}
		}
	}

}
