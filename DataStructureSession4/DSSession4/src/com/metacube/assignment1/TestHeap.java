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
	static HeapSort heap;
	static Jobs jobQueue[] = {};
	
	/**
	 * @throws java.lang.Exception
	 */
	@SuppressWarnings("rawtypes")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			jobQueue = new Jobs[2];
			Jobs job1 = new Jobs();
			String designation = "UnderGraduate";
			String message = "I am undergraduate";
			job1.setDesignation(designation);
			job1.setMessage(message);
			job1.setPriority(getPriority(designation.charAt(0)) );
			jobQueue[0] = job1;
			Jobs job2 = new Jobs();
			designation = "ChairPerson";
			message = "I am chairperson";
			job2.setDesignation(designation);
			job2.setMessage(message);
			job2.setPriority(getPriority(designation.charAt(0)) );
			jobQueue[1] = job2;
			heap = new HeapSort();
	}
	
	/**
	 * 
	 * @param ch
	 * @return priority
	 */
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

	/**
	 * test priority of queue
	 */
	@Test
	public void testPriority() {
		int actual = getPriority('c');
		int expected = 4;
		assertEquals(expected,actual);
		actual = getPriority('p');
		expected = 3;
		assertEquals(expected,actual);
	}

	/**
	 * test sorting of queue using heap
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testHeap() {
		heap.sort(jobQueue);
		String actual="";
		for (int index = 0; index < 2; index++) {
			actual += jobQueue[index].getDesignation() + " ";
		}
		String  expected = "ChairPerson UnderGraduate ";
		assertEquals(expected.toString() , actual);
	}
}
