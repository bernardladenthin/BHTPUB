
package org.dieschnittstelle.jee.esa.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpointArray;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.dieschnittstelle.jee.esa.jaxws package. 
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

    private final static QName _CreateTouchpoint_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jaxws", "createTouchpoint");
    private final static QName _DeleteTouchpointResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jaxws", "deleteTouchpointResponse");
    private final static QName _CreateTouchpointResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jaxws", "createTouchpointResponse");
    private final static QName _ReadAllTouchpointsResponse_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jaxws", "readAllTouchpointsResponse");
    private final static QName _DeleteTouchpoint_QNAME = new QName("http://dieschnittstelle.org/jee/esa/jaxws", "deleteTouchpoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.dieschnittstelle.jee.esa.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CustomerTransaction }
     * 
     */
    public CustomerTransaction createCustomerTransaction() {
        return new CustomerTransaction();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link CrmProductBundle }
     * 
     */
    public CrmProductBundle createCrmProductBundle() {
        return new CrmProductBundle();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link MobileTouchpoint }
     * 
     */
    public MobileTouchpoint createMobileTouchpoint() {
        return new MobileTouchpoint();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTouchpoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jaxws", name = "createTouchpoint")
    public JAXBElement<AbstractTouchpoint> createCreateTouchpoint(AbstractTouchpoint value) {
        return new JAXBElement<AbstractTouchpoint>(_CreateTouchpoint_QNAME, AbstractTouchpoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jaxws", name = "deleteTouchpointResponse")
    public JAXBElement<Boolean> createDeleteTouchpointResponse(Boolean value) {
        return new JAXBElement<Boolean>(_DeleteTouchpointResponse_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTouchpoint }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jaxws", name = "createTouchpointResponse")
    public JAXBElement<AbstractTouchpoint> createCreateTouchpointResponse(AbstractTouchpoint value) {
        return new JAXBElement<AbstractTouchpoint>(_CreateTouchpointResponse_QNAME, AbstractTouchpoint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AbstractTouchpointArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jaxws", name = "readAllTouchpointsResponse")
    public JAXBElement<AbstractTouchpointArray> createReadAllTouchpointsResponse(AbstractTouchpointArray value) {
        return new JAXBElement<AbstractTouchpointArray>(_ReadAllTouchpointsResponse_QNAME, AbstractTouchpointArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dieschnittstelle.org/jee/esa/jaxws", name = "deleteTouchpoint")
    public JAXBElement<Integer> createDeleteTouchpoint(Integer value) {
        return new JAXBElement<Integer>(_DeleteTouchpoint_QNAME, Integer.class, null, value);
    }

}
