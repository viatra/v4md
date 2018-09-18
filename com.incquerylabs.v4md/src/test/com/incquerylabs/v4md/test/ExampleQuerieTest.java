package com.incquerylabs.v4md.test;

import java.io.File;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.incquerylabs.v4md.test.queries.BlockNamedDummy;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.tests.MagicDrawTestCase;
import com.nomagic.magicdraw.tests.common.TestEnvironment;

public class ExampleQuerieTest extends MagicDrawTestCase{

	private Project project;
	
	@Override
	protected void setUpTest() throws Exception {
		super.setUpTest();
		setSkipMemoryTest(true);
		
		File file = new File(TestEnvironment.getResourceDir(),"TestProject.mdzip");
		project = MagicDrawTestCase.loadProject(file.getAbsolutePath());
	}
	
	public void testOneDummyBlock() {
		ViatraQueryEngine engine = ViatraQueryAdapter.getOrCreateAdapter(project).getEngine();
		int size = BlockNamedDummy.instance().getMatcher(engine).countMatches();
		assertEquals(1, size);
	}
	
	public void testFailOneDummyBlock() {
		ViatraQueryEngine engine = ViatraQueryAdapter.getOrCreateAdapter(project).getEngine();
		BlockNamedDummy.instance().getMatcher(engine).getAllMatches().forEach( m -> {
			String name = m.getValueOfClass().getHumanName();
			assertEquals("NotDummy", name);
		}
			
		);
	}
	
	@Override
	protected void tearDownTest() throws Exception {
		super.tearDownTest();
		setSkipMemoryTest(true);
		
		closeAllProjects();
		project = null;
	}
}
 