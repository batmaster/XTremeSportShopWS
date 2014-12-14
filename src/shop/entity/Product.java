package shop.entity;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Product contains name, price, description, image.
 * Receive image and price from productIamge and productPrice.
 * @author Rungroj Maipradit 5510546654
 */
@Entity(name="ProductDescriptions")
@Table(name="ProductDescriptions")
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Product implements Serializable {

	/**
	 * Id of product.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	@Column(name="ProductDescriptionId")
	private long id;

	/**
	 * Name of product.
	 */
	@XmlElement
	@Column(name="ProductName")
	private String name;

	/**
	 * price of product.
	 */
	@Transient
	private double price;
	@Column(name="Description")
	private String description;

	/**
	 * image of product.
	 */
	@XmlElement
	@Transient
	private String image;

	/**
	 * URL refer to real product.
	 */
	@XmlElement
	@Transient
	private String url;
	
	protected Product() {

	}

	public void setPrice(double p) {
		price = p;
	}

	public long getId() {
		return id;
	}
	
	public void setProductImageUrl(String url) {
		image = url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}


	/**
	 * AtomLink of this product.
	 */
	@Transient
	@XmlTransient
	private AtomLinks links = null;

	/**
	 * Set AtomLink and URL.
	 * @return
	 */
	@XmlElement(name = "link", namespace = AtomLink.NAMESPACE_ATOM)
	public AtomLinks getLink() {
		if (this.links == null) {
			try {
				AtomLink self = new AtomLink(new URI(AtomLink.PRODUCT_PATH + id));
				AtomLinks links = new AtomLinks();
				links.add(self);
				this.links = links;
				setUrl(AtomLink.PRODUCT_PATH + id);
			} catch (URISyntaxException e) {

			}
		}

		return this.links;
	}
	
	@Override
	public int hashCode() {
		return ((id+"aa").hashCode()+name+price+name+description+image+"").hashCode();
	}
}
