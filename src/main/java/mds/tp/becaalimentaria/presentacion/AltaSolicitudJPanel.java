package mds.tp.becaalimentaria.presentacion;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.gestores.GestorAlumno;

import java.awt.event.ActionListener;
import java.util.Optional;
import java.awt.event.ActionEvent;

public class AltaSolicitudJPanel extends JPanel {

	private JFrame frmAltaSolicitud;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblEstadoSolic;
	private JTextField tfBusqueda;
	private JLabel lblNombreValor;
	private JLabel lblApellidoValor;
	private JLabel lblDniValor;
	private JLabel lblTituloBusqueda;
	private JLabel lblTituloDatos;
	private JButton btnConsultar;
	private JButton btnCrearSolicitud;
	private JButton btnAtras;
	private MenuJFrame menuJFrame;
	private GestorAlumno alumnoService = GestorAlumno.getInstance();

	public AltaSolicitudJPanel(MenuJFrame menuJFrame) {
		this.menuJFrame = menuJFrame;

		// ----- LABEL ----//

		setLayout(null);
		lblTituloBusqueda = new JLabel("Ingrese el número de documento del alumno");
		lblTituloBusqueda.setBounds(310, 25, 250, 20);
		add(lblTituloBusqueda);

		lblTituloDatos = new JLabel("Datos del alumno");
		lblTituloDatos.setBounds(370, 100, 250, 20);
		lblTituloDatos.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblTituloDatos);

		lblDni = new JLabel("Documento");
		lblDni.setBounds(330, 150, 100, 20);
		lblDni.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblDni);

		lblDniValor = new JLabel("38445779 BD"); // traer de la BD
		lblDniValor.setBounds(410, 150, 200, 20);
		lblDniValor.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblDniValor);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(330, 190, 100, 20);
		lblNombre.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblNombre);

		lblNombreValor = new JLabel("Juancito Ariel BD"); // traer de la BD
		lblNombreValor.setBounds(410, 190, 200, 20);
		lblNombreValor.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblNombreValor);

		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(330, 230, 100, 20);
		lblApellido.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblApellido);

		lblApellidoValor = new JLabel("Gómez BD"); // traer de la BD
		lblApellidoValor.setBounds(410, 230, 200, 20);
		lblApellidoValor.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblApellidoValor);

		lblEstadoSolic = new JLabel("Solicitud Aprobada BD"); // traer de la BD
		lblEstadoSolic.setBounds(370, 330, 200, 20);
		lblEstadoSolic.setVisible(true); // habilitar si se encuentra el alumno en la BD

		add(lblEstadoSolic);

		// ---- TEXTFIELD ----//

		tfBusqueda = new JTextField();
		tfBusqueda.setBounds(350, 60, 150, 20);
		add(tfBusqueda);

		// ----- BUTTON ------//

		btnConsultar = new JButton("Consultar estado");
		btnConsultar.setBounds(350, 280, 150, 20);
		btnConsultar.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(btnConsultar);

		btnCrearSolicitud = new JButton("Crear solicitud");
		btnCrearSolicitud.setBounds(430, 370, 100, 20);
		btnCrearSolicitud.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(btnCrearSolicitud);

		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(310, 370, 100, 20);
		add(btnAtras);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Optional<Alumno> optAlumnoObtenido = alumnoService.findByDni(tfBusqueda.getText());
				actualizarInterfaz(optAlumnoObtenido.get());
			}
		});
		btnBuscar.setBounds(510, 59, 89, 23);
		add(btnBuscar);
		
		

	}
	
	private void actualizarInterfaz(Alumno alumnoObtenido) {
		lblNombreValor.setText(alumnoObtenido.getNombre());
		lblApellidoValor.setText(alumnoObtenido.getApellido());
		lblDniValor.setText(alumnoObtenido.getDni());
		
	}

}
