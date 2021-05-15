package mds.tp.becaalimentaria.gestores.interfaces;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.Direccion;
import mds.tp.becaalimentaria.domain.EnfermedadCronica;
import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.domain.GrupoFamiliar;
import mds.tp.becaalimentaria.domain.Hermano;


public interface GestorAlumnoInterface {

	public Optional<Alumno> guardarAlumno(Alumno alumno);
	
	public Optional<Alumno> borrarAlumno(Alumno alumno);
	
	public Optional<Alumno> actualizarAlumno(Alumno alumno);
	
	public Optional<Alumno> getAlumno(Integer id);
	
	public Optional<Direccion> guardarDireccion(Direccion direccion);
	
	public Optional<GrupoFamiliar> guardarGrupoFamiliar(GrupoFamiliar grupoFamiliar);
	
	public Optional<GrupoFamiliar> asignarHermanoGrupoFamiliar(GrupoFamiliar grupoFamiliar);
		
	public Optional<GrupoFamiliar> asignarEnfermedadCronicaGrupoFamiliar(GrupoFamiliar grupoFamiliar, EnfermedadCronica enfermedadCronica);
	
	public Optional<Alumno> agregarEscuelaAlumno(Escuela escuela, Integer idAlumno);
	
	public Optional<Alumno> agregarGrupoFamiliarAAlumno(GrupoFamiliar grupFamiliar, Integer idAlumno);
	
	public Double getIngresoFamiliarTotal(Alumno alumno);
	
	public Double getGastoEnfermedadCronica(Alumno alumno);
	
	public Integer getCantidadHermanos(Alumno alumno);
}
