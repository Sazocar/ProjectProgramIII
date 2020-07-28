package view;

import javax.swing.JPanel;
import java.awt.Color;
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
import model.Patient;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ViewAppointments extends JPanel {
	private JTable table;
	private JTextField searchTxt;

	
	public ViewAppointments(Clinic clinic) {
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
        
        JButton btnNewButton = new JButton("New button");
        btnNewButton.setBounds(221, 274, 89, 75);
        add(btnNewButton);
        table.getTableHeader().setReorderingAllowed(false); // prevent user to drag column
        table.getTableHeader().setEnabled(false);		  // tableHeader not resizable
        table.setDefaultEditor(Object.class, null);		  // column not editable
        
        
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
            }
        }
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	
	
}
