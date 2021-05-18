package mds.tp.becaalimentaria.gestores.dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import mds.tp.becaalimentaria.domain.ProgenitorTutor;
import mds.tp.becaalimentaria.gestores.dao.interfaces.ProgenitorTutorDAo;

public class ProgenitorTutorDaoImp implements ProgenitorTutorDAo{
	
	private static ProgenitorTutorDaoImp _INSTANCE;

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("base");

	public static ProgenitorTutorDaoImp getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new ProgenitorTutorDaoImp();
		}
		return _INSTANCE;
	}

	private ProgenitorTutorDaoImp() {
	}


	@Override
	public ProgenitorTutor save(ProgenitorTutor progenitorTutor) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(progenitorTutor);
			em.flush();
			et.commit();
			em.close();
			return progenitorTutor;

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
