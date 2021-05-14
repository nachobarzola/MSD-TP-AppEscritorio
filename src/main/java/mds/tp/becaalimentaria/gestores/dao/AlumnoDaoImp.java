package mds.tp.becaalimentaria.gestores.dao;



import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.gestores.dao.interfaces.AlumnoDao;

public class AlumnoDaoImp implements AlumnoDao{
	private static AlumnoDaoImp _INSTANCE;
	
	private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("base");

	public static AlumnoDaoImp getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new AlumnoDaoImp();
		}
		return _INSTANCE;
	}

	private AlumnoDaoImp() {}
	
	
	public Optional<Alumno> save(Alumno alumno) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
						
			em.persist(alumno);
			em.flush(); //Actualiza el contexto
			et.commit();
			return Optional.of(alumno);
			
		}catch (Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
			return Optional.empty();
		}
		finally {
			em.close();
		}
	}
	
	
}
