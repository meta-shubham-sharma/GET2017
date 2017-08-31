package com.metacube.sortingSystem;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;

		do {
			System.out.println("Enter numbers you want to sort ");

			int num = Integer.parseInt(scan.nextLine());

			while (num < 1) {
				System.out
						.println("Number less than 1 !! Enter numbers you want to sort ");
				num = Integer.parseInt(scan.nextLine());
			}

			SortingSystem system = new SortingSystem(num);
			for (int index = 0; index < num; index++) {
				System.out.println("Enter the number");
				int data = Integer.parseInt(scan.nextLine());
				system.add(data);
			}

			System.out.println("\n1. Comparison Sorting");
			System.out.println("2. Linear Sorting");
			System.out.println("3. Exit");
			try {
				System.out.println("Enter a choice");
				int choice = Integer.parseInt(scan.nextLine());
				switch (choice) {
				case 1:
					if (system.checkLength(num)) {
						System.out.println("\nBubble Sort is used !!");
						BubbleSort.bubbleSort(system.getArray());
					} else {
						System.out.println("\nQuick Sort is used !!");
						QuickSort.quickSort(system.getArray(), 0,
								system.getSize() - 1);
					}
					System.out.println("\nSorted List :");
					System.out.println(system);
					break;
				case 2:
					if (system.checkTotalDigits(system.getArray())) {
						System.out.println("Radix Sort is used !!");
						RadixSort.sort(system.getArray());
					} else {
						System.out.println("Counting Sort is used !!");
						CountingSort.sort(system.getArray());
					}
					System.out.println("\nSorted List :");
					System.out.println(system);
					break;
				case 3:
					System.exit(0);
				default:
					System.out.println("Enter a valid choice between 1-3 !!");
				}
			} catch (NumberFormatException exc) {
				System.out.println("Enter a valid integral choice !!" + exc);
			}
			flag = false;
			System.out.println("Press y to continue :");
			char ch = scan.nextLine().charAt(0);
			if (ch == 'y' || ch == 'Y')
				flag = true;
		} while (flag);
		scan.close();
	}

}
