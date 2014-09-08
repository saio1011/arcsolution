package util;

import java.awt.Color;
import java.awt.EventQueue;

import kundenverwaltung.domain.Kundedomain;
import kundenverwaltung.service.*;
import debitorenwervaltung.service.*;
import debitorenwervaltung.domain.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JPopupMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;

public class MainUI extends JFrame {

	private JFrame frame;
	private JPanel mainUI;
	private JPanel kundeUI;
	private JLabel lblTitle;
	private JTextField txtFldCautaClient;
	private JList listKundenInDB;
	private JLabel lblClientiInDb;
	private JScrollPane scrollPaneListKundeInDB;
	private JButton btnCautaClient;
	private JButton btnCreazaClient;
	private JLabel lblTitleKundeUI;
	private JLabel lblDenumireClientKundeUI;
	private JTextField txtFldDenumireClientKundeUI;
	private JLabel lblNrCtrKundeUI;
	private JTextField txtFldNrCtrKundeUI;
	private JLabel lblActeAditionaleKundeUI;
	private JTextField txtFldActeAditionaleKundeUI;
	private JLabel lblValabilitateCtrKundeUI;
	private JTextField txtFldValabilitateCtrKundeUI;
	private JButton btnSalveazaClientKundeUI;
	private JButton btnCancelKundeUI;
	private JButton btnDebitorenVerwaltung;
	private JPanel debitorenMainUI;
	private JLabel lblTitleDebMainUI;
	private JLabel lblClientSelectatDebMainUi;
	private JButton btnEditeazaClient;
	private JButton btnCancelDebMainUI;
	private JButton btnEditeazaDebitorDebMainUI;
	private JLabel lblDebitoriInDbDebMainUI;
	private JLabel lblTitleDebitorUI;
	private JButton btnCancelDebitorUI;
	private JScrollPane scrollPaneContactDebitorUI;
	private JTextArea textAreaContactDebitorUI;
	private JLabel lblActiuniDebitorUI;
	private JScrollPane scrollPaneActiuniDebitorUI;
	private JTextArea textAreaActiuniDebitorUI;
	
	private Kundedomain selectedKunde;
	private String angeklickteButton;
	private JButton btnCautaDebitoriDebMainUI;
	private JButton btnCreazaDebitorDebMainUI;
	private JTextField txtFldCautaDebitorDebMainUI;
	private JScrollPane scrollPaneListDebitoriInDB;
	private JList listDebitorenInDbDebMainUI;
	private JPanel debitorUI;
	private JLabel lblClientDebitorUI;
	private JLabel lblDenumireDebitorDebitorUI;
	private JLabel lblContactDebitorDebitorUI;
	private JTextField txtFldDenumireDebitorDebitorUI;
	private JTextField txtFldStradaDebitorUI;
	private JTextField txtFldNumarStrDebitorUI;
	private JTextField txtFldLocalitateDebitorUI;
	private JTextField txtFldCodPostalDebitorUI;
	private JTextField txtFldTaraDebitorUI;
	private JButton btnSaveDebitorUI;
	private JButton btnAdministreazaFacturiDebMainUI;
	private JPanel BillingMainUI;
	private JButton btnCancelBillingMainUI;
	private JLabel lblTitleBillingMainUI;
	private JLabel lblDebitorBillingMainUI;
	private JButton btnCautaFacturaBillingMainUI;
	private JButton btnAddBillingBillingMainUI;
	private JTextField txtFldFindBillingBillingMainUI;
	private JLabel lblFacturiInDbBillingMainUI;
	private JButton btnEditeazaFacturaBillingMainUI;
	
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
		Debitorenservice ds = new Debitorenservice();
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.setTitle("Arc Solution");
	
//mainUI
		mainUI = new JPanel();
		frame.getContentPane().add(mainUI, "name_27322271565082");
		mainUI.setLayout(null);
		
		lblTitle = new JLabel("Arc Solution");
		lblTitle.setBounds(21, 21, 135, 14);
		mainUI.add(lblTitle);
		
		//Search Customer
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
				btnEditeazaClient.setVisible(true);
				scrollPaneListKundeInDB.setVisible(true);
				lblClientiInDb.setVisible(true);
				listKundenInDB.setListData(allKunden.toArray());
				btnEditeazaClient.setEnabled(false);
				btnDebitorenVerwaltung.setEnabled(false);
			}
		});
		mainUI.add(btnCautaClient);
		
		//Create Customer
		btnCreazaClient = new JButton("Creaza Client");
		btnCreazaClient.setBounds(206, 154, 135, 23);
		btnCreazaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainUI.setVisible(false);
				kundeUI.setVisible(true);
				frame.setTitle("Arc Solution - Creaza Client");
				
				angeklickteButton = "btnCreazaClient";
			}
		});
		mainUI.add(btnCreazaClient);
		
		scrollPaneListKundeInDB = new JScrollPane();
		scrollPaneListKundeInDB.setBounds(21, 316, 704, 182);
		scrollPaneListKundeInDB.setVisible(false);
		mainUI.add(scrollPaneListKundeInDB);
		listKundenInDB = new JList();
		listKundenInDB.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listKundenInDB.addListSelectionListener(new ListSelectionListener() {
			
			// enable Edit-button and Debitorenverwaltung-button when one Item is selected
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnEditeazaClient.setEnabled(true);
				btnDebitorenVerwaltung.setEnabled(true);
			}
		});
		scrollPaneListKundeInDB.setViewportView(listKundenInDB);
		
		lblClientiInDb = new JLabel("Clienti in DB");
		lblClientiInDb.setBounds(21, 290, 111, 14);
		lblClientiInDb.setVisible(false);
		mainUI.add(lblClientiInDb);
		
		txtFldCautaClient = new JTextField();
		txtFldCautaClient.setBounds(382, 120, 343, 23);
		mainUI.add(txtFldCautaClient);
		txtFldCautaClient.setColumns(10);
		
		//Debitorenverwaltung
		btnDebitorenVerwaltung = new JButton("Administreaza Debitori");
		btnDebitorenVerwaltung.setBounds(313, 282, 175, 23);
		btnDebitorenVerwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//debitorenMainUI only when one customer selected is
				//set debitorenMainUI as visible
				mainUI.setVisible(false);
				debitorenMainUI.setVisible(true);
				frame.setTitle("Arc Solution - Administreaza Debitori - "+ getSelectedCustomer().getName().toString());
				
				//list only one customer as title in DebitorenMainUI
				lblClientSelectatDebMainUi.setText(getSelectedCustomer().getName().toString());
			}
		});
		btnDebitorenVerwaltung.setVisible(false);
		btnDebitorenVerwaltung.setEnabled(false);
		mainUI.add(btnDebitorenVerwaltung);
		
		//Edit Customer
		btnEditeazaClient = new JButton("Editeaza Client");
		btnEditeazaClient.setBounds(136, 282, 175, 23);
		btnEditeazaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kundeUI.setVisible(true);
				mainUI.setVisible(false);
				frame.setTitle("Arc Solution - Editeaza Client");
			
				//Edit and Update selected customer
				txtFldDenumireClientKundeUI.setText(getSelectedCustomer().getName().toString());
				txtFldNrCtrKundeUI.setText(getSelectedCustomer().getKontraktNr().toString());
				txtFldActeAditionaleKundeUI.setText(getSelectedCustomer().getActaditional().toString());
				txtFldValabilitateCtrKundeUI.setText(getSelectedCustomer().getValabilitateCrt().toString());
				
				angeklickteButton = "btnEditeazaClient";
				
			}
		});
		btnEditeazaClient.setEnabled(false);
		btnEditeazaClient.setVisible(false);
		mainUI.add(btnEditeazaClient);

//kundeUI
		kundeUI = new JPanel();
		frame.getContentPane().add(kundeUI, "name_27327655750175");
		kundeUI.setLayout(null);
		
		lblTitleKundeUI = new JLabel("Introduce Client Nou");
		lblTitleKundeUI.setBounds(10, 31, 152, 14);
		kundeUI.add(lblTitleKundeUI);
		
		lblDenumireClientKundeUI = new JLabel("*Denumire Client");
		lblDenumireClientKundeUI.setBounds(51, 76, 137, 20);
		kundeUI.add(lblDenumireClientKundeUI);
		
		txtFldDenumireClientKundeUI = new JTextField();
		txtFldDenumireClientKundeUI.setColumns(10);
		txtFldDenumireClientKundeUI.setBounds(211, 76, 314, 20);
		kundeUI.add(txtFldDenumireClientKundeUI);
		
		lblNrCtrKundeUI = new JLabel("*Nr. Contract");
		lblNrCtrKundeUI.setBounds(51, 114, 137, 17);
		kundeUI.add(lblNrCtrKundeUI);
		
		txtFldNrCtrKundeUI = new JTextField();
		txtFldNrCtrKundeUI.setColumns(10);
		txtFldNrCtrKundeUI.setBounds(211, 112, 314, 20);
		kundeUI.add(txtFldNrCtrKundeUI);
		
		lblActeAditionaleKundeUI = new JLabel("Acte Aditionale");
		lblActeAditionaleKundeUI.setBounds(51, 150, 137, 17);
		kundeUI.add(lblActeAditionaleKundeUI);
		
		txtFldActeAditionaleKundeUI = new JTextField();
		txtFldActeAditionaleKundeUI.setColumns(10);
		txtFldActeAditionaleKundeUI.setBounds(211, 148, 314, 20);
		kundeUI.add(txtFldActeAditionaleKundeUI);
		
		lblValabilitateCtrKundeUI = new JLabel("Valabilitate Contract");
		lblValabilitateCtrKundeUI.setBounds(51, 191, 137, 17);
		kundeUI.add(lblValabilitateCtrKundeUI);
		
		txtFldValabilitateCtrKundeUI = new JTextField();
		txtFldValabilitateCtrKundeUI.setText("");
		txtFldValabilitateCtrKundeUI.setColumns(10);
		txtFldValabilitateCtrKundeUI.setBounds(211, 189, 314, 20);
		kundeUI.add(txtFldValabilitateCtrKundeUI);
		 
		//save Customer
		btnSalveazaClientKundeUI = new JButton("Salveaza Client");
		btnSalveazaClientKundeUI.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(true);
				kundeUI.setVisible(false);
				frame.setTitle("Arc Solution");
				
				//save or edit/update a new customer
				if(!(txtFldDenumireClientKundeUI.getText().isEmpty() || txtFldNrCtrKundeUI.getText().isEmpty())){
					DBverbindung.dbconnect();
					if(angeklickteButton.equals("btnCreazaClient")){
						Kundedomain kundeNou = new Kundedomain(txtFldDenumireClientKundeUI.getText().toString(), txtFldNrCtrKundeUI.getText().toString(), 
								txtFldActeAditionaleKundeUI.getText().toString(), txtFldValabilitateCtrKundeUI.getText().toString());
						Kundedomain tmp = ks.createKunde(kundeNou);
						//TODO Success Meldung anzeigen
						
//						System.out.println("Button create pressed");
					}else if(angeklickteButton.equals("btnEditeazaClient")){
						//TODO - updateKunde only when the customer is modified
						
						//TODO ks.updateKunde
						Kundedomain kundeNou = new Kundedomain(txtFldDenumireClientKundeUI.getText().toString(), txtFldNrCtrKundeUI.getText().toString(), 
								txtFldActeAditionaleKundeUI.getText().toString(), txtFldValabilitateCtrKundeUI.getText().toString());
						Kundedomain tmp = ks.updateKunde(selectedKunde.getID(), kundeNou);
						System.out.println("Button edit pressed");
						
					}
					DBverbindung.dbdisconect();
				}
				
				//clear all fields after save
				txtFldDenumireClientKundeUI.setText(null);
				txtFldNrCtrKundeUI.setText(null);
				txtFldActeAditionaleKundeUI.setText(null);
				txtFldValabilitateCtrKundeUI.setText(null);
			}
		});
		btnSalveazaClientKundeUI.setBounds(211, 239, 151, 23);
		kundeUI.add(btnSalveazaClientKundeUI);
		
		//Cancel
		btnCancelKundeUI = new JButton("Cancel");
		btnCancelKundeUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(true);
				kundeUI.setVisible(false);
				frame.setTitle("Arc Solution");
				
				//clear all fields by cancel
				txtFldDenumireClientKundeUI.setText(null);
				txtFldNrCtrKundeUI.setText(null);
				txtFldActeAditionaleKundeUI.setText(null);
				txtFldValabilitateCtrKundeUI.setText(null);
			}
		});
		btnCancelKundeUI.setBounds(374, 239, 151, 23);
		kundeUI.add(btnCancelKundeUI);
		
//debitorenMainUI
		debitorenMainUI = new JPanel();
		frame.getContentPane().add(debitorenMainUI, "name_79084692757183");
		debitorenMainUI.setLayout(null);
		
		lblTitleDebMainUI = new JLabel("Client:");
		lblTitleDebMainUI.setBounds(10, 11, 43, 14);
		debitorenMainUI.add(lblTitleDebMainUI);
		
		//Cancel
		btnCancelDebMainUI = new JButton("Cancel");
		btnCancelDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(true);
				debitorenMainUI.setVisible(false);
				frame.setTitle("Arc Solution");
				
				//delete all entry from list by cancel and set a empty list to scrollList
				//TODO must verify if works fine?!?!
				listDebitorenInDbDebMainUI.removeAll();
				ArrayList<Debitorendomain> allDebitoren = new ArrayList<Debitorendomain>();
				listDebitorenInDbDebMainUI.setListData(allDebitoren.toArray());
				//
				btnEditeazaDebitorDebMainUI.setEnabled(false);
				lblDebitoriInDbDebMainUI.setVisible(false);
				btnEditeazaDebitorDebMainUI.setVisible(false);
				scrollPaneListDebitoriInDB.setVisible(false);
				btnAdministreazaFacturiDebMainUI.setEnabled(false);
				btnAdministreazaFacturiDebMainUI.setVisible(false);
				
				//clear search field by cancel
				txtFldCautaDebitorDebMainUI.setText(null);
			}
		});
		btnCancelDebMainUI.setBounds(171, 533, 89, 23);
		debitorenMainUI.add(btnCancelDebMainUI);		
		
		lblClientSelectatDebMainUi = new JLabel("Client Selectat");
		lblClientSelectatDebMainUi.setBounds(63, 11, 442, 14);
		debitorenMainUI.add(lblClientSelectatDebMainUi);
		
		btnCautaDebitoriDebMainUI = new JButton("Cauta Debitori");
		btnCautaDebitoriDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//teste
				DBverbindung.dbconnect();
				ArrayList<Debitorendomain> allDebitoren = ds.getAllDebitorenByKundenId(selectedKunde.getID());
				DBverbindung.dbdisconect();	
				
				listDebitorenInDbDebMainUI.setVisible(true);
				btnEditeazaDebitorDebMainUI.setVisible(true);
				btnAdministreazaFacturiDebMainUI.setVisible(true);
				scrollPaneListDebitoriInDB.setVisible(true);
				lblDebitoriInDbDebMainUI.setVisible(true);
				listDebitorenInDbDebMainUI.setListData(allDebitoren.toArray());
				btnEditeazaDebitorDebMainUI.setEnabled(false);
				btnAdministreazaFacturiDebMainUI.setEnabled(false);
			}
		});
		btnCautaDebitoriDebMainUI.setBounds(206, 120, 135, 23);
		debitorenMainUI.add(btnCautaDebitoriDebMainUI);
		
		btnEditeazaDebitorDebMainUI = new JButton("Editeaza Debitor");
		btnEditeazaDebitorDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorenMainUI.setVisible(false);
				debitorUI.setVisible(true);
				frame.setTitle("Arc Solution - Editeaza Debitor - "+getSelectedCustomer().getName().toString());
				//TODO - DebitorenUI Fields fill with selected Debitor values
				
				angeklickteButton = "btnEditeazaDebitorDebMainUI";
			}
		});
		btnEditeazaDebitorDebMainUI.setBounds(136, 282, 167, 23);
		btnEditeazaDebitorDebMainUI.setEnabled(false);
		btnEditeazaDebitorDebMainUI.setVisible(false);
		debitorenMainUI.add(btnEditeazaDebitorDebMainUI);
		
		btnCreazaDebitorDebMainUI = new JButton("Creaza Debitor");
		btnCreazaDebitorDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorenMainUI.setVisible(false);
				debitorUI.setVisible(true);
				lblClientDebitorUI.setText(getSelectedCustomer().getName().toString());
				
				angeklickteButton = "btnCreazaDebitorDebMainUI";
				
			}
		});
		btnCreazaDebitorDebMainUI.setBounds(206, 154, 135, 23);
		debitorenMainUI.add(btnCreazaDebitorDebMainUI);
		
		txtFldCautaDebitorDebMainUI = new JTextField();
		txtFldCautaDebitorDebMainUI.setColumns(10);
		txtFldCautaDebitorDebMainUI.setBounds(382, 120, 343, 23);
		debitorenMainUI.add(txtFldCautaDebitorDebMainUI);
		
		scrollPaneListDebitoriInDB = new JScrollPane();
		scrollPaneListDebitoriInDB.setBounds(21, 316, 704, 182);
		scrollPaneListDebitoriInDB.setVisible(false);
		debitorenMainUI.add(scrollPaneListDebitoriInDB);
		
		listDebitorenInDbDebMainUI = new JList();
		listDebitorenInDbDebMainUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDebitorenInDbDebMainUI.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnEditeazaDebitorDebMainUI.setEnabled(true);
				btnAdministreazaFacturiDebMainUI.setEnabled(true);
			}
		});
		scrollPaneListDebitoriInDB.setViewportView(listDebitorenInDbDebMainUI);
		
		
		lblDebitoriInDbDebMainUI = new JLabel("Debitori in DB");
		lblDebitoriInDbDebMainUI.setBounds(21, 290, 111, 14);
		lblDebitoriInDbDebMainUI.setVisible(false);
		debitorenMainUI.add(lblDebitoriInDbDebMainUI);
		
		btnAdministreazaFacturiDebMainUI = new JButton("Administreaza Facturi");
		btnAdministreazaFacturiDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorenMainUI.setVisible(false);
				BillingMainUI.setVisible(true);
				frame.setTitle("Arc Solution - Administreaza Facturi - Client-"+getSelectedCustomer().getName().toString() + " <-> Debitor-");
				
			}
		});
		btnAdministreazaFacturiDebMainUI.setBounds(315, 279, 167, 29);
		btnAdministreazaFacturiDebMainUI.setEnabled(false);
		btnAdministreazaFacturiDebMainUI.setVisible(false);
		debitorenMainUI.add(btnAdministreazaFacturiDebMainUI);
	
//Debitoren UI
		debitorUI = new JPanel();
		frame.getContentPane().add(debitorUI, "name_1409479611197372000");
		debitorUI.setLayout(null);
		
		lblTitleDebitorUI = new JLabel("Introduce Debitor nou pentru Clientul");
		lblTitleDebitorUI.setBounds(10, 31, 264, 14);
		debitorUI.add(lblTitleDebitorUI);
		
		btnCancelDebitorUI = new JButton("Cancel");
		btnCancelDebitorUI.setBounds(470, 620, 172, 29);
		btnCancelDebitorUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorUI.setVisible(false);
				debitorenMainUI.setVisible(true);
				frame.setTitle("Arc Solution - Administreaza Debitori - "+ getSelectedCustomer().getName().toString());
				
				//clear all fields by cancel
				txtFldDenumireDebitorDebitorUI.setText(null);
				txtFldCodPostalDebitorUI.setText(null);
				textAreaContactDebitorUI.setText(null);
				textAreaActiuniDebitorUI.setText(null);
				txtFldLocalitateDebitorUI.setText(null);
				txtFldNumarStrDebitorUI.setText(null);
				txtFldStradaDebitorUI.setText(null);
				txtFldTaraDebitorUI.setText("Romania");
				
			}
		});
		debitorUI.add(btnCancelDebitorUI);
		
		lblClientDebitorUI = new JLabel("Selected Customer...");
		lblClientDebitorUI.setBounds(286, 30, 205, 16);
		debitorUI.add(lblClientDebitorUI);
		
		lblDenumireDebitorDebitorUI = new JLabel("*Denumire Debitor");
		lblDenumireDebitorDebitorUI.setBounds(109, 81, 165, 16);
		debitorUI.add(lblDenumireDebitorDebitorUI);
		
		lblContactDebitorDebitorUI = new JLabel("Contact Debitor");
		lblContactDebitorDebitorUI.setBounds(109, 109, 165, 16);
		debitorUI.add(lblContactDebitorDebitorUI);
		
		JLabel lblAdresaDebitorUI = new JLabel("Adresa");
		lblAdresaDebitorUI.setBounds(109, 180, 165, 16);
		debitorUI.add(lblAdresaDebitorUI);
		
		JLabel lblStrasseDebitorUI = new JLabel("Strada");
		lblStrasseDebitorUI.setBounds(156, 208, 61, 16);
		debitorUI.add(lblStrasseDebitorUI);
		
		JLabel lblNumarDebitorUI = new JLabel("Numar");
		lblNumarDebitorUI.setBounds(156, 236, 61, 16);
		debitorUI.add(lblNumarDebitorUI);
		
		JLabel lblLocalitateDebitorUI = new JLabel("Localitate");
		lblLocalitateDebitorUI.setBounds(156, 264, 92, 16);
		debitorUI.add(lblLocalitateDebitorUI);
		
		JLabel lblCodPostalDebitorUI = new JLabel("Cod Postal");
		lblCodPostalDebitorUI.setBounds(156, 292, 92, 16);
		debitorUI.add(lblCodPostalDebitorUI);
		
		JLabel lblTaraDebitorUI = new JLabel("Tara");
		lblTaraDebitorUI.setBounds(156, 320, 61, 16);
		debitorUI.add(lblTaraDebitorUI);
		
		txtFldDenumireDebitorDebitorUI = new JTextField();
		txtFldDenumireDebitorDebitorUI.setBounds(286, 79, 350, 20);
		debitorUI.add(txtFldDenumireDebitorDebitorUI);
		txtFldDenumireDebitorDebitorUI.setColumns(10);
		
		txtFldStradaDebitorUI = new JTextField();
		txtFldStradaDebitorUI.setBounds(322, 206, 314, 20);
		debitorUI.add(txtFldStradaDebitorUI);
		txtFldStradaDebitorUI.setColumns(10);
		
		txtFldNumarStrDebitorUI = new JTextField();
		txtFldNumarStrDebitorUI.setBounds(322, 234, 314, 20);
		debitorUI.add(txtFldNumarStrDebitorUI);
		txtFldNumarStrDebitorUI.setColumns(10);
		
		txtFldLocalitateDebitorUI = new JTextField();
		txtFldLocalitateDebitorUI.setBounds(322, 262, 314, 20);
		debitorUI.add(txtFldLocalitateDebitorUI);
		txtFldLocalitateDebitorUI.setColumns(10);
		
		txtFldCodPostalDebitorUI = new JTextField();
		txtFldCodPostalDebitorUI.setBounds(322, 290, 314, 20);
		debitorUI.add(txtFldCodPostalDebitorUI);
		txtFldCodPostalDebitorUI.setColumns(10);
		
		txtFldTaraDebitorUI = new JTextField();
		txtFldTaraDebitorUI.setBounds(322, 318, 314, 20);
		debitorUI.add(txtFldTaraDebitorUI);
		txtFldTaraDebitorUI.setColumns(10);
		txtFldTaraDebitorUI.setText("Romania");
		
		
		scrollPaneContactDebitorUI = new JScrollPane();
		scrollPaneContactDebitorUI.setBounds(286, 109, 350, 77);
		debitorUI.add(scrollPaneContactDebitorUI);		
		textAreaContactDebitorUI = new JTextArea();
		scrollPaneContactDebitorUI.setViewportView(textAreaContactDebitorUI);
		
		btnSaveDebitorUI = new JButton("Salveaza Debitor");
		btnSaveDebitorUI.setBounds(286, 620, 172, 29);
		btnSaveDebitorUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO - ds.createDebitor bei create aufrufen
				//TODO - ds.updateDebitor bei edit aufrufen
				
				if(txtFldDenumireDebitorDebitorUI.getText().isEmpty()){
					//
					System.out.println(txtFldDenumireDebitorDebitorUI.getBorder().toString());
					txtFldDenumireDebitorDebitorUI.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
					return;
				}
				
				debitorenMainUI.setVisible(true);
				debitorUI.setVisible(false);
				frame.setTitle("Arc Solution - Administreaza Debitori - "+ getSelectedCustomer().getName().toString());
				
				//save or edit/update a new debitor
				if(!(txtFldDenumireDebitorDebitorUI.getText().isEmpty())){
//					DBverbindung.dbconnect();
					if(angeklickteButton.equals("btnCreazaDebitorDebMainUI")){
						System.out.println("btn Creaza Debitor geclicked");
					}else if(angeklickteButton.equals("btnEditeazaDebitorDebMainUI")){
						System.out.println("btn Edit Debitor geclicked");
					}
//					DBverbindung.dbdisconect();
				}
				
				/*
				 * 
				 * mainUI.setVisible(true);
				kundeUI.setVisible(false);
				frame.setTitle("Arc Solution");
				
				//save or edit/update a new customer
				if(!(txtFldDenumireClientKundeUI.getText().isEmpty() || txtFldNrCtrKundeUI.getText().isEmpty())){
					DBverbindung.dbconnect();
					if(angeklickteButton.equals("btnCreazaClient")){
						Kundedomain kundeNou = new Kundedomain(txtFldDenumireClientKundeUI.getText().toString(), txtFldNrCtrKundeUI.getText().toString(), 
								txtFldActeAditionaleKundeUI.getText().toString(), txtFldValabilitateCtrKundeUI.getText().toString());
						Kundedomain tmp = ks.createKunde(kundeNou);
						//TODO Success Meldung anzeigen
						
//						System.out.println("Button create pressed");
					}else if(angeklickteButton.equals("btnEditeazaClient")){
						//TODO - updateKunde only when the customer is modified
						
						//TODO ks.updateKunde
						Kundedomain kundeNou = new Kundedomain(txtFldDenumireClientKundeUI.getText().toString(), txtFldNrCtrKundeUI.getText().toString(), 
								txtFldActeAditionaleKundeUI.getText().toString(), txtFldValabilitateCtrKundeUI.getText().toString());
						Kundedomain tmp = ks.updateKunde(selectedKunde.getID(), kundeNou);
						System.out.println("Button edit pressed");
						
					}
					DBverbindung.dbdisconect();*/
				}
		});
		debitorUI.add(btnSaveDebitorUI);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(109, 348, 527, 12);
		debitorUI.add(separator);
		
		lblActiuniDebitorUI = new JLabel("Actiuni");
		lblActiuniDebitorUI.setBounds(109, 372, 61, 16);
		debitorUI.add(lblActiuniDebitorUI);
		
		scrollPaneActiuniDebitorUI = new JScrollPane();
		scrollPaneActiuniDebitorUI.setBounds(109, 400, 527, 196);
		debitorUI.add(scrollPaneActiuniDebitorUI);
		textAreaActiuniDebitorUI = new JTextArea();
		scrollPaneActiuniDebitorUI.setViewportView(textAreaActiuniDebitorUI);
	
//BillingManiUI
		BillingMainUI = new JPanel();
		BillingMainUI.setLayout(null);
		
		btnCancelBillingMainUI = new JButton("Cancel");
		btnCancelBillingMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillingMainUI.setVisible(false);
				debitorenMainUI.setVisible(true);
				frame.setTitle("Arc Solution - Administreaza Debitori - "+ getSelectedCustomer().getName().toString());
				
			}
		});
		btnCancelBillingMainUI.setBounds(163, 559, 117, 29);
		BillingMainUI.add(btnCancelBillingMainUI);
		
		lblTitleBillingMainUI = new JLabel("Factura Debitor");
		lblTitleBillingMainUI.setBounds(39, 50, 171, 16);
		BillingMainUI.add(lblTitleBillingMainUI);
		
		lblDebitorBillingMainUI = new JLabel("Nume Debitor");
		lblDebitorBillingMainUI.setBounds(202, 50, 248, 16);
		BillingMainUI.add(lblDebitorBillingMainUI);
		
		btnCautaFacturaBillingMainUI = new JButton("Cauta Factura");
		btnCautaFacturaBillingMainUI.setBounds(148, 95, 153, 29);
		BillingMainUI.add(btnCautaFacturaBillingMainUI);
		
		btnAddBillingBillingMainUI = new JButton("Adauga Factura");
		btnAddBillingBillingMainUI.setBounds(148, 130, 153, 29);
		BillingMainUI.add(btnAddBillingBillingMainUI);
		
		txtFldFindBillingBillingMainUI = new JTextField();
		txtFldFindBillingBillingMainUI.setBounds(452, 94, 337, 29);
		BillingMainUI.add(txtFldFindBillingBillingMainUI);
		txtFldFindBillingBillingMainUI.setColumns(10);
		
		lblFacturiInDbBillingMainUI = new JLabel("Facturi in DB");
		lblFacturiInDbBillingMainUI.setBounds(77, 279, 117, 16);
		BillingMainUI.add(lblFacturiInDbBillingMainUI);
		
		btnEditeazaFacturaBillingMainUI = new JButton("Editeaza Factura");
		btnEditeazaFacturaBillingMainUI.setBounds(202, 274, 159, 29);
		BillingMainUI.add(btnEditeazaFacturaBillingMainUI);
		
		String[] status = { "Open", "Closed"};
		JComboBox comboBox = new JComboBox(status);
		comboBox.setBounds(335, 96, 77, 27);
		BillingMainUI.add(comboBox);
		
		JScrollPane scrollPaneListFacturiInDB = new JScrollPane();
		scrollPaneListFacturiInDB.setBounds(77, 315, 712, 200);
		BillingMainUI.add(scrollPaneListFacturiInDB);
		
		JList listFacturiInDbBillingMainUI = new JList();
		scrollPaneListFacturiInDB.setViewportView(listFacturiInDbBillingMainUI);
		
		frame.getContentPane().add(BillingMainUI, "name_17654855574017");

	}
	
//Hilfsmethoden
	//get selected Customer
	private Kundedomain getSelectedCustomer(){
		Object selectedItem = listKundenInDB.getSelectedValue();
		selectedKunde = (Kundedomain) selectedItem;		
		return selectedKunde;
	}
	
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
