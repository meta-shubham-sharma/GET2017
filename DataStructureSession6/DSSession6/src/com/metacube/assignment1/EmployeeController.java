package com.metacube.assignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeController {

	private List<Employee> employeeList;

	public EmployeeController() {
		employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(1, "shubham","Karol Bagh"));
		employeeList.add(new Employee(4, "pawan","RK Colony"));
		employeeList.add(new Employee(3, "rajat","RC Vyas Colony"));
		employeeList.add(new Employee(2, "gourav","Lajpat Nagar"));
	}

	/**
	 * @return the employeeList
	 */
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public boolean checkEmployeeId(int id){
		boolean flag = false;
		for (Employee emp : employeeList) {
			if (emp.getId() == id) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public Employee getEmployee(int id){
		employeeList = getEmployeeList();
		for (Employee emp : employeeList) {
			if (emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}
}

@SuppressWarnings("rawtypes")
class NameComparator implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		Employee emp1 = (Employee) arg0;
		Employee emp2 = (Employee) arg1;
		return emp1.getName().compareTo(emp2.getName());
	}

}