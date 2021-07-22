package mds.tp.becaalimentaria.gestores.dao.interfaces;

import java.util.List;
import java.util.Optional;

import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.domain.Solicitud;

public interface SolicitudDao {
	public Solicitud save(Solicitud solicitud);
	
	public Optional<Solicitud> findById(Integer idSolicitud);
	
	public List<Solicitud> findByAllSolicitud(Escuela escuela);

}
