package mds.tp.becaalimentaria.gestores.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mds.tp.becaalimentaria.domain.BecaAprobada;
import mds.tp.becaalimentaria.gestores.dao.interfaces.BecaAprobadaDao;

public class BecaAprobadaDaoImp implements BecaAprobadaDao{
	private static BecaAprobadaDaoImp _INSTANCE;
	
	private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("base");

	public static BecaAprobadaDaoImp getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new BecaAprobadaDaoImp();
		}
		return _INSTANCE;
	}

	private BecaAprobadaDaoImp() {}

	@Override
	public BecaAprobada save(BecaAprobada becaAprobada) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
						
			em.persist(becaAprobada);
			em.flush(); //Actualiza el alumno en memoria
			et.commit();
			return becaAprobada;
			
		}catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
			return null;
		}
		finally {
			em.close();
		}
	}

}
