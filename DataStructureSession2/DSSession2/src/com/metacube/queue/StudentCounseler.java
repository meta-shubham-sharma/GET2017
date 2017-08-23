package com.metacube.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class StudentCounseler extends MyQueue {
	public static void main(String[] args) {

		MyQueue que = new MyQueue();

		// read college list
		String str1 = FileHandling.read("Colleges.txt");
		College col = new College(str1);

		// read students list
		String str2 = FileHandling.read("Candidates.txt");
		new Candidate(str2, que);

		int countColleges = 0;
		HashMap<Integer, College> collegeList = col.getColleges();

		// print list of colleges
		System.out.println("LIST OF COLLEGES : ");
		for (Map.Entry<Integer, College> entry : collegeList.entrySet()) {
			System.out.println("\nID : " + entry.getValue().getId() + "\tName : "
					+ entry.getValue().getName() + "\tSeats : "
					+ entry.getValue().getSeatsAvailable());
			countColleges++;
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("\nEnter options for all students on basis of your priority  :- ");

		que = sort(que);
		 
		// get options from all the candidates
		int size = que.getSize();
		for (int index = 0; index < size; index++) {
			Candidate can = (Candidate) que.dequeue();
			System.out.println("\nEnter id of colleges you want to select for "
					+ can.getName() + " : ");
			int options[] = new int[countColleges];
			for (int jindex = 0; jindex < countColleges; jindex++) {
				options[jindex] = scan.nextInt();
			}
			can.setOptions(options);
			que.enqueue(can);
		}

		// assign colleges to the queue 
		que = assignColleges(que, collegeList);

		//print queue of results
		System.out.println("\nRESULTS OF COUNSELLING : ");
		size = que.getSize();
		for (int index = 0; index < size; index++) {
			Candidate can = (Candidate) que.dequeue();
			System.out.println("\nName : " + can.getName() + "\tRank : "
					+ can.getRank() + "\tCollege Alloted : "
					+ can.getCollegeName());
		}
		scan.close();

	}

	/**
	 * sort queue using maps
	 * @param que
	 * @return queue sorted according to ranks
	 */
	public static MyQueue sort(MyQueue que) {

		HashMap<String, Candidate> map = new HashMap<String, Candidate>();
		int size = que.getSize();
		for (int index = 0; index < size; index++) {
			Candidate can = (Candidate) que.dequeue();
			map.put(can.getRank(), can);
		}
		Map<String, Candidate> sortedMap = new TreeMap<String, Candidate>(map);

		for (Map.Entry<String, Candidate> entry : sortedMap.entrySet()) {
			que.enqueue(entry.getValue());
		}
		return que;
	}

	/**
	 * 
	 * @param que
	 * @param collegeList
	 * @return queue with list of options
	 */
	public static MyQueue assignColleges(MyQueue que,
			HashMap<Integer, College> collegeList) {
		int size = que.getSize();
		boolean flag;
		// get options from user and assign colleges on the basis of the priority given by him 
		for (int index = 0; index < size; index++) {
			Candidate can = (Candidate) que.dequeue();
			int options[] = can.getOptions();
			flag = true;
			for(int jindex = 0;jindex < options.length ; jindex++){
				if( collegeList.containsKey( options[jindex]) ){
					int seats  = collegeList.get(options[jindex]).getSeatsAvailable();
					if (seats > 0) {
						seats -= 1;
						collegeList.get(options[jindex]).setSeatsAvailable(seats);
						can.setCollegeName(collegeList.get(options[jindex]).getName());
						flag = false;
						break;
					}	
				}
			}
			if(flag){
				can.setCollegeName("NO COLLEGE ALLOTED");
			}
			que.enqueue(can);
		}
		return que;
	}

}
