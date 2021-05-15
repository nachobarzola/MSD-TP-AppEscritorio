package mds.tp.becaalimentaria.presentacion;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AltaGrupoFamiliarJPanel extends JPanel {
	private JTable tableProgenitorTutor;
	private MenuJFrame menuJFrame;


	/**
	 * Create the panel.
	 */
	public AltaGrupoFamiliarJPanel(MenuJFrame frame) {
		setLayout(null);
		this.menuJFrame = frame;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 143, 500, 104);
		add(scrollPane);
		tableProgenitorTutor = new JTable();
		tableProgenitorTutor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Ingreso neto", "Edad", "Ocupacion", "Lugar de trabajo", "Convive"
			}
		));
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
				AltaProgenitorJFrame altaProgenitorJFrame = new AltaProgenitorJFrame();
				altaProgenitorJFrame.setVisible(true);
				
				
			}
		});

	}
}
