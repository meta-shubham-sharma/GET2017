/**
 * 
 */
package com.metacube.assignment2;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author shubham
 *
 */
public class TestRoomAllocation {

	static MyHashTable<Integer,Guest> hashtable = new MyHashTable<Integer,Guest>();
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Guest guest1 = new Guest();
		guest1.setName("shubham");
		guest1.setAge(23);
		hashtable.insertValue(23, guest1);
		Guest guest2 = new Guest();
		guest2.setName("pawan");
		guest2.setAge(23);
		hashtable.insertValue(23,guest2);
	}

	@Test
	public void testHashFunction() {
		int actual = hashtable.hashFunction(23);
		int expected = 10;
		assertEquals(expected,actual);
		actual = hashtable.hashFunction(25);
		expected = 12;
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetValue(){
		Guest guest = hashtable.getValue(23, "shubham");
		int actual = guest.getRoom();
		int expected = 11;
		assertEquals(expected,actual);
		guest = hashtable.getValue(23, "pawan");
		actual = guest.getRoom();
		expected = 1;
		assertEquals(expected,actual);
	}

}
