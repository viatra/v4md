/**
 * Generated from platform:/resource/com.incquerylabs.v4md.snapshotmaker/src/main/java/com/incquerylabs/v4md/test/queries/Check_Expression.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.ClassesWithNameThatContainsID;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Check_Expression.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Check_Expression.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>classesWithNameThatContainsID</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Check_Expression extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Check_Expression instance() {
    if (INSTANCE == null) {
        INSTANCE = new Check_Expression();
    }
    return INSTANCE;
  }
  
  private static Check_Expression INSTANCE;
  
  private Check_Expression() {
    querySpecifications.add(ClassesWithNameThatContainsID.instance());
  }
  
  public ClassesWithNameThatContainsID getClassesWithNameThatContainsID() {
    return ClassesWithNameThatContainsID.instance();
  }
  
  public ClassesWithNameThatContainsID.Matcher getClassesWithNameThatContainsID(final ViatraQueryEngine engine) {
    return ClassesWithNameThatContainsID.Matcher.on(engine);
  }
}
