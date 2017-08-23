package com.metacube.singlyLinkedList;

public class Node<E> {

	E data;
	Node<E> next;
	/**
	 * 
	 * @return next
	 */
	public Node<E> next() {
		return this.next;
	}
	/**
	 * 
	 * @param data
	 * @return new node
	 */
	public Node<E> getNode(E data) {
		Node<E> node = new Node<E>();
		node.data = data;
		node.next = null;
		return node;
	}
}
