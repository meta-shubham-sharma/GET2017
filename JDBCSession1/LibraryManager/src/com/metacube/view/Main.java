package com.metacube.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.metacube.dao.HelperDao;
import com.metacube.model.Titles;

public class Main {
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		HelperDao connect = new HelperDao();
		do {
			System.out.println("\n1. Get all books by authors's name");
			System.out
					.println("2. Check if book has been issued based on book's name");
			System.out
					.println("3. Delete all boooks not issued in last 1 year");
			System.out.println("4. Exit");
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				System.out.println("Enter the name of the author");
				String input = scan.nextLine();
				List<Titles> list = connect.getBookDetails(input);
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
				int output = connect.checkBook(input);
				if (output == 1) {
					System.out.println("Book can be issued !!");
				} else if (output == 0) {
					System.out.println("Book is not available in library !!");
				} else {
					System.out.println("Book can not be issued !!");
				}
				break;
			case 3:
				int rows = connect.deleteBooks();
				System.out.println("Number of books deleted are : " + rows);
				break;
			case 4:
				connect.closeConnection();
				scan.close();
				System.exit(0);
			}
		} while (true);
	}
}
