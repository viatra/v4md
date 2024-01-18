/**
 * Generated from platform:/resource/com.incquerylabs.v4md.integrationtest/src/test/com/incquerylabs/v4md/test/queries/Block_With_More_than_1_Parent.vql
 */
package com.incquerylabs.v4md.test.queries;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Block_With_More_than_1_Parent.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Block_With_More_than_1_Parent.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>BlocksWithDeepGeneralizationHierarchy</li>
 * <li>MultipleInheritanceBlock</li>
 * <li>getSuperClasses</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Block_With_More_than_1_Parent extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Block_With_More_than_1_Parent instance() {
    if (INSTANCE == null) {
        INSTANCE = new Block_With_More_than_1_Parent();
    }
    return INSTANCE;
  }
  
  private static Block_With_More_than_1_Parent INSTANCE;
  
  private Block_With_More_than_1_Parent() {
    querySpecifications.add(BlocksWithDeepGeneralizationHierarchy.instance());
    querySpecifications.add(MultipleInheritanceBlock.instance());
    querySpecifications.add(GetSuperClasses.instance());
  }
  
  public BlocksWithDeepGeneralizationHierarchy getBlocksWithDeepGeneralizationHierarchy() {
    return BlocksWithDeepGeneralizationHierarchy.instance();
  }
  
  public BlocksWithDeepGeneralizationHierarchy.Matcher getBlocksWithDeepGeneralizationHierarchy(final ViatraQueryEngine engine) {
    return BlocksWithDeepGeneralizationHierarchy.Matcher.on(engine);
  }
  
  public MultipleInheritanceBlock getMultipleInheritanceBlock() {
    return MultipleInheritanceBlock.instance();
  }
  
  public MultipleInheritanceBlock.Matcher getMultipleInheritanceBlock(final ViatraQueryEngine engine) {
    return MultipleInheritanceBlock.Matcher.on(engine);
  }
  
  public GetSuperClasses getGetSuperClasses() {
    return GetSuperClasses.instance();
  }
  
  public GetSuperClasses.Matcher getGetSuperClasses(final ViatraQueryEngine engine) {
    return GetSuperClasses.Matcher.on(engine);
  }
}
