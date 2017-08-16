package com.metacube.shoppingCart.controller;

import java.util.HashMap;
import java.util.List;

import com.metacube.shoppingCart.Enums.Status;
import com.metacube.shoppingCart.Facade.ProductFacade;
import com.metacube.shoppingCart.Facade.ShoppingCartFacade;
import com.metacube.shoppingCart.Model.Product;
import com.metacube.shoppingCart.Model.ShoppingCart;
import com.metacube.shoppingCart.View.DisplayOutput;

/**
 * The Class ProductController.
 */
public class ProductController {

	ProductFacade pfacade = new ProductFacade();
	ShoppingCartFacade sfacade = new ShoppingCartFacade();
	/**
	 * Gets the view object.
	 *
	 * @param input
	 * 
	 * @return the view object
	 */
	public void getViewObject(Product input) {
		String code = input.getCode();
		if (pfacade.checkProductCode(code)) {
			sfacade.addToCart(input);
			DisplayOutput.checkStatus(Status.ADDED);
		} else {
			DisplayOutput.checkStatus(Status.NOTAVAILABLE);
		}
	}

	public void removeItem(String code) {
		if (sfacade.checkProductCodeFromCart(code)) {
			sfacade.removeFromcart(code);
			DisplayOutput.checkStatus(Status.REMOVED);
		} else {
			DisplayOutput.checkStatus(Status.NOTSELECTED);
		}
	}

	public List<ShoppingCart> getCart() {
		return sfacade.getCart();
	}

	public HashMap<String, Product> getProducts() {
		return pfacade.getProducts();
	}
}
