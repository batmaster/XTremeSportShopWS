package shop.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Product {
	
	@Id
	@XmlAttribute
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String desc;
	private double price;
	
	protected Product() {
		this(null, null, 0);
	}
	
	public Product(String name, String desc, double price) {
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
}
