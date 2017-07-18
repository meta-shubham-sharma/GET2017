/*
 * class to perform binary search for sorted array
 */
public class BinarySearch {
	/**
	 * 
	 * @param array
	 * @param num
	 * @param start
	 * @param end
	 * @return 1 if number found else return 0
	 */
	public static int search(int array[],int num,int start,int end)
	{
		if(end >= start)
		{
			int mid = (end + start)/2 ;
			if(array[mid] == num)
			{
				return 1;
			}
			else if(num < array[mid])
			{
				return search(array,num,0,mid-1);
			}
			else
			{
				return search(array,num,mid+1,end);
			}
		}
		else
		{
			return 0;
		}
	}
	public static void main(String args[])
	{
		int array[] = {2,5,8,9,10, 88, 77};
		int num = 88;
		int result = search(array,num,0,array.length-1);
		System.out.println(result);
	}
}
