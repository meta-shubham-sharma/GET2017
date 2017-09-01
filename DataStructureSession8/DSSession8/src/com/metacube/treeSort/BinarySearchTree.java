package com.metacube.treeSort;

public class BinarySearchTree {

	private BinarySearchTreeNode root;
	private int array[];
	int index,size;
	/**
	 * constructor
	 */
	public BinarySearchTree(){
		root = null;
		size=0;
	}
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		if(getSize() != 0)
			size = size + getSize(); 
		array = new int[size];
	}

	/**
	 * 
	 * @param root
	 * @param data
	 * @return binary tree node
	 */
	private BinarySearchTreeNode insert(BinarySearchTreeNode root , int data){
		if(root == null){
			root = new BinarySearchTreeNode(data);
			size++;
		}
		else{
			if( root.getData() > data ){
				root.setLeft( insert(root.getLeft(), data) ); 
			}
			else{
			root.setRight(insert(root.getRight(),data));
			}
		}
		return root;
	}
	
	public void insertNode(int data){
		root = insert(root,data);
	}
	
	/**
	 * recursive method for inorder traversal
	 * @param root
	 */
	private void inOrder(BinarySearchTreeNode root){
		if(root != null){
			inOrder(root.getLeft());
			array[index++]=root.getData();
			inOrder(root.getRight());
		}
	}
	
	public int[] printInorder(){
		index = 0;
		inOrder(root);
		return array;
	}
}
