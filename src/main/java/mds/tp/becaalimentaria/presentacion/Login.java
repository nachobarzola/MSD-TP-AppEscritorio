package mds.tp.becaalimentaria.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.gestores.GestorEscuela;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;



public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField campoCodigo;
	private JPasswordField campoClave;
	private JLabel ingresando;
	private JFrame loginFrame;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private GestorEscuela escuelaService = GestorEscuela.getInstance();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		this.loginFrame=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Código: ");
		lblNewLabel.setBounds(127, 74, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Clave: ");
		lblNewLabel_1.setBounds(127, 109, 46, 14);
		
		contentPane.add(lblNewLabel_1);
		
		campoCodigo = new JTextField();
		campoCodigo.setBounds(192, 71, 86, 20);
		contentPane.add(campoCodigo);
		campoCodigo.setColumns(10);
		
		campoClave = new JPasswordField();
		campoClave.setBounds(192, 106, 86, 20);
		campoClave.setToolTipText("");
		campoClave.setEchoChar('*');
		contentPane.add(campoClave);
		campoClave.setColumns(10);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(161, 198, 89, 23);
		contentPane.add(btnIngresar);
		
		ingresando = new JLabel("Ingresando...");
		ingresando.setBounds(181, 236, 97, 14);
		ingresando.setVisible(false);   
		contentPane.add(ingresando);
		
		btnIngresar.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				boolean completo = true;
				if(campoCodigo.getText().length() == 0) {
					completo = false;
				}
				if(campoClave.getText().length() == 0){
					completo = false;
				}
				if(completo) {
					ingresando.setVisible(true);
			        
				     
			        Optional<Escuela> optEscuela = escuelaService.loginEscuela(campoCodigo.getText(),campoClave.getText());
			        
			        if (optEscuela.isPresent()) {
			        	MenuJFrame menu = new MenuJFrame(optEscuela.get());
			        	menu.setVisible(true);
			        	
			        	loginFrame.dispose();
			        }
			        else {
			        	JOptionPane.showMessageDialog(loginFrame,
			        	    "Ingrese un código y clave correctas",
			        	    "Error",
			        	    JOptionPane.ERROR_MESSAGE);
			        		ingresando.setVisible(false);
			        }
					
				}
				else {
					JOptionPane.showMessageDialog(loginFrame,
			        	    "Debe completar el campo 'Código' y 'Clave'",
			        	    "Error",
			        	    JOptionPane.ERROR_MESSAGE);
					//System.out.println("Debe llenar todos los campos");
				}
		        
		        
		}  
		});  
		
		this.setVisible(true);
	}
}
