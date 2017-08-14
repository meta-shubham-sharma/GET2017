package com.metacube.shoppingCart.Dao;

import java.util.List;

import com.metacube.shoppingCart.Model.Product;

/**
 * The Interface ProductDao.
 */
public interface ProductDao extends BaseDao{
		
		/**
		 * Gets the all products.
		 *
		 * @return the all products
		 */
		public List<Product> getAllProducts();
}
