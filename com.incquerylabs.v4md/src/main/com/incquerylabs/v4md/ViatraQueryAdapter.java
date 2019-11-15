
package com.incquerylabs.v4md;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.incquerylabs.v4md.internal.MagicDrawProjectScope;
import com.nomagic.magicdraw.core.Project;

/**
 * Centralized management class for managing the lifecycle of query engines. The
 * static lifecycle methods of this class ensure that the adapter is correctly
 * registered as an EMF adapter to the given MagicDraw project.
 * 
 */
public class ViatraQueryAdapter extends AdapterImpl {
	
	private AdvancedViatraQueryEngine engine;
	private Project project;
	private boolean engineDisposable = true;
	private Set<String> identifierMap = new HashSet<>();

	private ViatraQueryAdapter(AdvancedViatraQueryEngine engine, Project project) {
		this.engine = engine;
		this.project = project;
	}
	
	public AdvancedViatraQueryEngine getEngine() {
		return engine;
	}
	
	/**
	 * This method is responsible for disposing of the VIATRA query engine and removing it from the list of project adapters.
	 * </p>
	 * <b>Note</b> Calling this method disposes the engine without any validation; it is not expected to be called by clients.
	 * @see #dispose(String)
	 */
	public void dispose(){
		engine.dispose();
		project.getPrimaryModel().eAdapters().remove(this);
	}
	
	/**
	 * Calling this method the client tells the system that the query engine
	 * accessor with a given identifier does not need the query engine anymore.
	 * Calling this method results in the adapter removing the identifier from the
	 * list of known users; and if there are no other users remaining, it disposes
	 * the engine itself.
	 */
	public void dispose(String identifier) {
		identifierMap.remove(Objects.requireNonNull(identifier, "Identifier must not be null"));
		if (engineDisposable && identifierMap.isEmpty()) {
			dispose();
		}
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
	
	/**
	 * Returns an adapter registered to the current project; however, if no adapter
	 * exists, no new adapter is constructed. Additionally, if the adapter exists,
	 * it is marked as accessed without identifiers, marking it non-removable.
	 */
	public static Optional<ViatraQueryAdapter> getAdapter(Project project) {
		Optional<ViatraQueryAdapter> adapter = doGetAdapter(project);
		adapter.ifPresent(ad -> ad.engineDisposable = false);
		return adapter;
	}

	/**
	 * Returns an query engine adapter for the given project (and the additionally
	 * selected notifiers as well); if no adapter exists, a new one is created.
	 * Furthermore, the adapter is marked as accessed without identifiers, marking
	 * it non-removable.
	 */
	public static ViatraQueryAdapter getOrCreateAdapter(Project project, Notifier... notifiers) {
		ViatraQueryAdapter adapter = doGetOrCreateAdapter(project, notifiers);
		adapter.engineDisposable = false;
		return adapter;
	}
	
	/**
	 * Returns an query engine adapter for the given project; if no adapter exists,
	 * a new one is created. Furthermore, the adapter is marked as accessed without
	 * identifiers, marking it non-removable.
	 */
	public static ViatraQueryAdapter getOrCreateAdapter(Project project) {
		return getOrCreateAdapter(project, new Notifier[0]);
	}
	
	/**
	 * Disposes the adapter of a given project without usage counter checking. It is not recommended to be called by clients.
	 */
	public static void disposeAdapter(Project project) {
		getAdapter(project).ifPresent(ViatraQueryAdapter::dispose);
	}
	
	/**
	 * Returns an adapter registered to the current project; however, if no adapter
	 * exists, no new adapter is constructed. Additionally, if the adapter exists,
	 * it is marked as accessed with the given identifier.
	 */
	public static Optional<ViatraQueryAdapter> getAdapter(Project project, String identifier) {
		Optional<ViatraQueryAdapter> adapter = doGetAdapter(project);
		adapter.ifPresent(ad -> ad.identifierMap.add(Objects.requireNonNull(identifier, "Identifier must not be null")));
		return adapter;
	}
	
	/**
	 * Returns an query engine adapter for the given project (and the additionally
	 * selected notifiers as well); if no adapter exists, a new one is created.
	 * Furthermore, the adapter is marked as accessed with the given identifier.
	 */
	public static ViatraQueryAdapter getOrCreateAdapter(Project project, String identifier, Notifier... notifiers) {
		ViatraQueryAdapter adapter = doGetOrCreateAdapter(project, notifiers);
		adapter.identifierMap.add(Objects.requireNonNull(identifier, "Identifier must not be null"));
		return adapter;
	}
	
	/**
	 * Returns an query engine adapter for the given project; if no adapter exists,
	 * a new one is created. Furthermore, the adapter is marked as accessed with the
	 * given identifier.
	 */
	public static ViatraQueryAdapter getOrCreateAdapter(Project project, String identifier) {
		return getOrCreateAdapter(project, identifier, new Notifier[0]);
	}
	
	/**
	 * Calling this method the client tells the system that the query engine
	 * accessor with a given identifier does not need the query engine anymore.
	 * Calling this method results in the adapter removing the identifier from the
	 * list of known users; and if there are no other users remaining, it disposes
	 * the engine itself.
	 */
	public static void disposeAdapter(Project project, String identifier) {
		getAdapter(project).ifPresent(ad -> ad.dispose(identifier));
	}
	
	private static Optional<ViatraQueryAdapter> doGetAdapter(Project project) {
		Objects.requireNonNull(project, "ViatraQueryAdapter cannot be provided for a null Project");
		return Optional.ofNullable(project.getPrimaryModel()).flatMap(m -> m.eAdapters().stream()
				.filter(ViatraQueryAdapter.class::isInstance).map(ViatraQueryAdapter.class::cast).findAny());
	}
	
	private static ViatraQueryAdapter doGetOrCreateAdapter(Project project, Notifier... notifiers) {
		return getAdapter(project).orElseGet(() -> {
			ViatraQueryAdapter adapter = new ViatraQueryAdapter(createQueryEngine(project, notifiers), project);
			project.getPrimaryModel().eAdapters().add(adapter);
			return adapter;
		});
	}
	
	private static AdvancedViatraQueryEngine createQueryEngine(Project project, Notifier... notifiers) throws ViatraQueryException {
		return AdvancedViatraQueryEngine.createUnmanagedEngine(createMagicDrawProjectScope(project, notifiers));
	}
	
	private static MagicDrawProjectScope createMagicDrawProjectScope(Project project, Notifier... notifiers) {
		if(V4MDSpecificEnvironmentOptionsGroup.getCurrentGroup().useEmptyQueryScope()) {
			return MagicDrawProjectScope.createMagicDrawEmptyProjectScope(project);
		}
		return new MagicDrawProjectScope(project, ViatraQueryAdapterOptions.getInstance().isEnableEngineProfiling(), notifiers);
	}
}
