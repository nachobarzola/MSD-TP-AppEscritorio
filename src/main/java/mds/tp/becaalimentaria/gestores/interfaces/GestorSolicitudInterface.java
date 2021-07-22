package mds.tp.becaalimentaria.gestores.interfaces;

import java.util.List;
import java.util.Optional;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.ClasificacionSolicitud;
import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.domain.Solicitud;



public interface GestorSolicitudInterface {
	Optional<Solicitud> guardarSolicitud(Solicitud solicitud);
	
	ClasificacionSolicitud clasificarSolicitud(Alumno alumnoSolicitante);
	
	List<Solicitud> getAllSolicitudes(Escuela escuela);
	
}
