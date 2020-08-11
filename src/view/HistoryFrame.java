package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class HistoryFrame extends JFrame {

	private JPanel contentPane;
	private JTextPane txtDisplayHistory;	

	/**
	 * Create the frame.
	 */
	public HistoryFrame(Patient patient) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Paciente:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(56, 71, 59, 23);
		contentPane.add(lblName);
		
		JLabel displayName = new JLabel(patient.getName());
		displayName.setHorizontalAlignment(SwingConstants.LEFT);
		displayName.setBounds(130, 71, 152, 23);
		contentPane.add(displayName);
		
		JLabel lblId = new JLabel("Cedula:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(61, 101, 49, 19);
		contentPane.add(lblId);
		
		JLabel displayId = new JLabel(Integer.toString(patient.getId()));
		displayId.setHorizontalAlignment(SwingConstants.LEFT);
		displayId.setBounds(130, 106, 152, 14);
		contentPane.add(displayId);
		
		JLabel lblSex = new JLabel("Sexo: ");
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setBounds(75, 132, 38, 14);
		contentPane.add(lblSex);
		
		JLabel displaySex = new JLabel(patient.getSex());
		displaySex.setHorizontalAlignment(SwingConstants.LEFT);
		displaySex.setBounds(125, 132, 59, 14);
		contentPane.add(displaySex);
		
		JLabel lblAddress = new JLabel("Direccion:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(37, 158, 76, 20);
		contentPane.add(lblAddress);
		
		JLabel displayAddress = new JLabel(patient.getAddress());
		displayAddress.setHorizontalAlignment(SwingConstants.LEFT);
		displayAddress.setBounds(123, 158, 209, 20);
		contentPane.add(displayAddress);
		
		JLabel lblAge = new JLabel("Edad:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(57, 188, 59, 14);
		contentPane.add(lblAge);
		
		JLabel displayAge = new JLabel(Integer.toString(patient.getAge()));
		displayAge.setHorizontalAlignment(SwingConstants.LEFT);
		displayAge.setBounds(128, 188, 33, 14);
		contentPane.add(displayAge);
		
		JLabel lblNumeroDeTlfn = new JLabel("Numero de Tlfn:");
		lblNumeroDeTlfn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeTlfn.setBounds(10, 216, 107, 14);
		contentPane.add(lblNumeroDeTlfn);
		
		JLabel displayPhone = new JLabel(Integer.toString(patient.getPhoneNumber()));
		displayPhone.setHorizontalAlignment(SwingConstants.LEFT);
		displayPhone.setBounds(129, 216, 161, 14);
		contentPane.add(displayPhone);
		
		JLabel lblPic = new JLabel("");
		lblPic.setIcon(new ImageIcon(HistoryFrame.class.getResource("/icons/Addressbook-3-icon.png")));
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setBounds(344, 79, 143, 138);
		contentPane.add(lblPic);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon(HistoryFrame.class.getResource("/icons/arrow-back-icon.png")));
		btnBack.setForeground(new Color(176, 224, 230));
		btnBack.setBorder(new IconHelper(260));
		btnBack.setBackground(new Color(176, 224, 230));
		btnBack.setBounds(321, 571, 59, 51);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("HISTORIAL MEDICO");
		lblNewLabel.setFont(new Font("PT Sans Caption", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 16, 539, 43);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
		scrollPane.getViewport().setBackground(new Color(176, 224, 230));
		scrollPane.setBounds(37, 253, 473, 307);		
		
		this.txtDisplayHistory = new JTextPane();
		this.txtDisplayHistory.setFont(new Font("Hiragino Sans", Font.PLAIN, 15));
		this.txtDisplayHistory.setEditable(false);
		this.txtDisplayHistory.setBounds(37, 283, 459, 181);
		this.txtDisplayHistory.setBackground(new Color(176, 224, 230));
		this.txtDisplayHistory.setText(patient.getHistory().getTreatment());
		this.txtDisplayHistory.setCaretPosition(0);
		this.txtDisplayHistory.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		scrollPane.setViewportView(txtDisplayHistory);
		
		contentPane.add(scrollPane);
		
		JButton btnAddHistory = new JButton("");
		btnAddHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddHistory addHistoryFrame = new AddHistory(patient, txtDisplayHistory);
				addHistoryFrame.setVisible(true);
			}
		});
		btnAddHistory.setIcon(new ImageIcon(HistoryFrame.class.getResource("/icons/pencil-icon.png")));
		btnAddHistory.setForeground(new Color(176, 224, 230));
		btnAddHistory.setBorder(new IconHelper(260));
		btnAddHistory.setBackground(new Color(176, 224, 230));
		btnAddHistory.setBounds(75, 571, 59, 51);
		btnAddHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnAddHistory);
		
		JLabel lblAddHistory = new JLabel("Agregar a la Historia");
		lblAddHistory.setBounds(138, 587, 134, 16);
		contentPane.add(lblAddHistory);
		
		JLabel lblAtras = new JLabel("Atras");
		lblAtras.setBounds(386, 587, 59, 16);
		contentPane.add(lblAtras);
		
		
	}

	public JTextPane getTxtDisplayHistory() {
		return txtDisplayHistory;
	}

	public void setTxtDisplayHistory(JTextPane txtDisplayHistory) {
		this.txtDisplayHistory = txtDisplayHistory;
	}
}
