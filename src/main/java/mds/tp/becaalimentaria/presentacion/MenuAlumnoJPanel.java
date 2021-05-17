package mds.tp.becaalimentaria.presentacion;

import javax.swing.JPanel;

import mds.tp.becaalimentaria.domain.Escuela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

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
		btnNuevoAlumno.setBounds(248, 211, 145, 23);
		add(btnNuevoAlumno);
		
		btnNuevoAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(3);
			}
		});
		
		btnAtras = new JButton("Atrás");
		btnAtras.setBounds(248, 277, 145, 23);
		this.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAlumnoJPanel.this.menuJFrame.cambiarVentanaMenu(1);
			}
		});

	}
}
