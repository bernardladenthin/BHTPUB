package org.dieschnittstelle.jee.esa.crm.ejbs;

import java.util.List;

import javax.ejb.Local;

import org.dieschnittstelle.jee.esa.crm.entities.CustomerTransaction;

@Local
public interface CustomerTrackingLocal {

	public void createTransaction(CustomerTransaction transaction);

	public List<CustomerTransaction> readAllTransactions();

}
