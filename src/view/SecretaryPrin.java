package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.IconHelper;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SecretaryPrin extends JFrame {

	private JPanel contentPane;

	
	public SecretaryPrin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 446);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CreateApointment apo = new CreateApointment();
		apo.setBounds(143, 0, 524, 407);
		contentPane.add(apo);
		apo.setVisible(false);
		
		JButton btnApointmen = new JButton("");
		btnApointmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				apo.setVisible(true);
			}
		});
		btnApointmen.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/Icons/Calendar-icon.jpg")));
		btnApointmen.setForeground(new Color(176, 224, 230));
		btnApointmen.setBackground(new Color(176, 224, 230));
		btnApointmen.setBounds(0, 40, 133, 123);
		btnApointmen.setBorder(new IconHelper(260));
		contentPane.add(btnApointmen);
		
		JButton btnPacients = new JButton("");
		btnPacients.setIcon(new ImageIcon(SecretaryPrin.class.getResource("/Icons/Search.jpg")));
		btnPacients.setForeground(new Color(176, 224, 230));
		btnPacients.setBorder(new IconHelper(260));
		btnPacients.setBackground(new Color(176, 224, 230));
		btnPacients.setBounds(0, 219, 133, 132);
		contentPane.add(btnPacients);
	}
}
