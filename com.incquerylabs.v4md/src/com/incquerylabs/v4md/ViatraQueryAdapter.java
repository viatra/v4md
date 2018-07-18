package com.incquerylabs.v4md;

import java.util.Optional;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.google.common.collect.Sets;
import com.nomagic.magicdraw.core.Project;

public class ViatraQueryAdapter extends AdapterImpl{
	
	private AdvancedViatraQueryEngine engine;
	private Project project;
	


	private ViatraQueryAdapter(AdvancedViatraQueryEngine engine, Project project) {
		this.engine = engine;
		this.project = project;
	}
	
	public AdvancedViatraQueryEngine getEngine() {
		return engine;
	}
	
	public void dispose(){
		engine.dispose();
		project.getPrimaryModel().eAdapters().remove(this);
	}
	
	public void wipeEngine(){
		engine.wipe();
	}
	
	public static Optional<ViatraQueryAdapter> getAdapter(Project project) {
		return project.getPrimaryModel().eAdapters().stream().filter(ViatraQueryAdapter.class::isInstance)
				.map(ViatraQueryAdapter.class::cast).findAny();
	}
	
	public static ViatraQueryAdapter getOrCreateAdapter(Project project) {
		return getAdapter(project).orElseGet(() -> {
					ViatraQueryAdapter adapter = null;
					adapter = new ViatraQueryAdapter(createQueryEngine(project), project);
					project.getPrimaryModel().eAdapters().add(adapter);
					return adapter;
				});
		
	}
	
	public static void disposeAdapter(Project project) {
		getAdapter(project).ifPresent(ViatraQueryAdapter::dispose);
		
	}

	
	private static AdvancedViatraQueryEngine createQueryEngine(Project project) throws ViatraQueryException {
		// XXX Omitting references can cause semantic errors (so far we are in the clear though)
		// these references are only present in UML profiles, typically their contents are equal to the original references inherited from the UML type hierarchy, however there are some cases when this might not be the case.
		BaseIndexOptions options = new BaseIndexOptions()
				.withFeatureFilterConfiguration(reference -> reference instanceof EReference
						&& ((EReference) reference).isContainment() && reference.getName().contains("_from_"))
				.withStrictNotificationMode(false);
				
		return AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(Sets.newHashSet(project.getModels()), options));
	}
}
