package mds.tp.becaalimentaria.presentacion;

import javax.swing.JPanel;

import mds.tp.becaalimentaria.domain.Escuela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class MenuAlumnoJPanel extends JPanel {

	private MenuJFrame menuJFrame;
	private JButton btnAtras;
	
	/**
	 * Create the panel.
	 */
	public MenuAlumnoJPanel(final MenuJFrame frame) {
		this.menuJFrame = frame;
	
		setLayout(null);
		
		JButton btnNuevoAlumno = new JButton("Nuevo alumno");
		btnNuevoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNuevoAlumno.setBounds(221, 239, 145, 23);
		add(btnNuevoAlumno);
		
		btnNuevoAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(3);
			}
		});
		
		btnAtras = new JButton("Atrás");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtras.setBounds(221, 305, 145, 23);
		this.add(btnAtras);
		
		JLabel lblNewLabel = new JLabel("MENU ALUMNO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(231, 105, 135, 29);
		add(lblNewLabel);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAlumnoJPanel.this.menuJFrame.cambiarVentanaMenu(1);
			}
		});

	}
}
