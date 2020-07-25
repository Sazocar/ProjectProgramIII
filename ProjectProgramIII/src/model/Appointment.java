package model;

public class Appointment {
    
    private Dentist dentist;
    private String date;
    private int hours;
    private String notes;    

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist (Dentist odontolo) {
        this.dentist = odontolo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
