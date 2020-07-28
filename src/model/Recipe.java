package model;

public class Recipe extends Document {
    
    private String medicines;
    
    public Recipe() {
        super();
        this.medicines = "";
    }

    public Recipe(int patientId) {
        super(patientId);
        this.medicines = medicines;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }
    
}
