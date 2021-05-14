package mds.tp.becaalimentaria.gestores.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mds.tp.becaalimentaria.domain.Direccion;
import mds.tp.becaalimentaria.gestores.dao.interfaces.DireccionDao;

public class DireccionDaoImp implements DireccionDao{
	private static DireccionDaoImp _INSTANCE;
	
	private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("base");

	public static DireccionDaoImp getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new DireccionDaoImp();
		}
		return _INSTANCE;
	}

	private DireccionDaoImp() {}
	
	@Override
	public Direccion save(Direccion direccion) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
						
			em.persist(direccion);
			em.flush(); //Actualiza el alumno en memoria
			et.commit();
			return direccion;
			
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
