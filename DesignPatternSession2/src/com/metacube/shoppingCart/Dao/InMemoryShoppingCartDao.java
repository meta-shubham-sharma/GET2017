package com.metacube.shoppingCart.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.metacube.shoppingCart.Model.Entity;
import com.metacube.shoppingCart.Model.Product;
import com.metacube.shoppingCart.Model.ShoppingCart;

public class InMemoryShoppingCartDao implements ProductDao, BaseDao {
	static List<ShoppingCart> cartItems = new ArrayList<ShoppingCart>();
	
	public void addToCartItems(ShoppingCart cart) {
		cartItems.add(cart);
	}

	public List<ShoppingCart> getCartItems() {
		return cartItems;
	}

	@Override
	public void create(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(Entity entity,Product input) {
		// TODO Auto-generated method stub
		int quantity = ((ShoppingCart)entity).getQuantity() + input.getQuantity();
		((ShoppingCart)entity).setQuantity(quantity);
	}

	@Override
	public void delete(String code) {
		// TODO Auto-generated method stub
		for (ShoppingCart item : cartItems) {
			if (item.getCode().equals(code)) {
				cartItems.remove(item);
				break;
			}
		}
	}

	@Override
	public Entity retreive(String code) {
		// TODO Auto-generated method stub
		for (ShoppingCart item : cartItems) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}

	@Override
	public HashMap<String, Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
