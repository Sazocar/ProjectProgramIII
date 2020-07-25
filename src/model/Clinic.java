package model;

import java.util.ArrayList;

public class Clinic {
    
    private ArrayList<Person> listOfStaff;
    private ArrayList<Patient> listOfPatients;
    private ArrayList<Appointment> listOfAppointments;
    private ArrayList<Inventory> inventory;
    
    public Clinic () {
        
    }

    public Clinic(ArrayList<Person> listOfStaff, ArrayList<Patient> listOfPatients, ArrayList<Appointment> listOfAppointments, 
            ArrayList<Inventory> inventory) {
        this.listOfStaff = listOfStaff;
        this.listOfPatients = listOfPatients;
        this.listOfAppointments = listOfAppointments;
        this.inventory = inventory;
    }

    public ArrayList<Person> getListOfStaff() {
        return listOfStaff;
    }

    public void setListOfStaff(ArrayList<Person> listOfStaff) {
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

    public ArrayList<Inventory> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Inventory> inventory) {
        this.inventory = inventory;
    }
    
}
