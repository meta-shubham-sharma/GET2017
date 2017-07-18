import static org.junit.Assert.*;

import org.junit.Test;


public class TestRemainder {

	//this test will check remainder for all the positive numbers
	@Test
	public void testPositiveNumbers() 
	{
		try
		{
			int num1 = 100,num2 = 3;
			if(num2==0)
			{
				throw new ArithmeticException();
			}
			int result = Remainder.rem(num1, num2);
			int expected = 1;
			assertEquals(expected,result);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Divided by zero");
		}
	}

	//this test will check remainder in case of zero
	@Test
	public void testZero() 
	{
		try
		{
			int num1 = 100,num2 = 0;
			if(num2==0)
			{
				throw new ArithmeticException();
			}
			Remainder.rem(num1, num2);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Divided by zero " + ae.getMessage());
		}
	}
}
