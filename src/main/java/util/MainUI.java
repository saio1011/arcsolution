package util;

import java.awt.EventQueue;

import kundenverwaltung.domain.Kundedomain;
import kundenverwaltung.service.*;


import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.CardLayout;

import javax.swing.JPanel;

public class MainUI extends JFrame {

	private JFrame frame;
	private JPanel mainUI;
	private JPanel kundeUI;
	private JLabel lblTitle;
	private JTextField txtFldCautaClient;
	private JList listKundenInDB;
	private JLabel lblClientiInDb;
	private JScrollPane scrollPane;
	private JButton btnCautaClient;
	private JButton btnCreazaClient;
	private JLabel lblTitleKundeUI;
	private JLabel lblDenumireClient;
	private JTextField txtFldDenumireClient;
	private JLabel lblNrCtr;
	private JTextField txtFldNrCtr;
	private JLabel lblActeAditionale;
	private JTextField txtFldActeAditionale;
	private JLabel lblValabilitateCtr;
	private JTextField txtFldValabilitateCtr;
	private JButton btnSalveazaClient;
	private JButton btnCancel;
	private JButton btnDebitorenVerwaltung;
	private JPanel debitorenMainUI;
	private JLabel lblTitleDebMainUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Kundeservice ks = new Kundeservice();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		mainUI = new JPanel();
		frame.getContentPane().add(mainUI, "name_27322271565082");
		mainUI.setLayout(null);
		
		lblTitle = new JLabel("Arc Solution");
		lblTitle.setBounds(21, 21, 135, 14);
		mainUI.add(lblTitle);
		
		btnCautaClient = new JButton("Cauta Client");
		btnCautaClient.setBounds(206, 120, 135, 23);
		btnCautaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//read customers from db
				DBverbindung.dbconnect();
				ArrayList<Kundedomain> allKunden = ks.findKundenByName(txtFldCautaClient.getText());
				ArrayList<Kundedomain> allKunden1 = ks.getAllKunden();
				DBverbindung.dbdisconect();	
				
				//add customers into listOutput
				listKundenInDB.setVisible(true);
				btnDebitorenVerwaltung.setVisible(true);
				scrollPane.setVisible(true);
				lblClientiInDb.setVisible(true);
				listKundenInDB.setListData(allKunden.toArray());
			}
		});
		mainUI.add(btnCautaClient);
		
		btnCreazaClient = new JButton("Creaza Client");
		btnCreazaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainUI.setVisible(false);
				kundeUI.setVisible(true);
			}
		});
		btnCreazaClient.setBounds(206, 154, 135, 23);
		mainUI.add(btnCreazaClient);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 316, 704, 182);
		scrollPane.setVisible(false);
		mainUI.add(scrollPane);
		
		listKundenInDB = new JList();
		scrollPane.setViewportView(listKundenInDB);
		
		lblClientiInDb = new JLabel("Clienti in DB");
		lblClientiInDb.setBounds(21, 290, 111, 14);
		lblClientiInDb.setVisible(false);
		mainUI.add(lblClientiInDb);
		
		txtFldCautaClient = new JTextField();
		txtFldCautaClient.setBounds(382, 120, 343, 23);
		mainUI.add(txtFldCautaClient);
		txtFldCautaClient.setColumns(10);
		
		btnDebitorenVerwaltung = new JButton("Debitorenverwaltung");
		btnDebitorenVerwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//
				List<Kundedomain> selectedItems = new ArrayList<Kundedomain>();
				selectedItems = listKundenInDB.getSelectedValuesList();
				
				
				mainUI.setVisible(false);
				debitorenMainUI.setVisible(true);
				
				lblTitleDebMainUI.setText(selectedItems.toString());
			}
		});
		btnDebitorenVerwaltung.setBounds(136, 282, 167, 23);
		btnDebitorenVerwaltung.setVisible(false);
		mainUI.add(btnDebitorenVerwaltung);
			
		kundeUI = new JPanel();
		frame.getContentPane().add(kundeUI, "name_27327655750175");
		kundeUI.setLayout(null);
		
		lblTitleKundeUI = new JLabel("Introduce Client Nou");
		lblTitleKundeUI.setBounds(10, 31, 152, 14);
		kundeUI.add(lblTitleKundeUI);
		
		lblDenumireClient = new JLabel("Denumire Client");
		lblDenumireClient.setBounds(51, 76, 137, 20);
		kundeUI.add(lblDenumireClient);
		
		txtFldDenumireClient = new JTextField();
		txtFldDenumireClient.setColumns(10);
		txtFldDenumireClient.setBounds(211, 76, 314, 20);
		kundeUI.add(txtFldDenumireClient);
		
		lblNrCtr = new JLabel("Nr. Contract");
		lblNrCtr.setBounds(51, 114, 137, 17);
		kundeUI.add(lblNrCtr);
		
		txtFldNrCtr = new JTextField();
		txtFldNrCtr.setColumns(10);
		txtFldNrCtr.setBounds(211, 112, 314, 20);
		kundeUI.add(txtFldNrCtr);
		
		lblActeAditionale = new JLabel("Acte Aditionale");
		lblActeAditionale.setBounds(51, 150, 137, 17);
		kundeUI.add(lblActeAditionale);
		
		txtFldActeAditionale = new JTextField();
		txtFldActeAditionale.setColumns(10);
		txtFldActeAditionale.setBounds(211, 148, 314, 20);
		kundeUI.add(txtFldActeAditionale);
		
		lblValabilitateCtr = new JLabel("Valabilitate Contract");
		lblValabilitateCtr.setBounds(51, 191, 137, 17);
		kundeUI.add(lblValabilitateCtr);
		
		txtFldValabilitateCtr = new JTextField();
		txtFldValabilitateCtr.setText("");
		txtFldValabilitateCtr.setColumns(10);
		txtFldValabilitateCtr.setBounds(211, 189, 314, 20);
		kundeUI.add(txtFldValabilitateCtr);
		
		btnSalveazaClient = new JButton("Salveaza Client");
		btnSalveazaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(true);
				kundeUI.setVisible(false);
				
				//save a new customer
				if(!(txtFldDenumireClient.getText().isEmpty() || txtFldNrCtr.getText().isEmpty())){
					DBverbindung.dbconnect();
					Kundedomain kundeNou = new Kundedomain(txtFldDenumireClient.getText().toString(), txtFldNrCtr.getText().toString(), 
							txtFldActeAditionale.getText().toString(), txtFldValabilitateCtr.getText().toString());
					Kundedomain tmp = ks.createKunde(kundeNou);
					DBverbindung.dbdisconect();
				}
				
				//clear all fields after save
				txtFldDenumireClient.setText(null);
				txtFldNrCtr.setText(null);
				txtFldActeAditionale.setText(null);
				txtFldValabilitateCtr.setText(null);
			}
		});
		btnSalveazaClient.setBounds(211, 239, 151, 23);
		kundeUI.add(btnSalveazaClient);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(true);
				kundeUI.setVisible(false);
				
				//clear all fields by cancel
				txtFldDenumireClient.setText(null);
				txtFldNrCtr.setText(null);
				txtFldActeAditionale.setText(null);
				txtFldValabilitateCtr.setText(null);
			}
		});
		btnCancel.setBounds(374, 239, 151, 23);
		kundeUI.add(btnCancel);
		
		debitorenMainUI = new JPanel();
		frame.getContentPane().add(debitorenMainUI, "name_79084692757183");
		debitorenMainUI.setLayout(null);
		
		lblTitleDebMainUI = new JLabel("Client Selectat");
		lblTitleDebMainUI.setBounds(10, 11, 842, 14);
		debitorenMainUI.add(lblTitleDebMainUI);
		
		
	}
}
