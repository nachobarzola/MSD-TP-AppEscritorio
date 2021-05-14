package mds.tp.becaalimentaria.gestores.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mds.tp.becaalimentaria.domain.EnfermedadCronica;
import mds.tp.becaalimentaria.gestores.dao.interfaces.EnfermedadCronicaDao;

public class EnfermedadCronicaDaoImp implements EnfermedadCronicaDao{
	private static EnfermedadCronicaDaoImp _INSTANCE;

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("base");

	public static EnfermedadCronicaDaoImp getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new EnfermedadCronicaDaoImp();
		}
		return _INSTANCE;
	}

	private EnfermedadCronicaDaoImp() {
	}

	@Override
	public EnfermedadCronica save(EnfermedadCronica enfermedadCronica) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(enfermedadCronica);
			em.flush();
			et.commit();
			em.close();
			return enfermedadCronica;

		} catch (

		Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}

}
