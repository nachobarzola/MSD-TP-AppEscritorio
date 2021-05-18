package mds.tp.becaalimentaria.presentacion;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.ClasificacionSolicitud;
import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.domain.Solicitud;
import mds.tp.becaalimentaria.gestores.GestorAlumno;
import mds.tp.becaalimentaria.gestores.GestorSolicitud;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Optional;
import java.awt.Color;
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
	private GestorSolicitud solicitudService = GestorSolicitud.getInstance();
	private Alumno alumnoObtenido;
	private Escuela escuelaLogeada;
	private ClasificacionSolicitud clasificacionSolicitud;
	Border bordeRojo = BorderFactory.createLineBorder(Color.red);
	public AltaSolicitudJPanel(final MenuJFrame menuJFrame, Escuela escuela) {
		this.menuJFrame = menuJFrame;
		this.escuelaLogeada = escuela;
		// ----- LABEL ----//

		setLayout(null);
		lblTituloBusqueda = new JLabel("Ingrese el número de documento del alumno");
		lblTituloBusqueda.setBounds(249, 89, 300, 20);
		add(lblTituloBusqueda);

		lblTituloDatos = new JLabel("Datos del alumno");
		lblTituloDatos.setBounds(309, 164, 250, 20);
		lblTituloDatos.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblTituloDatos);

		lblDni = new JLabel("Documento");
		lblDni.setBounds(269, 214, 100, 20);
		lblDni.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblDni);

		lblDniValor = new JLabel(""); // traer de la BD
		lblDniValor.setBounds(349, 214, 200, 20);
		lblDniValor.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblDniValor);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(269, 254, 100, 20);
		lblNombre.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblNombre);

		lblNombreValor = new JLabel(""); // traer de la BD
		lblNombreValor.setBounds(349, 254, 200, 20);
		lblNombreValor.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblNombreValor);

		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(269, 294, 100, 20);
		lblApellido.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblApellido);

		lblApellidoValor = new JLabel(""); // traer de la BD
		lblApellidoValor.setBounds(349, 294, 200, 20);
		lblApellidoValor.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(lblApellidoValor);

		lblEstadoSolic = new JLabel("Solicitud:"); // traer de la BD
		lblEstadoSolic.setBounds(309, 394, 200, 20);
		lblEstadoSolic.setVisible(true); // habilitar si se encuentra el alumno en la BD

		add(lblEstadoSolic);

		// ---- TEXTFIELD ----//

		tfBusqueda = new JTextField();
		tfBusqueda.setBounds(289, 124, 150, 20);
		add(tfBusqueda);
		//Validacion ingreso de solo numeros y hasta 8 digitos
		tfBusqueda.addKeyListener(new KeyAdapter() { 
			@Override
			public void keyTyped(KeyEvent e){
				int max = 7;
				char caracter = e.getKeyChar();
				if(((caracter < '0') ||
						(caracter > '9')) &&
						(caracter != '\b'))
				{
					e.consume();
				}
				if(tfBusqueda.getText().length() > max) {
					e.consume();
				}
			}
		});

		// ----- BUTTON ------//

		btnConsultar = new JButton("Consultar estado");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				clasificacionSolicitud = solicitudService.clasificarSolicitud(alumnoObtenido);
				lblEstadoSolic.setText("Solicitud: "+String.valueOf(clasificacionSolicitud));
				btnCrearSolicitud.setEnabled(true);
			}
		});
		btnConsultar.setBounds(289, 344, 150, 20);
		btnConsultar.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(btnConsultar);

		btnCrearSolicitud = new JButton("Crear solicitud");
		btnCrearSolicitud.setEnabled(false);
		btnCrearSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date fechaActual = new Date(System.currentTimeMillis());
				Solicitud solicitudNueva = new Solicitud();
				solicitudNueva.setFecha(fechaActual);
				solicitudNueva.setAlumnoSolicitante(alumnoObtenido);
				solicitudNueva.setClasificacionSolicitud(clasificacionSolicitud);
				if((solicitudService.guardarSolicitud(solicitudNueva)).isPresent()) {
					
					
					String text = "La solicitud se creó satisfactoriamente";
				    String title = "Exito";
				    int optionType = JOptionPane.DEFAULT_OPTION;
				    int result = JOptionPane.showConfirmDialog(menuJFrame, text, title, optionType);
				    if (result == JOptionPane.OK_OPTION) {
				       menuJFrame.cambiarVentanaMenu(1);
				    }
					
				} else {
					JOptionPane.showMessageDialog(frmAltaSolicitud, "No se pudo crear la solicitud", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btnCrearSolicitud.setBounds(369, 434, 140, 20);
		btnCrearSolicitud.setVisible(true); // habilitar si se encuentra el alumno en la BD
		add(btnCrearSolicitud);

		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(249, 434, 100, 20);
		add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaSolicitudJPanel.this.menuJFrame.cambiarVentanaMenu(1);
			}
		});
		

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Optional<Alumno> optAlumnoObtenido = alumnoService.findByDniYEscuela(tfBusqueda.getText(),escuelaLogeada.getId());
				if(optAlumnoObtenido.isPresent()) {
					alumnoObtenido = optAlumnoObtenido.get();
					actualizarInterfaz(optAlumnoObtenido.get());
					btnConsultar.setEnabled(true);
				}
				else {
					JOptionPane.showMessageDialog(frmAltaSolicitud, "El alumno no se encuentra registrado", "Error",
							JOptionPane.ERROR_MESSAGE);
					btnConsultar.setEnabled(false);
					btnCrearSolicitud.setEnabled(false);

				}
				
				
			}
		});
		btnBuscar.setBounds(449, 123, 89, 23);
		add(btnBuscar);
		btnConsultar.setEnabled(false);

	}

	private void actualizarInterfaz(Alumno alumnoObtenido) {
		lblNombreValor.setText(alumnoObtenido.getNombre());
		lblApellidoValor.setText(alumnoObtenido.getApellido());
		lblDniValor.setText(alumnoObtenido.getDni());

	}

}
