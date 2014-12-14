package shop.entity;

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
/**
 * Contains product's id and product's image.
 * Use for join with product to set product's image.
 * @author Rungroj Maipradit 5510546654
 */
@Entity
@Table(name = "ProductImages")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProductImage {
	/**
	 * Id of product.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductDescriptionId")
	@XmlAttribute
	private long id;

	/**
	 * Image of product.
	 */
	@XmlElement
	@Column(name="ImageAddress")
	private String url;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
