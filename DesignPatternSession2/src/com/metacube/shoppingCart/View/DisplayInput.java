package com.metacube.shoppingCart.View;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.metacube.shoppingCart.Model.Product;
import com.metacube.shoppingCart.controller.ProductController;

/**
 * The Class DisplayInput.
 */
public class DisplayInput {

	/** The code. */
	public String code;

	/** The quantity. */
	public int quantity;

	/**
	 * Instantiates a new display input.
	 *
	 * @param code
	 *            the code
	 * @param quantity
	 *            the quantity
	 */
	public DisplayInput(String code, int quantity) {
		this.code = code;
		this.quantity = quantity;
	}

	/**
	 * Gets the input from user.
	 *
	 * @return the input from user
	 */
	public static void getInputFromUser() {
		try {
			Scanner scan = new Scanner(System.in);
			System.out
					.println("Enter number of products you want to add to your cart :");
			int num = scan.nextInt();
			ProductController pc = new ProductController();
			for (int index = 0; index < num; index++) {
				System.out
						.println("Enter code of product you want to add to your cart :");
				String code = scan.next();
				System.out.println("Enter quantity of this product :");
				int quantity = scan.nextInt();
				while (quantity < 1) {
					System.out
							.println("Enter valid quantity for this product :");
					quantity = scan.nextInt();
				}
				Product input = new Product();
				input.setCode(code);
				input.setQuantity(quantity);
				pc.getViewObject(input);
			}
		} catch (InputMismatchException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
