
package com.incquerylabs.v4md;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

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
		Objects.requireNonNull(project, "ViatraQueryAdapter cannot be provided for a null Project");
		return project.getPrimaryModel().eAdapters().stream().filter(ViatraQueryAdapter.class::isInstance)
				.map(ViatraQueryAdapter.class::cast).findAny();
	}
	
	public static ViatraQueryAdapter getOrCreateAdapter(Project project, Notifier... notifiers) {
		return getAdapter(project).orElseGet(() -> {
					ViatraQueryAdapter adapter = 
							new ViatraQueryAdapter(
									createQueryEngine(
											Stream.concat(project.getModels().stream(), Arrays.stream(notifiers))
												.collect(Collectors.toSet())), 
									project);
					project.getPrimaryModel().eAdapters().add(adapter);
					return adapter;
				});
	}
	
	public static ViatraQueryAdapter getOrCreateAdapter(Project project) {
		return getOrCreateAdapter(project, new Notifier[0]);
	}
	
	public static void disposeAdapter(Project project) {
		getAdapter(project).ifPresent(ViatraQueryAdapter::dispose);
	}

	
	private static AdvancedViatraQueryEngine createQueryEngine(Set<? extends Notifier> setOfRootElement) throws ViatraQueryException {
		// XXX Omitting references can cause semantic errors (so far we are in the clear though)
		// these references are only present in UML profiles, typically their contents are equal to the original references inherited from the UML type hierarchy, however there are some cases when this might not be the case.
		BaseIndexOptions options = new BaseIndexOptions()
				.withFeatureFilterConfiguration(reference -> reference instanceof EReference
						&& ((EReference) reference).isContainment() && reference.getName().contains("_from_"))
				.withStrictNotificationMode(false);
				
		return AdvancedViatraQueryEngine.createUnmanagedEngine(new EMFScope(setOfRootElement, options));
	}
}
