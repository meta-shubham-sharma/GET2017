/**
 * 
 */
package com.metacube.arrayList;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

/**
 * @author shubham
 * @param <E>
 *
 */
public class TestArrayList<E> {

	/**
	 * test to add element at any location
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	@Test
	public void testSetElement() {
		MyArrayList<E> arrayList = new MyArrayList<E>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter element you want to add");
		E element = (E)scan.next();
		boolean expected = arrayList.setElement(0, element);
		boolean actual = true;
		assertEquals(expected,actual);
	}

	/**
	 * test to get size of list
	 */
	@Test
	public void testGetSize(){
		MyArrayList<E> arrayList = new MyArrayList<E>();
		int expected = arrayList.getSize();
		int actual = 0;
		assertEquals(expected,actual);
	}
	
	/**
	 * test to get element from list
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	@Test
	public void testGetElement(){
		MyArrayList<E> arrayList = new MyArrayList<E>();
		System.out.println("Enter element you want to get");
		Scanner scan = new Scanner(System.in);
		E element = (E)scan.next(); 
		int expected = arrayList.getElement(element);
		int actual = -1;
		assertEquals(expected,actual);
	}
	
	/**
	 * test to remove element from list
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	@Test
	public void testRemoveElementFromPosition(){
		MyArrayList<E> arrayList = new MyArrayList<E>();
		System.out.println("Enter element you want to remove");
		Scanner scan = new Scanner(System.in);
		E element = (E)scan.next(); 
		boolean expected = arrayList.removeElement(element);
		boolean actual = false;
		assertEquals(expected,actual);
	}
	
}
