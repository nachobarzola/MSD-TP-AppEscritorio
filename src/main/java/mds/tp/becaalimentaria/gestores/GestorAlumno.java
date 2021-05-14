package mds.tp.becaalimentaria.gestores;


import java.util.Optional;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.Direccion;
import mds.tp.becaalimentaria.domain.EnfermedadCronica;
import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.domain.GrupoFamiliar;
import mds.tp.becaalimentaria.domain.Hermano;
import mds.tp.becaalimentaria.domain.ProgenitorTutor;
import mds.tp.becaalimentaria.gestores.dao.AlumnoDaoImp;
import mds.tp.becaalimentaria.gestores.dao.DireccionDaoImp;
import mds.tp.becaalimentaria.gestores.dao.EnfermedadCronicaDaoImp;
import mds.tp.becaalimentaria.gestores.dao.GrupoFamiliarDaoImp;
import mds.tp.becaalimentaria.gestores.dao.HermanoDaoImp;
import mds.tp.becaalimentaria.gestores.dao.ProgenitorTutorDaoImp;
import mds.tp.becaalimentaria.gestores.interfaces.GestorAlumnoInterface;


public class GestorAlumno implements GestorAlumnoInterface{
	private static GestorAlumno _INSTANCE;
	
	public GestorAlumno getInstance() {
		if(_INSTANCE == null) {
			_INSTANCE = new GestorAlumno();
		}
		return _INSTANCE;
	}
	
	
	private GestorAlumno() {}
	
	
	//----------------Repositorios - Acceso a datos.

	private AlumnoDaoImp alumnoRepo;
	
	
	private DireccionDaoImp direccionRepo;
	
	
	private GrupoFamiliarDaoImp grupoFamiliarRepo;
	
	
	private HermanoDaoImp hermanoRepo;
	
	
	private ProgenitorTutorDaoImp progenitorTutorRepo;
	
	
	private EnfermedadCronicaDaoImp enfermedadCronicaRepo;
	//---------------------------------------------------
	
	@Override
	public Optional<Alumno> guardarAlumno(Alumno alumno) {
		Alumno alumnoRetur = alumnoRepo.save(alumno);
		return Optional.of(alumnoRetur);
	}

	@Override
	public Optional<Alumno> borrarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Alumno> actualizarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Alumno> getAlumno(Integer id) {
		return alumnoRepo.findById(id);
		
	}

	@Override
	public Optional<Direccion> guardarDireccion(Direccion direccion) {
		return Optional.of(direccionRepo.save(direccion));
	}

	@Override
	public Optional<Alumno> agregarEscuelaAlumno(Escuela escuela, Integer idAlumno) {
		Optional<Alumno> optAlumno = alumnoRepo.findById(idAlumno);
		if(optAlumno.isPresent()) {
			Alumno alumno = optAlumno.get();
			alumno.setEscuela(escuela);
			escuela.addAlumno(alumno);
			return Optional.of(alumnoRepo.save(alumno));
		}
		
		return Optional.empty();
	}

	@Override
	public Optional<Alumno> agregarGrupoFamiliarAAlumno(GrupoFamiliar grupFamiliar, Integer idAlumno) {
		Optional<Alumno> optAlumno = alumnoRepo.findById(idAlumno);
		if(optAlumno.isPresent()) {
			Alumno alumno = optAlumno.get();
			//Verificamos si el grupo familiar existe
			if(grupoFamiliarRepo.findById(grupFamiliar.getId()) != null) {
				alumno.setGrupoFamiliar(grupFamiliar);
				return Optional.of(alumnoRepo.save(alumno));
			}
		}
		return Optional.empty();
	}

	@Override
	public Optional<GrupoFamiliar> guardarGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
		if(grupoFamiliarRepo.save(grupoFamiliar) != null) {
			if(grupoFamiliar.getListaHermano().size() > 0) {
				//tiene hermanos, Los que guardan la relacion es la clase hermano
				//Debo guardar relacion por cada hermano
				for(Hermano unHer: grupoFamiliar.getListaHermano()) {
					hermanoRepo.save(unHer);
				}
			}
			if(grupoFamiliar.getListaProgenitorTutor().size() > 0) {
				//Tiene progenitor, Los que guardan la relacion es la clase progenitorTutor
				//Debo guardar relacion por cada progenitorTutor
				for(ProgenitorTutor unProg: grupoFamiliar.getListaProgenitorTutor()) {
					progenitorTutorRepo.save(unProg);
				}
			}
			if(grupoFamiliar.getListaEnfermedadCronica().size() > 0) {
				//Tiene EnfermedadCronica, Los que guardan la relacion es la clase EnfermedadCronica
				//Debo guardar relacion por cada EnfermedadCronica
				for(EnfermedadCronica unaEnf: grupoFamiliar.getListaEnfermedadCronica()) {
					enfermedadCronicaRepo.save(unaEnf);
				}
			}
			return Optional.of(grupoFamiliar);
		}
		
		return Optional.empty();
	}

	@Override
	public Double getIngresoFamiliarTotal(Alumno alumno) {
		Double sumaTotal = 0.0;
		GrupoFamiliar grupoFamiliar = alumno.getGrupoFamiliar();
		if(grupoFamiliar == null) {
			return null; //Error debe tener grupo familiar
		}
		for(ProgenitorTutor unProgenitorTutor: grupoFamiliar.getListaProgenitorTutor()) {
			sumaTotal += unProgenitorTutor.getIngresoNeto();
		}

		return sumaTotal;
	}

	@Override
	public Double getGastoEnfermedadCronica(Alumno alumno) {
		Double sumaGastoEnfermedadCronica = 0.0;
		GrupoFamiliar grupoFamiliar = alumno.getGrupoFamiliar();
		if(grupoFamiliar == null) {
			return null; //Error debe tener grupo familiar
		}
		for(EnfermedadCronica unaEnfermedad: grupoFamiliar.getListaEnfermedadCronica()) {
			sumaGastoEnfermedadCronica += unaEnfermedad.getGastoMensual(); 
		}
		return sumaGastoEnfermedadCronica;
	}

	@Override
	public Integer getCantidadHermanos(Alumno alumno) {
		if(alumno.getGrupoFamiliar() == null) {
			return null; //Error debe tener grupo familiar
		}
		return alumno.getGrupoFamiliar().getListaHermano().size();
	}

}
