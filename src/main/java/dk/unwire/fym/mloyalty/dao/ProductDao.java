package dk.unwire.fym.mloyalty.dao;

import java.util.List;

import dk.unwire.fym.mloyalty.model.Product;

public interface ProductDao {

	public List<Product> getProductsByMerchant(long merchantId);
}
