/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Block_With_More_than_1_Parent.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.GetSuperClasses;
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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.PatternMatchCounter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
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
 *         pattern BlocksWithDeepGeneralizationHierarchy(block : Class, superClass : Class) {
 *         	Class.appliedStereotypeInstance.classifier.name(block, "Block");
 *             parents == count find getSuperClasses(block, _);
 *             find getSuperClasses(block, superClass);
 *             check(parents {@literal >} 1);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class BlocksWithDeepGeneralizationHierarchy extends BaseGeneratedEMFQuerySpecification<BlocksWithDeepGeneralizationHierarchy.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.BlocksWithDeepGeneralizationHierarchy pattern,
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
    private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fBlock;
    
    private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fSuperClass;
    
    private static List<String> parameterNames = makeImmutableList("block", "superClass");
    
    private Match(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      this.fBlock = pBlock;
      this.fSuperClass = pSuperClass;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "block": return this.fBlock;
          case "superClass": return this.fSuperClass;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fBlock;
          case 1: return this.fSuperClass;
          default: return null;
      }
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getBlock() {
      return this.fBlock;
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getSuperClass() {
      return this.fSuperClass;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("block".equals(parameterName) ) {
          this.fBlock = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      if ("superClass".equals(parameterName) ) {
          this.fSuperClass = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      return false;
    }
    
    public void setBlock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fBlock = pBlock;
    }
    
    public void setSuperClass(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSuperClass = pSuperClass;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.BlocksWithDeepGeneralizationHierarchy";
    }
    
    @Override
    public List<String> parameterNames() {
      return BlocksWithDeepGeneralizationHierarchy.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fBlock, fSuperClass};
    }
    
    @Override
    public BlocksWithDeepGeneralizationHierarchy.Match toImmutable() {
      return isMutable() ? newMatch(fBlock, fSuperClass) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"block\"=" + prettyPrintValue(fBlock) + ", ");
      result.append("\"superClass\"=" + prettyPrintValue(fSuperClass));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fBlock, fSuperClass);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof BlocksWithDeepGeneralizationHierarchy.Match)) {
          BlocksWithDeepGeneralizationHierarchy.Match other = (BlocksWithDeepGeneralizationHierarchy.Match) obj;
          return Objects.equals(fBlock, other.fBlock) && Objects.equals(fSuperClass, other.fSuperClass);
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
    public BlocksWithDeepGeneralizationHierarchy specification() {
      return BlocksWithDeepGeneralizationHierarchy.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static BlocksWithDeepGeneralizationHierarchy.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static BlocksWithDeepGeneralizationHierarchy.Match newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      return new Mutable(pBlock, pSuperClass);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static BlocksWithDeepGeneralizationHierarchy.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      return new Immutable(pBlock, pSuperClass);
    }
    
    private static final class Mutable extends BlocksWithDeepGeneralizationHierarchy.Match {
      Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
        super(pBlock, pSuperClass);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends BlocksWithDeepGeneralizationHierarchy.Match {
      Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
        super(pBlock, pSuperClass);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.BlocksWithDeepGeneralizationHierarchy pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern BlocksWithDeepGeneralizationHierarchy(block : Class, superClass : Class) {
   * 	Class.appliedStereotypeInstance.classifier.name(block, "Block");
   *     parents == count find getSuperClasses(block, _);
   *     find getSuperClasses(block, superClass);
   *     check(parents {@literal >} 1);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see BlocksWithDeepGeneralizationHierarchy
   * 
   */
  public static class Matcher extends BaseMatcher<BlocksWithDeepGeneralizationHierarchy.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static BlocksWithDeepGeneralizationHierarchy.Matcher on(final ViatraQueryEngine engine) {
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
    public static BlocksWithDeepGeneralizationHierarchy.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_BLOCK = 0;
    
    private static final int POSITION_SUPERCLASS = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(BlocksWithDeepGeneralizationHierarchy.Matcher.class);
    
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
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<BlocksWithDeepGeneralizationHierarchy.Match> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      return rawStreamAllMatches(new Object[]{pBlock, pSuperClass}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<BlocksWithDeepGeneralizationHierarchy.Match> streamAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      return rawStreamAllMatches(new Object[]{pBlock, pSuperClass});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<BlocksWithDeepGeneralizationHierarchy.Match> getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      return rawGetOneArbitraryMatch(new Object[]{pBlock, pSuperClass});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      return rawHasMatch(new Object[]{pBlock, pSuperClass});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      return rawCountMatches(new Object[]{pBlock, pSuperClass});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass, final Consumer<? super BlocksWithDeepGeneralizationHierarchy.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pBlock, pSuperClass}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pSuperClass the fixed value of pattern parameter superClass, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public BlocksWithDeepGeneralizationHierarchy.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      return BlocksWithDeepGeneralizationHierarchy.Match.newMatch(pBlock, pSuperClass);
    }
    
    /**
     * Retrieve the set of values that occur in matches for block.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawStreamAllValuesOfblock(final Object[] parameters) {
      return rawStreamAllValues(POSITION_BLOCK, parameters).map(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for block.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock() {
      return rawStreamAllValuesOfblock(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for block.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfblock() {
      return rawStreamAllValuesOfblock(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for block.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfblock(final BlocksWithDeepGeneralizationHierarchy.Match partialMatch) {
      return rawStreamAllValuesOfblock(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for block.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfblock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      return rawStreamAllValuesOfblock(new Object[]{null, pSuperClass});
    }
    
    /**
     * Retrieve the set of values that occur in matches for block.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final BlocksWithDeepGeneralizationHierarchy.Match partialMatch) {
      return rawStreamAllValuesOfblock(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for block.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pSuperClass) {
      return rawStreamAllValuesOfblock(new Object[]{null, pSuperClass}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawStreamAllValuesOfsuperClass(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SUPERCLASS, parameters).map(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfsuperClass() {
      return rawStreamAllValuesOfsuperClass(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfsuperClass() {
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
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfsuperClass(final BlocksWithDeepGeneralizationHierarchy.Match partialMatch) {
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
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfsuperClass(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock) {
      return rawStreamAllValuesOfsuperClass(new Object[]{pBlock, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfsuperClass(final BlocksWithDeepGeneralizationHierarchy.Match partialMatch) {
      return rawStreamAllValuesOfsuperClass(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for superClass.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfsuperClass(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock) {
      return rawStreamAllValuesOfsuperClass(new Object[]{pBlock, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected BlocksWithDeepGeneralizationHierarchy.Match tupleToMatch(final Tuple t) {
      try {
          return BlocksWithDeepGeneralizationHierarchy.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_BLOCK), (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_SUPERCLASS));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected BlocksWithDeepGeneralizationHierarchy.Match arrayToMatch(final Object[] match) {
      try {
          return BlocksWithDeepGeneralizationHierarchy.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_SUPERCLASS]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected BlocksWithDeepGeneralizationHierarchy.Match arrayToMatchMutable(final Object[] match) {
      try {
          return BlocksWithDeepGeneralizationHierarchy.Match.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_SUPERCLASS]);
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
    public static IQuerySpecification<BlocksWithDeepGeneralizationHierarchy.Matcher> querySpecification() {
      return BlocksWithDeepGeneralizationHierarchy.instance();
    }
  }
  
  private BlocksWithDeepGeneralizationHierarchy() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static BlocksWithDeepGeneralizationHierarchy instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected BlocksWithDeepGeneralizationHierarchy.Matcher instantiate(final ViatraQueryEngine engine) {
    return BlocksWithDeepGeneralizationHierarchy.Matcher.on(engine);
  }
  
  @Override
  public BlocksWithDeepGeneralizationHierarchy.Matcher instantiate() {
    return BlocksWithDeepGeneralizationHierarchy.Matcher.create();
  }
  
  @Override
  public BlocksWithDeepGeneralizationHierarchy.Match newEmptyMatch() {
    return BlocksWithDeepGeneralizationHierarchy.Match.newEmptyMatch();
  }
  
  @Override
  public BlocksWithDeepGeneralizationHierarchy.Match newMatch(final Object... parameters) {
    return BlocksWithDeepGeneralizationHierarchy.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link BlocksWithDeepGeneralizationHierarchy} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link BlocksWithDeepGeneralizationHierarchy#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final BlocksWithDeepGeneralizationHierarchy INSTANCE = new BlocksWithDeepGeneralizationHierarchy();
    
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
    private static final BlocksWithDeepGeneralizationHierarchy.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_block = new PParameter("block", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_superClass = new PParameter("superClass", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_block, parameter_superClass);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.BlocksWithDeepGeneralizationHierarchy";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("block","superClass");
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
          PVariable var_block = body.getOrCreateVariableByName("block");
          PVariable var_superClass = body.getOrCreateVariableByName("superClass");
          PVariable var_parents = body.getOrCreateVariableByName("parents");
          PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
          new TypeConstraint(body, Tuples.flatTupleOf(var_block), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_superClass), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_block, parameter_block),
             new ExportedParameter(body, var_superClass, parameter_superClass)
          ));
          // 	Class.appliedStereotypeInstance.classifier.name(block, "Block")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "Block");
          new TypeConstraint(body, Tuples.flatTupleOf(var_block), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_block, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Element", "appliedStereotypeInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification", "classifier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "String")));
          new Equality(body, var__virtual_3_, var__virtual_0_);
          //     parents == count find getSuperClasses(block, _)
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new PatternMatchCounter(body, Tuples.flatTupleOf(var_block, var___0_), GetSuperClasses.instance().getInternalQueryRepresentation(), var__virtual_4_);
          new Equality(body, var_parents, var__virtual_4_);
          //     find getSuperClasses(block, superClass)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_block, var_superClass), GetSuperClasses.instance().getInternalQueryRepresentation());
          //     check(parents > 1)
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern BlocksWithDeepGeneralizationHierarchy";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("parents");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  Integer parents = (Integer) provider.getValue("parents");
                  return evaluateExpression_1_1(parents);
              }
          },  null); 
          bodies.add(body);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1(final Integer parents) {
    return ((parents).intValue() > 1);
  }
}
