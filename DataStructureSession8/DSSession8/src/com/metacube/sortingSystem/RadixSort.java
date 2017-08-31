package com.metacube.sortingSystem;

import java.util.Arrays;

public class RadixSort {

	/**
	 * 
	 * @param array
	 * @return String of sorted numbers
	 */
	public static String sort(int[] array) {

		int index, max = array[0], exponenet = 1, size = array.length;

		int[] output = new int[10];

		// get maximum number from array
		for (index = 1; index < size; index++) {
			if (array[index] > max)
				max = array[index];
		}

		// traverse loop till maximum number is zero
		while (max / exponenet > 0) {
			int[] bucket = new int[10];

			// place the last digit of number in a bucket
			for (index = 0; index < size; index++)
				bucket[(array[index] / exponenet) % 10]++;

			// get the position of number where it is to be placed in the output
			for (index = 1; index < 10; index++)
				bucket[index] += bucket[index - 1];

			// place the number at position of bucket value
			for (index = size - 1; index >= 0; index--) {
				output[--bucket[(array[index] / exponenet) % 10]] = array[index];
			}

			// copy output array back to input array
			for (index = 0; index < size; index++)
				array[index] = output[index];

			// exponent is multiplied by 10
			exponenet *= 10;
		}
		return Arrays.toString(array);
	}
}
