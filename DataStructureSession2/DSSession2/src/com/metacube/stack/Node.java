package com.metacube.stack;

public class Node<E> {

	E data;
	Node<E> previous;

	public Node(){}
	
	public Node(E data){
		this.data = data;
		this.previous = null;
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
	 * @return new node
	 */
	public Node<E> getNode(E data) {
		Node<E> node = new Node<E>(data);
		return node;
	}
	
}
