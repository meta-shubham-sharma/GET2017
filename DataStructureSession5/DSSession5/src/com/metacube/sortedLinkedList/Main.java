package com.metacube.sortedLinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MyLinkedList list = new MyLinkedList();
		do{
			System.out.println("\n1. Add item to LinkedList");
			System.out.println("2. Print LinkedList");
			System.out.println("3. Exit");
			int choice = scan.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter item you want to add");
				int item = scan.nextInt();
				list.addValue(item);
				break;
			case 2:
				LinkedList<Integer> linkedList = list.printList();
				for(int index = 0; index<linkedList.size();index++ ){
					System.out.print(linkedList.get(index) + " ");
				}
				break;
			case 3:
				scan.close();
				System.exit(0);
				break;
			}
		}while(true);
	}
}
