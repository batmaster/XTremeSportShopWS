package shop.entity;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType (XmlAccessType.FIELD)
public class Products implements Serializable {
	
	@XmlElement(name = "product")
	private ArrayList<Product> products;

	protected Products() {
		
	}
	
	public Products(ArrayList<Product> list) {
		products = list;
	}
}
