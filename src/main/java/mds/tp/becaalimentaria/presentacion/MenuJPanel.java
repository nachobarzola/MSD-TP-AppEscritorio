package mds.tp.becaalimentaria.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mds.tp.becaalimentaria.domain.Escuela;
import java.awt.Font;


public class MenuJPanel extends JPanel {
	private MenuJFrame menuJFrame;
	private Escuela escuelaLogeada;

	/**
	 * Create the panel.
	 */
	public MenuJPanel(MenuJFrame frame) {
		this.menuJFrame = frame;
		setLayout(null);
		
		JButton btnAlumno = new JButton("Alumno");
		btnAlumno.setBounds(185, 113, 85, 23);
        add(btnAlumno);

        JButton btnSolicitudes = new JButton("Solicitudes");
        btnSolicitudes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		menuJFrame.cambiarVentanaMenu(5);
        	}
        });
        btnSolicitudes.setBounds(185, 158, 91, 23);
        add(btnSolicitudes);

        JLabel lblNewLabel = new JLabel("MENU");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(204, 46, 48, 23);
        add(lblNewLabel);

        JLabel lblEscuela = new JLabel("Escuela: "+menuJFrame.getEscuelaLogeada().getNombre());
        lblEscuela.setBounds(197, 88, 150, 14);
        add(lblEscuela);

        //contentPane.setLayout(cardLayout);
        btnAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(2);
			}
		});
       
	}

}
