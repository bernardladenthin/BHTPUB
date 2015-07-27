package org.dieschnittstelle.jee.esa.shopping;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import org.dieschnittstelle.jee.esa.crm.ejbs.CampaignTrackingLocal;
import org.dieschnittstelle.jee.esa.crm.ejbs.CustomerTrackingLocal;
import org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingCartLocal;
import org.dieschnittstelle.jee.esa.crm.ejbs.ShoppingException;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.entities.CrmProductBundle;
import org.dieschnittstelle.jee.esa.crm.entities.Customer;
import org.dieschnittstelle.jee.esa.crm.entities.CustomerTransaction;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.entities.Campaign;

@Stateful
public class ShoppingSessionFacadeStateful implements ShoppingSessionFacadeRemote {

	@EJB
	private ShoppingCartLocal shoppingCart;

	@EJB
	private CustomerTrackingLocal customerTracking;

	@EJB
	private CampaignTrackingLocal campaignTracking;

	private Customer customer;

	private AbstractTouchpoint touchpoint;

	@Override
	public void setTouchpoint(AbstractTouchpoint touchpoint) {
		this.touchpoint = touchpoint;
	}

	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void addProduct(AbstractProduct product, int units) {
		boolean isCampaign = product instanceof Campaign;
		shoppingCart.addProductBundle(new CrmProductBundle(product.getId(), units, isCampaign));
	}
	
	@Override
	public void purchase() {
		System.out.println("#purchase()");
		if (customer == null) {
			throw new RuntimeException("customer == null");
		}
		if (touchpoint == null) {
			throw new RuntimeException("touchpoint == null");
		}

		final List<CrmProductBundle> products = shoppingCart.getProductBundles();

		for (CrmProductBundle productBundle : products) {
			if (productBundle.isCampaign()) {
				int campaignUnits = campaignTracking.existsValidCampaignExecutionAtTouchpoint(productBundle.getErpProductId(), touchpoint);
				System.out.println("campaignUnits: " + campaignUnits);
				System.out.println("productBundle: " + productBundle);
				System.out.println("productBundle.getErpProductId(): " + productBundle.getErpProductId());
				System.out.println("productBundle.getUnits(): " + productBundle.getUnits());
				if (campaignUnits < productBundle.getUnits()) {
					throw new ShoppingException("campaignUnits < productBundle.getUnits()");
				}
				campaignTracking.purchaseCampaignAtTouchpoint(productBundle.getErpProductId(), this.touchpoint, productBundle.getUnits());
			}
		}

		CustomerTransaction transaction = new CustomerTransaction(this.customer, this.touchpoint, products);
		transaction.setCompleted(true);
		customerTracking.createTransaction(transaction);

		System.out.println("#purchase() done\n");
	}

}
