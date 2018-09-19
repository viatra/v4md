package com.incquerylabs.v4md.snapshotmaker.registry

import com.incquerylabs.v4md.snapshotmaker.queries.DeduciblePortType
import com.incquerylabs.v4md.snapshotmaker.queries.internal.PortWithSpecifiedType
import org.eclipse.viatra.query.runtime.api.IQuerySpecification
import java.util.List
import org.eclipse.viatra.query.runtime.api.GenericPatternMatcher

class QueryRegistry {
	static def getQueries(){
		#[
			DeduciblePortType,
			PortWithSpecifiedType
		] as List<IQuerySpecification<GenericPatternMatcher>>
	}
}