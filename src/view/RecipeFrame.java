package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import model.IconHelper;
import persistence.DaoPatientXML;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.DropMode;
import javax.swing.JScrollPane;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import controller.ControlFields;

import javax.swing.border.LineBorder;

public class RecipeFrame extends JFrame {

	private JPanel contentPane;
	private JTextPane txtDisplayRecipe; 

	/**
	 * Create the frame.
	 */
	public RecipeFrame(Patient patient) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAtras = new JLabel("Atras");
		lblAtras.setBounds(395, 369, 70, 20);
		lblAtras.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtras.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblAtras);
		
		JLabel lblName = new JLabel("Paciente:");
		lblName.setBounds(169, 15, 59, 23);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblName);
		
		JLabel displayName = new JLabel(patient.getName());
		displayName.setBounds(243, 15, 138, 23);
		displayName.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(displayName);
		
		JLabel lblId = new JLabel("Cedula:");
		lblId.setBounds(174, 45, 49, 19);
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblId);
		
		JLabel displayId = new JLabel(Integer.toString(patient.getId()));
		displayId.setBounds(243, 50, 152, 14);
		displayId.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(displayId);
		
		JLabel lblNotes = new JLabel("Motivo:");
		lblNotes.setBounds(166, 73, 59, 25);
		lblNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblNotes);
		
		JLabel displayNotes = new JLabel(patient.getAppointment().getNotes());
		displayNotes.setBounds(244, 73, 357, 25);
		displayNotes.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(displayNotes);
		
		JButton btnNewRecipe = new JButton("");
		btnNewRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateRecipe createRecipeFrame = new CreateRecipe(patient, txtDisplayRecipe);
				createRecipeFrame.setVisible(true);
			}
		});
		btnNewRecipe.setBounds(38, 38, 105, 104);
		btnNewRecipe.setIcon(new ImageIcon(RecipeFrame.class.getResource("/icons/q.png")));
		btnNewRecipe.setForeground(new Color(176, 224, 230));
		btnNewRecipe.setBorder(new IconHelper(260));
		btnNewRecipe.setBackground(new Color(176, 224, 230));
		btnNewRecipe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewRecipe);
		
		JLabel lblNewRecipe = new JLabel("Nuevo Recipe");
		lblNewRecipe.setBounds(38, 143, 105, 20);
		lblNewRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewRecipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewRecipe);
		
		JButton btnClearRecipe = new JButton("");
		btnClearRecipe.setBounds(38, 200, 105, 104);
		btnClearRecipe.setIcon(new ImageIcon(RecipeFrame.class.getResource("/icons/note-icon.png")));
		btnClearRecipe.setForeground(new Color(176, 224, 230));
		btnClearRecipe.setBorder(new IconHelper(260));
		btnClearRecipe.setBackground(new Color(176, 224, 230));
		btnClearRecipe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnClearRecipe);
		
		JLabel lblClearRecipe = new JLabel("Limpiar");
		lblClearRecipe.setBounds(38, 305, 105, 20);
		lblClearRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblClearRecipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblClearRecipe);
		
		JButton btnConfirm = new JButton("");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoPatientXML.deletePatient(patient.getId());
                DaoPatientXML.updatePatient(patient);
                JOptionPane.showMessageDialog(null, "Recipe generado exitosamente");
                setVisible(false);
			}
		});
		btnConfirm.setBounds(303, 312, 58, 54);
		btnConfirm.setIcon(new ImageIcon(RecipeFrame.class.getResource("/icons/check2.jpg")));
		btnConfirm.setForeground(new Color(176, 224, 230));
		btnConfirm.setBorder(new IconHelper(260));
		btnConfirm.setBackground(new Color(176, 224, 230));
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnConfirm);
		
		JLabel lblConfirm = new JLabel("Confirmar");
		lblConfirm.setBounds(293, 369, 88, 20);
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblConfirm);
		
		JButton btnCancel = new JButton("");
		btnCancel.setBounds(403, 312, 58, 54);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {{
                    setVisible(false);
                }
			}
		});
		btnCancel.setIcon(new ImageIcon(RecipeFrame.class.getResource("/icons/arrow-back-icon.png")));
		btnCancel.setForeground(new Color(176, 224, 230));
		btnCancel.setBorder(new IconHelper(260));
		btnCancel.setBackground(new Color(176, 224, 230));
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnCancel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
		scrollPane.getViewport().setBackground(new Color(176, 224, 230));
		scrollPane.setBounds(191, 119, 463, 185);
		
		
		this.txtDisplayRecipe = new JTextPane();
		this.txtDisplayRecipe.setFont(new Font("Euphemia UCAS", Font.PLAIN, 15));
		this.txtDisplayRecipe.setEditable(false);
		this.txtDisplayRecipe.setBounds(190, 119, 464, 165);
		this.txtDisplayRecipe.setBackground(new Color(176, 224, 230));
		this.txtDisplayRecipe.setText(patient.getRecipe().getMedicines() + "\n\n   Odontologo: " + patient.getDentist().getName());
		this.txtDisplayRecipe.setCaretPosition(0);
		
		scrollPane.setViewportView(txtDisplayRecipe);
		
		contentPane.add(scrollPane);
		
		JLabel lblOdontologoName = new JLabel("Odontologo:");
		lblOdontologoName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOdontologoName.setBounds(403, 15, 86, 23);
		contentPane.add(lblOdontologoName);
		
		JLabel displayOdontolgoName = new JLabel(patient.getDentist().getName());
		displayOdontolgoName.setHorizontalAlignment(SwingConstants.LEFT);
		displayOdontolgoName.setBounds(504, 15, 150, 23);
		contentPane.add(displayOdontolgoName);
		
		btnClearRecipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				patient.getRecipe().setMedicines("");
				txtDisplayRecipe.setText("\n\n   Odontologo: " + patient.getDentist().getName());
			}
		});
		
		
		
	}

	public JTextPane getTxtDisplayRecipe() {
		return txtDisplayRecipe;
	}

	public void setTxtDisplayRecipe(JTextPane txtDisplayRecipe) {
		this.txtDisplayRecipe = txtDisplayRecipe;
	}
	
	
}
