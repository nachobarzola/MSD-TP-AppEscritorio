package mds.tp.becaalimentaria.gestores.dao.interfaces;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Alumno;

public interface AlumnoDao {

	public Optional<Alumno> save(Alumno alumno);
	
}
