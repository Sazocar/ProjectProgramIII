package model;

public class Patient extends Person {
    
    private Dentist dentist;
    private Appointment appointment;
    private Recipe recipe;
    private History history;
    private int listId;

    public Patient() {
        super();
        this.dentist = null;
        this.appointment = null;
        this.recipe = null;
        this.history = null;
        listId = -1;
    }

    public Patient(String name, int id, int age, String sex, String address, int phoneNumber,
            Dentist dentist, Appointment appointment, Recipe recipe, History history, int listId) {
        super(name, id, age, sex, address, phoneNumber);
        this.dentist = dentist;
        this.appointment = appointment;
        this.recipe = recipe;
        this.history = history;
        this.listId = listId;
    }

	public Dentist getDentist() {
		return dentist;
	}

	public void setDentist(Dentist dentist) {
		this.dentist = dentist;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	} 
}
