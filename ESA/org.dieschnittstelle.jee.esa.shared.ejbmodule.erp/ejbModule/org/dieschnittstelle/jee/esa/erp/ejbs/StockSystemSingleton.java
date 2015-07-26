package org.dieschnittstelle.jee.esa.erp.ejbs;

import static org.dieschnittstelle.jee.esa.shared.lib.Util.show;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import org.dieschnittstelle.jee.esa.erp.ejbs.crud.PointOfSaleCRUDLocal;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.StockItemCRUDLocal;
import org.dieschnittstelle.jee.esa.erp.entities.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.erp.entities.PointOfSale;
import org.dieschnittstelle.jee.esa.erp.entities.StockItem;
import org.jboss.logging.Logger;

@Singleton
public class StockSystemSingleton implements StockSystemRemote {

	protected static Logger logger = Logger
			.getLogger(StockSystemSingleton.class);

	@EJB
	private StockItemCRUDLocal stockItemCRUD;

	@EJB
	private PointOfSaleCRUDLocal posCRUD;

	@Override
	public void addToStock(IndividualisedProductItem product,
			int pointOfSaleId, int units) {
		show("#addToStock: " + product + "," + pointOfSaleId + "," + units);

		PointOfSale pos = posCRUD.readPointOfSale(pointOfSaleId);
		StockItem item = new StockItem(product, pos, units);
		stockItemCRUD.createStockItem(item);
	}

	@Override
	public void removeFromStock(IndividualisedProductItem product,
			int pointOfSaleId, int units) {
		show("#removeFromStock: " + product + "," + pointOfSaleId + "," + units);

		PointOfSale pos = posCRUD.readPointOfSale(pointOfSaleId);
		StockItem item = stockItemCRUD.readStockItem(product, pos);
		final int newUnits = item.getUnits() - units;
		if (newUnits < 0) {
			show("if (newUnits < 0) return");
			return;
		}
		item.setUnits(newUnits);
		stockItemCRUD.updateStockItem(item);
	}

	@Override
	public List<IndividualisedProductItem> getProductsOnStock(int pointOfSaleId) {
		show("#getProductsOnStock: " + pointOfSaleId);
		PointOfSale pos = posCRUD.readPointOfSale(pointOfSaleId);

		List<StockItem> items = stockItemCRUD.readStockItemForPointOfSale(pos);
		List<IndividualisedProductItem> products = new ArrayList<IndividualisedProductItem>();
		for (StockItem item : items) {
			products.add(item.getProduct());
		}
		return products;
	}

	@Override
	public List<IndividualisedProductItem> getAllProductsOnStock() {
		show("#getAllProductsOnStock: ");

		List<PointOfSale> posList = posCRUD.readAllPointsOfSale();

		List<IndividualisedProductItem> allProductsOnStock = new ArrayList<IndividualisedProductItem>();

		for (PointOfSale pos : posList) {
			List<StockItem> items = stockItemCRUD
					.readStockItemForPointOfSale(pos);
			for (StockItem item : items) {
				allProductsOnStock.add(item.getProduct());
			}
		}
		return allProductsOnStock;
	}

	@Override
	public int getUnitsOnStock(IndividualisedProductItem product,
			int pointOfSaleId) {
		show("#getUnitsOnStock: " + product + "," + pointOfSaleId);

		PointOfSale pos = posCRUD.readPointOfSale(pointOfSaleId);
		StockItem item = stockItemCRUD.readStockItem(product, pos);
		return item.getUnits();
	}

	@Override
	public int getTotalUnitsOnStock(IndividualisedProductItem product) {
		show("#getTotalUnitsOnStock: " + product);
		int total = 0;
		List<StockItem> items = stockItemCRUD.readStockItemsForProduct(product);
		for (StockItem item : items) {
			if (item != null) {
				total += item.getUnits();
			}
		}
		return total;
	}

	@Override
	public List<Integer> getPointsOfSale(IndividualisedProductItem product) {
		show("#getPointsOfSale: " + product);
		List<Integer> allPos = new ArrayList<Integer>();

		List<PointOfSale> posList = posCRUD.readAllPointsOfSale();

		for (PointOfSale pos : posList) {
			List<StockItem> stockItems = stockItemCRUD
					.readStockItemForPointOfSale(pos);

			for (StockItem item : stockItems) {
				if (item.getProduct().equals(product)) {
					allPos.add(item.getPos().getId());
				}
			}
		}
		return allPos;
	}
}
