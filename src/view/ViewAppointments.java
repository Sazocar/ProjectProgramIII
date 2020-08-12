package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.ControlFields;
import excepciones.Validations;
import model.Clinic;
import model.Dentist;
import model.IconHelper;
import model.Patient;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ViewAppointments extends JPanel {
	private JTable table;
	private static JTextField searchTxt;
	private ArrayList<Patient> filler = new ArrayList<Patient>();

	
	public ViewAppointments(Clinic clinic, ArrayList<Patient> patients, Dentist dentist) {
		setBackground(new Color(176, 224, 230));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 29, 471, 184);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);	
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        table.setBackground(new Color(255, 255, 255));
        scrollPane.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false); // prevent user to drag column
        table.getTableHeader().setEnabled(false);		  // tableHeader not resizable
        table.setDefaultEditor(Object.class, null);		  // column not editable
        
        
        JComboBox cbmSearch = new JComboBox();
        cbmSearch.setModel(new DefaultComboBoxModel(new String[]{" ", "Nombre", "Cedula"}));
        cbmSearch.setMaximumRowCount(3);
        cbmSearch.setBounds(265, 236, 105, 20);
        add(cbmSearch);

        searchTxt = new JTextField();
        
        searchTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                searchAction(cbmSearch, clinic);
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
                	ControlFields.fillTableAppointments(table, patients);
                	filler.clear();
                	Search.fillFiller(filler, patients);
                }
            }
        });
        {

        }
        searchTxt.setBounds(37, 237, 145, 20);
        add(searchTxt);
        searchTxt.setColumns(10);

        JLabel lblSearch = new JLabel("Buscar Por: ");
        lblSearch.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSearch.setBounds(186, 240, 79, 14);
        add(lblSearch);
        
        JButton btnSearch = new JButton("Buscar");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		searchAction(cbmSearch, clinic);
        	}
        });
        btnSearch.setBounds(382, 236, 89, 23);
        add(btnSearch);
        
        JButton btnModif = new JButton("");
        btnModif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (table.getSelectedRow() == -1) {
                    Validations.errorMessage("Seleccione un paciente\npara mostrar mas informacion");
                } else {
                	if (searchTxt.getText().isEmpty())
                		Search.fillFiller(filler, patients);
                		ModifPatientDent modifPatient = new ModifPatientDent(clinic, patients.get(filler.get(table.getSelectedRow()).getListId()), table,patients);
                        ControlFields.fillTableDentist(modifPatient.getDentistTable(), clinic);
                        modifPatient.setLocationRelativeTo(null);
                        modifPatient.setVisible(true);
                }
            }
        });
        btnModif.setIcon(new ImageIcon(Search.class.getResource("/icons/Pencil.jpg")));
        btnModif.setForeground(new Color(176, 224, 230));
        btnModif.setBorder(new IconHelper(260));
        btnModif.setBackground(new Color(176, 224, 230));
        btnModif.setBounds(144, 283, 72, 72);
        btnModif.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnModif);
        
        JButton btnMore = new JButton("");
        btnMore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() == -1) {
                    Validations.errorMessage("Seleccione un paciente\npara mostrar mas informacion");
                } else {
                	if (searchTxt.getText().isEmpty())
                		Search.fillFiller(filler, patients);
                		MoreInfoDent more = new MoreInfoDent(patients.get(filler.get(table.getSelectedRow()).getListId()));
	                    more.setLocationRelativeTo(null);
                		more.setVisible(true);
                }
            }
        });
        btnMore.setForeground(new Color(176, 224, 230));
        btnMore.setBackground(new Color(176, 224, 230));
        btnMore.setIcon(new ImageIcon(Search.class.getResource("/Icons/mas.jpg")));
        btnMore.setBounds(287, 286, 72, 72);
        btnMore.setBorder(new IconHelper(260));
        btnMore.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnMore);
        
        JLabel lblModif = new JLabel("Modificar");
        lblModif.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblModif.setHorizontalAlignment(SwingConstants.CENTER);
        lblModif.setBounds(147, 366, 72, 20);
        add(lblModif);
        
        JLabel lblMore = new JLabel("Mas");
        lblMore.setHorizontalAlignment(SwingConstants.CENTER);
        lblMore.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMore.setBounds(287, 366, 72, 20);
        add(lblMore);
	}
	
	public void searchAction(JComboBox cbmSearch, Clinic clinic) {
		if (cbmSearch.getSelectedIndex() == 0) {
            Validations.errorMessage("Indique que metodo quiere usar para buscar (Nombre o Cedula)");
        } else {
            filler.clear();
            for (Patient patient : clinic.getListOfPatients()) {
                if (cbmSearch.getSelectedIndex() == 1) {
                    if (searchTxt.getText().equalsIgnoreCase(patient.getName())) {
                        filler.add(patient);
                    }
                } else if (searchTxt.getText().equals(String.valueOf(patient.getId()))) {
                    filler.add(patient);
                }
            }
            if (filler.isEmpty()) {
                Validations.errorMessage("Persona no Encontrada");
            } else {
                ControlFields.fillTableAppointments(table, filler);
            }
        }
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	 public static void clearTxt() {
	    	searchTxt.setText("");;
	    }
	
}
