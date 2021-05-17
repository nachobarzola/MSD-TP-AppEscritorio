package mds.tp.becaalimentaria.presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import mds.tp.becaalimentaria.domain.GrupoFamiliar;
import mds.tp.becaalimentaria.domain.Hermano;
import mds.tp.becaalimentaria.gestores.GestorAlumno;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class AltaHermanoJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfApellidos;
	private JTextField tfNombres;
	private JTextField tfEdad;
	private JTextField tfOcupacion;
	private JTextField tfEscuela;
	private JRadioButton btnRadioConviveSi;
	private JRadioButton btnRadioConviveNo;
	private JButton btnAceptar;
	private JButton btnAtras;
	private GrupoFamiliar grupoFamiliarNuevo;
	private AltaGrupoFamiliarJPanel panelAnterior;
	private GestorAlumno alumnoService = GestorAlumno.getInstance();
	private AltaHermanoJFrame altaHermanoJFrame;
	private JLabel lblNewLabel_8;
	Border bordeRojo = BorderFactory.createLineBorder(Color.red);

	
	/**
	 * Create the frame.
	 */
	public AltaHermanoJFrame(AltaGrupoFamiliarJPanel altaGrupoFamiliarJPanel, final GrupoFamiliar grupoFamiliarNuevo) {
		this.panelAnterior = altaGrupoFamiliarJPanel;
		this.grupoFamiliarNuevo = grupoFamiliarNuevo;
		this.altaHermanoJFrame = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 523, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		

		JLabel lblNewLabel = new JLabel("Agregar hermano");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(105, 11, 271, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Datos del hermano:");
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
		
		JLabel lblNewLabel_6 = new JLabel("Escuela:");
		lblNewLabel_6.setBounds(109, 204, 101, 14);
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
		//Valida que la edad sea un número y no tenga mas de dos dígitos
		tfEdad.addKeyListener(new KeyAdapter() { 
			@Override
			public void keyTyped(KeyEvent e){
				int max = 2;
				char caracter = e.getKeyChar();
				if(((caracter < '0') ||
							(caracter > '9')) &&
							(caracter != '\b'))
				{
					e.consume();
				}
				if(tfEdad.getText().length() > max) {
					e.consume();
				}
			}
		});
		
		tfOcupacion = new JTextField();
		tfOcupacion.setBounds(189, 173, 86, 20);
		contentPane.add(tfOcupacion);
		tfOcupacion.setColumns(10);
		
		tfEscuela = new JTextField();
		tfEscuela.setBounds(189, 201, 86, 20);
		contentPane.add(tfEscuela);
		tfEscuela.setColumns(10);
		
		
		lblNewLabel_8 = new JLabel("¿Convive?");
		lblNewLabel_8.setBounds(151, 269, 63, 14);
		contentPane.add(lblNewLabel_8);
		
		btnRadioConviveSi = new JRadioButton("Sí");
		btnRadioConviveSi.setBounds(216, 265, 46, 23);
		contentPane.add(btnRadioConviveSi);
		
		btnRadioConviveNo = new JRadioButton("No");
		btnRadioConviveNo.setBounds(266, 265, 101, 23);
		contentPane.add(btnRadioConviveNo);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(247, 334, 89, 23);
		contentPane.add(btnAceptar);
		
		btnAtras = new JButton("Cancelar");
		btnAtras.setBounds(150, 334, 89, 23);
		this.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaHermanoJFrame.dispose();
			}
		});
		
		
		//para que haga el deseleccionamiento automatico
		btnRadioConviveSi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnRadioConviveNo.setSelected(false);
				
			}
		});
				
		btnRadioConviveNo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnRadioConviveSi.setSelected(false);
				
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean completo = validarCamposVacios();
				
				if(completo) {
					Hermano hermano = new Hermano();
					hermano.setApellido(tfApellidos.getText());
					hermano.setNombre(tfNombres.getText());
					hermano.setEdad(Integer.valueOf(tfEdad.getText()));
					hermano.setOcupacion(tfOcupacion.getText());
					hermano.setEscuela(tfEscuela.getText());
					
					if(btnRadioConviveSi.isSelected()) {
						hermano.setConvive(true);
					}
					if(btnRadioConviveNo.isSelected()) {
						hermano.setConvive(false);
					}
					
					Optional<GrupoFamiliar> optGrupoFamiliarRetur= alumnoService.asignarHermanoGrupoFamiliar(grupoFamiliarNuevo,hermano);
					
					if(optGrupoFamiliarRetur.isPresent()) {
						// guardado correctamente
						 String text = "Hermano guardado correctamente";
						    String title = "Exito";
						    int optionType = JOptionPane.DEFAULT_OPTION;
						    int result = JOptionPane.showConfirmDialog(altaHermanoJFrame, text, title, optionType);
						    if (result == JOptionPane.OK_OPTION) {
						    	altaHermanoJFrame.dispose();
						    	panelAnterior.actualizarTablaHermano(optGrupoFamiliarRetur.get());
						    	
						    }
					}
					else {
						// error
						JOptionPane.showMessageDialog(altaHermanoJFrame, "No se pudo guardar el hermano", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(altaHermanoJFrame, "Debe completar todos los campos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
			}
		});
		
		
		
	}
	
	private boolean validarCamposVacios() {
		boolean estado = true;
		if(tfApellidos.getText().length() == 0) {
			estado = false;
			tfApellidos.setBorder(bordeRojo);
		}
		if(tfNombres.getText().length() == 0) {
			estado = false;
			tfNombres.setBorder(bordeRojo);
		}
		if(tfEdad.getText().length() == 0) {
			estado = false;
			tfEdad.setBorder(bordeRojo);
		}
		if(tfOcupacion.getText().length() == 0) {
			estado = false;
			tfOcupacion.setBorder(bordeRojo);
		}
		if(tfEscuela.getText().length() == 0) {
			estado = false;
			tfEscuela.setBorder(bordeRojo);
		}
		if((btnRadioConviveSi.isSelected() == false) && (btnRadioConviveNo.isSelected() == false) ) {
			lblNewLabel_8.setBorder(bordeRojo);
			estado = false;
			}
		return estado;
		
	}

}
