package mds.tp.becaalimentaria.gestores.dao.interfaces;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Escuela;

public interface EscuelaDao {
	
	public Escuela save(Escuela escuela);
	
	public Optional<Escuela> findById(Integer idEscuela);
	
	public Escuela findByCodigoUnicoEstablecimiento(String CcdigoUnicoEstablecimiento);

}
