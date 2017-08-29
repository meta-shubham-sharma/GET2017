package com.metacube.assignment1;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class testEmployee {

	static EmployeeController controller;
	static List<Employee> employeeList;
	
	/**
	 * set values to perform tests 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		controller = new EmployeeController();
		employeeList = controller.getEmployeeList();
	}

	/**
	 * free the resources used
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		controller = null;
		employeeList = null;
	}

	/**
	 * check if the particular employee is present in list
	 */
	@Test
	public void testEmployeeId() {
		boolean actual = controller.checkEmployeeId(1);
		boolean expected = true;
		assertEquals("Employee with this Id exist !!",expected,actual);
		
		actual = controller.checkEmployeeId(5);
		expected = false;
		assertEquals("Employee with this Id does not exist !!",expected,actual);
	}
	
	/**
	 * get employeeName using its Id 
	 */
	@Test
	public void testEmployeeDetails() {
		Employee actual = controller.getEmployee(1);
		String expected = "shubham";
		assertEquals(expected,actual.getName());
	}

	/**
	 * use comparable interface to sort list based on Id
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSortUsingId() {
		Collections.sort(employeeList);
		String actual = "";
		Iterator<Employee> itr = employeeList.iterator();
		while(itr.hasNext()){
			Employee temp = itr.next();
			actual+=temp.getId();
		}
		String expected = "1234";
		assertEquals(expected,actual);
	}
	
	/**
	 * use comparator to sort list based on names
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSortUsingName() {
		Collections.sort(employeeList,new NameComparator());
		String actual = "";
		Iterator<Employee> itr = employeeList.iterator();
		while(itr.hasNext()){
			Employee temp = itr.next();
			actual+=temp.getName()+" ";
		}
		String expected = "gourav pawan rajat shubham ";
		assertEquals(expected,actual);
	}
}
