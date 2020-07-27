package controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.*;

public final class ControlSecretary {

    private ControlSecretary() {

    }

    public static void createAppointment(JTextField name, JTextField id, JTextField age, JComboBox sex,
            JTextField address, JTextField phoneNumber, JTable listDentist, JTextField date, JComboBox hour, JTextField notes,
            ArrayList<Person> listOfStaff, ArrayList<Appointment> listOfAppointments, ArrayList<Patient> listOfPatients) {

        Patient patient = new Patient();
        Appointment appointment = new Appointment();
        
        patient.setName(name.getText());
        patient.setId(Integer.parseInt(id.getText()));
        patient.setAge(Integer.parseInt(age.getText()));
        int optionSex = sex.getSelectedIndex();
        switch (optionSex) {
            case 0: {
                patient.setSex("M");
                break;
            }
            case 1: {
                patient.setSex("F");
            }
        }
        patient.setAddress(address.getText());
        patient.setPhoneNumber(Integer.parseInt(phoneNumber.getText()));
        
        if (listOfStaff.get(listDentist.getSelectedRow()) instanceof Dentist) {     // No estoy seguro que esto así funcione
            appointment.setDentist((Dentist) listOfStaff.get(listDentist.getSelectedRow()));  // para asignarle un dentista a la cita
        }
        appointment.setDate(date.getText());
        appointment.setHour(hour.getSelectedItem().toString());
        appointment.setNotes(notes.getText());
        
        listOfPatients.add(patient);
        listOfAppointments.add(appointment);
    }

}
