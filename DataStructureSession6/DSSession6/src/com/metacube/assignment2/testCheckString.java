package com.metacube.assignment2;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class testCheckString {

	static CheckString object;
	/**
	 * set up objects to perform test
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		object = new CheckString();
		}

	/**
	 * test number of distinct characters from input string
	 */
	@Test
	public void testUniqueCharachtersFromString() {
		int actual = object.checkUniqueCharachtersFromString("Metacube");
		int expected = 7;
		assertEquals(expected,actual);
		
		actual = object.checkUniqueCharachtersFromString("Solutions");
		expected = 8;
		assertEquals(expected,actual);
	}

	/**
	 * free the resources used
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		object = null;
	}
}
