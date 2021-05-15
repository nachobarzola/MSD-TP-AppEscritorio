package mds.tp.becaalimentaria.gestores.dao;


import java.util.Optional;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.gestores.dao.interfaces.EscuelaDao;

public class EscuelaDaoImp implements EscuelaDao{
private static EscuelaDaoImp _INSTANCE;
	
	private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("base");

	public static EscuelaDaoImp getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new EscuelaDaoImp();
		}
		return _INSTANCE;
	}

	private EscuelaDaoImp() {}

	@Override
	public Escuela save(Escuela escuela) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			
			if(escuela.getId() == null) {
				em.persist(escuela);
				em.flush(); //Actualiza el escuela en memoria
			}
			else {
				em.merge(escuela);
			}
			et.commit();
			return escuela;
			
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
	public Optional<Escuela> findById(Integer idEscuela) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		Escuela escuela = null;
		try {
			et = em.getTransaction();
			et.begin();
			escuela = em.find(Escuela.class, idEscuela);
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return Optional.of(escuela);
	}
	
	@Override
	public Escuela findByCodigoUnicoEstablecimiento(String codigoUnicoEstablecimiento){
		EntityManager em = emf.createEntityManager();
		String query = "SELECT e FROM Escuela e WHERE e.codigoUnicoEstablecimiento = :codUnico";
		TypedQuery<Escuela> escTq = em.createQuery(query,Escuela.class);
		escTq.setParameter("codUnico", codigoUnicoEstablecimiento);
		Escuela esc = null;
		try {
			esc = escTq.getSingleResult();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}

		return esc;
	}
	
	
	
	
	

}
