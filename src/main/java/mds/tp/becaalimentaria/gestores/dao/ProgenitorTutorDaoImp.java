package mds.tp.becaalimentaria.gestores.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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

	@Override
	public List<ProgenitorTutor> findByProgenitorTutor(Integer idGrupoFamiliar) {
		EntityManager em = emf.createEntityManager();
		//String query = "SELECT p FROM ProgenitorTutor p WHERE p.ID_GRUPOFAMILIAR = :idgrupofamiliar";
		String query = "SELECT p FROM ProgenitorTutor p INNER JOIN GrupoFamiliar g ON p.id_grupofamiliar=g.id_grupofamiliar"
				+ " WHERE p.id_grupofamiliar=:idGrupoFamiliar";
		TypedQuery<ProgenitorTutor> tq = em.createQuery(query, ProgenitorTutor.class);
		
		tq.setParameter("idgrupofamiliar", idGrupoFamiliar);
		
		List<ProgenitorTutor> listaProgenitorTutor = null;
		try {
			listaProgenitorTutor = tq.getResultList();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		System.out.println("La lista es "+listaProgenitorTutor.get(0).toString());
		return listaProgenitorTutor;
	}

}
