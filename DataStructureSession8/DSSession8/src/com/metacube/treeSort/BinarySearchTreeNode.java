package com.metacube.treeSort;

public class BinarySearchTreeNode {
	private int data;
	private BinarySearchTreeNode left;
	private BinarySearchTreeNode right;
	/**
	 * constructor
	 * @param data
	 */
	public BinarySearchTreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	/**
	 * @return the left
	 */
	public BinarySearchTreeNode getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}
	/**
	 * @return the right
	 */
	public BinarySearchTreeNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}
}
