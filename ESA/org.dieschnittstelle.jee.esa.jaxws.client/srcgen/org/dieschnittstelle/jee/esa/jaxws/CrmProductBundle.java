
package org.dieschnittstelle.jee.esa.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für crmProductBundle complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="crmProductBundle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="productObj" type="{http://dieschnittstelle.org/jee/esa/jaxws}abstractProduct" minOccurs="0"/>
 *         &lt;element name="units" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crmProductBundle", propOrder = {
    "productObj",
    "units"
})
public class CrmProductBundle {

    protected AbstractProduct productObj;
    protected int units;

    /**
     * Ruft den Wert der productObj-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AbstractProduct }
     *     
     */
    public AbstractProduct getProductObj() {
        return productObj;
    }

    /**
     * Legt den Wert der productObj-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AbstractProduct }
     *     
     */
    public void setProductObj(AbstractProduct value) {
        this.productObj = value;
    }

    /**
     * Ruft den Wert der units-Eigenschaft ab.
     * 
     */
    public int getUnits() {
        return units;
    }

    /**
     * Legt den Wert der units-Eigenschaft fest.
     * 
     */
    public void setUnits(int value) {
        this.units = value;
    }

}
