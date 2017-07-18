import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class TestQuickSort {

	// this test will check quick sort for a given unsorted array of positive values
	@Test
	public void test() {
		int array[] = {2,5,8,9,10,77,55,99,34,88};
		QuickSort qs = new QuickSort();
		int result[] = qs.quickSort(array,0,array.length-1);
		int expected[] = {2,5,8,9,10,34,55,77,88,99};
		Assert.assertArrayEquals(expected, result);
	}
	
	// this test will check quick sort for a given unsorted array with negative values
	@Test
	public void testNegative() {
		int array[] = {2,5,8,9,10,-77,55,99,34,88};
		QuickSort qs = new QuickSort();
		int result[] = qs.quickSort(array,0,array.length-1);
		int expected[] = {-77,2,5,8,9,10,34,55,88,99};
		Assert.assertArrayEquals(expected, result);
	}
	
	// this test will check quick sort for a given sorted array in descending order
	@Test
	public void testDescending() {
		int array[] = {10,9,8,7,6,5,4};
		QuickSort qs = new QuickSort();
		int result[] = qs.quickSort(array,0,array.length-1);
		int expected[] = {4,5,6,7,8,9,10};
		Assert.assertArrayEquals(expected, result);
	}

	// this test will check quick sort for null array
		@Test
		public void testNull() {
			int array[] = {};
			QuickSort qs = new QuickSort();
			int result[] = qs.quickSort(array,0,array.length-1);
			int expected[] = {};
			Assert.assertArrayEquals(expected, result);
		}	
}
