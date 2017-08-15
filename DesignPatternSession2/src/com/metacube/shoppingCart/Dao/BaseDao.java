package com.metacube.shoppingCart.Dao;

import com.metacube.shoppingCart.Model.Entity;

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
	public void update(Entity entity);

	/**
	 * Delete.
	 *
	 * @param entity
	 *            the entity
	 */
	public void delete(Entity entity);

	/**
	 * Retreive.
	 *
	 * @param code
	 *            the code
	 * @return the entity
	 */
	public Entity retreive(String code);
}
