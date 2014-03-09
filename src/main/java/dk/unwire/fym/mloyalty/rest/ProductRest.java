package dk.unwire.fym.mloyalty.rest;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.util.HttpResponseCodes;

import dk.unwire.fym.mloyalty.model.Product;
import dk.unwire.fym.mloyalty.service.ProductService;

@Path("/")
public class ProductRest {
	
	@Inject
	private ProductService productService;

	@PermitAll
	@GET
	@Path("products/{merchantId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts(@PathParam("merchantId") long merchantId) {
		List<Product> products = productService.getProductsByMerchant(merchantId);
		return Response.status(HttpResponseCodes.SC_OK).entity(products).build();
	}
	
	@PermitAll
	@GET
	@Path("product/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("productId") long productId) {
		Product product = productService.getProduct(productId);
		return Response.status(HttpResponseCodes.SC_OK).entity(product).build();
	}
}
