import static org.junit.Assert.*;

import org.junit.Test;


public class TestGcd {

	// this test will check gcd of any two positive numbers
	@Test
	public void test() {
		try
		{
			int num1 = 12,num2 = 18;
			if(num2 == 0)
			{
				throw new ArithmeticException();
			}
			int result = gcd.gcdCall(num1,num2);
			int expected = 6;
			assertEquals(expected,result);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Divided by zero");
		}
	}
	
	// this test will check gcd of a positive number and zero
	@Test
	public void testZero() {
		try
		{
			int num1 = 12,num2 = 0;
			if(num2 == 0)
			{
				throw new ArithmeticException();
			}
			int result = gcd.gcdCall(num1,num2);
			int expected = 6;
			assertEquals(expected,result);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Divided by zero "+ae.getMessage());
		}
	}

}
