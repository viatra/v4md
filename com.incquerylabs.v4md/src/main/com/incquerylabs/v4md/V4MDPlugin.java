package com.incquerylabs.v4md;

import com.incquerylabs.v4md.expressions.BinaryVQLExpression;
import com.nomagic.ci.persistence.IProject;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.ProjectUtilities;
import com.nomagic.magicdraw.core.modules.ModuleUsage;
import com.nomagic.magicdraw.core.project.ProjectEventListenerAdapter;
import com.nomagic.magicdraw.core.project.ProjectPartListener;
import com.nomagic.magicdraw.expressions.evaluation.ExpressionEvaluationConfigurator;

public class V4MDPlugin extends com.nomagic.magicdraw.plugins.Plugin {
	
	private final class V4MDProjectListener extends ProjectEventListenerAdapter implements ProjectPartListener {
		@Override
		public void projectOpened(Project project) {
			ViatraQueryAdapter.getOrCreateAdapter(project);
		}

		@Override
		public void projectPreClosed(Project project) {
			ViatraQueryAdapter.disposeAdapter(project);
		}

		@Override
		public void projectPartLoaded(Project project, IProject storage) {
			ViatraQueryAdapter.getAdapter(project).ifPresent(ViatraQueryAdapter::projectStructureUpdated);
		}

		@Override
		public void projectPartAttached(ModuleUsage usage) {
			Project project = ProjectUtilities.getProject(usage.getUsed());
			ViatraQueryAdapter.getAdapter(project).ifPresent(ViatraQueryAdapter::projectStructureUpdated);
		}

		@Override
		public void projectPartDetached(ModuleUsage usage) {
			Project project = ProjectUtilities.getProject(usage.getUsed());
			ViatraQueryAdapter.getAdapter(project).ifPresent(ViatraQueryAdapter::projectStructureUpdated);
			
		}

		@Override
		public void projectPartRemoved(IProject project) {
			Project modelProject = ProjectUtilities.getProject(project);
			ViatraQueryAdapter.getAdapter(modelProject).ifPresent(ViatraQueryAdapter::projectStructureUpdated);
		}
	}

	@Override
	public void init() {
		Application.getInstance().getProjectsManager().addProjectListener(new V4MDProjectListener());
		
		// Registers an expression evaluator for generated VIATRA queries
		ExpressionEvaluationConfigurator.getInstance().registerFactory(BinaryVQLExpression.LANGUAGE,
				BinaryVQLExpression::new);
	}
	
	@Override
	public boolean close() {
		return true;
	}
	
	@Override
	public boolean isSupported() {
		return true;
	}
}
