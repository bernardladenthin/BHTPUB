package esa.uebungen.jws4;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.dieschnittstelle.jee.esa.entities.GenericCRUDExecutor;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.jboss.logging.Logger;

/*
 * UE JWS4: machen Sie die Funktionalitaet dieser Klasse als Web Service verfuegbar und verwenden Sie fuer 
 * die Umetzung der beiden Methoden die Instanz von GenericCRUDExecutor<AbstractProduct>, 
 * die Sie aus dem ServletContext auslesen koennen
 */
@WebService(targetNamespace = "http://dieschnittstelle.org/jee/esa/uebungen/jws", serviceName = "ProductCRUDWebService")
@SOAPBinding(parameterStyle = ParameterStyle.BARE)
public class ProductCRUDWebService {

	protected static Logger logger = Logger.getLogger(ProductCRUDWebService.class);

	@Resource
	private WebServiceContext wscontext;

	public ProductCRUDWebService() {
		logger.info("<constructor>");
	}

	@PostConstruct
	@WebMethod(exclude = true)
	public void initialiseContext() {
		logger.info("@PostConstruct: the wscontext is: " + wscontext);
	}

	/**
	 * obtain the CRUD executor from the servlet context
	 * @return the ServletContext
	 */
	private ServletContext getServletContext() {
		ServletContext sc = ((ServletContext) wscontext.getMessageContext().get(MessageContext.SERVLET_CONTEXT));
		logger.info("<< getServletContext(): " + sc);
		return sc;
	}

	private GenericCRUDExecutor<AbstractProduct> getProductCRUD() {
		GenericCRUDExecutor<AbstractProduct> crud = (GenericCRUDExecutor<AbstractProduct>) getServletContext().getAttribute("productCRUD");
		logger.info("<< getProductCRUD(): " + crud);
		return crud;
	}

	@WebMethod
	public List<AbstractProduct> readAllProducts() {
		logger.info("<< readAllProducts()");
		return getProductCRUD().readAllObjects();
	}

	@WebMethod
	public AbstractProduct createProduct(AbstractProduct product) {
		logger.info("<< createObject()");
		return getProductCRUD().createObject(product);
	}

	@WebMethod
	public AbstractProduct updateProduct(AbstractProduct product) {
		logger.info("<< updateProduct()");
		return getProductCRUD().updateObject(product);
	}

	@WebMethod
	public boolean deleteProduct(int productId) {
		logger.info("<< deleteProduct()");
		return getProductCRUD().deleteObject(productId);
	}
}
