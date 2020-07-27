package model;

public class Recipe extends Document {
    
    private String medicines;
    
    public Recipe() {
        super();
        this.medicines = "";
    }

    public Recipe(String name, int age, String sex, String notes, String medicines, int patientId) {
        super(name, age, sex, notes, patientId);
        this.medicines = medicines;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }
    
}
