/**
 * class to print a pattern
 * @author shubham
 *
 */
class PatternPrinting2 {
	/*
	 *  method returns a string of spaces using parameters row and maximum value to print 
	 */		
		public static String spaces(int row,int max)
		{
			String spaces = "";
			for(int index = 1;index<row;index++)
				{
					spaces+=" ";
				}
			return spaces;
		}
		/*
		 *  method returns a string of numbers using parameters row and maximum value to print 
		 */
		public static String numbers(int row,int max)
		{
			String numbers = "";
			for(int index = 1;index<=max+1-row;index++)
			{
				numbers+=index;
			}	
			return numbers;
		}
		/*
		 *  method returns an array of string using maximum value to print 
		 */
		public String[] printPyramid(int max) throws IllegalArgumentException
		{
			if(max<1)
			{
				throw new IllegalArgumentException();
			}
			String space;
			String number;
			String result[] = new String[max];
			for(int index = 1;index<=max;index++)
			{
				space = spaces(index,max);
				number = numbers(index,max);
				result[index-1] = space+number;
			}
			return result;
		}
		public static void main(String args[])
		{
			try
			{
				int max=Integer.parseInt("5");
				PatternPrinting2 pattern = new PatternPrinting2();
				String result[] = pattern.printPyramid(max);
				for(int index = 0;index<5;index++)
					System.out.println(result[index]);
			}
			catch(IllegalArgumentException exception)
			{
				System.out.println("An Exception occured");
			}
		}
		
}