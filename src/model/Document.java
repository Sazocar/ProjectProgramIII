package model;

public abstract class Document {
    
    protected String name;
    protected int age;
    protected String sex;
    protected String notes;
    
    public Document() {
        this.name = "";
        this.age = 0;
        this.sex = "";
        this.notes = "";
    }

    public Document (String name, int age, String sex, String notes) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.notes = notes;
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

}
