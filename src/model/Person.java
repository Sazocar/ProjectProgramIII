package model;

public class Person {
    
    protected String name;
    protected int id;
    protected int age;
    protected String sex;
    protected String address;
    protected int phoneNumber;
    
    public Person() {
        name = "";
        id = 0;
        age = 0;
        sex = "";
        address = "";
        phoneNumber = 0;        
    }

    public Person(String name, int id, int age, String sex, String address, int phoneNumber) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
}
