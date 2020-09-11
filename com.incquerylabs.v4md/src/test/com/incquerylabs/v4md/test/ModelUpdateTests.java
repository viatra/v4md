package com.incquerylabs.v4md.test;

import java.io.File;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import org.eclipse.viatra.query.testing.core.TestingSeverityAggregatorLogAppender;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.incquerylabs.v4md.test.queries.PortConnections;
import com.incquerylabs.v4md.test.queries.PortConnections.Matcher;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.magicdraw.tests.MagicDrawTestCase;
import com.nomagic.magicdraw.tests.common.TestEnvironment;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector;

public class ModelUpdateTests extends MagicDrawTestCase {
			
	protected  Project project;
	protected static String projectToUse = "ConnectorRemoveTest.mdzip";

	@Before
    protected void setUpTest() throws Exception
    {
		project = loadProject(new File(TestEnvironment.getResourceDir(), projectToUse).getAbsolutePath());
		setSkipMemoryTest(true);
        super.setUpTest();
     }

	@After
	protected void tearDownTest() throws Exception {
		closeAllProjects();
		super.tearDownTest();
	}
	
	public void testListener() {
		ViatraQueryAdapter adapter = ViatraQueryAdapter.getOrCreateAdapter(project);
		Appender appender = ViatraQueryLoggingUtil.getLogger(ViatraQueryEngine.class).getAppender(this.getClass().getName());
		TestingSeverityAggregatorLogAppender testAppender;
		if (appender instanceof TestingSeverityAggregatorLogAppender) {
			testAppender = (TestingSeverityAggregatorLogAppender) appender;
			testAppender.clear();
		} else {
			testAppender = new TestingSeverityAggregatorLogAppender();
			testAppender.setName(this.getClass().getName());
			ViatraQueryLoggingUtil.getLogger(ViatraQueryEngine.class).addAppender(testAppender);
		}
		
		Matcher matcher = PortConnections.Matcher.on(adapter.getInitializedEngineChecked());
		
		matcher.countMatches();
				
		final Connector connector = (Connector) project.getElementByID("_19_0_1_c0402f4_1551707958244_224488_42396");
		SessionManager.getInstance().executeInsideSession(project, "Modification", connector::dispose);
		
		Assert.assertTrue(testAppender.getSeverity().toInt() < Level.ERROR_INT);
	}
	
}
