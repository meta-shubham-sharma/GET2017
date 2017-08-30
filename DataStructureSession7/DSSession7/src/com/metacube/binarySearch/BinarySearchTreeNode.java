package com.metacube.binarySearch;

public class BinarySearchTreeNode<E> implements Comparable<E> {
	private E data;
	private BinarySearchTreeNode<E> left;
	private BinarySearchTreeNode<E> right;
	private int index;

	/**
	 * constructor
	 * 
	 * @param data
	 */
	public BinarySearchTreeNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * @return the left
	 */
	public BinarySearchTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * @param left
	 *            the left to set
	 */
	public void setLeft(BinarySearchTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BinarySearchTreeNode<E> getRight() {
		return right;
	}

	/**
	 * @param right
	 *            the right to set
	 */
	public void setRight(BinarySearchTreeNode<E> right) {
		this.right = right;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.getData().toString())
				- Integer.parseInt(arg0.toString());
	}
}
