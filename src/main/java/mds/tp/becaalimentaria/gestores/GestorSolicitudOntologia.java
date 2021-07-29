package mds.tp.becaalimentaria.gestores;

import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

import mds.tp.becaalimentaria.dao.ontologia.SolicitudOntologia;
import mds.tp.becaalimentaria.domain.Solicitud;
import mds.tp.becaalimentaria.gestores.interfaces.GestorSolicitudOntologiaInterface;


public class GestorSolicitudOntologia implements GestorSolicitudOntologiaInterface{
	private static GestorSolicitudOntologia _INSTANCE;
	private HTTPRepository repository;
	private SolicitudOntologia solicitudOntologia;
	
	private String PATH_REPOSITORY_ONTOLOGIA ="http://localhost:7200/repositories/tpOntologias";

	public static GestorSolicitudOntologia getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorSolicitudOntologia();
			_INSTANCE.crearConexionOntologia();
		}
		return _INSTANCE;
	}

	private GestorSolicitudOntologia() {}
	
	//Gestores necesarios
	private GestorAlumno alumnoService = GestorAlumno.getInstance();
	

	private void crearConexionOntologia() {
		// Gestion de la conexion
		repository = new HTTPRepository(PATH_REPOSITORY_ONTOLOGIA);
        RepositoryConnection connection = repository.getConnection();
		solicitudOntologia = new SolicitudOntologia(connection);				
	}
	
	@Override
	public void guardarSolicitudEnOntologia(Solicitud solicitud) {
		//Datos requeridos
		Integer cantHermanos = alumnoService.getCantidadHermanos(solicitud.getAlumnoSolicitante());
		Double ingresoFamiliarTotal = alumnoService.getIngresoFamiliarTotal(solicitud.getAlumnoSolicitante());
		//Insertamos la solicitud en la ontologia
		solicitudOntologia.addSolicitud(solicitud,cantHermanos, ingresoFamiliarTotal);
	}

	@Override
	public void showLogSolicitudAllOnto() {
		solicitudOntologia.listarSolicitudes();
	}
	
	
	
	
	
	
}
