package view;

import javax.swing.JPanel;
import excepciones.Validations;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Clinic;
import model.IconHelper;
import model.Patient;
import model.Person;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.ControlFields;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Search extends JPanel {
	private JTable table;
	private JTextField searchTxt;

	
	public Search(Clinic clinic) {
		setBackground(new Color(176, 224, 230));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 22, 460, 203);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		JButton home = new JButton("");
		home.setBackground(new Color(176, 224, 230));
		home.setForeground(new Color(176, 224, 230));
		home.setIcon(new ImageIcon(Search.class.getResource("/Icons/home2.jpg")));
		home.setBounds(30, 285, 72, 72);
		home.setBorder(new IconHelper(260));
		add(home);
		
		JButton more = new JButton("");
		more.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() == -1) 
					Validations.errorMessage("Seleccione un paciente primero");
				else {
					MoreInfoSecre more = new MoreInfoSecre(clinic.getListOfPatients().get(table.getSelectedRow()));
					more.setVisible(true);
				}
			}
		});
		more.setForeground(new Color(176, 224, 230));
		more.setBackground(new Color(176, 224, 230));
		more.setIcon(new ImageIcon(Search.class.getResource("/Icons/mas.jpg")));
		more.setBounds(287, 286, 72, 72);
		more.setBorder(new IconHelper(260));
		add(more);
		
		JButton delete = new JButton("");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlFields.deletePatient(clinic, table);
				ControlFields.fillTablePatient(table, clinic.getListOfPatients());
		}
		});
		delete.setForeground(new Color(176, 224, 230));
		delete.setBackground(new Color(176, 224, 230));
		delete.setIcon(new ImageIcon(Search.class.getResource("/Icons/eliminar.jpg")));
		delete.setBounds(395, 285, 72, 72);
		delete.setBorder(new IconHelper(260));
		add(delete);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(37, 367, 62, 17);
		add(lblHome);
		
		JLabel lblMas = new JLabel("Mas");
		lblMas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMas.setBounds(291, 369, 62, 17);
		add(lblMas);
		
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEliminar.setBounds(402, 367, 62, 17);
		add(lblEliminar);
		
		JComboBox cbmSearch = new JComboBox();
		cbmSearch.setModel(new DefaultComboBoxModel(new String[] {" ", "Nombre", "Cedula"}));
		cbmSearch.setMaximumRowCount(3);
		cbmSearch.setBounds(265, 236, 79, 20);
		add(cbmSearch);
		
		searchTxt = new JTextField();
		searchTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbmSearch.getSelectedIndex() == 0)
					Validations.errorMessage("Indique que metodo quiere usar para buscar (Nombre o Cedula)");
				else {
					ArrayList<Patient> filler = new ArrayList<Patient>();
					for(Patient patient: clinic.getListOfPatients()) {
						if (cbmSearch.getSelectedIndex() == 1) {
							if (searchTxt.getText().equals(patient.getName())) 
								filler.add(patient);
						}
						else 
							if(searchTxt.getText().equals(String.valueOf(patient.getId())))
								filler.add(patient);
					}
					if (filler.isEmpty())
						Validations.errorMessage("Persona no Encontrada");
					else 
						ControlFields.fillTablePatient(table, filler);
			}
			}
		});
		searchTxt.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updater();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updater();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updater();	
			}
			
			public void updater() {
				if (searchTxt.getText().isEmpty()) {
					ControlFields.fillTablePatient(table, clinic.getListOfPatients());
				}
			}
		}); {
	
		}
		searchTxt.setBounds(37, 237, 145, 20);
		add(searchTxt);
		searchTxt.setColumns(10);
		
		JLabel lblSearch = new JLabel("Buscar Por: ");
		lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearch.setBounds(186, 240, 79, 14);
		add(lblSearch);
		
		JButton modif = new JButton("");
		modif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModifPatient modifPatient = new ModifPatient(clinic, clinic.getListOfPatients().get(table.getSelectedRow()), table);
				ControlFields.fillTableDentist(modifPatient.getDentistTable(), clinic);
				modifPatient.setVisible(true);
				modifPatient.getDentistTable().setRowSelectionInterval(clinic.getListOfStaff().indexOf(clinic.getListOfPatients().get(table.getSelectedRow()).getDentist()),clinic.getListOfStaff().indexOf(clinic.getListOfPatients().get(table.getSelectedRow()).getDentist()));
			}
		});
		modif.setIcon(new ImageIcon(Search.class.getResource("/icons/Pencil.jpg")));
		modif.setForeground(new Color(176, 224, 230));
		modif.setBorder(new IconHelper(260));
		modif.setBackground(new Color(176, 224, 230));
		modif.setBounds(180, 285, 72, 72);
		add(modif);
		
		JLabel lblModif = new JLabel("Modificar");
		lblModif.setHorizontalAlignment(SwingConstants.CENTER);
		lblModif.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModif.setBounds(190, 367, 62, 17);
		add(lblModif);
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}
	
	

}