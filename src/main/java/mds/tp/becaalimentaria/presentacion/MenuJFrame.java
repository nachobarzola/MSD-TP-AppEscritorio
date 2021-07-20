package mds.tp.becaalimentaria.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.Escuela;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Dimension;

public class MenuJFrame extends JFrame {

	private JPanel contentPane;
	private AltaAlumnoJPanel panelAltaAlumno;
	private MenuJPanel panelMenu;
	private MenuAlumnoJPanel panelMenuAlumno;
	private MenuSolicitudJPanel panelMenuSolicitud;
	private AltaGrupoFamiliarJPanel panelAltaGrupoFamiliar;
	private AltaSolicitudJPanel panelAltaSolicitud;
	private ListarSolicitudesJPanel listarSolicitudesJPanel;

	private CardLayout cardLayout = new CardLayout();
	private MenuJFrame menuJFrame;

	private Escuela escuelaLogeada;

	public MenuJFrame(Escuela escuela) {
		this.escuelaLogeada = escuela;
		this.menuJFrame = this;
		//--------------------Regular dimension de la interfaz grafica
		//setSize(738, 800);
		
		Dimension dimPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int height = dimPantalla.height;
		int width = dimPantalla.width;
		setSize((int)(width*0.35),(int)(height*0.90));
		
		setLocationRelativeTo(null); //Centra el jframe en la pantalla
		//---------------------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(cardLayout);

		MenuJPanel menuJPanel = new MenuJPanel(menuJFrame);
		contentPane.add(menuJPanel, "1");

	}

	public Escuela getEscuelaLogeada() {
		return this.escuelaLogeada;
	}

	public void cambiarVentanaMenu(int n) {
		switch (n) {
		case 1:
			this.setTitle("Menu");
			panelMenu = new MenuJPanel(this);
			contentPane.add(panelMenu, "1");
			cardLayout.show(contentPane, "1");
			break;
		case 2: // Menu alumno
			this.setTitle("Menu alumno");
			panelMenuAlumno = new MenuAlumnoJPanel(this);
			contentPane.add(panelMenuAlumno, "2");
			cardLayout.show(contentPane, "2");
			break;
		case 3: // Alta Alumno
			this.setTitle("Agregar alumno");
			panelAltaAlumno = new AltaAlumnoJPanel(this);
			contentPane.add(panelAltaAlumno, "3");
			cardLayout.show(contentPane, "3");
			break;
		case 4: // Alta grupo familiar
			this.setTitle("Agregar grupo familiar");
			panelAltaGrupoFamiliar = new AltaGrupoFamiliarJPanel(this, null);
			contentPane.add(panelAltaGrupoFamiliar, "4");
			cardLayout.show(contentPane, "4");
			break;
		/*
		 * case 5: // Menu solicitud this.setTitle("Menu solicitud"); panelMenuSolicitud
		 * = new MenuSolicitudJPanel(this, null); contentPane.add(panelMenuSolicitud,
		 * "5"); cardLayout.show(contentPane, "5"); break;
		 * 
		 * case 6: // Alta solicitud this.setTitle("Agregar solicitud");
		 * panelAltaSolicitud = new AltaSolicitudJPanel(this, null);
		 * contentPane.add(panelAltaSolicitud, "6"); cardLayout.show(contentPane, "6");
		 * break;
		 * 
		 * case 7: // Listar solicitudes this.setTitle("Lista de solicitudes");
		 * listarSolicitudesJPanel = new ListarSolicitudesJPanel();
		 * contentPane.add(listarSolicitudesJPanel, "7"); cardLayout.show(contentPane,
		 * "7"); break;
		 */
		}
	}

	public void cambiarVentanaMenu(int n, Alumno alumno) {
		switch (n) {

		case 4: // Alta grupo familiar
			this.setTitle("Agregar grupo familiar");
			panelAltaGrupoFamiliar = new AltaGrupoFamiliarJPanel(this, alumno);
			contentPane.add(panelAltaGrupoFamiliar, "4");
			cardLayout.show(contentPane, "4");
			break;

		}
	}

	public void cambiarVentanaMenu(int n, Escuela escuelaLogeada) {
		switch (n) {

		case 5: // Menu solicitud
			this.setTitle("Menu solicitud");
			panelMenuSolicitud = new MenuSolicitudJPanel(this, escuelaLogeada);
			contentPane.add(panelMenuSolicitud, "5");
			cardLayout.show(contentPane, "5");
			break;
		case 6: // Alta solicitud
			this.setTitle("Agregar solicitud");
			panelAltaSolicitud = new AltaSolicitudJPanel(this, escuelaLogeada);
			contentPane.add(panelAltaSolicitud, "6");
			cardLayout.show(contentPane, "6");
			break;
		case 7: // Listar solicitudes
			this.setTitle("Lista de solicitudes");
			listarSolicitudesJPanel = new ListarSolicitudesJPanel(this, escuelaLogeada);
			contentPane.add(listarSolicitudesJPanel, "7");
			cardLayout.show(contentPane, "7");
			break;
		}
	}

}
