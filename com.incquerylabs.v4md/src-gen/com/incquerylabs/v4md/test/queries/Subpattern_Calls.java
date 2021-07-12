/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Subpattern_Calls.vql
 */
package com.incquerylabs.v4md.test.queries;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Subpattern_Calls.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Subpattern_Calls.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>blocksWithNonEmptyName</li>
 * <li>classesWithEmptyName</li>
 * <li>blocks</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Subpattern_Calls extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Subpattern_Calls instance() {
    if (INSTANCE == null) {
        INSTANCE = new Subpattern_Calls();
    }
    return INSTANCE;
  }
  
  private static Subpattern_Calls INSTANCE;
  
  private Subpattern_Calls() {
    querySpecifications.add(BlocksWithNonEmptyName.instance());
    querySpecifications.add(ClassesWithEmptyName.instance());
    querySpecifications.add(Blocks.instance());
  }
  
  public BlocksWithNonEmptyName getBlocksWithNonEmptyName() {
    return BlocksWithNonEmptyName.instance();
  }
  
  public BlocksWithNonEmptyName.Matcher getBlocksWithNonEmptyName(final ViatraQueryEngine engine) {
    return BlocksWithNonEmptyName.Matcher.on(engine);
  }
  
  public ClassesWithEmptyName getClassesWithEmptyName() {
    return ClassesWithEmptyName.instance();
  }
  
  public ClassesWithEmptyName.Matcher getClassesWithEmptyName(final ViatraQueryEngine engine) {
    return ClassesWithEmptyName.Matcher.on(engine);
  }
  
  public Blocks getBlocks() {
    return Blocks.instance();
  }
  
  public Blocks.Matcher getBlocks(final ViatraQueryEngine engine) {
    return Blocks.Matcher.on(engine);
  }
}
