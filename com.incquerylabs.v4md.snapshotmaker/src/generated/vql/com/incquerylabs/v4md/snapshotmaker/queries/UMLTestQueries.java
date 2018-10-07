/**
 * Generated from platform:/resource/com.incquerylabs.v4md.snapshotmaker/src/main/java/com/incquerylabs/v4md/snapshotmaker/queries/UMLTestQueries.vql
 */
package com.incquerylabs.v4md.snapshotmaker.queries;

import com.incquerylabs.v4md.snapshotmaker.queries.CompnoentsWithName;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in UMLTestQueries.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file UMLTestQueries.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.snapshotmaker.queries, the group contains the definition of the following patterns: <ul>
 * <li>CompnoentsWithName</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class UMLTestQueries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static UMLTestQueries instance() {
    if (INSTANCE == null) {
        INSTANCE = new UMLTestQueries();
    }
    return INSTANCE;
  }
  
  private static UMLTestQueries INSTANCE;
  
  private UMLTestQueries() {
    querySpecifications.add(CompnoentsWithName.instance());
  }
  
  public CompnoentsWithName getCompnoentsWithName() {
    return CompnoentsWithName.instance();
  }
  
  public CompnoentsWithName.Matcher getCompnoentsWithName(final ViatraQueryEngine engine) {
    return CompnoentsWithName.Matcher.on(engine);
  }
}
