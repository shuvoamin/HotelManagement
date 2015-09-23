package unitTesting;

import org.junit.Test;

import xml.XMLOutput;
import junit.framework.TestCase;


public class XMLOutputTest extends TestCase {
	XMLOutput xml;


	protected void setUp() throws Exception {
		xml = new XMLOutput();
	}



	/*
	 * Setup a minimal test just to illustrate JUnit usage 
	 * Note: This is not an example of a 'good' test - why? 
	 */
	@Test
	public void testSimpleObjectTest()
	{

		assertTrue(xml != null);

	}

	/*
	 * Another test that should 'pass'
	 */
	@Test
	public void testCompareXMLObjectToString()
	{
		assertFalse(xml.equals(new String()));
	}


	/*
	 * Finally a failing test
	 */
	@Test
	public void testNoOpALwaysFalseTest()
	{
		assertTrue(1==0);
	}


}
