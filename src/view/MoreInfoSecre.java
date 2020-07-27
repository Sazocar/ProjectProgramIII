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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoreInfoSecre extends JFrame {

	private JPanel contentPane;
            
	public MoreInfoSecre(Patient patient ) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 382);
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
		lblAge.setBounds(48, 168, 59, 14);
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
		displayAge.setBounds(119, 168, 33, 14);
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
		done.setIcon(new ImageIcon(MoreInfoSecre.class.getResource("/Icons/check2.jpg")));
		done.setBounds(147, 257, 55, 55);
		done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(done);
		
		JLabel lbldone = new JLabel("Listo");
		lbldone.setHorizontalAlignment(SwingConstants.CENTER);
		lbldone.setBounds(152, 316, 50, 14);
		contentPane.add(lbldone);
		
		JLabel displayPhone = new JLabel(String.valueOf(patient.getPhoneNumber()));
		displayPhone.setHorizontalAlignment(SwingConstants.LEFT);
		displayPhone.setBounds(119, 198, 33, 14);
		contentPane.add(displayPhone);
		
		JLabel lblNumeroDeTlfn = new JLabel("Numero de Tlfn:");
		lblNumeroDeTlfn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeTlfn.setBounds(10, 198, 97, 14);
		contentPane.add(lblNumeroDeTlfn);
		
		JLabel lblDentist = new JLabel("Odontologo:");
		lblDentist.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDentist.setBounds(10, 232, 97, 14);
		contentPane.add(lblDentist);
		
		JLabel displayDentist = new JLabel(patient.getDentist().getName());
		displayDentist.setHorizontalAlignment(SwingConstants.LEFT);
		displayDentist.setBounds(119, 232, 110, 14);
		contentPane.add(displayDentist);
		
		JLabel lblDate = new JLabel("Fecha de la cita:");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setBounds(250, 176, 97, 14);
		contentPane.add(lblDate);
		
		JLabel displayDate = new JLabel(patient.getAppointment().getDate());
		displayDate.setHorizontalAlignment(SwingConstants.LEFT);
		displayDate.setBounds(359, 176, 68, 14);
		contentPane.add(displayDate);
		
		JLabel lblHour = new JLabel("Hora de la cita:");
		lblHour.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHour.setBounds(250, 207, 97, 14);
		contentPane.add(lblHour); 
		
		JLabel displayHour = new JLabel(patient.getAppointment().getHour());
		displayHour.setHorizontalAlignment(SwingConstants.LEFT);
		displayHour.setBounds(359, 207, 49, 14);
		contentPane.add(displayHour);
		
		JLabel lblNotes = new JLabel("Motivo de la cita:");
		lblNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotes.setBounds(250, 232, 97, 14);
		contentPane.add(lblNotes);
		
		JLabel displayNotes = new JLabel(patient.getAppointment().getNotes());
		displayNotes.setHorizontalAlignment(SwingConstants.LEFT);
		displayNotes.setBounds(357, 232, 87, 14);
		contentPane.add(displayNotes);
		
		JLabel lblPic = new JLabel("");
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setIcon(new ImageIcon(MoreInfoSecre.class.getResource("/icons/imgAgregar.jpg")));
		lblPic.setBounds(281, 11, 160, 138);
		contentPane.add(lblPic);
		
		JButton cancelAppoitment = new JButton("");
		cancelAppoitment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patient.getAppointment().setDate("");
				patient.getAppointment().setHour("0");
				patient.getAppointment().setNotes("");
				displayDate.setText(patient.getAppointment().getDate());
				displayHour.setText(patient.getAppointment().getHour());
				displayNotes.setText(patient.getAppointment().getNotes());
				JOptionPane.showMessageDialog(null, "Cita Eliminada");
			}
		});
		cancelAppoitment.setIcon(new ImageIcon(MoreInfoSecre.class.getResource("/icons/recyclebin-icon.jpg")));
		cancelAppoitment.setForeground(new Color(176, 224, 230));
		cancelAppoitment.setBorder(new IconHelper(10));
		cancelAppoitment.setBackground(new Color(176, 224, 230));
		cancelAppoitment.setBounds(234, 257, 55, 55);
		contentPane.add(cancelAppoitment);
		
		JLabel lblEliminarCita = new JLabel("Eliminar Cita");
		lblEliminarCita.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarCita.setBounds(217, 316, 97, 14);
		contentPane.add(lblEliminarCita);
	}
}
