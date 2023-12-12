/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Pattern_Constraints.vql
 */
package com.incquerylabs.v4md.test.queries;

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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
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
 *         //Classes that have attributes that have the same name
 *         pattern classesWithSameNamedProperty(class1 : Class, class2 : Class, name : java String){
 *         	//using the 'name' parameter in both places will ensure that the name is the same
 *         	Class.ownedAttribute.name(class1, name);
 *         	Class.ownedAttribute.name(class2, name);
 *         	//Ensure that they are not the same class
 *         	class1 != class2;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class ClassesWithSameNamedProperty extends BaseGeneratedEMFQuerySpecification<ClassesWithSameNamedProperty.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.classesWithSameNamedProperty pattern,
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
    private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fClass1;
    
    private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fClass2;
    
    private String fName;
    
    private static List<String> parameterNames = makeImmutableList("class1", "class2", "name");
    
    private Match(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      this.fClass1 = pClass1;
      this.fClass2 = pClass2;
      this.fName = pName;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "class1": return this.fClass1;
          case "class2": return this.fClass2;
          case "name": return this.fName;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fClass1;
          case 1: return this.fClass2;
          case 2: return this.fName;
          default: return null;
      }
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getClass1() {
      return this.fClass1;
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getClass2() {
      return this.fClass2;
    }
    
    public String getName() {
      return this.fName;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("class1".equals(parameterName) ) {
          this.fClass1 = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      if ("class2".equals(parameterName) ) {
          this.fClass2 = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      if ("name".equals(parameterName) ) {
          this.fName = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setClass1(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClass1 = pClass1;
    }
    
    public void setClass2(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fClass2 = pClass2;
    }
    
    public void setName(final String pName) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fName = pName;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.classesWithSameNamedProperty";
    }
    
    @Override
    public List<String> parameterNames() {
      return ClassesWithSameNamedProperty.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fClass1, fClass2, fName};
    }
    
    @Override
    public ClassesWithSameNamedProperty.Match toImmutable() {
      return isMutable() ? newMatch(fClass1, fClass2, fName) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"class1\"=" + prettyPrintValue(fClass1) + ", ");
      result.append("\"class2\"=" + prettyPrintValue(fClass2) + ", ");
      result.append("\"name\"=" + prettyPrintValue(fName));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fClass1, fClass2, fName);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof ClassesWithSameNamedProperty.Match)) {
          ClassesWithSameNamedProperty.Match other = (ClassesWithSameNamedProperty.Match) obj;
          return Objects.equals(fClass1, other.fClass1) && Objects.equals(fClass2, other.fClass2) && Objects.equals(fName, other.fName);
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
    public ClassesWithSameNamedProperty specification() {
      return ClassesWithSameNamedProperty.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static ClassesWithSameNamedProperty.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pClass1 the fixed value of pattern parameter class1, or null if not bound.
     * @param pClass2 the fixed value of pattern parameter class2, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static ClassesWithSameNamedProperty.Match newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      return new Mutable(pClass1, pClass2, pName);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClass1 the fixed value of pattern parameter class1, or null if not bound.
     * @param pClass2 the fixed value of pattern parameter class2, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static ClassesWithSameNamedProperty.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      return new Immutable(pClass1, pClass2, pName);
    }
    
    private static final class Mutable extends ClassesWithSameNamedProperty.Match {
      Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
        super(pClass1, pClass2, pName);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends ClassesWithSameNamedProperty.Match {
      Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
        super(pClass1, pClass2, pName);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.classesWithSameNamedProperty pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * //Classes that have attributes that have the same name
   * pattern classesWithSameNamedProperty(class1 : Class, class2 : Class, name : java String){
   * 	//using the 'name' parameter in both places will ensure that the name is the same
   * 	Class.ownedAttribute.name(class1, name);
   * 	Class.ownedAttribute.name(class2, name);
   * 	//Ensure that they are not the same class
   * 	class1 != class2;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see ClassesWithSameNamedProperty
   * 
   */
  public static class Matcher extends BaseMatcher<ClassesWithSameNamedProperty.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static ClassesWithSameNamedProperty.Matcher on(final ViatraQueryEngine engine) {
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
    public static ClassesWithSameNamedProperty.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_CLASS1 = 0;
    
    private static final int POSITION_CLASS2 = 1;
    
    private static final int POSITION_NAME = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(ClassesWithSameNamedProperty.Matcher.class);
    
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
     * @param pClass1 the fixed value of pattern parameter class1, or null if not bound.
     * @param pClass2 the fixed value of pattern parameter class2, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<ClassesWithSameNamedProperty.Match> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      return rawStreamAllMatches(new Object[]{pClass1, pClass2, pName}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pClass1 the fixed value of pattern parameter class1, or null if not bound.
     * @param pClass2 the fixed value of pattern parameter class2, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<ClassesWithSameNamedProperty.Match> streamAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      return rawStreamAllMatches(new Object[]{pClass1, pClass2, pName});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClass1 the fixed value of pattern parameter class1, or null if not bound.
     * @param pClass2 the fixed value of pattern parameter class2, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<ClassesWithSameNamedProperty.Match> getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      return rawGetOneArbitraryMatch(new Object[]{pClass1, pClass2, pName});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pClass1 the fixed value of pattern parameter class1, or null if not bound.
     * @param pClass2 the fixed value of pattern parameter class2, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      return rawHasMatch(new Object[]{pClass1, pClass2, pName});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pClass1 the fixed value of pattern parameter class1, or null if not bound.
     * @param pClass2 the fixed value of pattern parameter class2, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      return rawCountMatches(new Object[]{pClass1, pClass2, pName});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pClass1 the fixed value of pattern parameter class1, or null if not bound.
     * @param pClass2 the fixed value of pattern parameter class2, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName, final Consumer<? super ClassesWithSameNamedProperty.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pClass1, pClass2, pName}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pClass1 the fixed value of pattern parameter class1, or null if not bound.
     * @param pClass2 the fixed value of pattern parameter class2, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public ClassesWithSameNamedProperty.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      return ClassesWithSameNamedProperty.Match.newMatch(pClass1, pClass2, pName);
    }
    
    /**
     * Retrieve the set of values that occur in matches for class1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawStreamAllValuesOfclass1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CLASS1, parameters).map(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for class1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfclass1() {
      return rawStreamAllValuesOfclass1(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfclass1() {
      return rawStreamAllValuesOfclass1(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfclass1(final ClassesWithSameNamedProperty.Match partialMatch) {
      return rawStreamAllValuesOfclass1(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfclass1(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      return rawStreamAllValuesOfclass1(new Object[]{null, pClass2, pName});
    }
    
    /**
     * Retrieve the set of values that occur in matches for class1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfclass1(final ClassesWithSameNamedProperty.Match partialMatch) {
      return rawStreamAllValuesOfclass1(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfclass1(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2, final String pName) {
      return rawStreamAllValuesOfclass1(new Object[]{null, pClass2, pName}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawStreamAllValuesOfclass2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_CLASS2, parameters).map(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for class2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfclass2() {
      return rawStreamAllValuesOfclass2(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfclass2() {
      return rawStreamAllValuesOfclass2(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfclass2(final ClassesWithSameNamedProperty.Match partialMatch) {
      return rawStreamAllValuesOfclass2(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfclass2(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final String pName) {
      return rawStreamAllValuesOfclass2(new Object[]{pClass1, null, pName});
    }
    
    /**
     * Retrieve the set of values that occur in matches for class2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfclass2(final ClassesWithSameNamedProperty.Match partialMatch) {
      return rawStreamAllValuesOfclass2(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for class2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfclass2(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final String pName) {
      return rawStreamAllValuesOfclass2(new Object[]{pClass1, null, pName}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<String> rawStreamAllValuesOfname(final Object[] parameters) {
      return rawStreamAllValues(POSITION_NAME, parameters).map(String.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfname() {
      return rawStreamAllValuesOfname(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfname() {
      return rawStreamAllValuesOfname(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for name.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfname(final ClassesWithSameNamedProperty.Match partialMatch) {
      return rawStreamAllValuesOfname(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for name.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<String> streamAllValuesOfname(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2) {
      return rawStreamAllValuesOfname(new Object[]{pClass1, pClass2, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfname(final ClassesWithSameNamedProperty.Match partialMatch) {
      return rawStreamAllValuesOfname(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfname(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass1, final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pClass2) {
      return rawStreamAllValuesOfname(new Object[]{pClass1, pClass2, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected ClassesWithSameNamedProperty.Match tupleToMatch(final Tuple t) {
      try {
          return ClassesWithSameNamedProperty.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_CLASS1), (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_CLASS2), (String) t.get(POSITION_NAME));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ClassesWithSameNamedProperty.Match arrayToMatch(final Object[] match) {
      try {
          return ClassesWithSameNamedProperty.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_CLASS1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_CLASS2], (String) match[POSITION_NAME]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected ClassesWithSameNamedProperty.Match arrayToMatchMutable(final Object[] match) {
      try {
          return ClassesWithSameNamedProperty.Match.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_CLASS1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_CLASS2], (String) match[POSITION_NAME]);
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
    public static IQuerySpecification<ClassesWithSameNamedProperty.Matcher> querySpecification() {
      return ClassesWithSameNamedProperty.instance();
    }
  }
  
  private ClassesWithSameNamedProperty() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static ClassesWithSameNamedProperty instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected ClassesWithSameNamedProperty.Matcher instantiate(final ViatraQueryEngine engine) {
    return ClassesWithSameNamedProperty.Matcher.on(engine);
  }
  
  @Override
  public ClassesWithSameNamedProperty.Matcher instantiate() {
    return ClassesWithSameNamedProperty.Matcher.create();
  }
  
  @Override
  public ClassesWithSameNamedProperty.Match newEmptyMatch() {
    return ClassesWithSameNamedProperty.Match.newEmptyMatch();
  }
  
  @Override
  public ClassesWithSameNamedProperty.Match newMatch(final Object... parameters) {
    return ClassesWithSameNamedProperty.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[1], (java.lang.String) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link ClassesWithSameNamedProperty} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link ClassesWithSameNamedProperty#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final ClassesWithSameNamedProperty INSTANCE = new ClassesWithSameNamedProperty();
    
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
    private static final ClassesWithSameNamedProperty.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_class1 = new PParameter("class1", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_class2 = new PParameter("class2", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_name = new PParameter("name", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_class1, parameter_class2, parameter_name);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.classesWithSameNamedProperty";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("class1","class2","name");
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
          PVariable var_class1 = body.getOrCreateVariableByName("class1");
          PVariable var_class2 = body.getOrCreateVariableByName("class2");
          PVariable var_name = body.getOrCreateVariableByName("name");
          new TypeConstraint(body, Tuples.flatTupleOf(var_class1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_class2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Class")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_name), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_class1, parameter_class1),
             new ExportedParameter(body, var_class2, parameter_class2),
             new ExportedParameter(body, var_name, parameter_name)
          ));
          // 	//using the 'name' parameter in both places will ensure that the name is the same	Class.ownedAttribute.name(class1, name)
          new TypeConstraint(body, Tuples.flatTupleOf(var_class1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Class")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_class1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Property")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "String")));
          new Equality(body, var__virtual_1_, var_name);
          // 	Class.ownedAttribute.name(class2, name)
          new TypeConstraint(body, Tuples.flatTupleOf(var_class2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Class")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_class2, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "StructuredClassifier", "ownedAttribute")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Property")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "String")));
          new Equality(body, var__virtual_3_, var_name);
          // 	//Ensure that they are not the same class	class1 != class2
          new Inequality(body, var_class1, var_class2);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
