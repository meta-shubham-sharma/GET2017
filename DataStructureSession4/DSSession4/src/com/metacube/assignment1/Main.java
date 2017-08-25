package com.metacube.assignment1;

import java.util.Scanner;

public class Main {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of jobs to be done");
		int numJobs = Integer.parseInt(scan.nextLine());
		Jobs jobQueue[] = new Jobs[numJobs];
		for (int index = 0; index < numJobs; index++) {
			Jobs job = new Jobs();
			System.out.println("Enter Designation");
			String designation = scan.nextLine();
			System.out.println("Enter message");
			String message = scan.nextLine();
			job.setDesignation(designation);
			job.setMessage(message);
			job.setPriority(getPriority(designation.charAt(0)));
			jobQueue[index] = job;
		}
		
		HeapSort heap = new HeapSort();
		heap.sort(jobQueue);
		
		for (int index = 0; index < numJobs; index++) {
			System.out.println("\nDesignation : "+jobQueue[index].getDesignation()+"\tMessage : " + jobQueue[index].getMessage());
		}
		scan.close();
	}
	
	public static int getPriority(char ch){
		switch(ch){
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
