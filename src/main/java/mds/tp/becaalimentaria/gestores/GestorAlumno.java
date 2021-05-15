package mds.tp.becaalimentaria.gestores;

import java.util.List;
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

public class GestorAlumno implements GestorAlumnoInterface {
	private static GestorAlumno _INSTANCE;

	public static GestorAlumno getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorAlumno();
		}
		return _INSTANCE;
	}

	private GestorAlumno() {
	}

	private GestorEscuela escuelaService = GestorEscuela.getInstance();
	
	private ProgenitorTutorDaoImp progenitorTutorRepo = ProgenitorTutorDaoImp.getInstance();

	private GrupoFamiliarDaoImp grupoFamiliarRepo = GrupoFamiliarDaoImp.getInstance();

	
	// ---------------------------------------------------

	@Override
	public Optional<Alumno> guardarAlumno(Alumno alumno) {
		// Chequeo si tiene asociado una direccion
		if (alumno.getDireccion() != null) {
			Optional<Direccion> optDireccionReturn = this.guardarDireccion(alumno.getDireccion());
			if (optDireccionReturn.isEmpty()) {
				return Optional.empty();
			}
			alumno.setDireccion(optDireccionReturn.get());
		}
		// Chequeo si tiene asociado una escuela
		if (alumno.getEscuela() != null) {
			Optional<Escuela> optEscuelaReturn = escuelaService.guardarEscuela(alumno.getEscuela());
			if (optEscuelaReturn.isEmpty()) {
				return Optional.empty();
			}
			// Asigno el alumno a la escuela y actualizo en la BD la escuela
			if (escuelaService.asignarAlumnoEscuela(optEscuelaReturn.get(), alumno) == null) {
				return Optional.empty();
			}
			alumno.setEscuela(optEscuelaReturn.get());
		}
		Alumno alumnoRetur = AlumnoDaoImp.getInstance().save(alumno);
		return Optional.of(alumnoRetur);
	}

	@Override
	public Optional<Alumno> borrarAlumno(Alumno alumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Alumno> actualizarAlumno(Alumno alumno) {
		return AlumnoDaoImp.getInstance().actualizar(alumno);
	}

	@Override
	public Optional<Alumno> getAlumno(Integer id) {
		return AlumnoDaoImp.getInstance().findById(id);

	}

	@Override
	public Optional<Direccion> guardarDireccion(Direccion direccion) {
		return Optional.of(DireccionDaoImp.getInstance().save(direccion));
	}

	@Override
	public Optional<Alumno> agregarEscuelaAlumno(Escuela escuela, Integer idAlumno) {
		Optional<Alumno> optAlumno = AlumnoDaoImp.getInstance().findById(idAlumno);
		if (optAlumno.isPresent()) {
			Alumno alumno = optAlumno.get();
			alumno.setEscuela(escuela);
			escuela.addAlumno(alumno);
			return AlumnoDaoImp.getInstance().actualizar(alumno);
		}

		return Optional.empty();
	}

	@Override
	public Optional<Alumno> agregarGrupoFamiliarAAlumno(GrupoFamiliar grupFamiliar, Integer idAlumno) {
		Optional<Alumno> optAlumno = AlumnoDaoImp.getInstance().findById(idAlumno);
		if (optAlumno.isPresent()) {
			Alumno alumno = optAlumno.get();
			// Verificamos si el grupo familiar existe
			if (GrupoFamiliarDaoImp.getInstance().findById(grupFamiliar.getId()) != null) {
				alumno.setGrupoFamiliar(grupFamiliar);
				return AlumnoDaoImp.getInstance().actualizar(alumno);
			}
		}
		return Optional.empty();

	}
	/* Metodo que guarda el grupo familiar, para que no falle tiene que contar el grupo familiar
	 * con por lo menos un progenitor
	 * */
	@Override
	public Optional<GrupoFamiliar> guardarGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
		if (GrupoFamiliarDaoImp.getInstance().save(grupoFamiliar) == null) {
			return Optional.empty();
		}
		if (grupoFamiliar.getListaProgenitorTutor().size() == 0) {
			return Optional.empty();
		}
		// Tiene progenitor, Los que guardan la relacion es la clase progenitorTutor
		// Debo guardar relacion por cada progenitorTutor
		for (ProgenitorTutor unProg : grupoFamiliar.getListaProgenitorTutor()) {
			if(ProgenitorTutorDaoImp.getInstance().save(unProg) == null) {
				return Optional.empty();
			}
		}
		return Optional.of(grupoFamiliar);
	}

	@Override
	public Double getIngresoFamiliarTotal(Alumno alumno) {
		Double sumaTotal = 0.0;
		GrupoFamiliar grupoFamiliar = alumno.getGrupoFamiliar();
		if (grupoFamiliar == null) {
			return null; // Error debe tener grupo familiar
		}
		for (ProgenitorTutor unProgenitorTutor : grupoFamiliar.getListaProgenitorTutor()) {
			sumaTotal += unProgenitorTutor.getIngresoNeto();
		}

		return sumaTotal;
	}

	@Override
	public Double getGastoEnfermedadCronica(Alumno alumno) {
		Double sumaGastoEnfermedadCronica = 0.0;
		GrupoFamiliar grupoFamiliar = alumno.getGrupoFamiliar();
		if (grupoFamiliar == null) {
			return null; // Error debe tener grupo familiar
		}
		for (EnfermedadCronica unaEnfermedad : grupoFamiliar.getListaEnfermedadCronica()) {
			sumaGastoEnfermedadCronica += unaEnfermedad.getGastoMensual();
		}
		return sumaGastoEnfermedadCronica;
	}

	@Override
	public Integer getCantidadHermanos(Alumno alumno) {
		if (alumno.getGrupoFamiliar() == null) {
			return null; // Error debe tener grupo familiar
		}
		return alumno.getGrupoFamiliar().getListaHermano().size();
	}

	@Override
	public Optional<GrupoFamiliar> asignarHermanoGrupoFamiliar(GrupoFamiliar grupoFamiliar) {
		if (grupoFamiliar.getListaHermano().size() == 0) {
			return Optional.empty();
		}
		// tiene hermanos, Los que guardan la relacion es la clase hermano.
		// Debo guardar relacion por cada hermano
		for (Hermano unHer : grupoFamiliar.getListaHermano()) {
			if (HermanoDaoImp.getInstance().save(unHer) == null) {
				return Optional.empty();
			}
		}
		return Optional.of(grupoFamiliar);
	}

	@Override
	public Optional<GrupoFamiliar> asignarEnfermedadCronicaGrupoFamiliar(GrupoFamiliar grupoFamiliar,
			EnfermedadCronica enfermedadCronica) {
		if (grupoFamiliar.getListaEnfermedadCronica().size() == 0) {
			return Optional.empty();
		}
		// Tiene EnfermedadCronica, Los que guardan la relacion es la clase
		// EnfermedadCronica
		// Debo guardar relacion por cada EnfermedadCronica
		for (EnfermedadCronica unaEnf : grupoFamiliar.getListaEnfermedadCronica()) {
			if (EnfermedadCronicaDaoImp.getInstance().save(unaEnf) == null) {
				return Optional.empty();
			}
		}
		return Optional.of(grupoFamiliar);
	}

	@Override
	public Optional<GrupoFamiliar> getGrupoFamiliar(Integer idGrupoFamiliar) {
		return grupoFamiliarRepo.findById(idGrupoFamiliar);
	}


}
