package com.metacube.queue;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class testMyQueue<E> {

	static MyQueue<Integer> queue;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		queue = new MyQueue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
	}

	@Test
	public void testDequeue() {
		int actual = queue.dequeue();
		int expected = 1;
		assertEquals(expected,actual);
		actual = queue.dequeue();
		expected = 2;
		assertEquals(expected,actual);
	}

	@Test
	public void testPeek(){
		int actual = queue.peek();
		int expected = 1;
		assertEquals(expected,actual);
	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception{
		queue = null;
	}
}
