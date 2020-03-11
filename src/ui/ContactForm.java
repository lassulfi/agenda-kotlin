package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.ContactBusiness;

public class ContactForm extends JFrame {

	private JPanel rootPanel;
	private JTextField textName;
	private JTextField textPhone;
	private JButton buttonCancel;
	private JButton buttonSave;
	
	private ContactBusiness mContactBusiness;


	/**
	 * Create the frame.
	 */
	public ContactForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		rootPanel = new JPanel();
		rootPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPanel);
		rootPanel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(12, 12, 66, 15);
		rootPanel.add(lblNome);
		
		textName = new JTextField();
		textName.setBounds(12, 27, 426, 19);
		rootPanel.add(textName);
		textName.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(12, 60, 66, 15);
		rootPanel.add(lblTelefone);
		
		textPhone = new JTextField();
		textPhone.setBounds(12, 87, 190, 19);
		rootPanel.add(textPhone);
		textPhone.setColumns(10);
		
		buttonCancel = new JButton("Cancelar");
		buttonCancel.setBounds(324, 226, 114, 25);
		rootPanel.add(buttonCancel);
		
		buttonSave = new JButton("Salvar");
		buttonSave.setBounds(198, 226, 114, 25);
		rootPanel.add(buttonSave);
		
		setVisible(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
		
		mContactBusiness = new ContactBusiness();
		
		setListeners();
				
	}


	private void setListeners() {
		buttonSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = textName.getText();
					String phone = textPhone.getText();
					mContactBusiness.save(name, phone);
					
					new MainForm();
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
				}
				
			}
		});
		
		buttonCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new MainForm();
				dispose();
			}
		});
		
	}
}
