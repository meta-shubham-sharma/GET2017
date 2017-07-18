/*
 * class to compute largest digit from a given number
 */
public class LargestDigit {
	
	int digitPre=0,digitNow=0; 
	/**
	 * 
	 * @param num
	 * @return largest digit
	 */
	public int largest(int num)
	{
		digitPre = digitNow;
		if(num != 0)
		{
			digitNow = num % 10;
			num = num / 10;	
			digitNow = compare(digitNow,digitPre);
			largest(num);
		}
		return digitNow;
	}
	public static int compare(int num1, int num2)
	{
		if(num1>num2)
		{
			return num1;
		}
		else
		{
			return num2;
		}
	}
	public static void main(String args[])
	{
		int num = 659954827;
		LargestDigit ld = new LargestDigit();
		int result = ld.largest(num);
		System.out.println(result);
	}
}
