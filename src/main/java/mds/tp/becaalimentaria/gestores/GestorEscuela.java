package mds.tp.becaalimentaria.gestores;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.gestores.dao.EscuelaDaoImp;
import mds.tp.becaalimentaria.gestores.interfaces.GestorEscuelaInterface;



public class GestorEscuela implements GestorEscuelaInterface {
	private static GestorEscuela _INSTANCE;

	public static GestorEscuela getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorEscuela();
		}
		return _INSTANCE;
	}

	private GestorEscuela() {
	}
	
	private EscuelaDaoImp repoEscuela = EscuelaDaoImp.getInstance();
	

	@Override
	public Optional<Escuela> guardarEscuela(Escuela escuela) {
		return Optional.of(EscuelaDaoImp.getInstance().save(escuela));
	
	}
	@Override
	public Optional<Escuela> asignarAlumnoEscuela(Escuela escuela, Alumno alumno){
		escuela.addAlumno(alumno);
		if(this.repoEscuela.save(escuela) == null) {
			return Optional.empty();
		}
		return Optional.of(escuela);
	}

	@Override
	public Optional<Escuela> loginEscuela(String codidoUnicoEstablecimiento, String clave) {
		Escuela escuela = repoEscuela.findByCodigoUnicoEstablecimiento(codidoUnicoEstablecimiento);
		// Existe esa escuela
		if (escuela != null) {
			if (escuela.getClave().equals(clave)) {
				return Optional.of(escuela);
			}

		}
		return Optional.empty();
	}
	
	
	
	
}
