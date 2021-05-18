package mds.tp.becaalimentaria.gestores;

import java.util.Optional;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.ClasificacionSolicitud;
import mds.tp.becaalimentaria.domain.Solicitud;
import mds.tp.becaalimentaria.gestores.dao.SolicitudDaoImp;
import mds.tp.becaalimentaria.gestores.interfaces.GestorSolicitudInterface;

public class GestorSolicitud implements GestorSolicitudInterface {
	private static GestorSolicitud _INSTANCE;

	public static GestorSolicitud getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorSolicitud();
		}
		return _INSTANCE;
	}

	private GestorSolicitud() {}

	
	private SolicitudDaoImp solicitudRepo= SolicitudDaoImp.getInstance();


	
	private GestorAlumno alumnoService = GestorAlumno.getInstance();

	@Override
	public Optional<Solicitud> guardarSolicitud(Solicitud solicitud) {
		if (solicitud.getAlumnoSolicitante() == null || solicitud.getClasificacionSolicitud() == null) {
			return Optional.empty();
		}
		Solicitud solicitudGuar = solicitudRepo.save(solicitud);
		if (solicitudGuar != null) {
			return Optional.of(solicitudGuar);
		}
		return Optional.empty();
	}


	/*
	 * Metodo que se encarga de clasificar una solicitud. La solicitud debe tener un
	 * grupo familiar asignado.
	 */
	@Override
	public ClasificacionSolicitud clasificarSolicitud(Alumno alumnoSolicitante) {
		Double sumaIngresoNetoFamiliar = alumnoService.getIngresoFamiliarTotal(alumnoSolicitante);
		if (sumaIngresoNetoFamiliar == null) {
			System.out
					.println("[Debug-SolicitudServiceImp-clasificarSolicitud]: la suma del ingreso familiar es nula\n");
			// TODO: deberia notificar a la interfaz
			return null; // TODO: evitar return null
		}
		Double sumaGastoEnfermedad = alumnoService.getGastoEnfermedadCronica(alumnoSolicitante);
		if (sumaGastoEnfermedad == null) {
			System.out.println("[Debug-SolicitudServiceImp-clasificarSolicitud]: la suma del gasto familiar es nula\n");
			// TODO: deberia notificar a la interfaz
			return null; // TODO: evitar return null
		}
		Double diferenciaIngresoGasto = sumaIngresoNetoFamiliar - sumaGastoEnfermedad;
		if (diferenciaIngresoGasto < 0.0) {
			diferenciaIngresoGasto = 0.0;
		}
		Integer cantidadHermanos = alumnoService.getCantidadHermanos(alumnoSolicitante);

		return analizarSolicitud(diferenciaIngresoGasto, cantidadHermanos);
	
	}

	/*
	 * */
	private ClasificacionSolicitud analizarSolicitud(Double diferenciaIngresoGasto, Integer cantidadHermanos) {
		// ------------SOLICITUD RECHAZADA
		// Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) >= $ 60.000
		// Tiene postulante <= 2 Hermanos
		if (diferenciaIngresoGasto >= 60000.0 && cantidadHermanos <= 2) {
			return ClasificacionSolicitud.SolicitudRechazada;
		}
		// ------------- SOLICITUD APROBADA CON MEDIA BECA
		// Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) >= $ 60.000
		// Tiene postulante >= 3 hermanos
		else if (diferenciaIngresoGasto >= 60000.0 && cantidadHermanos >= 3) {
			return ClasificacionSolicitud.MediaBeca;
		}
		// Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) <= $ 60.000
		// Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) >= $ 50.000
		// Tiene postulante <= 2 hermanos
		else if (diferenciaIngresoGasto <= 60000.0 && diferenciaIngresoGasto >= 50000.0 && cantidadHermanos <= 2) {
			return ClasificacionSolicitud.MediaBeca;
		}
		// Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) <= $ 50.000
		// No tiene hermanos.
		else if (diferenciaIngresoGasto <= 50000.0 && cantidadHermanos == 0) {
			return ClasificacionSolicitud.MediaBeca;
		}
		// ------------- SOLICITUD APROBADA CON BECA TOTAL
		// Suma(ingresosFamiliar) - Suma(gastoMensualEnfermedad) <= $ 50.000
		else if (diferenciaIngresoGasto <= 50000.0) {
			return ClasificacionSolicitud.BecaTotal;
		} else {
			return ClasificacionSolicitud.SolicitudEnEstudio;
		}
	}

}
