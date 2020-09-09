
package com.incquerylabs.v4md;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.IQueryGroup;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngineOptions;
import org.eclipse.viatra.query.runtime.exception.ViatraQueryException;

import com.incquerylabs.v4md.internal.MagicDrawProjectScope;
import com.incquerylabs.v4md.internal.NopQueryBackend;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.ProjectUtilities;

/**
 * Centralized management class for managing the lifecycle of query engines. The
 * static lifecycle methods of this class ensure that the adapter is correctly
 * registered as an EMF adapter to the given MagicDraw project.
 * 
 */
public class ViatraQueryAdapter extends AdapterImpl {
	public static final String MESSAGE_ENGINE_PREPARE_ACTION_ERROR = 
			"Required actions cannot be executed on the VIATRA engine!";
	public static final String MESSAGE_ENGINE_NOT_READY = 
			"Cannot initialize VIATRA Query Engine until the project is loaded.";
	private static final Logger LOGGER = Logger.getLogger(ViatraQueryAdapter.class);
	
	private Optional<AdvancedViatraQueryEngine> engine = Optional.empty();
	private Project project;
	private boolean engineDisposable = true;
	private Set<String> identifierMap = new HashSet<>();
	private boolean isInitialized = false;
	private Notifier[] notifiers;
	private List<Consumer<AdvancedViatraQueryEngine>> initializationActions = new ArrayList<>();

	private ViatraQueryAdapter(Project project, Notifier[] notifiers) {
		this.project = project;
		this.notifiers = notifiers;
	}

	/**
	 * @deprecated Use {@link #getInitializedEngineChecked()} or {@link #getInitializedEngine()} instead
	 * @return initialized engine
	 * @throws ViatraQueryException if no query engine was initialized before and initialization failed
	 */
	@Deprecated
	public AdvancedViatraQueryEngine getEngine() {
		return getInitializedEngineChecked();
	}

	/**
	 * Returns an initialized VIATRA query engine stored in the adapter.
	 * If a query engine was initialized earlier, that engine will be returned;
	 * if no query engine was initialized earlier, a new one is created. If
	 * the initialization fails, e.g. the engine was requested before the
	 * model was loaded entirely, a {@link ViatraQueryException} is thrown.
	 * </p>
	 * This method should only be called if the engine initialization is
	 * expected to be completed successfully, otherwise it is recommended
	 * to use {@link #getInitializedEngine()},
	 * {@link #executeActionOnEngine(Consumer)}
	 * or {@link #requireQueries(IQuerySpecification)} instead
	 * as they are aimed to handle the initialization issues better.

	 * @return the initialized engine
	 * @throws ViatraQueryException if no query engine was initialized before and initialization failed
	 */
	public AdvancedViatraQueryEngine getInitializedEngineChecked() {
		return getInitializedEngine()
				.orElseThrow(() ->
					new ViatraQueryException(MESSAGE_ENGINE_NOT_READY, MESSAGE_ENGINE_NOT_READY));
	}

	/**
	 * Provide the initialized VIATRA if possible.<br />
	 * If the engine hasn't been initialized but it can be, then it will be initialize and
	 * every initialization action registered before will be executed.
	 * 
	 * @return the initialized VIATRA engine if possible, otherwise an empty Optional
	 * @see ViatraQueryAdapter#executeActionOnEngine(Consumer)
	 * @see ViatraQueryAdapter#requireQueries(IQuerySpecification)
	 */
	public Optional<AdvancedViatraQueryEngine> getInitializedEngine() {
		if(!isInitialized) {
			initializeEngine();
		}
		return engine;
	}
	
	/**
	 * Checks if an engine is available and execute the given action on it if yes.
	 * If not, the action will be registered in the list of actions which need to be done 
	 * when the engine is ready and will be executed when the engine become available.
	 * 
	 * @param action the operation which would like to use the initialized VIATRA engine
	 * @return the initialized VIATRA engine of it is available, otherwise empty Optional.
	 */
	public void executeActionOnEngine(Consumer<AdvancedViatraQueryEngine> action) {
		if(action != null) {
			initializationActions.add(action);
		}
		// we use initializeEngine instead of getInitializedEngine because the initializeEngine
		// executes the actions anyway while the other is just when the initialization is not complete
		initializeEngine();
	}
	
	private Optional<AdvancedViatraQueryEngine> initializeEngine() {
		synchronized(this) {
			if(!isInitialized && ProjectUtilities.isLoaded(project.getPrimaryProject())) {
				engine = Optional.of(createQueryEngine(project, notifiers));
			}
			isInitialized = engine.map(e -> {
					boolean thereWasException = false;
					try {
						e.getBaseIndex().coalesceTraversals(() -> {
							initializationActions.forEach(action -> action.accept(e));
							return null;
						});
						initializationActions.clear();
						notifiers = new Notifier[0];
					} catch (InvocationTargetException ite) {
						// we can invalidate our engine because there is two option for this exception:
						// 1. we throw something directly from the callable (but we don't do this)
						// 2. the engine got tainted because of an internal error, making the engine unusable
						// so even if we execute some action later than the  real initialization of the engine,
						// the engine will brake down and can't be used anymore
						LOGGER.error(MESSAGE_ENGINE_PREPARE_ACTION_ERROR, ite);
						e.dispose();
						thereWasException = true;
					}
					return !thereWasException;
				}).orElseGet(() -> {
					LOGGER.warn(MESSAGE_ENGINE_NOT_READY);
					return false;
				});
			if(!isInitialized) {
				engine = Optional.empty();
			}
		}
		return engine;
	}
	
	/**
	 * Prepare queries on the VIATRA query engine of the adapter. If it cannot be created
	 * immediately, the initialization of the queries will be done when the engine is ready.
	 * 
	 * @param querySpecifications the initializable queries
	 */
	public void requireQueries(IQuerySpecification<?>... querySpecifications) {
		Consumer<AdvancedViatraQueryEngine> initializer = e -> {
			for (IQuerySpecification<?> querySpecification : querySpecifications) {
				e.getMatcher(querySpecification);
			}
		};
		executeActionOnEngine(initializer);
	}
	
	/**
	 * Prepare queries on the VIATRA query engine of the adapter. If it cannot be created
	 * immediately, the initialization of the queries will be done when the engine is ready.
	 * 
	 * @param queryGroups the initializable queries
	 */
	public void requireQueries(IQueryGroup... queryGroups) {
		Consumer<AdvancedViatraQueryEngine> initializer = e -> {
			for (IQueryGroup queryGroup : queryGroups) {
				queryGroup.prepare(e);
			}
		};
		executeActionOnEngine(initializer);
	}
	
	/**
	 * This method is responsible for disposing of the VIATRA query engine and removing it from the list of project adapters.
	 * </p>
	 * <b>Note</b> Calling this method disposes the engine without any validation; it is not expected to be called by clients.
	 * @see #dispose(String)
	 */
	public void dispose(){
		engine.ifPresent(AdvancedViatraQueryEngine::dispose);
		isInitialized = false;
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
		engine.ifPresent(AdvancedViatraQueryEngine::wipe);
	}
	
	/**
	 * This method is called by a project change listener registered by V4MD; it should not be called by end-users.
	 */
	void projectStructureUpdated() {
		engine.ifPresent(e -> ((MagicDrawProjectScope)e.getScope()).projectStructureUpdated());
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
			ViatraQueryAdapter adapter = new ViatraQueryAdapter(project, notifiers);
			project.getPrimaryModel().eAdapters().add(adapter);
			return adapter;
		});
	}
	
	private static AdvancedViatraQueryEngine createQueryEngine(Project project, Notifier... notifiers) throws ViatraQueryException {
		ViatraQueryEngineOptions options;
		if (V4MDSpecificEnvironmentOptionsGroup.getCurrentGroup().isEmptyQueryScopeRequired()) {
			options = ViatraQueryEngineOptions.defineOptions()
					.withDefaultBackend(NopQueryBackend.CACHING_FACTORY)
					.withDefaultCachingBackend(NopQueryBackend.CACHING_FACTORY)
					.withDefaultSearchBackend(NopQueryBackend.SEARCH_FACTORY)
					.build();
		} else {
			options = ViatraQueryEngineOptions.getDefault();
		}
		return AdvancedViatraQueryEngine.createUnmanagedEngine(createMagicDrawProjectScope(project, notifiers), options);
	}
	
	private static MagicDrawProjectScope createMagicDrawProjectScope(Project project, Notifier... notifiers) {
		if(V4MDSpecificEnvironmentOptionsGroup.getCurrentGroup().isEmptyQueryScopeRequired()) {
			return MagicDrawProjectScope.createMagicDrawEmptyProjectScope(project);
		}
		return new MagicDrawProjectScope(project, ViatraQueryAdapterOptions.getInstance().isEnableEngineProfiling(), notifiers);
	}
}
