package mds.tp.becaalimentaria.gestores.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import mds.tp.becaalimentaria.domain.Escuela;
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
	@Override
	public List<Solicitud> findByAllSolicitud(Escuela escuela) {
		EntityManager em = emf.createEntityManager();
		//String query = "SELECT s FROM Solicitud s WHERE s.alumnoSolicitante=:alum";
		String query = "SELECT s FROM Solicitud s "
				+ "INNER JOIN Alumno a ON s.alumnoSolicitante=a "
				+ "WHERE a.escuela=:esc";
		TypedQuery<Solicitud> tq = em.createQuery(query, Solicitud.class);
		tq.setParameter("esc", escuela);
		List<Solicitud> listaSolic = null;
		try {
			listaSolic = tq.getResultList();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		ArrayList<Solicitud> listaSolic2 = new ArrayList<Solicitud>();
		listaSolic2.addAll(listaSolic);
		return listaSolic2;
	}
	

}
