package shop.resource;

import java.util.ArrayList;

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

import shop.entity.Product;
import shop.service.DaoFactory;
import shop.service.ProductDao;

@Path("/product")
@Singleton
public class ProductResource {
	
	private ProductDao dao;
	private CacheControl cache;
	
	private static final int NOT_FOUND = 404;
	
	public ProductResource() {
		dao = DaoFactory.getInstance().getContactDao();
		cache = new CacheControl();
		cache.setMaxAge(86400);
		cache.setPrivate(true);
		System.out.println("ContactResource Created");
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response getContact(@QueryParam("q") String title, @Context Request request) {
		System.out.println("in get");
		if (title == null) {
			ArrayList<Product> products = dao.findAll();
			return Response.ok(products).build();
		}
		ArrayList<Product> products = dao.findByTitle(title);
		return Response.ok(products).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Response getProduct(@PathParam("id") int id, @Context Request request) {
		Product contact = dao.find(id);
		if (contact == null) {
			return Response.status(NOT_FOUND).build();
		}
		
		EntityTag etag = new EntityTag(Integer.toString(contact.hashCode()));
		Response.ResponseBuilder builder = request.evaluatePreconditions(etag);
		// cache changed
		if (builder == null)
			builder = Response.ok(contact).tag(etag);
			
		builder.cacheControl(cache);
		return builder.build();
	}
	
	
}
