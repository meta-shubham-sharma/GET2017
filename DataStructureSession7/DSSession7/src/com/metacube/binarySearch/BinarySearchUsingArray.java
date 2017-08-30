package com.metacube.binarySearch;

public class BinarySearchUsingArray {
	
	/**
	 * 
	 * @param arr
	 * @param low
	 * @param high
	 * @param value
	 * @return first index where value occurs 
	 */
	public static int search(int arr[], int low, int high, int value)
    {
        if(high >= low)
        {
            int mid = low + (high - low)/2;
            if( ( mid == 0 || value > arr[mid-1]) && arr[mid] == value)
                return mid;
             else if(value > arr[mid])
                return search(arr, (mid + 1), high, value);
            else
                return search(arr, low, (mid -1), value);
        }
    return -1;
    }
}
