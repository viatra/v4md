/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Unreachable_States.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex;
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
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
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
 *         pattern reachableState(sourceState : Vertex, targetState : Vertex) {
 *             Transition.source(transition, sourceState);
 *             Transition.target(transition, targetState);
 *             sourceState != targetState;
 *             
 *             
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ReachableState extends BaseGeneratedEMFQuerySpecification<ReachableState.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.reachableState pattern,
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
    private Vertex fSourceState;
    
    private Vertex fTargetState;
    
    private static List<String> parameterNames = makeImmutableList("sourceState", "targetState");
    
    private Match(final Vertex pSourceState, final Vertex pTargetState) {
      this.fSourceState = pSourceState;
      this.fTargetState = pTargetState;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("sourceState".equals(parameterName)) return this.fSourceState;
      if ("targetState".equals(parameterName)) return this.fTargetState;
      return null;
    }
    
    public Vertex getSourceState() {
      return this.fSourceState;
    }
    
    public Vertex getTargetState() {
      return this.fTargetState;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("sourceState".equals(parameterName) ) {
          this.fSourceState = (Vertex) newValue;
          return true;
      }
      if ("targetState".equals(parameterName) ) {
          this.fTargetState = (Vertex) newValue;
          return true;
      }
      return false;
    }
    
    public void setSourceState(final Vertex pSourceState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSourceState = pSourceState;
    }
    
    public void setTargetState(final Vertex pTargetState) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTargetState = pTargetState;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.reachableState";
    }
    
    @Override
    public List<String> parameterNames() {
      return ReachableState.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fSourceState, fTargetState};
    }
    
    @Override
    public ReachableState.Match toImmutable() {
      return isMutable() ? newMatch(fSourceState, fTargetState) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"sourceState\"=" + prettyPrintValue(fSourceState) + ", ");
      result.append("\"targetState\"=" + prettyPrintValue(fTargetState));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fSourceState, fTargetState);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ReachableState.Match)) {
          ReachableState.Match other = (ReachableState.Match) obj;
          return Objects.equals(fSourceState, other.fSourceState) && Objects.equals(fTargetState, other.fTargetState);
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
    public ReachableState specification() {
      return ReachableState.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ReachableState.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
     * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ReachableState.Match newMutableMatch(final Vertex pSourceState, final Vertex pTargetState) {
      return new Mutable(pSourceState, pTargetState);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
     * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ReachableState.Match newMatch(final Vertex pSourceState, final Vertex pTargetState) {
      return new Immutable(pSourceState, pTargetState);
    }
    
    private static final class Mutable extends ReachableState.Match {
      Mutable(final Vertex pSourceState, final Vertex pTargetState) {
        super(pSourceState, pTargetState);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ReachableState.Match {
      Immutable(final Vertex pSourceState, final Vertex pTargetState) {
        super(pSourceState, pTargetState);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.reachableState pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern reachableState(sourceState : Vertex, targetState : Vertex) {
   *     Transition.source(transition, sourceState);
   *     Transition.target(transition, targetState);
   *     sourceState != targetState;
   *     
   *     
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ReachableState
   * 
   */
  public static class Matcher extends BaseMatcher<ReachableState.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ReachableState.Matcher on(final ViatraQueryEngine engine) {
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
    public static ReachableState.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_SOURCESTATE = 0;
    
    private static final int POSITION_TARGETSTATE = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ReachableState.Matcher.class);
    
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
     * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
     * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ReachableState.Match> getAllMatches(final Vertex pSourceState, final Vertex pTargetState) {
      return rawStreamAllMatches(new Object[]{pSourceState, pTargetState}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
     * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ReachableState.Match> streamAllMatches(final Vertex pSourceState, final Vertex pTargetState) {
      return rawStreamAllMatches(new Object[]{pSourceState, pTargetState});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
     * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ReachableState.Match> getOneArbitraryMatch(final Vertex pSourceState, final Vertex pTargetState) {
      return rawGetOneArbitraryMatch(new Object[]{pSourceState, pTargetState});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
     * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Vertex pSourceState, final Vertex pTargetState) {
      return rawHasMatch(new Object[]{pSourceState, pTargetState});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
     * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Vertex pSourceState, final Vertex pTargetState) {
      return rawCountMatches(new Object[]{pSourceState, pTargetState});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
     * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Vertex pSourceState, final Vertex pTargetState, final Consumer<? super ReachableState.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSourceState, pTargetState}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSourceState the fixed value of pattern parameter sourceState, or null if not bound.
     * @param pTargetState the fixed value of pattern parameter targetState, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ReachableState.Match newMatch(final Vertex pSourceState, final Vertex pTargetState) {
      return ReachableState.Match.newMatch(pSourceState, pTargetState);
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Vertex> rawStreamAllValuesOfsourceState(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SOURCESTATE, parameters).map(Vertex.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOfsourceState() {
      return rawStreamAllValuesOfsourceState(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOfsourceState() {
      return rawStreamAllValuesOfsourceState(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOfsourceState(final ReachableState.Match partialMatch) {
      return rawStreamAllValuesOfsourceState(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOfsourceState(final Vertex pTargetState) {
      return rawStreamAllValuesOfsourceState(new Object[]{null, pTargetState});
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOfsourceState(final ReachableState.Match partialMatch) {
      return rawStreamAllValuesOfsourceState(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for sourceState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOfsourceState(final Vertex pTargetState) {
      return rawStreamAllValuesOfsourceState(new Object[]{null, pTargetState}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Vertex> rawStreamAllValuesOftargetState(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TARGETSTATE, parameters).map(Vertex.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOftargetState() {
      return rawStreamAllValuesOftargetState(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOftargetState() {
      return rawStreamAllValuesOftargetState(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOftargetState(final ReachableState.Match partialMatch) {
      return rawStreamAllValuesOftargetState(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetState.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vertex> streamAllValuesOftargetState(final Vertex pSourceState) {
      return rawStreamAllValuesOftargetState(new Object[]{pSourceState, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOftargetState(final ReachableState.Match partialMatch) {
      return rawStreamAllValuesOftargetState(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for targetState.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vertex> getAllValuesOftargetState(final Vertex pSourceState) {
      return rawStreamAllValuesOftargetState(new Object[]{pSourceState, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ReachableState.Match tupleToMatch(final Tuple t) {
      try {
          return ReachableState.Match.newMatch((Vertex) t.get(POSITION_SOURCESTATE), (Vertex) t.get(POSITION_TARGETSTATE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ReachableState.Match arrayToMatch(final Object[] match) {
      try {
          return ReachableState.Match.newMatch((Vertex) match[POSITION_SOURCESTATE], (Vertex) match[POSITION_TARGETSTATE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ReachableState.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ReachableState.Match.newMutableMatch((Vertex) match[POSITION_SOURCESTATE], (Vertex) match[POSITION_TARGETSTATE]);
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
    public static IQuerySpecification<ReachableState.Matcher> querySpecification() {
      return ReachableState.instance();
    }
  }
  
  private ReachableState() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ReachableState instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ReachableState.Matcher instantiate(final ViatraQueryEngine engine) {
    return ReachableState.Matcher.on(engine);
  }
  
  @Override
  public ReachableState.Matcher instantiate() {
    return ReachableState.Matcher.create();
  }
  
  @Override
  public ReachableState.Match newEmptyMatch() {
    return ReachableState.Match.newEmptyMatch();
  }
  
  @Override
  public ReachableState.Match newMatch(final Object... parameters) {
    return ReachableState.Match.newMatch((com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex) parameters[0], (com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: com.incquerylabs.v4md.test.queries.ReachableState (visibility: PUBLIC, simpleName: ReachableState, identifier: com.incquerylabs.v4md.test.queries.ReachableState, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: com.incquerylabs.v4md.test.queries.ReachableState (visibility: PUBLIC, simpleName: ReachableState, identifier: com.incquerylabs.v4md.test.queries.ReachableState, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ReachableState INSTANCE = new ReachableState();
    
    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();
    
    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final ReachableState.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_sourceState = new PParameter("sourceState", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")), PParameterDirection.INOUT);
    
    private final PParameter parameter_targetState = new PParameter("targetState", "com.nomagic.uml2.ext.magicdraw.statemachines.mdbehaviorstatemachines.Vertex", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_sourceState, parameter_targetState);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.reachableState";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sourceState","targetState");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_sourceState = body.getOrCreateVariableByName("sourceState");
          PVariable var_targetState = body.getOrCreateVariableByName("targetState");
          PVariable var_transition = body.getOrCreateVariableByName("transition");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sourceState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_targetState), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_sourceState, parameter_sourceState),
             new ExportedParameter(body, var_targetState, parameter_targetState)
          ));
          //     Transition.source(transition, sourceState)
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition", "source")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_0_, var_sourceState);
          //     Transition.target(transition, targetState)
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_transition, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Transition", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Vertex")));
          new Equality(body, var__virtual_1_, var_targetState);
          //     sourceState != targetState
          new Inequality(body, var_sourceState, var_targetState);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
