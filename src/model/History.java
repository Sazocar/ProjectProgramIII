package model;

public class History extends Document {
    
    protected String treatment;

    public History() {
        super();
        this.treatment = "";
    }

    public History(String name, int age, String sex, String notes, String treatment, int patientId) {
        super(name, age, sex, notes, patientId);
        this.treatment = treatment;
    }
    
    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    
}
