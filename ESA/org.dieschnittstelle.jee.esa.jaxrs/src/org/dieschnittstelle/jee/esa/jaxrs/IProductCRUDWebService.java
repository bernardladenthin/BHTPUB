package org.dieschnittstelle.jee.esa.jaxrs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.entities.IndividualisedProductItem;

/*
 * UE JRS2: 
 * deklarieren Sie hier Methoden fuer:
 * - die Erstellung eines Produkts
 * - das Auslesen aller Produkte
 * - das Auslesen eines Produkts
 * - die Aktualisierung eines Produkts
 * - das Loeschen eines Produkts
 * und machen Sie diese Methoden mittels JAX-RS Annotationen als WebService verfuegbar
 */

/*
 * UE JRS3: aendern Sie Argument- und Rueckgabetypen der Methoden von IndividualisedProductItem auf AbstractProduct
 */
@Path("/resteasy/products")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface IProductCRUDWebService {

	@POST
	public IndividualisedProductItem createProduct(IndividualisedProductItem prod);

	@GET
	public List<IndividualisedProductItem> readAllProducts();

	@PUT
	@Path("/{productId}")
	public IndividualisedProductItem updateProduct(@PathParam("productId") int id,
			IndividualisedProductItem update);

	@DELETE
	@Path("/{productId}")
	boolean deleteProduct(@PathParam("productId") int id);

	@GET
	@Path("/{productId}")
	public IndividualisedProductItem readProduct(@PathParam("productId") int id);
			
}
