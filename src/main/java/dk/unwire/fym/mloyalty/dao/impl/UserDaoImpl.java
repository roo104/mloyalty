package dk.unwire.fym.mloyalty.dao.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dk.unwire.fym.mloyalty.dao.UserDao;
import dk.unwire.fym.mloyalty.model.User;

@Stateless
public class UserDaoImpl implements UserDao {

	@PersistenceContext( unitName = "mloyalty")
    private EntityManager entityManager;
	
	@Override
	public User getUserById(long userId) {
		return entityManager.find(User.class, userId);
	}

}
