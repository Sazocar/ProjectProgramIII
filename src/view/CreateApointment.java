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
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.*;
import java.awt.Cursor;
import model.*;
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

public class CreateApointment extends JPanel {

    private JTextField nameTxt;
    private JTextField idTxt;
    private JTextField ageTxt;
    private JTextField addressTxt;
    private JTextField phoneNumberTxt;
    private JTable dentistTable;
    private JTextField dateTxt;
    private JTextField notesTxt;
    
    PlaceHolder placeholder;
    
  
    public CreateApointment(Clinic clinic) {    
        
        setBackground(new Color(176, 224, 230));			
        setLayout(null);

        JLabel lblName = new JLabel("Nombre: ");
        lblName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName.setBounds(0, 34, 111, 20);
        add(lblName);

        nameTxt = new JTextField();
        nameTxt.setBounds(121, 34, 152, 20);
        add(nameTxt);
        nameTxt.setColumns(10);

        JLabel lblID = new JLabel("Cedula:");
        lblID.setHorizontalAlignment(SwingConstants.RIGHT);
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblID.setBounds(0, 89, 111, 20);
        add(lblID);

        idTxt = new JTextField();
        idTxt.setColumns(10);
        idTxt.setBounds(121, 89, 137, 20);
        add(idTxt);

        JLabel lblAge = new JLabel("Edad:");
        lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAge.setBounds(0, 137, 111, 20);
        add(lblAge);

        ageTxt = new JTextField();
        ageTxt.setBounds(121, 139, 46, 20);
        add(ageTxt);
        ageTxt.setColumns(10);

        JLabel lblSex = new JLabel("Sexo:");
        lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSex.setBounds(0, 184, 111, 20);
        add(lblSex);

        JComboBox sexBox = new JComboBox();
        sexBox.setMaximumRowCount(2);
        sexBox.setModel(new DefaultComboBoxModel(new String[]{"M", "F"}));
        sexBox.setBounds(121, 186, 72, 20);
        add(sexBox);

        JLabel lblAddress = new JLabel("Direccion:");
        lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAddress.setBounds(0, 225, 111, 20);
        add(lblAddress);

        addressTxt = new JTextField();
        addressTxt.setColumns(10);
        addressTxt.setBounds(121, 227, 152, 20);
        add(addressTxt);

        JLabel lblPhoneNumber = new JLabel("Numero de tlfn:");
        lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPhoneNumber.setBounds(0, 269, 111, 20);
        add(lblPhoneNumber);

        phoneNumberTxt = new JTextField();
        phoneNumberTxt.setColumns(10);
        phoneNumberTxt.setBounds(121, 270, 130, 20);
        add(phoneNumberTxt);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(285, 22, 212, 145);
        add(scrollPane);

        dentistTable = new JTable();
        scrollPane.setColumnHeaderView(dentistTable);
        dentistTable.setDragEnabled(false);

        JLabel lblAviliable = new JLabel("Odontologos Disponibles");
        lblAviliable.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblAviliable.setHorizontalAlignment(SwingConstants.CENTER);
        lblAviliable.setBounds(285, 177, 202, 35);
        add(lblAviliable);

        JLabel lblDate = new JLabel("Fecha:");
        lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDate.setBounds(245, 230, 89, 20);
        add(lblDate);

        dateTxt = new JTextField();
        dateTxt.setBounds(344, 232, 114, 20);
        add(dateTxt);
        dateTxt.setColumns(10);

        JLabel lblHour = new JLabel("Hora:");
        lblHour.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHour.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblHour.setBounds(275, 269, 59, 20);
        add(lblHour);

        JComboBox hourBox = new JComboBox();
        hourBox.setModel(new DefaultComboBoxModel(new String[]{"", "9 AM", "10 AM", "11 AM", "2 PM", "3 PM", "4 PM", "5 PM"}));
        hourBox.setBounds(344, 271, 104, 20);
        add(hourBox);

        JLabel lblNotes = new JLabel("Motivo:");
        lblNotes.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNotes.setBounds(245, 312, 89, 20);
        add(lblNotes);

        notesTxt = new JTextField();
        notesTxt.setColumns(10);
        notesTxt.setBounds(344, 314, 153, 20);
        add(notesTxt);

        JButton btnConfirm = new JButton("");
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if ((Validations.validateName(nameTxt)) && (Validations.validateId(idTxt)) && (Validations.validateAge(ageTxt))
                        && (Validations.validateAddress(addressTxt)) && (Validations.validatePhoneNumber(phoneNumberTxt))
                        && (Validations.validateDentist(dentistTable)) && (Validations.validateDate(dateTxt)) && (Validations.validateHour(hourBox))
                        && (Validations.validateNotes(notesTxt))) {
                    ControlSecretary.createAppointment(nameTxt, idTxt, ageTxt, sexBox, addressTxt, phoneNumberTxt, dentistTable, dateTxt, hourBox, notesTxt, clinic.getListOfStaff(), clinic.getListOfAppointments(), clinic.getListOfPatients());
                    JOptionPane.showMessageDialog(null, "Cita creada exitosamente");
                    System.out.println("Cantidad de appointments: " + clinic.getListOfAppointments().size());
                    ControlFields.clearFieldsSecretary(nameTxt, idTxt, ageTxt, sexBox, addressTxt, phoneNumberTxt, dateTxt, hourBox, notesTxt);
                }
            }
        });
        btnConfirm.setForeground(new Color(176, 224, 230));
        btnConfirm.setBackground(new Color(176, 224, 230));
        btnConfirm.setBorder(new IconHelper(260));
        btnConfirm.setIcon(new ImageIcon(CreateApointment.class.getResource("/Icons/check.jpg")));
        btnConfirm.setBounds(153, 328, 72, 72);
        btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnConfirm);

        JButton btnCancel = new JButton("");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Seguro que desea volver a la pagina inicial?", "Cancelar", JOptionPane.YES_NO_OPTION);
                if (option != 1) {
                    ControlFields.clearFieldsSecretary(nameTxt, idTxt, ageTxt, sexBox, addressTxt, phoneNumberTxt, dateTxt, hourBox, notesTxt);
                    setVisible(false);
                }
            }
        });
        btnCancel.setIcon(new ImageIcon(CreateApointment.class.getResource("/Icons/back.jpg")));
        btnCancel.setForeground(new Color(176, 224, 230));
        btnCancel.setBorder(new IconHelper(260));
        btnCancel.setBackground(new Color(176, 224, 230));
        btnCancel.setBounds(39, 328, 72, 72);
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(btnCancel);
        
        placeholder = new PlaceHolder(dateTxt, "dd/mm/aaaa");
    }

    public JTable getDentistTable() {
        return dentistTable;
    }

    public void setDentistTable(JTable dentistTable) {
        this.dentistTable = dentistTable;
    }
}
