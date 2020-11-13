package com.incquerylabs.v4md.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.scope.IEngineContext;
import org.eclipse.viatra.query.runtime.api.scope.IIndexingErrorListener;
import org.eclipse.viatra.query.runtime.api.scope.QueryScope;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.base.api.profiler.ProfilerMode;
import org.eclipse.viatra.query.runtime.emf.EMFBaseIndexWrapper;
import org.eclipse.viatra.query.runtime.emf.EMFScope;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;

public class MagicDrawProjectScope extends EMFScope {

	private final Project project;
	private Notifier[] customNotifiers;
	private List<IProjectChangedListener> listeners = new ArrayList<>();
	private boolean useEmptyQueryScope = false;

	// XXX Omitting references can cause semantic errors (so far we are in the clear
	// though)
	// these references are only present in UML profiles, typically their contents
	// are equal to the original references inherited from the UML type hierarchy,
	// however there are some cases when this might not be the case.
	private static final BaseIndexOptions BASE_OPTIONS = new BaseIndexOptions().withFeatureFilterConfiguration(
			reference -> reference instanceof EReference && isReferenceToBeFiltered((EReference) reference, false))
			.withStrictNotificationMode(false);
	private static final BaseIndexOptions BASE_OPTIONS_ENABLE_DIAGRAM = new BaseIndexOptions()
			.withFeatureFilterConfiguration(
					reference -> reference instanceof EReference && isReferenceToBeFiltered((EReference) reference, true))
			.withStrictNotificationMode(false);
	private static final BaseIndexOptions BASE_OPTIONS_WITH_PROFILER = BASE_OPTIONS
			.withIndexProfilerMode(ProfilerMode.START_DISABLED);
	private static final BaseIndexOptions BASE_OPTIONS_ENABLE_DIAGRAM_WITH_PROFILER = BASE_OPTIONS_ENABLE_DIAGRAM
			.withIndexProfilerMode(ProfilerMode.START_DISABLED);

	private static boolean isReferenceToBeFiltered(EReference reference, boolean enableDiagramContentIndexing) {
		String name = reference.getName();
		if (reference.isContainment() && name.contains("_from_")) {
			return true;
		} else if (enableDiagramContentIndexing && name.equals("_representation")) {
			/*
			 * "_representation" is a special feature of the MagicDraw metamodel that
			 * describes the containment of diagram related representation elements
			 */
			return false;
		} else if (name.startsWith("_")) {
			return true;
		}
		return false;
	}

	static BaseIndexOptions getBaseIndexOptions(boolean enableProfiler, boolean enableDiagramContentIndexing) {
		if(enableProfiler) {
			if(enableDiagramContentIndexing)
				return BASE_OPTIONS_ENABLE_DIAGRAM_WITH_PROFILER;
			return BASE_OPTIONS_WITH_PROFILER;
		} else {
			if(enableDiagramContentIndexing)
				return BASE_OPTIONS_ENABLE_DIAGRAM;
			return BASE_OPTIONS;
		}
	}
	
	static Stream<? extends Notifier> getProjectModels(Project projectModel) {
		Package primaryModel = projectModel.getPrimaryModel();
		return projectModel.getModels().stream().filter(pkg -> pkg == primaryModel || !EcoreUtil.isAncestor(primaryModel, pkg));
	}

	static Stream<Notifier> getCustomNotifiers(Notifier... notifiers) {
		return Arrays.stream(notifiers);
	}

	/**
	 * A special constructor that provides the ability to create empty scope.
	 */
	private MagicDrawProjectScope(Project project) {
		super(new ResourceSetImpl(), BASE_OPTIONS); // Mocking a dummy notifier
		this.project = project;
		this.customNotifiers = new Notifier[0];
		this.useEmptyQueryScope = true;
	}

	/**
	 * Returns a special empty project scope associated to the given project where
	 * only a dummy notifier is indexed.
	 * 
	 * @param project associated to the empty scope
	 * @return a special empty project scope
	 */
	public static MagicDrawProjectScope createMagicDrawEmptyProjectScope(Project project) {
		return new MagicDrawProjectScope(project);
	}

	public MagicDrawProjectScope(Project project, Notifier... notifiers) {
		this(project, false, false, notifiers);
	}

	public MagicDrawProjectScope(Project project, boolean enableProfiler, boolean enableDiagramContentIndexing, Notifier... notifiers) {
		super(Stream.concat(getProjectModels(project), getCustomNotifiers(notifiers)).collect(Collectors.toSet()),
				getBaseIndexOptions(enableProfiler, enableDiagramContentIndexing));
		this.project = project;
		this.customNotifiers = notifiers;
	}

	public Project getProject() {
		return project;
	}

	@Override
	protected IEngineContext createEngineContext(ViatraQueryEngine engine, IIndexingErrorListener errorListener,
			Logger logger) {
		return new MagicDrawProjectEngineContext(this, errorListener, logger, useEmptyQueryScope);
	}

	public void projectStructureUpdated() {
		for (IProjectChangedListener listener : listeners) {
			listener.modelSetUpdated();
		}
	}

	Stream<? extends Notifier> getProjectModels() {
		return getProjectModels(project);
	}

	Stream<Notifier> getCustomNotifiers() {
		return getCustomNotifiers(customNotifiers);
	}

	public static MagicDrawProjectNavigationHelper extractNavigationHelper(ViatraQueryEngine engine) {
		final QueryScope scope = engine.getScope();
		if (scope instanceof MagicDrawProjectScope)
			return (MagicDrawProjectNavigationHelper) ((EMFBaseIndexWrapper) AdvancedViatraQueryEngine.from(engine)
					.getBaseIndex()).getNavigationHelper();
		else
			throw new IllegalArgumentException(
					"Cannot extract EMF base index from VIATRA Query engine instantiated on non-EMF scope " + scope);
	}
}
