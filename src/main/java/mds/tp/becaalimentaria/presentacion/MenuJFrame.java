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
	private MenuAlumnoJPanel panelMenuAlumno;
	private AltaGrupoFamiliarJPanel panelAltaGrupoFamiliar;
	
	private CardLayout cardLayout= new CardLayout();
	private MenuJFrame menuJFrame;
	
	private Escuela escuelaLogeada;
	

	
	
	public MenuJFrame(Escuela escuela) {
		this.escuelaLogeada = escuela;
		this.menuJFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);
		
		MenuJPanel menuJPanel= new MenuJPanel(menuJFrame);
		contentPane.add(menuJPanel, "1");
		
		
	}
	public Escuela getEscuelaLogeada() {
		return this.escuelaLogeada;
	}
	
	
	public void cambiarVentanaMenu(int n) {
		switch(n) {
		case 1:
			this.setTitle("Menu");
			panelMenu = new MenuJPanel(this);
			contentPane.add(panelMenu,"1");
			cardLayout.show(contentPane, "1");
			break;
		case 2: //Menu alumno
			this.setTitle("Menu alumno");
			panelMenuAlumno = new MenuAlumnoJPanel(this);
			contentPane.add(panelMenuAlumno,"2");
			cardLayout.show(contentPane, "2");
			break;
		case 3: //Alta Alumno
			this.setTitle("Agregar alumno");
			panelAltaAlumno = new AltaAlumnoJPanel(this);
			contentPane.add(panelAltaAlumno,"3");
			cardLayout.show(contentPane, "3");
			break;
		case 4: //Alta grupo familiar
			this.setTitle("Agregar grupo familiar");
			panelAltaGrupoFamiliar = new AltaGrupoFamiliarJPanel(this);
			contentPane.add(panelAltaGrupoFamiliar,"4");
			cardLayout.show(contentPane, "4");
			break;
		
		
		}
	}
	

}
