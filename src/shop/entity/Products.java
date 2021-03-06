package shop.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Contains list of product.
 * Use for return productList.
 * @author Rungroj Maipradit 5510546654
 */
@Entity
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Products implements Serializable {
	
	/**
	 * Contains list of product.
	 */
	@XmlElement(name = "product")
	private ArrayList<Product> products;

	public Products() {
		products = new ArrayList<Product>();
	}
	
	public Products(Product product) {
		products = new ArrayList<Product>();
		addProduct(product);
	}
	
	public Products(ArrayList<Product> list) {
		products = list;
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
}
