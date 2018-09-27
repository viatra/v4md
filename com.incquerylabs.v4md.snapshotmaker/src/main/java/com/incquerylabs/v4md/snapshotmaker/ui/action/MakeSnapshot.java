package com.incquerylabs.v4md.snapshotmaker.ui.action;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.viatra.query.runtime.api.IQueryGroup;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.query.testing.core.SnapshotHelper;
import org.eclipse.viatra.query.testing.snapshot.QuerySnapshot;
import org.eclipse.viatra.query.testing.snapshot.SnapshotFactory;

import com.google.common.collect.Sets;
import com.incquerylabs.v4md.ViatraQueryAdapter;
import com.incquerylabs.v4md.snapshotmaker.QueryGroups;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;

public class MakeSnapshot extends MDAction{

	static final long serialVersionUID = 1L;
	
	private Set<IQuerySpecification<?>> specsToSave = Sets.newHashSet();
	private Set<IQueryGroup> groupsToSave = Sets.newHashSet();
	
	static String installroot = "";
	static final String SNAPSHOT_FOLDER = "query_snapshots";
	
	public MakeSnapshot(String id, String name) {
		super(id, name, null, null);
		installroot = Application.environment().getInstallRoot();
		
		groupsToSave.addAll(QueryGroups.groups());
		
	}
	
	private void createAndSaveSnapshot(ViatraQueryEngine engine, IQuerySpecification<?> spec) throws IOException{
	
		SnapshotHelper helper = new SnapshotHelper();
		QuerySnapshot snap = SnapshotFactory.eINSTANCE.createQuerySnapshot();

		helper.saveMatchesToSnapshot((ViatraQueryMatcher)engine.getMatcher(spec), snap);
		 ResourceSet resourceSet = new ResourceSetImpl();
		 Resource resource = resourceSet.createResource(URI.createFileURI(new File(installroot + "\\" + SNAPSHOT_FOLDER +"\\" + spec.getSimpleName()+".snapshot").getAbsolutePath()));
		 resource.getContents().add(snap);
		 
		 resource.save(null);
			
	}
	
	private void createAndSaveSnapshot(ViatraQueryEngine engine, IQueryGroup group) throws IOException {
		SnapshotHelper helper = new SnapshotHelper();
		QuerySnapshot snap = SnapshotFactory.eINSTANCE.createQuerySnapshot();
		
		group.getSpecifications().forEach( spec -> helper.saveMatchesToSnapshot((ViatraQueryMatcher)engine.getMatcher(spec), snap));
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createFileURI(new File(installroot + "\\" + SNAPSHOT_FOLDER +"\\groups\\" + group.getClass().getSimpleName()+".snapshot").getAbsolutePath()));
		resource.getContents().add(snap);
		 
		 resource.save(null);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		Project project = Application.getInstance().getProject();
		ViatraQueryEngine engine = ViatraQueryAdapter.getOrCreateAdapter(project).getEngine();	
		
		try {
			for (IQuerySpecification<?> spec: specsToSave) {
				createAndSaveSnapshot(engine, spec);
			}
			
			for (IQueryGroup g: groupsToSave) {
				createAndSaveSnapshot(engine, g);
			}
			
			Application.getInstance().getGUILog().showMessage("Snapshots successfully created and saved to: " + installroot + "\\" + SNAPSHOT_FOLDER);

		} catch (IOException e) {
			Application.getInstance().getGUILog().showError(e.getMessage());
		}
	}

}
