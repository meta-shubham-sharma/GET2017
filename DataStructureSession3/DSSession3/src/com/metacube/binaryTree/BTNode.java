package com.metacube.binaryTree;

public class BTNode<E> {
	
	E data;
	BTNode<E> left;
	BTNode<E> right;
	
	public BTNode(E data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public BTNode<E> left(){
		return this.left;
	}
	
	public BTNode<E> right(){
		return this.right;
	}
	
}
