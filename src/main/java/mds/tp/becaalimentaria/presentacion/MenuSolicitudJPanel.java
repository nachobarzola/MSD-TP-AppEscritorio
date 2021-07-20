package mds.tp.becaalimentaria.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import mds.tp.becaalimentaria.domain.Escuela;

public class MenuSolicitudJPanel extends JPanel {

	private MenuJFrame menuJFrame;
	private Escuela escuelaLogeada;
	private JButton btnAtras;
	
	public MenuSolicitudJPanel(final MenuJFrame frame, Escuela escuelaLog) {
		this.menuJFrame = frame;
		this.escuelaLogeada = escuelaLog;
		setLayout(null);
		
		JButton btnNuevaSolicitud = new JButton("Nueva solicitud");
		btnNuevaSolicitud.setBounds(142, 74, 145, 23);
		add(btnNuevaSolicitud);
		
		btnNuevaSolicitud.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(6,escuelaLogeada);
			}
		});
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(142, 266, 145, 23);
		this.add(btnAtras);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(1);
			}
		});
		
		JButton btnListarSolicitudes = new JButton("Listar solicitudes");
		btnListarSolicitudes.setBounds(142, 123, 145, 23);
		add(btnListarSolicitudes);
		
		btnListarSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(7, escuelaLogeada);
			}
		});
		
		
		
	}
}
