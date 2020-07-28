package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControlFields;
import model.Clinic;
import model.IconHelper;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DentistPrin extends JFrame {

	private JPanel contentPane;

	public DentistPrin(Clinic clinic) {
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 683, 452);
	        contentPane = new JPanel();
	        contentPane.setBackground(new Color(176, 224, 230));
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
	        
	        JButton btnAppointments = new JButton("");
	        btnAppointments.setIcon(new ImageIcon(DentistPrin.class.getResource("/icons/Files-2-icon.png")));
	        btnAppointments.setForeground(new Color(176, 224, 230));
	        btnAppointments.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        btnAppointments.setBackground(new Color(176, 224, 230));
	        btnAppointments.setBounds(21, 11, 86, 86);
	        btnAppointments.setBorder(new IconHelper(260));
	        contentPane.add(btnAppointments);
	        
	        JPanel appointments = new JPanel();
	        appointments.setBackground(new Color(176, 224, 230));
	        appointments.setBounds(131, 0, 536, 413);
	        contentPane.add(appointments);
	        appointments.setLayout(null);
	        appointments.setVisible(true);
	        
	        Search PatientsList = new Search(clinic, true);
	        PatientsList.setBackground(new Color(176, 224, 230));
	        PatientsList.setBounds(131, 0, 536, 413);
	        contentPane.add(PatientsList);
	        PatientsList.setLayout(null);
	        PatientsList.setVisible(false);
	        
	        JButton btnPacients = new JButton("");
	        btnPacients.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		appointments.setVisible(false);
	        		PatientsList.setVisible(true);
	        		ControlFields.fillTablePatient(PatientsList.getTable(), clinic.getListOfPatients());
	        	}
	        });
	        btnPacients.setIcon(new ImageIcon(DentistPrin.class.getResource("/icons/Addressbook-4-icon.png")));
	        btnPacients.setForeground(new Color(176, 224, 230));
	        btnPacients.setBackground(new Color(176, 224, 230));
	        btnPacients.setBorder(new IconHelper(260));
	        btnPacients.setBounds(21, 134, 86, 86);
	        contentPane.add(btnPacients);
	        
	        JButton btnInv = new JButton("");
	        btnInv.setIcon(new ImageIcon(DentistPrin.class.getResource("/icons/Close-icon.png")));
	        btnInv.setForeground(new Color(176, 224, 230));
	        btnInv.setBackground(new Color(176, 224, 230));
	        btnInv.setBorder(new IconHelper(260));
	        btnInv.setBounds(21, 256, 86, 86);
	        contentPane.add(btnInv);
	        
	        JLabel lblSeeAppointments = new JLabel("Ver Citas");
	        lblSeeAppointments.setHorizontalAlignment(SwingConstants.CENTER);
	        lblSeeAppointments.setBounds(10, 108, 111, 14);
	        contentPane.add(lblSeeAppointments);
	        
	        JLabel lblSeePatients = new JLabel("Ver Pacientes");
	        lblSeePatients.setHorizontalAlignment(SwingConstants.CENTER);
	        lblSeePatients.setBounds(10, 231, 111, 14);
	        contentPane.add(lblSeePatients);
	        
	        JLabel lblSeeInv = new JLabel("Ver Inventario");
	        lblSeeInv.setHorizontalAlignment(SwingConstants.CENTER);
	        lblSeeInv.setBounds(10, 355, 111, 14);
	        contentPane.add(lblSeeInv);
	}
}
