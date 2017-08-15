package com.metacube.shoppingCart.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.metacube.shoppingCart.Model.Entity;
import com.metacube.shoppingCart.Model.Product;
import com.metacube.shoppingCart.Model.ShoppingCart;

public class InMemoryProductDao implements ProductDao, BaseDao {

	static HashMap<String, Product> productMap = new HashMap<String, Product>();
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
	public HashMap<String, Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productMap;
	}

	public static void removeFromCart(String code) {
		for (ShoppingCart item : cartItems) {
			if (item.getCode().equals(code)) {
				cartItems.remove(item);
				break;
			}
		}
	}

	public void addToCartItems(ShoppingCart cart) {
		cartItems.add(cart);
	}

	public List<ShoppingCart> getCartItems() {
		return cartItems;
	}

}
