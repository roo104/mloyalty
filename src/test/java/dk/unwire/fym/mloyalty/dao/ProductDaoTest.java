package dk.unwire.fym.mloyalty.dao;

import javax.persistence.EntityManager;

import org.junit.Before;

import dk.unwire.fym.mloyalty.dao.impl.ProductDaoImpl;
import dk.unwire.fym.mloyalty.util.EntityManagerUtil;

public class ProductDaoTest {

	private ProductDaoImpl classUnderTest;

	private EntityManager entityManager;

	@Before
	public void setUp() {
		entityManager = EntityManagerUtil.getEntityManager();
	}

	public void getProduct() {

	}
}
