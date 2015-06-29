package org.dieschnittstelle.jee.esa.erp.ejbs.crud;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.entities.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.erp.entities.PointOfSale;
import org.dieschnittstelle.jee.esa.erp.entities.ProductAtPosPK;
import org.dieschnittstelle.jee.esa.erp.entities.StockItem;
import org.jboss.logging.Logger;

@Stateless
public class StockItemCRUDStateless implements StockItemCRUDLocal {

	protected static Logger logger = Logger
			.getLogger(StockItemCRUDStateless.class);

	@PersistenceContext(unitName = "crm_erp_PU")
	private EntityManager em;

	@Override
	public StockItem createStockItem(StockItem item) {
		if (!em.contains(item.getProduct())) {
			item.setProduct(em.merge(item.getProduct()));
		}
		em.persist(item);
		return item;
	}

	@Override
	public StockItem readStockItem(AbstractProduct prod, PointOfSale pos) {
		return em.find(StockItem.class, new ProductAtPosPK(
				(IndividualisedProductItem) prod, pos));
	}

	@Override
	public StockItem updateStockItem(StockItem item) {
		return em.merge(item);
	}

	@Override
	public List<StockItem> readStockItemsForProduct(AbstractProduct prod) {
		Query qu = em
				.createQuery("SELECT si FROM StockItem si WHERE si.product="
						+ prod.getId());
		return qu.getResultList();
	}

	@Override
	public List<StockItem> readStockItemForPointOfSale(PointOfSale pos) {
		Query qu = em
				.createQuery("SELECT si FROM StockItem si WHERE si.pos.id="
						+ pos.getId());
		return qu.getResultList();
	}

}
