/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Pattern_Constraints.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.ClassesWithSameNamedProperty;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Pattern_Constraints.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Pattern_Constraints.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>classesWithSameNamedProperty</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Pattern_Constraints extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Pattern_Constraints instance() {
    if (INSTANCE == null) {
        INSTANCE = new Pattern_Constraints();
    }
    return INSTANCE;
  }
  
  private static Pattern_Constraints INSTANCE;
  
  private Pattern_Constraints() {
    querySpecifications.add(ClassesWithSameNamedProperty.instance());
  }
  
  public ClassesWithSameNamedProperty getClassesWithSameNamedProperty() {
    return ClassesWithSameNamedProperty.instance();
  }
  
  public ClassesWithSameNamedProperty.Matcher getClassesWithSameNamedProperty(final ViatraQueryEngine engine) {
    return ClassesWithSameNamedProperty.Matcher.on(engine);
  }
}
