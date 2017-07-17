import static org.junit.Assert.*;

import org.junit.Test;


import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class TestPatternPrinting {

	/*
	 * this test will check pyramid pattern for a given max value
	 */
	@Test
	public void testPyramid() {
		try
		{
			int max = Integer.parseInt("5");
				PatternPrinting pattern = new PatternPrinting();
				String result[] = pattern.printPyramid(max);
						String expected[] ={"    1    ",
											"   121   ",
											"  12321  ",
											" 1234321 ",
											"123454321",
											" 1234321 ",
											"  12321  ",
											"   121   ",
											"    1    "};
				Assert.assertArrayEquals(expected,result);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("An Exception occured");	
		}
	}
	
	@Test
	public void test()
	{
		try
		{
			int max = -1;
			PatternPrinting pattern = new PatternPrinting();
			pattern.printPyramid(max);
		}
		catch(IllegalArgumentException e)
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
			String result = PatternPrinting.spaces(row, max);
			String expected = "    ";
			assertEquals(expected,result);
	}
	
	/*
	 * this test will check the numberes generated for a given row and max value
	 */
	@Test
	public void testNumbers() {
			int max = 5;
			int row = 1;
			String result = PatternPrinting.numbers(row, max);
			String expected = "1";
			assertEquals(expected,result);
	}

}

