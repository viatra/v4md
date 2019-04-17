package com.incquerylabs.v4md.expressions;

import java.util.stream.Stream;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Element;

/**
 * Abstract implementation for query result providers; concrete instances should
 * be initialized with a parameterless constructor.
 *
 */
public abstract class BinaryQueryResultProvider {

	/**
	 * This method is responsible for calculating the results to be returned to MagicDraw.
	 * @return A non-null, but possibly empty stream of results
	 */
	public abstract Stream<Object> getResults(ViatraQueryEngine engine, Object source);
	
	/**
	 * Returns the expected source object types for the given query
	 */
	public abstract Class<?> getSourceType();
	/**
	 * Returns the expected result object type for a given query
	 * @return the return type, or if it cannot be calculated, null
	 */
	public abstract Class<?> getResultType();

}