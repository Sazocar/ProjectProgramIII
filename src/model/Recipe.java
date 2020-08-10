package model;

public class Recipe {
    
    private String medicines;
    
    public Recipe() {
        super();
        this.medicines = "";
    }
    
    public Recipe(String meds) {
    	medicines = meds;
    }


    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }
    
    
}
