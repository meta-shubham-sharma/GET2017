import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class TestAssignment2 {

	@Test
	public void test() {
		Assignment2 a2=new Assignment2();
		int input[]={1,2,3,1,1,4};
		int expected[]={1,2,3,4};
		int a[]=a2.removeDuplicate(input);
		Assert.assertArrayEquals(expected, a);
	}
	
	// test when array is empty
		@Test
		public void testWhenArrayIsEmpty() {
			int input[] = {};
			Assignment2 a2=new Assignment2();
			int actual[] = a2.removeDuplicate(input);
			int expected[] = {};
			Assert.assertArrayEquals(expected, actual);
		}
		
		// test when all elements are different
		@Test
		public void testWhenAllElementsAreDifferent() {
			int input[] = { 1, 2, 3, 4, 5, 6 };
			Assignment2 a2=new Assignment2();
			int actual[] = a2.removeDuplicate(input);
			int expected[] = { 1, 2, 3, 4, 5, 6 };
			Assert.assertArrayEquals(expected, actual);
		}

}
