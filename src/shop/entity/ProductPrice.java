package shop.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Contains product's id and product's price.
 * Use for join with product to set product's price.
 * @author Rungroj Maipradit 5510546654
 */
@Entity(name="Products")
@Table(name="Products")
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class ProductPrice implements Serializable {
	
	/**
	 * Id of product.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductDescriptionId")
	@XmlAttribute
	private long id;
	
	/**
	 * Price of product.
	 */
	@XmlElement
	@Column(name="Price")
	private double price;
	
	protected ProductPrice() {
		
	}

	public double getPrice() {
		return price;
	}
}
