package controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.w3c.dom.ls.LSInput;

import model.*;
import persistence.DaoAppointmentsXML;
import persistence.DaoPatientXML;

public final class ControlSecretary {

    private ControlSecretary() {

    }

    public static void createAppointment(JTextField name, JTextField id, JTextField age, JComboBox sex,
            JTextField address, JTextField phoneNumber, JTable listDentist, JTextField date, JComboBox hour, JTextField notes,
            ArrayList<Dentist> listOfStaff, ArrayList<Appointment> listOfAppointments, ArrayList<Patient> listOfPatients) {

        Patient patient = new Patient();
        Appointment appointment = new Appointment();
        Recipe recipe = new Recipe();
        History hist = new History();
        
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
        
	        if (listOfStaff.get(listDentist.getSelectedRow()) instanceof Dentist) { 
	            appointment.setDentist((Dentist) listOfStaff.get(listDentist.getSelectedRow())); 
	            patient.setDentist((Dentist) listOfStaff.get(listDentist.getSelectedRow()));
	        }
        appointment.setDate(date.getText());
        appointment.setHour(hour.getSelectedItem().toString());
        appointment.setNotes(notes.getText());
        
        patient.setAppointment(appointment);
        patient.getAppointment().setPatientId(patient.getId());
        recipe.setMedicines("No se ha asignado tratamiento");
        patient.setRecipe(recipe);
        hist.setTreatment("Este paciente no contiene historial medico aun.");
        patient.setHistory(hist);
        
        listOfPatients.add(patient);
        listOfAppointments.add(appointment);
        DaoPatientXML.updatePatient(patient);
        DaoAppointmentsXML.updateAppointment(appointment);
    }

}
