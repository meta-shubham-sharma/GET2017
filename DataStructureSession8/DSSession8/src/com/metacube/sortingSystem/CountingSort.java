package com.metacube.sortingSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSort {

	/**
	 * 
	 * @param array
	 * @return String of sorted numbers
	 */
	public static String CountingSorts(int array[]) {

		int size = array.length - 1, kindex = 0;

		// create 2 lists for positive and negative values
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		// add numbers to lists for negative and positive values
		for (int index = 0; index <= size; index++) {
			if (array[index] < 0) {
				list1.add(-1 * array[index]);
			} else {
				list2.add(array[index]);
			}
		}

		// add to negative array only when list of negatives is not empty
		if (!list1.isEmpty()) {
			int[] negativeArray = list1.stream().mapToInt(i -> i).toArray();
			int array1[] = sort(negativeArray);
			for (int index = array1.length - 1; index >= 0; index--) {
				array[kindex++] = -1 * array1[index];
			}
		}

		// add to positive array only when list of positives is not empty
		if (!list2.isEmpty()) {
			int[] positiveArray = list2.stream().mapToInt(i -> i).toArray();
			int array2[] = sort(positiveArray);
			for (int index = 0; index < array2.length; index++) {
				array[kindex++] = array2[index];
			}
		}

		return Arrays.toString(array);
	}

	public static int[] sort(int array[]) {

		int size = array.length - 1;
		int output[] = new int[size + 1];

		// get maximum value from array
		int max = array[0];
		for (int index = 1; index <= size; index++) {
			if (array[index] > max) {
				max = array[index];
			}
		}

		// increase count of each number in an array count
		int count[] = new int[max + 1];
		for (int index = 0; index <= size; index++) {
			count[array[index]] += 1;
		}

		// get position of each element by taking sum of array
		for (int index = 1; index < count.length; index++) {
			count[index] += count[index - 1];
		}

		// place the numbers in output array at index given by count array
		for (int index = 0; index <= size; index++) {
			output[count[array[index]] - 1] = array[index];
			count[array[index]] -= 1;
		}

		// copy output array back to input array
		for (int index = 0; index <= size; index++) {
			array[index] = output[index];
		}
		return array;
	}
}
