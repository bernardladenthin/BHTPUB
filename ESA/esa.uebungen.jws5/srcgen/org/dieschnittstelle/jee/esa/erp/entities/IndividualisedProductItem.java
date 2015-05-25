
package org.dieschnittstelle.jee.esa.erp.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.dieschnittstelle.jee.esa.uebungen.jws.ProductType;


/**
 * <p>Java-Klasse für individualisedProductItem complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="individualisedProductItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://dieschnittstelle.org/jee/esa/erp/entities}abstractProduct">
 *       &lt;sequence>
 *         &lt;element name="expirationAfterStocked" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="productType" type="{http://dieschnittstelle.org/jee/esa/uebungen/jws}productType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "individualisedProductItem", propOrder = {
    "expirationAfterStocked",
    "productType"
})
public class IndividualisedProductItem
    extends AbstractProduct
{

    protected int expirationAfterStocked;
    protected ProductType productType;

    /**
     * Ruft den Wert der expirationAfterStocked-Eigenschaft ab.
     * 
     */
    public int getExpirationAfterStocked() {
        return expirationAfterStocked;
    }

    /**
     * Legt den Wert der expirationAfterStocked-Eigenschaft fest.
     * 
     */
    public void setExpirationAfterStocked(int value) {
        this.expirationAfterStocked = value;
    }

    /**
     * Ruft den Wert der productType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProductType }
     *     
     */
    public ProductType getProductType() {
        return productType;
    }

    /**
     * Legt den Wert der productType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductType }
     *     
     */
    public void setProductType(ProductType value) {
        this.productType = value;
    }

}
