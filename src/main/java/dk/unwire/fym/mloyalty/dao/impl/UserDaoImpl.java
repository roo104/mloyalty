package dk.unwire.fym.mloyalty.dao.impl;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dk.unwire.fym.mloyalty.dao.UserDao;
import dk.unwire.fym.mloyalty.model.User;

@Stateless
public class UserDaoImpl implements UserDao {

	@PersistenceContext( unitName = "mloyalty")
    private EntityManager entityManager;
	
	// @formatter:off
	private static final String BALANCE_SQL = "select "+
			"  (select"+
			"    ifnull(sum(points), 0) "+
			"  from "+
			"    `user` u "+
			"    join `point` p "+
			"      on u.id = p.user_id "+
			"  where u.id = ?) - "+
			"  (SELECT"+
			"    IFNULL(sum(points), 0) "+
			"  FROM "+
			"    `user` u "+
			"    JOIN redemption r "+
			"      ON u.id = r.user_id "+
			"  where u.id = ?) ";
	// @formatter:on
	
	@Override
	public User getUserById(long userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public long getBalance(long userId) {
		Query query = entityManager.createNativeQuery(BALANCE_SQL);
		query.setParameter(1, userId);
		query.setParameter(2, userId);
		return ((BigDecimal ) query.getSingleResult()).longValue();
	}

	@Override
	public User getUserByIdentifierAndPassword(String identifier,
			String password) {
		Object result = null;
		try {
			Query query = entityManager.createNativeQuery("SELECT * FROM `user` WHERE `identifier` = ? AND `password` = SHA1(?)", User.class);
			query.setParameter(1, identifier);
			query.setParameter(2, password);
			result = query.getSingleResult();
		} catch (NoResultException e) {
			
		}
		return (User) result;
	}

}
