import static org.junit.Assert.*;

import org.junit.Test;


public class TestNQueen {

	//this test will check NQueen for num = 4
	@Test
	public void test() {
		NQueen Queen = new NQueen();
		Queen.num = 4;
		Boolean bool = Queen.solveNQ();
		assertEquals(true,bool);
	}

	//this test will check NQueen for num = 3
	@Test
	public void test2() {
		NQueen Queen = new NQueen();
		Queen.num = 3;
		Boolean bool = Queen.solveNQ();
		assertEquals(false,bool);
	}
}
