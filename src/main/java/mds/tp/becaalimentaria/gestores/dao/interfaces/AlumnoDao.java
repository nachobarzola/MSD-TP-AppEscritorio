package mds.tp.becaalimentaria.gestores.dao.interfaces;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Alumno;

public interface AlumnoDao {

	public Alumno save(Alumno alumno);
	
	public Optional<Alumno> actualizar(Alumno alumno);
	
	public Optional<Alumno> findById(Integer id);
	
}
