package mds.tp.becaalimentaria.gestores.dao.interfaces;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Direccion;

public interface DireccionDao {
	
	public Direccion save(Direccion direccion);
	
	public Optional<Direccion> findById(Integer idDireccion);

}
