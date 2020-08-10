package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import model.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import model.IconHelper;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class RecipeFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public RecipeFrame(Patient patient) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 680, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(176, 224, 230));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCancelar = new JLabel("Cancelar");
		lblCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCancelar.setBounds(395, 369, 70, 20);
		contentPane.add(lblCancelar);
		
		JLabel lblName = new JLabel("Nombre: ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(169, 15, 59, 23);
		contentPane.add(lblName);
		
		JLabel displayName = new JLabel(patient.getName());
		displayName.setHorizontalAlignment(SwingConstants.LEFT);
		displayName.setBounds(243, 15, 272, 23);
		contentPane.add(displayName);
		
		JLabel lblId = new JLabel("Cedula:");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setBounds(174, 45, 49, 19);
		contentPane.add(lblId);
		
		JLabel displayId = new JLabel("");
		displayId.setHorizontalAlignment(SwingConstants.LEFT);
		displayId.setBounds(246, 49, 152, 14);
		contentPane.add(displayId);
		
		JLabel lblNotes = new JLabel("Motivo:");
		lblNotes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNotes.setBounds(166, 73, 59, 25);
		contentPane.add(lblNotes);
		
		JLabel displayNotes = new JLabel(patient.getAppointment().getNotes());
		displayNotes.setHorizontalAlignment(SwingConstants.LEFT);
		displayNotes.setBounds(244, 73, 356, 25);
		contentPane.add(displayNotes);
		
		JButton btnNewRecipe = new JButton("");
		btnNewRecipe.setIcon(new ImageIcon(RecipeFrame.class.getResource("/icons/q.png")));
		btnNewRecipe.setForeground(new Color(176, 224, 230));
		btnNewRecipe.setBorder(new IconHelper(260));
		btnNewRecipe.setBackground(new Color(176, 224, 230));
		btnNewRecipe.setBounds(38, 38, 105, 104);
		btnNewRecipe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnNewRecipe);
		
		JLabel lblNewRecipe = new JLabel("Nuevo Recipe");
		lblNewRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewRecipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewRecipe.setBounds(38, 142, 105, 20);
		contentPane.add(lblNewRecipe);
		
		JButton btnClearRecipe = new JButton("");
		btnClearRecipe.setIcon(new ImageIcon(RecipeFrame.class.getResource("/icons/note-icon.png")));
		btnClearRecipe.setForeground(new Color(176, 224, 230));
		btnClearRecipe.setBorder(new IconHelper(260));
		btnClearRecipe.setBackground(new Color(176, 224, 230));
		btnClearRecipe.setBounds(38, 200, 105, 104);
		btnClearRecipe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnClearRecipe);
		
		JLabel lblClearRecipe = new JLabel("Limpiar");
		lblClearRecipe.setHorizontalAlignment(SwingConstants.CENTER);
		lblClearRecipe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClearRecipe.setBounds(38, 304, 105, 20);
		contentPane.add(lblClearRecipe);
		
		JButton btnConfirm = new JButton("");
		btnConfirm.setIcon(new ImageIcon(RecipeFrame.class.getResource("/icons/check2.jpg")));
		btnConfirm.setForeground(new Color(176, 224, 230));
		btnConfirm.setBorder(new IconHelper(260));
		btnConfirm.setBackground(new Color(176, 224, 230));
		btnConfirm.setBounds(303, 312, 58, 54);
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnConfirm);
		
		JLabel lblConfirm = new JLabel("Confirmar");
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirm.setBounds(293, 369, 88, 20);
		contentPane.add(lblConfirm);
		
		JButton btnCancel = new JButton("");
		btnCancel.setIcon(new ImageIcon(RecipeFrame.class.getResource("/icons/arrow-back-icon.png")));
		btnCancel.setForeground(new Color(176, 224, 230));
		btnCancel.setBorder(new IconHelper(260));
		btnCancel.setBackground(new Color(176, 224, 230));
		btnCancel.setBounds(403, 312, 58, 54);
		btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnCancel);
		
		JLabel lblDisplayRecipe = new JLabel(patient.getRecipe().getMedicines());
		lblDisplayRecipe.setFont(new Font("Euphemia UCAS", Font.PLAIN, 15));
		lblDisplayRecipe.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisplayRecipe.setBounds(177, 115, 481, 181);
		contentPane.add(lblDisplayRecipe);
	}
}
