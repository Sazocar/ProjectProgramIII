package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.IconHelper;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search extends JPanel {
	private JTable table;

	
	public Search() {
		setBackground(new Color(176, 224, 230));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 22, 460, 231);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JButton home = new JButton("");
		home.setBackground(new Color(176, 224, 230));
		home.setForeground(new Color(176, 224, 230));
		home.setIcon(new ImageIcon(Search.class.getResource("/Icons/home2.jpg")));
		home.setBounds(30, 285, 72, 72);
		home.setBorder(new IconHelper(260));
		add(home);
		
		JButton more = new JButton("");
		more.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		more.setForeground(new Color(176, 224, 230));
		more.setBackground(new Color(176, 224, 230));
		more.setIcon(new ImageIcon(Search.class.getResource("/Icons/mas.jpg")));
		more.setBounds(211, 285, 72, 72);
		more.setBorder(new IconHelper(260));
		add(more);
		
		JButton delete = new JButton("");
		delete.setForeground(new Color(176, 224, 230));
		delete.setBackground(new Color(176, 224, 230));
		delete.setIcon(new ImageIcon(Search.class.getResource("/Icons/eliminar.jpg")));
		delete.setBounds(370, 285, 72, 72);
		delete.setBorder(new IconHelper(260));
		add(delete);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(37, 368, 62, 17);
		add(lblHome);
		
		JLabel lblMas = new JLabel("Mas");
		lblMas.setHorizontalAlignment(SwingConstants.CENTER);
		lblMas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMas.setBounds(221, 368, 62, 17);
		add(lblMas);
		
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEliminar.setBounds(380, 368, 62, 17);
		add(lblEliminar);
	}

}
