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

        Search searchPanel = new Search();
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
        btnAppointment.setBounds(0, 40, 144, 123);
        btnAppointment.setBorder(new IconHelper(260));
        btnAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(btnAppointment);

        JButton btnPatients = new JButton("");
        btnPatients.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appointmentPanel.setVisible(false);
                searchPanel.setVisible(true);
            }
        });
        btnPatients.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/Icons/Search.jpg")));
        btnPatients.setForeground(new Color(176, 224, 230));
        btnPatients.setBorder(new IconHelper(260));
        btnPatients.setBackground(new Color(176, 224, 230));
        btnPatients.setBounds(0, 219, 144, 132);
        btnPatients.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(btnPatients);
    }
}
