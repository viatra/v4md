/**
 * Generated from platform:/resource/com.incquerylabs.v4md.snapshotmaker/src/main/java/com/incquerylabs/v4md/test/queries/Circular_Dependency.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.DependencyChain;
import com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency;
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
 *         Pattern responsible for detecting circular dependency chains in UML models
 *          
 *         pattern CircularDependencyError(dep : Dependency) {
 *             //Call transitive closure of sub-pattern 'DependencyChain'
 *             find DependencyChain+(dep, dep);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class CircularDependencyError extends BaseGeneratedEMFQuerySpecification<CircularDependencyError.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.CircularDependencyError pattern,
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
    private Dependency fDep;
    
    private static List<String> parameterNames = makeImmutableList("dep");
    
    private Match(final Dependency pDep) {
      this.fDep = pDep;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("dep".equals(parameterName)) return this.fDep;
      return null;
    }
    
    public Dependency getDep() {
      return this.fDep;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("dep".equals(parameterName) ) {
          this.fDep = (Dependency) newValue;
          return true;
      }
      return false;
    }
    
    public void setDep(final Dependency pDep) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDep = pDep;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.CircularDependencyError";
    }
    
    @Override
    public List<String> parameterNames() {
      return CircularDependencyError.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fDep};
    }
    
    @Override
    public CircularDependencyError.Match toImmutable() {
      return isMutable() ? newMatch(fDep) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"dep\"=" + prettyPrintValue(fDep));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fDep);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof CircularDependencyError.Match)) {
          CircularDependencyError.Match other = (CircularDependencyError.Match) obj;
          return Objects.equals(fDep, other.fDep);
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
    public CircularDependencyError specification() {
      return CircularDependencyError.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static CircularDependencyError.Match newEmptyMatch() {
      return new Mutable(null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pDep the fixed value of pattern parameter dep, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static CircularDependencyError.Match newMutableMatch(final Dependency pDep) {
      return new Mutable(pDep);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pDep the fixed value of pattern parameter dep, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static CircularDependencyError.Match newMatch(final Dependency pDep) {
      return new Immutable(pDep);
    }
    
    private static final class Mutable extends CircularDependencyError.Match {
      Mutable(final Dependency pDep) {
        super(pDep);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends CircularDependencyError.Match {
      Immutable(final Dependency pDep) {
        super(pDep);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.CircularDependencyError pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * Pattern responsible for detecting circular dependency chains in UML models
   *  
   * pattern CircularDependencyError(dep : Dependency) {
   *     //Call transitive closure of sub-pattern 'DependencyChain'
   *     find DependencyChain+(dep, dep);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see CircularDependencyError
   * 
   */
  public static class Matcher extends BaseMatcher<CircularDependencyError.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static CircularDependencyError.Matcher on(final ViatraQueryEngine engine) {
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
    public static CircularDependencyError.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_DEP = 0;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(CircularDependencyError.Matcher.class);
    
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
     * @param pDep the fixed value of pattern parameter dep, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<CircularDependencyError.Match> getAllMatches(final Dependency pDep) {
      return rawStreamAllMatches(new Object[]{pDep}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pDep the fixed value of pattern parameter dep, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<CircularDependencyError.Match> streamAllMatches(final Dependency pDep) {
      return rawStreamAllMatches(new Object[]{pDep});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pDep the fixed value of pattern parameter dep, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<CircularDependencyError.Match> getOneArbitraryMatch(final Dependency pDep) {
      return rawGetOneArbitraryMatch(new Object[]{pDep});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pDep the fixed value of pattern parameter dep, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Dependency pDep) {
      return rawHasMatch(new Object[]{pDep});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pDep the fixed value of pattern parameter dep, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Dependency pDep) {
      return rawCountMatches(new Object[]{pDep});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pDep the fixed value of pattern parameter dep, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Dependency pDep, final Consumer<? super CircularDependencyError.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pDep}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pDep the fixed value of pattern parameter dep, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public CircularDependencyError.Match newMatch(final Dependency pDep) {
      return CircularDependencyError.Match.newMatch(pDep);
    }
    
    /**
     * Retrieve the set of values that occur in matches for dep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Dependency> rawStreamAllValuesOfdep(final Object[] parameters) {
      return rawStreamAllValues(POSITION_DEP, parameters).map(Dependency.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for dep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Dependency> getAllValuesOfdep() {
      return rawStreamAllValuesOfdep(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for dep.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Dependency> streamAllValuesOfdep() {
      return rawStreamAllValuesOfdep(emptyArray());
    }
    
    @Override
    protected CircularDependencyError.Match tupleToMatch(final Tuple t) {
      try {
          return CircularDependencyError.Match.newMatch((Dependency) t.get(POSITION_DEP));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected CircularDependencyError.Match arrayToMatch(final Object[] match) {
      try {
          return CircularDependencyError.Match.newMatch((Dependency) match[POSITION_DEP]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected CircularDependencyError.Match arrayToMatchMutable(final Object[] match) {
      try {
          return CircularDependencyError.Match.newMutableMatch((Dependency) match[POSITION_DEP]);
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
    public static IQuerySpecification<CircularDependencyError.Matcher> querySpecification() {
      return CircularDependencyError.instance();
    }
  }
  
  private CircularDependencyError() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static CircularDependencyError instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected CircularDependencyError.Matcher instantiate(final ViatraQueryEngine engine) {
    return CircularDependencyError.Matcher.on(engine);
  }
  
  @Override
  public CircularDependencyError.Matcher instantiate() {
    return CircularDependencyError.Matcher.create();
  }
  
  @Override
  public CircularDependencyError.Match newEmptyMatch() {
    return CircularDependencyError.Match.newEmptyMatch();
  }
  
  @Override
  public CircularDependencyError.Match newMatch(final Object... parameters) {
    return CircularDependencyError.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency) parameters[0]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: com.incquerylabs.v4md.test.queries.CircularDependencyError (visibility: PUBLIC, simpleName: CircularDependencyError, identifier: com.incquerylabs.v4md.test.queries.CircularDependencyError, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: com.incquerylabs.v4md.test.queries.CircularDependencyError (visibility: PUBLIC, simpleName: CircularDependencyError, identifier: com.incquerylabs.v4md.test.queries.CircularDependencyError, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static CircularDependencyError INSTANCE = new CircularDependencyError();
    
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
    private final static CircularDependencyError.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_dep = new PParameter("dep", "com.nomagic.uml2.ext.magicdraw.classes.mddependencies.Dependency", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Dependency")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_dep);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.CircularDependencyError";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("dep");
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
          PVariable var_dep = body.getOrCreateVariableByName("dep");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Dependency")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_dep, parameter_dep)
          ));
          //     //Call transitive closure of sub-pattern 'DependencyChain'    find DependencyChain+(dep, dep)
          new BinaryTransitiveClosure(body, Tuples.flatTupleOf(var_dep, var_dep), DependencyChain.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
