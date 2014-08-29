package util;

import java.awt.EventQueue;

import kundenverwaltung.domain.Kundedomain;
import kundenverwaltung.service.*;

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
	private JLabel lblClientSelectatDebMainUi;
	private JButton btnEditeazaClient;
	private JButton btnCancelDebMainUI;
	private JButton btnEditeazaDebitorDebMainUI;
	private JLabel lblDebitoriInDbDebMainUI;
	
	
	private Kundedomain selectedKunde;
	private String angeklickteButton;
	private JButton btnCautaDebitoriDebMainUI;
	private JButton btnCreazaDebitorDebMainUI;
	private JTextField txtFldCautaDebitorDebMainUI;
	private JScrollPane scrollPaneListDebitoriInDB;
	private JList listDebitorenInDbDebMainUI;
	
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
		btnCreazaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainUI.setVisible(false);
				kundeUI.setVisible(true);
				frame.setTitle("Arc Solution - Creaza Client");
				
				angeklickteButton = "btnCreazaClient";
			}
		});
		btnCreazaClient.setBounds(206, 154, 135, 23);
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
		btnDebitorenVerwaltung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//debitorenMainUI only when one customer selected is
				//set debitorenMainUI as visible
				mainUI.setVisible(false);
				debitorenMainUI.setVisible(true);
				frame.setTitle("Arc Solution - Administreaza Debitori");
				
				//list only one customer as title in DebitorenMainUI
				lblClientSelectatDebMainUi.setText(getSelectedCustomer().getName().toString());
			}
		});
		btnDebitorenVerwaltung.setBounds(313, 282, 167, 23);
		btnDebitorenVerwaltung.setVisible(false);
		btnDebitorenVerwaltung.setEnabled(false);
		mainUI.add(btnDebitorenVerwaltung);
		
		//Edit Customer
		btnEditeazaClient = new JButton("Editeaza Client");
		btnEditeazaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kundeUI.setVisible(true);
				mainUI.setVisible(false);
				frame.setTitle("Arc Solution - Editeaza Client");
			
				//Edit and Update selected customer
				txtFldDenumireClient.setText(getSelectedCustomer().getName().toString());
				txtFldNrCtr.setText(getSelectedCustomer().getKontraktNr().toString());
				txtFldActeAditionale.setText(getSelectedCustomer().getActaditional().toString());
				txtFldValabilitateCtr.setText(getSelectedCustomer().getValabilitateCrt().toString());
				
				angeklickteButton = "btnEditeazaClient";
				
			}
		});
		btnEditeazaClient.setBounds(136, 282, 167, 23);
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
		 
		//save Customer
		btnSalveazaClient = new JButton("Salveaza Client");
		btnSalveazaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(true);
				kundeUI.setVisible(false);
				frame.setTitle("Arc Solution");
				
				//save or edit/update a new customer
				if(!(txtFldDenumireClient.getText().isEmpty() || txtFldNrCtr.getText().isEmpty())){
					DBverbindung.dbconnect();
					if(angeklickteButton.equals("btnCreazaClient")){
						Kundedomain kundeNou = new Kundedomain(txtFldDenumireClient.getText().toString(), txtFldNrCtr.getText().toString(), 
								txtFldActeAditionale.getText().toString(), txtFldValabilitateCtr.getText().toString());
						Kundedomain tmp = ks.createKunde(kundeNou);
						//TODO Success Meldung anzeigen
						
//						System.out.println("Button create pressed");
					}else if(angeklickteButton.equals("btnEditeazaClient")){
						//TODO - updateKunde only when the customer is modified
						
						//TODO ks.updateKunde
						Kundedomain kundeNou = new Kundedomain(txtFldDenumireClient.getText().toString(), txtFldNrCtr.getText().toString(), 
								txtFldActeAditionale.getText().toString(), txtFldValabilitateCtr.getText().toString());
						Kundedomain tmp = ks.updateKunde(selectedKunde.getID(), kundeNou);
						System.out.println("Button edit pressed");
						
					}
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
		
		//Cancel
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(true);
				kundeUI.setVisible(false);
				frame.setTitle("Arc Solution");
				
				//clear all fields by cancel
				txtFldDenumireClient.setText(null);
				txtFldNrCtr.setText(null);
				txtFldActeAditionale.setText(null);
				txtFldValabilitateCtr.setText(null);
			}
		});
		btnCancel.setBounds(374, 239, 151, 23);
		kundeUI.add(btnCancel);
		
//debitorenUI
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
				ArrayList<Kundedomain> allKunden = ks.findKundenByName(txtFldCautaClient.getText());
				ArrayList<Kundedomain> allKunden1 = ks.getAllKunden();
				DBverbindung.dbdisconect();	
				
				listDebitorenInDbDebMainUI.setVisible(true);
				btnEditeazaDebitorDebMainUI.setVisible(true);
				scrollPaneListDebitoriInDB.setVisible(true);
				lblDebitoriInDbDebMainUI.setVisible(true);
				listDebitorenInDbDebMainUI.setListData(allKunden.toArray());
			}
		});
		btnCautaDebitoriDebMainUI.setBounds(206, 120, 135, 23);
		debitorenMainUI.add(btnCautaDebitoriDebMainUI);
		
		btnEditeazaDebitorDebMainUI = new JButton("Editeaza Debitor");
		btnEditeazaDebitorDebMainUI.setBounds(136, 282, 167, 23);
		btnEditeazaDebitorDebMainUI.setEnabled(false);
		debitorenMainUI.add(btnEditeazaDebitorDebMainUI);
		
		btnCreazaDebitorDebMainUI = new JButton("Creaza Debitor");
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
			}
		});
		scrollPaneListDebitoriInDB.setViewportView(listDebitorenInDbDebMainUI);
		
		
		lblDebitoriInDbDebMainUI = new JLabel("Debitori in DB");
		lblDebitoriInDbDebMainUI.setBounds(21, 290, 111, 14);
		debitorenMainUI.add(lblDebitoriInDbDebMainUI);
	}
	
//Hilfsmethoden
	//get selected Customer
	private Kundedomain getSelectedCustomer(){
		Object selectedItem = listKundenInDB.getSelectedValue();
		selectedKunde = (Kundedomain) selectedItem;		
		return selectedKunde;
	}
}
