package com.metacube.treeSort;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class testTreeSort {

	private static BinarySearchTree tree;
	
	/**
	 * set up object to add values 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tree = new BinarySearchTree();
		tree.setSize(6);
		tree.insertNode(5);
		tree.insertNode(5);
		tree.insertNode(4);
		tree.insertNode(3);
		tree.insertNode(2);
		tree.insertNode(1);
	}

	/**
	 * free the resources
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tree = null;
	}

	/**
	 * test for sorting of roll no. in ascending order
	 */
	@Test
	public void testSorting() {
		int actual[] = tree.printInorder();
		int expected[] ={1,2,3,4,5,5};
		Assert.assertArrayEquals("Arrays are equal to each other !!",expected, actual);
	}

	
}
