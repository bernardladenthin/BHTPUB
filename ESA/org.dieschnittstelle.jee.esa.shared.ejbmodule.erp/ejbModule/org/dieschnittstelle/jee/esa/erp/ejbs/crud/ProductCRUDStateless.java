package org.dieschnittstelle.jee.esa.erp.ejbs.crud;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.jboss.logging.Logger;

@Stateless
public class ProductCRUDStateless implements ProductCRUDRemote {

	protected static Logger logger = Logger
			.getLogger(ProductCRUDStateless.class);

	@PersistenceContext(unitName = "crm_erp_PU")
	private EntityManager em;

	@Override
	public AbstractProduct createProduct(AbstractProduct prod) {
		em.persist(prod);
		return prod;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AbstractProduct> readAllProducts() {
		Query query = em.createQuery("FROM AbstractProduct");
		return (List<AbstractProduct>) query.getResultList();
	}

	@Override
	public AbstractProduct updateProduct(AbstractProduct update) {
		return em.merge(update);
	}

	@Override
	public AbstractProduct readProduct(int productID) {
		return em.find(AbstractProduct.class, productID);
	}

	@Override
	public boolean deleteProduct(int productID) {
		em.remove(em.find(AbstractProduct.class, productID));
		return true;
	}
}
