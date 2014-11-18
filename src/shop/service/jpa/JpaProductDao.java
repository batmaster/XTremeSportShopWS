package shop.service.jpa;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import shop.entity.Product;
import shop.service.ProductDao;
import jersey.repackaged.com.google.common.collect.Lists;

/**
 * Data access object for saving and retrieving contacts,
 * using JPA.
 * To get an instance of this class use:
 * <p>
 * <tt>
 * dao = DaoFactory.getInstance().getContactDao()
 * </tt>
 * 
 * @author jim
 */
public class JpaProductDao extends ProductDao {
	
	/** the EntityManager for accessing JPA persistence services. */
	private final EntityManager em;
	
	/**
	 * Constructor with injected EntityManager to use.
	 * @param em an EntityManager for accessing JPA services
	 */
	public JpaProductDao(EntityManager em) {
		this.em = em;
	}

	/**
	 * @see shop.service.ProductDao#find(long)
	 */
	@Override
	public Product find(long id) {
		return em.find(Product.class, id);
	}

	/**
	 * @see shop.service.ProductDao#findAll()
	 */
	@Override
	public ArrayList<Product> findAll() {
		Query query = em.createQuery("SELECT c FROM Contact c");
		ArrayList<Product> result = new ArrayList<Product>(query.getResultList());
		return result;
	}

	/**
	 * @see shop.service.ProductDao#findByTitle(java.lang.String)
	 */
	@Override
	public ArrayList<Product> findByTitle(String titlestr) {
		Query query = em.createQuery("SELECT c FROM Product c WHERE LOWER(c.title) LIKE :title");
		query.setParameter("title", "%" + titlestr.toLowerCase() + "%");
		ArrayList<Product> result = new ArrayList<Product>(query.getResultList());
		return result;
	}

}
