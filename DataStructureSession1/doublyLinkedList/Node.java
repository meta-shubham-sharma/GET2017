package com.metacube.doublyLinkedList;
/**
 * 
 * @author shubham
 *
 * @param <E>
 */
public class Node<E> {
	E data;
	Node<E> next,previous;
	/**
	 * 
	 * @return next
	 */
	public Node<E> next() {
		return this.next;
	}
	/**
	 * 
	 * @return previous
	 */
	public Node<E> previous() {
		return this.previous;
	}
	/**
	 * 
	 * @param data
	 * @return data
	 */
	public Node<E> getNode(E data) {
		Node<E> node = new Node<E>();
		node.data = data;
		node.next = null;
		node.previous = null;
		return node;
	}

}
