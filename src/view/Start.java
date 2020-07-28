package view;

import java.awt.BorderLayout;
import model.*;
import persistence.DaoDentistXML;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControlFields;

import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import persistence.DaoAppointmentsXML;

public class Start extends JFrame {

    private JPanel contentPane;

    Clinic clinic = new Clinic();
    Inventory inventory = new Inventory();
    DaoDentistXML dataDentist = new DaoDentistXML();
    DaoAppointmentsXML dataAppointment = new DaoAppointmentsXML();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Start logInFrame = new Start();
                    logInFrame.setLocationRelativeTo(null);
                    logInFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Start() {
    	
        DaoDentistXML.allDentist(clinic.getListOfStaff());
        DaoAppointmentsXML.allAppointments(clinic.getListOfAppointments());
        ControlFields.crateAppointmentLists(clinic);        
        ControlFields.assingAppointmentsDentist(clinic);
        
        //Test
        Appointment apo = new Appointment(clinic.getListOfStaff().get(1),"22/12/2000", "10 AM", "Murision",0);
        Patient test = new Patient("Gral Kenobi", 234, 30, "M", "Hello There", 2345, (Dentist) clinic.getListOfStaff().get(0), apo, null, null);
        Patient test2 = new Patient("Anakin", 235, 30, "M", "Hello There", 2345, (Dentist) clinic.getListOfStaff().get(0), apo, null, null);
        Patient test3 = new Patient("Gral Greivous", 237, 30, "M", "Hello There", 2345, (Dentist) clinic.getListOfStaff().get(0), apo, null, null);
        test.getAppointment().setPatientId(test.getId());
        test2.getAppointment().setPatientId(test2.getId());
        test3.getAppointment().setPatientId(test3.getId());
        clinic.getListOfPatients().add(test);
        clinic.getListOfPatients().add(test2);
        clinic.getListOfPatients().add(test3);
        //end of test
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 344);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 224, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnDentist = new JButton("");
        btnDentist.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SelectDentist select = new SelectDentist(clinic);
        		setVisible(false);
        		ControlFields.fillTableDentist(select.getDentistTable(), clinic);
        		select.setLocationRelativeTo(null);
        		select.setVisible(true);
        	}
        });
        btnDentist.setIcon(new ImageIcon(Start.class.getResource("/Icons/Odon.jpg")));
        btnDentist.setForeground(new Color(176, 224, 230));
        btnDentist.setBackground(new Color(176, 224, 230));
        btnDentist.setBounds(72, 99, 124, 144);
        btnDentist.setBorder(new IconHelper(260));
        btnDentist.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(btnDentist);

        JButton btnSecretary = new JButton("");
        btnSecretary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                SecretaryPrin secretaryFrame = new SecretaryPrin(clinic);
                setVisible(false);
                secretaryFrame.setLocationRelativeTo(null);
                secretaryFrame.setVisible(true);
                ControlFields.fillTableDentist(secretaryFrame.getAppointmentPanel().getDentistTable(), clinic);
            }
        });
        btnSecretary.setIcon(new ImageIcon(Start.class.getResource("/Icons/Secretaris.jpg")));
        btnSecretary.setBackground(new Color(176, 224, 230));
        btnSecretary.setForeground(new Color(176, 224, 230));
        btnSecretary.setBounds(263, 99, 133, 144);
        btnSecretary.setBorder(new IconHelper(260));
        btnSecretary.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(btnSecretary);

        JLabel lblNewLabel = new JLabel("Odontologo");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(42, 255, 170, 30);
        contentPane.add(lblNewLabel);

        JLabel lblSecretaria = new JLabel("Secretaria");
        lblSecretaria.setHorizontalAlignment(SwingConstants.CENTER);
        lblSecretaria.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSecretaria.setBounds(230, 255, 190, 28);
        contentPane.add(lblSecretaria);

        JLabel lblNewLabel_1 = new JLabel("Seleccione un Usuario");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 24, 450, 33);
        contentPane.add(lblNewLabel_1);
    }
}
