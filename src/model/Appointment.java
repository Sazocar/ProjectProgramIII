package model;

public class Appointment {
    
    private Dentist dentist;
    private String date;
    private String hour;
    private String notes;    

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist (Dentist dentist) {
        this.dentist = dentist;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
}
