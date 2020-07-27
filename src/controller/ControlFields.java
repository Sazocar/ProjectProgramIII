package controller;

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
        tableDentist.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableDentist.getColumnModel().getColumn(1).setPreferredWidth(120);
    }
    
}
