package mds.tp.becaalimentaria.gestores;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.gestores.dao.EscuelaDaoImp;
import mds.tp.becaalimentaria.gestores.interfaces.GestorEscuelaInterface;



public class GestorEscuela implements GestorEscuelaInterface {
	private static GestorEscuela _INSTANCE;

	public GestorEscuela getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorEscuela();
		}
		return _INSTANCE;
	}

	private GestorEscuela() {
	}
	
	
	private EscuelaDaoImp repoEscuela;

	@Override
	public Optional<Escuela> guardarEscuela(Escuela escuela) {
		return Optional.of(repoEscuela.save(escuela));
	}

	@Override
	public Optional<Escuela> loginEscuela(String codidoUnicoEstablecimiento, String clave) {
		System.out.println("ENTRO COMO LOCO");
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
