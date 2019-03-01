package com.incquerylabs.v4md.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.scope.IEngineContext;
import org.eclipse.viatra.query.runtime.api.scope.IIndexingErrorListener;
import org.eclipse.viatra.query.runtime.base.api.BaseIndexOptions;
import org.eclipse.viatra.query.runtime.emf.EMFScope;

import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Package;

public class MagicDrawProjectScope extends EMFScope {

	private final Project project;
	private Notifier[] customNotifiers;
	private List<IProjectChangedListener> listeners = new ArrayList<>();

	// XXX Omitting references can cause semantic errors (so far we are in the clear though)
	// these references are only present in UML profiles, typically their contents are equal to the original references inherited from the UML type hierarchy, however there are some cases when this might not be the case.
	private static final BaseIndexOptions BASE_OPTIONS = new BaseIndexOptions()
			.withFeatureFilterConfiguration(reference -> reference instanceof EReference
					&& ((EReference) reference).isContainment() && reference.getName().contains("_from_"))
			.withStrictNotificationMode(false);
	
	static Stream<? extends Notifier> getProjectModels(Project projectModel) {
		Package primaryModel = projectModel.getPrimaryModel();
		return projectModel.getModels().stream().filter(pkg -> pkg == primaryModel || !EcoreUtil.isAncestor(primaryModel, pkg));
	}
	
	static Stream<Notifier> getCustomNotifiers(Notifier... notifiers) {
		return Arrays.stream(notifiers);
	}
	
	public MagicDrawProjectScope(Project project, Notifier... notifiers) {
		super(Stream.concat(getProjectModels(project), getCustomNotifiers(notifiers)).collect(Collectors.toSet()),
				BASE_OPTIONS);
		this.project = project;
		this.customNotifiers = notifiers;
	}

	public Project getProject() {
		return project;
	}

	@Override
	protected IEngineContext createEngineContext(ViatraQueryEngine engine, IIndexingErrorListener errorListener,
			Logger logger) {
		return new MagicDrawProjectEngineContext(this, engine, errorListener, logger);
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
	
	public boolean isIndexed(EObject element) {
		Set<Notifier> modelRoots = Stream.concat(getProjectModels(), getCustomNotifiers()).collect(Collectors.toSet());
		return EcoreUtil.isAncestor(modelRoots, element);
	}
}
