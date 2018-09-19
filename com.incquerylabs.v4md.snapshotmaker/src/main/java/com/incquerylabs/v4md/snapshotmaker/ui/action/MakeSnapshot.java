package com.incquerylabs.v4md.snapshotmaker.ui.action;

import java.awt.event.ActionEvent;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.testing.core.SnapshotHelper;
import org.eclipse.viatra.query.testing.snapshot.InputSpecification;
import org.eclipse.viatra.query.testing.snapshot.QuerySnapshot;
import org.eclipse.viatra.query.testing.snapshot.SnapshotFactory;
import org.eclipse.viatra.query.testing.snapshot.InputSpecification;

import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.incquerylabs.v4md.snapshotmaker.registry.QueryRegistry;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;

public class MakeSnapshot extends MDAction{

	static final long serialVersionUID = 1L;

	public MakeSnapshot(String id, String name) {
		super(id, name, null, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		
		Project project = Application.getInstance().getProject();
		
		ViatraQueryEngine engine = ViatraQueryAdapter.getOrCreateAdapter(project).getEngine();
		
		QueryRegistry.getQueries().forEach( spec -> {

			QuerySnapshot snapshot = SnapshotFactory.eINSTANCE.createQuerySnapshot();
			snapshot.setInputSpecification(InputSpecification.RESOURCE_SET);
			
			
			
			
		});
		
	}

}
