package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControlFields;
import model.Clinic;
import model.IconHelper;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	        btnAppointments.setBounds(24, 6, 79, 80);
	        btnAppointments.setBorder(new IconHelper(260));
	        btnAppointments.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        contentPane.add(btnAppointments);
	        
	        JPanel appointments = new JPanel();
	        appointments.setBackground(new Color(176, 224, 230));
	        appointments.setBounds(131, 0, 552, 430);
	        contentPane.add(appointments);
	        appointments.setLayout(null);
	        appointments.setVisible(true);
	        
	        Search PatientsList = new Search(clinic, true);		  // Perro explicame que este search
	        PatientsList.setBackground(new Color(176, 224, 230)); // y xq no es un JTable
	        PatientsList.setBounds(131, 0, 552, 430);
	        contentPane.add(PatientsList);
	        PatientsList.setLayout(null);
	        PatientsList.setVisible(false);
	        
	        JButton btnPatients = new JButton("");
	        btnPatients.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		appointments.setVisible(false);
	        		PatientsList.setVisible(true);
	        		ControlFields.fillTablePatient(PatientsList.getTable(), clinic.getListOfPatients());
	        	}
	        });
	        btnPatients.setIcon(new ImageIcon(DentistPrin.class.getResource("/icons/Addressbook-4-icon.png")));
	        btnPatients.setForeground(new Color(176, 224, 230));
	        btnPatients.setBackground(new Color(176, 224, 230));
	        btnPatients.setBorder(new IconHelper(260));
	        btnPatients.setBounds(24, 105, 79, 79);
	        btnPatients.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        contentPane.add(btnPatients);
	        
	        JButton btnInv = new JButton("");
	        btnInv.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	}
	        });
	        btnInv.setIcon(new ImageIcon(DentistPrin.class.getResource("/icons/Close-icon.png")));
	        btnInv.setForeground(new Color(176, 224, 230));
	        btnInv.setBackground(new Color(176, 224, 230));
	        btnInv.setBorder(new IconHelper(260));
	        btnInv.setBounds(24, 207, 78, 80);
	        btnInv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        contentPane.add(btnInv);
	        
	        JLabel lblSeeAppointments = new JLabel("Ver Citas");
	        lblSeeAppointments.setHorizontalAlignment(SwingConstants.CENTER);
	        lblSeeAppointments.setBounds(0, 86, 132, 14);
	        contentPane.add(lblSeeAppointments);
	        
	        JLabel lblSeePatients = new JLabel("Ver Pacientes");
	        lblSeePatients.setHorizontalAlignment(SwingConstants.CENTER);
	        lblSeePatients.setBounds(0, 187, 132, 14);
	        contentPane.add(lblSeePatients);
	        
	        JLabel lblSeeInv = new JLabel("Ver Inventario");
	        lblSeeInv.setHorizontalAlignment(SwingConstants.CENTER);
	        lblSeeInv.setBounds(0, 289, 132, 14);
	        contentPane.add(lblSeeInv);
	        
	        JButton btnLogOut = new JButton("");
	        btnLogOut.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		setVisible(false);
	        		Start logInFrame = new Start();
	        		logInFrame.setLocationRelativeTo(null);
	        		logInFrame.setVisible(true);
	        	}
	        });
	        btnLogOut.setIcon(new ImageIcon(DentistPrin.class.getResource("/icons/Arrow-inside-icon.png")));
	        btnLogOut.setForeground(new Color(176, 224, 230));
	        btnLogOut.setBorder(new IconHelper(260));
	        btnLogOut.setBackground(new Color(176, 224, 230));
	        btnLogOut.setBounds(45, 315, 39, 39);
	        btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        contentPane.add(btnLogOut);
	        
	        JLabel lblCambiar = new JLabel("Cambiar Usuario");
	        lblCambiar.setHorizontalAlignment(SwingConstants.CENTER);
	        lblCambiar.setBounds(0, 348, 132, 25);
	        contentPane.add(lblCambiar);
	        
	        JButton btnClose = new JButton("");
	        btnClose.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		int option = JOptionPane.showConfirmDialog(null, "Seguro que desea salir?", "Exit", JOptionPane.YES_NO_OPTION);
	        		if (option != 1)
	        			System.exit(0);
	        	}
	        });
	        btnClose.setIcon(new ImageIcon(DentistPrin.class.getResource("/icons/salir32.png")));
	        btnClose.setForeground(new Color(176, 224, 230));
	        btnClose.setBorder(new IconHelper(260));
	        btnClose.setBackground(new Color(176, 224, 230));
	        btnClose.setBounds(45, 374, 39, 35);
	        btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        contentPane.add(btnClose);
	        
	        JLabel lblSalir = new JLabel("Salir");
	        lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
	        lblSalir.setBounds(0, 411, 130, 16);
	        contentPane.add(lblSalir);
	}
}
