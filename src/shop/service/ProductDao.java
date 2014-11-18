package shop.service;

import java.util.ArrayList;

import shop.entity.Product;

/**
 * An abstract for contact dao contains method for handling
 * with contact.
 * 
 * @author Poramate Homprakob 5510546077
 *
 */
public abstract class ProductDao {

	/** A runner id for auto assign id to a new contact. */
	private static int runnerId = 1;

	/**
	 * Get the exist contact in the list with specific id.
	 * @param id id of the contact that want to find
	 * @return contact with specific id, null if not found
	 */
	public abstract Product find(long id);
	
	/**
	 * Get list of all contacts.
	 * @return list of all contacts
	 */
	public abstract ArrayList<Product> findAll();
	
	/**
	 * Get list of contacts whose title contains a specific string 
	 * @param title the specific string
	 * @return contactlist of contact
	 */
	public abstract ArrayList<Product> findByTitle(String name);
}
