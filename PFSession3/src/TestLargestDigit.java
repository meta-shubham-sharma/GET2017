import static org.junit.Assert.*;

import org.junit.Test;


public class TestLargestDigit {

	// this test will check largest digit from a given number
	@Test
	public void test() {
		int num = 156499876;
		LargestDigit ld = new LargestDigit();
		int result = ld.largest(num);
		int expected = 9;
		assertEquals(expected,result);
	}

	// this test will check largest digit from a one digit number
		@Test
		public void testSingleDigit() {
			int num = 9;
			LargestDigit ld = new LargestDigit();
			int result = ld.largest(num);
			int expected = 9;
			assertEquals(expected,result);
		}
}
