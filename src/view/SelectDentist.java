package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 278);
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
        dentistTable.setDefaultEditor(Object.class, null);		  // column not editable
        
        JButton btnConfirm = new JButton("");
        btnConfirm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DentistPrin dentistFrame = new DentistPrin(clinic,(Dentist) clinic.getListOfStaff().get(dentistTable.getSelectedRow()));
        		dentistFrame.setLocationRelativeTo(null);
        		dentistFrame.setVisible(true);
        		setVisible(false);
        		if (clinic.getListOfStaff().get(dentistTable.getSelectedRow()).getListOfAppointments().isEmpty()) {
        			dentistFrame.getAppointments().setVisible(false);
        			dentistFrame.getPatientsList().setVisible(true);
        			ControlFields.fillTablePatient(dentistFrame.getPatientsList().getTable(), clinic.getListOfPatients());
        		}
        		else {
        			ControlFields.fillTableAppointments(dentistFrame.getAppointments().getTable(), clinic.getListOfPatients(), clinic.getListOfStaff().get(dentistTable.getSelectedRow()));
        		}
        	}
        });
        btnConfirm.setForeground(new Color(176, 224, 230));
        btnConfirm.setBackground(new Color(176, 224, 230));
        btnConfirm.setBorder(new IconHelper(260));
        btnConfirm.setIcon(new ImageIcon(CreateApointment.class.getResource("/Icons/check.jpg")));
        btnConfirm.setBounds(75, 129, 72, 72);
        btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(btnConfirm);
        
        JLabel lblAcept = new JLabel("Aceptar");
        lblAcept.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAcept.setHorizontalAlignment(SwingConstants.CENTER);
        lblAcept.setBounds(75, 212, 72, 16);
        contentPane.add(lblAcept);
        
        JButton btnBack = new JButton("");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		setVisible(false);
        		Start start = new Start();
        		start.setLocationRelativeTo(null);
        		start.setVisible(true);
        		
        	}
        });
        btnBack.setIcon(new ImageIcon(SelectDentist.class.getResource("/icons/back.jpg")));
        btnBack.setForeground(new Color(176, 224, 230));
        btnBack.setBorder(new IconHelper(260));
        btnBack.setBackground(new Color(176, 224, 230));
        btnBack.setBounds(195, 129, 72, 72);
        contentPane.add(btnBack);
        
        JLabel lblBack = new JLabel("Volver");
        lblBack.setHorizontalAlignment(SwingConstants.CENTER);
        lblBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblBack.setBounds(195, 212, 82, 16);
        contentPane.add(lblBack);
	}


	public JTable getDentistTable() {
		return dentistTable;
	}


	public void setDentistTable(JTable dentistTable) {
		this.dentistTable = dentistTable;
	}
	
	
}
	

