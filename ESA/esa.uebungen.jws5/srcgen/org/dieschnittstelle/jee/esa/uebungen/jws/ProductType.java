
package org.dieschnittstelle.jee.esa.uebungen.jws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für productType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="productType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BREAD"/>
 *     &lt;enumeration value="ROLL"/>
 *     &lt;enumeration value="PASTRY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "productType", namespace = "http://dieschnittstelle.org/jee/esa/uebungen/jws")
@XmlEnum
public enum ProductType {

    BREAD,
    ROLL,
    PASTRY;

    public String value() {
        return name();
    }

    public static ProductType fromValue(String v) {
        return valueOf(v);
    }

}
