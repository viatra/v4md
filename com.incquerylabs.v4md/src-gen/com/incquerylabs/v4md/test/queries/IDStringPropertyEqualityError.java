/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Non_Unique_Names.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.PropertyStringValueEquals;
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
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Inequality;
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
 *         Pattern responsible for detecting duplicate ID Property tagged values 
 *          
 *         pattern IDStringPropertyEqualityError(elem : NamedElement, property : Property){
 *         	find PropertyStringValueEquals(elem, otherElement, property);
 *         	elem != otherElement;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class IDStringPropertyEqualityError extends BaseGeneratedEMFQuerySpecification<IDStringPropertyEqualityError.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.IDStringPropertyEqualityError pattern,
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
    private NamedElement fElem;
    
    private Property fProperty;
    
    private static List<String> parameterNames = makeImmutableList("elem", "property");
    
    private Match(final NamedElement pElem, final Property pProperty) {
      this.fElem = pElem;
      this.fProperty = pProperty;
    }
    
    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "elem": return this.fElem;
          case "property": return this.fProperty;
          default: return null;
      }
    }
    
    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fElem;
          case 1: return this.fProperty;
          default: return null;
      }
    }
    
    public NamedElement getElem() {
      return this.fElem;
    }
    
    public Property getProperty() {
      return this.fProperty;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("elem".equals(parameterName) ) {
          this.fElem = (NamedElement) newValue;
          return true;
      }
      if ("property".equals(parameterName) ) {
          this.fProperty = (Property) newValue;
          return true;
      }
      return false;
    }
    
    public void setElem(final NamedElement pElem) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fElem = pElem;
    }
    
    public void setProperty(final Property pProperty) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fProperty = pProperty;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.IDStringPropertyEqualityError";
    }
    
    @Override
    public List<String> parameterNames() {
      return IDStringPropertyEqualityError.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fElem, fProperty};
    }
    
    @Override
    public IDStringPropertyEqualityError.Match toImmutable() {
      return isMutable() ? newMatch(fElem, fProperty) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"elem\"=" + prettyPrintValue(fElem) + ", ");
      result.append("\"property\"=" + prettyPrintValue(fProperty));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fElem, fProperty);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof IDStringPropertyEqualityError.Match)) {
          IDStringPropertyEqualityError.Match other = (IDStringPropertyEqualityError.Match) obj;
          return Objects.equals(fElem, other.fElem) && Objects.equals(fProperty, other.fProperty);
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
    public IDStringPropertyEqualityError specification() {
      return IDStringPropertyEqualityError.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static IDStringPropertyEqualityError.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static IDStringPropertyEqualityError.Match newMutableMatch(final NamedElement pElem, final Property pProperty) {
      return new Mutable(pElem, pProperty);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static IDStringPropertyEqualityError.Match newMatch(final NamedElement pElem, final Property pProperty) {
      return new Immutable(pElem, pProperty);
    }
    
    private static final class Mutable extends IDStringPropertyEqualityError.Match {
      Mutable(final NamedElement pElem, final Property pProperty) {
        super(pElem, pProperty);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends IDStringPropertyEqualityError.Match {
      Immutable(final NamedElement pElem, final Property pProperty) {
        super(pElem, pProperty);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.IDStringPropertyEqualityError pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * Pattern responsible for detecting duplicate ID Property tagged values 
   *  
   * pattern IDStringPropertyEqualityError(elem : NamedElement, property : Property){
   * 	find PropertyStringValueEquals(elem, otherElement, property);
   * 	elem != otherElement;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see IDStringPropertyEqualityError
   * 
   */
  public static class Matcher extends BaseMatcher<IDStringPropertyEqualityError.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static IDStringPropertyEqualityError.Matcher on(final ViatraQueryEngine engine) {
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
    public static IDStringPropertyEqualityError.Matcher create() {
      return new Matcher();
    }
    
    private static final int POSITION_ELEM = 0;
    
    private static final int POSITION_PROPERTY = 1;
    
    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(IDStringPropertyEqualityError.Matcher.class);
    
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
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<IDStringPropertyEqualityError.Match> getAllMatches(final NamedElement pElem, final Property pProperty) {
      return rawStreamAllMatches(new Object[]{pElem, pProperty}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<IDStringPropertyEqualityError.Match> streamAllMatches(final NamedElement pElem, final Property pProperty) {
      return rawStreamAllMatches(new Object[]{pElem, pProperty});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<IDStringPropertyEqualityError.Match> getOneArbitraryMatch(final NamedElement pElem, final Property pProperty) {
      return rawGetOneArbitraryMatch(new Object[]{pElem, pProperty});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final NamedElement pElem, final Property pProperty) {
      return rawHasMatch(new Object[]{pElem, pProperty});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final NamedElement pElem, final Property pProperty) {
      return rawCountMatches(new Object[]{pElem, pProperty});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final NamedElement pElem, final Property pProperty, final Consumer<? super IDStringPropertyEqualityError.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pElem, pProperty}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pElem the fixed value of pattern parameter elem, or null if not bound.
     * @param pProperty the fixed value of pattern parameter property, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public IDStringPropertyEqualityError.Match newMatch(final NamedElement pElem, final Property pProperty) {
      return IDStringPropertyEqualityError.Match.newMatch(pElem, pProperty);
    }
    
    /**
     * Retrieve the set of values that occur in matches for elem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<NamedElement> rawStreamAllValuesOfelem(final Object[] parameters) {
      return rawStreamAllValues(POSITION_ELEM, parameters).map(NamedElement.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for elem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelem() {
      return rawStreamAllValuesOfelem(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelem() {
      return rawStreamAllValuesOfelem(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elem.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelem(final IDStringPropertyEqualityError.Match partialMatch) {
      return rawStreamAllValuesOfelem(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elem.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfelem(final Property pProperty) {
      return rawStreamAllValuesOfelem(new Object[]{null, pProperty});
    }
    
    /**
     * Retrieve the set of values that occur in matches for elem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelem(final IDStringPropertyEqualityError.Match partialMatch) {
      return rawStreamAllValuesOfelem(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for elem.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfelem(final Property pProperty) {
      return rawStreamAllValuesOfelem(new Object[]{null, pProperty}).collect(Collectors.toSet());
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
    public Stream<Property> streamAllValuesOfproperty(final IDStringPropertyEqualityError.Match partialMatch) {
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
    public Stream<Property> streamAllValuesOfproperty(final NamedElement pElem) {
      return rawStreamAllValuesOfproperty(new Object[]{pElem, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for property.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfproperty(final IDStringPropertyEqualityError.Match partialMatch) {
      return rawStreamAllValuesOfproperty(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for property.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Property> getAllValuesOfproperty(final NamedElement pElem) {
      return rawStreamAllValuesOfproperty(new Object[]{pElem, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected IDStringPropertyEqualityError.Match tupleToMatch(final Tuple t) {
      try {
          return IDStringPropertyEqualityError.Match.newMatch((NamedElement) t.get(POSITION_ELEM), (Property) t.get(POSITION_PROPERTY));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected IDStringPropertyEqualityError.Match arrayToMatch(final Object[] match) {
      try {
          return IDStringPropertyEqualityError.Match.newMatch((NamedElement) match[POSITION_ELEM], (Property) match[POSITION_PROPERTY]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected IDStringPropertyEqualityError.Match arrayToMatchMutable(final Object[] match) {
      try {
          return IDStringPropertyEqualityError.Match.newMutableMatch((NamedElement) match[POSITION_ELEM], (Property) match[POSITION_PROPERTY]);
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
    public static IQuerySpecification<IDStringPropertyEqualityError.Matcher> querySpecification() {
      return IDStringPropertyEqualityError.instance();
    }
  }
  
  private IDStringPropertyEqualityError() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static IDStringPropertyEqualityError instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected IDStringPropertyEqualityError.Matcher instantiate(final ViatraQueryEngine engine) {
    return IDStringPropertyEqualityError.Matcher.on(engine);
  }
  
  @Override
  public IDStringPropertyEqualityError.Matcher instantiate() {
    return IDStringPropertyEqualityError.Matcher.create();
  }
  
  @Override
  public IDStringPropertyEqualityError.Match newEmptyMatch() {
    return IDStringPropertyEqualityError.Match.newEmptyMatch();
  }
  
  @Override
  public IDStringPropertyEqualityError.Match newMatch(final Object... parameters) {
    return IDStringPropertyEqualityError.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link IDStringPropertyEqualityError} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link IDStringPropertyEqualityError#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final IDStringPropertyEqualityError INSTANCE = new IDStringPropertyEqualityError();
    
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
    private static final IDStringPropertyEqualityError.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_elem = new PParameter("elem", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement")), PParameterDirection.INOUT);
    
    private final PParameter parameter_property = new PParameter("property", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Property", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_elem, parameter_property);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.IDStringPropertyEqualityError";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("elem","property");
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
          PVariable var_elem = body.getOrCreateVariableByName("elem");
          PVariable var_property = body.getOrCreateVariableByName("property");
          PVariable var_otherElement = body.getOrCreateVariableByName("otherElement");
          new TypeConstraint(body, Tuples.flatTupleOf(var_elem), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_property), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Property")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_elem, parameter_elem),
             new ExportedParameter(body, var_property, parameter_property)
          ));
          // 	find PropertyStringValueEquals(elem, otherElement, property)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_elem, var_otherElement, var_property), PropertyStringValueEquals.instance().getInternalQueryRepresentation());
          // 	elem != otherElement
          new Inequality(body, var_elem, var_otherElement);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
