package com.metacube.shoppingCart.Facade;

import java.util.HashMap;

import com.metacube.shoppingCart.Constants;
import com.metacube.shoppingCart.Dao.BaseDao;
import com.metacube.shoppingCart.Dao.FileHandling;
import com.metacube.shoppingCart.Dao.InMemoryProductDao;
import com.metacube.shoppingCart.Model.Product;

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
		public HashMap<String, Product> getProducts() {
		return ((InMemoryProductDao) object).getAllProducts();
	}
}
