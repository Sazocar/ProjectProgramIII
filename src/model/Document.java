package model;

public abstract class Document {
    
    protected int patientId;
    
    public Document() {
        this.patientId=0;
    }

    public Document (int patientId) {
        this.patientId = patientId;
    }

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
    
    

}
