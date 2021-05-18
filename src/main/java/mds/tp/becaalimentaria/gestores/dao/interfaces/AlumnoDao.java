package mds.tp.becaalimentaria.gestores.dao.interfaces;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.Escuela;

public interface AlumnoDao {

	public Alumno save(Alumno alumno);
	
	public Optional<Alumno> actualizar(Alumno alumno);
	
	public Optional<Alumno> findById(Integer id);
	
	public Optional<Alumno> findByDni(String dni);

	public Optional<Alumno> findByDniYEscuela(String dni, Integer idEscuelaLogeada);
	
}
