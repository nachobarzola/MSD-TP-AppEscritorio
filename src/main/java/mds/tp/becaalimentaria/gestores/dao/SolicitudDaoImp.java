package mds.tp.becaalimentaria.gestores.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import mds.tp.becaalimentaria.domain.Solicitud;
import mds.tp.becaalimentaria.gestores.dao.interfaces.SolicitudDao;

public class SolicitudDaoImp implements SolicitudDao{
	private static SolicitudDaoImp _INSTANCE;
	
	private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("base");

	public static SolicitudDaoImp getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new SolicitudDaoImp();
		}
		return _INSTANCE;
	}
	private SolicitudDaoImp() {}
	
	@Override
	public Solicitud save(Solicitud solicitud) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
						
			em.persist(solicitud);
			em.flush(); //Actualiza el alumno en memoria
			et.commit();
			return solicitud;
			
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
	public Optional<Solicitud> findById(Integer idSolicitud) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		Solicitud solicitud = null;
		try {
			et = em.getTransaction();
			et.begin();
			solicitud = em.find(Solicitud.class, idSolicitud);
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return Optional.of(solicitud);
	}
	

}
