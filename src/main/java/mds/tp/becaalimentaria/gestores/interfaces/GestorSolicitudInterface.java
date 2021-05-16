package mds.tp.becaalimentaria.gestores.interfaces;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.BecaAprobada;
import mds.tp.becaalimentaria.domain.ClasificacionSolicitud;
import mds.tp.becaalimentaria.domain.Solicitud;



public interface GestorSolicitudInterface {
	Optional<Solicitud> guardarSolicitud(Solicitud solicitud);
	
	Optional<Solicitud> agregarBecaAprobada(Solicitud solicitud, BecaAprobada becaAprobada);
	
	ClasificacionSolicitud clasificarSolicitud(Alumno alumnoSolicitante);
	
}
