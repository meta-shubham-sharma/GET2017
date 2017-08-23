/**
 * 
 */
package com.metacube.doublyLinkedList;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author shubham
 * @param <E>
 *
 */
public class TestDoublyLinkedList<E> {
	/**
	 * test add node at any location
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testAddNodeAtLocation() {
		DoublyLinkedList<E> linkedList = new DoublyLinkedList<E>();
		boolean expected = linkedList.addNodeAtLocation(1,(E)"12");
		boolean actual = true;
		assertEquals(expected,actual);
	}

	/**
	 * test size of list
	 */
	@Test
	public void testSize() {
		DoublyLinkedList<E> linkedList = new DoublyLinkedList<E>();
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
		DoublyLinkedList<E> linkedList = new DoublyLinkedList<E>();
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
		DoublyLinkedList<E> linkedList = new DoublyLinkedList<E>();
		E expected = linkedList.getElementFromPosition(0);
		E actual = (E)"-1";
		assertEquals(expected,actual);
	}

}
