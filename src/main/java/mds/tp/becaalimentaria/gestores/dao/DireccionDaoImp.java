package mds.tp.becaalimentaria.gestores.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
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

	@Override
	public Optional<Direccion> findById(Integer idDireccion) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		Direccion direccion = null;
		try {
			et = em.getTransaction();
			et.begin();
			direccion = em.find(Direccion.class, idDireccion);
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return Optional.of(direccion);
	}
	
	
}
