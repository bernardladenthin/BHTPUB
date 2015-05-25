
package org.dieschnittstelle.jee.esa.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;


/**
 * <p>Java-Klasse für customerTransaction complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="customerTransaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="completed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="customer" type="{http://dieschnittstelle.org/jee/esa/jaxws}customer" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="products" type="{http://dieschnittstelle.org/jee/esa/jaxws}crmProductBundle" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="touchpoint" type="{http://dieschnittstelle.org/jee/esa/crm/entities}abstractTouchpoint" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerTransaction", propOrder = {
    "completed",
    "customer",
    "date",
    "id",
    "products",
    "touchpoint",
    "value"
})
public class CustomerTransaction {

    protected boolean completed;
    protected Customer customer;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected int id;
    @XmlElement(nillable = true)
    protected List<CrmProductBundle> products;
    protected AbstractTouchpoint touchpoint;
    protected int value;

    /**
     * Ruft den Wert der completed-Eigenschaft ab.
     * 
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Legt den Wert der completed-Eigenschaft fest.
     * 
     */
    public void setCompleted(boolean value) {
        this.completed = value;
    }

    /**
     * Ruft den Wert der customer-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Legt den Wert der customer-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setCustomer(Customer value) {
        this.customer = value;
    }

    /**
     * Ruft den Wert der date-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Legt den Wert der date-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the products property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the products property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProducts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CrmProductBundle }
     * 
     * 
     */
    public List<CrmProductBundle> getProducts() {
        if (products == null) {
            products = new ArrayList<CrmProductBundle>();
        }
        return this.products;
    }

    /**
     * Ruft den Wert der touchpoint-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AbstractTouchpoint }
     *     
     */
    public AbstractTouchpoint getTouchpoint() {
        return touchpoint;
    }

    /**
     * Legt den Wert der touchpoint-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AbstractTouchpoint }
     *     
     */
    public void setTouchpoint(AbstractTouchpoint value) {
        this.touchpoint = value;
    }

    /**
     * Ruft den Wert der value-Eigenschaft ab.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Legt den Wert der value-Eigenschaft fest.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

}
