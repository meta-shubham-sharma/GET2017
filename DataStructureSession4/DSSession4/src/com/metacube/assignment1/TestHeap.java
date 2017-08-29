/**
 * 
 */
package com.metacube.assignment1;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author shubham
 *
 */
public class TestHeap {

	@SuppressWarnings("rawtypes")
	static PriorityQueue heap;
	static Jobs jobQueue[] = {};

	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("rawtypes")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		heap = new PriorityQueue(2);
		String designation = "UnderGraduate";
		String message = "I am undergraduate";
		heap.insert(designation, message, getPriority(designation.charAt(0)));	
	
		designation = "ChairPerson";
		message = "I am chairperson";
		heap.insert(designation, message, getPriority(designation.charAt(0)));	
	}

	/**
	 * 
	 * @param ch
	 * @return priority
	 */
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

	/**
	 * test priority of queue
	 */
	@Test
	public void testPriority() {
		int actual = getPriority('c');
		int expected = 4;
		assertEquals(expected, actual);
		actual = getPriority('p');
		expected = 3;
		assertEquals(expected, actual);
	}

	/**
	 * test sorting of queue using heap
	 */
	@Test
	public void testHeap() {
		Jobs job = heap.remove();
		String actual = job.getDesignation()+" "+job.getMessage();
		String expected = "ChairPerson I am chairperson";
		assertEquals(expected,actual);
		
		job = heap.remove();
		actual = job.getDesignation()+" "+job.getMessage();
		expected = "UnderGraduate I am undergraduate";
		assertEquals(expected,actual);
	}
}
