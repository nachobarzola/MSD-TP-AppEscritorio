package mds.tp.becaalimentaria.Gestores;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.ClasificacionSolicitud;
import mds.tp.becaalimentaria.domain.Direccion;
import mds.tp.becaalimentaria.domain.Solicitud;
import mds.tp.becaalimentaria.domain.Turno;
import mds.tp.becaalimentaria.gestores.GestorAlumno;
import mds.tp.becaalimentaria.gestores.GestorEscuela;
import mds.tp.becaalimentaria.gestores.GestorSolicitud;
import mds.tp.becaalimentaria.gestores.dao.SolicitudDaoImp;


public class GestorSolicitudTest {
	
	private GestorAlumno alumnoService = GestorAlumno.getInstance();
	//private GestorEscuela escuelaService = GestorEscuela.getInstance();
	private GestorSolicitud solicitudService = GestorSolicitud.getInstance();
	
	private SolicitudDaoImp solicitudRepo = SolicitudDaoImp.getInstance();


	@Test
	public void guardar_solicitud() {
		// -----------Creamos el alumno

		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Juan", "Perez", "Argentina", "395783489", "Juan@gmail.com", "+543536458203",
				"2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		// --------------Creamos la solicitud
		Calendar fecha2 = Calendar.getInstance();
		fecha2.set(2003, 6, 3);
		Date fechaSolicitud = fecha2.getTime();
		//
		Solicitud solicitud1 = new Solicitud(fechaSolicitud, alumno1, ClasificacionSolicitud.SolicitudEnEstudio);
		// Guardamos la solicitud
		Optional<Solicitud> optSolReturn = solicitudService.guardarSolicitud(solicitud1);
		assertTrue(optSolReturn.isPresent());
		// chequeo persistencia
		Optional<Solicitud> optSolReturn2 = solicitudRepo.findById(optSolReturn.get().getId());
		assertTrue(optSolReturn2.isPresent());
	}


}
