package model;

import java.util.ArrayList;

public class Clinic {
    
    private ArrayList<Person> listOfStaff = new ArrayList<Person>();
    private ArrayList<Patient> listOfPatients = new ArrayList<Patient>();
    private ArrayList<Appointment> listOfAppointments =new ArrayList<Appointment>();
    private ArrayList<Inventory> inventory = new ArrayList<Inventory>();
    
    public Clinic () {
    	Dentist dummie = new Dentist("Simon", 4123, 22, "M", "Mi casa", 9123, "Odontologo pro", "tarde"); // el ulitmo parametero es un arrayList
    	listOfStaff = new ArrayList<Person>();
    	listOfStaff.add(dummie);
        
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
