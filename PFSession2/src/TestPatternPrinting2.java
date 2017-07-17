import static org.junit.Assert.*;

import org.junit.Test;



import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class TestPatternPrinting2 {
	
	/*
	 * this test will check pyramid pattern for a given max value
	 */
	@Test
	public void test() {
		int max = Integer.parseInt("5");
		PatternPrinting2 pattern = new PatternPrinting2();
		String result[] = pattern.printPyramid(max);
		String expected[] = {   "12345",
								" 1234",
								"  123",
								"   12",
								"    1"};
		Assert.assertArrayEquals(expected,result);
	}
	/*
	 * this test will check exception for a given max value
	 */
	@Test
	public void testException() 
	{
		try
		{
			int max = -1;
			PatternPrinting2 pattern = new PatternPrinting2();
			pattern.printPyramid(max);
		}
		catch(IllegalArgumentException exception)
		{
			System.out.println("An Exception occured");
		}
	}
	/*
	 * this test will check the spaces generated for a given row and max value
	 */
	@Test
	public void testSpace() {
			int max = 5;
			int row = 1;
			String result = PatternPrinting2.spaces(row, max);
			String expected = "";
			assertEquals(expected,result);
	}
	
	/*
	 * this test will check the numbers generated for a given row and max value
	 */
	@Test
	public void testNumbers() {
			int max = 5;
			int row = 1;
			String result = PatternPrinting2.numbers(row, max);
			String expected = "12345";
			assertEquals(expected,result);
	}
}
