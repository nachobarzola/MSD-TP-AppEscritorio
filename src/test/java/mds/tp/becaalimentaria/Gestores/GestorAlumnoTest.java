package mds.tp.becaalimentaria.Gestores;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.Direccion;
import mds.tp.becaalimentaria.domain.EnfermedadCronica;
import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.domain.GrupoFamiliar;
import mds.tp.becaalimentaria.domain.Hermano;
import mds.tp.becaalimentaria.domain.ProgenitorTutor;
import mds.tp.becaalimentaria.domain.Turno;
import mds.tp.becaalimentaria.gestores.GestorAlumno;
import mds.tp.becaalimentaria.gestores.GestorEscuela;
import mds.tp.becaalimentaria.gestores.dao.AlumnoDaoImp;
import mds.tp.becaalimentaria.gestores.dao.DireccionDaoImp;

public class GestorAlumnoTest {

	/*-------------------Services---------------*/
	private GestorAlumno alumnoService = GestorAlumno.getInstance();
	private GestorEscuela escuelaService = GestorEscuela.getInstance();
	/*-------------------Repositories-------------*/
	private DireccionDaoImp direccionRepo = DireccionDaoImp.getInstance();
	private AlumnoDaoImp alumnoRepo = AlumnoDaoImp.getInstance();
	

	@Test
	public void guardar_direccion() {
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		Optional<Direccion> optDireccion = alumnoService.guardarDireccion(direccion);
		assertTrue(optDireccion.isPresent());
		// Chequeamos persitencia en el repositorio
		Optional<Direccion> optDireccionBuscada = direccionRepo.findById(optDireccion.get().getId());
		assertTrue(optDireccionBuscada.isPresent());
	}

	@Test
	public void actualizar_alumno() {
		/*-------------------------------Cosas previas*/
		// --------------ESCUELA
		Escuela escuela = new Escuela();
		// -------------ALUMNO
		//FECHA DE NACIMIENTO
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		//DIRECION ALUMNO
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		//Creamos alumno
		Alumno alumno = new Alumno("Ariel", "Cela", "Chile", "395783489", 
				"Ariel@gmail.com", "+543536458203", "2039822669840", fechaNacimiento, 
				"4to", Turno.Tarde, null, direccion, escuela);
		//Guardamos alumno
		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno);
		assertTrue(optAlumno.isPresent());
		alumno = optAlumno.get();
		
		/*-------------------------------Ahora si la prueba*/
		// Cambio algo del alumno
		alumno.setApellido("Cambiado");
		
		Optional<Alumno> optAlumno2 = alumnoService.actualizarAlumno(alumno);
		//verificamos retorno
		assertTrue(optAlumno2.isPresent());
		assertEquals("Cambiado", optAlumno2.get().getApellido().toString());
		//Chequeamos en el repo
		Optional<Alumno> optAlumnoBuscado = alumnoRepo.findById(optAlumno2.get().getId());
		assertTrue(optAlumnoBuscado.isPresent());
		assertEquals("Cambiado", optAlumnoBuscado.get().getApellido().toString());
		
		;

	}

	@Ignore
	public void guardar_alumno_sin_escuela_GrupoFamiliar() {
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Ariel", "Chor", "Chile", "395783489", "Ariel@gmail.com", "+543536458203",
				"2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		assertTrue(optAlumno.isPresent());
	}

	@Ignore
	public void guardar_alumno_con_escuela_sin_GrupoFamiliar() {
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.guardarDireccion(direccion);
		// Creo escuela
		Escuela escuela = new Escuela("JFHSKVMSE", "siempreViva", "Juan A");
		escuelaService.guardarEscuela(escuela);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Ariel", "Chor", "Chile", "395783489", "Ariel@gmail.com", "+543536458203",
				"2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, escuela);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		assertTrue(optAlumno.isPresent());
	}

	@Ignore
	public void buscar_alumno() {
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Hernandez 896", "Parana", "3100");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Ariel", "Blanco", "Argentina", "395783489", "Ariel@gmail.com", "+543536458203",
				"2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		// Ahora lo busco
		Optional<Alumno> optAlumnoRec = alumnoService.getAlumno(optAlumno.get().getId());
		assertTrue(optAlumnoRec.isPresent());
	}

	@Ignore
	public void agregar_alumnoAEscuela() {
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Ariel", "ChorVoyalEscuela", "Chile", "395783489", "Ariel@gmail.com",
				"+543536458203", "2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		// Creo escuela

		Escuela escuela = new Escuela("JFHSKVMSE", "siempreViva", "Juan A");
		escuelaService.guardarEscuela(escuela);

		Optional<Alumno> optAlumnoActualizado = alumnoService.agregarEscuelaAlumno(escuela, optAlumno.get().getId());
		assertTrue(optAlumnoActualizado.isPresent());
		assertNotNull(optAlumnoActualizado.get().getEscuela());

	}

	@Ignore
	public void agregar_grupoFamiliarAAlumno() {
		// Fecha de nacimiento
		Calendar fecha1 = Calendar.getInstance();
		fecha1.set(2003, 6, 3);
		Date fechaNacimiento = fecha1.getTime();
		// Direccion
		Direccion direccion = new Direccion("Ramirez 896", "Lucas Gonzalez", "3158");
		alumnoService.guardarDireccion(direccion);
		// ----Creamos alumno
		Alumno alumno1 = new Alumno("Camila", "Palermo", "Argentina", "395783489", "CamilaPale@gmail.com",
				"+543536458203", "2039822669840", fechaNacimiento, "4to", Turno.Tarde, null, direccion, null);

		Optional<Alumno> optAlumno = alumnoService.guardarAlumno(alumno1);
		// ------------------------Creo grupo familiar
		GrupoFamiliar grupoFamiliar = new GrupoFamiliar();
		// Progenitor
		ProgenitorTutor progenitor = new ProgenitorTutor("Don Juan", "Palermo", 100000.00, 55, "Pule pisos", "Oficina",
				true, grupoFamiliar);
		grupoFamiliar.addProgenitorTutor(progenitor);
		// Hermanos
		Hermano h1 = new Hermano(25, "Pule picaportes", "", true, grupoFamiliar, "juan", "sanche");
		Hermano h2 = new Hermano(20, "Pule picaportes", "", true, grupoFamiliar, "juan", "reyes");
		Hermano h3 = new Hermano(14, "", "Escuela sin nombre", true, grupoFamiliar, "juan", "riquelme");
		grupoFamiliar.addHermano(h1);
		grupoFamiliar.addHermano(h2);
		grupoFamiliar.addHermano(h3);
		// EnfermedadCronica
		EnfermedadCronica enfermedadCronica1 = new EnfermedadCronica("Hipertension", 5000.00, grupoFamiliar);
		grupoFamiliar.addEnfermedadCronica(enfermedadCronica1);
		// Guardamos el grupo familiar
		alumnoService.guardarGrupoFamiliar(grupoFamiliar);
		// ---------------------------------------------------------
		// Agregamos el grupo familiar al alumno
		Optional<Alumno> optAlumnoActualizado = alumnoService.agregarGrupoFamiliarAAlumno(grupoFamiliar,
				optAlumno.get().getId());
		assertTrue(optAlumnoActualizado.isPresent());
		assertNotNull(optAlumnoActualizado.get().getGrupoFamiliar());

	}

}
