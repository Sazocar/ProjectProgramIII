package model;

public class History{
    
    protected String treatment;

    public History() {
        this.treatment = "";
    }

    public History(String hist) {
    	treatment = hist;
    }
    

	public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }
    
}
