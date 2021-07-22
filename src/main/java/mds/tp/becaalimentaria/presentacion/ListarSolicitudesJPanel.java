package mds.tp.becaalimentaria.presentacion;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mds.tp.becaalimentaria.domain.Escuela;
import mds.tp.becaalimentaria.domain.ProgenitorTutor;
import mds.tp.becaalimentaria.domain.Solicitud;
import mds.tp.becaalimentaria.gestores.GestorSolicitud;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class ListarSolicitudesJPanel extends JPanel {
	private JTable tableSolicitudes;
	private MenuJFrame menuJFrame;
	private Escuela escuelaLogeada;
	
	private GestorSolicitud serviceSolicitud=GestorSolicitud.getInstance();

	/**
	 * Create the panel.
	 */
	public ListarSolicitudesJPanel(final MenuJFrame frame, final Escuela escuelaLogeada) {
		this.menuJFrame = frame;
		this.escuelaLogeada = escuelaLogeada;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 56, 422, 260);
		add(scrollPane);
		
		tableSolicitudes = new JTable();
		tableSolicitudes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Apellido", "Fecha", "Estado solicitud"
			}
		));
		tableSolicitudes.setBounds(0, 0, 1, 1);
		scrollPane.setViewportView(tableSolicitudes);
		cargarValoresTabla();
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(5, escuelaLogeada);
			}
		});
		btnAtras.setBounds(370, 330, 89, 23);
		add(btnAtras);
		
		JLabel lblNewLabel = new JLabel("Registro de solicitudes");
		lblNewLabel.setBounds(36, 21, 130, 14);
		add(lblNewLabel);
		
	
	}
	
	private void cargarValoresTabla() {
		List<Solicitud> listaSolicitudes = new ArrayList<>();
		listaSolicitudes = serviceSolicitud.getAllSolicitudes(escuelaLogeada);
		
		for(Solicitud unaSoli: listaSolicitudes) {
			String fecha = unaSoli.getFecha().toString();//unaSoli.getFecha().getDay() +"/"+ unaSoli.getFecha().getMonth() +"/"+ unaSoli.getFecha().getYear();
			Object row[] = { unaSoli.getAlumnoSolicitante().getDni(),unaSoli.getAlumnoSolicitante().getNombre(),unaSoli.getAlumnoSolicitante().getApellido(),fecha ,unaSoli.getClasificacionSolicitud()};
			((DefaultTableModel) tableSolicitudes.getModel()).addRow(row);
		}
	}
}
