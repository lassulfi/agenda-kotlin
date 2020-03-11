package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import business.ContactBusiness;
import entity.ContactEntity;

import javax.swing.WindowConstants;

public class MainForm extends JFrame {

	private JPanel rootPane;
	private JTable tableContacts;
	private JButton buttonNewContact;
	private JButton buttonRemoveContact;
	private JLabel labelContactsCount;
	
	private ContactBusiness mContactBusiness;
	
	public MainForm() {
		
		this.setSize(500, 250);
		
		buttonNewContact = new JButton("Adicionar");
		
		buttonRemoveContact = new JButton("Remover");
		
		labelContactsCount = new JLabel("0");
		
		tableContacts = new JTable();
		tableContacts.setFillsViewportHeight(true);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(buttonNewContact)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonRemoveContact)
							.addPreferredGap(ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
							.addComponent(labelContactsCount))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(136)
							.addComponent(tableContacts, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addGap(152)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(buttonNewContact)
							.addComponent(buttonRemoveContact))
						.addComponent(labelContactsCount))
					.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
					.addComponent(tableContacts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(191))
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
				
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		mContactBusiness = new ContactBusiness();
		
		setListeners();
		
		loadContacts();
	}


	private void loadContacts() {
		List<ContactEntity> contactList = mContactBusiness.getList();
		
		String[] columnNames = {"Nome", "Telefone"};		
		DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);
		
		contactList.forEach(contact -> {
			Object[] o = new Object[2];
			o[0] = contact.getName();
			o[1] = contact.getPhone();
			
			model.addRow(o);
		});
		
		tableContacts.clearSelection();
		tableContacts.setModel(model);
		
		labelContactsCount.setText(mContactBusiness.getContactCountDescription());
	}


	private void setListeners() {
		buttonNewContact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ContactForm();
				dispose();
			}
		});	
		
		tableContacts.getSelectionModel()
			.addListSelectionListener(new ListSelectionListener() {
			
				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					
				}
		});
		
		buttonRemoveContact.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
