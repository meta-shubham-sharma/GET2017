package com.metacube.sortingSystem;

import java.util.Arrays;

public class CountingSort {

	/**
	 * 
	 * @param array
	 * @return String of sorted numbers
	 */
	public static String sort(int array[]) {

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

		return Arrays.toString(array);
	}
}
