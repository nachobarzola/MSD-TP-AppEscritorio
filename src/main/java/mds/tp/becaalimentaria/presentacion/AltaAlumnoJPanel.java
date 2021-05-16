package mds.tp.becaalimentaria.presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.Direccion;
import mds.tp.becaalimentaria.domain.Turno;
import mds.tp.becaalimentaria.gestores.GestorAlumno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class AltaAlumnoJPanel extends JPanel {

	private JTextField tfApellido;
	private JTextField tfNombre;
	private JTextField tfNacionalidad;
	private JTextField tfDNI;
	private JTextField tfCUIT;
	private JTextField tfGrado;
	private JTextField tfFecha;
	private JTextField tfDomicilio;
	private JTextField tfCodigoPostal;
	private JButton btnAgregarAlumno;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JTextField tfLocalidad;
	private JTextField tfEmail;
	private JTextField tfTelefono;
	private JComboBox comboTurno;

	private MenuJFrame menuJFrame;
	
	//Border compound;
	Border bordeRojo = BorderFactory.createLineBorder(Color.red);


	private GestorAlumno alumnoService = GestorAlumno.getInstance();

	public AltaAlumnoJPanel(MenuJFrame frame) {
		this.menuJFrame = frame;
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 300, 677, 602);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		// setContentPane(contentPane);
		this.setLayout(null);

		JLabel lblNewLabel = new JLabel("Apellidos: ");
		lblNewLabel.setBounds(57, 73, 76, 14);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombres: ");
		lblNewLabel_1.setBounds(57, 100, 76, 14);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nacionalidad: ");
		lblNewLabel_2.setBounds(57, 125, 76, 14);
		this.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("DNI: ");
		lblNewLabel_3.setBounds(57, 163, 76, 14);
		this.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("CUIL: ");
		lblNewLabel_4.setBounds(57, 188, 76, 14);
		this.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Grado/Año");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(58, 213, 64, 20);
		this.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Turno: ");
		lblNewLabel_6.setBounds(57, 267, 76, 14);
		this.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Fecha");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_7.setBounds(57, 292, 40, 14);
		this.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Domicilio: ");
		lblNewLabel_8.setBounds(57, 326, 76, 14);
		this.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Código postal: ");
		lblNewLabel_9.setBounds(57, 352, 76, 14);
		this.add(lblNewLabel_9);

		tfApellido = new JTextField();
		tfApellido.setBounds(153, 70, 86, 20);
		this.add(tfApellido);
		tfApellido.setColumns(10);

		tfNombre = new JTextField();
		tfNombre.setBounds(153, 94, 86, 20);
		this.add(tfNombre);
		tfNombre.setColumns(10);

		tfNacionalidad = new JTextField();
		tfNacionalidad.setBounds(153, 122, 86, 20);
		this.add(tfNacionalidad);
		tfNacionalidad.setColumns(10);

		tfDNI = new JTextField();
		tfDNI.setBounds(153, 160, 86, 20);
		this.add(tfDNI);
		tfDNI.setColumns(10);

		tfCUIT = new JTextField();
		tfCUIT.setBounds(153, 188, 86, 20);
		this.add(tfCUIT);
		tfCUIT.setColumns(10);

		tfGrado = new JTextField();
		tfGrado.setBounds(155, 219, 86, 20);
		this.add(tfGrado);
		tfGrado.setColumns(10);

		tfFecha = new JTextField();
		tfFecha.setBounds(153, 289, 86, 20);
		this.add(tfFecha);
		tfFecha.setColumns(10);

		tfDomicilio = new JTextField();
		tfDomicilio.setBounds(153, 317, 86, 20);
		this.add(tfDomicilio);
		tfDomicilio.setColumns(10);

		tfCodigoPostal = new JTextField();
		tfCodigoPostal.setBounds(153, 346, 86, 20);
		this.add(tfCodigoPostal);
		tfCodigoPostal.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Sala/Sección");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_10.setBounds(57, 229, 77, 14);
		this.add(lblNewLabel_10);

		btnAgregarAlumno = new JButton("Agregar alumno");
		btnAgregarAlumno.setBounds(167, 442, 158, 23);
		this.add(btnAgregarAlumno);

		lblNewLabel_11 = new JLabel("AGREGAR ALUMNO");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(131, 11, 184, 33);
		this.add(lblNewLabel_11);

		lblNewLabel_12 = new JLabel("de nac.");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_12.setBounds(57, 301, 46, 14);
		this.add(lblNewLabel_12);

		comboTurno = new JComboBox();
		comboTurno.setBounds(153, 259, 86, 22);
		comboTurno.addItem("Mañana");
		comboTurno.addItem("Tarde");
		comboTurno.addItem("Noche");
		add(comboTurno);

		JLabel lblNewLabel_9_1 = new JLabel("Localidad:");
		lblNewLabel_9_1.setBounds(57, 391, 76, 14);
		add(lblNewLabel_9_1);

		tfLocalidad = new JTextField();
		tfLocalidad.setColumns(10);
		tfLocalidad.setBounds(153, 385, 86, 20);
		add(tfLocalidad);

		JLabel lblNewLabel_9_1_1 = new JLabel("Email:");
		lblNewLabel_9_1_1.setBounds(268, 73, 76, 14);
		add(lblNewLabel_9_1_1);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(353, 70, 86, 20);
		add(tfEmail);

		JLabel lblNewLabel_9_1_1_1 = new JLabel("Telefono:");
		lblNewLabel_9_1_1_1.setBounds(268, 103, 76, 14);
		add(lblNewLabel_9_1_1_1);

		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(353, 100, 86, 20);
		add(tfTelefono);

		// TODO: metodo temporal, borrar luego
		cargarDatosInterfaceGrafica();

		btnAgregarAlumno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean estado = validarCamposVacios();
				
				if(estado) { //Si todos los campos estan completos
					
					if(alumnoService.comprobarExistencia(tfDNI.getText()) == false) { //Si no existe el alumno en la BD
						Alumno alumno = new Alumno();
						alumno.setApellido(tfApellido.getText());
						alumno.setNombre(tfNombre.getText());
						alumno.setNacionalidad(tfNacionalidad.getText());
						alumno.setDni(tfDNI.getText());
						alumno.setCuit(tfCUIT.getText());
						alumno.setGrado(tfGrado.getText());
						String turnoSelec = comboTurno.getSelectedItem().toString();
						if (turnoSelec.equals("Mañana")) {
							alumno.setTurno(Turno.Manana);
						} else if (turnoSelec.equals("Tarde")) {
							alumno.setTurno(Turno.Tarde);
						} else if (turnoSelec.equals("Noche")) {
							alumno.setTurno(Turno.Noche);
						}
						alumno.setFechaDeNacimiento(null);
						Direccion direccion = new Direccion();
						direccion.setDomicilio(tfDomicilio.getText());
						direccion.setCodigoPostal(tfCodigoPostal.getText());
						direccion.setLocalidad(tfLocalidad.getText());
						alumno.setDireccion(direccion);
						alumno.setEmail(tfEmail.getText());
						alumno.setTelefono(tfTelefono.getText());

						alumno.setEscuela(menuJFrame.getEscuelaLogeada());

						Optional<Alumno> optAlumnoReturn = alumnoService.guardarAlumno(alumno);
						if (optAlumnoReturn.isPresent()) {
							// guardado correctamente
							 String text = "Alumno guardado correctamente";
							    String title = "Exito";
							    int optionType = JOptionPane.DEFAULT_OPTION;
							    int result = JOptionPane.showConfirmDialog(menuJFrame, text, title, optionType);
							    if (result == JOptionPane.OK_OPTION) {
							       menuJFrame.cambiarVentanaMenu(4);
							    }
							
						} else {
							// error
							JOptionPane.showMessageDialog(menuJFrame, "No se pudo guardar el alumno", "Error",
									JOptionPane.ERROR_MESSAGE);

						}
					}
					else { //Si existe el alumno en la BD
						JOptionPane.showMessageDialog(menuJFrame, "El alumno con DNI: "+ tfDNI.getText()+" ya existe en el sistema", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
				else {
					JOptionPane.showMessageDialog(menuJFrame, "Debe completar todos los campos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				

			}

		});

	}

	private void cargarDatosInterfaceGrafica() {
		tfApellido.setText("Juhano");
		tfNombre.setText("Pepe");
		tfNacionalidad.setText("Uruguay");
		tfDNI.setText("39578398");
		tfCUIT.setText("20395783980");
		tfGrado.setText("5to");
		tfDomicilio.setText("Santa Fe 555");
		tfCodigoPostal.setText("3029");
		tfLocalidad.setText("Santa Fe Capital");
		tfEmail.setText("Juahano@gmail.com");
		tfTelefono.setText("+5433684569896");
	}
	
	private boolean validarCamposVacios() {
		boolean estado = true;
		if(tfApellido.getText().length() == 0) {
			estado = false;
			tfApellido.setBorder(bordeRojo);
		}
		if(tfNombre.getText().length() == 0) {
			estado = false;
			tfNombre.setBorder(bordeRojo);
		}
		if(tfNacionalidad.getText().length() == 0) {
			estado = false;
			tfNacionalidad.setBorder(bordeRojo);
		}
		if(tfDNI.getText().length() == 0) {
			estado = false;
			tfDNI.setBorder(bordeRojo);
		}
		if(tfCUIT.getText().length() == 0) {
			estado = false;
			tfCUIT.setBorder(bordeRojo);
		}
		if(tfGrado.getText().length() == 0) {
			estado = false;
			tfGrado.setBorder(bordeRojo);
		}
		if(tfDomicilio.getText().length() == 0) {
			estado = false;
			tfDomicilio.setBorder(bordeRojo);
		}
		if(tfCodigoPostal.getText().length() == 0) {
			estado = false;
			tfCodigoPostal.setBorder(bordeRojo);
		}
		if(tfLocalidad.getText().length() == 0) {
			estado = false;
			tfLocalidad.setBorder(bordeRojo);
		}
		if(tfEmail.getText().length() == 0) {
			estado = false;
			tfEmail.setBorder(bordeRojo);
		}
		if(tfTelefono.getText().length() == 0) {
			estado = false;
			tfTelefono.setBorder(bordeRojo);
		}
		
		
		
		return estado;
	}

}
