package com.metacube.treeSort;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearchTree tree = new BinarySearchTree();
		do {
			System.out.println("\n1. Enter Roll no. of students disorderly");
			System.out.println("2. Print sorted List of Roll no.");
			System.out.println("3. Exit");
			try {
				System.out.println("Enter a choice");
				int choice = Integer.parseInt(scan.nextLine());
				switch (choice) {
				case 1:
					System.out
							.println("Enter number of Roll No. you want to add ");
					int num = Integer.parseInt(scan.nextLine());
					tree.setSize(num);
					for (int index = 0; index < num; index++) {
						System.out.println("Enter the Roll No.");
						int data = Integer.parseInt(scan.nextLine());
						tree.insertNode(data);
					}
					break;
				case 2:
					int[] array = tree.printInorder();
					if (array == null || array.length == 0) {
						System.out
								.println("No Roll No. are present !!");
					} else {
						for(int index = 0 ; index < array.length ; index++){
							System.out.print(array[index] + " ");
						}
					}
					break;
				case 3:
					scan.close();
					System.exit(0);
				default:
					System.out.println("Enter a valid choice between 1-3 !!");
				}
			} catch (NumberFormatException exc) {
				System.out.println("Enter a valid integral choice !!" + exc);
			}
		} while (true);
	}
}
