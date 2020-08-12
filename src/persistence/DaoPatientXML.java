package persistence;

import model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.*;

import javax.sound.midi.Track;
import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.NodeList;

public class DaoPatientXML {

    private static Element root;
    private static String fileLocation = "src/recordsXML/patients.xml";

    public DaoPatientXML() {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("Can't inicializate operation: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Can't inicializate operation: " + ex.getMessage());
        }
    }
    
    private static Element recipeXmlElement(Recipe nRecipe) {
    	
    	Element Recipe = new Element("Recipe");

    	Element medicine = new Element("medicine");
    	medicine.setText(nRecipe.getMedicines());
    	Recipe.addContent(medicine);
    	return Recipe;
    }
    
    private static Element histXmlElement(History nHist) {
    	
    	Element Hist = new Element("History");
    	
    	Element treatment = new Element("history");
    	treatment.setText(nHist.getTreatment());
    	Hist.addContent(treatment);
    	return Hist;
    }

    private static Element PatientXmlElement(Patient nPatient) {
      
        Element Patient = new Element("Patient");
        
        Element name = new Element("name");
        name.setText(nPatient.getName());
        Element id = new Element("id");
        id.setText(Integer.toString(nPatient.getId()));
        Element age = new Element("age");
        age.setText(Integer.toString(nPatient.getAge()));
        Element sex = new Element("sex");
        sex.setText(nPatient.getSex());
        Element address = new Element("address");
        address.setText(nPatient.getAddress());
        Element phoneNumber = new Element("phoneNumber");
        phoneNumber.setText(Integer.toString(nPatient.getPhoneNumber()));
        Element dentist = DaoDentistXML.DentistXmlElement(nPatient.getDentist());
        Element appointment = DaoAppointmentsXML.AppointmentXmlElement(nPatient.getAppointment());
        Element recipe = recipeXmlElement(nPatient.getRecipe());
        Element hist = histXmlElement(nPatient.getHistory());
        Element listId = new Element("listId");
        listId.setText(Integer.toString(nPatient.getListId()));
        Patient.addContent(name);
        Patient.addContent(id);
        Patient.addContent(sex);
        Patient.addContent(address);
        Patient.addContent(age);
        Patient.addContent(phoneNumber);
        Patient.addContent(dentist);
        Patient.addContent(appointment);
        Patient.addContent(recipe);
        Patient.addContent(hist);
        Patient.addContent(listId);
        return Patient;
    }
    
    private static Recipe recipeToObjet(Element element) throws ParseException{
    	Recipe nRecipe = new Recipe(element.getChildText("medicine"));
    	return nRecipe;
    }
    
    private static History histToObjet(Element element) throws ParseException{
    	History nHist = new History(element.getChildText("history"));
    	return nHist;
    }
    
    
    public static Patient PatientToObject(Element element) throws ParseException {
        Patient nPatient = new Patient(element.getChildText("name"), Integer.parseInt(element.getChildText("id")),
                Integer.parseInt(element.getChildText("age")), element.getChildText("sex"),
                element.getChildText("address"), Integer.parseInt(element.getChildText("phoneNumber")),
                DaoDentistXML.DentistToObject(element.getChild("Dentist")), 
                DaoAppointmentsXML.AppointmentToObject(element.getChild("Appointment")), 
                recipeToObjet(element.getChild("Recipe")), histToObjet(element.getChild("History")), Integer.parseInt(element.getChildText("listId")));
        return nPatient;

    }

    public static void updateDocument() {
        try {
            XMLOutputter out = new XMLOutputter(org.jdom.output.Format.getPrettyFormat());
            FileOutputStream file = new FileOutputStream(fileLocation);
            out.output(root, file);
            file.flush();
            file.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void updatePatient (Patient nPatient) {
        root.addContent(PatientXmlElement(nPatient));
        updateDocument();
    }

    public static Element search(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("id").getText())) {
                return e;
            }
        }
        return null;
    }

    public static void deletePatient(Integer id) {
        Element aux = new Element("Patient");
        List Patients = root.getChildren("Patient");
        while (aux != null) {
            aux = DaoPatientXML.search(Patients, Integer.toString(id));
            if (aux != null) {
                Patients.remove(aux);
                updateDocument();
            }
        }
    }

    public static Patient searchPatient(Integer id) {
        Element aux = new Element("Patient");
        List Patients = root.getChildren("Patient");
        while (aux != null) {
            aux = search(Patients, Integer.toString(id));
            if (aux != null) {
                try {
                    return PatientToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public static void allPatients(ArrayList<Patient> listOfPatients) {
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                listOfPatients.add(PatientToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
