/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Aggregator_Functions.vql
 */
package com.incquerylabs.v4md.test.queries;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Aggregator_Functions.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Aggregator_Functions.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>classes</li>
 * <li>classAttributes</li>
 * <li>classNumberOfAttributes</li>
 * <li>classWithMaxNumberOfAttributes</li>
 * <li>sumOfClassAttributes</li>
 * <li>averageNumberOfAttributes</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Aggregator_Functions extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Aggregator_Functions instance() {
    if (INSTANCE == null) {
        INSTANCE = new Aggregator_Functions();
    }
    return INSTANCE;
  }
  
  private static Aggregator_Functions INSTANCE;
  
  private Aggregator_Functions() {
    querySpecifications.add(Classes.instance());
    querySpecifications.add(ClassAttributes.instance());
    querySpecifications.add(ClassNumberOfAttributes.instance());
    querySpecifications.add(ClassWithMaxNumberOfAttributes.instance());
    querySpecifications.add(SumOfClassAttributes.instance());
    querySpecifications.add(AverageNumberOfAttributes.instance());
  }
  
  public Classes getClasses() {
    return Classes.instance();
  }
  
  public Classes.Matcher getClasses(final ViatraQueryEngine engine) {
    return Classes.Matcher.on(engine);
  }
  
  public ClassAttributes getClassAttributes() {
    return ClassAttributes.instance();
  }
  
  public ClassAttributes.Matcher getClassAttributes(final ViatraQueryEngine engine) {
    return ClassAttributes.Matcher.on(engine);
  }
  
  public ClassNumberOfAttributes getClassNumberOfAttributes() {
    return ClassNumberOfAttributes.instance();
  }
  
  public ClassNumberOfAttributes.Matcher getClassNumberOfAttributes(final ViatraQueryEngine engine) {
    return ClassNumberOfAttributes.Matcher.on(engine);
  }
  
  public ClassWithMaxNumberOfAttributes getClassWithMaxNumberOfAttributes() {
    return ClassWithMaxNumberOfAttributes.instance();
  }
  
  public ClassWithMaxNumberOfAttributes.Matcher getClassWithMaxNumberOfAttributes(final ViatraQueryEngine engine) {
    return ClassWithMaxNumberOfAttributes.Matcher.on(engine);
  }
  
  public SumOfClassAttributes getSumOfClassAttributes() {
    return SumOfClassAttributes.instance();
  }
  
  public SumOfClassAttributes.Matcher getSumOfClassAttributes(final ViatraQueryEngine engine) {
    return SumOfClassAttributes.Matcher.on(engine);
  }
  
  public AverageNumberOfAttributes getAverageNumberOfAttributes() {
    return AverageNumberOfAttributes.instance();
  }
  
  public AverageNumberOfAttributes.Matcher getAverageNumberOfAttributes(final ViatraQueryEngine engine) {
    return AverageNumberOfAttributes.Matcher.on(engine);
  }
}
