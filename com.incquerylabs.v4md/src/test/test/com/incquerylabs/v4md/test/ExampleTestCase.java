package test.com.incquerylabs.v4md.test;

import com.nomagic.magicdraw.tests.MagicDrawTestCase;

public class ExampleTestCase extends MagicDrawTestCase{
	@Override
    protected void setUpTest() throws Exception
    {
        super.setUpTest();
        //do setup here
    }
 
    @Override
    protected void tearDownTest() throws Exception
    {
        super.tearDownTest();
        //do tear down here
    }
    
    public void testExample() {
    	assertEquals(true, true);
    }
    
}
