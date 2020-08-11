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

public class DaoAppointmentsXML {

    private static Element root;
    private static String fileLocation = "src/recordsXML/appointments.xml";

    public DaoAppointmentsXML() {
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

    public static Element AppointmentXmlElement(Appointment nAppointment) {
       
        Element Appointment = new Element("Appointment");

        
        Element dentist = DaoDentistXML.DentistXmlElement(nAppointment.getDentist());
        Element date = new Element("date");
        date.setText(nAppointment.getDate());
        Element hour =new Element("hour");
        hour.setText(nAppointment.getHour());
        Element notes =new Element("notes");
        notes.setText(nAppointment.getNotes());
        Element patientId = new Element("patientId");
        patientId.setText(Integer.toString(nAppointment.getPatientId()));
        Appointment.addContent(dentist);
        Appointment.addContent(date);
        Appointment.addContent(hour);
        Appointment.addContent(notes);
        Appointment.addContent(patientId);
        return Appointment;
    }
    

    public static Appointment AppointmentToObject(Element element) throws ParseException {
        Appointment nAppointment = new Appointment(DaoDentistXML.DentistToObject(element.getChild("Dentist")), element.getChildText("date"), element.getChildText("hour"), 
                element.getChildText("notes"), Integer.parseInt(element.getChildText("patientId")));
        return nAppointment;

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

    public static void updateAppointment (Appointment nAppointment) {
        root.addContent(AppointmentXmlElement(nAppointment));
        updateDocument();
    }

    public static Element search(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("patientId").getText())) {
                return e;
            }
        }
        return null;
    }

    public static void deleteAppointment(Integer patientId) {
        Element aux = new Element("Appointment");
        List Appointments = root.getChildren("Appointment");
        while (aux != null) {
            aux = DaoAppointmentsXML.search(Appointments, Integer.toString(patientId));
            if (aux != null) {
                Appointments.remove(aux);
                updateDocument();
            }
        }
    }

    public static Appointment buscarAppointment(Integer patientId) {
        Element aux = new Element("Appointment");
        List Appointments = root.getChildren("Appointment");
        while (aux != null) {
            aux = search(Appointments, Integer.toString(patientId));
            if (aux != null) {
                try {
                    return AppointmentToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public static void allAppointments(ArrayList<Appointment> listOfAppointments) {
        
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                listOfAppointments.add(AppointmentToObject(xmlElem));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
