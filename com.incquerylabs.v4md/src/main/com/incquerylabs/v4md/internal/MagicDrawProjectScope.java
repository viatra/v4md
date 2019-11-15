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
import org.eclipse.viatra.query.runtime.emf.EMFBaseIndexWrapper;
import org.eclipse.viatra.query.runtime.emf.EMFScope;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;

public class MagicDrawProjectScope extends EMFScope {

	private final Project project;
	private final boolean enableProfiler;
	private Notifier[] customNotifiers;
	private List<IProjectChangedListener> listeners = new ArrayList<>();
	private boolean useEmptyQueryScope = false;

	// XXX Omitting references can cause semantic errors (so far we are in the clear though)
	// these references are only present in UML profiles, typically their contents are equal to the original references inherited from the UML type hierarchy, however there are some cases when this might not be the case.
	private static final BaseIndexOptions BASE_OPTIONS = new BaseIndexOptions()
			.withFeatureFilterConfiguration(reference -> reference instanceof EReference && isReferenceToBeFiltered((EReference) reference))
			.withStrictNotificationMode(false);
	
	private static boolean isReferenceToBeFiltered(EReference reference) {
		String name = reference.getName();
		return (reference.isContainment() && name.contains("_from_"))
				||
				name.startsWith("_");
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
		super(new ResourceSetImpl(), BASE_OPTIONS); //Mocking a dummy notifier
		this.project = project;
		this.enableProfiler = false;
		this.customNotifiers = new Notifier[0];
		this.useEmptyQueryScope = true;
	}
	
	/**
	 * Returns a special empty project scope associated to the given project where only a dummy notifier is indexed. 
	 * @param project associated to the empty scope
	 * @return a special empty project scope
	 */
	public static MagicDrawProjectScope createMagicDrawEmptyProjectScope(Project project) {
		return new MagicDrawProjectScope(project);
	}
	
	public MagicDrawProjectScope(Project project, Notifier... notifiers) {
		this(project, false, notifiers);
	}
	
	public MagicDrawProjectScope(Project project, boolean enableProfiler, Notifier... notifiers) {
		super(Stream.concat(getProjectModels(project), getCustomNotifiers(notifiers)).collect(Collectors.toSet()),
				BASE_OPTIONS);
		this.project = project;
		this.enableProfiler = enableProfiler;
		this.customNotifiers = notifiers;
	}

	public Project getProject() {
		return project;
	}

	@Override
	protected IEngineContext createEngineContext(ViatraQueryEngine engine, IIndexingErrorListener errorListener,
			Logger logger) {
		return new MagicDrawProjectEngineContext(this, errorListener, enableProfiler, logger, useEmptyQueryScope);
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
            return (MagicDrawProjectNavigationHelper) ((EMFBaseIndexWrapper)AdvancedViatraQueryEngine.from(engine).getBaseIndex()).getNavigationHelper();
        else throw new IllegalArgumentException("Cannot extract EMF base index from VIATRA Query engine instantiated on non-EMF scope " + scope);
	}
}
