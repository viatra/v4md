/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Aggregator_Functions.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.ClassNumberOfAttributes;
import com.incquerylabs.v4md.test.queries.Classes;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.AggregatorConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
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
 *         //Calculates average number of attributes per class in the model
 *         pattern averageNumberOfAttributes(number : java Float, s : java Integer, c : java Integer) {
 *         	//calculates sum
 *         	s == sum find classNumberOfAttributes(_c, #tempNumber);
 *         	//determines the number of classes
 *         	c == count find classes(_c2);
 *         	//Calculates average in an eval() expression
 *         	//similar to check() in an eval expression standard Java code can be used
 *         	number == eval(s.floatValue/c.floatValue);
 *             
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class AverageNumberOfAttributes extends BaseGeneratedEMFQuerySpecification<AverageNumberOfAttributes.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.averageNumberOfAttributes pattern,
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
    private Float fNumber;
    
    private Integer fS;
    
    private Integer fC;
    
    private static List<String> parameterNames = makeImmutableList("number", "s", "c");
    
    private Match(final Float pNumber, final Integer pS, final Integer pC) {
      this.fNumber = pNumber;
      this.fS = pS;
      this.fC = pC;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("number".equals(parameterName)) return this.fNumber;
      if ("s".equals(parameterName)) return this.fS;
      if ("c".equals(parameterName)) return this.fC;
      return null;
    }
    
    public Float getNumber() {
      return this.fNumber;
    }
    
    public Integer getS() {
      return this.fS;
    }
    
    public Integer getC() {
      return this.fC;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("number".equals(parameterName) ) {
          this.fNumber = (Float) newValue;
          return true;
      }
      if ("s".equals(parameterName) ) {
          this.fS = (Integer) newValue;
          return true;
      }
      if ("c".equals(parameterName) ) {
          this.fC = (Integer) newValue;
          return true;
      }
      return false;
    }
    
    public void setNumber(final Float pNumber) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fNumber = pNumber;
    }
    
    public void setS(final Integer pS) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fS = pS;
    }
    
    public void setC(final Integer pC) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fC = pC;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.averageNumberOfAttributes";
    }
    
    @Override
    public List<String> parameterNames() {
      return AverageNumberOfAttributes.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fNumber, fS, fC};
    }
    
    @Override
    public AverageNumberOfAttributes.Match toImmutable() {
      return isMutable() ? newMatch(fNumber, fS, fC) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"number\"=" + prettyPrintValue(fNumber) + ", ");
      result.append("\"s\"=" + prettyPrintValue(fS) + ", ");
      result.append("\"c\"=" + prettyPrintValue(fC));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fNumber, fS, fC);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof AverageNumberOfAttributes.Match)) {
          AverageNumberOfAttributes.Match other = (AverageNumberOfAttributes.Match) obj;
          return Objects.equals(fNumber, other.fNumber) && Objects.equals(fS, other.fS) && Objects.equals(fC, other.fC);
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
    public AverageNumberOfAttributes specification() {
      return AverageNumberOfAttributes.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static AverageNumberOfAttributes.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pNumber the fixed value of pattern parameter number, or null if not bound.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @param pC the fixed value of pattern parameter c, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static AverageNumberOfAttributes.Match newMutableMatch(final Float pNumber, final Integer pS, final Integer pC) {
      return new Mutable(pNumber, pS, pC);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pNumber the fixed value of pattern parameter number, or null if not bound.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @param pC the fixed value of pattern parameter c, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static AverageNumberOfAttributes.Match newMatch(final Float pNumber, final Integer pS, final Integer pC) {
      return new Immutable(pNumber, pS, pC);
    }
    
    private static final class Mutable extends AverageNumberOfAttributes.Match {
      Mutable(final Float pNumber, final Integer pS, final Integer pC) {
        super(pNumber, pS, pC);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends AverageNumberOfAttributes.Match {
      Immutable(final Float pNumber, final Integer pS, final Integer pC) {
        super(pNumber, pS, pC);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.averageNumberOfAttributes pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * //Calculates average number of attributes per class in the model
   * pattern averageNumberOfAttributes(number : java Float, s : java Integer, c : java Integer) {
   * 	//calculates sum
   * 	s == sum find classNumberOfAttributes(_c, #tempNumber);
   * 	//determines the number of classes
   * 	c == count find classes(_c2);
   * 	//Calculates average in an eval() expression
   * 	//similar to check() in an eval expression standard Java code can be used
   * 	number == eval(s.floatValue/c.floatValue);
   *     
   * }
   * </pre></code>
   * 
   * @see Match
   * @see AverageNumberOfAttributes
   * 
   */
  public static class Matcher extends BaseMatcher<AverageNumberOfAttributes.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static AverageNumberOfAttributes.Matcher on(final ViatraQueryEngine engine) {
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
    public static AverageNumberOfAttributes.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_NUMBER = 0;
    
    private final static int POSITION_S = 1;
    
    private final static int POSITION_C = 2;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(AverageNumberOfAttributes.Matcher.class);
    
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
     * @param pNumber the fixed value of pattern parameter number, or null if not bound.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @param pC the fixed value of pattern parameter c, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<AverageNumberOfAttributes.Match> getAllMatches(final Float pNumber, final Integer pS, final Integer pC) {
      return rawStreamAllMatches(new Object[]{pNumber, pS, pC}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pNumber the fixed value of pattern parameter number, or null if not bound.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @param pC the fixed value of pattern parameter c, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<AverageNumberOfAttributes.Match> streamAllMatches(final Float pNumber, final Integer pS, final Integer pC) {
      return rawStreamAllMatches(new Object[]{pNumber, pS, pC});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pNumber the fixed value of pattern parameter number, or null if not bound.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @param pC the fixed value of pattern parameter c, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<AverageNumberOfAttributes.Match> getOneArbitraryMatch(final Float pNumber, final Integer pS, final Integer pC) {
      return rawGetOneArbitraryMatch(new Object[]{pNumber, pS, pC});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pNumber the fixed value of pattern parameter number, or null if not bound.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @param pC the fixed value of pattern parameter c, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Float pNumber, final Integer pS, final Integer pC) {
      return rawHasMatch(new Object[]{pNumber, pS, pC});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pNumber the fixed value of pattern parameter number, or null if not bound.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @param pC the fixed value of pattern parameter c, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Float pNumber, final Integer pS, final Integer pC) {
      return rawCountMatches(new Object[]{pNumber, pS, pC});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pNumber the fixed value of pattern parameter number, or null if not bound.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @param pC the fixed value of pattern parameter c, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Float pNumber, final Integer pS, final Integer pC, final Consumer<? super AverageNumberOfAttributes.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pNumber, pS, pC}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pNumber the fixed value of pattern parameter number, or null if not bound.
     * @param pS the fixed value of pattern parameter s, or null if not bound.
     * @param pC the fixed value of pattern parameter c, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public AverageNumberOfAttributes.Match newMatch(final Float pNumber, final Integer pS, final Integer pC) {
      return AverageNumberOfAttributes.Match.newMatch(pNumber, pS, pC);
    }
    
    /**
     * Retrieve the set of values that occur in matches for number.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Float> rawStreamAllValuesOfnumber(final Object[] parameters) {
      return rawStreamAllValues(POSITION_NUMBER, parameters).map(Float.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for number.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Float> getAllValuesOfnumber() {
      return rawStreamAllValuesOfnumber(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for number.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Float> streamAllValuesOfnumber() {
      return rawStreamAllValuesOfnumber(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for number.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Float> streamAllValuesOfnumber(final AverageNumberOfAttributes.Match partialMatch) {
      return rawStreamAllValuesOfnumber(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for number.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Float> streamAllValuesOfnumber(final Integer pS, final Integer pC) {
      return rawStreamAllValuesOfnumber(new Object[]{null, pS, pC});
    }
    
    /**
     * Retrieve the set of values that occur in matches for number.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Float> getAllValuesOfnumber(final AverageNumberOfAttributes.Match partialMatch) {
      return rawStreamAllValuesOfnumber(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for number.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Float> getAllValuesOfnumber(final Integer pS, final Integer pC) {
      return rawStreamAllValuesOfnumber(new Object[]{null, pS, pC}).collect(Collectors.toSet());
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
    
    /**
     * Retrieve the set of values that occur in matches for s.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfs(final AverageNumberOfAttributes.Match partialMatch) {
      return rawStreamAllValuesOfs(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for s.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfs(final Float pNumber, final Integer pC) {
      return rawStreamAllValuesOfs(new Object[]{pNumber, null, pC});
    }
    
    /**
     * Retrieve the set of values that occur in matches for s.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfs(final AverageNumberOfAttributes.Match partialMatch) {
      return rawStreamAllValuesOfs(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for s.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfs(final Float pNumber, final Integer pC) {
      return rawStreamAllValuesOfs(new Object[]{pNumber, null, pC}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for c.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Integer> rawStreamAllValuesOfc(final Object[] parameters) {
      return rawStreamAllValues(POSITION_C, parameters).map(Integer.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for c.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfc() {
      return rawStreamAllValuesOfc(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for c.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfc() {
      return rawStreamAllValuesOfc(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for c.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfc(final AverageNumberOfAttributes.Match partialMatch) {
      return rawStreamAllValuesOfc(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for c.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Integer> streamAllValuesOfc(final Float pNumber, final Integer pS) {
      return rawStreamAllValuesOfc(new Object[]{pNumber, pS, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for c.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfc(final AverageNumberOfAttributes.Match partialMatch) {
      return rawStreamAllValuesOfc(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for c.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Integer> getAllValuesOfc(final Float pNumber, final Integer pS) {
      return rawStreamAllValuesOfc(new Object[]{pNumber, pS, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected AverageNumberOfAttributes.Match tupleToMatch(final Tuple t) {
      try {
          return AverageNumberOfAttributes.Match.newMatch((Float) t.get(POSITION_NUMBER), (Integer) t.get(POSITION_S), (Integer) t.get(POSITION_C));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AverageNumberOfAttributes.Match arrayToMatch(final Object[] match) {
      try {
          return AverageNumberOfAttributes.Match.newMatch((Float) match[POSITION_NUMBER], (Integer) match[POSITION_S], (Integer) match[POSITION_C]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected AverageNumberOfAttributes.Match arrayToMatchMutable(final Object[] match) {
      try {
          return AverageNumberOfAttributes.Match.newMutableMatch((Float) match[POSITION_NUMBER], (Integer) match[POSITION_S], (Integer) match[POSITION_C]);
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
    public static IQuerySpecification<AverageNumberOfAttributes.Matcher> querySpecification() {
      return AverageNumberOfAttributes.instance();
    }
  }
  
  private AverageNumberOfAttributes() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static AverageNumberOfAttributes instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected AverageNumberOfAttributes.Matcher instantiate(final ViatraQueryEngine engine) {
    return AverageNumberOfAttributes.Matcher.on(engine);
  }
  
  @Override
  public AverageNumberOfAttributes.Matcher instantiate() {
    return AverageNumberOfAttributes.Matcher.create();
  }
  
  @Override
  public AverageNumberOfAttributes.Match newEmptyMatch() {
    return AverageNumberOfAttributes.Match.newEmptyMatch();
  }
  
  @Override
  public AverageNumberOfAttributes.Match newMatch(final Object... parameters) {
    return AverageNumberOfAttributes.Match.newMatch((java.lang.Float) parameters[0], (java.lang.Integer) parameters[1], (java.lang.Integer) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: com.incquerylabs.v4md.test.queries.AverageNumberOfAttributes (visibility: PUBLIC, simpleName: AverageNumberOfAttributes, identifier: com.incquerylabs.v4md.test.queries.AverageNumberOfAttributes, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: com.incquerylabs.v4md.test.queries.AverageNumberOfAttributes (visibility: PUBLIC, simpleName: AverageNumberOfAttributes, identifier: com.incquerylabs.v4md.test.queries.AverageNumberOfAttributes, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static AverageNumberOfAttributes INSTANCE = new AverageNumberOfAttributes();
    
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
    private final static AverageNumberOfAttributes.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_number = new PParameter("number", "java.lang.Float", new JavaTransitiveInstancesKey(java.lang.Float.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_s = new PParameter("s", "java.lang.Integer", new JavaTransitiveInstancesKey(java.lang.Integer.class), PParameterDirection.INOUT);
    
    private final PParameter parameter_c = new PParameter("c", "java.lang.Integer", new JavaTransitiveInstancesKey(java.lang.Integer.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_number, parameter_s, parameter_c);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.averageNumberOfAttributes";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("number","s","c");
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
          PVariable var_number = body.getOrCreateVariableByName("number");
          PVariable var_s = body.getOrCreateVariableByName("s");
          PVariable var_c = body.getOrCreateVariableByName("c");
          PVariable var__c = body.getOrCreateVariableByName("_c");
          PVariable var__tempNumber = body.getOrCreateVariableByName("#tempNumber");
          PVariable var__c2 = body.getOrCreateVariableByName("_c2");
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_number), new JavaTransitiveInstancesKey(java.lang.Float.class));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_s), new JavaTransitiveInstancesKey(java.lang.Integer.class));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_c), new JavaTransitiveInstancesKey(java.lang.Integer.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_number, parameter_number),
             new ExportedParameter(body, var_s, parameter_s),
             new ExportedParameter(body, var_c, parameter_c)
          ));
          // 	//calculates sum	s == sum find classNumberOfAttributes(_c, #tempNumber)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new AggregatorConstraint(new sum().getAggregatorLogic(Integer.class), body, Tuples.flatTupleOf(var__c, var__tempNumber), ClassNumberOfAttributes.instance().getInternalQueryRepresentation(), var__virtual_0_, 1);
          new Equality(body, var_s, var__virtual_0_);
          // 	//determines the number of classes	c == count find classes(_c2)
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new PatternMatchCounter(body, Tuples.flatTupleOf(var__c2), Classes.instance().getInternalQueryRepresentation(), var__virtual_1_);
          new Equality(body, var_c, var__virtual_1_);
          // 	//Calculates average in an eval() expression	//similar to check() in an eval expression standard Java code can be used	number == eval(s.floatValue/c.floatValue)
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern averageNumberOfAttributes";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("c", "s");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  Integer c = (Integer) provider.getValue("c");
                  Integer s = (Integer) provider.getValue("s");
                  return evaluateExpression_1_1(c, s);
              }
          },  var__virtual_2_ ); 
          new Equality(body, var_number, var__virtual_2_);
          bodies.add(body);
      }
      return bodies;
    }
  }
  
  private static float evaluateExpression_1_1(final Integer c, final Integer s) {
    float _floatValue = s.floatValue();
    float _floatValue_1 = c.floatValue();
    float _divide = (_floatValue / _floatValue_1);
    return _divide;
  }
}
