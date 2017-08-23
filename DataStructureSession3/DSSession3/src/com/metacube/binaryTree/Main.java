package com.metacube.binaryTree;

import java.util.Scanner;

public class Main {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <E> void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		BinaryTree mirrorTree = new BinaryTree();
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.println("\n1. ADD MULTIPLE ELEMENTS");
			System.out.println("2. INORDER ");
			System.out.println("3. PREORDER ");
			System.out.println("4. POSTORDER ");
			System.out.println("5. CREATE MIRROR ");
			System.out.println("6. CHECK MIRROR ");
			System.out.println("7. EXIT ");
			System.out.println("\nEnter your choice");
			int choice = scan.nextInt();
			
			switch(choice){
			case 1:
				System.out.println("Enter number of elements you want to add to the binary tree");
				int num = scan.nextInt();
				for(int index = 0 ; index < num ; index++){
					System.out.println("Enter the element");
					E data = (E)scan.next();
					tree.insertNode(data);
				}
				break;
			case 2:
				tree.inOrder();
				System.out.println(tree.getInOrder());
				break;
			case 3:
				tree.preOrder();
				System.out.println(tree.getPreOrder());
				break;
			case 4:
				tree.postOrder();
				System.out.println(tree.getPostOrder());
				break;
			case 5:
				System.out.println("Enter number of elements you want to add to the binary tree");
				num = scan.nextInt();
				for(int index = 0 ; index < num ; index++){
					System.out.println("Enter the element");
					E data = (E)scan.next();
					mirrorTree.insertMirrortNode(data);
				}
				break;
			case 6:
				if(tree.mirror(mirrorTree.getRoot(),tree.getRoot())){
					System.out.println("Trees are mirror images");
				}
				else{
					System.out.println("Trees are not mirror images");
				}
				break;
			case 7: 
				scan.close();
				System.exit(0);
				break;
			}
		}while(true);
	}

}
