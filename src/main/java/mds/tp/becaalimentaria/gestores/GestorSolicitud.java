package mds.tp.becaalimentaria.gestores;

import java.util.Optional;

import mds.tp.becaalimentaria.gestores.interfaces.GestorSolicitudInterface;

public class GestorSolicitud implements GestorSolicitudInterface {
	private static GestorSolicitud _INSTANCE;

	public GestorSolicitud getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorSolicitud();
		}
		return _INSTANCE;
	}

	private GestorSolicitud() {}

	@Autowired
	private SolicitudRepository solicitudRepo;

	@Autowired
	private BecaAprobadaRepository becaAprobadaRepo;

	@Autowired
	private GestorAlumnoInterface alumnoService;

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
	 * Metodo que se encarga de agregarle a una solicitud una becaAprobada, luego
	 * persiste los datos.
	 */
	@Override
	public Optional<Solicitud> agregarBecaAprobada(Solicitud solicitud, BecaAprobada becaAprobada) {
		if (becaAprobadaRepo.save(becaAprobada) != null) {
			solicitud.setBecaAprobada(becaAprobada);
			becaAprobada.setSolicitud(solicitud);
			// Solicitud es dueña de la relacion por lo tanto la guarda
			Solicitud solicitudReturn = solicitudRepo.save(solicitud);
			if (solicitudReturn != null) {
				return Optional.of(solicitudReturn);
			}
		}
		return Optional.empty();
	}

	/*
	 * Metodo que se encarga de clasificar una solicitud. La solicitud debe tener un
	 * grupo familiar asignado.
	 */
	@Override
	public ClasificacionSolicitud clasificarSolicitud(Solicitud solicitud) {
		Double sumaIngresoNetoFamiliar = alumnoService.getIngresoFamiliarTotal(solicitud.getAlumnoSolicitante());
		if (sumaIngresoNetoFamiliar == null) {
			System.out
					.println("[Debug-SolicitudServiceImp-clasificarSolicitud]: la suma del ingreso familiar es nula\n");
			// TODO: deberia notificar a la interfaz
			return null; // TODO: evitar return null
		}
		Double sumaGastoEnfermedad = alumnoService.getGastoEnfermedadCronica(solicitud.getAlumnoSolicitante());
		if (sumaGastoEnfermedad == null) {
			System.out.println("[Debug-SolicitudServiceImp-clasificarSolicitud]: la suma del gasto familiar es nula\n");
			// TODO: deberia notificar a la interfaz
			return null; // TODO: evitar return null
		}
		Double diferenciaIngresoGasto = sumaIngresoNetoFamiliar - sumaGastoEnfermedad;
		if (diferenciaIngresoGasto < 0.0) {
			diferenciaIngresoGasto = 0.0;
		}
		Integer cantidadHermanos = alumnoService.getCantidadHermanos(solicitud.getAlumnoSolicitante());

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
