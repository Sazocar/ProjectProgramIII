package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import model.Inventory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryPanel extends JPanel {
	static JLabel dpy1;
	static JLabel dpy2;
	static JLabel dpy3;
	static JLabel dpy4;
	static JLabel dpy5;
	static JLabel dpy6;
	static JLabel dpy7;
	static JLabel dpy8;
	static JLabel dpy9;
	static JLabel dpy10;
	static JLabel dpy11;
	static JLabel dpy12;
	static JLabel dpy13;
	static JLabel dpy14;
	static JLabel dpy15;
	static JLabel dpy16;
	static JLabel dpy17;
	static JLabel dpy18;
	static JLabel dpy19;
	static JLabel dpy20;
	static JLabel dpy21;
	static JLabel dpy22;
	static JLabel dpy23;
	static JLabel dpy24;

	public InventoryPanel(Inventory inv) {
		setBackground(new Color(176, 224, 230));
		setLayout(null);
		
		JLabel lblInv = new JLabel("INVENTARIO");
		lblInv.setHorizontalAlignment(SwingConstants.CENTER);
		lblInv.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblInv.setBounds(113, 11, 304, 34);
		add(lblInv);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Selecter add = new Selecter(true , inv);
				add.setVisible(true);
			}
		});
		btnNewButton.setBounds(140, 361, 89, 23);
		add(btnNewButton);
		
		JButton btnUsados = new JButton("Quitar");
		btnUsados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selecter add = new Selecter(false , inv);
				add.setVisible(true);
			}
		});
		btnUsados.setBounds(314, 361, 89, 23);
		add(btnUsados);
		
		dpy1 = new JLabel(Integer.toString(inv.getRollosDeAlgodon()));
		dpy1.setBounds(217, 72, 32, 14);
		add(dpy1);
		
		dpy2 = new JLabel(Integer.toString(inv.getConosDeGutabercha()));
		dpy2.setBounds(217, 106, 32, 14);
		add(dpy2);
		
		dpy3 = new JLabel(Integer.toString(inv.getResinaFotocurada()));
		dpy3.setBounds(217, 140, 32, 14);
		add(dpy3);
		
		dpy4 = new JLabel(Integer.toString(inv.getCementoDeVidrioIonomerico()));
		dpy4.setBounds(217, 174, 32, 14);
		add(dpy4);
		
		dpy5 = new JLabel(Integer.toString(inv.getCementoDeBaseDeHidroxidoDeCalcio()));
		dpy5.setBounds(217, 208, 32, 14);
		add(dpy5);
		
		dpy6 = new JLabel(Integer.toString(inv.getBarberosDesechables()));
		dpy6.setBounds(217, 242, 32, 14);
		add(dpy6);
		
		dpy7 = new JLabel(Integer.toString(inv.getPastaProfilactica()));
		dpy7.setBounds(217, 273, 32, 14);
		add(dpy7);
		
		 dpy8 = new JLabel(Integer.toString(inv.getConosDePapelAbsorbente()));
		dpy8.setBounds(217, 307, 32, 14);
		add(dpy8);
		
		 dpy9 = new JLabel(Integer.toString(inv.getGerdex()));
		dpy9.setBounds(346, 72, 32, 14);
		add(dpy9);
		
		 dpy10 = new JLabel(Integer.toString(inv.getGasas()));
		dpy10.setBounds(346, 106, 32, 14);
		add(dpy10);
		
		 dpy11 = new JLabel(Integer.toString(inv.getFluor()));
		dpy11.setBounds(346, 140, 32, 14);
		add(dpy11);
		
		 dpy12 = new JLabel(Integer.toString(inv.getSuturas()));
		dpy12.setBounds(346, 174, 32, 14);
		add(dpy12);
		
		 dpy13 = new JLabel(Integer.toString(inv.getEugenol()));
		dpy13.setBounds(346, 208, 32, 14);
		add(dpy13);
		
		 dpy14 = new JLabel(Integer.toString(inv.getCloro()));
		dpy14.setBounds(346, 238, 32, 14);
		add(dpy14);
		
		 dpy15 = new JLabel(Integer.toString(inv.getFormocresol()));
		dpy15.setBounds(346, 273, 32, 14);
		add(dpy15);
		
		 dpy16 = new JLabel(Integer.toString(inv.getConosDeGoma()));
		dpy16.setBounds(346, 307, 32, 14);
		add(dpy16);
		
		 dpy17 = new JLabel(Integer.toString(inv.getBatasDesechables()));
		dpy17.setBounds(510, 72, 32, 14);
		add(dpy17);
		
		 dpy18 = new JLabel(Integer.toString(inv.getDiquesDeGoma()));
		dpy18.setBounds(510, 106, 32, 14);
		add(dpy18);
		
		 dpy19 = new JLabel(Integer.toString(inv.getGuantesEsteriles()));
		dpy19.setBounds(510, 140, 32, 14);
		add(dpy19);
		
		 dpy20 = new JLabel(Integer.toString(inv.getGuantesDeExamen()));
		dpy20.setBounds(510, 174, 32, 14);
		add(dpy20);
		
		 dpy21 = new JLabel(Integer.toString(inv.getOxidoDeZinc()));
		dpy21.setBounds(510, 208, 32, 14);
		add(dpy21);
		
		 dpy22 = new JLabel(Integer.toString(inv.getTapabocas()));
		dpy22.setBounds(510, 242, 32, 14);
		add(dpy22);
		
		 dpy23 = new JLabel(Integer.toString(inv.getGorrosDesechables()));
		dpy23.setBounds(510, 273, 32, 14);
		add(dpy23);
		
		 dpy24 = new JLabel(Integer.toString(inv.getBatasDeCirugia()));
		dpy24.setBounds(510, 307, 32, 14);
		add(dpy24);
		
		JLabel lblBatas = new JLabel("Batas Desechables:");
		lblBatas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBatas.setBounds(395, 68, 147, 23);
		add(lblBatas);
		
		JLabel lblTapabocas = new JLabel("Tapabocas:");
		lblTapabocas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTapabocas.setBounds(395, 235, 147, 23);
		add(lblTapabocas);
		
		JLabel lblResina = new JLabel("Resina Fotocurada:");
		lblResina.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblResina.setBounds(10, 136, 130, 23);
		add(lblResina);
		
		JLabel lblCloro = new JLabel("Cloro:");
		lblCloro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCloro.setBounds(255, 235, 113, 23);
		add(lblCloro);
		
		JLabel lblGuantes1 = new JLabel("Guantes De Examen:");
		lblGuantes1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGuantes1.setBounds(395, 170, 147, 23);
		add(lblGuantes1);
		
		JLabel lblOxido = new JLabel("Oxido De Zinc:");
		lblOxido.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOxido.setBounds(395, 204, 147, 23);
		add(lblOxido);
		
		JLabel lblEugenol = new JLabel("Eugenol:");
		lblEugenol.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEugenol.setBounds(255, 204, 130, 23);
		add(lblEugenol);
		
		JLabel lblGerdex = new JLabel("Gerdex:");
		lblGerdex.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGerdex.setBounds(255, 68, 99, 23);
		add(lblGerdex);
		
		JLabel lblBatas2 = new JLabel("Batas De Cirugia:");
		lblBatas2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBatas2.setBounds(395, 303, 147, 23);
		add(lblBatas2);
		
		JLabel lblFormocresol = new JLabel("Formocresol:");
		lblFormocresol.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFormocresol.setBounds(255, 269, 130, 23);
		add(lblFormocresol);
		
		JLabel lblConos3 = new JLabel("Conos De Papel Absorbente:");
		lblConos3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblConos3.setBounds(10, 303, 172, 23);
		add(lblConos3);
		
		JLabel lblConos1 = new JLabel("Conos De Goma:");
		lblConos1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblConos1.setBounds(255, 303, 130, 23);
		add(lblConos1);
		
		JLabel lblRollos = new JLabel("Rollos De Algodon:");
		lblRollos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRollos.setBounds(10, 68, 113, 23);
		add(lblRollos);
		
		JLabel lblCemento2 = new JLabel("Cemento De Base De Hidroxido De Calcio:");
		lblCemento2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCemento2.setBounds(10, 204, 219, 23);
		add(lblCemento2);
		
		JLabel lblPasta = new JLabel("Pasta Profilactica:");
		lblPasta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPasta.setBounds(10, 269, 130, 23);
		add(lblPasta);
		
		JLabel lblSuturas = new JLabel("Suturas:");
		lblSuturas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSuturas.setBounds(255, 170, 130, 23);
		add(lblSuturas);
		
		JLabel lblGasas = new JLabel("Gasas:");
		lblGasas.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGasas.setBounds(255, 102, 130, 23);
		add(lblGasas);
		
		JLabel lblGuantes2 = new JLabel("Guantes Esteriles:");
		lblGuantes2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGuantes2.setBounds(395, 136, 130, 23);
		add(lblGuantes2);
		
		JLabel lblConos2 = new JLabel("Conos De Gutabercha:");
		lblConos2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblConos2.setBounds(10, 102, 172, 23);
		add(lblConos2);
		
		JLabel lblCemento1 = new JLabel("Cemento De Vidrio ionomerico:");
		lblCemento1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCemento1.setBounds(10, 170, 172, 23);
		add(lblCemento1);
		
		JLabel lblBarberos = new JLabel("Barberos Desechables:");
		lblBarberos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBarberos.setBounds(10, 238, 130, 23);
		add(lblBarberos);
		
		JLabel lblFluor = new JLabel("Fluor:");
		lblFluor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFluor.setBounds(255, 136, 130, 23);
		add(lblFluor);
		
		JLabel lblGorros = new JLabel("Gorros Desechables:");
		lblGorros.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblGorros.setBounds(395, 269, 147, 23);
		add(lblGorros);
		
		JLabel lblDiques = new JLabel("Diques De Goma:");
		lblDiques.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDiques.setBounds(395, 102, 130, 23);
		add(lblDiques);
		
		updateColor(inv);
		
	}
	
	public static void updateColor(Inventory inv) {
		if (inv.getRollosDeAlgodon() < 5)
			dpy1.setForeground(new Color(255, 0, 0));
		else
			dpy1.setForeground(new Color(0,0,0));
		
		if (inv.getConosDeGutabercha() < 5)
			dpy2.setForeground(new Color(255, 0, 0));
		else
			dpy2.setForeground(new Color(0,0,0));
		
		if (inv.getResinaFotocurada() < 5)
			dpy3.setForeground(new Color(255, 0, 0));
		else
			dpy3.setForeground(new Color(0,0,0));
		
		if (inv.getCementoDeVidrioIonomerico() < 5)
			dpy4.setForeground(new Color(255, 0, 0));
		else
			dpy4.setForeground(new Color(0,0,0));
		
		if (inv.getCementoDeBaseDeHidroxidoDeCalcio() < 5)
			dpy5.setForeground(new Color(255, 0, 0));
		else
			dpy5.setForeground(new Color(0,0,0));
		
		if (inv.getBarberosDesechables() < 5)
			dpy6.setForeground(new Color(255, 0, 0));
		else
			dpy6.setForeground(new Color(0,0,0));
		
		if (inv.getPastaProfilactica() < 5)
			dpy7.setForeground(new Color(255, 0, 0));
		else
			dpy7.setForeground(new Color(0,0,0));
		
		if (inv.getConosDePapelAbsorbente() < 5)
			dpy8.setForeground(new Color(255, 0, 0));
		else
			dpy8.setForeground(new Color(0,0,0));
		
		if (inv.getGerdex() < 5)
			dpy9.setForeground(new Color(255, 0, 0));
		else
			dpy9.setForeground(new Color(0,0,0));
		
		if (inv.getGasas() < 5)
			dpy10.setForeground(new Color(255, 0, 0));
		else
			dpy10.setForeground(new Color(0,0,0));
		
		if (inv.getFluor() < 5)
			dpy11.setForeground(new Color(255, 0, 0));
		else
			dpy11.setForeground(new Color(0,0,0));
		
		if (inv.getSuturas() < 5)
			dpy12.setForeground(new Color(255, 0, 0));
		else
			dpy12.setForeground(new Color(0,0,0));
		
		if (inv.getEugenol() < 5)
			dpy13.setForeground(new Color(255, 0, 0));
		else
			dpy13.setForeground(new Color(0,0,0));
	
		if (inv.getCloro() < 5)
			dpy14.setForeground(new Color(255, 0, 0));
		else
			dpy14.setForeground(new Color(0,0,0));
		
		if (inv.getFormocresol() < 5)
			dpy15.setForeground(new Color(255, 0, 0));
		else
			dpy15.setForeground(new Color(0,0,0));
		
		if (inv.getConosDeGoma() < 5)
			dpy16.setForeground(new Color(255, 0, 0));
		else
			dpy16.setForeground(new Color(0,0,0));
		
		if (inv.getBatasDesechables() < 5)
			dpy17.setForeground(new Color(255, 0, 0));
		else
			dpy17.setForeground(new Color(0,0,0));
		
		if (inv.getDiquesDeGoma() < 5)
			dpy18.setForeground(new Color(255, 0, 0));
		else
			dpy18.setForeground(new Color(0,0,0));
		
		if (inv.getGuantesEsteriles() < 5)
			dpy19.setForeground(new Color(255, 0, 0));
		else
			dpy19.setForeground(new Color(0,0,0));
		
		if (inv.getGuantesDeExamen() < 5)
			dpy20.setForeground(new Color(255, 0, 0));
		else
			dpy20.setForeground(new Color(0,0,0));
		
		if (inv.getOxidoDeZinc() < 5)
			dpy21.setForeground(new Color(255, 0, 0));
		else
			dpy21.setForeground(new Color(0,0,0));
		
		if (inv.getTapabocas() < 5)
			dpy22.setForeground(new Color(255, 0, 0));
		else
			dpy22.setForeground(new Color(0,0,0));
		
		if (inv.getGorrosDesechables() < 5)
			dpy23.setForeground(new Color(255, 0, 0));
		else
			dpy23.setForeground(new Color(0,0,0));
		
		if (inv.getBatasDeCirugia() < 5)
			dpy24.setForeground(new Color(255, 0, 0));
		else
			dpy24.setForeground(new Color(0,0,0));
	}
	
	public static void updateData(Inventory inv) {
		dpy1.setText(Integer.toString(inv.getRollosDeAlgodon()));
		
		dpy2.setText(Integer.toString(inv.getConosDeGutabercha()));
		
		dpy3.setText(Integer.toString(inv.getResinaFotocurada()));
		
		dpy4.setText(Integer.toString(inv.getCementoDeVidrioIonomerico()));

		dpy5.setText(Integer.toString(inv.getCementoDeBaseDeHidroxidoDeCalcio()));

		dpy6.setText(Integer.toString(inv.getBarberosDesechables()));
		
		dpy7.setText(Integer.toString(inv.getPastaProfilactica()));
		
		dpy8.setText(Integer.toString(inv.getConosDePapelAbsorbente()));

		dpy9.setText(Integer.toString(inv.getGerdex()));
		
		dpy10.setText(Integer.toString(inv.getGasas()));
		
		dpy11.setText(Integer.toString(inv.getFluor()));
		 
		dpy12.setText(Integer.toString(inv.getSuturas()));

		dpy13.setText(Integer.toString(inv.getEugenol()));

		dpy14.setText(Integer.toString(inv.getCloro()));

		dpy15.setText(Integer.toString(inv.getFormocresol()));

		dpy16.setText(Integer.toString(inv.getConosDeGoma()));

		dpy17.setText(Integer.toString(inv.getBatasDesechables()));

		dpy18.setText(Integer.toString(inv.getDiquesDeGoma()));
	
		dpy19.setText(Integer.toString(inv.getGuantesEsteriles()));
	
		dpy20.setText(Integer.toString(inv.getGuantesDeExamen()));
		
		dpy21.setText(Integer.toString(inv.getOxidoDeZinc()));
	 
		dpy22.setText(Integer.toString(inv.getTapabocas()));

		dpy23.setText(Integer.toString(inv.getGorrosDesechables()));

		dpy24.setText(Integer.toString(inv.getBatasDeCirugia()));

	}
}
