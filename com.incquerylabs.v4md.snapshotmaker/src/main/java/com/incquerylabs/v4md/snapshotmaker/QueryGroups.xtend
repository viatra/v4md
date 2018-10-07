package com.incquerylabs.v4md.snapshotmaker

import com.incquerylabs.v4md.test.queries.*

class QueryGroups {
	public static def groups(){
		#{
			Aggregator_Functions.instance,
			Block_With_More_than_1_Parent.instance,
			Check_Expression.instance,
			Circular_Dependency.instance,
			Non_Unique_Names.instance,
			Pattern_Constraints.instance,
			Port_Connections.instance,
			Requirement_Realization.instance,
			Subpattern_Calls.instance,
			Transitive_Closure.instance,
			Unreachable_States.instance
		}
	}
}