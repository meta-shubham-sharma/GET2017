/*
 * class to compute remainder using recursive calls
 */
public class Remainder {
	/**
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static int rem(int num1,int num2)
	{
		int result = num1;
		if(num1 >= num2)
		{
			num1 = num1-num2;					// subtract the second number from the first one till it is lesser
			result = rem(num1,num2);
		}
		return result;
	}
	public static void main(String args[])
	{
		try
		{
			int num1 = 100,num2 = 3;
			if(num2==0)
			{
				throw new ArithmeticException();
			}
			int result = rem(num1, num2);
			System.out.println(result);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Divided by zero");
		}
	}
}
