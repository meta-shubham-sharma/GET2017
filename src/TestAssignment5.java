import static org.junit.Assert.*;

import org.junit.Test;


public class TestAssignment5 {

	///// this test is used to check ascending sequence
	@Test
	public void testAscending() {
		Assignment5 a5=new Assignment5();
		int n[]={1,2,3,4};
		int result= a5.check(n);
		assertEquals(1, result);
	}

///// this test is used to check descending sequence
	@Test
	public void testDescending() 
	{
		Assignment5 a5=new Assignment5();
		int n[]={4,3,2,1};
		int result= a5.check(n);
		assertEquals(2, result);
	}
	
///// this test is used to check unsorted sequence
	@Test
	public void testNotSorted() 
	{
		Assignment5 a5=new Assignment5();
		int n[]={5,2,6,4};
		int result= a5.check(n);
		assertEquals(0, result);
	}

}
