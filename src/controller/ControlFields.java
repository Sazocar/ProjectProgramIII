package controller;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

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
    
}
