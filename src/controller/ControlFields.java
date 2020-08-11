package controller;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.*;

public final class ControlFields {

    private ControlFields() {

    }

    public static void clearFieldsSecretary(JTextField name, JTextField id, JTextField age, JComboBox sex, JTextField address,
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

    public static void clearFieldsDentist(JTextField name, JTextField id, JTextField age, JComboBox sex, JTextField address,
            JTextField phoneNumber, JTextField speciality, JComboBox shift) {

        name.setText("");
        id.setText("");
        age.setText("");
        sex.setSelectedIndex(0);
        address.setText("");
        phoneNumber.setText("");
        speciality.setText("");
        shift.setSelectedIndex(0);
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
                String[] fila = {person.getName(), String.valueOf(person.getId()), String.valueOf(person.getAge()), person.getSex(), String.valueOf(person.getPhoneNumber()), ((Patient) person).getDentist().getName()};
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

    public static void deletePatient(Clinic clinic, JTable table) {
        clinic.getListOfPatients().remove(table.getSelectedRow());
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.removeRow(table.getSelectedRow());
    }

    public static void assingAppointmentsDentist(Clinic clinic) {
        for (Appointment appointments : clinic.getListOfAppointments()) {
            for (Dentist dentist : clinic.getListOfStaff()) {
                if (appointments.getDentist().getId() == dentist.getId()) {
                    dentist.getListOfAppointments().add(appointments);
                }
            }
        }
    }

    public static void firstFillTableAppointments(JTable tableDentist, ArrayList<Patient> patients, Dentist dentist, ArrayList<Patient> patientsInAppointments) {
        String[] column = {"Nombre", "Cedula", "Fecha", "Hora", "Motivo"};
        DefaultTableModel dtm = new DefaultTableModel(null, column);
        for (Appointment appointments : dentist.getListOfAppointments()) {
            for (Patient patient : patients) {
                if (appointments.getPatientId() == patient.getId()) {
                    String[] fila = {patient.getName(), String.valueOf(patient.getId()), appointments.getDate(), appointments.getHour(), appointments.getNotes()};
                    dtm.addRow(fila);
                    patientsInAppointments.add(patient);
                }
            }
        }
        tableDentist.setModel(dtm);
        tableDentist.getColumnModel().getColumn(0).setPreferredWidth(60);
        tableDentist.getColumnModel().getColumn(1).setPreferredWidth(60);
        tableDentist.getColumnModel().getColumn(2).setPreferredWidth(60);
        tableDentist.getColumnModel().getColumn(3).setPreferredWidth(40);
        tableDentist.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

    public static void fillTableAppointments(JTable tableDentist, ArrayList<Patient> patientsInAppointments) {
        String[] column = {"Nombre", "Cedula", "Fecha", "Hora", "Motivo"};
        DefaultTableModel dtm = new DefaultTableModel(null, column);
        for (Patient patient : patientsInAppointments) {
            String[] fila = {patient.getName(), String.valueOf(patient.getId()), patient.getAppointment().getDate(), patient.getAppointment().getHour(), patient.getAppointment().getNotes()};
            dtm.addRow(fila);
        }

        tableDentist.setModel(dtm);
        tableDentist.getColumnModel().getColumn(0).setPreferredWidth(60);
        tableDentist.getColumnModel().getColumn(1).setPreferredWidth(60);
        tableDentist.getColumnModel().getColumn(2).setPreferredWidth(60);
        tableDentist.getColumnModel().getColumn(3).setPreferredWidth(40);
        tableDentist.getColumnModel().getColumn(4).setPreferredWidth(80);
    }

}
