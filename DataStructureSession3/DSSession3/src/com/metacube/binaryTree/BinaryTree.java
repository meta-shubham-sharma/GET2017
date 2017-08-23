package com.metacube.binaryTree;

public class BinaryTree<E> {
	
	BTNode<E> root;
	String inOrder,preOrder,postOrder;
	
	public BinaryTree(){
		inOrder = "";
		preOrder="";
		postOrder="";
		root = null;
	}
	
	/**
	 * create a skew tree towards right 
	 * @param root
	 * @param data
	 * @return node
	 */
	public BTNode<E> insert(BTNode<E> root , E data){
		if(root == null){
			root = new BTNode<E>(data);
		}
		else{
			if( root.left == null ){
				root.left = insert(root.left() , data);
			}
			else{
				root.right = insert(root.right() , data);
			}
		}
		return root;
	}
	
	/**
	 * create mirror tree towards left
	 * @param root
	 * @param data
	 * @return node
	 */
	public BTNode<E> insertMirrorNode(BTNode<E> root , E data){
		if(root == null){
			root = new BTNode<E>(data);
		}
		else{
			if( root.right == null ){
				root.right = insertMirrorNode(root.right() , data);
			}
			else{
				root.left = insertMirrorNode(root.left() , data);
			}
		}
		return root;
	}
	
	/**
	 * preOrder traversal
	 * @param root
	 */
	public void printPreOrder(BTNode<E> root){
		if(root != null){
		preOrder += root.data + " ";
		printPreOrder(root.left());
		printPreOrder(root.right());
		}
	}
	
	/**
	 * post order traversal
	 * @param root
	 */
	public void printPostOrder(BTNode<E> root){
		if(root != null){
		printPostOrder(root.left());
		printPostOrder(root.right());
		postOrder += root.data+" ";
		}
	}
	
	/**
	 * inorder traversal
	 * @param root
	 */
	public void printInOrder(BTNode<E> root){
		if(root != null){
			printInOrder(root.left());
			inOrder+=root.data + " ";
			printInOrder(root.right());
		}
	}
	
	/**
	 * call preOrder
	 */
	public void preOrder(){
		printPreOrder(root);
	}
	
	/**
	 * call postOrder
	 */
	public void postOrder(){
		printPostOrder(root);
	}
	
	/**
	 * call Inorder
	 */
	public void inOrder(){
		printInOrder(root);
	}
	
	/**
	 * call insert Node
	 * @param data
	 */
	public void insertNode(E data){
		root = insert(root,data);
	}
	
	/**
	 * call insert node of mirror
	 * @param data
	 */
	public void insertMirrortNode(E data){
		root = insertMirrorNode(root,data);
	}
	
	/**
	 * 
	 * @return inorder result
	 */
	public String getInOrder(){
		return inOrder;
	}
	
	/**
	 * 
	 * @return preOrder Result
 	 */
	public String getPreOrder(){
		return preOrder;
	}
	
	/**
	 * 
	 * @return postorder result
	 */
	public String getPostOrder(){
		return postOrder;
	}
	
	/**
	 * 
	 * @param newRoot
	 * @param oldRoot
	 * @return 
	 */
	public boolean mirror(BTNode<E> newRoot,BTNode<E> oldRoot){
		if(newRoot == null && oldRoot==null)
			return true;
		
		if(newRoot == null || oldRoot==null)
			return false;
		
		return oldRoot.data.toString().equals(newRoot.data.toString()) && mirror(newRoot.left(),oldRoot.right()) && mirror(newRoot.right(),oldRoot.left());
	}
	
	/**
	 * 
	 * @return root 
	 */
	public BTNode<E> getRoot(){
		return this.root;
	}
}
