import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class TestAssignment6 {

///// this test is to join sorted arrays when all elements are different in both arrays 
	@Test
	public void test() {
		Assignment6 a6=new Assignment6();
		int input1[]={1,2};
		int input2[]={3,4,5};
		int check[]= a6.join(input1, 2, input2, 3);
		int expected[]={1,2,3,4,5};
		Assert.assertArrayEquals(expected, check);
	}
	
	// when some of elements are same in both the array
		@Test
		public void testOnSameElements() {
			int input1[] = { 1, 2, 3, 4, 5, 6, 7 };
			int input2[] = { 0, 2, 3, 11, 12, 13, 14 };
			int expected[] = { 0, 1, 2, 2, 3, 3, 4, 5, 6, 7, 11, 12, 13, 14 };
			Assignment6 a6=new Assignment6();
			int actual[] = a6.join(input1, 7,input2,7);
			Assert.assertArrayEquals(expected, actual);
		}

		// when one of the array is null
		@Test
		public void testOnEmpty() {
			int input1[] = {};
			int input2[] = { 0, 2, 3, 11, 12, 13, 14 };
			int expected[] = { 0, 2, 3, 11, 12, 13, 14 };
			Assignment6 a6=new Assignment6();
			int actual[] = a6.join(input1,0, input2,7);
			Assert.assertArrayEquals(expected, actual);
		}

		//// when arrays are sorted differently
		@Test
		public void testOnDifferentOrder() {
			int input1[] = {5,4,3,2};
			int input2[] = {10,9,8,7,0};
			int expected[] = {0,2,3,4,5,7,8,9,10};
			Assignment6 a6=new Assignment6();
			int actual[] = a6.join(input1, 4, input2, 5);
			Assert.assertArrayEquals(expected, actual);
		}
}
