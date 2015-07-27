package org.dieschnittstelle.jee.esa.erp.ejbs.crud;

import java.util.List;

import javax.ejb.Local;

import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.entities.PointOfSale;
import org.dieschnittstelle.jee.esa.erp.entities.StockItem;

@Local
public interface StockItemCRUDLocal {
	
	public StockItem createStockItem(StockItem item);
	
	public StockItem readStockItem(AbstractProduct prod, PointOfSale pos);

	public StockItem updateStockItem(StockItem item);
	
	public List<StockItem> readStockItemsForProduct(AbstractProduct prod);
	
	public List<StockItem> readStockItemForPointOfSale(PointOfSale pos);
	
	public List<StockItem> getAllStockItems();
	
	public void setPriceForStockItem(AbstractProduct prod, PointOfSale pos, int price);
	
}
