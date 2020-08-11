package persistence;

import model.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.w3c.dom.NodeList;

public class DaoDentistXML {

    private static Element root;
    private static String fileLocation = "src/recordsXML/dentists.xml";

    public DaoDentistXML() {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            Document doc = builder.build(fileLocation);
            root = doc.getRootElement();
        } catch (JDOMException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("No se pudo iniciar la operacion por: " + ex.getMessage());
        }
    }

    public static Element DentistXmlElement(Dentist nDentist) {
    
        Element Dentist = new Element("Dentist");
        Element name = new Element("name");
        name.setText(nDentist.getName());
        Element id = new Element("id");
        id.setText(Integer.toString(nDentist.getId()));
        Element age = new Element("age");
        age.setText(Integer.toString(nDentist.getAge()));
        Element sex = new Element("sex");
        sex.setText(nDentist.getSex());
        Element address = new Element("address");
        address.setText(nDentist.getAddress());
        Element phoneNumber = new Element("phoneNumber");
        phoneNumber.setText(Integer.toString(nDentist.getPhoneNumber()));
        Element speciality = new Element("speciality");
        speciality.setText(nDentist.getSpecialty());
        Element shift = new Element("shift");
        shift.setText(nDentist.getShift());
        Dentist.addContent(name);
        Dentist.addContent(id);
        Dentist.addContent(sex);
        Dentist.addContent(address);
        Dentist.addContent(age);
        Dentist.addContent(phoneNumber);
        Dentist.addContent(speciality);
        Dentist.addContent(shift);
        return Dentist;
    }

    public static Dentist DentistToObject(Element element) throws ParseException {
        Dentist nDentist = new Dentist(element.getChildText("name"), Integer.parseInt(element.getChildText("id")),
                Integer.parseInt(element.getChildText("age")), element.getChildText("sex"),
                element.getChildText("address"), Integer.parseInt(element.getChildText("phoneNumber")),
                element.getChildText("speciality"), element.getChildText("shift"), null);
        return nDentist;

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

    public static void addDentist(Dentist nDentist) {
        root.addContent(DentistXmlElement(nDentist));
        updateDocument();
    }

    public static void updateDentist(Dentist nDentist) {
        Element aux = new Element("Dentist");
        List Deportistas = root.getChildren("Dentist");
        updateDentist(nDentist);
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

    public static void deleteDentist(Integer id) {
        Element aux = new Element("Dentist");
        List Dentists = root.getChildren("Dentist");
        while (aux != null) {
            aux = DaoDentistXML.search(Dentists, Integer.toString(id));
            if (aux != null) {
                Dentists.remove(aux);
                updateDocument();
            }
        }
    }

    public static Dentist buscarDeportista(Integer id) {
        Element aux = new Element("Dentist");
        List Dentists = root.getChildren("Dentist");
        while (aux != null) {
            aux = search(Dentists, Integer.toString(id));
            if (aux != null) {
                try {
                    return DentistToObject(aux);
                } catch (ParseException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }

    public static void allDentist(ArrayList<Dentist> listOfStaff) {
        for (Object it : root.getChildren()) {
            Element xmlElem = (Element) it;
            try {
                listOfStaff.add(DentistToObject(xmlElem));
                for (int i = 0 ; i <= listOfStaff.size()-1 ; i++) {
                	ArrayList<Appointment> listOfAppointments = new ArrayList<Appointment>();
                	listOfStaff.get(i).setListOfAppointments(listOfAppointments);
                }
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
