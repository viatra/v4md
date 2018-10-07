/**
 * Generated from platform:/resource/com.incquerylabs.v4md.snapshotmaker/src/main/java/com/incquerylabs/v4md/snapshotmaker/queries/UMLTestQueries.vql
 */
package com.incquerylabs.v4md.snapshotmaker.queries;

import com.nomagic.uml2.ext.magicdraw.components.mdbasiccomponents.Component;
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
 *         pattern CompnoentsWithName(component : Component, name: java String) {
 *         	Component.name(component, name);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class CompnoentsWithName extends BaseGeneratedEMFQuerySpecification<CompnoentsWithName.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.snapshotmaker.queries.CompnoentsWithName pattern,
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
    private Component fComponent;
    
    private String fName;
    
    private static List<String> parameterNames = makeImmutableList("component", "name");
    
    private Match(final Component pComponent, final String pName) {
      this.fComponent = pComponent;
      this.fName = pName;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("component".equals(parameterName)) return this.fComponent;
      if ("name".equals(parameterName)) return this.fName;
      return null;
    }
    
    public Component getComponent() {
      return this.fComponent;
    }
    
    public String getName() {
      return this.fName;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("component".equals(parameterName) ) {
          this.fComponent = (Component) newValue;
          return true;
      }
      if ("name".equals(parameterName) ) {
          this.fName = (String) newValue;
          return true;
      }
      return false;
    }
    
    public void setComponent(final Component pComponent) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fComponent = pComponent;
    }
    
    public void setName(final String pName) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fName = pName;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.snapshotmaker.queries.CompnoentsWithName";
    }
    
    @Override
    public List<String> parameterNames() {
      return CompnoentsWithName.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fComponent, fName};
    }
    
    @Override
    public CompnoentsWithName.Match toImmutable() {
      return isMutable() ? newMatch(fComponent, fName) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"component\"=" + prettyPrintValue(fComponent) + ", ");
      result.append("\"name\"=" + prettyPrintValue(fName));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fComponent, fName);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof CompnoentsWithName.Match)) {
          CompnoentsWithName.Match other = (CompnoentsWithName.Match) obj;
          return Objects.equals(fComponent, other.fComponent) && Objects.equals(fName, other.fName);
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
    public CompnoentsWithName specification() {
      return CompnoentsWithName.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static CompnoentsWithName.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static CompnoentsWithName.Match newMutableMatch(final Component pComponent, final String pName) {
      return new Mutable(pComponent, pName);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static CompnoentsWithName.Match newMatch(final Component pComponent, final String pName) {
      return new Immutable(pComponent, pName);
    }
    
    private static final class Mutable extends CompnoentsWithName.Match {
      Mutable(final Component pComponent, final String pName) {
        super(pComponent, pName);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends CompnoentsWithName.Match {
      Immutable(final Component pComponent, final String pName) {
        super(pComponent, pName);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.snapshotmaker.queries.CompnoentsWithName pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern CompnoentsWithName(component : Component, name: java String) {
   * 	Component.name(component, name);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see CompnoentsWithName
   * 
   */
  public static class Matcher extends BaseMatcher<CompnoentsWithName.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static CompnoentsWithName.Matcher on(final ViatraQueryEngine engine) {
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
    public static CompnoentsWithName.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_COMPONENT = 0;
    
    private final static int POSITION_NAME = 1;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(CompnoentsWithName.Matcher.class);
    
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
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<CompnoentsWithName.Match> getAllMatches(final Component pComponent, final String pName) {
      return rawStreamAllMatches(new Object[]{pComponent, pName}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<CompnoentsWithName.Match> streamAllMatches(final Component pComponent, final String pName) {
      return rawStreamAllMatches(new Object[]{pComponent, pName});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<CompnoentsWithName.Match> getOneArbitraryMatch(final Component pComponent, final String pName) {
      return rawGetOneArbitraryMatch(new Object[]{pComponent, pName});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Component pComponent, final String pName) {
      return rawHasMatch(new Object[]{pComponent, pName});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Component pComponent, final String pName) {
      return rawCountMatches(new Object[]{pComponent, pName});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Component pComponent, final String pName, final Consumer<? super CompnoentsWithName.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pComponent, pName}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pComponent the fixed value of pattern parameter component, or null if not bound.
     * @param pName the fixed value of pattern parameter name, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public CompnoentsWithName.Match newMatch(final Component pComponent, final String pName) {
      return CompnoentsWithName.Match.newMatch(pComponent, pName);
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Component> rawStreamAllValuesOfcomponent(final Object[] parameters) {
      return rawStreamAllValues(POSITION_COMPONENT, parameters).map(Component.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Component> getAllValuesOfcomponent() {
      return rawStreamAllValuesOfcomponent(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Component> streamAllValuesOfcomponent() {
      return rawStreamAllValuesOfcomponent(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Component> streamAllValuesOfcomponent(final CompnoentsWithName.Match partialMatch) {
      return rawStreamAllValuesOfcomponent(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Component> streamAllValuesOfcomponent(final String pName) {
      return rawStreamAllValuesOfcomponent(new Object[]{null, pName});
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Component> getAllValuesOfcomponent(final CompnoentsWithName.Match partialMatch) {
      return rawStreamAllValuesOfcomponent(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for component.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Component> getAllValuesOfcomponent(final String pName) {
      return rawStreamAllValuesOfcomponent(new Object[]{null, pName}).collect(Collectors.toSet());
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
    public Stream<String> streamAllValuesOfname(final CompnoentsWithName.Match partialMatch) {
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
    public Stream<String> streamAllValuesOfname(final Component pComponent) {
      return rawStreamAllValuesOfname(new Object[]{pComponent, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfname(final CompnoentsWithName.Match partialMatch) {
      return rawStreamAllValuesOfname(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for name.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<String> getAllValuesOfname(final Component pComponent) {
      return rawStreamAllValuesOfname(new Object[]{pComponent, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected CompnoentsWithName.Match tupleToMatch(final Tuple t) {
      try {
          return CompnoentsWithName.Match.newMatch((Component) t.get(POSITION_COMPONENT), (String) t.get(POSITION_NAME));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected CompnoentsWithName.Match arrayToMatch(final Object[] match) {
      try {
          return CompnoentsWithName.Match.newMatch((Component) match[POSITION_COMPONENT], (String) match[POSITION_NAME]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected CompnoentsWithName.Match arrayToMatchMutable(final Object[] match) {
      try {
          return CompnoentsWithName.Match.newMutableMatch((Component) match[POSITION_COMPONENT], (String) match[POSITION_NAME]);
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
    public static IQuerySpecification<CompnoentsWithName.Matcher> querySpecification() {
      return CompnoentsWithName.instance();
    }
  }
  
  private CompnoentsWithName() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static CompnoentsWithName instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected CompnoentsWithName.Matcher instantiate(final ViatraQueryEngine engine) {
    return CompnoentsWithName.Matcher.on(engine);
  }
  
  @Override
  public CompnoentsWithName.Matcher instantiate() {
    return CompnoentsWithName.Matcher.create();
  }
  
  @Override
  public CompnoentsWithName.Match newEmptyMatch() {
    return CompnoentsWithName.Match.newEmptyMatch();
  }
  
  @Override
  public CompnoentsWithName.Match newMatch(final Object... parameters) {
    return CompnoentsWithName.Match.newMatch((com.nomagic.uml2.ext.magicdraw.components.mdbasiccomponents.Component) parameters[0], (java.lang.String) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: com.incquerylabs.v4md.snapshotmaker.queries.CompnoentsWithName (visibility: PUBLIC, simpleName: CompnoentsWithName, identifier: com.incquerylabs.v4md.snapshotmaker.queries.CompnoentsWithName, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.snapshotmaker.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: com.incquerylabs.v4md.snapshotmaker.queries.CompnoentsWithName (visibility: PUBLIC, simpleName: CompnoentsWithName, identifier: com.incquerylabs.v4md.snapshotmaker.queries.CompnoentsWithName, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.snapshotmaker.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static CompnoentsWithName INSTANCE = new CompnoentsWithName();
    
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
    private final static CompnoentsWithName.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_component = new PParameter("component", "com.nomagic.uml2.ext.magicdraw.components.mdbasiccomponents.Component", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5", "Component")), PParameterDirection.INOUT);
    
    private final PParameter parameter_name = new PParameter("name", "java.lang.String", new JavaTransitiveInstancesKey(java.lang.String.class), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_component, parameter_name);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.snapshotmaker.queries.CompnoentsWithName";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("component","name");
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
          PVariable var_component = body.getOrCreateVariableByName("component");
          PVariable var_name = body.getOrCreateVariableByName("name");
          new TypeConstraint(body, Tuples.flatTupleOf(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Component")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_name), new JavaTransitiveInstancesKey(java.lang.String.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_component, parameter_component),
             new ExportedParameter(body, var_name, parameter_name)
          ));
          // 	Component.name(component, name)
          new TypeConstraint(body, Tuples.flatTupleOf(var_component), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "Component")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_component, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5", "String")));
          new Equality(body, var__virtual_0_, var_name);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
