package com.incquerylabs.v4md.transformations;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.transformation.evm.api.ScheduledExecution;
import org.eclipse.viatra.transformation.evm.api.Scheduler;
import org.eclipse.viatra.transformation.evm.update.IUpdateCompleteListener;
import org.eclipse.viatra.transformation.evm.update.IUpdateCompleteProvider;
import org.eclipse.viatra.transformation.evm.update.QueryEngineUpdateCompleteProvider;

import com.nomagic.magicdraw.core.Application;

public class MDEventBasedScheduler extends Scheduler implements IUpdateCompleteListener{

	private MDEventBasedSchedulerFactory factory;
	
	public MDEventBasedSchedulerFactory getFactory() {
		return factory;
	}

	public void setFactory(MDEventBasedSchedulerFactory factory) {
		this.factory = factory;
	}

	@Override
    public void updateComplete() {
        if(Application.getInstance().getProject().getRepository().getEventSupport().isEnableEventFiring()) {
        	schedule();
        }
    }
	
	@Override
    public void dispose() {
        factory.provider.removeUpdateCompleteListener(this);
        super.dispose();
    }
	
	protected MDEventBasedScheduler(ScheduledExecution execution) {
		super(execution);
	}

	 public static class MDEventBasedSchedulerFactory implements ISchedulerFactory {

	        private IUpdateCompleteProvider provider;

	        public IUpdateCompleteProvider getProvider() {
	            return provider;
	        }

	        public MDEventBasedSchedulerFactory(final ViatraQueryEngine engine) {
	            this.provider = new QueryEngineUpdateCompleteProvider(engine);
	        }

	        @Override
	        public Scheduler prepareScheduler(final ScheduledExecution execution) {
	        	MDEventBasedScheduler scheduler = new MDEventBasedScheduler(execution);
	            scheduler.factory = this;
	            provider.addUpdateCompleteListener(scheduler, true);
	            return scheduler;
	        }
	        
	    }
}
