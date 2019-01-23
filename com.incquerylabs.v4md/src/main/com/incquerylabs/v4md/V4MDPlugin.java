package com.incquerylabs.v4md;

import com.incquerylabs.v4md.expressions.BinaryVQLExpression;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.project.ProjectEventListenerAdapter;
import com.nomagic.magicdraw.expressions.evaluation.ExpressionEvaluationConfigurator;

public class V4MDPlugin extends com.nomagic.magicdraw.plugins.Plugin {
	
	@Override
	public void init() {
		Application.getInstance().getProjectsManager().addProjectListener(new ProjectEventListenerAdapter() {
			
			@Override
			public void projectOpened(Project project) {
				ViatraQueryAdapter.getOrCreateAdapter(project);
			}
			
			@Override
			public void projectPreClosed(Project project) {
				ViatraQueryAdapter.disposeAdapter(project);
			}
			
		});
		
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
