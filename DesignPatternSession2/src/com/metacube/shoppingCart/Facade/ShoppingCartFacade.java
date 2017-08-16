package com.metacube.shoppingCart.Facade;

import java.util.List;

import com.metacube.shoppingCart.Constants;
import com.metacube.shoppingCart.Dao.BaseDao;
import com.metacube.shoppingCart.Dao.FileHandling;
import com.metacube.shoppingCart.Dao.InMemoryShoppingCartDao;
import com.metacube.shoppingCart.Model.Entity;
import com.metacube.shoppingCart.Model.Product;
import com.metacube.shoppingCart.Model.ShoppingCart;

public class ShoppingCartFacade {
	
	BaseDao object = ProductFactory.getInstance(FileHandling
			.read(Constants.FILELOC2));

	public List<ShoppingCart> getCart() {
		return ((InMemoryShoppingCartDao) object).getCartItems();
	}

	public boolean checkProductCodeFromCart(String code) {
		List<ShoppingCart> cartItems = getCart();
		for (ShoppingCart item : cartItems) {
			if (item.getCode().equals(code))
				return true;
		}
		return false;
	}
	
	public void removeFromcart(String code){
		((InMemoryShoppingCartDao) object).delete(code);
	}
	
	/**
	 * Gets the cost.
	 *
	 * @param input
	 *            the input
	 * @return the cost
	 */
	public void addToCart(Product input) {
		
		if(checkProductCodeFromCart(input.getCode())){
			Entity item = ((InMemoryShoppingCartDao) object).retreive(input.getCode());
			((InMemoryShoppingCartDao) object).update(item,input);
		}
		else{
		ShoppingCart cart = new ShoppingCart();
		cart.setCode(input.getCode());
		ProductFacade pf =new ProductFacade();
		cart.setPrice(pf.getCost(input));
		cart.setQuantity(input.getQuantity());
		((InMemoryShoppingCartDao) object).addToCartItems(cart);
		}
	}
}
