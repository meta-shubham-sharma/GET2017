package com.metacube.stack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your infix expresion");
		String input = scan.nextLine();
		String output = convertInfixToPostfix(input);
		System.out.println("Postfix notation : " + output);
		scan.close();
	}

	@SuppressWarnings("unchecked")
	public static <E> String convertInfixToPostfix(String input) {
		MyStack<E> stack = new MyStack<E>();
		String output = "";
		input = input.replace(" ", "");
		for (int index = 0; index < input.length(); index++) {

			if (Character.isLetterOrDigit(input.charAt(index))) { 		// character or digit is added to output
				output += input.charAt(index);
			} else if (input.charAt(index) == '(') {					
				stack.push((E) String.valueOf(input.charAt(index)));	// push element ( in stack
			} else if (input.charAt(index) == ')') {
				while ((stack.getSize() != 0) 
						&& (stack.peek().toString().charAt(0) != '(')) {
					E item = stack.pop();
					output += item.toString();							// pop elements until ( is encountered
				}
				if (stack.getSize() != 0
						&& stack.peek().toString().charAt(0) != '(') {
					return "Invalid Expression";						// if ( is not present in stack
				} else {
					stack.pop();										
				}
			} else {
				while (stack.getSize() != 0
						&& (getPrecedence(stack.peek().toString().charAt(0)) >= getPrecedence(input
								.charAt(index)))) {
					E item = stack.pop();								// pop elements if element at top of stack has high precedence than input 
					output += item.toString();
				}
				stack.push((E) String.valueOf(input.charAt(index)));
			}
		}
		while (stack.getSize() != 0) {
			E item = stack.pop();
			output += item.toString();									// pop all the rest of the operators from stack
		}
		return output;
	}

	/**
	 * 
	 * @param ch
	 * @return precedence of operators
	 */
	public static int getPrecedence(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		}
		return -1;
	}
}
