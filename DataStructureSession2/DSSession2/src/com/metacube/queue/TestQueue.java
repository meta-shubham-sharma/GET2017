package com.metacube.queue;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestQueue {

	static MyQueue que;
	@BeforeClass
	public static void testQue(){
		que = new MyQueue();
		que.enqueue("1");
		que.enqueue("2");
		que.enqueue("3");
		que.enqueue("4");
		que.enqueue("5");
	}
	/**
	 * test dequeue operation of queue
	 */
	@Test
	public void testDequeue() {
		Object expected = que.dequeue();
		Object actual = "1";
		assertEquals(expected,actual);
	}
	/**
	 * test size of queue
	 */
	@Test
	public void testSize() {
		int expected = que.getSize();
		int actual = 5;
		assertEquals(expected,actual);
	}
	/**
	 * test front of queue
	 */
	@Test
	public void testFront(){
		Object expected = que.getFront();
		Object actual = "1";
		assertEquals(expected,actual);
	}
}
