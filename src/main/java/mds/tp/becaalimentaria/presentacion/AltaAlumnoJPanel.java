package mds.tp.becaalimentaria.presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
	private JTextField tfDomicilio;
	private JTextField tfCodigoPostal;
	private JButton btnAgregarAlumno;
	private JButton btnAtras;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JTextField tfLocalidad;
	private JTextField tfEmail;
	private JTextField tfTelefono;
	private JComboBox comboTurno;
	final JDateChooser fechaNac;
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
		lblNewLabel.setBounds(103, 83, 76, 14);
		this.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombres: ");
		lblNewLabel_1.setBounds(103, 110, 76, 14);
		this.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Nacionalidad: ");
		lblNewLabel_2.setBounds(103, 135, 91, 14);
		this.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("DNI: ");
		lblNewLabel_3.setBounds(103, 173, 76, 14);
		this.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("CUIL: ");
		lblNewLabel_4.setBounds(103, 198, 76, 14);
		this.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Grado/Año");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(104, 223, 64, 20);
		this.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Turno: ");
		lblNewLabel_6.setBounds(103, 277, 76, 14);
		this.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Fecha");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_7.setBounds(103, 302, 40, 14);
		this.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Domicilio: ");
		lblNewLabel_8.setBounds(103, 336, 76, 14);
		this.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Código postal: ");
		lblNewLabel_9.setBounds(103, 362, 86, 14);
		this.add(lblNewLabel_9);

		tfApellido = new JTextField();
		tfApellido.setBounds(199, 80, 115, 20);
		this.add(tfApellido);
		tfApellido.setColumns(10);

		tfNombre = new JTextField();
		tfNombre.setBounds(199, 104, 115, 20);
		this.add(tfNombre);
		tfNombre.setColumns(10);

		tfNacionalidad = new JTextField();
		tfNacionalidad.setBounds(199, 132, 115, 20);
		this.add(tfNacionalidad);
		tfNacionalidad.setColumns(10);

		tfDNI = new JTextField();
		tfDNI.setBounds(199, 170, 115, 20);
		this.add(tfDNI);
		tfDNI.setColumns(10);
		//Validacion ingreso de solo numeros y hasta 8 digitos
		tfDNI.addKeyListener(new KeyAdapter() { 
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
				if(tfDNI.getText().length() > max) {
					e.consume();
				}
			}
		});

		tfCUIT = new JTextField();
		tfCUIT.setBounds(199, 198, 115, 20);
		this.add(tfCUIT);
		tfCUIT.setColumns(10);

		tfGrado = new JTextField();
		tfGrado.setBounds(201, 229, 113, 20);
		this.add(tfGrado);
		tfGrado.setColumns(10);
		
		fechaNac =  new JDateChooser();
		fechaNac.setBounds(199, 302, 115, 20);
		this.add(fechaNac);

		tfDomicilio = new JTextField();
		tfDomicilio.setBounds(199, 327, 115, 20);
		this.add(tfDomicilio);
		tfDomicilio.setColumns(10);

		tfCodigoPostal = new JTextField();
		tfCodigoPostal.setBounds(199, 356, 115, 20);
		this.add(tfCodigoPostal);
		tfCodigoPostal.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Sala/Sección");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_10.setBounds(103, 239, 77, 14);
		this.add(lblNewLabel_10);

		btnAgregarAlumno = new JButton("Agregar alumno");
		btnAgregarAlumno.setBounds(341, 489, 158, 23);
		this.add(btnAgregarAlumno);

		lblNewLabel_11 = new JLabel("AGREGAR ALUMNO");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(239, 21, 184, 33);
		this.add(lblNewLabel_11);

		lblNewLabel_12 = new JLabel("de nac.");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_12.setBounds(103, 311, 46, 14);
		this.add(lblNewLabel_12);

		comboTurno = new JComboBox();
		comboTurno.setBounds(199, 269, 115, 22);
		comboTurno.addItem("Mañana");
		comboTurno.addItem("Tarde");
		comboTurno.addItem("Noche");
		add(comboTurno);

		JLabel lblNewLabel_9_1 = new JLabel("Localidad:");
		lblNewLabel_9_1.setBounds(103, 401, 76, 14);
		add(lblNewLabel_9_1);

		tfLocalidad = new JTextField();
		tfLocalidad.setColumns(10);
		tfLocalidad.setBounds(199, 395, 115, 20);
		add(tfLocalidad);

		JLabel lblNewLabel_9_1_1 = new JLabel("Email:");
		lblNewLabel_9_1_1.setBounds(356, 86, 76, 14);
		add(lblNewLabel_9_1_1);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(441, 83, 115, 20);
		add(tfEmail);

		JLabel lblNewLabel_9_1_1_1 = new JLabel("Telefono:");
		lblNewLabel_9_1_1_1.setBounds(356, 116, 76, 14);
		add(lblNewLabel_9_1_1_1);

		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		tfTelefono.setBounds(441, 113, 115, 20);
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
						alumno.setFechaDeNacimiento(fechaNac.getDate());
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
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(214, 489, 100, 23);
		this.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaAlumnoJPanel.this.menuJFrame.cambiarVentanaMenu(2);
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
		if(fechaNac.getDate() == null) {
			estado = false;
			fechaNac.setBorder(bordeRojo);
		}
		
		
		return estado;
	}

}
