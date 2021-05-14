package mds.tp.becaalimentaria.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;



public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField campoCodigo;
	private JTextField campoClave;
	private JLabel ingresando;

	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código: ");
		lblNewLabel.setBounds(127, 74, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Clave: ");
		lblNewLabel_1.setBounds(127, 109, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		campoCodigo = new JTextField();
		campoCodigo.setBounds(192, 71, 86, 20);
		contentPane.add(campoCodigo);
		campoCodigo.setColumns(10);
		
		campoClave = new JTextField();
		campoClave.setBounds(192, 106, 86, 20);
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
		        ingresando.setVisible(true);
		        //campoCodigo.getText();
		        //campoClave.getText();
		        	        
		       
		}  
		});  
		
		this.setVisible(true);
	}
}
