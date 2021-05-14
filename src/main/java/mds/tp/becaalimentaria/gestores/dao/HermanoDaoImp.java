package mds.tp.becaalimentaria.gestores.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mds.tp.becaalimentaria.domain.Hermano;
import mds.tp.becaalimentaria.gestores.dao.interfaces.HermanoDao;

public class HermanoDaoImp implements HermanoDao{
	private static HermanoDaoImp _INSTANCE;

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("base");

	public static HermanoDaoImp getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new HermanoDaoImp();
		}
		return _INSTANCE;
	}

	private HermanoDaoImp() {
	}
	
	
	
	@Override
	public Hermano save(Hermano hermano) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(hermano);
			em.flush();
			et.commit();
			em.close();
			return hermano;

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
