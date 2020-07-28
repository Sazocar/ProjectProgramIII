package model;

public class Appointment {

    private Dentist dentist;
    private String date;
    private String hour;
    private String notes;
    private int patientId;

    public Appointment() {

    }

    public Appointment(Dentist dentist, String date, String hour, String notes, int patientId) {
        this.dentist = dentist;
        this.date = date;
        this.hour = hour;
        this.notes = notes;
        this.patientId = patientId;
    }

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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

}
