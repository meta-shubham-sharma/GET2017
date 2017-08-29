package com.metacube.assignment1;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EmployeeController controller = new EmployeeController();
		List<Employee> employeeList = controller.getEmployeeList();
		Scanner scan = new Scanner(System.in);

		do {
			System.out.println("\n1. Add an employee");
			System.out.println("2. Get employee details");
			System.out.println("3. Sort using Comparable");
			System.out.println("4. Sort using Comaparator");
			System.out.println("5. Exit");
			try{
			int choice = Integer.parseInt(scan.nextLine());
			switch (choice) {
			case 1:
				System.out.println("Enter user Id of employee");
				int id = Integer.parseInt(scan.nextLine());
				if (controller.checkEmployeeId(id)) {
					System.out.println("Id already exist !!");
				} else {
					System.out.println("Enter name of employee");
					String name = scan.nextLine();
					System.out.println("Enter address of employee");
					String address = scan.nextLine();
					employeeList.add(new Employee(id, name, address));
				}
				break;
			case 2:
				System.out.println("Enter user Id of employee");
				id = Integer.parseInt(scan.next());
				if (controller.checkEmployeeId(id)) {
					Employee temp = controller.getEmployee(id);
					System.out.println("\nId : " + temp.getId() + "\tName : "
							+ temp.getName() + "\tAddress : "
							+ temp.getAddress());
				} else {
					System.out.println("Id entered is invalid !!");
				}
				break;
			case 3:
				Collections.sort(employeeList);
				System.out.println("\nSorted By ID using Comaparable ");
				employeeList = controller.getEmployeeList();
				Iterator<Employee> itr = employeeList.iterator();
				while (itr.hasNext()) {
					Employee temp = itr.next();
					System.out.println("\nId : " + temp.getId() + "\tName : "
							+ temp.getName() + "\tAddress : "
							+ temp.getAddress());
				}
				break;
			case 4:
				Collections.sort(employeeList, new NameComparator());
				System.out.println("\nSorted by name using Comaparator");
				employeeList = controller.getEmployeeList();
				itr = employeeList.iterator();
				while (itr.hasNext()) {
					Employee temp = itr.next();
					System.out.println("\nId : " + temp.getId() + "\tName : "
							+ temp.getName() + "\tAddress : "
							+ temp.getAddress());
				}
				break;
			case 5:
				scan.close();
				System.exit(0);
			}
			}catch(NumberFormatException exc){
				System.out.println("Enter a valid choice !! "+exc);
			}
		} while (true);
	}
}
