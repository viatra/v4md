/**
 * Generated from platform:/resource/com.incquerylabs.v4md.integrationtest/src/test/com/incquerylabs/v4md/test/queries/Non_Unique_Names.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property;
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
 *         Detects NamedElement pairs, where the values of the same STRING ID property are equal
 *          
 *         pattern PropertyStringValueEquals(element : NamedElement, element2 : NamedElement, property : Property){
 *         	element != element2;
 *         	Property.isID(property, true);
 *         	
 *         	NamedElement.taggedValue(element, taggedValue);
 *         	StringTaggedValue.value(taggedValue, val1);
 *         	
 *         	NamedElement.taggedValue(element2, taggedValue2);
 *         	StringTaggedValue.value(taggedValue2, val2);
 *         	
 *         	val1 == val2;
 *         	
 *         	TaggedValue.tagDefinition(taggedValue, property);
 *         	TaggedValue.tagDefinition(taggedValue2, property);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class PropertyStringValueEquals extends BaseGeneratedEMFQuerySpecification<PropertyStringValueEquals.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.PropertyStringValueEquals pattern,
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
    private NamedElement fElement;
    
    private NamedElement fElement2;
    
    private Property fProperty;
    
    private static List<String> parameterNames = makeImmutableList("element", "element2", "property");
    
    private Match(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
      this.fElement = pElement;
      this.fElement2 = pElement2;
      this.fProperty = pProperty;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "element": return this.fElement;
          case "element2": return this.fElement2;
          case "property": return this.fProperty;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fElement;
          case 1: return this.fElement2;
          case 2: return this.fProperty;
          default: return null;
      }
    }
    
    public NamedElement getElement() {
      return this.fElement;
    }
    
    public NamedElement getElement2() {
      return this.fElement2;
    }
    
    public Property getProperty() {
      return this.fProperty;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("element".equals(parameterName) ) {
          this.fElement = (NamedElement) newValue;
          return true;
      }
      if ("element2".equals(parameterName) ) {
          this.fElement2 = (NamedElement) newValue;
          return true;
      }
      if ("property".equals(parameterName) ) {
          this.fProperty = (Property) newValue;
          return true;
      }
      return false;
    }
    
    public void setElement(final NamedElement pElement) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fElement = pElement;
    }
    
    public void setElement2(final NamedElement pElement2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fElement2 = pElement2;
    }
    
    public void setProperty(final Property pProperty) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fProperty = pProperty;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.PropertyStringValueEquals";
    }
    
    @Override
    public List<String> parameterNames() {
      return PropertyStringValueEquals.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fElement, fElement2, fProperty};
    }
    
    @Override
    public PropertyStringValueEquals.Match toImmutable() {
      return isMutable() ? newMatch(fElement, fElement2, fProperty) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"element\"=" + prettyPrintValue(fElement) + ", ");
      result.append("\"element2\"=" + prettyPrintValue(fElement2) + ", ");
      result.append("\"property\"=" + prettyPrintValue(fProperty));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fElement, fElement2, fProperty);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof PropertyStringValueEquals.Match)) {
          PropertyStringValueEquals.Match other = (PropertyStringValueEquals.Match) obj;
          return Objects.equals(fElement, other.fElement) && Objects.equals(fElement2, other.fElement2) && Objects.equals(fProperty, other.fProperty);
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
    public PropertyStringValueEquals specification() {
      return PropertyStringValueEquals.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static PropertyStringValueEquals.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pElement2 the fixed value of pattern parameter element2, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static PropertyStringValueEquals.Match newMutableMatch(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
      return new Mutable(pElement, pElement2, pProperty);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pElement2 the fixed value of pattern parameter element2, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static PropertyStringValueEquals.Match newMatch(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
      return new Immutable(pElement, pElement2, pProperty);
    }
    
    private static final class Mutable extends PropertyStringValueEquals.Match {
      Mutable(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
        super(pElement, pElement2, pProperty);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends PropertyStringValueEquals.Match {
      Immutable(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
        super(pElement, pElement2, pProperty);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.PropertyStringValueEquals pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * Detects NamedElement pairs, where the values of the same STRING ID property are equal
   *  
   * pattern PropertyStringValueEquals(element : NamedElement, element2 : NamedElement, property : Property){
   * 	element != element2;
   * 	Property.isID(property, true);
   * 	
   * 	NamedElement.taggedValue(element, taggedValue);
   * 	StringTaggedValue.value(taggedValue, val1);
   * 	
   * 	NamedElement.taggedValue(element2, taggedValue2);
   * 	StringTaggedValue.value(taggedValue2, val2);
   * 	
   * 	val1 == val2;
   * 	
   * 	TaggedValue.tagDefinition(taggedValue, property);
   * 	TaggedValue.tagDefinition(taggedValue2, property);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see PropertyStringValueEquals
   * 
   */
  public static class Matcher extends BaseMatcher<PropertyStringValueEquals.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static PropertyStringValueEquals.Matcher on(final ViatraQueryEngine engine) {
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
    public static PropertyStringValueEquals.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_ELEMENT = 0;
    
    private static final int POSITION_ELEMENT2 = 1;
    
    private static final int POSITION_PROPERTY = 2;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(PropertyStringValueEquals.Matcher.class);
    
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
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pElement2 the fixed value of pattern parameter element2, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<PropertyStringValueEquals.Match> getAllMatches(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
      return rawStreamAllMatches(new Object[]{pElement, pElement2, pProperty}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pElement2 the fixed value of pattern parameter element2, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<PropertyStringValueEquals.Match> streamAllMatches(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
      return rawStreamAllMatches(new Object[]{pElement, pElement2, pProperty});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pElement2 the fixed value of pattern parameter element2, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<PropertyStringValueEquals.Match> getOneArbitraryMatch(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
      return rawGetOneArbitraryMatch(new Object[]{pElement, pElement2, pProperty});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pElement2 the fixed value of pattern parameter element2, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
      return rawHasMatch(new Object[]{pElement, pElement2, pProperty});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pElement2 the fixed value of pattern parameter element2, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
      return rawCountMatches(new Object[]{pElement, pElement2, pProperty});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pElement2 the fixed value of pattern parameter element2, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final NamedElement pElement, final NamedElement pElement2, final Property pProperty, final Consumer<? super PropertyStringValueEquals.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pElement, pElement2, pProperty}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pElement the fixed value of pattern parameter element, or null if not bound.
     * @param pElement2 the fixed value of pattern parameter element2, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public PropertyStringValueEquals.Match newMatch(final NamedElement pElement, final NamedElement pElement2, final Property pProperty) {
      return PropertyStringValueEquals.Match.newMatch(pElement, pElement2, pProperty);
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<NamedElement> rawStreamAllValuesOfelement(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ELEMENT, parameters).map(NamedElement.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelement() {
      return rawStreamAllValuesOfelement(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelement() {
      return rawStreamAllValuesOfelement(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelement(final PropertyStringValueEquals.Match partialMatch) {
      return rawStreamAllValuesOfelement(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelement(final NamedElement pElement2, final Property pProperty) {
      return rawStreamAllValuesOfelement(new Object[]{null, pElement2, pProperty});
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelement(final PropertyStringValueEquals.Match partialMatch) {
      return rawStreamAllValuesOfelement(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelement(final NamedElement pElement2, final Property pProperty) {
      return rawStreamAllValuesOfelement(new Object[]{null, pElement2, pProperty}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<NamedElement> rawStreamAllValuesOfelement2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ELEMENT2, parameters).map(NamedElement.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for element2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelement2() {
      return rawStreamAllValuesOfelement2(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelement2() {
      return rawStreamAllValuesOfelement2(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelement2(final PropertyStringValueEquals.Match partialMatch) {
      return rawStreamAllValuesOfelement2(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelement2(final NamedElement pElement, final Property pProperty) {
      return rawStreamAllValuesOfelement2(new Object[]{pElement, null, pProperty});
    }
    
    /**
     * Retrieve the set of values that occur in matches for element2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelement2(final PropertyStringValueEquals.Match partialMatch) {
      return rawStreamAllValuesOfelement2(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for element2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelement2(final NamedElement pElement, final Property pProperty) {
      return rawStreamAllValuesOfelement2(new Object[]{pElement, null, pProperty}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for property.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Property> rawStreamAllValuesOfproperty(final Object[] parameters) {
      return rawStreamAllValues(POSITION_PROPERTY, parameters).map(Property.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for property.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfproperty() {
      return rawStreamAllValuesOfproperty(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for property.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfproperty() {
      return rawStreamAllValuesOfproperty(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for property.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfproperty(final PropertyStringValueEquals.Match partialMatch) {
      return rawStreamAllValuesOfproperty(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for property.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Property> streamAllValuesOfproperty(final NamedElement pElement, final NamedElement pElement2) {
      return rawStreamAllValuesOfproperty(new Object[]{pElement, pElement2, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for property.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfproperty(final PropertyStringValueEquals.Match partialMatch) {
      return rawStreamAllValuesOfproperty(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for property.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfproperty(final NamedElement pElement, final NamedElement pElement2) {
      return rawStreamAllValuesOfproperty(new Object[]{pElement, pElement2, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected PropertyStringValueEquals.Match tupleToMatch(final Tuple t) {
      try {
          return PropertyStringValueEquals.Match.newMatch((NamedElement) t.get(POSITION_ELEMENT), (NamedElement) t.get(POSITION_ELEMENT2), (Property) t.get(POSITION_PROPERTY));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PropertyStringValueEquals.Match arrayToMatch(final Object[] match) {
      try {
          return PropertyStringValueEquals.Match.newMatch((NamedElement) match[POSITION_ELEMENT], (NamedElement) match[POSITION_ELEMENT2], (Property) match[POSITION_PROPERTY]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected PropertyStringValueEquals.Match arrayToMatchMutable(final Object[] match) {
      try {
          return PropertyStringValueEquals.Match.newMutableMatch((NamedElement) match[POSITION_ELEMENT], (NamedElement) match[POSITION_ELEMENT2], (Property) match[POSITION_PROPERTY]);
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
    public static IQuerySpecification<PropertyStringValueEquals.Matcher> querySpecification() {
      return PropertyStringValueEquals.instance();
    }
  }
  
  private PropertyStringValueEquals() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static PropertyStringValueEquals instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected PropertyStringValueEquals.Matcher instantiate(final ViatraQueryEngine engine) {
    return PropertyStringValueEquals.Matcher.on(engine);
  }
  
  @Override
  public PropertyStringValueEquals.Matcher instantiate() {
    return PropertyStringValueEquals.Matcher.create();
  }
  
  @Override
  public PropertyStringValueEquals.Match newEmptyMatch() {
    return PropertyStringValueEquals.Match.newEmptyMatch();
  }
  
  @Override
  public PropertyStringValueEquals.Match newMatch(final Object... parameters) {
    return PropertyStringValueEquals.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement) parameters[1], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[2]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link PropertyStringValueEquals} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link PropertyStringValueEquals#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final PropertyStringValueEquals INSTANCE = new PropertyStringValueEquals();
    
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
    private static final PropertyStringValueEquals.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_element = new PParameter("element", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "NamedElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_element2 = new PParameter("element2", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "NamedElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_property = new PParameter("property", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Property")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_element, parameter_element2, parameter_property);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.PropertyStringValueEquals";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("element","element2","property");
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
          PVariable var_element = body.getOrCreateVariableByName("element");
          PVariable var_element2 = body.getOrCreateVariableByName("element2");
          PVariable var_property = body.getOrCreateVariableByName("property");
          PVariable var_taggedValue = body.getOrCreateVariableByName("taggedValue");
          PVariable var_val1 = body.getOrCreateVariableByName("val1");
          PVariable var_taggedValue2 = body.getOrCreateVariableByName("taggedValue2");
          PVariable var_val2 = body.getOrCreateVariableByName("val2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "NamedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_element2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "NamedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Property")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_element, parameter_element),
             new ExportedParameter(body, var_element2, parameter_element2),
             new ExportedParameter(body, var_property, parameter_property)
          ));
          // 	element != element2
          new Inequality(body, var_element, var_element2);
          // 	Property.isID(property, true)
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, true);
          new TypeConstraint(body, Tuples.flatTupleOf(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Property")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_property, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Property", "isID")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Boolean")));
          new Equality(body, var__virtual_1_, var__virtual_0_);
          // 		NamedElement.taggedValue(element, taggedValue)
          new TypeConstraint(body, Tuples.flatTupleOf(var_element), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "NamedElement")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_element, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Element", "taggedValue")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "TaggedValue")));
          new Equality(body, var__virtual_2_, var_taggedValue);
          // 	StringTaggedValue.value(taggedValue, val1)
          new TypeConstraint(body, Tuples.flatTupleOf(var_taggedValue), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "StringTaggedValue")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_taggedValue, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "StringTaggedValue", "value")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "String")));
          new Equality(body, var__virtual_3_, var_val1);
          // 		NamedElement.taggedValue(element2, taggedValue2)
          new TypeConstraint(body, Tuples.flatTupleOf(var_element2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "NamedElement")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_element2, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Element", "taggedValue")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "TaggedValue")));
          new Equality(body, var__virtual_4_, var_taggedValue2);
          // 	StringTaggedValue.value(taggedValue2, val2)
          new TypeConstraint(body, Tuples.flatTupleOf(var_taggedValue2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "StringTaggedValue")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_taggedValue2, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "StringTaggedValue", "value")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "String")));
          new Equality(body, var__virtual_5_, var_val2);
          // 		val1 == val2
          new Equality(body, var_val1, var_val2);
          // 		TaggedValue.tagDefinition(taggedValue, property)
          new TypeConstraint(body, Tuples.flatTupleOf(var_taggedValue), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "TaggedValue")));
          PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_taggedValue, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "TaggedValue", "tagDefinition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_6_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Property")));
          new Equality(body, var__virtual_6_, var_property);
          // 	TaggedValue.tagDefinition(taggedValue2, property)
          new TypeConstraint(body, Tuples.flatTupleOf(var_taggedValue2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "TaggedValue")));
          PVariable var__virtual_7_ = body.getOrCreateVariableByName(".virtual{7}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_taggedValue2, var__virtual_7_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "TaggedValue", "tagDefinition")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_7_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1.1", "Property")));
          new Equality(body, var__virtual_7_, var_property);
          bodies.add(body);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1() {
    return true;
  }
}
