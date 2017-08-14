package com.metacube.shoppingCart.View;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.metacube.shoppingCart.Dao.BaseDao;
import com.metacube.shoppingCart.Dao.InMemoryProductDao;
import com.metacube.shoppingCart.Enums.Status;
import com.metacube.shoppingCart.Model.ShoppingCart;


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
		List<ShoppingCart> cartItems = InMemoryProductDao.getCartItems();
		do {
			System.out.println("\n1. View Cart");
			System.out.println("2. Edit Cart");
			System.out.println("3. Generate Bill");
			try{
			int num = scan.nextInt();
			switch (num) {
			case 1:
				cartItems = InMemoryProductDao.getCartItems();
				System.out.println("\n########################");
				System.out.println("YOUR ORDER");
				System.out.println("########################");
				System.out.println("\nPURCHASED PRODUCTS : ");
				for (ShoppingCart item : cartItems) {
					System.out.println("Product : "
							+ InMemoryProductDao.productMap.get(item.getCode())
									.getCode()
							+ " - "
							+ InMemoryProductDao.productMap.get(item.getCode())
									.getName());
					System.out.println("Cost : Rs."
							+ item.getPrice()
							+ "( "
							+ InMemoryProductDao.productMap.get(item.getCode())
									.getPrice() + " * " + item.getQuantity()
							+ " )\n");
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
						InMemoryProductDao.removeFromCart(code);
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
				cartItems = InMemoryProductDao.getCartItems();
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
			}catch(InputMismatchException ie){
				System.out.println(ie.getMessage());
			}
		} while (true);
	}

	/**
	 * Check status.
	 *
	 * @param status the status
	 */
	public static void checkStatus(Status status) {
		switch (status) {
		case NOTAVAILABLE:
			System.out.println("Product is not available !!");
			break;
		case NOTSELECTED:
			System.out.println("Product is not available in your cart !!");
			break;
		}
	}
}
