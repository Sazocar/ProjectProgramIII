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
import java.awt.Cursor;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Search extends JPanel {

    private JTable table;
    private JTextField searchTxt;

    public Search(Clinic clinic, boolean SorD) {
        setBackground(new Color(176, 224, 230));
        setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(37, 22, 460, 203);
        add(scrollPane);

        table = new JTable();	
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        table.setBackground(new Color(255, 255, 255));
        scrollPane.setViewportView(table);
        table.getTableHeader().setReorderingAllowed(false); // prevent user to drag column
        table.getTableHeader().setEnabled(false);		  // tableHeader not resizable
        table.setDefaultEditor(Object.class, null);		  // column not editable

        JButton btnHome = new JButton("");
        btnHome.setBackground(new Color(176, 224, 230));
        btnHome.setForeground(new Color(176, 224, 230));
        btnHome.setIcon(new ImageIcon(Search.class.getResource("/Icons/home2.jpg")));
        btnHome.setBounds(30, 285, 72, 72);
        btnHome.setBorder(new IconHelper(260));
        btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnHome);

        JButton btnMore = new JButton("");
        btnMore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() == -1) {
                    Validations.errorMessage("Seleccione un paciente\npara mostrar mas informacion");
                } else {
                	if (!SorD) {
	                    MoreInfoSecre more = new MoreInfoSecre(clinic.getListOfPatients().get(table.getSelectedRow()));
	                    more.setVisible(true);
                	}
                	else {
                		MoreInfoDent more = new MoreInfoDent(clinic.getListOfPatients().get(table.getSelectedRow()));
	                    more.setVisible(true);
                	}
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

        JButton btnDelete = new JButton("");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() == -1) 
                    Validations.errorMessage("Seleccione un paciente\npara eliminar");
                else {
                    ControlFields.deletePatient(clinic, table);
                    ControlFields.fillTablePatient(table, clinic.getListOfPatients());
                }
            }
        });
        btnDelete.setForeground(new Color(176, 224, 230));
        btnDelete.setBackground(new Color(176, 224, 230));
        btnDelete.setIcon(new ImageIcon(Search.class.getResource("/Icons/eliminar.jpg")));
        btnDelete.setBounds(395, 285, 72, 72);
        btnDelete.setBorder(new IconHelper(260));
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnDelete);

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
        cbmSearch.setModel(new DefaultComboBoxModel(new String[]{" ", "Nombre", "Cedula"}));
        cbmSearch.setMaximumRowCount(3);
        cbmSearch.setBounds(265, 236, 79, 20);
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
                    ControlFields.fillTablePatient(table, clinic.getListOfPatients());
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

        JButton btnModif = new JButton("");
        btnModif.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (table.getSelectedRow() == -1) 
                    Validations.errorMessage("Seleccione un paciente\npara modificar");
                else {
                    ModifPatient modifPatient = new ModifPatient(clinic, clinic.getListOfPatients().get(table.getSelectedRow()), table);
                    ControlFields.fillTableDentist(modifPatient.getDentistTable(), clinic);
                    modifPatient.setVisible(true);
                    modifPatient.getDentistTable().setRowSelectionInterval(clinic.getListOfStaff().indexOf(clinic.getListOfPatients().get(table.getSelectedRow()).getDentist()), clinic.getListOfStaff().indexOf(clinic.getListOfPatients().get(table.getSelectedRow()).getDentist()));
                }
            }
        });
        btnModif.setIcon(new ImageIcon(Search.class.getResource("/icons/Pencil.jpg")));
        btnModif.setForeground(new Color(176, 224, 230));
        btnModif.setBorder(new IconHelper(260));
        btnModif.setBackground(new Color(176, 224, 230));
        btnModif.setBounds(180, 285, 72, 72);
        btnModif.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnModif);

        JLabel lblModif = new JLabel("Modificar");
        lblModif.setHorizontalAlignment(SwingConstants.CENTER);
        lblModif.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblModif.setBounds(190, 367, 62, 17);
        add(lblModif);
        
        JButton btnSearch = new JButton("Buscar");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		searchAction(cbmSearch, clinic);
        	}
        });
        btnSearch.setBounds(382, 236, 89, 23);
        add(btnSearch);
    }
    
    

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    
    public void searchAction(JComboBox cbmSearch, Clinic clinic) {
    	if (cbmSearch.getSelectedIndex() == 0) {
            Validations.errorMessage("Indique que metodo quiere usar para buscar (Nombre o Cedula)");
        } else {
            ArrayList<Patient> filler = new ArrayList<Patient>();
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
                ControlFields.fillTablePatient(table, filler);
            }
        }
    }
}
