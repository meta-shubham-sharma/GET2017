package com.metacube.shoppingCart.View;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.metacube.shoppingCart.Enums.Status;
import com.metacube.shoppingCart.Model.Product;
import com.metacube.shoppingCart.Model.ShoppingCart;
import com.metacube.shoppingCart.controller.ProductController;

/**
 * The Class DisplayOutput.
 */
public class DisplayOutput {

	/**
	 * Gets the output.
	 *
	 * @return the output
	 */
	public static void getOutput() {
		double total = 0;
		Scanner scan = new Scanner(System.in);
		ProductController pc = new ProductController();
		List<ShoppingCart> cartItems = pc.getCart();
		HashMap<String, Product> AllProducts = pc.getProducts();
		do {
			System.out.println("\n1. View Cart");
			System.out.println("2. Edit Cart");
			System.out.println("3. Generate Bill");
			try {
				int num = scan.nextInt();
				switch (num) {
				case 1:
					cartItems = pc.getCart();
					System.out.println("\n########################");
					System.out.println("YOUR ORDER");
					System.out.println("########################");
					System.out.println("\nPURCHASED PRODUCTS : ");
					for (ShoppingCart item : cartItems) {
						System.out.println("Product : "
								+ AllProducts.get(item.getCode()).getCode()
								+ " - "
								+ AllProducts.get(item.getCode()).getName());
						System.out.println("Cost : Rs." + item.getPrice()
								+ "( "
								+ AllProducts.get(item.getCode()).getPrice()
								+ " * " + item.getQuantity() + " )\n");
					}
					break;
				case 2:
					boolean flag = true;
					do {
						System.out.println("\n1. Remove items from cart");
						System.out.println("2. Add items to cart");
						System.out.println("3. Back");
						int val = scan.nextInt();
						switch (val) {
						case 1:
							System.out
									.println("Enter product code you want to remove");
							String code = scan.next();
							pc.removeItem(code);
							break;
						case 2:
							DisplayInput.getInputFromUser();
							break;
						case 3:
							flag = false;
							break;
						}
					} while (flag);
					break;
				case 3:
					cartItems = pc.getCart();
					total = 0;
					for (ShoppingCart item : cartItems) {
						total += item.getPrice();
					}
					System.out.println("\n########################");
					System.out.println("YOUR BILL");
					System.out.println("########################");
					System.out.println("\nTotal : " + total);
					System.exit(0);
					break;
				}
			} catch (InputMismatchException ie) {
				System.out.println(ie.getMessage());
			}
		} while (true);
	}

	/**
	 * Check status.
	 *
	 * @param status
	 *            the status
	 */
	public static void checkStatus(Status status) {
		switch (status) {
		case NOTAVAILABLE:
			System.out.println("Product is not available !!");
			break;
		case NOTSELECTED:
			System.out.println("Product is not available in your cart !!");
			break;
		case ADDED:
			System.out.println("Product is successfully added to your cart !!");
			break;
		case REMOVED:
			System.out
					.println("Product is successfully removed from your cart !!");
			break;
		}
	}
}
