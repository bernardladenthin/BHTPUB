package org.dieschnittstelle.jee.esa.jaxrs;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.entities.GenericCRUDExecutor;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;

/*
UE JRS2: implementieren Sie hier die im Interface deklarierten Methoden
 */

public class ProductCRUDWebServiceImpl implements IProductCRUDWebService {

	protected static Logger logger = Logger.getLogger(ProductCRUDWebServiceImpl.class);
	
	/**
	 * this accessor will be provided by the ServletContext, to which it is written by the ProductServletContextListener
	 */
	private GenericCRUDExecutor<AbstractProduct> productCRUD;
	
	public ProductCRUDWebServiceImpl(@Context ServletContext servletContext, @Context HttpServletRequest request) {
		logger.info("<constructor>: " + servletContext + "/" + request);
		// read out the dataAccessor
		this.productCRUD = (GenericCRUDExecutor<AbstractProduct>)servletContext.getAttribute("productCRUD");
		
		logger.debug("read out the productCRUD from the servlet context: " + this.productCRUD);		
	}
	
	@Override
	public AbstractProduct createProduct(AbstractProduct prod) {
		return (AbstractProduct)this.productCRUD.createObject(prod);	
	}

	@Override
	public List<AbstractProduct> readAllProducts() {
		return this.productCRUD.readAllObjects();
	}

	@Override
	public AbstractProduct updateProduct(int id, AbstractProduct update) {
		return (AbstractProduct)this.productCRUD.updateObject(update);	
	}

	@Override
	public boolean deleteProduct(int id) {
		return this.productCRUD.deleteObject(id);
	}

	@Override
	public AbstractProduct readProduct(int id) {
		return this.productCRUD.readObject(id);
	}
	
}
