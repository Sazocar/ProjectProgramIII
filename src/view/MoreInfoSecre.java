package view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.*;
import persistence.DaoAppointmentsXML;
import persistence.DaoPatientXML;

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
            
	public MoreInfoSecre(Patient patient, Clinic clinic) {
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
		lblName.setBounds(58, 30, 59, 23);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("Cedula:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(66, 65, 49, 19);
		contentPane.add(lblId);
		
		JLabel lblSex = new JLabel("Sexo: ");
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setBounds(77, 103, 38, 14);
		contentPane.add(lblSex);
		
		JLabel lblAddress = new JLabel("Direccion:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(41, 136, 76, 20);
		contentPane.add(lblAddress);
		
		JLabel lblAge = new JLabel("Edad:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(58, 170, 59, 14);
		contentPane.add(lblAge);
		
		JLabel displayName = new JLabel(patient.getName());
		displayName.setHorizontalAlignment(SwingConstants.LEFT);
		displayName.setBounds(127, 30, 152, 23);
		contentPane.add(displayName);
		
		JLabel displayId = new JLabel(String.valueOf(patient.getId()));
		displayId.setHorizontalAlignment(SwingConstants.LEFT);
		displayId.setBounds(127, 67, 152, 14);
		contentPane.add(displayId);
		
		JLabel displaySex = new JLabel(patient.getSex());
		displaySex.setHorizontalAlignment(SwingConstants.LEFT);
		displaySex.setBounds(127, 103, 59, 14);
		contentPane.add(displaySex);
		
		JLabel displayAddress = new JLabel(patient.getAddress());
		displayAddress.setHorizontalAlignment(SwingConstants.LEFT);
		displayAddress.setBounds(127, 136, 191, 20);
		contentPane.add(displayAddress);
		
		
		JLabel displayAge = new JLabel(String.valueOf(patient.getAge()));
		displayAge.setHorizontalAlignment(SwingConstants.LEFT);
		displayAge.setBounds(129, 170, 33, 14);
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
		done.setBounds(145, 269, 55, 55);
		done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(done);
		
		JLabel lbldone = new JLabel("Listo");
		lbldone.setHorizontalAlignment(SwingConstants.CENTER);
		lbldone.setBounds(147, 328, 50, 14);
		contentPane.add(lbldone);
		
		JLabel displayPhone = new JLabel(String.valueOf(patient.getPhoneNumber()));
		displayPhone.setHorizontalAlignment(SwingConstants.LEFT);
		displayPhone.setBounds(129, 202, 126, 14);
		contentPane.add(displayPhone);
		
		JLabel lblNumeroDeTlfn = new JLabel("Numero de Tlfn:");
		lblNumeroDeTlfn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeTlfn.setBounds(10, 202, 107, 14);
		contentPane.add(lblNumeroDeTlfn);
		
		JLabel lblDentist = new JLabel("Odontologo:");
		lblDentist.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDentist.setBounds(20, 232, 97, 24);
		contentPane.add(lblDentist);
		
		JLabel displayDentist = new JLabel(patient.getDentist().getName());
		displayDentist.setHorizontalAlignment(SwingConstants.LEFT);
		displayDentist.setBounds(129, 232, 110, 25);
		contentPane.add(displayDentist);
		
		JLabel lblDate = new JLabel("Fecha:");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setBounds(249, 175, 59, 14);
		contentPane.add(lblDate);
		
		JLabel displayDate = new JLabel(patient.getAppointment().getDate());
		displayDate.setHorizontalAlignment(SwingConstants.LEFT);
		displayDate.setBounds(333, 175, 108, 14);
		contentPane.add(displayDate);
		
		JLabel lblHour = new JLabel("Hora:");
		lblHour.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHour.setBounds(249, 204, 59, 14);
		contentPane.add(lblHour); 
		
		JLabel displayHour = new JLabel(patient.getAppointment().getHour());
		displayHour.setHorizontalAlignment(SwingConstants.LEFT);
		displayHour.setBounds(333, 204, 85, 14);
		contentPane.add(displayHour);
		
		JLabel lblNotes = new JLabel("Motivo:");
		lblNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotes.setBounds(253, 231, 59, 25);
		contentPane.add(lblNotes);
		
		JLabel displayNotes = new JLabel(patient.getAppointment().getNotes());
		displayNotes.setHorizontalAlignment(SwingConstants.LEFT);
		displayNotes.setBounds(333, 231, 117, 25);
		contentPane.add(displayNotes);
		
		JLabel lblPic = new JLabel("");
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		if (patient.getSex().equalsIgnoreCase("m")) 
			lblPic.setIcon(new ImageIcon(MoreInfoSecre.class.getResource("/icons/Man-1-icon.png")));
		else if (patient.getSex().equalsIgnoreCase("f"))
			lblPic.setIcon(new ImageIcon(MoreInfoSecre.class.getResource("/icons/Woman-9-icon.png")));
		lblPic.setBounds(281, 11, 160, 138);
		contentPane.add(lblPic);
		
		JButton btnCancelAppointment = new JButton("");
		btnCancelAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Dentist dentist : clinic.getListOfStaff()) {
					if (patient.getDentist().getId() == dentist.getId())
						dentist.getListOfAppointments().remove(patient.getAppointment());
				}
				clinic.getListOfAppointments().remove(patient.getAppointment());				
				patient.getAppointment().setDate("");;
				patient.getAppointment().setHour("");
				patient.getAppointment().setNotes("");
				DaoPatientXML.deletePatient(patient.getId());
				DaoPatientXML.updatePatient(patient);
				DaoAppointmentsXML.deleteAppointment(patient.getId());
				DaoAppointmentsXML.updateAppointment(patient.getAppointment());
				displayDate.setText(patient.getAppointment().getDate());
				displayHour.setText(patient.getAppointment().getHour());
				displayNotes.setText(patient.getAppointment().getNotes());
				JOptionPane.showMessageDialog(null, "Cita Eliminada");
			}
		});
		btnCancelAppointment.setIcon(new ImageIcon(MoreInfoSecre.class.getResource("/icons/recyclebin-icon.jpg")));
		btnCancelAppointment.setForeground(new Color(176, 224, 230));
		btnCancelAppointment.setBorder(new IconHelper(10));
		btnCancelAppointment.setBackground(new Color(176, 224, 230));
		btnCancelAppointment.setBounds(232, 269, 55, 55);
		btnCancelAppointment.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnCancelAppointment);
		
		JLabel lblEliminarCita = new JLabel("Eliminar Cita");
		lblEliminarCita.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarCita.setBounds(215, 328, 97, 14);
		contentPane.add(lblEliminarCita);
	}
}
