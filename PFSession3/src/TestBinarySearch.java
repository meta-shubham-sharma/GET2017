import static org.junit.Assert.*;

import org.junit.Test;


public class TestBinarySearch {

	// this test will check if number is present
	@Test
	public void testElementFound() {
		int array[] = {2,5,8,9,10, 55, 77};
		int num = 77;
		int result = BinarySearch.search(array,num,0,array.length-1);
		int expected = 1;
		assertEquals(expected,result);
	}

	// this test will check if number is not present
	@Test
	public void testElementNotFound() {
		int array[] = {2,5,8,9,10, 55, 77};
		int num = 88;
		int result = BinarySearch.search(array,num,0,array.length-1);
		int expected = 0;
		assertEquals(expected,result);
	}
	
	// this test will check if only one number is present
	@Test
	public void testOneElement() {
		int array[] = {2};
		int num = 2;
		int result = BinarySearch.search(array,num,0,array.length-1);
		int expected = 1;
		assertEquals(expected,result);
	}
	
	
}
