package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.IconHelper;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CreateApointment extends JPanel {
	private JTextField nameTxt;
	private JTextField idTxt;
	private JTextField ageTxt;
	private JTextField adressTxt;
	private JTextField numberTxt;
	private JTable table;
	private JTextField dateTxt;
	private JTextField textField;

	
	public CreateApointment() {
		setBackground(new Color(176, 224, 230));
		setLayout(null);
		
		JLabel lblName = new JLabel("Nombre: ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(44, 34, 67, 20);
		add(lblName);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(121, 34, 114, 20);
		add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblID = new JLabel("Cedula:");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setBounds(44, 89, 67, 20);
		add(lblID);
		
		idTxt = new JTextField();
		idTxt.setColumns(10);
		idTxt.setBounds(121, 89, 114, 20);
		add(idTxt);
		
		JLabel lblAge = new JLabel("Edad:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAge.setBounds(44, 137, 67, 20);
		add(lblAge);
		
		ageTxt = new JTextField();
		ageTxt.setBounds(121, 139, 37, 20);
		add(ageTxt);
		ageTxt.setColumns(10);
		
		JLabel lblSex = new JLabel("Sexo:");
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSex.setBounds(44, 184, 67, 20);
		add(lblSex);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(2);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox.setBounds(121, 186, 37, 20);
		add(comboBox);
		
		JLabel lblAdress = new JLabel("Direccion:");
		lblAdress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAdress.setBounds(22, 225, 89, 20);
		add(lblAdress);
		
		adressTxt = new JTextField();
		adressTxt.setColumns(10);
		adressTxt.setBounds(121, 227, 114, 20);
		add(adressTxt);
		
		JLabel lblNumeroDeTelefono = new JLabel("Numero de tlfn:");
		lblNumeroDeTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDeTelefono.setBounds(0, 269, 114, 20);
		add(lblNumeroDeTelefono);
		
		numberTxt = new JTextField();
		numberTxt.setColumns(10);
		numberTxt.setBounds(121, 271, 114, 20);
		add(numberTxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(285, 22, 212, 145);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JLabel lblAviliable = new JLabel("Odontologos Disponibles");
		lblAviliable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAviliable.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviliable.setBounds(285, 177, 202, 35);
		add(lblAviliable);
		
		JButton btnConfirm = new JButton("");
		btnConfirm.setForeground(new Color(176, 224, 230));
		btnConfirm.setBackground(new Color(176, 224, 230));
		btnConfirm.setBorder(new IconHelper(260));
		btnConfirm.setIcon(new ImageIcon(CreateApointment.class.getResource("/Icons/check.jpg")));
		btnConfirm.setBounds(44, 325, 72, 72);
		add(btnConfirm);
		
		JButton btnCancel = new JButton("");
		btnCancel.setIcon(new ImageIcon(CreateApointment.class.getResource("/Icons/back.jpg")));
		btnCancel.setForeground(new Color(176, 224, 230));
		btnCancel.setBorder(new IconHelper(260));
		btnCancel.setBackground(new Color(176, 224, 230));
		btnCancel.setBounds(163, 325, 72, 72);
		add(btnCancel);
		
		JLabel lblDate = new JLabel("Fecha:");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDate.setBounds(245, 230, 89, 20);
		add(lblDate);
		
		dateTxt = new JTextField();
		dateTxt.setBounds(344, 232, 89, 20);
		add(dateTxt);
		dateTxt.setColumns(10);
		
		JLabel lblHour = new JLabel("Hora:");
		lblHour.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHour.setBounds(245, 269, 89, 20);
		add(lblHour);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "9 AM", "10 AM", "11 AM", "2 PM", "3 PM", "4 PM", "5 PM"}));
		comboBox_1.setBounds(354, 271, 49, 20);
		add(comboBox_1);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMotivo.setBounds(245, 312, 89, 20);
		add(lblMotivo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(344, 314, 153, 20);
		add(textField);

	}
}
