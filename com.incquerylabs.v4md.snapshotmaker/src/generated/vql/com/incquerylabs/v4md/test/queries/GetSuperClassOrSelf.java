/**
 * Generated from platform:/resource/com.incquerylabs.v4md.snapshotmaker/src/main/java/com/incquerylabs/v4md/test/queries/Transitive_Closure.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.GetSuperClass;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
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
 *         Produce Class inheritance hierarchy
 *           'or' keyword represents an or relation between bodies --{@literal >} one of them needs to apply to the parameters for them to produce a match
 *           note that the transitive closure does not appear as parameters of a single match, but a number of matches in a following way:
 *           class1 --{@literal >} parent1
 *           class1 --{@literal >} parent2 
 *           ...
 *          
 *         pattern getSuperClassOrSelf(class : Classifier, superClass: Classifier) {
 *         	//  semantics for transitive closure can be implemented this way
 *         	// by default the transitive closure does not add the trivial relation to the TC
 *         	class == superClass;
 *         } or {
 *         	//transitive closure
 *         	find getSuperClass+(class, superClass);
 *         	
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class GetSuperClassOrSelf extends BaseGeneratedEMFQuerySpecification<GetSuperClassOrSelf.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.getSuperClassOrSelf pattern,
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
    private Classifier fClass;
    
    private Classifier fSuperClass;
    
    private static List<String> parameterNames = makeImmutableList("class", "superClass");
    
    private Match(final Classifier pClass, final Classifier pSuperClass) {
      this.fClass = pClass;
      this.fSuperClass = pSuperClass;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("class".equals(parameterName)) return this.fClass;
      if ("superClass".equals(parameterName)) return this.fSuperClass;
      return null;
    }
    
    public Classifier getValueOfClass() {
      return this.fClass;
    }
    
    public Classifier getSuperClass() {
      return this.fSuperClass;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("class".equals(parameterName) ) {
          this.fClass = (Classifier) newValue;
          return true;
      }
      if ("superClass".equals(parameterName) ) {
          this.fSuperClass = (Classifier) newValue;
          return true;
      }
      return false;
    }
    
    public void setClass(final Classifier pClass) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClass = pClass;
    }
    
    public void setSuperClass(final Classifier pSuperClass) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSuperClass = pSuperClass;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.getSuperClassOrSelf";
    }
    
    @Override
    public List<String> parameterNames() {
      return GetSuperClassOrSelf.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fClass, fSuperClass};
    }
    
    @Override
    public GetSuperClassOrSelf.Match toImmutable() {
      return isMutable() ? newMatch(fClass, fSuperClass) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"class\"=" + prettyPrintValue(fClass) + ", ");
      result.append("\"superClass\"=" + prettyPrintValue(fSuperClass));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fClass, fSuperClass);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof GetSuperClassOrSelf.Match)) {
          GetSuperClassOrSelf.Match other = (GetSuperClassOrSelf.Match) obj;
          return Objects.equals(fClass, other.fClass) && Objects.equals(fSuperClass, other.fSuperClass);
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
    public GetSuperClassOrSelf specification() {
      return GetSuperClassOrSelf.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static GetSuperClassOrSelf.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static GetSuperClassOrSelf.Match newMutableMatch(final Classifier pClass, final Classifier pSuperClass) {
      return new Mutable(pClass, pSuperClass);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static GetSuperClassOrSelf.Match newMatch(final Classifier pClass, final Classifier pSuperClass) {
      return new Immutable(pClass, pSuperClass);
    }
    
    private static final class Mutable extends GetSuperClassOrSelf.Match {
      Mutable(final Classifier pClass, final Classifier pSuperClass) {
        super(pClass, pSuperClass);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends GetSuperClassOrSelf.Match {
      Immutable(final Classifier pClass, final Classifier pSuperClass) {
        super(pClass, pSuperClass);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.getSuperClassOrSelf pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * Produce Class inheritance hierarchy
   *   'or' keyword represents an or relation between bodies --{@literal >} one of them needs to apply to the parameters for them to produce a match
   *   note that the transitive closure does not appear as parameters of a single match, but a number of matches in a following way:
   *   class1 --{@literal >} parent1
   *   class1 --{@literal >} parent2 
   *   ...
   *  
   * pattern getSuperClassOrSelf(class : Classifier, superClass: Classifier) {
   * 	//  semantics for transitive closure can be implemented this way
   * 	// by default the transitive closure does not add the trivial relation to the TC
   * 	class == superClass;
   * } or {
   * 	//transitive closure
   * 	find getSuperClass+(class, superClass);
   * 	
   * }
   * </pre></code>
   * 
   * @see Match
   * @see GetSuperClassOrSelf
   * 
   */
  public static class Matcher extends BaseMatcher<GetSuperClassOrSelf.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static GetSuperClassOrSelf.Matcher on(final ViatraQueryEngine engine) {
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
    public static GetSuperClassOrSelf.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_CLASS = 0;
    
    private final static int POSITION_SUPERCLASS = 1;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(GetSuperClassOrSelf.Matcher.class);
    
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
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<GetSuperClassOrSelf.Match> getAllMatches(final Classifier pClass, final Classifier pSuperClass) {
      return rawStreamAllMatches(new Object[]{pClass, pSuperClass}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<GetSuperClassOrSelf.Match> streamAllMatches(final Classifier pClass, final Classifier pSuperClass) {
      return rawStreamAllMatches(new Object[]{pClass, pSuperClass});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<GetSuperClassOrSelf.Match> getOneArbitraryMatch(final Classifier pClass, final Classifier pSuperClass) {
      return rawGetOneArbitraryMatch(new Object[]{pClass, pSuperClass});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Classifier pClass, final Classifier pSuperClass) {
      return rawHasMatch(new Object[]{pClass, pSuperClass});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Classifier pClass, final Classifier pSuperClass) {
      return rawCountMatches(new Object[]{pClass, pSuperClass});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Classifier pClass, final Classifier pSuperClass, final Consumer<? super GetSuperClassOrSelf.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pClass, pSuperClass}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClass the fixed value of pattern parameter class, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public GetSuperClassOrSelf.Match newMatch(final Classifier pClass, final Classifier pSuperClass) {
      return GetSuperClassOrSelf.Match.newMatch(pClass, pSuperClass);
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Classifier> rawStreamAllValuesOfclass(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CLASS, parameters).map(Classifier.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Classifier> getAllValuesOfclass() {
      return rawStreamAllValuesOfclass(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Classifier> streamAllValuesOfclass() {
      return rawStreamAllValuesOfclass(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Classifier> streamAllValuesOfclass(final GetSuperClassOrSelf.Match partialMatch) {
      return rawStreamAllValuesOfclass(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Classifier> streamAllValuesOfclass(final Classifier pSuperClass) {
      return rawStreamAllValuesOfclass(new Object[]{null, pSuperClass});
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Classifier> getAllValuesOfclass(final GetSuperClassOrSelf.Match partialMatch) {
      return rawStreamAllValuesOfclass(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Classifier> getAllValuesOfclass(final Classifier pSuperClass) {
      return rawStreamAllValuesOfclass(new Object[]{null, pSuperClass}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Classifier> rawStreamAllValuesOfsuperClass(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SUPERCLASS, parameters).map(Classifier.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Classifier> getAllValuesOfsuperClass() {
      return rawStreamAllValuesOfsuperClass(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Classifier> streamAllValuesOfsuperClass() {
      return rawStreamAllValuesOfsuperClass(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Classifier> streamAllValuesOfsuperClass(final GetSuperClassOrSelf.Match partialMatch) {
      return rawStreamAllValuesOfsuperClass(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Classifier> streamAllValuesOfsuperClass(final Classifier pClass) {
      return rawStreamAllValuesOfsuperClass(new Object[]{pClass, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Classifier> getAllValuesOfsuperClass(final GetSuperClassOrSelf.Match partialMatch) {
      return rawStreamAllValuesOfsuperClass(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Classifier> getAllValuesOfsuperClass(final Classifier pClass) {
      return rawStreamAllValuesOfsuperClass(new Object[]{pClass, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected GetSuperClassOrSelf.Match tupleToMatch(final Tuple t) {
      try {
          return GetSuperClassOrSelf.Match.newMatch((Classifier) t.get(POSITION_CLASS), (Classifier) t.get(POSITION_SUPERCLASS));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected GetSuperClassOrSelf.Match arrayToMatch(final Object[] match) {
      try {
          return GetSuperClassOrSelf.Match.newMatch((Classifier) match[POSITION_CLASS], (Classifier) match[POSITION_SUPERCLASS]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected GetSuperClassOrSelf.Match arrayToMatchMutable(final Object[] match) {
      try {
          return GetSuperClassOrSelf.Match.newMutableMatch((Classifier) match[POSITION_CLASS], (Classifier) match[POSITION_SUPERCLASS]);
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
    public static IQuerySpecification<GetSuperClassOrSelf.Matcher> querySpecification() {
      return GetSuperClassOrSelf.instance();
    }
  }
  
  private GetSuperClassOrSelf() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static GetSuperClassOrSelf instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected GetSuperClassOrSelf.Matcher instantiate(final ViatraQueryEngine engine) {
    return GetSuperClassOrSelf.Matcher.on(engine);
  }
  
  @Override
  public GetSuperClassOrSelf.Matcher instantiate() {
    return GetSuperClassOrSelf.Matcher.create();
  }
  
  @Override
  public GetSuperClassOrSelf.Match newEmptyMatch() {
    return GetSuperClassOrSelf.Match.newEmptyMatch();
  }
  
  @Override
  public GetSuperClassOrSelf.Match newMatch(final Object... parameters) {
    return GetSuperClassOrSelf.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: com.incquerylabs.v4md.test.queries.GetSuperClassOrSelf (visibility: PUBLIC, simpleName: GetSuperClassOrSelf, identifier: com.incquerylabs.v4md.test.queries.GetSuperClassOrSelf, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: com.incquerylabs.v4md.test.queries.GetSuperClassOrSelf (visibility: PUBLIC, simpleName: GetSuperClassOrSelf, identifier: com.incquerylabs.v4md.test.queries.GetSuperClassOrSelf, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static GetSuperClassOrSelf INSTANCE = new GetSuperClassOrSelf();
    
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
    private final static GetSuperClassOrSelf.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pClass = new PParameter("class", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pSuperClass = new PParameter("superClass", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Classifier", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pClass, parameter_pSuperClass);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.getSuperClassOrSelf";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("class","superClass");
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
          PVariable var_class = body.getOrCreateVariableByName("class");
          PVariable var_superClass = body.getOrCreateVariableByName("superClass");
          new TypeConstraint(body, Tuples.flatTupleOf(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_superClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_class, parameter_pClass),
             new ExportedParameter(body, var_superClass, parameter_pSuperClass)
          ));
          // 	// * semantics for transitive closure can be implemented this way	// by default the transitive closure does not add the trivial relation to the TC	class == superClass
          new Equality(body, var_class, var_superClass);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_class = body.getOrCreateVariableByName("class");
          PVariable var_superClass = body.getOrCreateVariableByName("superClass");
          new TypeConstraint(body, Tuples.flatTupleOf(var_class), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_superClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_class, parameter_pClass),
             new ExportedParameter(body, var_superClass, parameter_pSuperClass)
          ));
          // 	//transitive closure	find getSuperClass+(class, superClass)
          new BinaryTransitiveClosure(body, Tuples.flatTupleOf(var_class, var_superClass), GetSuperClass.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
