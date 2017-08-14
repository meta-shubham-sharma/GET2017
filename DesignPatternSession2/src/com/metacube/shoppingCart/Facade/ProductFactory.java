package com.metacube.shoppingCart.Facade;

import com.metacube.shoppingCart.Dao.BaseDao;
import com.metacube.shoppingCart.Dao.InMemoryProductDao;

/**
 * A factory for creating Product objects.
 */
public class ProductFactory {
	
	/**
	 * Gets the single instance of ProductFactory.
	 *
	 * @param str the str
	 * @return single instance of ProductFactory
	 */
	public static BaseDao getInstance(String str){
		switch(str){
		case "InMemoryProductDao":
			return new InMemoryProductDao();
		default:
			return null;
		}
	}
}
