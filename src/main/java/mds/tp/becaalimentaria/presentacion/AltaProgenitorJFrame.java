package mds.tp.becaalimentaria.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AltaProgenitorJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfApellidos;
	private JTextField tfNombres;
	private JTextField tfEdad;
	private JTextField tfOcupacion;
	private JTextField tfLugarDeTrabajo;
	private JTextField tfIngresosNetos;

	
	public AltaProgenitorJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNewLabel_8 = new JLabel("¿Convive?");
		lblNewLabel_8.setBounds(159, 269, 63, 14);
		contentPane.add(lblNewLabel_8);
		
		JRadioButton btnRadioConviveSi = new JRadioButton("Sí");
		btnRadioConviveSi.setBounds(217, 265, 33, 23);
		contentPane.add(btnRadioConviveSi);
		
		JRadioButton btnRadioConviveNo = new JRadioButton("No");
		btnRadioConviveNo.setBounds(252, 265, 39, 23);
		contentPane.add(btnRadioConviveNo);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(229, 326, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(123, 326, 89, 23);
		contentPane.add(btnAtras);
	}
}
