package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControlFields;
import controller.ControlSecretary;
import excepciones.Validations;
import model.Clinic;
import model.Dentist;
import model.IconHelper;
import model.Patient;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SelectDentist extends JFrame {

	private JPanel contentPane;
	private JTable dentistTable;


	public SelectDentist(Clinic clinic ) {
		
		ArrayList<Patient> patientsInAppointments = new ArrayList<Patient>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 255);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 11, 310, 107);
        getContentPane().add(scrollPane);

        dentistTable = new JTable();
        dentistTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        	}
        ));
        scrollPane.setViewportView(dentistTable);
        dentistTable.getTableHeader().setReorderingAllowed(false); // prevent user to drag column
        dentistTable.getTableHeader().setEnabled(false);		  // tableHeader not resizable
        dentistTable.setDefaultEditor(Object.class, null);
        
        JButton btnConfirm = new JButton("Aceptar");
        btnConfirm.setBounds(10, 183, 89, 23);
        btnConfirm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (dentistTable.getSelectedRow() == -1) {
        			Validations.errorMessage("Debe seleccionar un odontologo para poder continuar");
        		}
        		else {
	        		DentistPrin dentistFrame = new DentistPrin(clinic,(Dentist) clinic.getListOfStaff().get(dentistTable.getSelectedRow()), patientsInAppointments);
	        		dentistFrame.setLocationRelativeTo(null);
	        		dentistFrame.setVisible(true);
	        		setVisible(false);
	        		if (clinic.getListOfStaff().get(dentistTable.getSelectedRow()).getListOfAppointments().isEmpty()) {
	        			dentistFrame.getAppointments().setVisible(false);
	        			dentistFrame.getPatientsList().setVisible(true);
	        			ControlFields.fillTablePatient(dentistFrame.getPatientsList().getTable(), clinic.getListOfPatients());
	        		}
	        		else {
	        			ControlFields.firstFillTableAppointments(dentistFrame.getAppointments().getTable(), clinic.getListOfPatients(), clinic.getListOfStaff().get(dentistTable.getSelectedRow()), patientsInAppointments);
	        		}
        	}
        	}
        });
        contentPane.add(btnConfirm);
        
        JLabel lblInfo = new JLabel("Seleccione o cree un nuevo Odontologo");
        lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
        lblInfo.setBounds(21, 131, 300, 14);
        contentPane.add(lblInfo);
        
        JButton btnNew = new JButton("Nuevo");
        btnNew.setBounds(122, 183, 89, 23);
        contentPane.add(btnNew);
        
        JButton btnBack = new JButton("Atras");
        btnBack.setBounds(242, 183, 89, 23);
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		setVisible(false);
        		Start start = new Start();
        		start.setLocationRelativeTo(null);
        		start.setVisible(true);
        		
        	}
        });
        contentPane.add(btnBack);
        
	}


	public JTable getDentistTable() {
		return dentistTable;
	}


	public void setDentistTable(JTable dentistTable) {
		this.dentistTable = dentistTable;
	}
	
}
	

