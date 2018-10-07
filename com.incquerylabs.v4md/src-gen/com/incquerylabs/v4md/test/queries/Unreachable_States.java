/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Unreachable_States.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.NotReachableFromInit;
import com.incquerylabs.v4md.test.queries.ReachableFromInitState;
import com.incquerylabs.v4md.test.queries.ReachableState;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Unreachable_States.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Unreachable_States.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>notReachableFromInit</li>
 * <li>reachableFromInitState</li>
 * <li>reachableState</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Unreachable_States extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Unreachable_States instance() {
    if (INSTANCE == null) {
        INSTANCE = new Unreachable_States();
    }
    return INSTANCE;
  }
  
  private static Unreachable_States INSTANCE;
  
  private Unreachable_States() {
    querySpecifications.add(NotReachableFromInit.instance());
    querySpecifications.add(ReachableFromInitState.instance());
    querySpecifications.add(ReachableState.instance());
  }
  
  public NotReachableFromInit getNotReachableFromInit() {
    return NotReachableFromInit.instance();
  }
  
  public NotReachableFromInit.Matcher getNotReachableFromInit(final ViatraQueryEngine engine) {
    return NotReachableFromInit.Matcher.on(engine);
  }
  
  public ReachableFromInitState getReachableFromInitState() {
    return ReachableFromInitState.instance();
  }
  
  public ReachableFromInitState.Matcher getReachableFromInitState(final ViatraQueryEngine engine) {
    return ReachableFromInitState.Matcher.on(engine);
  }
  
  public ReachableState getReachableState() {
    return ReachableState.instance();
  }
  
  public ReachableState.Matcher getReachableState(final ViatraQueryEngine engine) {
    return ReachableState.Matcher.on(engine);
  }
}
