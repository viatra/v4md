/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Port_Connections.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.PortConnections;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Port_Connections.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Port_Connections.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>PortConnections</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Port_Connections extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Port_Connections instance() {
    if (INSTANCE == null) {
        INSTANCE = new Port_Connections();
    }
    return INSTANCE;
  }
  
  private static Port_Connections INSTANCE;
  
  private Port_Connections() {
    querySpecifications.add(PortConnections.instance());
  }
  
  public PortConnections getPortConnections() {
    return PortConnections.instance();
  }
  
  public PortConnections.Matcher getPortConnections(final ViatraQueryEngine engine) {
    return PortConnections.Matcher.on(engine);
  }
}
