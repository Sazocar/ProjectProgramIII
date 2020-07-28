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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SecretaryPrin extends JFrame {

    private JPanel contentPane;
    private CreateApointment appointmentPanel;

    public SecretaryPrin(Clinic clinic) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 683, 462);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 224, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        appointmentPanel = new CreateApointment(clinic);
        appointmentPanel.setBounds(143, 0, 540, 440);
        contentPane.add(appointmentPanel);
        appointmentPanel.setVisible(true);

        Search searchPanel = new Search(clinic, false);
        searchPanel.setBounds(143, 0, 540, 440);
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
        btnAppointment.setBounds(0, 25, 144, 123);
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
        btnPatients.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/icons/Addressbook-4-icon (128).png")));
        btnPatients.setForeground(new Color(176, 224, 230));
        btnPatients.setBorder(new IconHelper(260));
        btnPatients.setBackground(new Color(176, 224, 230));
        btnPatients.setBounds(0, 172, 144, 132);
        btnPatients.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(btnPatients);
        
        JButton btnLogOut = new JButton("");
        btnLogOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		Start logInFrame = new Start();
        		logInFrame.setLocationRelativeTo(null);
        		logInFrame.setVisible(true);
        	}
        });
        btnLogOut.setForeground(new Color(176, 224, 230));
        btnLogOut.setBackground(new Color(176, 224, 230));
        btnLogOut.setBorder(new IconHelper(260));
        btnLogOut.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/icons/Arrow-inside-icon.png")));
        btnLogOut.setBounds(52, 315, 36, 36);
        btnLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(btnLogOut);
        
        JLabel lblCrearCita = new JLabel("Crear Cita");
        lblCrearCita.setHorizontalAlignment(SwingConstants.CENTER);
        lblCrearCita.setBounds(0, 6, 144, 16);
        contentPane.add(lblCrearCita);
        
        JLabel lblVerListaDe = new JLabel("Ver lista de Pacientes");
        lblVerListaDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblVerListaDe.setBounds(0, 153, 144, 16);
        contentPane.add(lblVerListaDe);
        
        JLabel lblCambiar = new JLabel("Cambiar Usuario");
        lblCambiar.setBounds(0, 349, 144, 25);
        contentPane.add(lblCambiar);
        lblCambiar.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton btnClose = new JButton("");
        btnClose.setBounds(52, 378, 39, 35);
        contentPane.add(btnClose);
        btnClose.setForeground(new Color(176, 224, 230));
        btnClose.setBackground(new Color(176, 224, 230));
        btnClose.setBorder(new IconHelper(260));
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		int option = JOptionPane.showConfirmDialog(null, "Seguro que desea salir?", "Exit", JOptionPane.YES_NO_OPTION);
        		if (option != 1)
        			System.exit(0);
        	}
        });
        btnClose.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/icons/salir32.png")));
        btnClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        JLabel lblSalir = new JLabel("Salir");
        lblSalir.setBounds(0, 418, 144, 16);
        contentPane.add(lblSalir);
        lblSalir.setHorizontalAlignment(SwingConstants.CENTER);
    }

	public CreateApointment getAppointmentPanel() {
		return appointmentPanel;
	}

	public void setAppointmentPanel(CreateApointment appointmentPanel) {
		this.appointmentPanel = appointmentPanel;
	}
    
    
}
