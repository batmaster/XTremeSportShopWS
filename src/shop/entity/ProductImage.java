package shop.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@Entity
@Table(name = "ProductImages")
@XmlAccessorType (XmlAccessType.FIELD)
public class ProductImage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ProductDescriptionId")
	@XmlAttribute
	private long id;

	
//	@XmlAttribute
//	@Id
//	@Column(name="ProductDescriptionId")
//	private long id;
	
//	@XmlTransient
//	private long productDescriptionId;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="ProductDescriptionId",referencedColumnName="ProductDescriptionId")
//	@XmlInverseReference(mappedBy="imageList")
//	@XmlTransient
//	private Product product;
	
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
