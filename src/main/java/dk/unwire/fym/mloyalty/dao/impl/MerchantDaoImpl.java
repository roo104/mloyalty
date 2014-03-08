package dk.unwire.fym.mloyalty.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dk.unwire.fym.mloyalty.dao.MerchantDao;
import dk.unwire.fym.mloyalty.model.Merchant;

@Stateless
public class MerchantDaoImpl implements MerchantDao {

	@PersistenceContext( unitName = "mloyalty")
    private EntityManager entityManager;
	
	@Override
	public Merchant getMerchantByUsernameAndPassword(String username,
			String password) {
		Query query = entityManager.createNativeQuery("SELECT * FROM merchant WHERE username = ? AND password = SHA1(?)", Merchant.class);
		query.setParameter(1, username);
		query.setParameter(2, password);
		return (Merchant) query.getSingleResult();
	}

}
