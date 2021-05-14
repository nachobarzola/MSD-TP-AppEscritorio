package mds.tp.becaalimentaria.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mds.tp.becaalimentaria.domain.Escuela;


public class MenuJPanel extends JPanel {
	private MenuJFrame menuJFrame;
	private Escuela escuelaLogeada;

	/**
	 * Create the panel.
	 */
	public MenuJPanel(MenuJFrame frame,Escuela escuela) {
		this.menuJFrame = frame;
		this.escuelaLogeada = escuela;
		
		JButton btnAlumno = new JButton("Alumno");
        add(btnAlumno, "name_903094095131900");

        JButton btnSolicitudes = new JButton("Solicitudes");
        add(btnSolicitudes, "name_903094110897200");

        JLabel lblNewLabel = new JLabel("MENU");
        add(lblNewLabel, "name_903094126363500");

        JLabel lblEscuela = new JLabel(escuela.getNombre());
        add(lblEscuela, "name_903094143766800");

        //contentPane.setLayout(cardLayout);
        btnAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				menuJFrame.cambiarVentanaMenu(2, escuelaLogeada);
			}
		});
       
	}

}
