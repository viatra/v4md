/**
 * Generated from platform:/resource/com.incquerylabs.v4md.integrationtest/src/test/com/incquerylabs/v4md/test/queries/Requirement_Realization.vql
 */
package com.incquerylabs.v4md.test.queries;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Requirement_Realization.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Requirement_Realization.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>RequirementRealization</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Requirement_Realization extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Requirement_Realization instance() {
    if (INSTANCE == null) {
        INSTANCE = new Requirement_Realization();
    }
    return INSTANCE;
  }
  
  private static Requirement_Realization INSTANCE;
  
  private Requirement_Realization() {
    querySpecifications.add(RequirementRealization.instance());
  }
  
  public RequirementRealization getRequirementRealization() {
    return RequirementRealization.instance();
  }
  
  public RequirementRealization.Matcher getRequirementRealization(final ViatraQueryEngine engine) {
    return RequirementRealization.Matcher.on(engine);
  }
}
