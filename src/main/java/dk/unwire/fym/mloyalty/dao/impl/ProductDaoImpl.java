package dk.unwire.fym.mloyalty.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dk.unwire.fym.mloyalty.dao.ProductDao;
import dk.unwire.fym.mloyalty.model.Product;

public class ProductDaoImpl implements ProductDao {
	
	@PersistenceContext(unitName = "mloyalty")
	private EntityManager entityManager;

	@Override
	public List<Product> getProductsByMerchant(long merchantId) {
		Query query = this.entityManager.createNativeQuery("SELECT * FROM product WHERE merchant_id = ?", Product.class);
		query.setParameter(1, merchantId);
		return query.getResultList();
	}

	@Override
	public Product getProduct(long productId) {
		Object result = null;
		try {
			Query query = this.entityManager.createNativeQuery("SELECT * FROM product WHERE id = ?", Product.class);
			query.setParameter(1, productId);
			result = query.getSingleResult();
		} catch (NoResultException e) {
			
		}
		
		return (Product) result;
	}
}
