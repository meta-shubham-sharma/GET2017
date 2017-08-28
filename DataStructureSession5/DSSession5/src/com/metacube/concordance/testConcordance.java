package com.metacube.concordance;

import static org.junit.Assert.*;

import org.junit.Test;

public class testConcordance {

	@Test
	public void testGetConcordance() {
		String input = "Hello World";
		input = input.replace(" ", "");
		String actual = Concordance.getConcordance(input);
		String expected = "{r=[7], d=[9], e=[1], W=[5], H=[0], l=[2, 3, 8], o=[4, 6]}";
		assertEquals("Concordance is successfully checked", expected, actual);
	
		actual = Concordance.getConcordance("Metacube");
		expected = "{a=[3], b=[6], c=[4], t=[2], e=[1, 7], u=[5], M=[0]}";

		assertEquals("Concordance is successfully checked", expected, actual);
	}

}
