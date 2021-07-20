package mds.tp.becaalimentaria.presentacion;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mds.tp.becaalimentaria.domain.Escuela;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarSolicitudesJPanel extends JPanel {
	private JTable tableSolicitudes;
	private MenuJFrame menuJFrame;
	private Escuela escuelaLogeada;

	/**
	 * Create the panel.
	 */
	public ListarSolicitudesJPanel(final MenuJFrame frame, final Escuela escuelaLogeada) {
		this.menuJFrame = frame;
		this.escuelaLogeada = escuelaLogeada;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 56, 420, 260);
		add(scrollPane);
		
		tableSolicitudes = new JTable();
		tableSolicitudes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Alumno solicitante", "Fecha", "Estado solicitud"
			}
		));
		tableSolicitudes.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(tableSolicitudes);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(5, escuelaLogeada);
			}
		});
		btnAtras.setBounds(368, 358, 89, 23);
		add(btnAtras);
		
	
	}
}
