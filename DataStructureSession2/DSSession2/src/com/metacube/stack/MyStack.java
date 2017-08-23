package com.metacube.stack;

public class MyStack<E> {

	Node<E> head = null, node;
	private int size = 0;

	public MyStack() {
		node = new Node<E>();
	}

	/**
	 * 
	 * @return size of stack
	 */
	public int getSize() {
		return size;
	}
	/**
	 * 
	 * @param data
	 */
	public void push(E data) {
			Node<E> newNode = node.getNode(data);
			newNode.previous = this.head;
			this.head = newNode;
			size++;
	}
	/**
	 * 
	 * @return data popped
	 */
	public E pop() {
		E val = null;
		if (head != null) {
			val=head.data;
			head = head.previous;
			size--;
		}
		return val;
	}
	/**
	 * 
	 * @return data at top
	 */
	public E peek(){
		E val = null;
		if(head != null){
		val = head.data;
		}
		return val;
	}
}
