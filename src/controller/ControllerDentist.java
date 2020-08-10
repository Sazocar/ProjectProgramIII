package controller;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Appointment;
import model.Dentist;
import persistence.DaoDentistXML;
import persistence.DaoPatientXML;

public final class ControllerDentist {
	
	public static void createNewDentist(JTextField nameTxt, JTextField idTxt, JTextField ageTxt, JComboBox cbmSex, 
			JTextField AddressTxt, JTextField PhoneNumberTxt, JTextField SpecialityTxt, JComboBox cbmShift, 
			ArrayList<Dentist> listOfStaff) {
		
		Dentist dentist = new Dentist();
		dentist.setName(nameTxt.getText());
		dentist.setId(Integer.parseInt(idTxt.getText()));
		dentist.setAge(Integer.parseInt(ageTxt.getText()));
		if (cbmSex.getSelectedIndex() == 0)
			dentist.setSex("M");
		else
			dentist.setSex("F");
		dentist.setAddress(AddressTxt.getText());
		dentist.setPhoneNumber(Integer.parseInt(PhoneNumberTxt.getText()));
		dentist.setSpecialty(SpecialityTxt.getText());
		if (cbmShift.getSelectedIndex() == 1)
			dentist.setShift("Manana");
		else
			if (cbmShift.getSelectedIndex() == 2)
				dentist.setShift("Tarde");
			else
				dentist.setShift("Noche");
		ArrayList<Appointment> list = new ArrayList<Appointment>();
		dentist.setListOfAppointments(list);
		listOfStaff.add(dentist);
		DaoDentistXML.addDentist(dentist);
	}
	
	
}
