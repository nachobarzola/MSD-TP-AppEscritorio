package mds.tp.becaalimentaria.gestores.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.GrupoFamiliar;
import mds.tp.becaalimentaria.gestores.dao.interfaces.GrupoFamiliarDao;

public class GrupoFamiliarDaoImp implements GrupoFamiliarDao{
	private static GrupoFamiliarDaoImp _INSTANCE;

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("base");

	public static GrupoFamiliarDaoImp getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GrupoFamiliarDaoImp();
		}
		return _INSTANCE;
	}

	private GrupoFamiliarDaoImp() {
	}

	@Override
	public GrupoFamiliar save(GrupoFamiliar grupoFamiliar) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(grupoFamiliar);
			em.flush();
			et.commit();
			em.close();
			return grupoFamiliar;

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
	public Optional<GrupoFamiliar> findById(Integer idGrupoFamiliar) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		GrupoFamiliar grupoFamiliar = null;
		try {
			et = em.getTransaction();
			et.begin();
			grupoFamiliar = em.find(GrupoFamiliar.class, idGrupoFamiliar);
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return Optional.of(grupoFamiliar);
	}
	
	
	
	
	
}
