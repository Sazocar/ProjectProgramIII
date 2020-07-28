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

    private static Element PatientXmlElement(Patient nPatient) {
        /*
		 * Aqui lleno todo el contexto que le voy a insertar al archivo, es decir el
		 * nodo proncipal que es Estudiante con los atributos que le corresponden, los
		 * cuales seria cedula,nombre y apellido,etc. Debes ser muuuuy preciso en este
		 * llenado, es decir, indicar los atributos con pelos y señales exactamente como
		 * están en la Clase, de lo contrario la tabla XML no se generará y no se
		 * produzca ningún error que te advierta que falta un acento, un espacio u otro
		 * símbolo
         */
        Element Patient = new Element("Patient");// nombre de la Clase
        
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
        Patient.addContent(name);
        Patient.addContent(id);
        Patient.addContent(sex);
        Patient.addContent(address);
        Patient.addContent(age);
        Patient.addContent(phoneNumber);
        Patient.addContent(dentist);
        Patient.addContent(appointment);
        return Patient;
    }
    
    
    public static Patient PatientToObject(Element element) throws ParseException {
        Patient nPatient = new Patient(element.getChildText("name"), Integer.parseInt(element.getChildText("id")),
                Integer.parseInt(element.getChildText("age")), element.getChildText("sex"),
                element.getChildText("address"), Integer.parseInt(element.getChildText("phoneNumber")),
                DaoDentistXML.DentistToObject(element.getChild("Dentist")), 
                DaoAppointmentsXML.AppointmentToObject(element.getChild("Appointment")), null, null);
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
        /*
		 * Para obtener todas las Personas registradas
		 * 
		 * @return ArrayList con todos los objetos Dentist
         */
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
