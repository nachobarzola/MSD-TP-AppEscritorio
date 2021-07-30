package mds.tp.becaalimentaria.Gestores;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.SQLInsert;
import org.junit.Ignore;
import org.junit.Test;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.ClasificacionSolicitud;
import mds.tp.becaalimentaria.domain.Direccion;
import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.domain.GrupoFamiliar;
import mds.tp.becaalimentaria.domain.ProgenitorTutor;
import mds.tp.becaalimentaria.domain.Solicitud;
import mds.tp.becaalimentaria.domain.Turno;
import mds.tp.becaalimentaria.gestores.GestorAlumno;
import mds.tp.becaalimentaria.gestores.GestorEscuela;
import mds.tp.becaalimentaria.gestores.GestorSolicitud;
import mds.tp.becaalimentaria.gestores.dao.SolicitudDaoImp;

public class GestorSolicitudTest {

	/*-------------------Services---------------*/
	private GestorAlumno alumnoService = GestorAlumno.getInstance();
	private GestorEscuela escuelaService = GestorEscuela.getInstance();
	private GestorSolicitud solicitudService = GestorSolicitud.getInstance();
	/*-------------------Repositories---------------*/
	private SolicitudDaoImp solicitudRepo = SolicitudDaoImp.getInstance();

	
	@Ignore
	public void guardar_solicitud() {
		//--------------ESCUELA
		Escuela escuela = new Escuela();
		Optional<Escuela> optEscuela = escuelaService.guardarEscuela(escuela);
		assertTrue(optEscuela.isPresent());
		//-------------------------------------------
		
		//------------GRUPO FAMILIAR
		GrupoFamiliar grupFamiliar = new GrupoFamiliar();
		Optional<GrupoFamiliar> optGrupFamiliar = alumnoService.guardarGrupoFamiliar(grupFamiliar);
		assertTrue(optGrupFamiliar.isPresent());
		//-------------------------------------------
		
		//-------------PROGENITOR
		ProgenitorTutor progenitor = new ProgenitorTutor();
		progenitor.setNombre("Eddy");
		progenitor.setApellido("Ficio");
		progenitor.setIngresoNeto(80000.0);
		List<ProgenitorTutor> lisProgenitor = new ArrayList<>();
		grupFamiliar.setListaProgenitorTutor(lisProgenitor);
		//-------------------------------------------------------------
		
		//------------DIRECION ALUMNO
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.guardarDireccion(direccion);
		// -----------ALUMNO
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		Alumno alumno1 = new Alumno("Juan", "Perez", "Argentina", "395783489", "Juan@gmail.com", "+543536458203",
				"2039822669840", fechaNacimiento, "4to", Turno.Tarde, grupFamiliar, direccion, escuela);
		//Guardamos el alumno
		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		assertTrue(optAlumno.isPresent());
		//--------------------------------------
		// --------------SOLICITUD
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
