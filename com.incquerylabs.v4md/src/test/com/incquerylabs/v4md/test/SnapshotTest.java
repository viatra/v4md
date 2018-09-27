package com.incquerylabs.v4md.test;

import java.io.IOException;

import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.rete.matcher.ReteBackendFactory;
import org.eclipse.viatra.query.testing.core.api.ViatraQueryTest;
import org.eclipse.viatra.query.testing.snapshot.QuerySnapshot;

import com.incquerylabs.v4md.test.base.TestWithQueryTest;
import com.incquerylabs.v4md.test.queries.ComponentsWithName;

public class SnapshotTest extends TestWithQueryTest {
		
	public SnapshotTest() {
		projectToUse = "SimpleUML.mdzip";
	}
	
	
	public void testModuleNames() throws IOException {
			
			QuerySnapshot snapshot = getSnapshotResource(project, "ComponentsWithName.snapshot");
			EMFScope scope = getScopeForProject(project);
			
			
			ViatraQueryTest.test(ComponentsWithName.instance())
			.on(scope)
			.with(snapshot)
			.with(ReteBackendFactory.INSTANCE).assertEquals();
	}
	
	

}
