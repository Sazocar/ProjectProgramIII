package model;

public class History extends Document {
    
    protected String treatment;

    public History() {
        super();
        this.treatment = "";
    }

    public History(int patientId) {
        super(patientId);
        this.treatment = treatment;
    }
    
    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    
}
