package mds.tp.becaalimentaria.Gestores;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.Direccion;
import mds.tp.becaalimentaria.domain.Turno;
import mds.tp.becaalimentaria.gestores.GestorAlumno;


public class GestorAlumnoTest {

	private GestorAlumno alumnoService = GestorAlumno.getInstance();
	
	@Test
	public void guardar_alumno_sin_escuela_GrupoFamiliar() {
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		/*Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.getInstance().guardarDireccion(direccion);*/
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Ariel", "Chor", "Chile", "395783489", "Ariel@gmail.com", "+543536458203",
				"2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, null, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		assertTrue(optAlumno.isPresent());
	}

}
