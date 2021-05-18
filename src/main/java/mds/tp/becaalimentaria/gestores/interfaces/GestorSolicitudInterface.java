package mds.tp.becaalimentaria.gestores.interfaces;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.ClasificacionSolicitud;
import mds.tp.becaalimentaria.domain.Solicitud;



public interface GestorSolicitudInterface {
	Optional<Solicitud> guardarSolicitud(Solicitud solicitud);
	
	ClasificacionSolicitud clasificarSolicitud(Alumno alumnoSolicitante);
	
}
