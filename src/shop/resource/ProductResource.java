package shop.resource;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import shop.entity.Products;
import shop.service.DaoFactory;
import shop.service.ProductDao;
/**
 * Used to handle request from client.
 * Handle get product from client.
 * @author Rungroj Maipradit 5510546654
 *
 */
@Path("/products")
@Singleton
public class ProductResource {
	private ProductDao dao;
	private CacheControl cache;
	
	private static final int NOT_FOUND = 404;
	
	/**
	 * Initialize DAO and set cache.
	 */
	public ProductResource() {
		dao = DaoFactory.getInstance().getProductDao();
		cache = new CacheControl();
		cache.setMaxAge(86400);
		cache.setPrivate(true);
		System.out.println("Resource Created");
	}
	
	
	/**
	 * Get products if has query parameter search by query else return all products.
	 * @param request
	 * @param search use for search by query.
	 * @return response which has products value.
	 */
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getProduct(@Context Request request,@QueryParam("search")String search) {
		Products products;
		if(search == null){
			products = dao.findAll();
		}
		else{
			products = dao.findbystr(search);
		}
		return Response.ok(products).build();
	}
	
	/**
	 * Get specific product with id and support ETAG.
	 * If product doesn't exist return NOT_FOUND.
	 * @param id use for search product.
	 * @param request
	 * @return response which has products value.
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getProduct(@PathParam("id") int id, @Context Request request) {
		Products product = dao.find(id);
		if (product == null) {
			return Response.status(NOT_FOUND).build();
		}
		
		EntityTag etag = new EntityTag(Integer.toString(getEtag(product)));
		Response.ResponseBuilder builder = request.evaluatePreconditions(etag);
		if (builder == null)
			builder = Response.ok(product).tag(etag);
		builder.cacheControl(cache);
		return builder.build();
	}
	
	/**
	 * use for create ETAG for product.
	 * @param product use to create ETAG.
	 * @return product's hashcode.
	 */
	public int getEtag(Products product){
		return product.hashCode();
	}
	
	
}
