package shop.service;

import shop.entity.Products;

/**
 * An abstract for product dao contains method for handling
 * with product.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
public abstract class ProductDao {

	/**
	 * Get the exist product in the list with specific id.
	 * @param id id of the product that want to find
	 * @return product with specific id, null if not found
	 */
	public abstract Products find(long id);
	
	/**
	 * Get list of all products.
	 * @return list of all products
	 */
	public abstract Products findAll();
	
	public abstract Products findbystr(String str);
}
