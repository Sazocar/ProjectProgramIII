package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

import excepciones.Validations;
import model.Inventory;
import persistence.DaoInventoryXML;

import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class Selecter extends JFrame {

	private JPanel contentPane;
	
	JSpinner spinnerRollos;
	JSpinner spinnerConosDG;
	JSpinner spinnerResina;
	JSpinner spinnerCementoV;
	JSpinner spinnerCementoC;
	JSpinner spinnerBarberos;
	JSpinner spinnerPasta;
	JSpinner spinnerConosP;
	JSpinner spinnerBatasD;
	JSpinner spinnerGuantesE;
	JSpinner spinnerDiques;
	JSpinner spinnerGuantesD;
	JSpinner spinnerGerdex;
	JSpinner spinnerGasas;
	JSpinner spinnerFluor;
	JSpinner spinnerSuturas;
	JSpinner spinnerEugenol;
	JSpinner spinnerCloro;
	JSpinner spinnerFormocresol;
	JSpinner spinnerConosG;
	JSpinner spinnerOxido;
	JSpinner spinnerTapabocas;
	JSpinner spinnerGorros;
	JSpinner spinnerBatasDC;
	
	
	public Selecter(boolean addOrSustract, Inventory inv) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 562);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOxido = new JLabel("Oxido De Zinc:");
		lblOxido.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOxido.setBounds(329, 337, 147, 23);
		getContentPane().add(lblOxido);
		
		JLabel lblGorros = new JLabel("Gorros Desechables:");
		lblGorros.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGorros.setBounds(329, 402, 147, 23);
		getContentPane().add(lblGorros);
		
		JLabel lblGerdex = new JLabel("Gerdex:");
		lblGerdex.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGerdex.setBounds(329, 68, 99, 23);
		getContentPane().add(lblGerdex);
		
		JLabel lblCemento2 = new JLabel("Cemento De Base De Hidroxido De Calcio:");
		lblCemento2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCemento2.setBounds(10, 204, 219, 23);
		getContentPane().add(lblCemento2);
		
		JLabel lblGuantes2 = new JLabel("Guantes Esteriles:");
		lblGuantes2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGuantes2.setBounds(10, 405, 130, 23);
		getContentPane().add(lblGuantes2);
		
		JLabel lblTapabocas = new JLabel("Tapabocas:");
		lblTapabocas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTapabocas.setBounds(329, 368, 147, 23);
		getContentPane().add(lblTapabocas);
		
		JLabel lblConos3 = new JLabel("Conos De Papel Absorbente:");
		lblConos3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblConos3.setBounds(10, 303, 172, 23);
		getContentPane().add(lblConos3);
		
		JLabel lblConos2 = new JLabel("Conos De Gutabercha:");
		lblConos2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblConos2.setBounds(10, 102, 172, 23);
		getContentPane().add(lblConos2);
		
		JLabel lblCloro = new JLabel("Cloro:");
		lblCloro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCloro.setBounds(329, 235, 86, 23);
		getContentPane().add(lblCloro);
		
		JLabel lblConos1 = new JLabel("Conos De Goma:");
		lblConos1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblConos1.setBounds(329, 303, 99, 23);
		getContentPane().add(lblConos1);
		
		JLabel lblBarberos = new JLabel("Barberos Desechables:");
		lblBarberos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBarberos.setBounds(10, 238, 130, 23);
		getContentPane().add(lblBarberos);
		
		JLabel lblBatas2 = new JLabel("Batas De Cirugia:");
		lblBatas2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBatas2.setBounds(329, 436, 147, 23);
		getContentPane().add(lblBatas2);
		
		JLabel lblFluor = new JLabel("Fluor:");
		lblFluor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFluor.setBounds(329, 136, 130, 23);
		getContentPane().add(lblFluor);
		
		JLabel lblBatas = new JLabel("Batas Desechables:");
		lblBatas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBatas.setBounds(10, 337, 147, 23);
		getContentPane().add(lblBatas);
		
		JLabel lblPasta = new JLabel("Pasta Profilactica:");
		lblPasta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPasta.setBounds(10, 269, 130, 23);
		getContentPane().add(lblPasta);
		
		JLabel lblCemento1 = new JLabel("Cemento De Vidrio ionomerico:");
		lblCemento1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCemento1.setBounds(10, 170, 172, 23);
		getContentPane().add(lblCemento1);
		
		JLabel lblSuturas = new JLabel("Suturas:");
		lblSuturas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSuturas.setBounds(329, 170, 130, 23);
		getContentPane().add(lblSuturas);
		
		JLabel lblDiques = new JLabel("Diques De Goma:");
		lblDiques.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDiques.setBounds(10, 371, 130, 23);
		getContentPane().add(lblDiques);
		
		JLabel lblResina = new JLabel("Resina Fotocurada:");
		lblResina.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblResina.setBounds(10, 136, 130, 23);
		getContentPane().add(lblResina);
		
		JLabel lblEugenol = new JLabel("Eugenol:");
		lblEugenol.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEugenol.setBounds(329, 204, 99, 23);
		getContentPane().add(lblEugenol);
		
		JLabel lblGuantes1 = new JLabel("Guantes De Examen:");
		lblGuantes1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGuantes1.setBounds(10, 439, 147, 23);
		getContentPane().add(lblGuantes1);
		
		JLabel lblRollos = new JLabel("Rollos De Algodon:");
		lblRollos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRollos.setBounds(10, 68, 113, 23);
		getContentPane().add(lblRollos);
		
		JLabel lblGasas = new JLabel("Gasas:");
		lblGasas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGasas.setBounds(329, 102, 130, 23);
		getContentPane().add(lblGasas);
		
		JLabel lblFormocresol = new JLabel("Formocresol:");
		lblFormocresol.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFormocresol.setBounds(329, 269, 130, 23);
		getContentPane().add(lblFormocresol);
		
		JLabel lblTitle = new JLabel("");
		if (addOrSustract)
			lblTitle.setText("Indiqe la cantidad de materiales que arrivaron");
		else
			lblTitle.setText("Indique la cantidad de materiales usados");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 494, 29);
		contentPane.add(lblTitle);
		
		 spinnerRollos = new JSpinner();
		 spinnerRollos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerRollos.setBounds(248, 68, 50, 20);
		contentPane.add(spinnerRollos);
		
		 spinnerConosDG = new JSpinner();
		 spinnerConosDG.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerConosDG.setBounds(248, 103, 50, 20);
		contentPane.add(spinnerConosDG);
		
		 spinnerResina = new JSpinner();
		 spinnerResina.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerResina.setBounds(248, 137, 50, 20);
		contentPane.add(spinnerResina);
		
		 spinnerCementoV = new JSpinner();
		 spinnerCementoV.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerCementoV.setBounds(248, 173, 50, 20);
		contentPane.add(spinnerCementoV);
		
		 spinnerCementoC = new JSpinner();
		 spinnerCementoC.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerCementoC.setBounds(248, 207, 50, 20);
		contentPane.add(spinnerCementoC);
		
		 spinnerBarberos = new JSpinner();
		 spinnerBarberos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerBarberos.setBounds(248, 238, 50, 20);
		contentPane.add(spinnerBarberos);
		
		 spinnerPasta = new JSpinner();
		 spinnerPasta.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerPasta.setBounds(248, 272, 50, 20);
		contentPane.add(spinnerPasta);
		
		 spinnerConosP = new JSpinner();
		 spinnerConosP.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerConosP.setBounds(248, 306, 50, 20);
		contentPane.add(spinnerConosP);
		
		 spinnerBatasD = new JSpinner();
		 spinnerBatasD.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerBatasD.setBounds(248, 340, 50, 20);
		contentPane.add(spinnerBatasD);
		
		 spinnerDiques = new JSpinner();
		 spinnerDiques.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerDiques.setBounds(248, 371, 50, 20);
		contentPane.add(spinnerDiques);
		
		 spinnerGuantesE = new JSpinner();
		 spinnerGuantesE.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerGuantesE.setBounds(248, 408, 50, 20);
		contentPane.add(spinnerGuantesE);
		
		 spinnerGuantesD = new JSpinner();
		 spinnerGuantesD.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerGuantesD.setBounds(248, 439, 50, 20);
		contentPane.add(spinnerGuantesD);
		
		 spinnerGerdex = new JSpinner();
		 spinnerGerdex.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerGerdex.setBounds(466, 68, 50, 20);
		contentPane.add(spinnerGerdex);
		
		 spinnerGasas = new JSpinner();
		 spinnerGasas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerGasas.setBounds(465, 102, 50, 20);
		contentPane.add(spinnerGasas);
		
		 spinnerFluor = new JSpinner();
		 spinnerFluor.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerFluor.setBounds(465, 139, 50, 20);
		contentPane.add(spinnerFluor);
		
		 spinnerSuturas = new JSpinner();
		 spinnerSuturas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerSuturas.setBounds(465, 174, 50, 20);
		contentPane.add(spinnerSuturas);
		
		 spinnerEugenol = new JSpinner();
		 spinnerEugenol.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerEugenol.setBounds(465, 207, 50, 20);
		contentPane.add(spinnerEugenol);
		
		 spinnerCloro = new JSpinner();
		 spinnerCloro.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerCloro.setBounds(466, 235, 50, 20);
		contentPane.add(spinnerCloro);
		
		 spinnerFormocresol = new JSpinner();
		 spinnerFormocresol.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerFormocresol.setBounds(466, 272, 50, 20);
		contentPane.add(spinnerFormocresol);
		
		 spinnerConosG = new JSpinner();
		 spinnerConosG.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerConosG.setBounds(466, 306, 50, 20);
		contentPane.add(spinnerConosG);
		
		 spinnerOxido = new JSpinner();
		 spinnerOxido.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerOxido.setBounds(466, 340, 50, 20);
		contentPane.add(spinnerOxido);
		
		 spinnerTapabocas = new JSpinner();
		 spinnerTapabocas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerTapabocas.setBounds(466, 368, 50, 20);
		contentPane.add(spinnerTapabocas);
		
		 spinnerGorros = new JSpinner();
		 spinnerGorros.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerGorros.setBounds(466, 405, 50, 20);
		contentPane.add(spinnerGorros);
		
		 spinnerBatasDC = new JSpinner();
		 spinnerBatasDC.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerBatasDC.setBounds(466, 439, 50, 20);
		contentPane.add(spinnerBatasDC);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addOrSustract) {
					addMaterials(inv);
					JOptionPane.showMessageDialog(null, "Se han agregado los materiales ");
					setVisible(false);
					DaoInventoryXML.deleteInv(inv.getRollosDeAlgodon());
					DaoInventoryXML.updateInv(inv);
				}
				else 
					if (checkNegatives(inv)) {
						sustractMaterials(inv);
						JOptionPane.showMessageDialog(null, "Se han quitado los materiales usados");
						setVisible(false);
						DaoInventoryXML.deleteInv(inv.getRollosDeAlgodon());
						DaoInventoryXML.updateInv(inv);
					}
					else
						Validations.errorMessage("No puede quitar mas cantidad de la que ya hay");
				
				
			}
		});
		btnAceptar.setBounds(148, 489, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCencelar = new JButton("Cancelar");
		btnCencelar.setBounds(302, 489, 89, 23);
		contentPane.add(btnCencelar);
	}
	
	private void addMaterials(Inventory inv) {
		
			inv.setRollosDeAlgodon(inv.getRollosDeAlgodon() + (Integer)spinnerRollos.getValue());
			inv.setCementoDeBaseDeHidroxidoDeCalcio(inv.getCementoDeBaseDeHidroxidoDeCalcio() + (Integer)spinnerCementoC.getValue());
			inv.setConosDeGutabercha(inv.getConosDeGutabercha() + (Integer)spinnerConosDG.getValue());
			inv.setResinaFotocurada(inv.getResinaFotocurada() + (Integer)spinnerResina.getValue());
			inv.setCementoDeVidrioIonomerico(inv.getCementoDeVidrioIonomerico() + (Integer)spinnerCementoV.getValue());
			inv.setBarberosDesechables(inv.getBarberosDesechables() + (Integer)spinnerBarberos.getValue());
			inv.setPastaProfilactica(inv.getPastaProfilactica() + (Integer)spinnerPasta.getValue());
			inv.setConosDePapelAbsorbente(inv.getConosDePapelAbsorbente() + (Integer)spinnerConosP.getValue());
			inv.setBatasDesechables(inv.getBatasDesechables() + (Integer)spinnerBatasD.getValue());
			inv.setDiquesDeGoma(inv.getDiquesDeGoma() + (Integer)spinnerDiques.getValue());
			inv.setGuantesEsteriles(inv.getGuantesEsteriles() + (Integer)spinnerGuantesE.getValue());
			inv.setGuantesDeExamen(inv.getGuantesDeExamen() + (Integer)spinnerGuantesD.getValue());
			inv.setGorrosDesechables(inv.getGorrosDesechables() + (Integer)spinnerGorros.getValue());
			inv.setTapabocas(inv.getTapabocas() + (Integer)spinnerTapabocas.getValue());
			inv.setBatasDeCirugia(inv.getBatasDeCirugia() + (Integer)spinnerBatasDC.getValue());
			inv.setOxidoDeZinc(inv.getOxidoDeZinc() + (Integer)spinnerOxido.getValue());
			inv.setGerdex(inv.getGerdex() + (Integer)spinnerGerdex.getValue());
			inv.setGasas(inv.getGasas() + (Integer)spinnerGasas.getValue());
			inv.setFluor(inv.getFluor() + (Integer)spinnerFluor.getValue());
			inv.setSuturas(inv.getSuturas() + (Integer)spinnerSuturas.getValue());
			inv.setCloro(inv.getCloro() + (Integer)spinnerCloro.getValue());
			inv.setFormocresol(inv.getFormocresol() + (Integer)spinnerFormocresol.getValue());
			inv.setConosDeGoma(inv.getConosDeGoma() + (Integer)spinnerConosG.getValue());
			inv.setEugenol(inv.getEugenol() + (Integer)spinnerEugenol.getValue());

			InventoryPanel.updateColor(inv);
			InventoryPanel.updateData(inv);
	}
	
	private void sustractMaterials(Inventory inv) {
		
		inv.setRollosDeAlgodon(inv.getRollosDeAlgodon() - (Integer)spinnerRollos.getValue());
		inv.setCementoDeBaseDeHidroxidoDeCalcio(inv.getCementoDeBaseDeHidroxidoDeCalcio() - (Integer)spinnerCementoC.getValue());
		inv.setConosDeGutabercha(inv.getConosDeGutabercha() - (Integer)spinnerConosDG.getValue());
		inv.setResinaFotocurada(inv.getResinaFotocurada() - (Integer)spinnerResina.getValue());
		inv.setCementoDeVidrioIonomerico(inv.getCementoDeVidrioIonomerico() - (Integer)spinnerCementoV.getValue());
		inv.setBarberosDesechables(inv.getBarberosDesechables() - (Integer)spinnerBarberos.getValue());
		inv.setPastaProfilactica(inv.getPastaProfilactica() - (Integer)spinnerPasta.getValue());
		inv.setConosDePapelAbsorbente(inv.getConosDePapelAbsorbente() - (Integer)spinnerConosP.getValue());
		inv.setBatasDesechables(inv.getBatasDesechables() - (Integer)spinnerBatasD.getValue());
		inv.setDiquesDeGoma(inv.getDiquesDeGoma() - (Integer)spinnerDiques.getValue());
		inv.setGuantesEsteriles(inv.getGuantesEsteriles() - (Integer)spinnerGuantesE.getValue());
		inv.setGuantesDeExamen(inv.getGuantesDeExamen() - (Integer)spinnerGuantesD.getValue());
		inv.setGorrosDesechables(inv.getGorrosDesechables() - (Integer)spinnerGorros.getValue());
		inv.setTapabocas(inv.getTapabocas() - (Integer)spinnerTapabocas.getValue());
		inv.setBatasDeCirugia(inv.getBatasDeCirugia() - (Integer)spinnerBatasDC.getValue());
		inv.setOxidoDeZinc(inv.getOxidoDeZinc() - (Integer)spinnerOxido.getValue());
		inv.setGerdex(inv.getGerdex() - (Integer)spinnerGerdex.getValue());
		inv.setGasas(inv.getGasas() - (Integer)spinnerGasas.getValue());
		inv.setFluor(inv.getFluor() - (Integer)spinnerFluor.getValue());
		inv.setSuturas(inv.getSuturas() - (Integer)spinnerSuturas.getValue());
		inv.setCloro(inv.getCloro() - (Integer)spinnerCloro.getValue());
		inv.setFormocresol(inv.getFormocresol() - (Integer)spinnerFormocresol.getValue());
		inv.setConosDeGoma(inv.getConosDeGoma() - (Integer)spinnerConosG.getValue());
		inv.setEugenol(inv.getEugenol() - (Integer)spinnerEugenol.getValue());

		InventoryPanel.updateColor(inv);
		InventoryPanel.updateData(inv);
	}
	
	private boolean checkNegatives(Inventory inv) {
		if (((inv.getRollosDeAlgodon() - (Integer)spinnerRollos.getValue()) < 0) ||
			((inv.getCementoDeBaseDeHidroxidoDeCalcio() - (Integer)spinnerCementoC.getValue()) < 0) ||
			((inv.getConosDeGutabercha() - (Integer)spinnerConosDG.getValue()) < 0) ||
			((inv.getResinaFotocurada() - (Integer)spinnerResina.getValue()) < 0) ||
			((inv.getCementoDeVidrioIonomerico() - (Integer)spinnerCementoV.getValue()) < 0) ||
			((inv.getBarberosDesechables() - (Integer)spinnerBarberos.getValue()) < 0) ||
			((inv.getPastaProfilactica() - (Integer)spinnerPasta.getValue()) < 0) ||
			((inv.getConosDePapelAbsorbente() - (Integer)spinnerConosP.getValue()) < 0) ||
			((inv.getBatasDesechables() - (Integer)spinnerBatasD.getValue()) < 0) ||
			((inv.getDiquesDeGoma() - (Integer)spinnerDiques.getValue()) < 0) ||
			((inv.getGuantesEsteriles() - (Integer)spinnerGuantesE.getValue()) < 0) ||
			((inv.getGuantesDeExamen() - (Integer)spinnerGuantesD.getValue()) < 0) ||
			((inv.getGorrosDesechables() - (Integer)spinnerGorros.getValue()) < 0) ||
			((inv.getTapabocas() - (Integer)spinnerTapabocas.getValue()) < 0) ||
			((inv.getBatasDeCirugia() - (Integer)spinnerBatasDC.getValue()) < 0) ||
			((inv.getOxidoDeZinc() - (Integer)spinnerOxido.getValue()) < 0) ||
			((inv.getGerdex() - (Integer)spinnerGerdex.getValue()) < 0) ||
			((inv.getGasas() - (Integer)spinnerGasas.getValue()) < 0) ||
			((inv.getFluor() - (Integer)spinnerFluor.getValue()) < 0) ||
			((inv.getSuturas() - (Integer)spinnerSuturas.getValue()) < 0) ||
			((inv.getCloro() - (Integer)spinnerCloro.getValue()) < 0) ||
			((inv.getFormocresol() - (Integer)spinnerFormocresol.getValue()) < 0) ||
			((inv.getConosDeGoma() - (Integer)spinnerConosG.getValue()) < 0) ||
			((inv.getEugenol() - (Integer)spinnerEugenol.getValue())) < 0)
			return false;
		return true;
	}
	
	
}
