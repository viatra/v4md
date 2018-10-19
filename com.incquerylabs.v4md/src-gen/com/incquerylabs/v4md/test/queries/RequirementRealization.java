/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Requirement_Realization.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
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
 *         pattern RequirementRealization(requirement : Class, realizingElement : NamedElement) {
 *         	Class.appliedStereotypeInstance.classifier.name(requirement, "Requirement");
 *         	
 *         	Dependency.appliedStereotypeInstance.classifier.name(dep, "Satisfy");
 *         	Dependency.supplier(dep, requirement);
 *         	Dependency.client(dep, realizingElement);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class RequirementRealization extends BaseGeneratedEMFQuerySpecification<RequirementRealization.Matcher> {
  /**
   * Pattern-specific match representation of the com.incquerylabs.v4md.test.queries.RequirementRealization pattern,
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
    private com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class fRequirement;
    
    private NamedElement fRealizingElement;
    
    private static List<String> parameterNames = makeImmutableList("requirement", "realizingElement");
    
    private Match(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
      this.fRequirement = pRequirement;
      this.fRealizingElement = pRealizingElement;
    }
    
    @Override
    public Object get(final String parameterName) {
      if ("requirement".equals(parameterName)) return this.fRequirement;
      if ("realizingElement".equals(parameterName)) return this.fRealizingElement;
      return null;
    }
    
    public com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class getRequirement() {
      return this.fRequirement;
    }
    
    public NamedElement getRealizingElement() {
      return this.fRealizingElement;
    }
    
    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("requirement".equals(parameterName) ) {
          this.fRequirement = (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) newValue;
          return true;
      }
      if ("realizingElement".equals(parameterName) ) {
          this.fRealizingElement = (NamedElement) newValue;
          return true;
      }
      return false;
    }
    
    public void setRequirement(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRequirement = pRequirement;
    }
    
    public void setRealizingElement(final NamedElement pRealizingElement) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fRealizingElement = pRealizingElement;
    }
    
    @Override
    public String patternName() {
      return "com.incquerylabs.v4md.test.queries.RequirementRealization";
    }
    
    @Override
    public List<String> parameterNames() {
      return RequirementRealization.Match.parameterNames;
    }
    
    @Override
    public Object[] toArray() {
      return new Object[]{fRequirement, fRealizingElement};
    }
    
    @Override
    public RequirementRealization.Match toImmutable() {
      return isMutable() ? newMatch(fRequirement, fRealizingElement) : this;
    }
    
    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"requirement\"=" + prettyPrintValue(fRequirement) + ", ");
      result.append("\"realizingElement\"=" + prettyPrintValue(fRealizingElement));
      return result.toString();
    }
    
    @Override
    public int hashCode() {
      return Objects.hash(fRequirement, fRealizingElement);
    }
    
    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof RequirementRealization.Match)) {
          RequirementRealization.Match other = (RequirementRealization.Match) obj;
          return Objects.equals(fRequirement, other.fRequirement) && Objects.equals(fRealizingElement, other.fRealizingElement);
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
    public RequirementRealization specification() {
      return RequirementRealization.instance();
    }
    
    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static RequirementRealization.Match newEmptyMatch() {
      return new Mutable(null, null);
    }
    
    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pRequirement the fixed value of pattern parameter requirement, or null if not bound.
     * @param pRealizingElement the fixed value of pattern parameter realizingElement, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static RequirementRealization.Match newMutableMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
      return new Mutable(pRequirement, pRealizingElement);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pRequirement the fixed value of pattern parameter requirement, or null if not bound.
     * @param pRealizingElement the fixed value of pattern parameter realizingElement, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static RequirementRealization.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
      return new Immutable(pRequirement, pRealizingElement);
    }
    
    private static final class Mutable extends RequirementRealization.Match {
      Mutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
        super(pRequirement, pRealizingElement);
      }
      
      @Override
      public boolean isMutable() {
        return true;
      }
    }
    
    private static final class Immutable extends RequirementRealization.Match {
      Immutable(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
        super(pRequirement, pRealizingElement);
      }
      
      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }
  
  /**
   * Generated pattern matcher API of the com.incquerylabs.v4md.test.queries.RequirementRealization pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(Notifier)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern RequirementRealization(requirement : Class, realizingElement : NamedElement) {
   * 	Class.appliedStereotypeInstance.classifier.name(requirement, "Requirement");
   * 	
   * 	Dependency.appliedStereotypeInstance.classifier.name(dep, "Satisfy");
   * 	Dependency.supplier(dep, requirement);
   * 	Dependency.client(dep, realizingElement);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see RequirementRealization
   * 
   */
  public static class Matcher extends BaseMatcher<RequirementRealization.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static RequirementRealization.Matcher on(final ViatraQueryEngine engine) {
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
    public static RequirementRealization.Matcher create() {
      return new Matcher();
    }
    
    private final static int POSITION_REQUIREMENT = 0;
    
    private final static int POSITION_REALIZINGELEMENT = 1;
    
    private final static Logger LOGGER = ViatraQueryLoggingUtil.getLogger(RequirementRealization.Matcher.class);
    
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
     * @param pRequirement the fixed value of pattern parameter requirement, or null if not bound.
     * @param pRealizingElement the fixed value of pattern parameter realizingElement, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<RequirementRealization.Match> getAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
      return rawStreamAllMatches(new Object[]{pRequirement, pRealizingElement}).collect(Collectors.toSet());
    }
    
    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pRequirement the fixed value of pattern parameter requirement, or null if not bound.
     * @param pRealizingElement the fixed value of pattern parameter realizingElement, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<RequirementRealization.Match> streamAllMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
      return rawStreamAllMatches(new Object[]{pRequirement, pRealizingElement});
    }
    
    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pRequirement the fixed value of pattern parameter requirement, or null if not bound.
     * @param pRealizingElement the fixed value of pattern parameter realizingElement, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<RequirementRealization.Match> getOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
      return rawGetOneArbitraryMatch(new Object[]{pRequirement, pRealizingElement});
    }
    
    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pRequirement the fixed value of pattern parameter requirement, or null if not bound.
     * @param pRealizingElement the fixed value of pattern parameter realizingElement, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
      return rawHasMatch(new Object[]{pRequirement, pRealizingElement});
    }
    
    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pRequirement the fixed value of pattern parameter requirement, or null if not bound.
     * @param pRealizingElement the fixed value of pattern parameter realizingElement, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
      return rawCountMatches(new Object[]{pRequirement, pRealizingElement});
    }
    
    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pRequirement the fixed value of pattern parameter requirement, or null if not bound.
     * @param pRealizingElement the fixed value of pattern parameter realizingElement, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement, final Consumer<? super RequirementRealization.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pRequirement, pRealizingElement}, processor);
    }
    
    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pRequirement the fixed value of pattern parameter requirement, or null if not bound.
     * @param pRealizingElement the fixed value of pattern parameter realizingElement, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public RequirementRealization.Match newMatch(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement, final NamedElement pRealizingElement) {
      return RequirementRealization.Match.newMatch(pRequirement, pRealizingElement);
    }
    
    /**
     * Retrieve the set of values that occur in matches for requirement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> rawStreamAllValuesOfrequirement(final Object[] parameters) {
      return rawStreamAllValues(POSITION_REQUIREMENT, parameters).map(com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for requirement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfrequirement() {
      return rawStreamAllValuesOfrequirement(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for requirement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfrequirement() {
      return rawStreamAllValuesOfrequirement(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for requirement.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfrequirement(final RequirementRealization.Match partialMatch) {
      return rawStreamAllValuesOfrequirement(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for requirement.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> streamAllValuesOfrequirement(final NamedElement pRealizingElement) {
      return rawStreamAllValuesOfrequirement(new Object[]{null, pRealizingElement});
    }
    
    /**
     * Retrieve the set of values that occur in matches for requirement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfrequirement(final RequirementRealization.Match partialMatch) {
      return rawStreamAllValuesOfrequirement(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for requirement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class> getAllValuesOfrequirement(final NamedElement pRealizingElement) {
      return rawStreamAllValuesOfrequirement(new Object[]{null, pRealizingElement}).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for realizingElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<NamedElement> rawStreamAllValuesOfrealizingElement(final Object[] parameters) {
      return rawStreamAllValues(POSITION_REALIZINGELEMENT, parameters).map(NamedElement.class::cast);
    }
    
    /**
     * Retrieve the set of values that occur in matches for realizingElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfrealizingElement() {
      return rawStreamAllValuesOfrealizingElement(emptyArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for realizingElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfrealizingElement() {
      return rawStreamAllValuesOfrealizingElement(emptyArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for realizingElement.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfrealizingElement(final RequirementRealization.Match partialMatch) {
      return rawStreamAllValuesOfrealizingElement(partialMatch.toArray());
    }
    
    /**
     * Retrieve the set of values that occur in matches for realizingElement.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<NamedElement> streamAllValuesOfrealizingElement(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement) {
      return rawStreamAllValuesOfrealizingElement(new Object[]{pRequirement, null});
    }
    
    /**
     * Retrieve the set of values that occur in matches for realizingElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfrealizingElement(final RequirementRealization.Match partialMatch) {
      return rawStreamAllValuesOfrealizingElement(partialMatch.toArray()).collect(Collectors.toSet());
    }
    
    /**
     * Retrieve the set of values that occur in matches for realizingElement.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<NamedElement> getAllValuesOfrealizingElement(final com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class pRequirement) {
      return rawStreamAllValuesOfrealizingElement(new Object[]{pRequirement, null}).collect(Collectors.toSet());
    }
    
    @Override
    protected RequirementRealization.Match tupleToMatch(final Tuple t) {
      try {
          return RequirementRealization.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) t.get(POSITION_REQUIREMENT), (NamedElement) t.get(POSITION_REALIZINGELEMENT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected RequirementRealization.Match arrayToMatch(final Object[] match) {
      try {
          return RequirementRealization.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_REQUIREMENT], (NamedElement) match[POSITION_REALIZINGELEMENT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }
    
    @Override
    protected RequirementRealization.Match arrayToMatchMutable(final Object[] match) {
      try {
          return RequirementRealization.Match.newMutableMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) match[POSITION_REQUIREMENT], (NamedElement) match[POSITION_REALIZINGELEMENT]);
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
    public static IQuerySpecification<RequirementRealization.Matcher> querySpecification() {
      return RequirementRealization.instance();
    }
  }
  
  private RequirementRealization() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static RequirementRealization instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }
  
  @Override
  protected RequirementRealization.Matcher instantiate(final ViatraQueryEngine engine) {
    return RequirementRealization.Matcher.on(engine);
  }
  
  @Override
  public RequirementRealization.Matcher instantiate() {
    return RequirementRealization.Matcher.create();
  }
  
  @Override
  public RequirementRealization.Match newEmptyMatch() {
    return RequirementRealization.Match.newEmptyMatch();
  }
  
  @Override
  public RequirementRealization.Match newMatch(final Object... parameters) {
    return RequirementRealization.Match.newMatch((com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class) parameters[0], (com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement) parameters[1]);
  }
  
  /**
   * Inner class allowing the singleton instance of {@link JvmGenericType: com.incquerylabs.v4md.test.queries.RequirementRealization (visibility: PUBLIC, simpleName: RequirementRealization, identifier: com.incquerylabs.v4md.test.queries.RequirementRealization, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link JvmGenericType: com.incquerylabs.v4md.test.queries.RequirementRealization (visibility: PUBLIC, simpleName: RequirementRealization, identifier: com.incquerylabs.v4md.test.queries.RequirementRealization, deprecated: <unset>) (abstract: false, static: false, final: true, packageName: com.incquerylabs.v4md.test.queries) (interface: false, strictFloatingPoint: false, anonymous: false)#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private final static RequirementRealization INSTANCE = new RequirementRealization();
    
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
    private final static RequirementRealization.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    private final PParameter parameter_pRequirement = new PParameter("requirement", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.Class", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")), PParameterDirection.INOUT);
    
    private final PParameter parameter_pRealizingElement = new PParameter("realizingElement", "com.nomagic.uml2.ext.magicdraw.classes.mdkernel.NamedElement", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement")), PParameterDirection.INOUT);
    
    private final List<PParameter> parameters = Arrays.asList(parameter_pRequirement, parameter_pRealizingElement);
    
    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }
    
    @Override
    public String getFullyQualifiedName() {
      return "com.incquerylabs.v4md.test.queries.RequirementRealization";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("requirement","realizingElement");
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
          PVariable var_requirement = body.getOrCreateVariableByName("requirement");
          PVariable var_realizingElement = body.getOrCreateVariableByName("realizingElement");
          PVariable var_dep = body.getOrCreateVariableByName("dep");
          new TypeConstraint(body, Tuples.flatTupleOf(var_requirement), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_realizingElement), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_requirement, parameter_pRequirement),
             new ExportedParameter(body, var_realizingElement, parameter_pRealizingElement)
          ));
          // 	Class.appliedStereotypeInstance.classifier.name(requirement, "Requirement")
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, "Requirement");
          new TypeConstraint(body, Tuples.flatTupleOf(var_requirement), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Class")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_requirement, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Element", "appliedStereotypeInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification", "classifier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "String")));
          new Equality(body, var__virtual_3_, var__virtual_0_);
          // 		Dependency.appliedStereotypeInstance.classifier.name(dep, "Satisfy")
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ConstantValue(body, var__virtual_4_, "Satisfy");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Dependency")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Element", "appliedStereotypeInstance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification")));
          PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "InstanceSpecification", "classifier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_6_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Classifier")));
          PVariable var__virtual_7_ = body.getOrCreateVariableByName(".virtual{7}");
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_6_, var__virtual_7_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement", "name")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_7_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "String")));
          new Equality(body, var__virtual_7_, var__virtual_4_);
          // 	Dependency.supplier(dep, requirement)
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Dependency")));
          PVariable var__virtual_8_ = body.getOrCreateVariableByName(".virtual{8}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep, var__virtual_8_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Dependency", "supplier")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_8_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement")));
          new Equality(body, var__virtual_8_, var_requirement);
          // 	Dependency.client(dep, realizingElement)
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Dependency")));
          PVariable var__virtual_9_ = body.getOrCreateVariableByName(".virtual{9}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_dep, var__virtual_9_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "Dependency", "client")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_9_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://www.nomagic.com/magicdraw/UML/2.5.1", "NamedElement")));
          new Equality(body, var__virtual_9_, var_realizingElement);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
