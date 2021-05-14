package mds.tp.becaalimentaria.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class AltaGrupoFamiliar extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaGrupoFamiliar frame = new AltaGrupoFamiliar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AltaGrupoFamiliar() {
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
		lblNewLabel_1.setBounds(150, 145, 167, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos: ");
		lblNewLabel_2.setBounds(108, 182, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombres: ");
		lblNewLabel_3.setBounds(108, 209, 76, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Edad:");
		lblNewLabel_4.setBounds(108, 234, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Ocupación: ");
		lblNewLabel_5.setBounds(108, 259, 65, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Lugar de trabajo:");
		lblNewLabel_6.setBounds(83, 283, 101, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(188, 170, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 198, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 225, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(188, 252, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(188, 280, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Ingresos netos: ");
		lblNewLabel_7.setBounds(93, 308, 91, 14);
		contentPane.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(188, 305, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("¿Convive?");
		lblNewLabel_8.setBounds(158, 348, 63, 14);
		contentPane.add(lblNewLabel_8);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Sí");
		rdbtnNewRadioButton.setBounds(216, 344, 33, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("No");
		rdbtnNewRadioButton_1.setBounds(251, 344, 39, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_9 = new JLabel("Seleccionar alumno: ");
		lblNewLabel_9.setBounds(59, 84, 101, 14);
		contentPane.add(lblNewLabel_9);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(175, 80, 99, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("(+) Agregar progenitor/tutor");
		btnNewButton.setBounds(127, 375, 172, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Aceptar");
		btnNewButton_1.setBounds(175, 511, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("¿Algún miembro del grupo familiar sufre de una enfermedad crónica? ");
		//lblNewLabel_10.setText(¿Algún miembro del grupo familiar sufre de una enfermedad crónica? ));
		lblNewLabel_10.setBounds(108, 455, 285, 20);
		contentPane.add(lblNewLabel_10);
	}
}
