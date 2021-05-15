package mds.tp.becaalimentaria.gestores;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	
	

	@Override
	public Optional<Escuela> guardarEscuela(Escuela escuela) {
		return Optional.of(EscuelaDaoImp.getInstance().save(escuela));
	
	}

	@Override
	public Optional<Escuela> loginEscuela(String codidoUnicoEstablecimiento, String clave) {
		EscuelaDaoImp escuelaRepo = EscuelaDaoImp.getInstance();
		
		Escuela escuela = escuelaRepo.findByCodigoUnicoEstablecimiento(codidoUnicoEstablecimiento);
		// Existe esa escuela
		if (escuela != null) {
			if (escuela.getClave().equals(clave)) {
				return Optional.of(escuela);
			}

		}
		return Optional.empty();
	}
	
	
	
	
}
