package org.dieschnittstelle.jee.esa.erp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.dieschnittstelle.jee.esa.entities.GenericCRUDEntity;

/*
 * UE JRS3: entfernen Sie die Auskommentierung der Annotation
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://dieschnittstelle.org/jee/esa/erp/entities")
@XmlSeeAlso({IndividualisedProductItem.class})
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractProduct implements Serializable, GenericCRUDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6940403029597060153L;

	@Id
	@GeneratedValue
	private int id;

	private String name;
	
	private int price;

	public AbstractProduct() {

	}

	public AbstractProduct(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
