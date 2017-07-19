import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class TestPermutations {

	// this test will check all the permutations of given string 
	@Test
	public void test() {
		Permutations obj = new Permutations();
		List<String> result = obj.generatePermutations("ABC");
		String actual[] = result.toArray(new String[result.size()]);
		String expected[]={"ACB", "BCA", "ABC", "CBA", "BAC", "CAB"};
		Assert.assertArrayEquals(expected, actual);
	}

	// this test will check all the permutations of given string with same letters
	@Test
	public void testString() {
		Permutations obj = new Permutations();
		List<String> result = obj.generatePermutations("AAC");
		String actual[] = result.toArray(new String[result.size()]);
		String expected[]={"CAA", "AAC", "ACA"};
		Assert.assertArrayEquals(expected, actual);
	}
}
