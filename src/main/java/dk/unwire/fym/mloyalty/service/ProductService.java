package dk.unwire.fym.mloyalty.service;

import java.util.List;

import dk.unwire.fym.mloyalty.model.Product;

public interface ProductService {

	public List<Product> getProductsByMerchant(long merchantId);
}
