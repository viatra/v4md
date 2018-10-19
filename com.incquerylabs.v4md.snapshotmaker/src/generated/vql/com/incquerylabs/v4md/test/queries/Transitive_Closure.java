/**
 * Generated from platform:/resource/com.incquerylabs.v4md.snapshotmaker/src/main/java/com/incquerylabs/v4md/test/queries/Transitive_Closure.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.GetSuperClass;
import com.incquerylabs.v4md.test.queries.GetSuperClassOrSelf;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Transitive_Closure.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Transitive_Closure.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>getSuperClassOrSelf</li>
 * <li>getSuperClass</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Transitive_Closure extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Transitive_Closure instance() {
    if (INSTANCE == null) {
        INSTANCE = new Transitive_Closure();
    }
    return INSTANCE;
  }
  
  private static Transitive_Closure INSTANCE;
  
  private Transitive_Closure() {
    querySpecifications.add(GetSuperClassOrSelf.instance());
    querySpecifications.add(GetSuperClass.instance());
  }
  
  public GetSuperClassOrSelf getGetSuperClassOrSelf() {
    return GetSuperClassOrSelf.instance();
  }
  
  public GetSuperClassOrSelf.Matcher getGetSuperClassOrSelf(final ViatraQueryEngine engine) {
    return GetSuperClassOrSelf.Matcher.on(engine);
  }
  
  public GetSuperClass getGetSuperClass() {
    return GetSuperClass.instance();
  }
  
  public GetSuperClass.Matcher getGetSuperClass(final ViatraQueryEngine engine) {
    return GetSuperClass.Matcher.on(engine);
  }
}
