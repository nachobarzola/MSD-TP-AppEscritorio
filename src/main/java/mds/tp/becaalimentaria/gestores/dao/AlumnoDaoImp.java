package mds.tp.becaalimentaria.gestores.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.gestores.dao.interfaces.AlumnoDao;

public class AlumnoDaoImp implements AlumnoDao {
	private static AlumnoDaoImp _INSTANCE;

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("base");

	public static AlumnoDaoImp getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new AlumnoDaoImp();
		}
		return _INSTANCE;
	}

	private AlumnoDaoImp() {
	}

	/*
	 * Permite guardar un alumno en la DB
	 */
	@Override
	public Alumno save(Alumno alumno) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.persist(alumno);
			em.flush();
			et.commit();
			em.close();
			return alumno;

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
	public Optional<Alumno> actualizar(Alumno alumno) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			em.merge(alumno);
			et.commit();
			em.close();
			return Optional.of(alumno);

		} catch (

		Exception ex) {
			if (et != null) {
				et.rollback();
			}
			ex.printStackTrace();
			return Optional.empty();
		} finally {
			em.close();
		}
	}

	@Override
	public Optional<Alumno> findById(Integer idAlumno) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = null;
		Alumno alumno = null;
		try {
			et = em.getTransaction();
			et.begin();
			alumno = em.find(Alumno.class, idAlumno);
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}
		return Optional.of(alumno);
	}
	
	
	public List<Alumno> getAlumnosEscuelaCombo(String idEscuela) {
		EntityManager em = emf.createEntityManager();
		String query = "SELECT a FROM Alumno a WHERE a.id_escuela = :idEscuela";
		TypedQuery<Alumno> aluTq = em.createQuery(query,Alumno.class);
		aluTq.setParameter("idEscuela", idEscuela);
		List<Alumno> alu = null;
		try {
			alu = aluTq.getResultList();
		} catch (NoResultException ex) {
			ex.printStackTrace();
		} finally {
			em.close();
		}

		return alu;
	}


}
