/**
 * Generated from platform:/resource/com.incquerylabs.v4md.snapshotmaker/src/main/java/com/incquerylabs/v4md/test/queries/Block_With_More_than_1_Parent.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.GetSuperClass;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
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
 *         pattern MultipleInheritanceBlock(block : Class, parent1 : Class){
 *         	Class.appliedStereotypeInstance.classifier.name(block, "Block");
 *         	find getSuperClass(block, parent1);
 *         	find getSuperClass(block, parent2);
 *         	parent1 != parent2;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class MultipleInheritanceBlock extends BaseGeneratedEMFQuerySpecification<MultipleInheritanceBlock.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.MultipleInheritanceBlock pattern,
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
    
    private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fParent1;
    
    private static List<String> parameterNames = makeImmutableList("block", "parent1");
    
    private Match(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      this.fBlock = pBlock;
      this.fParent1 = pParent1;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("block".equals(parameterName)) return this.fBlock;
      if ("parent1".equals(parameterName)) return this.fParent1;
      return null;
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getBlock() {
      return this.fBlock;
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getParent1() {
      return this.fParent1;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("block".equals(parameterName) ) {
          this.fBlock = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      if ("parent1".equals(parameterName) ) {
          this.fParent1 = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      return false;
    }
    
    public void setBlock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fBlock = pBlock;
    }
    
    public void setParent1(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fParent1 = pParent1;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.MultipleInheritanceBlock";
    }
    
    @Override
    public List<String> parameterNames() {
      return MultipleInheritanceBlock.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fBlock, fParent1};
    }
    
    @Override
    public MultipleInheritanceBlock.Match toImmutable() {
      return isMutable() ? newMatch(fBlock, fParent1) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"block\"=" + prettyPrintValue(fBlock) + ", ");
      result.append("\"parent1\"=" + prettyPrintValue(fParent1));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fBlock, fParent1);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof MultipleInheritanceBlock.Match)) {
          MultipleInheritanceBlock.Match other = (MultipleInheritanceBlock.Match) obj;
          return Objects.equals(fBlock, other.fBlock) && Objects.equals(fParent1, other.fParent1);
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
    public MultipleInheritanceBlock specification() {
      return MultipleInheritanceBlock.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static MultipleInheritanceBlock.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static MultipleInheritanceBlock.Match newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      return new Mutable(pBlock, pParent1);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static MultipleInheritanceBlock.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      return new Immutable(pBlock, pParent1);
    }
    
    private static final class Mutable extends MultipleInheritanceBlock.Match {
      Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
        super(pBlock, pParent1);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends MultipleInheritanceBlock.Match {
      Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
        super(pBlock, pParent1);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.MultipleInheritanceBlock pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern MultipleInheritanceBlock(block : Class, parent1 : Class){
   * 	Class.appliedStereotypeInstance.classifier.name(block, "Block");
   * 	find getSuperClass(block, parent1);
   * 	find getSuperClass(block, parent2);
   * 	parent1 != parent2;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see MultipleInheritanceBlock
   * 
   */
  public static class Matcher extends BaseMatcher<MultipleInheritanceBlock.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static MultipleInheritanceBlock.Matcher on(final ViatraQueryEngine engine) {
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
    public static MultipleInheritanceBlock.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_BLOCK = 0;
    
    private final static int POSITION_PARENT1 = 1;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(MultipleInheritanceBlock.Matcher.class);
    
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
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<MultipleInheritanceBlock.Match> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      return rawStreamAllMatches(new Object[]{pBlock, pParent1}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<MultipleInheritanceBlock.Match> streamAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      return rawStreamAllMatches(new Object[]{pBlock, pParent1});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<MultipleInheritanceBlock.Match> getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      return rawGetOneArbitraryMatch(new Object[]{pBlock, pParent1});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      return rawHasMatch(new Object[]{pBlock, pParent1});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      return rawCountMatches(new Object[]{pBlock, pParent1});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1, final Consumer<? super MultipleInheritanceBlock.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pBlock, pParent1}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pBlock the fixed value of pattern parameter block, or null if not bound.
     * @param pParent1 the fixed value of pattern parameter parent1, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public MultipleInheritanceBlock.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      return MultipleInheritanceBlock.Match.newMatch(pBlock, pParent1);
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
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfblock(final MultipleInheritanceBlock.Match partialMatch) {
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
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfblock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      return rawStreamAllValuesOfblock(new Object[]{null, pParent1});
    }
    
    /**
     * Retrieve the set of values that occur in matches for block.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final MultipleInheritanceBlock.Match partialMatch) {
      return rawStreamAllValuesOfblock(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for block.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfblock(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pParent1) {
      return rawStreamAllValuesOfblock(new Object[]{null, pParent1}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for parent1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawStreamAllValuesOfparent1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PARENT1, parameters).map(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for parent1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfparent1() {
      return rawStreamAllValuesOfparent1(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for parent1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfparent1() {
      return rawStreamAllValuesOfparent1(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for parent1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfparent1(final MultipleInheritanceBlock.Match partialMatch) {
      return rawStreamAllValuesOfparent1(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for parent1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfparent1(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock) {
      return rawStreamAllValuesOfparent1(new Object[]{pBlock, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for parent1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfparent1(final MultipleInheritanceBlock.Match partialMatch) {
      return rawStreamAllValuesOfparent1(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for parent1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfparent1(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pBlock) {
      return rawStreamAllValuesOfparent1(new Object[]{pBlock, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected MultipleInheritanceBlock.Match tupleToMatch(final Tuple t) {
      try {
          return MultipleInheritanceBlock.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_BLOCK), (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_PARENT1));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected MultipleInheritanceBlock.Match arrayToMatch(final Object[] match) {
      try {
          return MultipleInheritanceBlock.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_PARENT1]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected MultipleInheritanceBlock.Match arrayToMatchMutable(final Object[] match) {
      try {
          return MultipleInheritanceBlock.Match.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_BLOCK], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_PARENT1]);
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
    public static IQuerySpecification<MultipleInheritanceBlock.Matcher> querySpecification() {
      return MultipleInheritanceBlock.instance();
    }
  }
  
  private MultipleInheritanceBlock() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static MultipleInheritanceBlock instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected MultipleInheritanceBlock.Matcher instantiate(final ViatraQueryEngine engine) {
    return MultipleInheritanceBlock.Matcher.on(engine);
  }
  
  @Override
  public MultipleInheritanceBlock.Matcher instantiate() {
    return MultipleInheritanceBlock.Matcher.create();
  }
  
  @Override
  public MultipleInheritanceBlock.Match newEmptyMatch() {
    return MultipleInheritanceBlock.Match.newEmptyMatch();
  }
  
  @Override
  public MultipleInheritanceBlock.Match newMatch(final Object... parameters) {
    return MultipleInheritanceBlock.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: com.incquerylabs.v4md.test.queries.MultipleInheritanceBlock (visibility: PUBLIC, simpleName: MultipleInheritanceBlock, identifier: com.incquerylabs.v4md.test.queries.MultipleInheritanceBlock, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: com.incquerylabs.v4md.test.queries.MultipleInheritanceBlock (visibility: PUBLIC, simpleName: MultipleInheritanceBlock, identifier: com.incquerylabs.v4md.test.queries.MultipleInheritanceBlock, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static MultipleInheritanceBlock INSTANCE = new MultipleInheritanceBlock();
    
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
    private final static MultipleInheritanceBlock.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_block = new PParameter("block", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_parent1 = new PParameter("parent1", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_block, parameter_parent1);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.MultipleInheritanceBlock";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("block","parent1");
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
          PVariable var_parent1 = body.getOrCreateVariableByName("parent1");
          PVariable var_parent2 = body.getOrCreateVariableByName("parent2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_block), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_parent1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_block, parameter_block),
             new ExportedParameter(body, var_parent1, parameter_parent1)
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
          // 	find getSuperClass(block, parent1)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_block, var_parent1), GetSuperClass.instance().getInternalQueryRepresentation());
          // 	find getSuperClass(block, parent2)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_block, var_parent2), GetSuperClass.instance().getInternalQueryRepresentation());
          // 	parent1 != parent2
          new Inequality(body, var_parent1, var_parent2);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
