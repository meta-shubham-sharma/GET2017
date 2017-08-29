package com.metacube.assignment2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		RoomAllocation rooms = new RoomAllocation();
		do {
			System.out.println("\n1. Add Guests");
			System.out.println("2. See Guest Information");
			System.out.println("3. See All Guest Information");
			System.out.println("4. Exit");
			System.out.println("enter your choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter total guests");
				int num = scan.nextInt();
				for (int index = 0; index < num; index++) {
					System.out.println("Enter name of guest " + (index + 1));
					String name = scan.next();
					System.out.println("Enter age of guest " + (index + 1));
					int age = scan.nextInt();
					rooms.addGuest(name, age);
				}
				break;
			case 2:
				System.out.println("Enter age of guest");
				int age = scan.nextInt();
				System.out.println("Enter name of guest");
				String name = scan.next();
				Guest guest = rooms.getGuest(age, name);
				if (guest != null) {
					System.out.println("\nName : " + guest.getName()
							+ "\tAge : " + guest.getAge() + "\tRoomNo. : "
							+ guest.getRoom());
				} else {
					System.out.println("Guest information is invalid !!");
				}
				break;
			case 3:
				String result = rooms.getAllGuest();
				System.out.println(result);
				break;
			case 4:
				scan.close();
				System.exit(0);
				break;
			}
		} while (true);
	}
}
