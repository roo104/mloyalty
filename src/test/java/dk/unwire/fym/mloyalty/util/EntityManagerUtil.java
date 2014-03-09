package dk.unwire.fym.mloyalty.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("mloyalty_test");
	private static EntityManager em = emf.createEntityManager();

	public static EntityManager getEntityManager() {
		return em;
	}
}
