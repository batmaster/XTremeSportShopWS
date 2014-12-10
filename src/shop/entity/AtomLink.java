package shop.entity;

import java.io.Serializable;
import java.net.URI;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public class AtomLink implements Serializable {
	
	@Transient
	public final static String NAMESPACE_ATOM = "http://www.w3.org/2005/Atom";
	
	@Transient
	public final static String PRODUCT_PATH = "http://128.199.145.53:22222/products/";
	
	@Transient
	public final static String SELF = "self";
	
	@Transient
	public final static String XML = "application/xml";

	@XmlAttribute(name = "rel")
	private String rel;

	@XmlAttribute(name = "href")
	private URI href;
	
	@XmlAttribute(name = "type")
	private String type;
	
	public AtomLink(URI href) {
		this.rel = SELF;
		this.href = href;
		this.type = XML;
	}
	
	public AtomLink(String rel, URI href, String type) {
		this.rel = rel;
		this.href = href;
		this.type = type;
	}
}
