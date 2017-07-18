/*
 * class to perform linear search
 */
public class LinearSearch {
	int index = 0;
	/**
	 * 
	 * @param array
	 * @param num
	 * @return 1 if number is found else return 0
	 */
	public int search(int array[],int num)
	{
		if(array[index] == num)
		{
			return 1;
		}
		else
		{
			index++;
			if(index != array.length)
			{
				return search(array,num);
			}
			else
			{
				return 0;
			}
		}
	}
	public static void main(String args[])
	{
		int array[] = {2,5,8,9,10, 77, 55};
		int num = 77;
		LinearSearch ls = new LinearSearch();
		int result = ls.search(array, num);
		System.out.print(result);
	}
}
