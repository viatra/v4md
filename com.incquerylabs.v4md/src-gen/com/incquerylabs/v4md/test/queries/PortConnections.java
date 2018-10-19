/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Port_Connections.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector;
import com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         pattern PortConnections(port1 : Port, connector : Connector, port2 : Port) {
 *             Connector.end(connector, end1);
 *             Connector.end(connector, end2);
 *             
 *             Port.end(port1, end1);
 *             Port.end(port2, end2);
 *             
 *             port1 != port2;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class PortConnections extends BaseGeneratedEMFQuerySpecification<PortConnections.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.PortConnections pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private Port fPort1;
    
    private Connector fConnector;
    
    private Port fPort2;
    
    private static List<String> parameterNames = makeImmutableList("port1", "connector", "port2");
    
    private Match(final Port pPort1, final Connector pConnector, final Port pPort2) {
      this.fPort1 = pPort1;
      this.fConnector = pConnector;
      this.fPort2 = pPort2;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("port1".equals(parameterName)) return this.fPort1;
      if ("connector".equals(parameterName)) return this.fConnector;
      if ("port2".equals(parameterName)) return this.fPort2;
      return null;
    }
    
    public Port getPort1() {
      return this.fPort1;
    }
    
    public Connector getConnector() {
      return this.fConnector;
    }
    
    public Port getPort2() {
      return this.fPort2;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("port1".equals(parameterName) ) {
          this.fPort1 = (Port) newValue;
          return true;
      }
      if ("connector".equals(parameterName) ) {
          this.fConnector = (Connector) newValue;
          return true;
      }
      if ("port2".equals(parameterName) ) {
          this.fPort2 = (Port) newValue;
          return true;
      }
      return false;
    }
    
    public void setPort1(final Port pPort1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPort1 = pPort1;
    }
    
    public void setConnector(final Connector pConnector) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fConnector = pConnector;
    }
    
    public void setPort2(final Port pPort2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fPort2 = pPort2;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.PortConnections";
    }
    
    @Override
    public List<String> parameterNames() {
      return PortConnections.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fPort1, fConnector, fPort2};
    }
    
    @Override
    public PortConnections.Match toImmutable() {
      return isMutable() ? newMatch(fPort1, fConnector, fPort2) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"port1\"=" + prettyPrintValue(fPort1) + ", ");
      result.append("\"connector\"=" + prettyPrintValue(fConnector) + ", ");
      result.append("\"port2\"=" + prettyPrintValue(fPort2));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fPort1, fConnector, fPort2);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof PortConnections.Match)) {
          PortConnections.Match other = (PortConnections.Match) obj;
          return Objects.equals(fPort1, other.fPort1) && Objects.equals(fConnector, other.fConnector) && Objects.equals(fPort2, other.fPort2);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }
    
    @Override
    public PortConnections specification() {
      return PortConnections.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static PortConnections.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pPort1 the fixed value of pattern parameter port1, or null if not bound.
     * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
     * @param pPort2 the fixed value of pattern parameter port2, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static PortConnections.Match newMutableMatch(final Port pPort1, final Connector pConnector, final Port pPort2) {
      return new Mutable(pPort1, pConnector, pPort2);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPort1 the fixed value of pattern parameter port1, or null if not bound.
     * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
     * @param pPort2 the fixed value of pattern parameter port2, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static PortConnections.Match newMatch(final Port pPort1, final Connector pConnector, final Port pPort2) {
      return new Immutable(pPort1, pConnector, pPort2);
    }
    
    private static final class Mutable extends PortConnections.Match {
      Mutable(final Port pPort1, final Connector pConnector, final Port pPort2) {
        super(pPort1, pConnector, pPort2);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends PortConnections.Match {
      Immutable(final Port pPort1, final Connector pConnector, final Port pPort2) {
        super(pPort1, pConnector, pPort2);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.PortConnections pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern PortConnections(port1 : Port, connector : Connector, port2 : Port) {
   *     Connector.end(connector, end1);
   *     Connector.end(connector, end2);
   *     
   *     Port.end(port1, end1);
   *     Port.end(port2, end2);
   *     
   *     port1 != port2;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see PortConnections
   * 
   */
  public static class Matcher extends BaseMatcher<PortConnections.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static PortConnections.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }
    
    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static PortConnections.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_PORT1 = 0;
    
    private final static int POSITION_CONNECTOR = 1;
    
    private final static int POSITION_PORT2 = 2;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PortConnections.Matcher.class);
    
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }
    
    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pPort1 the fixed value of pattern parameter port1, or null if not bound.
     * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
     * @param pPort2 the fixed value of pattern parameter port2, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<PortConnections.Match> getAllMatches(final Port pPort1, final Connector pConnector, final Port pPort2) {
      return rawStreamAllMatches(new Object[]{pPort1, pConnector, pPort2}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pPort1 the fixed value of pattern parameter port1, or null if not bound.
     * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
     * @param pPort2 the fixed value of pattern parameter port2, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<PortConnections.Match> streamAllMatches(final Port pPort1, final Connector pConnector, final Port pPort2) {
      return rawStreamAllMatches(new Object[]{pPort1, pConnector, pPort2});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPort1 the fixed value of pattern parameter port1, or null if not bound.
     * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
     * @param pPort2 the fixed value of pattern parameter port2, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<PortConnections.Match> getOneArbitraryMatch(final Port pPort1, final Connector pConnector, final Port pPort2) {
      return rawGetOneArbitraryMatch(new Object[]{pPort1, pConnector, pPort2});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pPort1 the fixed value of pattern parameter port1, or null if not bound.
     * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
     * @param pPort2 the fixed value of pattern parameter port2, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Port pPort1, final Connector pConnector, final Port pPort2) {
      return rawHasMatch(new Object[]{pPort1, pConnector, pPort2});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pPort1 the fixed value of pattern parameter port1, or null if not bound.
     * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
     * @param pPort2 the fixed value of pattern parameter port2, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Port pPort1, final Connector pConnector, final Port pPort2) {
      return rawCountMatches(new Object[]{pPort1, pConnector, pPort2});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pPort1 the fixed value of pattern parameter port1, or null if not bound.
     * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
     * @param pPort2 the fixed value of pattern parameter port2, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Port pPort1, final Connector pConnector, final Port pPort2, final Consumer<? super PortConnections.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pPort1, pConnector, pPort2}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pPort1 the fixed value of pattern parameter port1, or null if not bound.
     * @param pConnector the fixed value of pattern parameter connector, or null if not bound.
     * @param pPort2 the fixed value of pattern parameter port2, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public PortConnections.Match newMatch(final Port pPort1, final Connector pConnector, final Port pPort2) {
      return PortConnections.Match.newMatch(pPort1, pConnector, pPort2);
    }
    
    /**
     * Retrieve the set of values that occur in matches for port1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Port> rawStreamAllValuesOfport1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PORT1, parameters).map(Port.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for port1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfport1() {
      return rawStreamAllValuesOfport1(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfport1() {
      return rawStreamAllValuesOfport1(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfport1(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfport1(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfport1(final Connector pConnector, final Port pPort2) {
      return rawStreamAllValuesOfport1(new Object[]{null, pConnector, pPort2});
    }
    
    /**
     * Retrieve the set of values that occur in matches for port1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfport1(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfport1(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfport1(final Connector pConnector, final Port pPort2) {
      return rawStreamAllValuesOfport1(new Object[]{null, pConnector, pPort2}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connector.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Connector> rawStreamAllValuesOfconnector(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CONNECTOR, parameters).map(Connector.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for connector.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Connector> getAllValuesOfconnector() {
      return rawStreamAllValuesOfconnector(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connector.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Connector> streamAllValuesOfconnector() {
      return rawStreamAllValuesOfconnector(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connector.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Connector> streamAllValuesOfconnector(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfconnector(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connector.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Connector> streamAllValuesOfconnector(final Port pPort1, final Port pPort2) {
      return rawStreamAllValuesOfconnector(new Object[]{pPort1, null, pPort2});
    }
    
    /**
     * Retrieve the set of values that occur in matches for connector.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Connector> getAllValuesOfconnector(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfconnector(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for connector.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Connector> getAllValuesOfconnector(final Port pPort1, final Port pPort2) {
      return rawStreamAllValuesOfconnector(new Object[]{pPort1, null, pPort2}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Port> rawStreamAllValuesOfport2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PORT2, parameters).map(Port.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for port2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfport2() {
      return rawStreamAllValuesOfport2(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfport2() {
      return rawStreamAllValuesOfport2(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfport2(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfport2(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Port> streamAllValuesOfport2(final Port pPort1, final Connector pConnector) {
      return rawStreamAllValuesOfport2(new Object[]{pPort1, pConnector, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for port2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfport2(final PortConnections.Match partialMatch) {
      return rawStreamAllValuesOfport2(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for port2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Port> getAllValuesOfport2(final Port pPort1, final Connector pConnector) {
      return rawStreamAllValuesOfport2(new Object[]{pPort1, pConnector, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected PortConnections.Match tupleToMatch(final Tuple t) {
      try {
          return PortConnections.Match.newMatch((Port) t.get(POSITION_PORT1), (Connector) t.get(POSITION_CONNECTOR), (Port) t.get(POSITION_PORT2));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PortConnections.Match arrayToMatch(final Object[] match) {
      try {
          return PortConnections.Match.newMatch((Port) match[POSITION_PORT1], (Connector) match[POSITION_CONNECTOR], (Port) match[POSITION_PORT2]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PortConnections.Match arrayToMatchMutable(final Object[] match) {
      try {
          return PortConnections.Match.newMutableMatch((Port) match[POSITION_PORT1], (Connector) match[POSITION_CONNECTOR], (Port) match[POSITION_PORT2]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<PortConnections.Matcher> querySpecification() {
      return PortConnections.instance();
    }
  }
  
  private PortConnections() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static PortConnections instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected PortConnections.Matcher instantiate(final ViatraQueryEngine engine) {
    return PortConnections.Matcher.on(engine);
  }
  
  @Override
  public PortConnections.Matcher instantiate() {
    return PortConnections.Matcher.create();
  }
  
  @Override
  public PortConnections.Match newEmptyMatch() {
    return PortConnections.Match.newEmptyMatch();
  }
  
  @Override
  public PortConnections.Match newMatch(final Object... parameters) {
    return PortConnections.Match.newMatch((com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port) parameters[0], (com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector) parameters[1], (com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: com.incquerylabs.v4md.test.queries.PortConnections (visibility: PUBLIC, simpleName: PortConnections, identifier: com.incquerylabs.v4md.test.queries.PortConnections, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: com.incquerylabs.v4md.test.queries.PortConnections (visibility: PUBLIC, simpleName: PortConnections, identifier: com.incquerylabs.v4md.test.queries.PortConnections, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static PortConnections INSTANCE = new PortConnections();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private final static Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static PortConnections.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pPort1 = new PParameter("port1", "com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Port")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pConnector = new PParameter("connector", "com.nomagic.uml2.ext.magicdraw.compositestructures.mdinternalstructures.Connector", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pPort2 = new PParameter("port2", "com.nomagic.uml2.ext.magicdraw.compositestructures.mdports.Port", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Port")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pPort1, parameter_pConnector, parameter_pPort2);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.PortConnections";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("port1","connector","port2");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() {
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_port1 = body.getOrCreateVariableByName("port1");
          PVariable var_connector = body.getOrCreateVariableByName("connector");
          PVariable var_port2 = body.getOrCreateVariableByName("port2");
          PVariable var_end1 = body.getOrCreateVariableByName("end1");
          PVariable var_end2 = body.getOrCreateVariableByName("end2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_port1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Port")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_connector), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_port2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Port")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_port1, parameter_pPort1),
             new ExportedParameter(body, var_connector, parameter_pConnector),
             new ExportedParameter(body, var_port2, parameter_pPort2)
          ));
          //     Connector.end(connector, end1)
          new TypeConstraint(body, Tuples.flatTupleOf(var_connector), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_connector, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector", "end")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ConnectorEnd")));
          new Equality(body, var__virtual_0_, var_end1);
          //     Connector.end(connector, end2)
          new TypeConstraint(body, Tuples.flatTupleOf(var_connector), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_connector, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Connector", "end")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ConnectorEnd")));
          new Equality(body, var__virtual_1_, var_end2);
          //         Port.end(port1, end1)
          new TypeConstraint(body, Tuples.flatTupleOf(var_port1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Port")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_port1, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ConnectableElement", "end")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ConnectorEnd")));
          new Equality(body, var__virtual_2_, var_end1);
          //     Port.end(port2, end2)
          new TypeConstraint(body, Tuples.flatTupleOf(var_port2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Port")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_port2, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ConnectableElement", "end")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "ConnectorEnd")));
          new Equality(body, var__virtual_3_, var_end2);
          //         port1 != port2
          new Inequality(body, var_port1, var_port2);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
