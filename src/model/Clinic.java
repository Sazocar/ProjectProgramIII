package model;

import java.util.ArrayList;

public class Clinic {
    
    private ArrayList<Dentist> listOfStaff = new ArrayList<Dentist>();
    private ArrayList<Patient> listOfPatients = new ArrayList<Patient>();
    private ArrayList<Appointment> listOfAppointments =new ArrayList<Appointment>();
    private Inventory inventory ;
    
    public Clinic () {
    }

    public Clinic(ArrayList<Dentist> listOfStaff, ArrayList<Patient> listOfPatients, ArrayList<Appointment> listOfAppointments, 
            Inventory inventory) {
        this.listOfStaff = listOfStaff;
        this.listOfPatients = listOfPatients;
        this.listOfAppointments = listOfAppointments;
        this.inventory = inventory;
    }

    public ArrayList<Dentist> getListOfStaff() {
        return listOfStaff;
    }

    public void setListOfStaff(ArrayList<Dentist> listOfStaff) {
        this.listOfStaff = listOfStaff;
    }

    public ArrayList<Patient> getListOfPatients() {
        return listOfPatients;
    }

    public void setListOfPatients(ArrayList<Patient> listOfPatients) {
        this.listOfPatients = listOfPatients;
    }

    public ArrayList<Appointment> getListOfAppointments() {
        return listOfAppointments;
    }

    public void setListOfAppointments(ArrayList<Appointment> listOfAppointments) {
        this.listOfAppointments = listOfAppointments;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
}
