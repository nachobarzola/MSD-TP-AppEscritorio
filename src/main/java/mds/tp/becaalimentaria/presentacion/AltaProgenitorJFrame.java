package mds.tp.becaalimentaria.presentacion;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.hibernate.mapping.PropertyGeneration;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.GrupoFamiliar;
import mds.tp.becaalimentaria.domain.ProgenitorTutor;
import mds.tp.becaalimentaria.gestores.GestorAlumno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Optional;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class AltaProgenitorJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfApellidos;
	private JTextField tfNombres;
	private JTextField tfEdad;
	private JTextField tfOcupacion;
	private JTextField tfLugarDeTrabajo;
	private JTextField tfIngresosNetos;
	private JLabel lblNewLabel_8;
	private JButton btnAtras;
	private JRadioButton btnRadioConviveSi;
	private JRadioButton btnRadioConviveNo;
	Border bordeRojo = BorderFactory.createLineBorder(Color.red);
	private Alumno alumnoEnProgreso;

	private AltaGrupoFamiliarJPanel panelAnterior;
	private AltaProgenitorJFrame altaProgenitorJFrame;

	private GestorAlumno alumnoService = GestorAlumno.getInstance();

	public AltaProgenitorJFrame(AltaGrupoFamiliarJPanel panelAnt, final Alumno alumnoEnProgreso) {
		this.alumnoEnProgreso = alumnoEnProgreso;
		this.altaProgenitorJFrame = this;
		this.panelAnterior = panelAnt;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("AGREGAR GRUPO FAMILIAR A ALUMNO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(105, 11, 271, 44);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Datos del progenitor o tutor:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel_1.setBounds(151, 66, 167, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Apellidos: ");
		lblNewLabel_2.setBounds(109, 103, 76, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nombres: ");
		lblNewLabel_3.setBounds(109, 130, 76, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Edad:");
		lblNewLabel_4.setBounds(109, 155, 46, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Ocupación: ");
		lblNewLabel_5.setBounds(109, 180, 65, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Lugar de trabajo:");
		lblNewLabel_6.setBounds(84, 204, 101, 14);
		contentPane.add(lblNewLabel_6);

		tfApellidos = new JTextField();
		tfApellidos.setBounds(189, 91, 86, 20);
		contentPane.add(tfApellidos);
		tfApellidos.setColumns(10);

		tfNombres = new JTextField();
		tfNombres.setBounds(189, 119, 86, 20);
		contentPane.add(tfNombres);
		tfNombres.setColumns(10);

		tfEdad = new JTextField();
		tfEdad.setBounds(188, 146, 86, 20);
		contentPane.add(tfEdad);
		tfEdad.setColumns(10);

		// Validacion ingreso de solo numeros y hasta 3 digitos
		tfEdad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 1;
				char caracter = e.getKeyChar();

				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
				if (tfEdad.getText().length() > max) {
					e.consume();
				}
			}
		});

		tfOcupacion = new JTextField();
		tfOcupacion.setBounds(189, 173, 86, 20);
		contentPane.add(tfOcupacion);
		tfOcupacion.setColumns(10);

		tfLugarDeTrabajo = new JTextField();
		tfLugarDeTrabajo.setBounds(189, 201, 86, 20);
		contentPane.add(tfLugarDeTrabajo);
		tfLugarDeTrabajo.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Ingresos netos: ");
		lblNewLabel_7.setBounds(94, 229, 91, 14);
		contentPane.add(lblNewLabel_7);

		tfIngresosNetos = new JTextField();
		tfIngresosNetos.setBounds(189, 226, 86, 20);
		contentPane.add(tfIngresosNetos);
		tfIngresosNetos.setColumns(10);

		// Validacion ingreso solo numeros y hasta 6 digitos
		tfIngresosNetos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int max = 5;
				char caracter = e.getKeyChar();

				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
					e.consume();
				}
				if (tfIngresosNetos.getText().length() > max) {
					e.consume();
				}
			}
		});

		lblNewLabel_8 = new JLabel("¿Convive?");
		lblNewLabel_8.setBounds(151, 269, 63, 14);
		contentPane.add(lblNewLabel_8);

		btnRadioConviveSi = new JRadioButton("Sí");
		btnRadioConviveSi.setBounds(207, 265, 59, 23);
		contentPane.add(btnRadioConviveSi);

		btnRadioConviveSi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnRadioConviveNo.setSelected(false);
				;

			}
		});

		btnRadioConviveNo = new JRadioButton("No");
		btnRadioConviveNo.setBounds(268, 265, 50, 23);
		contentPane.add(btnRadioConviveNo);

		btnRadioConviveNo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnRadioConviveSi.setSelected(false);

			}
		});

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(229, 326, 89, 23);
		contentPane.add(btnAceptar);

		btnAtras = new JButton("Cancelar");
		btnAtras.setBounds(120, 326, 89, 23);
		this.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaProgenitorJFrame.dispose();
			}
		});

		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean completo = validarCamposVacios();
				if (completo) {

					ProgenitorTutor progenitorTutor = new ProgenitorTutor();
					progenitorTutor.setApellido(tfApellidos.getText());
					progenitorTutor.setNombre(tfNombres.getText());
					progenitorTutor.setIngresoNeto(Double.valueOf(tfIngresosNetos.getText()));
					progenitorTutor.setEdad(Integer.valueOf(tfEdad.getText()));
					progenitorTutor.setOcupacion(tfOcupacion.getText());
					progenitorTutor.setLugarDeTrabajo(tfLugarDeTrabajo.getText());
					if (btnRadioConviveSi.isSelected()) {
						progenitorTutor.setConvive(true);
					}
					if (btnRadioConviveNo.isSelected()) {
						progenitorTutor.setConvive(false);
					}
					// Cremos el grupo familiar
					GrupoFamiliar grupoFamiliar = new GrupoFamiliar();
					grupoFamiliar.addProgenitorTutor(progenitorTutor);
					progenitorTutor.setGrupoFamiliar(grupoFamiliar);

					Optional<GrupoFamiliar> optGrupoFamiliarRetur = alumnoService.guardarGrupoFamiliar(grupoFamiliar);
					if (optGrupoFamiliarRetur.isPresent()) {
						// guardado correctamente
						String text = "Progenitor guardado correctamente";
						String title = "Exito";
						int optionType = JOptionPane.DEFAULT_OPTION;
						int result = JOptionPane.showConfirmDialog(altaProgenitorJFrame, text, title, optionType);
						if (result == JOptionPane.OK_OPTION) {
							altaProgenitorJFrame.dispose();
							panelAnterior.actualizarTablaProgenitor(grupoFamiliar);

						}
					} else {
						// error
						JOptionPane.showMessageDialog(altaProgenitorJFrame, "No se pudo guardar el progenitor", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					if (alumnoService.agregarGrupoFamiliarAAlumno(optGrupoFamiliarRetur.get(), alumnoEnProgreso.getId()).isEmpty()) {
						JOptionPane.showMessageDialog(altaProgenitorJFrame,
								"No se pudo asociar alumno con su grupo familiar", "Error", JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(altaProgenitorJFrame, "Debe completar todos los campos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

	}

	private boolean validarCamposVacios() {
		boolean estado = true;
		if (tfApellidos.getText().length() == 0) {
			estado = false;
			tfApellidos.setBorder(bordeRojo);
		}
		if (tfNombres.getText().length() == 0) {
			estado = false;
			tfNombres.setBorder(bordeRojo);
		}
		if (tfEdad.getText().length() == 0) {
			estado = false;
			tfEdad.setBorder(bordeRojo);
		}
		if (tfOcupacion.getText().length() == 0) {
			estado = false;
			tfOcupacion.setBorder(bordeRojo);
		}
		if (tfLugarDeTrabajo.getText().length() == 0) {
			estado = false;
			tfLugarDeTrabajo.setBorder(bordeRojo);
		}
		if (tfIngresosNetos.getText().length() == 0) {
			estado = false;
			tfIngresosNetos.setBorder(bordeRojo);
		}
		if ((btnRadioConviveSi.isSelected() == false) && (btnRadioConviveNo.isSelected() == false)) {
			lblNewLabel_8.setBorder(bordeRojo);
			estado = false;
		}
		return estado;

	}
}
