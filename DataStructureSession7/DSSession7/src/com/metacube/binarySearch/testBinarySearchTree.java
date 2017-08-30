package com.metacube.binarySearch;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class testBinarySearchTree {

	@SuppressWarnings("rawtypes")
	static BinarySearchTree tree;

	/**
	 * set up the values to test the class
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tree = new BinarySearchTree();
		tree.insertNode(50);
		tree.insertNode(60);
		tree.insertNode(40);
		tree.insertNode(45);
		tree.insertNode(45);
		tree.insertNode(55);
	}

	/*
	 * free the resources
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tree = null;
	}

	/**
	 * this test will check the binary search method
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearch() {
		/**
		 * test unique element
		 */
		int actual = tree.searchNode(55);
		int expected = 3;
		assertEquals("Item is present in the tree !!", expected, actual);

		/**
		 * test duplicate element
		 */
		actual = tree.searchNode(45);
		expected = 1;
		assertEquals(
				"Duplicates are present so first occurence is returned !!",
				expected, actual);

		/**
		 * test element not present in list
		 */
		actual = tree.searchNode(65);
		expected = -1;
		assertEquals("Item is not present in the tree !!", expected, actual);
	}

}
