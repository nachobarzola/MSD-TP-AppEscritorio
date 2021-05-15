package mds.tp.becaalimentaria.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mds.tp.becaalimentaria.domain.Escuela;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.CardLayout;


public class MenuJFrame extends JFrame {

	private JPanel contentPane;
	private AltaAlumnoJPanel panelAltaAlumno;
	private MenuJPanel panelMenu;
	
	private CardLayout cardLayout= new CardLayout();
	private MenuJFrame frame;
	

	
	
	public MenuJFrame(Escuela escuela) {
		this.frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		JLabel labelEscuela = new JLabel();
		labelEscuela.setText(escuela.getNombre());
		labelEscuela.setBounds(127, 109, 46, 14); //MODIFICAR ESTO PQ NO PUEDO ABRIRLO CON EL W BUILDER
		MenuJPanel menuJPanel= new MenuJPanel(frame, escuela);
		contentPane.add(menuJPanel, "1");
		
		
	}
	
	
	public void cambiarVentanaMenu(int n, Escuela escuela) {
		switch(n) {
		case 1:
			this.setTitle("Menu");
			panelMenu = new MenuJPanel(this,escuela);
			contentPane.add(panelMenu,"1");
			cardLayout.show(contentPane, "1");
			break;
		case 2: //Alta Alumno
			this.setTitle("Agregar alumno");
			panelAltaAlumno = new AltaAlumnoJPanel(this);
			contentPane.add(panelAltaAlumno,"2");
			cardLayout.show(contentPane, "2");
			break;
		
		}
	}
	

}
