package persistence;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import model.Appointment;
import model.Inventory;
import model.Patient;

public class DaoInventoryXML {
	private static Element root;
    private static String fileLocation = "src/recordsXML/inventory.xml";

    public DaoInventoryXML() {
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
    
    public static Element inventoryXMLElement(Inventory inventory) {
    	
    	Element inv = new Element("inventory");
    	
    	Element rollos = new Element("rollos");
    	rollos.setText(Integer.toString(inventory.getRollosDeAlgodon()));
    	Element gasas = new Element("gasas");
    	gasas.setText(Integer.toString(inventory.getGasas()));
    	Element resina = new Element("resina_fotocurada");
    	resina.setText(Integer.toString(inventory.getResinaFotocurada()));
    	Element cementoV = new Element("cemento_de_vidrio_ionomerico");
    	cementoV.setText(Integer.toString(inventory.getCementoDeVidrioIonomerico()));
    	Element cementoC = new Element("cemento_de_base_de_hidroxido_de_calcio");
    	cementoC.setText(Integer.toString(inventory.getCementoDeBaseDeHidroxidoDeCalcio()));
    	Element conosG = new Element("conos_de_goma");
    	conosG.setText(Integer.toString(inventory.getConosDeGoma()));
    	Element pasta= new Element("pasta");
    	pasta.setText(Integer.toString(inventory.getPastaProfilactica()));
    	Element fluor = new Element("fluor");
    	fluor.setText(Integer.toString(inventory.getFluor()));
    	Element diques = new Element("diques_de_goma");
    	diques.setText(Integer.toString(inventory.getDiquesDeGoma()));
    	Element conosG2 = new Element("conos_de_gutabercha");
    	conosG2.setText(Integer.toString(inventory.getConosDeGutabercha()));
    	Element conosP = new Element("conos_de_papel_absorbente");
    	conosP.setText(Integer.toString(inventory.getConosDePapelAbsorbente()));
    	Element suturas = new Element("suturas");
    	suturas.setText(Integer.toString(inventory.getSuturas()));
    	Element oxido = new Element("oxido_de_zinc");
    	oxido.setText(Integer.toString(inventory.getOxidoDeZinc()));
    	Element eugenol = new Element("eugenol");
    	eugenol.setText(Integer.toString(inventory.getEugenol()));
    	Element formo = new Element("formocresol");
    	formo.setText(Integer.toString(inventory.getFormocresol()));
    	Element barberos = new Element("barberos_desechables");
    	barberos.setText(Integer.toString(inventory.getBarberosDesechables()));
    	Element batasD = new Element("batas_desechables");
    	batasD.setText(Integer.toString(inventory.getBatasDesechables()));
    	Element gerdex = new Element("gerdex");
    	gerdex.setText(Integer.toString(inventory.getGerdex()));
    	Element cloro = new Element("cloro");
    	cloro.setText(Integer.toString(inventory.getCloro()));
    	Element guantesD = new Element("guantes_de_examen");
    	guantesD.setText(Integer.toString(inventory.getGuantesDeExamen()));
    	Element tapabocas = new Element("tapabocas");
    	tapabocas.setText(Integer.toString(inventory.getTapabocas()));
    	Element gorros = new Element("gorros_desechables");
    	gorros.setText(Integer.toString(inventory.getGorrosDesechables()));
    	Element batasC = new Element("batas_de_cirugia");
    	batasC.setText(Integer.toString(inventory.getBatasDeCirugia()));
    	Element guantesE = new Element("guantes_esteriles");
    	guantesE.setText(Integer.toString(inventory.getGuantesEsteriles()));
    	inv.addContent(rollos);
    	inv.addContent(gasas);
    	inv.addContent(resina);
    	inv.addContent(cementoV);
    	inv.addContent(cementoC);
    	inv.addContent(conosG);
    	inv.addContent(pasta);
    	inv.addContent(fluor);
    	inv.addContent(diques);
    	inv.addContent(conosG2);
    	inv.addContent(conosP);
    	inv.addContent(suturas);
    	inv.addContent(oxido);
    	inv.addContent(eugenol);
    	inv.addContent(formo);
    	inv.addContent(barberos);
    	inv.addContent(batasD);
    	inv.addContent(gerdex);
    	inv.addContent(cloro);
    	inv.addContent(guantesD);
    	inv.addContent(tapabocas);
    	inv.addContent(gorros);
    	inv.addContent(batasC);
    	inv.addContent(guantesE);
		return inv;
	}
    
    public static Inventory invToObjet(Element element) throws ParseException {
    	
    	Inventory inv = new Inventory(Integer.parseInt(element.getChildText("rollos")), Integer.parseInt(element.getChildText("gasas")),
    					Integer.parseInt(element.getChildText("resina_fotocurada")), Integer.parseInt(element.getChildText("cemento_de_vidrio_ionomerico")),
    					Integer.parseInt(element.getChildText("cemento_de_base_de_hidroxido_de_calcio")), Integer.parseInt(element.getChildText("conos_de_goma")),
    					Integer.parseInt(element.getChildText("pasta")),Integer.parseInt(element.getChildText("fluor")),
    					Integer.parseInt(element.getChildText("diques_de_goma")), Integer.parseInt(element.getChildText("conos_de_gutabercha")),
    					Integer.parseInt(element.getChildText("conos_de_papel_absorbente")), Integer.parseInt(element.getChildText("suturas")),
    					Integer.parseInt(element.getChildText("oxido_de_zinc")), Integer.parseInt(element.getChildText("eugenol")),
    					Integer.parseInt(element.getChildText("formocresol")), Integer.parseInt(element.getChildText("barberos_desechables")),
    					Integer.parseInt(element.getChildText("batas_desechables")), Integer.parseInt(element.getChildText("gerdex")),
    					Integer.parseInt(element.getChildText("cloro")), Integer.parseInt(element.getChildText("guantes_de_examen")),
    					Integer.parseInt(element.getChildText("tapabocas")), Integer.parseInt(element.getChildText("gorros_desechables")),
    					Integer.parseInt(element.getChildText("batas_de_cirugia")), Integer.parseInt(element.getChildText("guantes_esteriles")));
    	return inv; 
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
    
    public static void updateInv (Inventory nInv) {
        root.addContent(inventoryXMLElement(nInv));
        updateDocument();
    }
    
    public static Inventory createInv() {
    	Element element = new Element("inventory");
    	Inventory inv = new Inventory();
    	if (root.getChild("inventory") != null)
    		element = root.getChild("inventory");
    	else {
    		updateInv(inv);
    		return inv;
    	}
    	try {
    		 inv = invToObjet(element);
    	}
    	catch (ParseException e) {
    		System.out.println("No se pudo cargar el inv");
		}
    	return inv;
    	
    }
    
   
    public static Element search(List raiz, String dato) {
        Iterator i = raiz.iterator();
        while (i.hasNext()) {
            Element e = (Element) i.next();
            if (dato.equals(e.getChild("rollos").getText())) {
                return e;
            }
        }
        
        return null;
    }
    
    public static void deleteInv(int dato) {
    	Element aux = new Element("Inventory");
        aux = root.getChild("inventory");
        root.removeContent(aux);
        updateDocument();
           
        }

}