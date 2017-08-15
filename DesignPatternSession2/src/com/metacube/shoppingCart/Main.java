package com.metacube.shoppingCart;

import com.metacube.shoppingCart.Dao.FileHandling;
import com.metacube.shoppingCart.View.DisplayInput;
import com.metacube.shoppingCart.View.DisplayOutput;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		FileHandling.readProducts(Constants.PRODUCTLOC);
		DisplayInput.getInputFromUser();
		DisplayOutput.getOutput();
	}
}
