package view;

import java.awt.BorderLayout;
import model.*;
import persistence.DaoDentistXML;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start extends JFrame {

	private JPanel contentPane;
	
	Clinic clinic = new Clinic();
	Inventory inventory = new Inventory();
	DaoDentistXML dataDentist = new DaoDentistXML();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDentist = new JButton("");
		btnDentist.setIcon(new ImageIcon(Start.class.getResource("/Icons/Odon.jpg")));
		btnDentist.setForeground(new Color(176, 224, 230));
		btnDentist.setBackground(new Color(176, 224, 230));
		btnDentist.setBounds(10, 60, 190, 183);
		btnDentist.setBorder(new IconHelper(260));
		contentPane.add(btnDentist);
		
		JButton btnSecretary = new JButton("");
		btnSecretary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SecretaryPrin secretaryFrame = new SecretaryPrin(clinic);
				setVisible(false);
				secretaryFrame.setVisible(true);
			}
		});
		btnSecretary.setIcon(new ImageIcon(Start.class.getResource("/Icons/Secretaris.jpg")));
		btnSecretary.setBackground(new Color(176, 224, 230));
		btnSecretary.setForeground(new Color(176, 224, 230));
		btnSecretary.setBounds(244, 60, 190, 183);
		btnSecretary.setBorder(new IconHelper(260));
		contentPane.add(btnSecretary);
		
		JLabel lblNewLabel = new JLabel("Odontologo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 264, 170, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblSecretaria = new JLabel("Secretaria");
		lblSecretaria.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecretaria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSecretaria.setBounds(244, 266, 190, 28);
		contentPane.add(lblSecretaria);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione un Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 414, 33);
		contentPane.add(lblNewLabel_1);
	}
}
