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

	private static Element DentistXmlElement(Dentist nDentist) {
		/*
		 * Aqui lleno todo el contexto que le voy a insertar al archivo, es decir el
		 * nodo proncipal que es Estudiante con los atributos que le corresponden, los
		 * cuales seria cedula,nombre y apellido,etc. Debes ser muuuuy preciso en este
		 * llenado, es decir, indicar los atributos con pelos y señales exactamente como
		 * están en la Clase, de lo contrario la tabla XML no se generará y no se
		 * produzca ningún error que te advierta que falta un acento, un espacio u otro
		 * símbolo
		 */
		Element Dentist = new Element("Deportista");// nombre de la Clase

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
		phoneNumber.setText(Double.toString(nDentist.getPhoneNumber()));
		Element speciality = new Element("speciality");
		speciality.setText(nDentist.getSpecialty());
		// Aqui va el arrayList de appointments
		Dentist.addContent(name);
		Dentist.addContent(id);
		Dentist.addContent(sex);
		Dentist.addContent(address);
		Dentist.addContent(age);
		Dentist.addContent(phoneNumber);
		Dentist.addContent(speciality);
		return Dentist;
	}

	public static Dentist DentistToObject(Element element) throws ParseException {
		Dentist nDeportista = new Dentist(element.getChildText("name"), Integer.parseInt(element.getChildText("id")),
				Integer.parseInt(element.getChildText("age")), element.getChildText("sex"),
				element.getChildText("address"), Integer.parseInt(element.getChildText("phoneNumber")),
				element.getChildText("speciality"), element.getChildText("shift"));
		return nDeportista;

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

	public static void allDentist(ArrayList<Person> listOfStaff) {
		/*
		 * Para obtener todas las Personas registradas
		 * 
		 * @return ArrayList con todos los objetos Estudiante
		 */
		for (Object it : root.getChildren()) {
			Element xmlElem = (Element) it;
			try {
				listOfStaff.add(DentistToObject(xmlElem));
			} catch (ParseException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

}
