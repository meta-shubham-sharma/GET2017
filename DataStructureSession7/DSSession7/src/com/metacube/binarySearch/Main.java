package com.metacube.binarySearch;

import java.util.Scanner;

public class Main {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <E> void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree tree = new BinarySearchTree();
		do {
			System.out.println("\n1. Enter items in binary search tree");
			System.out.println("2. Enter item to search in binary search tree");
			System.out.println("3. Print binary search tree");
			System.out.println("4. Exit");
			try {
				System.out.println("Enter a choice");
				int choice = Integer.parseInt(scan.nextLine());
				switch (choice) {
				case 1:
					System.out
							.println("Enter number of elements you want to add to the binary tree");
					int num = Integer.parseInt(scan.nextLine());
					for (int index = 0; index < num; index++) {
						System.out.println("Enter the element");
						E data = (E) scan.nextLine();
						tree.insertNode(data);
					}
					break;
				case 2:
					System.out.println("Enter the element");
					E data = (E) scan.nextLine();
					if (tree.searchNode(data) != -1) {
						System.out
								.println("Item is present in the tree at index : "
										+ tree.searchNode(data));
					} else {
						System.out
								.println("Item is not present in the list !!");
					}
					break;
				case 3:
					tree.printInorder();
					if (tree.toString().equals("")) {
						System.out
								.println("No elements are present in tree !!");
					} else {
						System.out.println(tree);
					}
					break;
				case 4:
					scan.close();
					System.exit(0);
				default:
					System.out.println("Enter a valid choice between 1-4 !!");
				}
			} catch (NumberFormatException exc) {
				System.out.println("Enter a valid integral choice !!" + exc);
			}
		} while (true);
	}
}
