
package com.incquerylabs.v4md;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.incquerylabs.v4md.internal.MagicDrawProjectScope;
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
	
	/**
	 * This method is called by a project change listener registered by V4MD; it should not be called by end-users.
	 */
	void projectStructureUpdated() {
		((MagicDrawProjectScope)engine.getScope()).projectStructureUpdated();
	}
	
	public static Optional<ViatraQueryAdapter> getAdapter(Project project) {
		Objects.requireNonNull(project, "ViatraQueryAdapter cannot be provided for a null Project");
		return Optional.ofNullable(project.getPrimaryModel()).flatMap(m -> m.eAdapters().stream()
				.filter(ViatraQueryAdapter.class::isInstance).map(ViatraQueryAdapter.class::cast).findAny());
	}
	
	public static ViatraQueryAdapter getOrCreateAdapter(Project project, Notifier... notifiers) {
		return getAdapter(project).orElseGet(() -> {
			ViatraQueryAdapter adapter = new ViatraQueryAdapter(createQueryEngine(project, notifiers), project);
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
	
	private static AdvancedViatraQueryEngine createQueryEngine(Project project, Notifier... notifiers) throws ViatraQueryException {
		return AdvancedViatraQueryEngine.createUnmanagedEngine(new MagicDrawProjectScope(project, ViatraQueryAdapterOptions.getInstance().isEnableEngineProfiling(), notifiers));
	}
}
