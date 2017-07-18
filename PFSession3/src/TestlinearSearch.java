import static org.junit.Assert.*;

import org.junit.Test;


public class TestlinearSearch {

	// this test will check a number in array
	@Test
	public void testNumberPresent() {
		int array[] = {2,5,8,9,10, 77, 55};
		int num = 77;
		LinearSearch ls = new LinearSearch();
		int result = ls.search(array, num);
		int expected = 1;
		assertEquals(expected,result);
	}

	// this test will check a number in array
		@Test
		public void testNumberNotPresent() {
			int array[] = {2,5,8,9,10, 77, 55};
			int num = 88;
			LinearSearch ls = new LinearSearch();
			int result = ls.search(array, num);
			int expected = 0;
			assertEquals(expected,result);
		}
}
