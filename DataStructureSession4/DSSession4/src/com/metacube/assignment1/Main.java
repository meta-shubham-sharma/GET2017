package com.metacube.assignment1;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter number of jobs to be done");
		int numJobs = Integer.parseInt(scan.nextLine());
		
		PriorityQueue queue = new PriorityQueue(numJobs);
		
		for (int index = 0; index < numJobs; index++) {
			System.out.println("Enter Designation");
			String designation = scan.nextLine();
			System.out.println("Enter message");
			String message = scan.nextLine();
			int priority = getPriority(designation.charAt(0));
			while (priority < 1) {
				System.out.println("Designation entered is invalid !!");
				System.out.println("Enter a Valid Designation");
				designation = scan.nextLine();
				System.out.println("Enter message");
				message = scan.nextLine();
				priority = getPriority(designation.charAt(0));
			}
			queue.insert(designation, message, priority);
		}

		for(int index = 0 ; index < numJobs ; index++){
			Jobs job = queue.remove();
			System.out.println("\nDesignation : "+job.getDesignation() + "\tMessage : "+job.getMessage());
		}
		
		scan.close();
	}

	public static int getPriority(char ch) {
		switch (ch) {
		case 'C':
		case 'c':
			return 4;
		case 'P':
		case 'p':
			return 3;
		case 'G':
		case 'g':
			return 2;
		case 'U':
		case 'u':
			return 1;
		default:
			return -1;
		}
	}
}
