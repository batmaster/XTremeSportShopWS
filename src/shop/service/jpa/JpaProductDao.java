package shop.service.jpa;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import shop.entity.Product;
import shop.entity.ProductImage;
import shop.entity.ProductPrice;
import shop.entity.Products;
import shop.service.ProductDao;

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
	public Products find(long id) {
		Product productdesc = em.find(Product.class, id);
		
		ProductPrice productprice = em.find(ProductPrice.class, id);
		productdesc.setPrice(productprice.getPrice());
		
		ProductImage productImage = em.find(ProductImage.class, id);
		productdesc.setProductImageUrl(productImage.getUrl());
		
		return new Products(productdesc);
	}

	/**
	 * @see shop.service.ProductDao#findAll()
	 */
	@Override
	public Products findAll() {
		Query query = em.createQuery("SELECT p FROM ProductDescriptions p");
		ArrayList<Product> productList = new ArrayList<Product>(query.getResultList());
		for(int i = 0;i<productList.size();i++){
			long id = productList.get(i).getId();
			ProductPrice productprice = em.find(ProductPrice.class, id);
			productList.get(i).setPrice(productprice.getPrice());
			ProductImage productImage = em.find(ProductImage.class, id);
			productList.get(i).setProductImageUrl(productImage.getUrl());
		}
		Products result = new Products(productList);
		
		return result;
	}

	/**
	 * @see shop.service.ProductDao#findbystr(String)
	 */
	@Override
	public Products findbystr(String str) {
		Query query = em.createQuery("SELECT p FROM ProductDescriptions p where p.name like :str");
		query.setParameter("str","%"+str+"%");
		ArrayList<Product> productList = new ArrayList<Product>(query.getResultList());
		for(int i = 0;i<productList.size();i++){
			long id = productList.get(i).getId();
			ProductPrice productprice = em.find(ProductPrice.class, id);
			productList.get(i).setPrice(productprice.getPrice());
			ProductImage productImage = em.find(ProductImage.class, id);
			productList.get(i).setProductImageUrl(productImage.getUrl());
		}
		Products result = new Products(productList);
		
		return result;
	}
	
	
}
