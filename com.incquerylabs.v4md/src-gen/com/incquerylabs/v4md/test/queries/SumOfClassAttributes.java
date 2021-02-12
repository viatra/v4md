/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Aggregator_Functions.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.ClassNumberOfAttributes;
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
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.matchers.aggregators.sum;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.AggregatorConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         //Sums the number of overall attributes of classes in the model
 *         pattern sumOfClassAttributes(s : java Integer) {
 *         	//use # to determine which parameter should be summarized
 *         	s == sum find classNumberOfAttributes(_c, #tempNumber);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class SumOfClassAttributes extends BaseGeneratedEMFQuerySpecification<SumOfClassAttributes.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.sumOfClassAttributes pattern,
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
    private Integer fS;
    
    private static List<String> parameterNames = makeImmutableList("s");
    
    private Match(final Integer pS) {
      this.fS = pS;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "s": return this.fS;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fS;
          default: return null;
      }
    }
    
    public Integer getS() {
      return this.fS;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("s".equals(parameterName) ) {
          this.fS = (Integer) newValue;
          return true;
      }
      return false;
    }
    
    public void setS(final Integer pS) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fS = pS;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.sumOfClassAttributes";
    }
    
    @Override
    public List<String> parameterNames() {
      return SumOfClassAttributes.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fS};
    }
    
    @Override
    public SumOfClassAttributes.Match toImmutable() {
      return isMutable() ? newMatch(fS) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"s\"=" + prettyPrintValue(fS));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fS);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SumOfClassAttributes.Match)) {
          SumOfClassAttributes.Match other = (SumOfClassAttributes.Match) obj;
          return Objects.equals(fS, other.fS);
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
    public SumOfClassAttributes specification() {
      return SumOfClassAttributes.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SumOfClassAttributes.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SumOfClassAttributes.Match newMutableMatch(final Integer pS) {
      return new Mutable(pS);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SumOfClassAttributes.Match newMatch(final Integer pS) {
      return new Immutable(pS);
    }
    
    private static final class Mutable extends SumOfClassAttributes.Match {
      Mutable(final Integer pS) {
        super(pS);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends SumOfClassAttributes.Match {
      Immutable(final Integer pS) {
        super(pS);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.sumOfClassAttributes pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * //Sums the number of overall attributes of classes in the model
   * pattern sumOfClassAttributes(s : java Integer) {
   * 	//use # to determine which parameter should be summarized
   * 	s == sum find classNumberOfAttributes(_c, #tempNumber);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SumOfClassAttributes
   * 
   */
  public static class Matcher extends BaseMatcher<SumOfClassAttributes.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SumOfClassAttributes.Matcher on(final ViatraQueryEngine engine) {
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
    public static SumOfClassAttributes.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_S = 0;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SumOfClassAttributes.Matcher.class);
    
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
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SumOfClassAttributes.Match> getAllMatches(final Integer pS) {
      return rawStreamAllMatches(new Object[]{pS}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SumOfClassAttributes.Match> streamAllMatches(final Integer pS) {
      return rawStreamAllMatches(new Object[]{pS});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SumOfClassAttributes.Match> getOneArbitraryMatch(final Integer pS) {
      return rawGetOneArbitraryMatch(new Object[]{pS});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Integer pS) {
      return rawHasMatch(new Object[]{pS});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Integer pS) {
      return rawCountMatches(new Object[]{pS});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Integer pS, final Consumer<? super SumOfClassAttributes.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pS}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SumOfClassAttributes.Match newMatch(final Integer pS) {
      return SumOfClassAttributes.Match.newMatch(pS);
    }
    
    /**
     * Retrieve the set of values that occur in matches for s.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Integer> rawStreamAllValuesOfs(final Object[] parameters) {
      return rawStreamAllValues(POSITION_S, parameters).map(Integer.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for s.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfs() {
      return rawStreamAllValuesOfs(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for s.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfs() {
      return rawStreamAllValuesOfs(emptyArray());
    }
    
    @Override
    protected SumOfClassAttributes.Match tupleToMatch(final Tuple t) {
      try {
          return SumOfClassAttributes.Match.newMatch((Integer) t.get(POSITION_S));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected SumOfClassAttributes.Match arrayToMatch(final Object[] match) {
      try {
          return SumOfClassAttributes.Match.newMatch((Integer) match[POSITION_S]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected SumOfClassAttributes.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SumOfClassAttributes.Match.newMutableMatch((Integer) match[POSITION_S]);
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
    public static IQuerySpecification<SumOfClassAttributes.Matcher> querySpecification() {
      return SumOfClassAttributes.instance();
    }
  }
  
  private SumOfClassAttributes() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SumOfClassAttributes instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected SumOfClassAttributes.Matcher instantiate(final ViatraQueryEngine engine) {
    return SumOfClassAttributes.Matcher.on(engine);
  }
  
  @Override
  public SumOfClassAttributes.Matcher instantiate() {
    return SumOfClassAttributes.Matcher.create();
  }
  
  @Override
  public SumOfClassAttributes.Match newEmptyMatch() {
    return SumOfClassAttributes.Match.newEmptyMatch();
  }
  
  @Override
  public SumOfClassAttributes.Match newMatch(final Object... parameters) {
    return SumOfClassAttributes.Match.newMatch((java.lang.Integer) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link SumOfClassAttributes} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SumOfClassAttributes#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SumOfClassAttributes INSTANCE = new SumOfClassAttributes();
    
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
    private static final SumOfClassAttributes.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_s = new PParameter("s", "java.lang.Integer", new JavaTransitiveInstancesKey(java.lang.Integer.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_s);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.sumOfClassAttributes";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("s");
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
          PVariable var_s = body.getOrCreateVariableByName("s");
          PVariable var__c = body.getOrCreateVariableByName("_c");
          PVariable var__tempNumber = body.getOrCreateVariableByName("#tempNumber");
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_s), new JavaTransitiveInstancesKey(java.lang.Integer.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_s, parameter_s)
          ));
          // 	//use # to determine which parameter should be summarized	s == sum find classNumberOfAttributes(_c, #tempNumber)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new AggregatorConstraint(new sum().getAggregatorLogic(Integer.class), body, Tuples.flatTupleOf(var__c, var__tempNumber), ClassNumberOfAttributes.instance().getInternalQueryRepresentation(), var__virtual_0_, 1);
          new Equality(body, var_s, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
