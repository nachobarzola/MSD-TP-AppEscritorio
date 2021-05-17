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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import mds.tp.becaalimentaria.domain.EnfermedadCronica;
import mds.tp.becaalimentaria.domain.GrupoFamiliar;
import mds.tp.becaalimentaria.domain.Hermano;
import mds.tp.becaalimentaria.gestores.GestorAlumno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class AltaEnfermedadCronicaJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfDiagnostico;
	private JTextField tfGastoMensual;
	private JButton btnAceptar;
	private JButton btnAtras;
	private GrupoFamiliar grupoFamiliarNuevo;
	private AltaGrupoFamiliarJPanel panelAnterior;
	private AltaEnfermedadCronicaJFrame altaEnfermedadCronicaJFrame;
	private GestorAlumno alumnoService = GestorAlumno.getInstance();
	Border bordeRojo = BorderFactory.createLineBorder(Color.red);

	/**
	 * Create the frame.
	 */
	public AltaEnfermedadCronicaJFrame(AltaGrupoFamiliarJPanel altaGrupoFamiliarJPanel, final GrupoFamiliar grupoFamiliarNuevo) {
		this.panelAnterior = altaGrupoFamiliarJPanel;
		this.grupoFamiliarNuevo = grupoFamiliarNuevo;
		this.altaEnfermedadCronicaJFrame = this;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregar enfermedad crónica");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(105, 11, 271, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Diagnóstico: ");
		lblNewLabel_2.setBounds(105, 106, 91, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gasto mensual: ");
		lblNewLabel_3.setBounds(105, 131, 91, 14);
		contentPane.add(lblNewLabel_3);
		
		tfDiagnostico = new JTextField();
		tfDiagnostico.setBounds(199, 100, 86, 20);
		contentPane.add(tfDiagnostico);
		tfDiagnostico.setColumns(10);
		
		tfGastoMensual = new JTextField();
		tfGastoMensual.setBounds(199, 127, 86, 20);
		contentPane.add(tfGastoMensual);
		tfGastoMensual.setColumns(10);
		
		//Valida que el gasto mensual sea un numero y tenga como maximo 6 dígitos
		tfGastoMensual.addKeyListener(new KeyAdapter() { 
			@Override
			   public void keyTyped(KeyEvent e)
			   {
					int max = 5;
					char caracter = e.getKeyChar();

					if(((caracter < '0') ||
							(caracter > '9')) &&
							(caracter != '\b'))
					{
						e.consume();
					}
					if(tfGastoMensual.getText().length() > max) {
						e.consume();
					}
			   }
		});
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(196, 207, 89, 23);
		contentPane.add(btnAceptar);
		
		btnAtras = new JButton("Cancelar");
		btnAtras.setBounds(100, 207, 89, 23);
		this.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaEnfermedadCronicaJFrame.dispose();
			}
		});

		
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EnfermedadCronica enfermedadCronica= new EnfermedadCronica();
				enfermedadCronica.setDiagnostico(tfDiagnostico.getText());
				enfermedadCronica.setGastoMensual(Double.valueOf(tfGastoMensual.getText()));
				
				Optional<GrupoFamiliar> optGrupoFamiliarRetur = alumnoService.asignarEnfermedadCronicaGrupoFamiliar(grupoFamiliarNuevo, enfermedadCronica);
				
				if(optGrupoFamiliarRetur.isPresent()) {
					// guardado correctamente
					 String text = "Enfermedad cronica guardada correctamente";
					    String title = "Exito";
					    int optionType = JOptionPane.DEFAULT_OPTION;
					    int result = JOptionPane.showConfirmDialog(altaEnfermedadCronicaJFrame, text, title, optionType);
					    if (result == JOptionPane.OK_OPTION) {
					    	altaEnfermedadCronicaJFrame.dispose();
					    	panelAnterior.actualizarTablaEnfermedadCronica(optGrupoFamiliarRetur.get());
					    	
					    }
				}
				else {
					// error
					JOptionPane.showMessageDialog(altaEnfermedadCronicaJFrame, "No se pudo guardar la enfermedad cronica", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		
	}
	
	private boolean validarCamposVacios() {
		boolean estado = true;
		if(tfDiagnostico.getText().length() == 0) {
			estado = false;
			tfDiagnostico.setBorder(bordeRojo);
		}
		if(tfGastoMensual.getText().length() == 0) {
			estado = false;
			tfGastoMensual.setBorder(bordeRojo);
		}
		return estado;
	}

}
