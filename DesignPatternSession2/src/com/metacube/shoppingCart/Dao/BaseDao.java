package com.metacube.shoppingCart.Dao;

import com.metacube.shoppingCart.Model.Entity;
import com.metacube.shoppingCart.Model.Product;

/**
 * The Interface BaseDao.
 */
public interface BaseDao {

	/**
	 * Creates the.
	 *
	 * @param entity
	 *            the entity
	 */
	public void create(Entity entity);

	/**
	 * Update.
	 *
	 * @param entity
	 *            the entity
	 */
	public void update(Entity entity,Product prod);

	/**
	 * Delete.
	 *
	 * @param entity
	 *            the entity
	 */
	public void delete(String code);

	/**
	 * Retreive.
	 *
	 * @param code
	 *            the code
	 * @return the entity
	 */
	public Entity retreive(String code);
}
