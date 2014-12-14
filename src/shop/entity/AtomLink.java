package shop.entity;

import java.io.Serializable;
import java.net.URI;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Create AtomLink for product.
 * @author Poramate Homprakob 5510546077
 */
@XmlAccessorType(XmlAccessType.NONE)
public class AtomLink implements Serializable {
	
	/**
	 * Name space of AtomLink.
	 */
	@Transient
	public final static String NAMESPACE_ATOM = "http://www.w3.org/2005/Atom";
	
	/**
	 * Use for create self link.
	 */
	@Transient
	public final static String PRODUCT_PATH = "http://128.199.145.53/tsp/?page=detail&id=";
	
	@Transient
	public final static String SELF = "self";
	
	@Transient
	public final static String XML = "application/xml";

	/**
	 * Attribute in AtomLink.
	 */
	@XmlAttribute(name = "rel")
	private String rel;

	/**
	 * Attribute in AtomLink.
	 */
	@XmlAttribute(name = "href")
	private URI href;
	
	/**
	 * Attribute in AtomLink.
	 */
	@XmlAttribute(name = "type")
	private String type;
	
	/**
	 * Use to initialize AtomLink with href.
	 * @param href use for set href.
	 */
	public AtomLink(URI href) {
		this.rel = SELF;
		this.href = href;
		this.type = XML;
	}
	
	/**
	 * Use to initialize AtomLink.
	 * @param rel use for set rel.
	 * @param href use for set href.
	 * @param type use for set type.
	 */
	public AtomLink(String rel, URI href, String type) {
		this.rel = rel;
		this.href = href;
		this.type = type;
	}
}
