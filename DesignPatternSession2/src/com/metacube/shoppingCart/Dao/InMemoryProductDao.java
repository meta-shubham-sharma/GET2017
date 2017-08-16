package com.metacube.shoppingCart.Dao;

import java.util.HashMap;

import com.metacube.shoppingCart.Model.Entity;
import com.metacube.shoppingCart.Model.Product;


public class InMemoryProductDao implements ProductDao, BaseDao {

	static HashMap<String, Product> productMap = new HashMap<String, Product>();

	@Override
	public void create(Entity entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Entity entity,Product input) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(String code) {
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

	

}
