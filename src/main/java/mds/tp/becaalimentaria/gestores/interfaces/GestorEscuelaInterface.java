package mds.tp.becaalimentaria.gestores.interfaces;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Escuela;


public interface GestorEscuelaInterface {
	public Optional<Escuela> guardarEscuela(Escuela escuela);
	
	public Optional<Escuela> loginEscuela(String codidoUnicoEstablecimiento, String clave);
}
