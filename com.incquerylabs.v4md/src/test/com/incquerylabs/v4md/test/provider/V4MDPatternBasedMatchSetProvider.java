package com.incquerylabs.v4md.test.provider;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryMatcher;
import org.eclipse.viatra.query.runtime.emf.EMFScope;
import org.eclipse.viatra.query.testing.core.IMatchSetModelProvider;
import org.eclipse.viatra.query.testing.core.SnapshotHelper;
import org.eclipse.viatra.query.testing.snapshot.MatchSetRecord;

import com.incquerylabs.v4md.ViatraQueryAdapter;

public class V4MDPatternBasedMatchSetProvider implements IMatchSetModelProvider {

	private ViatraQueryAdapter adapter;
	private SnapshotHelper helper;
	
	public V4MDPatternBasedMatchSetProvider(ViatraQueryAdapter adapter) {
		this.adapter = adapter;
		this.helper = new SnapshotHelper();
	}
	
	
	public V4MDPatternBasedMatchSetProvider(ViatraQueryAdapter adapter, SnapshotHelper snapshotHelper) {
		this.adapter = adapter;
		this.helper = snapshotHelper;
	}


	@Override
	public <Match extends IPatternMatch> MatchSetRecord getMatchSetRecord(EMFScope scope,
			IQuerySpecification<? extends ViatraQueryMatcher<Match>> querySpecification, Match filter) {

		ViatraQueryMatcher<Match> matcher = adapter.getEngine().getMatcher(querySpecification);
        return helper.createMatchSetRecordForMatcher(matcher,
                filter == null ? matcher.newEmptyMatch() : filter);
	}

	@Override
	public <Match extends IPatternMatch> MatchSetRecord getMatchSetRecord(ResourceSet rs,
			IQuerySpecification<? extends ViatraQueryMatcher<Match>> querySpecification, Match filter) {
	
		return getMatchSetRecord(new EMFScope(rs), querySpecification, filter);
	}

	@Override
	public boolean updatedByModify() {
		 return true;
	}

	@Override
	public void dispose() {
		if (adapter != null) {
			adapter.dispose();
			adapter = null;
		}
	}
	

}
