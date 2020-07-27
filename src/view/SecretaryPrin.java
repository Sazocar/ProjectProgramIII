package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControlFields;
import controller.ControlSecretary;
import model.*;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SecretaryPrin extends JFrame {

    private JPanel contentPane;

    public SecretaryPrin(Clinic clinic) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 683, 446);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 224, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        CreateApointment appointmentPanel = new CreateApointment(clinic);
        appointmentPanel.setBounds(143, 0, 540, 424);
        contentPane.add(appointmentPanel);
        appointmentPanel.setVisible(false);

        Search searchPanel = new Search(clinic);
        searchPanel.setBounds(143, 0, 540, 424);
        contentPane.add(searchPanel);
        searchPanel.setVisible(false);

        JButton btnAppointment = new JButton("");
        btnAppointment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                searchPanel.setVisible(false);
                appointmentPanel.setVisible(true);
                ControlFields.fillTableDentist(appointmentPanel.getDentistTable(), clinic);
            }
        });
        btnAppointment.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/Icons/Calendar-icon.jpg")));
        btnAppointment.setForeground(new Color(176, 224, 230));
        btnAppointment.setBackground(new Color(176, 224, 230));
        btnAppointment.setBounds(0, 26, 144, 123);
        btnAppointment.setBorder(new IconHelper(260));
        btnAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(btnAppointment);

        JButton btnPatients = new JButton("");
        btnPatients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appointmentPanel.setVisible(false);
                ControlFields.fillTablePatient(searchPanel.getTable(), clinic.getListOfPatients());
                searchPanel.setVisible(true);
            }
        });
        btnPatients.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/Icons/Search.jpg")));
        btnPatients.setForeground(new Color(176, 224, 230));
        btnPatients.setBorder(new IconHelper(260));
        btnPatients.setBackground(new Color(176, 224, 230));
        btnPatients.setBounds(0, 171, 144, 132);
        btnPatients.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(btnPatients);
        
        JButton btnClose = new JButton("");
        btnClose.setForeground(new Color(176, 224, 230));
        btnClose.setBackground(new Color(176, 224, 230));
        btnClose.setBorder(new IconHelper(260));
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		setVisible(false);
        	}
        });
        btnClose.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/icons/salir32.png")));
        btnClose.setBounds(23, 346, 36, 35);
        contentPane.add(btnClose);
        
        JButton btnLogOut = new JButton("");
        btnLogOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		Start reset = new Start();
        		reset.setVisible(true);
        	}
        });
        btnLogOut.setForeground(new Color(176, 224, 230));
        btnLogOut.setBackground(new Color(176, 224, 230));
        btnLogOut.setBorder(new IconHelper(260));
        btnLogOut.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/icons/logOut32.png")));
        btnLogOut.setBounds(80, 346, 36, 36);
        contentPane.add(btnLogOut);
    }
}
