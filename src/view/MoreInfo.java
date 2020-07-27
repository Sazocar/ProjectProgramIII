package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.*;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoreInfo extends JFrame {

	private JPanel contentPane;
            
	public MoreInfo(Patient patient ) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 412);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(176, 224, 230));
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Nombre: ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(48, 30, 59, 14);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("Cedula:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(56, 65, 49, 19);
		contentPane.add(lblId);
		
		JLabel lblSex = new JLabel("Sexo: ");
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setBounds(67, 103, 38, 14);
		contentPane.add(lblSex);
		
		JLabel lblAddress = new JLabel("Direccion:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(29, 140, 76, 14);
		contentPane.add(lblAddress);
		
		JLabel lblAge = new JLabel("Edad:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(48, 183, 59, 14);
		contentPane.add(lblAge);
		
		JLabel displayName = new JLabel(patient.getName());
		displayName.setHorizontalAlignment(SwingConstants.LEFT);
		displayName.setBounds(117, 30, 112, 14);
		contentPane.add(displayName);
		
		JLabel displayId = new JLabel(String.valueOf(patient.getId()));
		displayId.setHorizontalAlignment(SwingConstants.LEFT);
		displayId.setBounds(117, 67, 68, 14);
		contentPane.add(displayId);
		
		JLabel displaySex = new JLabel(patient.getSex());
		displaySex.setHorizontalAlignment(SwingConstants.LEFT);
		displaySex.setBounds(117, 103, 59, 14);
		contentPane.add(displaySex);
		
		JLabel displayAddress = new JLabel(patient.getAddress());
		displayAddress.setHorizontalAlignment(SwingConstants.LEFT);
		displayAddress.setBounds(117, 140, 112, 14);
		contentPane.add(displayAddress);
		
		
		JLabel displayAge = new JLabel(String.valueOf(patient.getAge()));
		displayAge.setHorizontalAlignment(SwingConstants.LEFT);
		displayAge.setBounds(119, 183, 33, 14);
		contentPane.add(displayAge);
		JButton done = new JButton("");
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		done.setBorder(new IconHelper(10));
		done.setForeground(new Color(176, 224, 230));
		done.setBackground(new Color(176, 224, 230));
		done.setIcon(new ImageIcon(MoreInfo.class.getResource("/Icons/check2.jpg")));
		done.setBounds(245, 289, 55, 55);
		done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(done);
		
		JLabel lbldone = new JLabel("Listo");
		lbldone.setHorizontalAlignment(SwingConstants.CENTER);
		lbldone.setBounds(250, 348, 50, 14);
		contentPane.add(lbldone);
		
		JLabel displayPhone = new JLabel(String.valueOf(patient.getPhoneNumber()));
		displayPhone.setHorizontalAlignment(SwingConstants.LEFT);
		displayPhone.setBounds(119, 219, 33, 14);
		contentPane.add(displayPhone);
		
		JLabel lblNumeroDeTlfn = new JLabel("Numero de Tlfn:");
		lblNumeroDeTlfn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeTlfn.setBounds(10, 219, 97, 14);
		contentPane.add(lblNumeroDeTlfn);
		
		JLabel lblDentist = new JLabel("Odontologo:");
		lblDentist.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDentist.setBounds(10, 253, 97, 14);
		contentPane.add(lblDentist);
		
		JLabel displayDentist = new JLabel(patient.getDentist().getName());
		displayDentist.setHorizontalAlignment(SwingConstants.LEFT);
		displayDentist.setBounds(119, 253, 110, 14);
		contentPane.add(displayDentist);
		
		JLabel lblDate = new JLabel("Fecha de la cita:");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setBounds(10, 284, 97, 14);
		contentPane.add(lblDate);
		
		JLabel displayDate = new JLabel((String) null);
		displayDate.setHorizontalAlignment(SwingConstants.LEFT);
		displayDate.setBounds(119, 284, 68, 14);
		contentPane.add(displayDate);
		
		JLabel lblHour = new JLabel("Hora de la cita:");
		lblHour.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHour.setBounds(10, 315, 97, 14);
		contentPane.add(lblHour); 
		
		JLabel displayHour = new JLabel((String) null);
		displayHour.setHorizontalAlignment(SwingConstants.LEFT);
		displayHour.setBounds(119, 315, 49, 14);
		contentPane.add(displayHour);
		
		JButton done_1 = new JButton("");
		done_1.setIcon(new ImageIcon(MoreInfo.class.getResource("/Icons/recyclebin-icon.jpg")));
		done_1.setForeground(new Color(176, 224, 230));
		done_1.setBorder(new IconHelper(10));
		done_1.setBackground(new Color(176, 224, 230));
		done_1.setBounds(399, 289, 55, 55);
		contentPane.add(done_1);
		
		JLabel lblDelete = new JLabel("Borrar");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setBounds(404, 348, 50, 14);
		contentPane.add(lblDelete);
		
		JButton hist = new JButton("");
		hist.setIcon(new ImageIcon(MoreInfo.class.getResource("/Icons/Play-Books-icon.jpg")));
		hist.setForeground(new Color(176, 224, 230));
		hist.setBorder(new IconHelper(10));
		hist.setBackground(new Color(176, 224, 230));
		hist.setBounds(282, 196, 55, 55);
		contentPane.add(hist);
		
		JButton recipe = new JButton("");
		recipe.setIcon(new ImageIcon(MoreInfo.class.getResource("/Icons/documents-icon.png")));
		recipe.setForeground(new Color(176, 224, 230));
		recipe.setBorder(new IconHelper(10));
		recipe.setBackground(new Color(176, 224, 230));
		recipe.setBounds(363, 196, 47, 47);
		contentPane.add(recipe);
		
		JLabel lblHist = new JLabel("Historia");
		lblHist.setHorizontalAlignment(SwingConstants.CENTER);
		lblHist.setBounds(287, 253, 50, 14);
		contentPane.add(lblHist);
		
		JLabel lblRecipe = new JLabel("Recipe");
		lblRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecipe.setBounds(363, 253, 50, 14);
		contentPane.add(lblRecipe);
		
		JButton modif = new JButton("");
		modif.setIcon(new ImageIcon(MoreInfo.class.getResource("/Icons/Pencil-icon.jpg")));
		modif.setForeground(new Color(176, 224, 230));
		modif.setBorder(new IconHelper(10));
		modif.setBackground(new Color(176, 224, 230));
		modif.setBounds(322, 289, 55, 55);
		contentPane.add(modif);
		
		JLabel lblModif = new JLabel("Modificar");
		lblModif.setHorizontalAlignment(SwingConstants.CENTER);
		lblModif.setBounds(322, 348, 59, 14);
		contentPane.add(lblModif);
	}
}
