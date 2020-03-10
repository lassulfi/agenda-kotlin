package ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import java.awt.FlowLayout;

public class MainForm extends JPanel {
	private JTable table;
	
	public MainForm() {
		
		JPanel rootPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) rootPanel.getLayout();
		add(rootPanel);
		
		JButton buttonNewContact = new JButton("Adicionar");
		rootPanel.add(buttonNewContact);
		
		JButton buttonRemove = new JButton("Remover");
		rootPanel.add(buttonRemove);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		rootPanel.add(horizontalGlue);
		
		JLabel lblNewLabel = new JLabel("New label");
		rootPanel.add(lblNewLabel);
		
		table = new JTable();
		rootPanel.add(table);

	}

}
