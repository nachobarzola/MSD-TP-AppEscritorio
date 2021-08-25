package mds.tp.becaalimentaria.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import mds.tp.becaalimentaria.domain.Escuela;
import javax.swing.JLabel;
import java.awt.Font;

public class MenuSolicitudJPanel extends JPanel {

	private MenuJFrame menuJFrame;
	private Escuela escuelaLogeada;
	private JButton btnAtras;
	
	public MenuSolicitudJPanel(final MenuJFrame frame, Escuela escuelaLog) {
		this.menuJFrame = frame;
		this.escuelaLogeada = escuelaLog;
		setLayout(null);
		
		JButton btnNuevaSolicitud = new JButton("Nueva solicitud");
		btnNuevaSolicitud.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNuevaSolicitud.setBounds(205, 156, 145, 23);
		add(btnNuevaSolicitud);
		
		btnNuevaSolicitud.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(6,escuelaLogeada);
			}
		});
		
		btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtras.setBounds(205, 348, 145, 23);
		this.add(btnAtras);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(1);
			}
		});
		
		JButton btnListarSolicitudes = new JButton("Listar solicitudes");
		btnListarSolicitudes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnListarSolicitudes.setBounds(205, 205, 145, 23);
		add(btnListarSolicitudes);
		
		JLabel lblNewLabel = new JLabel("MENU SOLICITUDES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(194, 65, 177, 35);
		add(lblNewLabel);
		
		btnListarSolicitudes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(7, escuelaLogeada);
			}
		});
		
		
		
	}
}
