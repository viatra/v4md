package com.incquerylabs.v4md.internal;

import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.viatra.query.runtime.matchers.backend.IMatcherCapability;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackend;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryBackendFactory;
import org.eclipse.viatra.query.runtime.matchers.backend.IQueryResultProvider;
import org.eclipse.viatra.query.runtime.matchers.backend.IUpdateable;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.IQueryBackendContext;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.viatra.query.runtime.matchers.tuple.ITuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.TupleMask;
import org.eclipse.viatra.query.runtime.matchers.util.Accuracy;

public class NopQueryBackend implements IQueryBackend {

	public class NopQueryResultProvider implements IQueryResultProvider {

		@Override
		public boolean hasMatch(Object[] parameters) {
			return false;
		}

		@Override
		public boolean hasMatch(TupleMask parameterSeedMask, ITuple projectedParameterSeed) {
			return false;
		}

		@Override
		public int countMatches(Object[] parameters) {
			return 0;
		}

		@Override
		public int countMatches(TupleMask parameterSeedMask, ITuple projectedParameterSeed) {
			return 0;
		}

		@Override
		public Optional<Long> estimateCardinality(TupleMask groupMask, Accuracy requiredAccuracy) {
			return Optional.of(0l);
		}

		@Override
		public Optional<Tuple> getOneArbitraryMatch(Object[] parameters) {
			return Optional.empty();
		}

		@Override
		public Optional<Tuple> getOneArbitraryMatch(TupleMask parameterSeedMask, ITuple parameters) {
			return Optional.empty();
		}

		@Override
		public Stream<Tuple> getAllMatches(Object[] parameters) {
			return Stream.empty();
		}

		@Override
		public Stream<Tuple> getAllMatches(TupleMask parameterSeedMask, ITuple parameters) {
			return Stream.empty();
		}

		@Override
		public IQueryBackend getQueryBackend() {
			return NopQueryBackend.this;
		}

		@Override
		public void addUpdateListener(IUpdateable listener, Object listenerTag, boolean fireNow) {
		}

		@Override
		public void removeUpdateListener(Object listenerTag) {
		}
	}
	
	public static final IQueryBackendFactory CACHING_FACTORY = new IQueryBackendFactory() {
		
		@Override
		public boolean isCaching() {
			return true;
		}
		
		@Override
		public Class<? extends IQueryBackend> getBackendClass() {
			return NopQueryBackend.class;
		}
		
		@Override
		public IQueryBackend create(IQueryBackendContext context) {
			return new NopQueryBackend(this, true);
		}
		
		@Override
		public IMatcherCapability calculateRequiredCapability(PQuery query, QueryEvaluationHint hint) {
			return capability -> true;
		}
	}; 
	
	public static final IQueryBackendFactory SEARCH_FACTORY = new IQueryBackendFactory() {
		
		@Override
		public boolean isCaching() {
			return false;
		}
		
		@Override
		public Class<? extends IQueryBackend> getBackendClass() {
			return NopQueryBackend.class;
		}
		
		@Override
		public IQueryBackend create(IQueryBackendContext context) {
			return new NopQueryBackend(this, false);
		}
		
		@Override
		public IMatcherCapability calculateRequiredCapability(PQuery query, QueryEvaluationHint hint) {
			return capability -> true;
		}
	}; 
	
	private NopQueryResultProvider resultProvider = new NopQueryResultProvider();
	private boolean isCaching;
	private IQueryBackendFactory factory;
	
	
	
	public NopQueryBackend(IQueryBackendFactory factory, boolean isCaching) {
		super();
		this.isCaching = isCaching;
		this.factory = factory;
	}

	@Override
	public boolean isCaching() {
		return isCaching;
	}

	@Override
	public IQueryResultProvider getResultProvider(PQuery query) {
		return resultProvider;
	}

	@Override
	public IQueryResultProvider getResultProvider(PQuery query, QueryEvaluationHint hints) {
		return resultProvider;
	}

	@Override
	public IQueryResultProvider peekExistingResultProvider(PQuery query) {
		return resultProvider;
	}

	@Override
	public void flushUpdates() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public IQueryBackendFactory getFactory() {
		return factory;
	}

}
