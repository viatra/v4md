/**
 * Generated from platform:/resource/com.incquerylabs.v4md/src/test/com/incquerylabs/v4md/test/queries/Non_Unique_Names.vql
 */
package com.incquerylabs.v4md.test.queries;

import com.incquerylabs.v4md.test.queries.IDStringPropertyEqualityError;
import com.incquerylabs.v4md.test.queries.PropertyStringValueEquals;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in Non_Unique_Names.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file Non_Unique_Names.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.incquerylabs.v4md.test.queries, the group contains the definition of the following patterns: <ul>
 * <li>IDStringPropertyEqualityError</li>
 * <li>PropertyStringValueEquals</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Non_Unique_Names extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Non_Unique_Names instance() {
    if (INSTANCE == null) {
        INSTANCE = new Non_Unique_Names();
    }
    return INSTANCE;
  }
  
  private static Non_Unique_Names INSTANCE;
  
  private Non_Unique_Names() {
    querySpecifications.add(IDStringPropertyEqualityError.instance());
    querySpecifications.add(PropertyStringValueEquals.instance());
  }
  
  public IDStringPropertyEqualityError getIDStringPropertyEqualityError() {
    return IDStringPropertyEqualityError.instance();
  }
  
  public IDStringPropertyEqualityError.Matcher getIDStringPropertyEqualityError(final ViatraQueryEngine engine) {
    return IDStringPropertyEqualityError.Matcher.on(engine);
  }
  
  public PropertyStringValueEquals getPropertyStringValueEquals() {
    return PropertyStringValueEquals.instance();
  }
  
  public PropertyStringValueEquals.Matcher getPropertyStringValueEquals(final ViatraQueryEngine engine) {
    return PropertyStringValueEquals.Matcher.on(engine);
  }
}
