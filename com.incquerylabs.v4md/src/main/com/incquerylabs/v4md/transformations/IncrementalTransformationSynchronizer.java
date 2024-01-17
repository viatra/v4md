package com.incquerylabs.v4md.transformations;

import java.beans.PropertyChangeEvent;
import java.util.Collection;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import org.eclipse.viatra.query.runtime.matchers.util.Preconditions;
import org.eclipse.viatra.transformation.runtime.emf.transformation.batch.BatchTransformation;

import com.dassault_systemes.modeler.foundation.synchronizer.ModelSynchronizer;
import com.dassault_systemes.modeler.foundation.synchronizer.ModelSynchronizerManager;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.uml2.synchronizer.TransactionBasedSynchronizer;

/**
 * This synchronizer is used by VIATRA batch transformation to support rerunning
 * incremental transformations if the model is changed during transaction based
 * synchronizers.
 * </p>
 * 
 * Important notes:
 * <ul>
 * <li>This synchronizer is registered globally with the {@link #FACTORY}
 * instance to the class {@link ModelSynchronizerManager#addFactory(Function)},
 * and each transformation should wrap its execution by calling
 * {@link #transformationStarted(BatchTransformation, Predicate, Runnable)} and
 * {@link #transformationFinished(BatchTransformation)}.</li>
 * 
 * <li>It is the transformations responsibility to avoid infinite calls by
 * providing an appropriate filter predicate.</li>
 * 
 * <li>This synchronizer does not support multiple transformations running at
 * the same time.</li>
 * <li>This synchronizer relies on internal APIs of MagicDraw, its behavior may
 * depend on the executed MagicDraw versions.</li>
 * </ul>
 *
 */
@SuppressWarnings("deprecation")
public class IncrementalTransformationSynchronizer extends TransactionBasedSynchronizer<Project> {

	public static Function<Project, ModelSynchronizer> FACTORY = new ViatraTransformationSynchronizerManager();

	private static class ViatraTransformationSynchronizerManager implements Function<Project, ModelSynchronizer> {

		private WeakHashMap<Project, IncrementalTransformationSynchronizer> storage = new WeakHashMap<>();

		private ViatraTransformationSynchronizerManager() {
			// Hidden constructor for singleton class
		}

		@Override
		public ModelSynchronizer apply(Project t) {
			return (ModelSynchronizer) storage.computeIfAbsent(t, IncrementalTransformationSynchronizer::new);
		}
		
	}
	public static void disposeSynchronizer(Project p) {
		((ViatraTransformationSynchronizerManager)FACTORY).storage.remove(p);
	}

	private BatchTransformation transformation;

	private Predicate<Collection<PropertyChangeEvent>> needsRerun;
	private Runnable rerunTransformation;

	public IncrementalTransformationSynchronizer(Project project) {
		super(project);
	}

	/**
	 * Notifies the synchronizer that a rerunnable transformation is being started,
	 * and provides a predicate to decide whether a rerun is necessary and a
	 * runnable to execute the transformation again.
	 * 
	 */
	public void transformationStarted(BatchTransformation transformation,
			Predicate<Collection<PropertyChangeEvent>> needsRerun, Runnable rerunTransformation) {
		this.transformation = transformation;
		this.needsRerun = needsRerun;
		this.rerunTransformation = rerunTransformation;
	}

	/**
	 * Marks that the given transformation has ended, and the synchronizer needs not
	 * consider further changes.
	 * 
	 * @throws IllegalStateException if a different transformation is being executed
	 *                               to the one given
	 */
	public void transformationFinished(BatchTransformation transformation) {
		Preconditions.checkState(Objects.equals(this.transformation, transformation), "Invalid transformation to stop");
		this.transformation = null;
		this.needsRerun = null;
		this.rerunTransformation = null;
	}

	@Override
	public Runnable transactionCommited(Collection<PropertyChangeEvent> events) {
		if (transformation != null && needsRerun.test(events)) {
			return rerunTransformation;
		} else {
			return null;
		}
	}

}
