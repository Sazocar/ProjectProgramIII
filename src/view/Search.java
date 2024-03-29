package view;

import javax.swing.JPanel;
import excepciones.Validations;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.*;
import persistence.DaoAppointmentsXML;
import persistence.DaoPatientXML;

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
import java.util.ConcurrentModificationException;
import java.util.ResourceBundle.Control;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Search extends JPanel {

    private JTable table;
    private static JTextField searchTxt;
    private ArrayList<Patient> filler = new ArrayList<Patient>();

    public Search(Clinic clinic, boolean SorD) {
        setBackground(new Color(176, 224, 230));
        setLayout(null);
        
        fillFiller(filler, clinic.getListOfPatients());

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

        JButton btnMore = new JButton("");
        btnMore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() == -1) {
                    Validations.errorMessage("Seleccione un paciente\npara mostrar mas informacion");
                } else {
                    if (!SorD) {
                    	if (searchTxt.getText().isEmpty()) {
                    		filler.clear();
                            fillFiller(filler, clinic.getListOfPatients());
                    	} 
                        MoreInfoSecre more = new MoreInfoSecre(clinic.getListOfPatients().get(filler.get(table.getSelectedRow()).getListId()), clinic);
                        more.setLocationRelativeTo(null);
                        more.setVisible(true);
                    } else {
                    	if (searchTxt.getText().isEmpty()) {
                    		filler.clear();
                            fillFiller(filler, clinic.getListOfPatients());
                    	} 
                        MoreInfoDent more = new MoreInfoDent(clinic.getListOfPatients().get(filler.get(table.getSelectedRow()).getListId()));
                        more.setLocationRelativeTo(null);
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
                if (table.getSelectedRow() == -1) {
                    Validations.errorMessage("Seleccione un paciente\npara eliminar");
                } else {
                	if (searchTxt.getText().isEmpty()) {
                		filler.clear();
                        fillFiller(filler, clinic.getListOfPatients());
                	}               		
                    try {
                        delete(clinic);
                    } catch (ConcurrentModificationException weirdExeption) {
                        delete(clinic);
                    }
                }
            }
        });
        btnDelete.setForeground(new Color(176, 224, 230));
        btnDelete.setBackground(new Color(176, 224, 230));
        btnDelete.setIcon(new ImageIcon(Search.class.getResource("/Icons/eliminar.jpg")));
        btnDelete.setBounds(395, 285, 72, 72);
        btnDelete.setBorder(new IconHelper(260));
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        if (SorD) {
            btnDelete.setVisible(false);
        }
        add(btnDelete);

        JLabel lblMore = new JLabel("Mas");
        lblMore.setHorizontalAlignment(SwingConstants.CENTER);
        lblMore.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMore.setBounds(291, 369, 62, 17);
        add(lblMore);

        JLabel lblDelete = new JLabel("Eliminar");
        lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
        lblDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDelete.setBounds(402, 367, 62, 17);
        if (SorD) {
            lblDelete.setVisible(false);
        }
        add(lblDelete);

        JComboBox cbmSearch = new JComboBox();
        cbmSearch.setModel(new DefaultComboBoxModel(new String[]{" ", "Nombre", "Cedula"}));
        cbmSearch.setMaximumRowCount(3);
        cbmSearch.setBounds(265, 236, 106, 20);
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
                    filler.clear();
                    fillFiller(filler, clinic.getListOfPatients());
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
                if (table.getSelectedRow() == -1) {
                    Validations.errorMessage("Seleccione un paciente\npara mostrar mas informacion");
                } else {
                	if (searchTxt.getText().isEmpty()) {
                		filler.clear();
                        fillFiller(filler, clinic.getListOfPatients());
                	} 
                    ModifPatient modifPatient = new ModifPatient(clinic, clinic.getListOfPatients().get(filler.get(table.getSelectedRow()).getListId()), table);
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
                ControlFields.fillTablePatient(table, filler);
            }
        }
    }

    public void delete(Clinic clinic) {
        for (Dentist dentist : clinic.getListOfStaff()) {
            if (clinic.getListOfPatients().get(filler.get(table.getSelectedRow()).getListId()).getAppointment().getDentist().getId() == dentist.getId()) {
                dentist.getListOfAppointments().remove(clinic.getListOfPatients().get(filler.get(table.getSelectedRow()).getListId()).getAppointment());
            }
        }
        for (Appointment appointment : clinic.getListOfAppointments()) {
            if (clinic.getListOfPatients().get(filler.get(table.getSelectedRow()).getListId()).getId() == appointment.getPatientId()) {
                clinic.getListOfAppointments().remove(appointment);
                DaoAppointmentsXML.deleteAppointment(clinic.getListOfPatients().get(filler.get(table.getSelectedRow()).getListId()).getId());
            }
        }

        DaoPatientXML.deletePatient(clinic.getListOfPatients().get(filler.get(table.getSelectedRow()).getListId()).getId());
        ControlFields.deletePatient(clinic, table, filler.get(table.getSelectedRow()).getListId());
        ControlFields.fillTablePatient(table, clinic.getListOfPatients());
        JOptionPane.showMessageDialog(null, "Paciente eliminado\nsatisfactoriamente!");
    }
    
    public static void fillFiller(ArrayList<Patient> filler, ArrayList<Patient> patients) {
    	for (int i = 0; i < patients.size(); i++) 
    		filler.add(patients.get(i));  	
    }
    
    public static void clearTxt() {
    	searchTxt.setText("");;
    }
}
