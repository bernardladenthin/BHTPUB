
package org.dieschnittstelle.jee.esa.uebungen.jws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProductArray;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.dieschnittstelle.jee.esa.uebungen.jws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteProductResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/uebungen/jws", "deleteProductResponse");
    private final static QName _CreateProductResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/uebungen/jws", "createProductResponse");
    private final static QName _UpdateProduct_QNAME = new QName("http://dieschnittstelle.org/jee/esa/uebungen/jws", "updateProduct");
    private final static QName _CreateProduct_QNAME = new QName("http://dieschnittstelle.org/jee/esa/uebungen/jws", "createProduct");
    private final static QName _ReadAllProductsResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/uebungen/jws", "readAllProductsResponse");
    private final static QName _DeleteProduct_QNAME = new QName("http://dieschnittstelle.org/jee/esa/uebungen/jws", "deleteProduct");
    private final static QName _UpdateProductResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/uebungen/jws", "updateProductResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.dieschnittstelle.jee.esa.uebungen.jws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/uebungen/jws", name = "deleteProductResponse")
    public JAXBElement<Boolean> createDeleteProductResponse(Boolean value) {
        return new JAXBElement<Boolean>(_DeleteProductResponse_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/uebungen/jws", name = "createProductResponse")
    public JAXBElement<AbstractProduct> createCreateProductResponse(AbstractProduct value) {
        return new JAXBElement<AbstractProduct>(_CreateProductResponse_QNAME, AbstractProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/uebungen/jws", name = "updateProduct")
    public JAXBElement<AbstractProduct> createUpdateProduct(AbstractProduct value) {
        return new JAXBElement<AbstractProduct>(_UpdateProduct_QNAME, AbstractProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/uebungen/jws", name = "createProduct")
    public JAXBElement<AbstractProduct> createCreateProduct(AbstractProduct value) {
        return new JAXBElement<AbstractProduct>(_CreateProduct_QNAME, AbstractProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractProductArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/uebungen/jws", name = "readAllProductsResponse")
    public JAXBElement<AbstractProductArray> createReadAllProductsResponse(AbstractProductArray value) {
        return new JAXBElement<AbstractProductArray>(_ReadAllProductsResponse_QNAME, AbstractProductArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/uebungen/jws", name = "deleteProduct")
    public JAXBElement<Integer> createDeleteProduct(Integer value) {
        return new JAXBElement<Integer>(_DeleteProduct_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/uebungen/jws", name = "updateProductResponse")
    public JAXBElement<AbstractProduct> createUpdateProductResponse(AbstractProduct value) {
        return new JAXBElement<AbstractProduct>(_UpdateProductResponse_QNAME, AbstractProduct.class, null, value);
    }

}
