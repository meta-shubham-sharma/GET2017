import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class TestTowerOfHanoi {

	// this test will check tower of hanoi for 3 disks
	@Test
	public void test() {
		TowerOfHanoi obj = new TowerOfHanoi();
		List<String> result = obj.towerOfHanoi("a" , "b", "c" , 3);
		String actual[] = result.toArray(new String[result.size()]);
		String expected[]={ "Move disk 1 from a to b",
							"Move disk 2 from a to c",
							"Move disk 1 from b to c",
							"Move disk 3 from a to b",
							"Move disk 1 from c to a",
							"Move disk 2 from c to b",
							"Move disk 1 from a to b"};
		Assert.assertArrayEquals(expected, actual);
	}

	// this test will check tower of hanoi for 2 disks
	@Test
	public void test2() {
		TowerOfHanoi obj = new TowerOfHanoi();
		List<String> result = obj.towerOfHanoi("a" , "b", "c" , 2);
		String actual[] = result.toArray(new String[result.size()]);
		String expected[]={ "Move disk 1 from a to c",
							"Move disk 2 from a to b",
							"Move disk 1 from c to b",};
		Assert.assertArrayEquals(expected, actual);
	}
}
