package com.metacube.singlyLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author shubham
 * @param <E>
 *
 */
public class TestSinglyLinkedList<E> {

	/**
	 * test add node at any location
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAddNodeAtLocation() {
		SinglyLinkedList<E> linkedList = new SinglyLinkedList<E>();
		boolean expected = linkedList.addNodeAtLocation(1,(E)"12");
		boolean actual = true;
		assertEquals(expected,actual);
	}

	/**
	 * test size of list
	 */
	@Test
	public void testSize() {
		SinglyLinkedList<E> linkedList = new SinglyLinkedList<E>();
		int expected = linkedList.getSize();
		int actual = 0;
		assertEquals(expected,actual);
	}
	
	/**
	 * test to remove item from list
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testRemoveItem() {
		SinglyLinkedList<E> linkedList = new SinglyLinkedList<E>();
		boolean expected = linkedList.removeItem((E)"13");
		boolean actual = false;
		assertEquals(expected,actual);
	}
	
	/**
	 * test retrieval of element from a position
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetElementFromPosition() {
		SinglyLinkedList<E> linkedList = new SinglyLinkedList<E>();
		E expected = linkedList.getElementFromPosition(0);
		E actual = (E)"-1";
		assertEquals(expected,actual);
	}

}
