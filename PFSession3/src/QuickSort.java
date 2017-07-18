/*
 * class to perform quickSort for a given array
 */
public class QuickSort {
	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return sorted array 
	 */
	public int[] quickSort(int array[],int start,int end)
	{
		if(start <= end)
		{
			int part = partition(array,start,end);				
			array = quickSort(array,start,part-1);	
			array = quickSort(array,part+1,end);
		}
		return array;
	}
	/**
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return partition which has lesser elements on left and greater on right 
	 */
	public static int partition(int array[],int start,int end)
	{
		int index = start ,current = start;
		int pivot = array[end];
		while(current < end)								// current value is checked till the end
		{
			if(array[current] <= pivot)
			{
				if(index != current)
				{
					array = swap(array,index,current);		// exchange two numbers of array if current element in array is lesser than pivot
				}													 	
				index++;									// increase the index here
			}
			current++;
		}
		array = swap(array,index,end);						// pivot is exchanged with the element at index 
		return index;
	}
	public static int[] swap(int[] arr,int num1,int num2)
	{
		int temp = arr[num2];
		arr[num2] = arr[num1];
		arr[num1] = temp;
		return arr;
	}
	
	public static void main(String args[])
	{
		int array[] = {2,5,8,9,10,77,55,99,34,88};
		QuickSort qs = new QuickSort();
		int result[] = qs.quickSort(array,0,array.length-1);
		for(int index = 0;index < result.length ; index++ )
		{
			System.out.print(result[index]+" ");
		}
	}	
}
