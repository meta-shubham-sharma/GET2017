package com.metacube.binarySearch;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class testBinarysearchInArray {

	private static int arr[];
	
	/**
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		arr =  new int[]{ 1, 2, 2, 3, 4, 6, 6, 7, 8 };
	}

	/*
	 * free the resources
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		arr = null;
	}
	
	/**
	 * test when value is present in array
	 */
	@Test
	public void testWhenValueIsPresent() {
		int actual = BinarySearchUsingArray.search(arr, 0, 8, 6);
		int expected = 5;
		assertEquals("Value is present in array !!",expected, actual);
	}

	/**
	 * test when value is not present in array
	 */
	@Test
	public void testWhenValueIsNotPresent() {
		int actual = BinarySearchUsingArray.search(arr, 0, 8, 9);
		int expected = -1;
		assertEquals("Value is not present in array !!",expected, actual);
	}
	
}
