package controller;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.*;

public final class ControlFields {
    
    private ControlFields () {
        
    }
    
    public static void clearFieldsSecretary(JTextField name, JTextField id, JTextField age, JComboBox sex,  JTextField address, 
            JTextField phoneNumber, JTextField date, JComboBox hour, JTextField notes) {
        
        name.setText("");
        id.setText("");
        age.setText("");
        sex.setSelectedIndex(0);
        address.setText("");
        phoneNumber.setText("");
        date.setText("");
        hour.setSelectedIndex(0);
        notes.setText("");
    }
    
    public static void fillTableDentist(JTable tableDentist, Clinic clinic) {
        String[] column = {"Nombre", "Especialidad"};
        DefaultTableModel dtm = new DefaultTableModel(null, column);
        for (Person person : clinic.getListOfStaff()) {
            if (person instanceof Dentist) {
                String[] fila = {person.getName(), ((Dentist) person).getSpecialty()};
                dtm.addRow(fila);
            }
        }
        tableDentist.setModel(dtm);
        tableDentist.getColumnModel().getColumn(0).setPreferredWidth(80);
        tableDentist.getColumnModel().getColumn(1).setPreferredWidth(80);
    }
    
    public static void fillTablePatient(JTable tableDentist, ArrayList<Patient> patients) {
        String[] column = {"Nombre", "Cedula", "Edad", "Sexo", "Numero de Tlfn", "Odontologo"};
        DefaultTableModel dtm = new DefaultTableModel(null, column);
        for (Person person : patients) {
            if (person instanceof Patient) {
                String[] fila = {person.getName(), String.valueOf(person.getId()), String.valueOf(person.getAge()), person.getSex(), String.valueOf(person.getPhoneNumber()), ((Patient) person).getDentist().getName() };
                dtm.addRow(fila);
            }
        }
        tableDentist.setModel(dtm);
        tableDentist.getColumnModel().getColumn(0).setPreferredWidth(60);
        tableDentist.getColumnModel().getColumn(1).setPreferredWidth(60);
        tableDentist.getColumnModel().getColumn(2).setPreferredWidth(20);
        tableDentist.getColumnModel().getColumn(3).setPreferredWidth(20);
        tableDentist.getColumnModel().getColumn(4).setPreferredWidth(80);
        tableDentist.getColumnModel().getColumn(5).setPreferredWidth(80);
    }
    
}
