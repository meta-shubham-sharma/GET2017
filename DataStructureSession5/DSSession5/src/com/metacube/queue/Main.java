package com.metacube.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	@SuppressWarnings("unchecked")
	public static <E> void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MyQueue<E> queue = new MyQueue<E>();
		do {
			System.out.println("\n1. Enqueue item");
			System.out.println("2. Dequeue item");
			System.out.println("3. Peek item");
			System.out.println("4. Print Queue");
			System.out.println("5. Exit");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter an item");
				E item = (E) scan.next();
				queue.enqueue(item);
				break;
			case 2:
				try {
					item = queue.dequeue();
					System.out.println("Dequed Element : " + item);
				} catch (NoSuchElementException exc) {
					System.out.println("Queue is empty");
				}
				break;
			case 3:
				try {
					item = queue.peek();
					System.out.println("Peek item : " + item);
				} catch (NoSuchElementException exc) {
					System.out.println("Queue is empty");
				}
				break;
			case 4:
				LinkedList<E> list = queue.printQueue();
				if (list.isEmpty()) {
					System.out.println("Queue is empty !!");
				} else {
					Iterator<E> itr = list.iterator();
					while (itr.hasNext()) {
						E temp = itr.next();
						System.out.print(temp + " ");
					}
				}
				break;
			case 5:
				scan.close();
				System.exit(0);
				break;
			}
		} while (true);
	}
}
