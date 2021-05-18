package mds.tp.becaalimentaria.presentacion;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import mds.tp.becaalimentaria.domain.Alumno;
import mds.tp.becaalimentaria.domain.EnfermedadCronica;
import mds.tp.becaalimentaria.domain.GrupoFamiliar;
import mds.tp.becaalimentaria.domain.Hermano;
import mds.tp.becaalimentaria.domain.ProgenitorTutor;
import mds.tp.becaalimentaria.gestores.GestorAlumno;

import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.util.List;
import java.util.Optional;

public class AltaGrupoFamiliarJPanel extends JPanel {
	private JTable tableProgenitorTutor;
	private JTable tableHermano;
	private JTable tableEnfermedadCronica;
	private MenuJFrame menuJFrame;
	private AltaGrupoFamiliarJPanel altaGrupoFamiliarJPanel;
	private GrupoFamiliar grupoFamiliarNuevo;
	private JButton btnAgregarHermano;
	private JButton btnAgregarEnfermedadCronica;
	private GestorAlumno alumnoService = GestorAlumno.getInstance();
	private Alumno alumnoEnProgreso;
	
	
	public AltaGrupoFamiliarJPanel(MenuJFrame frame, Alumno alumno) {
		this.alumnoEnProgreso= alumno; 
		setLayout(null);
		this.menuJFrame = frame;
		this.altaGrupoFamiliarJPanel = this;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 107, 500, 104);
		add(scrollPane);
		tableProgenitorTutor = new JTable();
		tableProgenitorTutor.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Apellido",
				"Ingreso neto", "Edad", "Ocupacion", "Lugar de trabajo", "Convive" }));
		scrollPane.setViewportView(tableProgenitorTutor);
		
		JScrollPane scrollPaneHermanos = new JScrollPane();
		scrollPaneHermanos.setBounds(56, 293, 500, 104);
		add(scrollPaneHermanos);
		tableHermano = new JTable();
		tableHermano.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Apellido",
				"Edad", "Ocupacion", "Escuela", "Convive" }));
		scrollPaneHermanos.setViewportView(tableHermano);
		
		JScrollPane scrollPaneEnfermedad = new JScrollPane();
		scrollPaneEnfermedad.setBounds(56, 458, 500, 104);
		add(scrollPaneEnfermedad);
		tableEnfermedadCronica = new JTable();
		tableEnfermedadCronica.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Diagnóstico", "Gasto mensual" }));
		scrollPaneEnfermedad.setViewportView(tableEnfermedadCronica);

		
		JLabel lblNewLabel = new JLabel("Progenitor/Tutor:");
		lblNewLabel.setBounds(56, 82, 96, 14);
		add(lblNewLabel);

		JButton btnAgregarProgenitorTutor = new JButton("Agregar");
		btnAgregarProgenitorTutor.setBounds(467, 73, 89, 23);
		add(btnAgregarProgenitorTutor);
		
		JLabel lblNewLabel_1 = new JLabel("Hermanos:");
		lblNewLabel_1.setBounds(56, 268, 79, 14);
		add(lblNewLabel_1);
		
		btnAgregarHermano = new JButton("Agregar");
		btnAgregarHermano.setBounds(467, 259, 89, 23);
		btnAgregarHermano.setEnabled(false);
		add(btnAgregarHermano);
		
		JLabel lblNewLabel_2 = new JLabel("Enfermedades crónicas: ");
		lblNewLabel_2.setBounds(56, 436, 144, 14);
		add(lblNewLabel_2);
		
		btnAgregarEnfermedadCronica = new JButton("Agregar");
		btnAgregarEnfermedadCronica.setBounds(467, 432, 89, 23);
		btnAgregarEnfermedadCronica.setEnabled(false);
		add(btnAgregarEnfermedadCronica);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(285, 679, 89, 23);
		add(btnFinalizar);
		
		
		
		btnAgregarEnfermedadCronica.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AltaEnfermedadCronicaJFrame altaEnfermedadCronicaJFrame = new AltaEnfermedadCronicaJFrame(altaGrupoFamiliarJPanel,grupoFamiliarNuevo);
				altaEnfermedadCronicaJFrame.setVisible(true);
				
			}
		});
		
		
		btnAgregarHermano.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AltaHermanoJFrame altaHermanoJFrame = new AltaHermanoJFrame(altaGrupoFamiliarJPanel,grupoFamiliarNuevo);
				altaHermanoJFrame.setVisible(true);
				
			}
			
		});

		
		btnAgregarProgenitorTutor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AltaProgenitorJFrame altaProgenitorJFrame = new AltaProgenitorJFrame(altaGrupoFamiliarJPanel, alumnoEnProgreso);
				altaProgenitorJFrame.setVisible(true);

			}
		});
		
		btnFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuJFrame.cambiarVentanaMenu(1);
			}
		});

	}

	public void actualizarTablaProgenitor(GrupoFamiliar grupoFamiliar) {
		
		this.grupoFamiliarNuevo = grupoFamiliar;
		Optional<GrupoFamiliar> grupoFamiliarReturn = alumnoService.getGrupoFamiliar(grupoFamiliar.getId());
		List<ProgenitorTutor> listaProgenitorTutor = grupoFamiliarReturn.get().getListaProgenitorTutor();
		
		if (listaProgenitorTutor.size() > 0) {
			for (ProgenitorTutor unPro : listaProgenitorTutor) {
				Object row[] = { unPro.getNombre(), unPro.getApellido(), unPro.getIngresoNeto(),
						unPro.getEdad(), unPro.getOcupacion(), unPro.getLugarDeTrabajo(), unPro.getConvive()};
				((DefaultTableModel) tableProgenitorTutor.getModel()).addRow(row);
			}
			btnAgregarHermano.setEnabled(true);
			btnAgregarEnfermedadCronica.setEnabled(true);
		}
		tableProgenitorTutor.repaint();
	}
	
	public void actualizarTablaHermano(GrupoFamiliar grupoFamiliar) {
		this.grupoFamiliarNuevo = grupoFamiliar;
		Optional<GrupoFamiliar> grupoFamiliarReturn = alumnoService.getGrupoFamiliar(grupoFamiliar.getId());
		List<Hermano> listaHermanos = grupoFamiliarReturn.get().getListaHermano();
		
		if (listaHermanos.size() > 0) {
			for (Hermano unHer : listaHermanos) {
				Object row[] = { unHer.getNombre(), unHer.getApellido(), unHer.getEdad(),
						unHer.getOcupacion(), unHer.getEscuela(), unHer.getConvive()};
				((DefaultTableModel) tableHermano.getModel()).addRow(row);
			}
		}
		tableHermano.repaint();
	}

	public void actualizarTablaEnfermedadCronica(GrupoFamiliar grupoFamiliar) {
		this.grupoFamiliarNuevo = grupoFamiliar;
		Optional<GrupoFamiliar> grupoFamiliarReturn = alumnoService.getGrupoFamiliar(grupoFamiliar.getId());
		List<EnfermedadCronica> listaEnfermedadCronica = grupoFamiliarReturn.get().getListaEnfermedadCronica();
		
		if (listaEnfermedadCronica.size() > 0) {
			for (EnfermedadCronica unaEnf : listaEnfermedadCronica) {
				Object row[] = {unaEnf.getDiagnostico(), unaEnf.getGastoMensual()};
				((DefaultTableModel) tableEnfermedadCronica.getModel()).addRow(row);
			}
		}
		tableEnfermedadCronica.repaint();
		
	}
}
