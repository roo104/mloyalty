package dk.unwire.fym.mloyalty.dao.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dk.unwire.fym.mloyalty.dao.PointDao;
import dk.unwire.fym.mloyalty.model.Point;

@Stateless
public class PointDaoImpl implements PointDao {

	@PersistenceContext( unitName = "mloyalty")
    private EntityManager entityManager;
	
	@Override
	public List<Point> getByUser(long userId) {
		Query query = entityManager.createNativeQuery("SELECT * FROM point WHERE user_id = ?", Point.class);
		query.setParameter(1, userId);
		return (List<Point>) query.getResultList();
	}
	
	@Override
	public long getBalance(long userId) {
		Query query = entityManager.createNativeQuery("SELECT sum(points) FROM point WHERE user_id = ?");
		query.setParameter(1, userId);
		return ((BigDecimal) query.getSingleResult()).longValue();
	}

	@Override
	public void addPoints(Point point) {
		entityManager.persist(point);
	}
	
}
