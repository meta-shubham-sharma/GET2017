/**
 * class to print a Pyramid
 * @author shubham
 *
 */
public class PatternPrinting {
				
	/*
	 *  method returns a string of spaces using parameters row and maximum value to print 
	 */
		public static String spaces(int row,int max)
		{
			String spaces = "";
			if(row>max)
			{
				row = row-max;
				for(int index=1;index<=row;index++)
					{
						spaces+=" ";
					}
			}
			else
			{
				for(int index = row;index<max;index++)
					{
						spaces+=" ";
					}
			}
			return spaces;
		}
		/*
		 *  method returns a string of numbers using parameters row and maximum value to print 
		 */
		public static String numbers(int row,int max)
		{
			String numbers = "";
			if(row>max)
			{
				int dif = row-max;
				row = max-dif;
			}
				for(int index = 1;index<=row;index++)
				{
					numbers+=index;
					if(index==row)
					{
						while(index>1)
						{
							index--;
							numbers+=index;
						}
						break;
					}
				}	
			return numbers;
		}
		/*
		 *  method returns an array of string using maximum value to print and print pattern
		 */
		public String[] printPyramid(int max) throws IllegalArgumentException 
		{
			if(max<1)
			{
				throw new IllegalArgumentException();
			}
			String space;
			String number;
			String result[] = new String[2*max-1];
			for(int index = 1;index<=2*max-1;index++)
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
				PatternPrinting pattern = new PatternPrinting();
				String result[] = pattern.printPyramid(max);
				for(int index = 0;index<2*max-1;index++)
					System.out.println(result[index]);
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("An Exception occured");	
			}
			
		}
		
}
