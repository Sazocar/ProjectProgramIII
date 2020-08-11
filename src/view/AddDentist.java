package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControlFields;
import controller.ControllerDentist;
import excepciones.Validations;
import model.Clinic;
import model.IconHelper;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDentist extends JFrame {

	private JPanel contentPane;
	private JTextField nameTxt;
    private JTextField idTxt;
    private JTextField ageTxt;
    private JTextField addressTxt;
    private JTextField phoneNumberTxt;
    private JTextField SpecialityTxt;

	public AddDentist(Clinic clinic, JTable table) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 418);
                                   setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Nombre: ");
        lblName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName.setBounds(0, 34, 111, 20);
        getContentPane().add(lblName);

        nameTxt = new JTextField();
        nameTxt.setBounds(121, 34, 137, 20);
        getContentPane().add(nameTxt);
        nameTxt.setColumns(10);

        JLabel lblID = new JLabel("Cedula:");
        lblID.setHorizontalAlignment(SwingConstants.RIGHT);
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblID.setBounds(0, 73, 111, 20);
        getContentPane().add(lblID);

        idTxt = new JTextField();
        idTxt.setColumns(10);
        idTxt.setBounds(121, 73, 137, 20);
        getContentPane().add(idTxt);

        JLabel lblAge = new JLabel("Edad:");
        lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAge.setBounds(0, 107, 111, 20);
        getContentPane().add(lblAge);

        ageTxt = new JTextField();
        ageTxt.setBounds(121, 109, 46, 20);
        getContentPane().add(ageTxt);
        ageTxt.setColumns(10);

        JLabel lblSex = new JLabel("Sexo:");
        lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSex.setBounds(0, 149, 111, 20);
        getContentPane().add(lblSex);

        JComboBox sexBox = new JComboBox();
        sexBox.setMaximumRowCount(2);
        sexBox.setModel(new DefaultComboBoxModel(new String[]{"M", "F"}));
        sexBox.setBounds(121, 151, 72, 20);
        getContentPane().add(sexBox);

        JLabel lblAddress = new JLabel("Direccion:");
        lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAddress.setBounds(0, 190, 111, 20);
        getContentPane().add(lblAddress);

        addressTxt = new JTextField();
        addressTxt.setColumns(10);
        addressTxt.setBounds(114, 191, 172, 20);
        getContentPane().add(addressTxt);

        JLabel lblPhoneNumber = new JLabel("Numero de tlfn:");
        lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPhoneNumber.setBounds(0, 234, 111, 20);
        getContentPane().add(lblPhoneNumber);

        phoneNumberTxt = new JTextField();
        phoneNumberTxt.setColumns(10);
        phoneNumberTxt.setBounds(114, 236, 137, 20);
        getContentPane().add(phoneNumberTxt);
        
        JLabel lblSpeciality = new JLabel("Especialidad:");
        lblSpeciality.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSpeciality.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSpeciality.setBounds(0, 275, 111, 20);
        contentPane.add(lblSpeciality);
        
        SpecialityTxt = new JTextField();
        SpecialityTxt.setColumns(10);
        SpecialityTxt.setBounds(114, 277, 172, 20);
        contentPane.add(SpecialityTxt);
        
        JLabel lblShift = new JLabel("Turno:");
        lblShift.setHorizontalAlignment(SwingConstants.RIGHT);
        lblShift.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblShift.setBounds(0, 312, 111, 20);
        contentPane.add(lblShift);
        
        JComboBox cbmShift = new JComboBox();
        cbmShift.setModel(new DefaultComboBoxModel(new String[] {"", "Manana", "Tarde", "Noche"}));
        cbmShift.setMaximumRowCount(4);
        cbmShift.setBounds(114, 314, 111, 20);
        contentPane.add(cbmShift);
        
        JButton btnConfirm = new JButton("");
        btnConfirm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if ((Validations.validateName(nameTxt)) && (Validations.validateId(idTxt)) && (Validations.validateAge(ageTxt))
                        && (Validations.validateAddress(addressTxt)) && (Validations.validatePhoneNumber(phoneNumberTxt))
                        && (Validations.validateName(SpecialityTxt))) {
        			ControllerDentist.createNewDentist(nameTxt, idTxt, ageTxt, sexBox, addressTxt, phoneNumberTxt, SpecialityTxt, cbmShift, clinic.getListOfStaff());
        			JOptionPane.showMessageDialog(null, "Odontologo Guardado");
        			ControlFields.fillTableDentist(table, clinic);
        			setVisible(false);
        		}
        	}
        });
        btnConfirm.setForeground(new Color(176, 224, 230));
        btnConfirm.setBackground(new Color(176, 224, 230));
        btnConfirm.setBorder(new IconHelper(260));
        btnConfirm.setIcon(new ImageIcon(CreateApointment.class.getResource("/Icons/check.jpg")));
        btnConfirm.setBounds(338, 34, 72, 72);
        btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        getContentPane().add(btnConfirm);
        
        JButton btnCancel = new JButton("");
        btnCancel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
        btnCancel.setIcon(new ImageIcon(CreateApointment.class.getResource("/Icons/back.jpg")));
        btnCancel.setForeground(new Color(176, 224, 230));
        btnCancel.setBorder(new IconHelper(260));
        btnCancel.setBackground(new Color(176, 224, 230));
        btnCancel.setBounds(338, 275, 72, 72);
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        getContentPane().add(btnCancel);
        
        JLabel lblConfirm = new JLabel("Confirmar");
        lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
        lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblConfirm.setBounds(330, 109, 88, 20);
        contentPane.add(lblConfirm);
        
        JLabel lblCancelar = new JLabel("Cancelar");
        lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
        lblCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCancelar.setBounds(330, 348, 88, 20);
        contentPane.add(lblCancelar);
        
        JButton btnWipe = new JButton("");
        btnWipe.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ControlFields.clearFieldsDentist(nameTxt, idTxt, ageTxt, sexBox, addressTxt, phoneNumberTxt, SpecialityTxt, cbmShift);
        	}
        });
        btnWipe.setIcon(new ImageIcon(AddDentist.class.getResource("/icons/eliminar.jpg")));
        btnWipe.setForeground(new Color(176, 224, 230));
        btnWipe.setBorder(new IconHelper(260));
        btnWipe.setBackground(new Color(176, 224, 230));
        btnWipe.setBounds(338, 161, 72, 72);
        btnWipe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        contentPane.add(btnWipe);
        
        JLabel lblWipe = new JLabel("Limpiar Campos");
        lblWipe.setHorizontalAlignment(SwingConstants.CENTER);
        lblWipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWipe.setBounds(306, 234, 130, 20);
        contentPane.add(lblWipe);
	}
}
