import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class TestAssignment3 {

	// this test will check input array
	@Test
	public void test() {
		int input[]={1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		int expected[]={1,2,4,5,6,7,8,9};
		Assignment3 a3=new Assignment3();
		int result[]=a3.longestSequence(input);
		Assert.assertArrayEquals(expected, result);
	}
	
	// this test will check if all the elements of array are same
		@Test
		public void testWhenAllInputAreSame() {
			int input[] = { 1, 1, 1, 1, 1, 1, 1 };
			Assignment3 a3=new Assignment3();
			int actual[] = a3.longestSequence(input);
			int expected[] = { 1 };
			Assert.assertArrayEquals(expected, actual);
		}

}
