package com.metacube.stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStack<E extends Object> {

	@Test
	public void testConvertInfixToPostfix() {
		String expected = Main.convertInfixToPostfix("(A + B) * C + D / (E + F * G) - H");
		String actual = "AB+C*DEFG*+/+H-";
		assertEquals(expected , actual);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void checkSize(){
		MyStack<E> stack = new MyStack<>();
		stack = new MyStack<>();
		stack.push((E)"1");
		stack.push((E)"2");
		stack.push((E)"3");
		stack.push((E)"4");
		int expected = stack.getSize();
		int actual = 4;
		assertEquals(expected , actual);
	}
	
	@SuppressWarnings("unchecked")
	public void checkPop(){
		MyStack<E> stack = new MyStack<>();
		stack = new MyStack<>();
		stack.push((E)"1");
		stack.push((E)"2");
		stack.push((E)"3");
		stack.push((E)"4");
		E expected = stack.pop();
		E actual = (E)"4";
		assertEquals(expected , actual);
	}
}
