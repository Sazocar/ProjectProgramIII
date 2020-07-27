package excepciones;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.*;

public final class Validations {

    public static void ageRange(int age) throws AgeRangeException {
        if (age < 5 || age > 91) 
            throw new AgeRangeException("Numero invalido, este debe estar comprendido entre 5 y 90");
    }


    public static void idRange(long id) throws IdRangeException {
        if (id < 1 || id > 35000000) 
            throw new IdRangeException("Numero invalido, la cedula debe estar comprendida entre 1 y 35000000 ");
    }


    public static void phoneNumberRange(long phoneNumber) throws PhoneNumberRangeException {
        if (phoneNumber < 0) 
            throw new PhoneNumberRangeException("Indique un numero entero positivo. \n ");
    }

    public static void errorMessage(JTextField nombreTxt, String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        nombreTxt.setText("");
        nombreTxt.requestFocus();
    }
    
    public static void errorMessageBox(JComboBox nombreTxt, String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        nombreTxt.requestFocus();
    }

    public static boolean validateName(JTextField name) {
        Pattern pat = Pattern.compile("^[a-zA-ZáÁéÉíÍóÓúÚñ ]+${1,40}");
        Matcher mat = pat.matcher(name.getText());
        if (name.getText().isEmpty()) {
            errorMessage(name, "Error en: Nombre\nEl campo no puede estar vacio.");
            return false;
        } else if (mat.matches() == false) {
            errorMessage(name, "Error en: Nombre\nEl campo solo puede contener letras.");
            return false;
        }
        return true;
    }

    public static boolean validateId(JTextField id) {
        if (id.getText().isEmpty()) {
            errorMessage(id, "Error en: Cedula\nEl campo no puede estar vacio.");
            return false;
        } else {
                try {
                    Validations.idRange(Integer.parseInt(id.getText()));
                    Integer.parseInt(id.getText());
                    return true;
                } catch (NumberFormatException error) {
                    errorMessage(id, "Error en: Cedula\nValor introducido no es un numero entero.");
                    return false;
                } catch (IdRangeException idError) {
                    errorMessage(id, "Error en: Cedula\n" + idError.getMessage());
                    return false;
                }
        }
    }
    
    public static boolean validateAge(JTextField age) {
        if (age.getText().isEmpty()) {
            errorMessage(age, "Error en: Edad\nEl campo no puede estar vacio.");
            return false;
        } else {
                try {
                    Validations.ageRange(Integer.parseInt(age.getText()));
                    return true;
                } catch (NumberFormatException e) {
                    errorMessage(age, "Error en: Edad\nValor introducido debe ser un numero entero positivo.");
                    return false;
                } catch (AgeRangeException ageError) {
                    errorMessage(age, "Error en: Edad\n" + ageError.getMessage());
                    return false;
                }
        }
    }
    
    public static boolean validateAddress(JTextField address) {
        Pattern pat = Pattern.compile("^[a-zA-Z0-9áÁéÉíÍóÓúÚñ.# ]+${1,60}");
        Matcher mat = pat.matcher(address.getText());
        if (mat.matches() == false) {
            errorMessage(address, "Error en: Direccion\nIngrese numeros, letras y caracteres especiales tales como: \n .\n #");
            return false;
        } else if (address.getText().isEmpty()) {
            errorMessage(address, "Error en: Direccion\nEl campo no puede estar vacio.");
            return false;
        }
        return true;
    }

    public static boolean validatePhoneNumber(JTextField phoneNumber) {
        if (phoneNumber.getText().isEmpty()) {
            errorMessage(phoneNumber, "Error en: Numero de Telefono\nEl campo no puede estar vacio.");
            return false;
        } else {
                try {
                    Validations.phoneNumberRange(Long.parseLong(phoneNumber.getText()));
                    return true;
                } catch (NumberFormatException e) {
                    errorMessage(phoneNumber, "Error en: Numero de Telefono\nValor introducido no es un numero entero.");
                    return false;
                } catch (PhoneNumberRangeException errorExp) {
                    errorMessage(phoneNumber, "Error en: Numero de Telefono\n" + errorExp.getMessage());
                    return false;
                }
        }
    }
    
    public static boolean validateDentist(JTable dentistTable) {
        if (dentistTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar primero un dentista", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public static boolean validateDate(JTextField date) {
        Pattern pat = Pattern.compile("[0-2]{0,1}[0-9]{1}(/|-)[0-1]{0,1}[0-9]{1}(/|-)[2]{1}[0-9]{3}");  // puedo hacer varios patterns?
        Matcher mat = pat.matcher(date.getText());
        if (mat.matches() == false) {       // aqui verificar los distintos patterns
            errorMessage(date, "Error en: Fecha\nDebe contener el siguiente formato: dd/mm/aaaa");
            return false;
        } else if (date.getText().isEmpty()) {
            errorMessage(date, "Error en: Fecha\nEl campo no puede estar vacio.");
            return false;
        }
        return true;
    }

    public static boolean validateHour(JComboBox hour) {
        if (hour.getSelectedIndex() == 0) {
            errorMessageBox(hour, "Error en: Hora\nDebe especificar la hora de la cita.");
            return false;
        }
        return true;
    }
    
    public static boolean validateNotes(JTextField notes) {
        Pattern pat = Pattern.compile("^[a-zA-ZáÁéÉíÍóÓúÚñ ]+${1,40}");
        Matcher mat = pat.matcher(notes.getText());
        if (notes.getText().isEmpty()) {
            errorMessage(notes, "Error en: Motivo\nEl campo no puede estar vacio.");
            return false;
        } else if (mat.matches() == false) {
            errorMessage(notes, "Error en: Motivo\nEl campo solo puede contener letras.");
            return false;
        }
        return true;
    }


    public static boolean validateSameId(JTextField id, Clinic clinic) {
        for (int i = 0; i < clinic.getListOfPatients().size(); i++) {
            if (id.getText() == String.valueOf(clinic.getListOfPatients().get(i).getId())) {
                errorMessage(id, "Error en: Cedula\nLa cedula no puede coincidir con otra.");
                return false;
            }
        }
        return true;
    }
    
}
