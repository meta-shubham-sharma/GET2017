package com.metacube.shoppingCart.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.metacube.shoppingCart.Enums.Status;
import com.metacube.shoppingCart.Model.Entity;
import com.metacube.shoppingCart.Model.Product;
import com.metacube.shoppingCart.Model.ShoppingCart;
import com.metacube.shoppingCart.View.DisplayOutput;

public class InMemoryProductDao implements ProductDao, BaseDao {

	public static HashMap<String, Product> productMap = new HashMap<String, Product>();
	static List<ShoppingCart> cartItems = new ArrayList<ShoppingCart>();

	@Override
	public void create(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Entity entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Entity retreive(String code) {
		// TODO Auto-generated method stub
		return InMemoryProductDao.productMap.get(code);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void removeFromCart(String code) {
		boolean flag = true;
		for (ShoppingCart item : cartItems) {
			if (item.getCode().equals(code)) {
				cartItems.remove(item);
				flag = false;
				System.out
						.println("Product is successfully removed from the cart !!");
				break;
			}
		}
		if (flag) {
			DisplayOutput.checkStatus(Status.NOTSELECTED);
		}
	}

	public void addToCartItems(ShoppingCart cart) {
		cartItems.add(cart);
	}

	public static List<ShoppingCart> getCartItems() {
		return cartItems;
	}
}
