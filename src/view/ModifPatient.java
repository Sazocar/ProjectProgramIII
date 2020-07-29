package view;

import com.placeholder.PlaceHolder;
import controller.ControlFields;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.*;
import java.awt.Cursor;
import model.*;
import persistence.DaoAppointmentsXML;
import persistence.DaoPatientXML;
import excepciones.*;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ModifPatient extends JFrame {

    private JTextField nameTxt;
    private JTextField idTxt;
    private JTextField ageTxt;
    private JTextField addressTxt;
    private JTextField phoneNumberTxt;
    private JTable dentistTable;
    private JTextField dateTxt;
    private JTextField notesTxt;
    
    PlaceHolder placeholder;
    
  
    public ModifPatient(Clinic clinic, Patient patient, JTable table) {
    	getContentPane().setBackground(new Color(176, 224, 230));   
    	setBounds(100, 100, 543, 452);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBackground(new Color(176, 224, 230));
        getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Nombre: ");
        lblName.setBounds(0, 34, 111, 20);
        lblName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblName);

        nameTxt = new JTextField(patient.getName());
        nameTxt.setBounds(121, 34, 152, 20);
        getContentPane().add(nameTxt);
        nameTxt.setColumns(10);

        JLabel lblID = new JLabel("Cedula:");
        lblID.setBounds(0, 89, 111, 20);
        lblID.setHorizontalAlignment(SwingConstants.RIGHT);
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblID);

        idTxt = new JTextField(String.valueOf(patient.getId()));
        idTxt.setBounds(121, 89, 137, 20);
        idTxt.setColumns(10);
        getContentPane().add(idTxt);

        JLabel lblAge = new JLabel("Edad:");
        lblAge.setBounds(0, 137, 111, 20);
        lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblAge);

        ageTxt = new JTextField(String.valueOf(patient.getAge()));
        ageTxt.setBounds(121, 139, 46, 20);
        getContentPane().add(ageTxt);
        ageTxt.setColumns(10);

        JLabel lblSex = new JLabel("Sexo:");
        lblSex.setBounds(0, 184, 111, 20);
        lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblSex);

        JComboBox sexBox = new JComboBox();
        sexBox.setBounds(121, 186, 72, 20);
        sexBox.setMaximumRowCount(2);
        sexBox.setModel(new DefaultComboBoxModel(new String[]{"M", "F"}));
        if (patient.getSex().equals("M"))
        	sexBox.setSelectedIndex(0);
        else
        	sexBox.setSelectedIndex(1);
        getContentPane().add(sexBox);

        JLabel lblAddress = new JLabel("Direccion:");
        lblAddress.setBounds(0, 225, 111, 20);
        lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblAddress);

        addressTxt = new JTextField(patient.getAddress());
        addressTxt.setBounds(121, 227, 152, 20);
        addressTxt.setColumns(10);
        getContentPane().add(addressTxt);

        JLabel lblPhoneNumber = new JLabel("Numero de tlfn:");
        lblPhoneNumber.setBounds(0, 269, 111, 20);
        lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblPhoneNumber);

        phoneNumberTxt = new JTextField(String.valueOf(patient.getPhoneNumber()));
        phoneNumberTxt.setBounds(121, 270, 130, 20);
        phoneNumberTxt.setColumns(10);
        getContentPane().add(phoneNumberTxt);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(285, 22, 212, 145);
        getContentPane().add(scrollPane);

        dentistTable = new JTable();
        dentistTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        	}
        ));
        scrollPane.setViewportView(dentistTable);
        dentistTable.getTableHeader().setReorderingAllowed(false); // prevent user to drag column
        dentistTable.getTableHeader().setEnabled(false);		  // tableHeader not resizable
        dentistTable.setDefaultEditor(Object.class, null);		  // column not editable

        JLabel lblAviliable = new JLabel("Odontologos Disponibles");
        lblAviliable.setBounds(285, 177, 202, 35);
        lblAviliable.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAviliable.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblAviliable);

        JLabel lblDate = new JLabel("Fecha:");
        lblDate.setBounds(245, 230, 89, 20);
        lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblDate);
        
        JLabel lblNotes = new JLabel("Motivo:");
        lblNotes.setBounds(245, 312, 89, 20);
        lblNotes.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblNotes);

        JLabel lblHour = new JLabel("Hora:");
        lblHour.setBounds(275, 269, 59, 20);
        lblHour.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHour.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblHour);
        
        JComboBox hourBox = new JComboBox();
        
        try {
        dateTxt = new JTextField(patient.getAppointment().getDate());
        dateTxt.setBounds(344, 232, 114, 20);
        getContentPane().add(dateTxt);
        dateTxt.setColumns(10);
        
        
        hourBox.setBounds(344, 271, 104, 20);
        hourBox.setModel(new DefaultComboBoxModel(new String[]{"", "9 AM", "10 AM", "11 AM", "2 PM", "3 PM", "4 PM", "5 PM"}));
        if (patient.getAppointment().getHour().equals("9 AM"))
        	hourBox.setSelectedIndex(1);
        else
        	if (patient.getAppointment().getHour().equals("10 AM"))
            	hourBox.setSelectedIndex(2);
        	else
        		if (patient.getAppointment().getHour().equals("11 AM"))
                	hourBox.setSelectedIndex(3);
        		else
        			if (patient.getAppointment().getHour().equals("2 PM"))
        	        	hourBox.setSelectedIndex(4);
        			else
        				if (patient.getAppointment().getHour().equals("3 PM"))
            	        	hourBox.setSelectedIndex(5);
        				else
        					if (patient.getAppointment().getHour().equals("4 PM"))
                	        	hourBox.setSelectedIndex(6);
        					else
        						if (patient.getAppointment().getHour().equals("5 PM"))
        	        	        	hourBox.setSelectedIndex(7);
        						else
        							hourBox.setSelectedIndex(0);
        getContentPane().add(hourBox);


        notesTxt = new JTextField(patient.getAppointment().getNotes());
        notesTxt.setBounds(344, 314, 153, 20);
        notesTxt.setColumns(10);
        getContentPane().add(notesTxt);
        }
        catch (NullPointerException e) {

		}
        

        JButton btnConfirm = new JButton("");
        btnConfirm.setBounds(153, 328, 72, 72);
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((Validations.validateName(nameTxt)) && (Validations.validateId(idTxt)) && (Validations.validateAge(ageTxt))
                        && (Validations.validateAddress(addressTxt)) && (Validations.validatePhoneNumber(phoneNumberTxt))
                        && (Validations.validateDate(dateTxt)) && (Validations.validateHour(hourBox))
                        && (Validations.validateNotes(notesTxt) && (Validations.validateTable(dentistTable.getSelectedRow())))) {
                    patient.setName(nameTxt.getText());
                    patient.setId(Integer.parseInt(idTxt.getText()));
                    patient.setAddress(addressTxt.getText());
                    patient.setAge(Integer.parseInt(ageTxt.getText()));
                    if (sexBox.getSelectedIndex() == 0)
                    	patient.setSex("M");
                    else 
                    	patient.setSex("F");
                    patient.setPhoneNumber(Integer.parseInt(phoneNumberTxt.getText()));
                    patient.setDentist( (Dentist) clinic.getListOfStaff().get(dentistTable.getSelectedRow()));
                    patient.getAppointment().setDentist((Dentist) clinic.getListOfStaff().get(dentistTable.getSelectedRow()));
                    patient.getAppointment().setDate(dateTxt.getText());
                    patient.getAppointment().setHour(hourBox.getSelectedItem().toString());
                    patient.getAppointment().setNotes(notesTxt.getText());
                	JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
                    ControlFields.clearFieldsSecretary(nameTxt, idTxt, ageTxt, sexBox, addressTxt, phoneNumberTxt, dateTxt, hourBox, notesTxt);
                    ControlFields.fillTablePatient(table, clinic.getListOfPatients());
                    setVisible(false);
                    DaoPatientXML.deletePatient(patient.getId());
                    DaoPatientXML.updatePatient(patient);
                    DaoAppointmentsXML.deleteAppointment(patient.getId());
                    DaoAppointmentsXML.updateAppointment(patient.getAppointment());
                }
            }
        });
        btnConfirm.setForeground(new Color(176, 224, 230));
        btnConfirm.setBackground(new Color(176, 224, 230));
        btnConfirm.setBorder(new IconHelper(260));
        btnConfirm.setIcon(new ImageIcon(CreateApointment.class.getResource("/Icons/check.jpg")));
        btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        getContentPane().add(btnConfirm);

        JButton btnCancel = new JButton("");
        btnCancel.setBounds(39, 328, 72, 72);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    ControlFields.clearFieldsSecretary(nameTxt, idTxt, ageTxt, sexBox, addressTxt, phoneNumberTxt, dateTxt, hourBox, notesTxt);
                    setVisible(false);
            }
        });
        btnCancel.setIcon(new ImageIcon(CreateApointment.class.getResource("/Icons/back.jpg")));
        btnCancel.setForeground(new Color(176, 224, 230));
        btnCancel.setBorder(new IconHelper(260));
        btnCancel.setBackground(new Color(176, 224, 230));
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        getContentPane().add(btnCancel);
        
        placeholder = new PlaceHolder(dateTxt, "dd/mm/aaaa");
        
        JLabel lblDentist = new JLabel("Dentista:");
        lblDentist.setBounds(245, 352, 89, 20);
        lblDentist.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDentist.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getContentPane().add(lblDentist);
        
        JLabel DisplayDentist = new JLabel(patient.getDentist().getName());
        DisplayDentist.setBounds(344, 357, 153, 14);
        getContentPane().add(DisplayDentist);
    }

    public JTable getDentistTable() {
        return dentistTable;
    }

    public void setDentistTable(JTable dentistTable) {
        this.dentistTable = dentistTable;
    }
    
    
}
