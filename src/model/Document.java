package model;

public abstract class Document {
    
    protected String name;
    protected int age;
    protected String sex;
    protected String notes;
    protected int patientId;
    
    public Document() {
        this.name = "";
        this.age = 0;
        this.sex = "";
        this.notes = "";
        this.patientId=0;
    }

    public Document (String name, int age, String sex, String notes, int patientId) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.notes = notes;
        this.patientId = patientId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
