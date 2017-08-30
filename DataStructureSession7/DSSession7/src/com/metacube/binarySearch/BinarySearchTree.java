package com.metacube.binarySearch;

public class BinarySearchTree<E> {

	private BinarySearchTreeNode<E> root;
	private int index;
	private String inOrder;

	/**
	 * constructor
	 */
	public BinarySearchTree() {
		root = null;
		index = 0;
		inOrder = "";
	}

	/**
	 * 
	 * @param root
	 * @param data
	 * @return binary tree node
	 */
	private BinarySearchTreeNode<E> insert(BinarySearchTreeNode<E> root, E data) {
		if (root == null) {
			root = new BinarySearchTreeNode<E>(data);
		} else {
			if (root.compareTo(data) > 0) {
				root.setLeft(insert(root.getLeft(), data));
			} else {
				root.setRight(insert(root.getRight(), data));
			}
		}
		return root;
	}

	public void insertNode(E data) {
		root = insert(root, data);
	}

	/**
	 * recursive method for inorder traversal
	 * 
	 * @param root
	 */
	private void inOrder(BinarySearchTreeNode<E> root) {
		if (root != null) {
			inOrder(root.getLeft());
			inOrder += root.getData() + " ";
			root.setIndex(index);
			index++;
			inOrder(root.getRight());
		}
	}

	public void printInorder() {
		inOrder = "";
		index = 0;
		inOrder(root);
	}

	/**
	 * method to perform binary search
	 * 
	 * @param data
	 * @return boolean
	 */
	private BinarySearchTreeNode<E> search(BinarySearchTreeNode<E> node, E data) {
		while (node != null) {
			if (node.getData().equals(data)) {
				return node;
			}
			if (node.compareTo(data) > 0) {
				node = node.getLeft();
			} else {
				node = node.getRight();
			}
		}
		return null;
	}

	public int searchNode(E data) {
		int value = -1;
		printInorder();
		BinarySearchTreeNode<E> node = search(root, data);
		if (node != null) {
			value = node.getIndex();
		}
		return value;
	}

	@Override
	public String toString() {
		return inOrder;
	}

}
