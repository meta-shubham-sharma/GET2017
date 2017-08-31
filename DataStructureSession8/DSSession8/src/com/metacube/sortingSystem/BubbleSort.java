package com.metacube.sortingSystem;

import java.util.Arrays;

public class BubbleSort {

	/**
	 * 
	 * @param array
	 * @return string of sorted array
	 */
	public static String bubbleSort(int array[]) {

		int size = array.length - 1;
		for (int index = 0; index < size; index++) {
			for (int jindex = 0; jindex < size - index; jindex++) {
				if (array[jindex] > array[jindex + 1]) {
					int temp = array[jindex];
					array[jindex] = array[jindex + 1];
					array[jindex + 1] = temp;
				}
			}
		}
		return Arrays.toString(array);
	}

}
