package esa.uebungen.jws5;

import java.util.List;

import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProductArray;
import org.dieschnittstelle.jee.esa.erp.entities.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.uebungen.jws.ProductCRUDWebService;
import org.dieschnittstelle.jee.esa.uebungen.jws.ProductCRUDWebService_Service;
import org.dieschnittstelle.jee.esa.uebungen.jws.ProductType;

/*
 * UE JWS5: rufen Sie hier den in JWS4 implementierten Web Service auf.
 */
public class TestProductCRUDWebService {
	
	private ProductCRUDWebService_Service service;
	private ProductCRUDWebService serviceOperations;
	
	public static void main(String[] args) {
		TestProductCRUDWebService testProductCRUDWebService = new TestProductCRUDWebService();
		testProductCRUDWebService.main();
	}
	
	public void main() {
		/*
		 * initialisieren ein Service Interface fuer den in JWS4 erstellten Web Service
		 */		
		service = new ProductCRUDWebService_Service();
		serviceOperations = service.getProductCRUDWebServicePort();
		
		// create two products and add them to the list of products
		IndividualisedProductItem prod1 = new IndividualisedProductItem();
		prod1.setName("Schrippe");
		prod1.setProductType(ProductType.ROLL);
		prod1.setPrice(720);
		
		IndividualisedProductItem prod2 = new IndividualisedProductItem();
		prod2.setName("Kirschplunder");
		prod2.setProductType(ProductType.PASTRY);
		prod2.setPrice(1080);
		
		/*
		 * rufen Sie die im Interface deklarierte Methode fuer das Erzeugen von Produkten fuer prod1 und prod2 auf und geben Sie die Rueckgabewerte auf der Kosole aus.
		 */
		AbstractProduct ap1 = serviceOperations.createProduct(prod1);
		System.out.println("create product 1:");
		soutProduct(ap1);
		System.out.println();
		System.out.println();
		System.out.println();
		
		AbstractProduct ap2 = serviceOperations.createProduct(prod2);
		System.out.println("create product 2:");
		soutProduct(ap2);
		System.out.println();
		System.out.println();
		System.out.println();
		
		/*
		 * rufen Sie die im Interface deklarierte Methode fuer das Auslesen aller Produkte auf und geben Sie den Rueckgabewert auf der Konsole aus.
		 */
		AbstractProductArray apa = serviceOperations.readAllProducts();
		System.out.println("AbstractProductArray: " + apa);
		
		List<AbstractProduct> products = apa.getItem();
		soutProducts(products);
		System.out.println();
		System.out.println();
		System.out.println();
		
		// delete all products
		deleteProducts(products);
		
		System.out.println("TestProductCRUDWebService: done.");
	}

	private void deleteProducts(Iterable<AbstractProduct> products) {
		System.out.println("deleteProducts():");
		for (AbstractProduct ap : products) {
			deleteProduct(ap);
		}
	}

	private void deleteProduct(AbstractProduct ap) {
		System.out.println("deleteProduct(): " + ap);
		int id = ap.getId();
		System.out.println("id: " + id);
		serviceOperations.deleteProduct(id);
	}
	
	private void soutProducts(Iterable<AbstractProduct> products) {
		System.out.println("soutProducts():");
		for (AbstractProduct ap : products) {
			soutProduct(ap);
		}
	}

	private void soutProduct(AbstractProduct ap) {
		System.out.println("soutProduct(): " + ap);
		System.out.println("id: " + ap.getId());
		System.out.println("name: " + ap.getName());
		System.out.println("price: " + ap.getPrice());
	}
	
}
