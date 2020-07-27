package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.*;

import java.awt.Color;
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
		
		JButton btnApointmen = new JButton("");
		btnApointmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchPanel.setVisible(false);
				appointmentPanel.setVisible(true);
			}
		});
		btnApointmen.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/Icons/Calendar-icon.jpg")));
		btnApointmen.setForeground(new Color(176, 224, 230));
		btnApointmen.setBackground(new Color(176, 224, 230));
		btnApointmen.setBounds(0, 40, 144, 123);
		btnApointmen.setBorder(new IconHelper(260));
		contentPane.add(btnApointmen);
		
		JButton btnPacients = new JButton("");
		btnPacients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appointmentPanel.setVisible(false);
				searchPanel.setVisible(true);
			}
		});
		btnPacients.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/Icons/Search.jpg")));
		btnPacients.setForeground(new Color(176, 224, 230));
		btnPacients.setBorder(new IconHelper(260));
		btnPacients.setBackground(new Color(176, 224, 230));
		btnPacients.setBounds(0, 219, 144, 132);
		contentPane.add(btnPacients);
	}
}
