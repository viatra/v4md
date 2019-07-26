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
import com.incquerylabs.v4md.test.runner.TestRunner;
import com.incquerylabs.v4md.test.snapshot.ISnapshotManager;
import com.incquerylabs.v4md.test.snapshot.SnapshotAnalyzer;
import com.incquerylabs.v4md.test.snapshot.SnapshotCreator;
import com.nomagic.ci.persistence.local.proxy.SnapshotManager;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.tests.MagicDrawTestCase;
import com.nomagic.magicdraw.tests.common.TestEnvironment;

public class QueryTests extends MagicDrawTestCase {
			
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
	
	@Override
	protected void tearDownTest() throws Exception {
		closeAllProjects();
		super.tearDownTest();
	}
	
	public void testNonUniqueNames() throws IOException {
		TestRunner.snapshotManager.assertQueryResult(project, Non_Unique_Names.instance(), "Non_Unique_Names");
	}
	
	public void testAggragatorFunctions() throws IOException{
		TestRunner.snapshotManager.assertQueryResult(project, Aggregator_Functions.instance(), "Aggregator_Functions");
	}
	
	public void testBlockWithMoreThanOneParent() throws IOException {
		TestRunner.snapshotManager.assertQueryResult(project, Block_With_More_than_1_Parent.instance(), "Block_With_More_than_1_Parent");
	}
	
	public void testCheckExpression() throws IOException {
		TestRunner.snapshotManager.assertQueryResult(project, Check_Expression.instance(), "Check_Expression");
	}
	
	public void testCircularDependency() throws IOException {
		TestRunner.snapshotManager.assertQueryResult(project, Circular_Dependency.instance(), "Circular_Dependency");
	}
	
	public void testPatternConstraints() throws IOException {
		TestRunner.snapshotManager.assertQueryResult(project, Pattern_Constraints.instance(), "Pattern_Constraints");
	}
	
	public void testPortConnections() throws IOException {
		TestRunner.snapshotManager.assertQueryResult(project, Port_Connections.instance(), "Port_Connections");
	}
	
	public void testRequirementRealization() throws IOException {
		TestRunner.snapshotManager.assertQueryResult(project, Requirement_Realization.instance(), "Requirement_Realization");
	}
	
	public void testSubpatternCalls() throws IOException {
		TestRunner.snapshotManager.assertQueryResult(project, Subpattern_Calls.instance(), "Subpattern_Calls");
	}
	
	public void testTransitiveClosure() throws IOException {
		TestRunner.snapshotManager.assertQueryResult(project, Transitive_Closure.instance(), "Transitive_Closure");
	}
	
	public void testUnreachableStates() throws IOException {
		TestRunner.snapshotManager.assertQueryResult(project, Unreachable_States.instance(), "Unreachable_States");
	}
	
}
