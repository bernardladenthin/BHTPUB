package org.dieschnittstelle.jee.esa.ejbs.client.shopping;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.ejbs.CampaignTrackingRemote;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.entities.Customer;
import org.dieschnittstelle.jee.esa.ejbs.client.Constants;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.shopping.ShoppingSessionFacadeRemote;

public class ShoppingSessionFacadeClient implements ShoppingBusinessDelegate {

	protected static Logger logger = Logger
			.getLogger(ShoppingSessionFacadeClient.class);

	/*
	 * use the ShoppingSessionFacadeRemote interface
	 */
	private ShoppingSessionFacadeRemote proxy;

	@Override
	public void initialise() throws Exception {
		/* create a jndi context */
		Context context = new InitialContext();
		
		/* lookup the bean */
		proxy = (ShoppingSessionFacadeRemote) context.lookup(Constants.SHOPPING_SESSION_BEAN);
	}

	@Override
	public void setTouchpoint(AbstractTouchpoint touchpoint) {
		proxy.setTouchpoint(touchpoint);
	}

	@Override
	public void setCustomer(Customer customer) {
		proxy.setCustomer(customer);
	}

	@Override
	public void addProduct(AbstractProduct product, int units) {
		proxy.addProduct(product, units);	
	}

	@Override
	public void purchase() {
		proxy.purchase();	
	}
}
