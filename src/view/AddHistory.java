package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import model.IconHelper;
import persistence.DaoPatientXML;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AddHistory extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AddHistory(Patient patient, JTextPane txtDisplayHistory) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE	);
		setBounds(100, 100, 540, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textArea.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
			}
		});
		textArea.setFont(new Font("Euphemia UCAS", Font.PLAIN, 15));
		textArea.setBounds(22, 31, 491, 214);
		textArea.setEditable(true);
		textArea.setBackground(Color.WHITE);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
		scrollPane.setBounds(25, 24, 485, 263);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(textArea);
		
		JButton btnConfirm = new JButton("");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textArea.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Para agregar contenido al historial \neste campo no puede estar vacio.");
				}else {
					int option = JOptionPane.showConfirmDialog(null, "Seguro que agregar \neste contenido al historial?", "Cancelar", JOptionPane.YES_NO_OPTION);
	                if (option != 1) {
	                	if (patient.getHistory().getTreatment().equalsIgnoreCase("Este paciente no contiene historial medico aun."))
	                		txtDisplayHistory.setText(textArea.getText());
	                	else 
	                		txtDisplayHistory.setText(txtDisplayHistory.getText() + "\n" + textArea.getText());
	                    patient.getHistory().setTreatment(txtDisplayHistory.getText());
	                    DaoPatientXML.deletePatient(patient.getId());
	                    DaoPatientXML.updatePatient(patient);
	                    JOptionPane.showMessageDialog(null, "Contenido agregado\nal historial exitosamente.");
	                    setVisible(false);
	                }
				}
			}
		});
		btnConfirm.setIcon(new ImageIcon(CreateRecipe.class.getResource("/icons/check2.jpg")));
		btnConfirm.setForeground(new Color(176, 224, 230));
		btnConfirm.setBorder(new IconHelper(260));
		btnConfirm.setBackground(new Color(176, 224, 230));
		btnConfirm.setBounds(183, 302, 58, 54);
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnConfirm);
		
		JLabel lblConfirm = new JLabel("Confirmar");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirm.setBounds(173, 359, 88, 20);
		contentPane.add(lblConfirm);
		
		JButton btnCancel = new JButton("");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setIcon(new ImageIcon(CreateRecipe.class.getResource("/icons/arrow-back-icon.png")));
		btnCancel.setForeground(new Color(176, 224, 230));
		btnCancel.setBorder(new IconHelper(260));
		btnCancel.setBackground(new Color(176, 224, 230));
		btnCancel.setBounds(283, 302, 58, 54);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnCancel);
		
		JLabel lblAtras = new JLabel("Atras");
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAtras.setBounds(277, 359, 70, 20);
		contentPane.add(lblAtras);
	}
}
