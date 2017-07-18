/*
 * class to compute gcd through recursion
 */
public class gcd {
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return the greatest common divisor
	 */
	public static int gcdCall(int num1,int num2) 
	{
		if(num2 > num1)
		{
			int temp = num2;
			num2 = num1;
			num1 = temp;
		}
		if(num2 != 0 )
		{
			return gcdCall(num2,num1%num2);  // call gcd for second number and modulus of two numbers
		}
		else
		{
			return num1;
		}
	}
	public static void main(String args[])
	{
		try
		{
			int num1 = 4,num2 = 2;
			if(num2 == 0)
			{
				throw new ArithmeticException();
			}
			int result = gcdCall(num1,num2);
			System.out.println(result);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Divided by zero");
		}
	}
}
