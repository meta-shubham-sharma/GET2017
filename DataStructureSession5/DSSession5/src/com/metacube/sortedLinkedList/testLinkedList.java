package com.metacube.sortedLinkedList;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class testLinkedList {

	static MyLinkedList list ;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		list = new MyLinkedList();
		list.addValue(5);
		list.addValue(3);
		list.addValue(8);
		list.addValue(7);
	}

	@Test
	public void testPrint() {
		LinkedList<Integer> linkedList = list.printList();
		String actual = "";
		for(int index = 0; index<linkedList.size();index++ ){
			actual+=linkedList.get(index) + " ";
		}
		String expected = "3 5 7 8 ";
		assertEquals(expected,actual);
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception{
		list = null;
	}
}
