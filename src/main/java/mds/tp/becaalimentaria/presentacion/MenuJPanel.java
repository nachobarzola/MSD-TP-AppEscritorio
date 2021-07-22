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
		btnAlumno.setBounds(150, 266, 116, 23);
        add(btnAlumno);

        JButton btnSolicitudes = new JButton("Solicitudes");
        btnSolicitudes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		menuJFrame.cambiarVentanaMenu(5,menuJFrame.getEscuelaLogeada());
        	}
        });
        btnSolicitudes.setBounds(150, 324, 116, 23);
        add(btnSolicitudes);

        JLabel lblNewLabel = new JLabel("MENU");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(181, 90, 74, 38);
        add(lblNewLabel);

        JLabel lblEscuela = new JLabel("Escuela logeada: "+menuJFrame.getEscuelaLogeada().getNombre());
        lblEscuela.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEscuela.setBounds(110, 48, 223, 28);
        add(lblEscuela);
        
        JLabel lblNewLabel_1 = new JLabel("Elija una opción:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblNewLabel_1.setBounds(168, 227, 116, 14);
        add(lblNewLabel_1);

        //contentPane.setLayout(cardLayout);
        btnAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(2);
			}
		});
       
	}
}
