package mds.tp.becaalimentaria.presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mds.tp.becaalimentaria.domain.Escuela;
import java.awt.Font;
import javax.swing.JSeparator;


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
		btnAlumno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAlumno.setBounds(231, 353, 116, 23);
        add(btnAlumno);

        JButton btnSolicitudes = new JButton("Solicitudes");
        btnSolicitudes.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSolicitudes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		menuJFrame.cambiarVentanaMenu(5,menuJFrame.getEscuelaLogeada());
        	}
        });
        btnSolicitudes.setBounds(231, 411, 116, 23);
        add(btnSolicitudes);

        JLabel lblNewLabel = new JLabel("MENU");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(262, 177, 74, 38);
        add(lblNewLabel);

        JLabel lblEscuela = new JLabel("Escuela logeada: "+menuJFrame.getEscuelaLogeada().getNombre());
        lblEscuela.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblEscuela.setBounds(124, 57, 309, 28);
        add(lblEscuela);
        
        JLabel lblNewLabel_1 = new JLabel("Elija una opción:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 12));
        lblNewLabel_1.setBounds(231, 313, 116, 14);
        add(lblNewLabel_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(61, 96, 451, 2);
        add(separator);

        //contentPane.setLayout(cardLayout);
        btnAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(2);
			}
		});
       
	}
}
