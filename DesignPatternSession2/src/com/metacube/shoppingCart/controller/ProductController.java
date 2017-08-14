package com.metacube.shoppingCart.controller;

import com.metacube.shoppingCart.Dao.InMemoryProductDao;
import com.metacube.shoppingCart.Enums.Status;
import com.metacube.shoppingCart.Facade.ProductFacade;
import com.metacube.shoppingCart.Model.Product;
import com.metacube.shoppingCart.View.DisplayOutput;

/**
 * The Class ProductController.
 */
public class ProductController {

	/** The pfacade. */
	ProductFacade pfacade = new ProductFacade();

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
			pfacade.addToCart(input);
		} else {
			DisplayOutput.checkStatus(Status.NOTAVAILABLE);
		}
	}
	
	public void removeItem(String code){
		if (pfacade.checkProductCode(code)) {
			InMemoryProductDao.removeFromCart(code);
		} else {
			DisplayOutput.checkStatus(Status.NOTSELECTED);
		}
	}
}
