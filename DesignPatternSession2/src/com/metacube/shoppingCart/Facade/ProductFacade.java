package com.metacube.shoppingCart.Facade;

import java.util.HashMap;
import java.util.List;

import com.metacube.shoppingCart.Constants;
import com.metacube.shoppingCart.Dao.BaseDao;
import com.metacube.shoppingCart.Dao.FileHandling;
import com.metacube.shoppingCart.Dao.InMemoryProductDao;
import com.metacube.shoppingCart.Model.Product;
import com.metacube.shoppingCart.Model.ShoppingCart;

/**
 * The Class ProductFacade.
 */
public class ProductFacade {

	/** The object. */
	BaseDao object = ProductFactory.getInstance(FileHandling
			.read(Constants.FILELOC));

	/**
	 * Check product code.
	 *
	 * @param input
	 *            the input
	 * @return true, if successful
	 */
	public boolean checkProductCode(String code) {
		if (getProducts().containsKey(code)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gets the cost.
	 *
	 * @param input
	 *            the input
	 * @return the cost
	 */
	public double getCost(Product input) {
		double total;
		Product prod = (Product) object.retreive(input.getCode());
		double price = prod.getPrice();
		total = input.getQuantity() * price;
		return total;
	}

	/**
	 * Adds the to cart.
	 *
	 * @param input
	 *            the input
	 */
	public void addToCart(Product input) {
		ShoppingCart cart = new ShoppingCart();
		cart.setCode(input.getCode());
		cart.setPrice(getCost(input));
		cart.setQuantity(input.getQuantity());
		((InMemoryProductDao) object).addToCartItems(cart);
	}

	public boolean checkProductCodeFromCart(String code) {
		List<ShoppingCart> cartItems = getCart();
		for (ShoppingCart item : cartItems) {
			if (item.getCode().equals(code))
				return true;
		}
		return false;
	}

	public List<ShoppingCart> getCart() {
		return ((InMemoryProductDao) object).getCartItems();
	}

	public HashMap<String, Product> getProducts() {
		return ((InMemoryProductDao) object).getAllProducts();
	}
}
