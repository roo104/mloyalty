package dk.unwire.fym.mloyalty.service.impl;

import java.util.List;

import javax.inject.Inject;

import dk.unwire.fym.mloyalty.dao.ProductDao;
import dk.unwire.fym.mloyalty.model.Product;
import dk.unwire.fym.mloyalty.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductDao productDao;
	
	@Override
	public List<Product> getProductsByMerchant(long merchantId) {
		return productDao.getProductsByMerchant(merchantId);
	}

	@Override
	public Product getProduct(long productId) {
		return productDao.getProduct(productId);
	}

}
