package mds.tp.becaalimentaria.presentacion;

import javax.swing.JPanel;

import mds.tp.becaalimentaria.domain.Escuela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuAlumnoJPanel extends JPanel {

	private MenuJFrame menuJFrame;
	
	/**
	 * Create the panel.
	 */
	public MenuAlumnoJPanel(final MenuJFrame frame) {
		this.menuJFrame = frame;
	
		setLayout(null);
		
		JButton btnNuevoAlumno = new JButton("Nuevo alumno");
		btnNuevoAlumno.setBounds(151, 64, 145, 23);
		add(btnNuevoAlumno);
		
		btnNuevoAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.cambiarVentanaMenu(3, menuJFrame.getEscuelaLogeada());
			}
		});

	}
}
