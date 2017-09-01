package com.metacube.sortingSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

	/**
	 * 
	 * @param array
	 * @return String of sorted numbers
	 */
	public static String RadixSorts(int[] array) {

		int kindex = 0, size = array.length - 1;

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
		int index, max = array[0], exponent = 1, size = array.length;
		int[] output = new int[10];
		// get maximum number from array
		for (index = 1; index < size; index++) {
			if (array[index] > max)
				max = array[index];
		}

		// traverse loop till maximum number is zero
		while (max / exponent > 0) {
			int[] bucket = new int[10];

			// place the last digit of number in a bucket
			for (index = 0; index < size; index++)
				bucket[(array[index] / exponent) % 10]++;

			// get the position of number where it is to be placed in the output
			for (index = 1; index < 10; index++)
				bucket[index] += bucket[index - 1];

			// place the number at position of bucket value
			for (index = size - 1; index >= 0; index--) {
				output[--bucket[(array[index] / exponent) % 10]] = array[index];
			}

			// copy output array back to input array
			for (index = 0; index < size; index++)
				array[index] = output[index];

			// exponent is multiplied by 10
			exponent *= 10;
		}
		return array;
	}
}
