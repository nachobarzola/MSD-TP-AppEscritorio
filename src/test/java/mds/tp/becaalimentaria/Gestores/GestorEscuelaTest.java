package mds.tp.becaalimentaria.Gestores;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;

import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.gestores.GestorEscuela;
import mds.tp.becaalimentaria.gestores.dao.EscuelaDaoImp;

public class GestorEscuelaTest {
	
	/*-------------------Services---------------*/
	private GestorEscuela escuelaService = GestorEscuela.getInstance();
	/*-------------------Repositories---------------*/
	private EscuelaDaoImp escuelaRepo = EscuelaDaoImp.getInstance();
	
	

	@Ignore
	public void guardar_buscar_escuela() {
		//guardo la escuela
		Escuela escuela = new Escuela("Cod2","Clav2","Juan A");
		Optional<Escuela> optEsc = escuelaService.guardarEscuela(escuela);
		assertTrue(optEsc.isPresent());
		//Recupero la escuela
		Optional<Escuela> optEscRecup = escuelaRepo.findById(optEsc.get().getId());
		assertTrue(optEscRecup.isPresent());
		
	}

}
