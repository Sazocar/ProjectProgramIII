package model;

import java.util.ArrayList;

public class Dentist extends Person {
    
    private String specialty;
    private String shift;
    private ArrayList<Appointment> listOfAppointments;
    
    public Dentist () {
        super();
        this.specialty = "";
        this.shift = "";
        this.listOfAppointments = new ArrayList<Appointment>();
    }
    
    public Dentist (String name, int id, int age, String sex, String address, int phoneNumber, String specialty,
            String shift, ArrayList<Appointment> listOfAppointments) {
        super(name, id, age, sex, address, phoneNumber);
        this.specialty = specialty;
        this.shift = shift;
        this.listOfAppointments = listOfAppointments;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public ArrayList<Appointment> getListOfAppointments() {
        return listOfAppointments;
    }

    public void setListOfAppointments(ArrayList<Appointment> listOfAppointments) {
        this.listOfAppointments = listOfAppointments;
    }
    
}
