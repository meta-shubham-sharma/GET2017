import static org.junit.Assert.*;

import org.junit.Test;


public class TestAssignment1 {

	// check when binary input is provided
		@Test
		public void testWhenBinary() {
			Assignment1 a1 = new Assignment1();
			int num = a1.convertBinaryToOctal(Integer.parseInt("sfsfsfshf"));
			assertEquals(65, num);
			
		}

		// check when provided input is not binary
		@Test
		public void testWhenNotBinary() {
			Assignment1 a1=new Assignment1();
			int num = a1.convertBinaryToOctal(Integer.parseInt("-7878787"));
			assertEquals(-1, num);
		}

}
