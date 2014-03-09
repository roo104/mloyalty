package dk.unwire.fym.mloyalty.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dk.unwire.fym.mloyalty.dao.PointDao;
import dk.unwire.fym.mloyalty.model.Point;

@Stateless
public class PointDaoImpl implements PointDao {

	@PersistenceContext(unitName = "mloyalty")
	private EntityManager entityManager;

	@Override
	public List<Point> getByUser(long userId) {
		Query query = this.entityManager.createNativeQuery("SELECT * FROM point WHERE user_id = ?", Point.class);
		query.setParameter(1, userId);
		return query.getResultList();
	}

	@Override
	public void addPoint(Point point) {
		this.entityManager.persist(point);
	}

}
