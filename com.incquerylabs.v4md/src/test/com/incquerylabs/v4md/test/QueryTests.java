package com.incquerylabs.v4md.test;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.testing.core.InitializedSnapshotMatchSetModelProvider;
import org.eclipse.viatra.query.testing.core.ViatraQueryTestCase;
import org.eclipse.viatra.query.testing.snapshot.QuerySnapshot;
import org.eclipse.viatra.query.testing.snapshot.SnapshotPackage;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.incquerylabs.v4md.test.provider.V4MDPatternBasedMatchSetProvider;
import com.incquerylabs.v4md.test.queries.Aggregator_Functions;
import com.incquerylabs.v4md.test.queries.Block_With_More_than_1_Parent;
import com.incquerylabs.v4md.test.queries.Check_Expression;
import com.incquerylabs.v4md.test.queries.Circular_Dependency;
import com.incquerylabs.v4md.test.queries.Non_Unique_Names;
import com.incquerylabs.v4md.test.queries.Pattern_Constraints;
import com.incquerylabs.v4md.test.queries.Port_Connections;
import com.incquerylabs.v4md.test.queries.Requirement_Realization;
import com.incquerylabs.v4md.test.queries.Subpattern_Calls;
import com.incquerylabs.v4md.test.queries.Transitive_Closure;
import com.incquerylabs.v4md.test.queries.Unreachable_States;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.tests.MagicDrawTestCase;
import com.nomagic.magicdraw.tests.common.TestEnvironment;

public class QueryTests extends MagicDrawTestCase {
			
	protected static String snapshotLibrary = "snapshots/";
	protected  Project project;
	protected static String projectToUse = "CustomQueryAndValidationExample.mdzip";

	public QueryTests() {}

	
	@Override
    protected void setUpTest() throws Exception
    {
		project = loadProject(new File(TestEnvironment.getResourceDir(), projectToUse).getAbsolutePath());
		setSkipMemoryTest(true);
        super.setUpTest();
     }
	

	protected EMFScope getScopeForProject(Project project) {
		ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
		AdvancedViatraQueryEngine engine = adapter.getEngine();
		//V4MD uses EMFScope instances
	
		return (EMFScope) engine.getScope();
	}
	
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
	
	protected ViatraQueryTestCase createTestCaseForSnapshot(String snapshotName) throws IOException {
		QuerySnapshot snapshot = getSnapshotResource(project, snapshotName + ".snapshot");
		ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);	
		ViatraQueryTestCase vqtc = new ViatraQueryTestCase();
		vqtc.addMatchSetModelProvider(new V4MDPatternBasedMatchSetProvider(adapter));
		vqtc.addMatchSetModelProvider(new InitializedSnapshotMatchSetModelProvider(snapshot));
		return vqtc;
	}
	
	
	public void testNonUniqueNames() throws IOException {
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Non_Unique_Names");
		vqtc.assertMatchSetsEqual(Non_Unique_Names.instance());
		vqtc.dispose();
	}
	
	public void testAggragatorFunctions() throws IOException{
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Aggregator_Functions");
		vqtc.assertMatchSetsEqual(Aggregator_Functions.instance());
		vqtc.dispose();
	}
	
	public void testBlockWithMoreThanOneParent() throws IOException {
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Block_With_More_than_1_Parent");
		vqtc.assertMatchSetsEqual(Block_With_More_than_1_Parent.instance());
		vqtc.dispose();
	}
	
	public void testCheckExpression() throws IOException {
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Check_Expression");
		vqtc.assertMatchSetsEqual(Check_Expression.instance());
		vqtc.dispose();
	}
	
	public void testCircularDependency() throws IOException {
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Circular_Dependency");
		vqtc.assertMatchSetsEqual(Circular_Dependency.instance());
		vqtc.dispose();
	}
	
	public void testPatternConstraints() throws IOException {
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Pattern_Constraints");
		vqtc.assertMatchSetsEqual(Pattern_Constraints.instance());
		vqtc.dispose();
	}
	
	public void testPortConnections() throws IOException {
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Port_Connections");
		vqtc.assertMatchSetsEqual(Port_Connections.instance());
		vqtc.dispose();
	}
	
	public void testRequirementRealization() throws IOException {
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Requirement_Realization");
		vqtc.assertMatchSetsEqual(Requirement_Realization.instance());
		vqtc.dispose();
	}
	
	public void testSubpatternCalls() throws IOException {
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Subpattern_Calls");
		vqtc.assertMatchSetsEqual(Subpattern_Calls.instance());
		vqtc.dispose();
	}
	
	public void testTransitiveClosure() throws IOException {
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Transitive_Closure");
		vqtc.assertMatchSetsEqual(Transitive_Closure.instance());
		vqtc.dispose();
	}
	
	public void testUnreachableStates() throws IOException {
		ViatraQueryTestCase vqtc = createTestCaseForSnapshot("Unreachable_States");
		vqtc.assertMatchSetsEqual(Unreachable_States.instance());
		vqtc.dispose();
	}
	
}
