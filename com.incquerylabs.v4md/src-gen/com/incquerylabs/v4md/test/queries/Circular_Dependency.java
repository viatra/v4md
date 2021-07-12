/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Circular_Dependency.vql
 */
package com.incquerylabs.v4md.test.queries;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Circular_Dependency.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Circular_Dependency.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>CircularDependencyError</li>
 * <li>DependencyChain</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Circular_Dependency extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Circular_Dependency instance() {
    if (INSTANCE == null) {
        INSTANCE = new Circular_Dependency();
    }
    return INSTANCE;
  }
  
  private static Circular_Dependency INSTANCE;
  
  private Circular_Dependency() {
    querySpecifications.add(CircularDependencyError.instance());
    querySpecifications.add(DependencyChain.instance());
  }
  
  public CircularDependencyError getCircularDependencyError() {
    return CircularDependencyError.instance();
  }
  
  public CircularDependencyError.Matcher getCircularDependencyError(final ViatraQueryEngine engine) {
    return CircularDependencyError.Matcher.on(engine);
  }
  
  public DependencyChain getDependencyChain() {
    return DependencyChain.instance();
  }
  
  public DependencyChain.Matcher getDependencyChain(final ViatraQueryEngine engine) {
    return DependencyChain.Matcher.on(engine);
  }
}
