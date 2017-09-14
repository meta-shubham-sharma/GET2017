package com.metacube.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.metacube.dao.DBHelper;
import com.metacube.model.Titles;

public class Main {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		DBHelper object = new DBHelper();
		do {
			System.out.println("\n1. Get all books by authors's name");
			System.out
					.println("2. Check if book has been issued based on book's name");
			System.out.println("3. Delete all books not issued in last 1 year");
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			int choice = 0;
			try {
				choice = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException exc) {
				System.out.println("Enter a valid integral choice " + exc);
			}
			switch (choice) {
			case 1:
				System.out.println("Enter the name of the author");
				String input = scan.nextLine();
				List<Titles> list = object.getBookDetailsByAuthor(input);
				if (list.isEmpty()) {
					System.out
							.println("This Author has no books in library !!");
				} else {
					for (Titles title : list) {
						System.out.println(title);
					}
				}
				break;
			case 2:
				System.out.println("Enter the name of the book");
				input = scan.nextLine();
				int output = object.checkBook(input);
				if (output == 1) {
					System.out.println("Book can be issued !!");
				} else if (output == 0) {
					System.out.println("Book is not available in library !!");
				} else {
					System.out.println("Book can not be issued !!");
				}
				break;
			case 3:
				int numOfBooksDeleted = object.deleteBooks();
				System.out.println("Number of books deleted are : " + numOfBooksDeleted);
				break;
			case 4:
				object.closeConnection();
				scan.close();
				System.exit(0);
			default:
				System.out.println("Enter a choice between 1-4");
			}
		} while (true);
	}
}
