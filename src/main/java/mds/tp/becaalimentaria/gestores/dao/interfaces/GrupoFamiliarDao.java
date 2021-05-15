package mds.tp.becaalimentaria.gestores.dao.interfaces;

import java.util.Optional;


import mds.tp.becaalimentaria.domain.GrupoFamiliar;

public interface GrupoFamiliarDao {
	
	public GrupoFamiliar save(GrupoFamiliar grupoFamiliar);

	public Optional<GrupoFamiliar> findById(Integer id);
	
}
