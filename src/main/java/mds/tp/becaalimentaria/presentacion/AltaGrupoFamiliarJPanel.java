package mds.tp.becaalimentaria.presentacion;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mds.tp.becaalimentaria.domain.GrupoFamiliar;
import mds.tp.becaalimentaria.domain.ProgenitorTutor;
import mds.tp.becaalimentaria.gestores.GestorAlumno;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.util.List;

public class AltaGrupoFamiliarJPanel extends JPanel {
	private JTable tableProgenitorTutor;
	private MenuJFrame menuJFrame;
	private AltaGrupoFamiliarJPanel altaGrupoFamiliarJPanel;

	private GestorAlumno alumnoService = GestorAlumno.getInstance();

	/**
	 * Create the panel.
	 */
	public AltaGrupoFamiliarJPanel(MenuJFrame frame) {
		setLayout(null);
		this.menuJFrame = frame;
		this.altaGrupoFamiliarJPanel = this;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 143, 500, 104);
		add(scrollPane);
		tableProgenitorTutor = new JTable();
		tableProgenitorTutor.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Apellido",
				"Ingreso neto", "Edad", "Ocupacion", "Lugar de trabajo", "Convive" }));
		scrollPane.setViewportView(tableProgenitorTutor);

		JLabel lblNewLabel = new JLabel("Progenitor/Tutor:");
		lblNewLabel.setBounds(22, 118, 96, 14);
		add(lblNewLabel);

		JButton btnAgregarProgenitorTutor = new JButton("Agregar");
		btnAgregarProgenitorTutor.setBounds(433, 109, 89, 23);
		add(btnAgregarProgenitorTutor);

		btnAgregarProgenitorTutor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AltaProgenitorJFrame altaProgenitorJFrame = new AltaProgenitorJFrame(altaGrupoFamiliarJPanel);
				altaProgenitorJFrame.setVisible(true);

			}
		});

	}

	public void actualizarTablaProgenitor(GrupoFamiliar grupoFamiliar) {
		List<ProgenitorTutor> listaProgenitorTutor = alumnoService.getProgenitorTutorGrupoFamiliar(grupoFamiliar);
		if (listaProgenitorTutor.size() > 0) {
			for (ProgenitorTutor unPro : listaProgenitorTutor) {
				Object row[] = { unPro.getNombre(), unPro.getApellido(), unPro.getIngresoNeto(),
						unPro.getEdad(), unPro.getOcupacion(), unPro.getLugarDeTrabajo(), unPro.getConvive()};
				((DefaultTableModel) tableProgenitorTutor.getModel()).addRow(row);
			}
		}
		tableProgenitorTutor.repaint();
	}

}
