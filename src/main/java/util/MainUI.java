package util;

import java.awt.Color;
import java.awt.EventQueue;

import kundenverwaltung.domain.Kundedomain;
import kundenverwaltung.domain.Prozentedomain;
import kundenverwaltung.domain.Prozenteheader;
import kundenverwaltung.domain.Prozenterow;
import kundenverwaltung.service.*;
import debitorenwervaltung.service.*;
import debitorenwervaltung.domain.*;
import billingverwaltung.*;
import billingverwaltung.domain.Billingdomain;
import billingverwaltung.service.Billingservice;
import util.*;

import javax.faces.model.DataModel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
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
import javax.swing.JCheckBox;
import javax.xml.bind.ParseConversionEvent;

import java.awt.ScrollPane;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class MainUI extends JFrame {

	private JFrame frmArcSolutions;
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
	private JButton btnSalveazaClientKundeUI;
	private JButton btnCancelKundeUI;
	private JButton btnVerwaltungMainUI;
	private JPanel kundeverwaltungMainUI;
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
	private JScrollPane scrollPaneActiuniDebitorUI;
	private JTextArea textAreaActiuniDebitorUI;
	private static JLabel lblMessageBarMainUI;
	private static JLabel lblMessageBarDebMainUI;
	private static JLabel lblMsgBarDebitorenverwaltungUI;
	private static JLabel lblMsgBarPayBillingUI;
	
	private Kundedomain selectedKunde;
	private Debitorendomain selectedDebtor;
	private Billingdomain selectedBilling;
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
	private JButton btnSalveazaDebitorUI;
	private JButton btnAdministreazaDebMainUI;
	private JPanel debitorenverwaltungMainUI;
	private JButton btnCancelBillingMainUI;
	private JLabel lblTitleBillingMainUI;
	private JLabel lblDebitorBillingMainUI;
	private JButton btnCautaFacturaBillingMainUI;
	private JButton btnAddBillingBillingMainUI;
	private JTextField txtFldFindBillingBillingMainUI;
	private JLabel lblRezultateBillingMainUI;
	private JButton btnEditeazaFacturaBillingMainUI;
	private JSeparator sep1MainUI;
	private JButton btnSituatieClientMainUI;
	private JButton btnFacturiDePrescrisMainUI;
	private JSeparator sep2MainUI;
	private JComboBox comboBoxSearchMainUI;
	private JButton btnRaportareGenMainUI;
	private JSeparator sep1KundeUI;
	private JLabel lblContactClientKundeUI;
	private JLabel lblAdresaKundeKundeUI;
	private JLabel lblStradaKundeKundeUI;
	private JLabel lblNummerStrKundeUI;
	private JLabel lblLocalitateKundeKundeUI;
	private JLabel lblPLZKundeKundeUI;
	private JLabel lblTaraKundeKundeUI;
	private JTextField txtFldStradaKundeKundeUI;
	private JTextField txtFldNummerStrKundeUI;
	private JTextField txtFldLocalitateKundeKundeUI;
	private JTextField txtFldPLZKundeKundeUI;
	private JTextField txtFldTaraKundeKundeUI;
	private JComboBox comboBoxValabilitateCtrKundeUI;
	private JScrollPane scrollPaneContactClientKundeUI;
	private JTextArea textAreaContactClientKundeUI;
	private JSeparator sep2KundeUI;
	private JSeparator separator_2;
	private JComboBox comboBoxCautaDebDebMainUI;
	private JButton btnReportClientKundeVerwMainUI;
	private JSeparator separator_3;
	private JLabel lblCUIKundeKundeUI;
	private JTextField txtFldCUIKundeKundeUI;
	private JLabel lblNrOrcKundeKundeUI;
	private JTextField txtFldNrONRCClientKundeUI;
	private JLabel lblCUIDebitorDebitorUI;
	private JTextField txtFldCUIDebitorDebitorUI;
	private JLabel lblStatusDebitorDebitorUI;
	private JLabel lblStatusDosarDebitorDebitorUI;
	private JComboBox comboBoxStatusDebitorDebitorUI;
	private JComboBox comboBoxStatusDosarDebitorUI;
	private JSeparator separator_1;
	private JButton btnAfisazaActiuniDebVerwMainUI;
	private JLabel label;
	private JLabel lblDescriptionActiuneDebitorUI;
	private JTextField txtFldActiuneDebitorUI;
	private JCheckBox chckbxActiuneDebitorActiv;
	private JButton btnAdaugaActiuneDebVerwMainUI;
	private JPanel actiuneUI;
	private JButton btnCancelActiuneUI;
	private JTextArea textAreaActiuneUI;
	private JPanel billingUI;
	private JButton btnCancelBillinUI;
	private JPanel payBillingUI;
	private JLabel lblTitlePayBillingUI;
	private JButton btnCancelPayBillingUI;
	private JScrollPane scrollPanelFacturiNeincasate;
	private JComboBox comboBoxTypPayBillingUI;
	private JComboBox comboBoxTagFacturaBillingUI;
	private JComboBox comboBoxJahresMonatBillingUI;
	private JComboBox comboBoxJahrBillingUI;
	private JComboBox comboBoxTagScadentaBillingUI;
	private JComboBox comboBoxMonatScadentaBillingUI;
	private JComboBox comboBoxJahrScadentaBillingUI;
	private JComboBox comboBoxStatusFakturaBillingUI;
	private JComboBox comboBoxTagPreluareCreantaBillingUI;
	private JComboBox comboBoxMonatPreluareCreantaBillingUI;
	private JComboBox comboBoxJahrPreluareCreantaBillingUI;
	private JLabel lblNumeDebitorBillingUI;
	private JLabel lblNumeCreditorBillingUI;
	private String chckBoxActiuneDebitorStatus;
	private JScrollPane scrollPaneListResultsInDBDebitronVerwMainUI;
	private JList listResultsInDbBillingMainUI;
	private JLabel lblNumeDebitorActiuneUI;
	
	
	Kundeservice ks = new Kundeservice();
	Debitorenservice ds = new Debitorenservice();
	Billingservice bs = new Billingservice();
	
	String Error = "Error";
	String None = "None";
	String MsgBarMainUI = "MainUI";
	String MsgBarDebUI = "DebUI";
	String MsgBarDebVerUI = "DebVerUI";
	String MsgBarPayBillingUI = "PayBillingUI";
	String[] searchKundeElement = {"Name", "Cui"};
	String[] statusDebitorElement = {"Activ", "Inactiv"};
	String[] statusDosarDebitorElement = {"Amiabil", "In instanza", "In executare"};
	String[] spalten = {"Nr Factura", "Data Factura", "Suma Factura", "Rest Plata", "Status", "Data Scadenta"};
	String[] headerAlerteFacturiTable = {"Client", "Debitor", "Nr Factura", "Suma Factura", "Data Scadenta", "Data Prescriere"};
	String[][] dataAlerteFacturiTable = new String[0][0];
	String[] spaltenProzente = {"intervale","0","0","0","0","0","0"};
	String[][] dataProzente = new String[0][0];
	String[][] data = new String[0][0];
	String statusFacturaOpen = "Open";
	String[] statusFactura = { "Open", "Closed"};
	
	
	private JTextField txtFldKurzDescActiuneUI;
	private JTextField txtFldNrFacturaBillingUI;
	private JTextField txtFldSumaFacturaBillingUI;
	private JTable tableFacturiNeincasate;
	private JTextField txtFldSumaAchitata;
	private JTextField txtFldNrFacturaPayBillingUI;
	private JLabel lblNrFacturaPayBillingUI;
	private JComboBox comboBoxTagDataIncasarePayBillingUI;
	private JComboBox comboBoxMonatDataIncasarePayBillingUI;
	private JComboBox comboBoxJahrDataIncasarePayBillingUI;
	private JComboBox comboBoxLocPlataPayBillingUI;
	private JComboBox comboBoxSearchStatusFactura;
	
	
	private JPanel procenteKundeUI;
	private JButton btnBackProcenteUI;
	private JTable tableProcenteKundeProcenteUI;
	private JButton btnAddLineProcenteUI;
	private JButton btnDeleteLineProcenteUI;
	private JPanel alerteFacturiUI;
	private JTable tableAlerteFacturiUI;
	private JPanel situatieClientUI;
	private JLabel lblSituatieGenerala;
	private JLabel lblSituatieAnuala;
	private JLabel lblSituatieLunara;
	private JLabel lblCreantePreluate;
	private JLabel lblCreanteRecuperate;
	private JLabel lblRecuperat;
	private JLabel lblCreantePreluateSitGenSituatieClientUI;
	private JLabel lblCreanteRecuperateSitGenSituatieClientUI;
	private JLabel lblProcRecuperatSitGenSituatieClientUI;
	private JLabel lblCreantePreluateThisYearSitClientUI;
	private JLabel lblCreantePreluateThisMonthSitClientUI;
	private JLabel lblCreanteRecuperateThisMonthSitClientUI;
	private JLabel lblCreanteRecuperateThisYearSitClientUI;
	private JLabel lblDifDeRecuperatSituatieClientUI;
	private JComboBox comboBoxJahrSituatieClientUI;
	private JComboBox comboBoxMonatSituatieClientUI;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI window = new MainUI();
					window.frmArcSolutions.setVisible(true);
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
//		Kundeservice ks = new Kundeservice();
//		Debitorenservice ds = new Debitorenservice();
		
//		String[] searchKundeElement = {"Name", "Cui"};
//		String[] statusDebitorElement = {"Activ", "Inactiv"};
//		String[] statusDosarDebitorElement = {"Amiabil", "In instanza", "In executare"};
//		String Error = "Error";
//		String None = "None";
//		String MsgBarMainUI = "MainUI";
//		String MsgBarDebUI = "DebUI";
		
		
		
		
		frmArcSolutions = new JFrame();
		frmArcSolutions.setBounds(100, 100, 900, 700);
		frmArcSolutions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArcSolutions.getContentPane().setLayout(new CardLayout(0, 0));
		frmArcSolutions.setTitle("ARC Solutions");
	
//mainUI
		this.mainUI();

//kundeUI
		this.kundeUI();

//kundeverwaltungMainUI
		this.kundeverwaltungMainUI();

//Debitoren UI
		this.debitorUI();

//BillingManiUI
		this.billingMainUI();
		
//actiuneUI
		this.actiuneUI();
		
//billingUI
		this.billingUI();
		
//payBillingUI
		this.payBillingUI();
		
//procenteKundeUI
		this.procenteKundeUI();

//situatie client UI 
		this.situatieClientUI();

	}
	
	/**
	 * mainUI
	 */
	private void mainUI(){
		mainUI = new JPanel();
		frmArcSolutions.getContentPane().add(mainUI, "name_27322271565082");
		mainUI.setLayout(null);
		
		lblTitle = new JLabel("ARC Solutions");
		lblTitle.setBounds(21, 21, 135, 14);
		mainUI.add(lblTitle);
		
		//Search Customer
		btnCautaClient = new JButton("Cauta Client");
		btnCautaClient.setBounds(21, 122, 135, 23);
		btnCautaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//read customers from db
				DBverbindung.dbconnect();
				ArrayList<Kundedomain> allKunden = ks.findKundenByName(comboBoxSearchMainUI.getSelectedItem().toString(),txtFldCautaClient.getText());
//				ArrayList<Kundedomain> allKunden1 = ks.getAllKunden();
				DBverbindung.dbdisconect();	
				
				//add customers into listOutput
				listKundenInDB.setVisible(true);
				btnVerwaltungMainUI.setVisible(true);
				btnEditeazaClient.setVisible(true);
				scrollPaneListKundeInDB.setVisible(true);
				lblClientiInDb.setVisible(true);
				listKundenInDB.setListData(allKunden.toArray());
				btnEditeazaClient.setEnabled(false);
				btnVerwaltungMainUI.setEnabled(false);
				btnSituatieClientMainUI.setEnabled(false);
			}
		});
		mainUI.add(btnCautaClient);
		
		//Create Customer
		btnCreazaClient = new JButton("Creaza Client");
		btnCreazaClient.setBounds(21, 157, 135, 23);
		btnCreazaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainUI.setVisible(false);
				kundeUI.setVisible(true);
				frmArcSolutions.setTitle("ARC Solutions - Creaza Client");
				
				angeklickteButton = "btnCreazaClient";
			}
		});
		mainUI.add(btnCreazaClient);
		
		scrollPaneListKundeInDB = new JScrollPane();
		scrollPaneListKundeInDB.setBounds(21, 316, 848, 317);
		scrollPaneListKundeInDB.setVisible(false);
		mainUI.add(scrollPaneListKundeInDB);
		listKundenInDB = new JList();
		listKundenInDB.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listKundenInDB.addListSelectionListener(new ListSelectionListener() {
			
			// enable Edit-button and Debitorenverwaltung-button when one Item is selected
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnEditeazaClient.setEnabled(true);
				btnVerwaltungMainUI.setEnabled(true);
				btnSituatieClientMainUI.setEnabled(true);
			}
		});
		scrollPaneListKundeInDB.setViewportView(listKundenInDB);
		
		lblClientiInDb = new JLabel("Clienti in DB");
		lblClientiInDb.setBounds(21, 290, 111, 14);
		lblClientiInDb.setVisible(false);
		mainUI.add(lblClientiInDb);
		
		txtFldCautaClient = new JTextField();
		txtFldCautaClient.setBounds(313, 120, 556, 23);
		mainUI.add(txtFldCautaClient);
		txtFldCautaClient.setColumns(10);
		
		//Debitorenverwaltung
		btnVerwaltungMainUI = new JButton("Administreaza");
		btnVerwaltungMainUI.setBounds(313, 282, 175, 23);
		btnVerwaltungMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//debitorenMainUI only when one customer selected is
				//set debitorenMainUI as visible
				mainUI.setVisible(false);
				kundeverwaltungMainUI.setVisible(true);
				frmArcSolutions.setTitle("ARC Solutions - Administreaza client - "+ getSelectedCustomer().getDenumireClient().toString());
				
				//list only one customer as title in DebitorenMainUI
				lblClientSelectatDebMainUi.setText(getSelectedCustomer().getDenumireClient().toString());
			}
		});
		btnVerwaltungMainUI.setVisible(false);
		btnVerwaltungMainUI.setEnabled(false);
		mainUI.add(btnVerwaltungMainUI);
		
		//Edit Customer
		btnEditeazaClient = new JButton("Editeaza Client");
		btnEditeazaClient.setBounds(136, 282, 175, 23);
		btnEditeazaClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kundeUI.setVisible(true);
				mainUI.setVisible(false);
				frmArcSolutions.setTitle("ARC Solutions - Editeaza Client");
			
				//Edit and Update selected customer
				txtFldDenumireClientKundeUI.setText(getSelectedCustomer().getDenumireClient().toString());
				txtFldNrCtrKundeUI.setText(getSelectedCustomer().getNrContract().toString());
				txtFldActeAditionaleKundeUI.setText(getSelectedCustomer().getActeAditionale().toString());
				comboBoxValabilitateCtrKundeUI.setSelectedItem(getSelectedCustomer().getValabilitateCtr().toString());
				txtFldCUIKundeKundeUI.setText(getSelectedCustomer().getCui().toString());
				txtFldNrONRCClientKundeUI.setText(getSelectedCustomer().getNrONRC().toString());
				textAreaContactClientKundeUI.setText(getSelectedCustomer().getContactClient().toString());
				txtFldStradaKundeKundeUI.setText(getSelectedCustomer().getAdresa().getStrada().toString());
				txtFldNummerStrKundeUI.setText(getSelectedCustomer().getAdresa().getNummer());
				txtFldPLZKundeKundeUI.setText(getSelectedCustomer().getAdresa().getCodPostal());
				txtFldLocalitateKundeKundeUI.setText(getSelectedCustomer().getAdresa().getOras());
				txtFldTaraKundeKundeUI.setText(getSelectedCustomer().getAdresa().getCountry());
				
//				tableProcenteKundeProcenteUI.setModel();
				
				angeklickteButton = "btnEditeazaClient";
				
			}
		});
		btnEditeazaClient.setEnabled(false);
		btnEditeazaClient.setVisible(false);
		mainUI.add(btnEditeazaClient);
		
		sep1MainUI = new JSeparator();
		sep1MainUI.setBounds(19, 45, 850, 12);
		mainUI.add(sep1MainUI);
		
		btnSituatieClientMainUI = new JButton("Situatie Client");
		btnSituatieClientMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(false);
				situatieClientUI.setVisible(true);
				frmArcSolutions.setTitle("ARC Solutions - Situatie Client -> "+getSelectedCustomer().getDenumireClient());
				
				//get current date
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				String currentDateAsString = dateFormat.format(cal.getTime());
				
				setDataSituatieUI(currentDateAsString.substring(0, 4), currentDateAsString.substring(5, 7));
			}
		});
		btnSituatieClientMainUI.setBounds(21, 59, 158, 29);
		btnSituatieClientMainUI.setEnabled(false);
		mainUI.add(btnSituatieClientMainUI);
		
		btnFacturiDePrescrisMainUI = new JButton("Alerte Facturi");
		btnFacturiDePrescrisMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(false);
				alerteFacturiUI.setVisible(true);
				
				//if termen prescriere = 365*3 days => ref date(60 days) = totay-1035 days
				//get current date
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1095);
				String dateBefore1095DaysString = dateFormat.format(cal.getTime());
				Date dateBefore1095Days = Date.valueOf(dateBefore1095DaysString);
				
				ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
				DBverbindung.dbconnect();
				billings = bs.getBillingsForAlerteFacturi(dateBefore1095Days);
				DBverbindung.dbdisconect();
				
				dataAlerteFacturiTable = new String[billings.size()][6];
				for(int row = 0; row < billings.size(); row ++){
					Billingdomain billing = billings.get(row);
					dataAlerteFacturiTable[row] = new String[6];
					dataAlerteFacturiTable[row][0] = billing.getNameKunde();
					dataAlerteFacturiTable[row][1] = billing.getNameDebitor(); 
					dataAlerteFacturiTable[row][2] = billing.getNrFactura();
					dataAlerteFacturiTable[row][3] = String.valueOf(billing.getSumaFactura());
					dataAlerteFacturiTable[row][4] = String.valueOf(billing.getDataScadentaFactura());
					cal.setTime(billing.getDataScadentaFactura());
					cal.add(Calendar.DATE, 365);
					dataAlerteFacturiTable[row][5] = dateFormat.format(cal.getTime());
				}
				
				tableAlerteFacturiUI.setModel(new DefaultTableModel(dataAlerteFacturiTable, headerAlerteFacturiTable));
				
			}
		});
		btnFacturiDePrescrisMainUI.setBounds(191, 59, 158, 29);
		mainUI.add(btnFacturiDePrescrisMainUI);
		
		sep2MainUI = new JSeparator();
		sep2MainUI.setBounds(21, 87, 848, 12);
		mainUI.add(sep2MainUI);
		 
		comboBoxSearchMainUI = new JComboBox(searchKundeElement);
		comboBoxSearchMainUI.setBounds(179, 120, 104, 27);
		mainUI.add(comboBoxSearchMainUI);
		
		btnRaportareGenMainUI = new JButton("Raportari");
		btnRaportareGenMainUI.setBounds(361, 59, 158, 29);
		mainUI.add(btnRaportareGenMainUI);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(21, 645, 450, 12);
		mainUI.add(separator_6);
		
		lblMessageBarMainUI = new JLabel("");
		lblMessageBarMainUI.setBounds(21, 656, 450, 16);
		mainUI.add(lblMessageBarMainUI);
	}

	/**
	 * kundeUI
	 */
	private void kundeUI(){
//		Kundeservice ks = new Kundeservice();
		
		kundeUI = new JPanel();
		frmArcSolutions.getContentPane().add(kundeUI, "name_27327655750175");
		kundeUI.setLayout(null);
		
		lblTitleKundeUI = new JLabel("Introduce Client Nou");
		lblTitleKundeUI.setBounds(21, 30, 152, 14);
		kundeUI.add(lblTitleKundeUI);
		
		lblDenumireClientKundeUI = new JLabel("*Denumire Client");
		lblDenumireClientKundeUI.setBounds(51, 178, 137, 20);
		kundeUI.add(lblDenumireClientKundeUI);
		
		txtFldDenumireClientKundeUI = new JTextField();
		txtFldDenumireClientKundeUI.setColumns(10);
		txtFldDenumireClientKundeUI.setBounds(183, 178, 314, 20);
		kundeUI.add(txtFldDenumireClientKundeUI);
		
		lblNrCtrKundeUI = new JLabel("*Nr. Contract");
		lblNrCtrKundeUI.setBounds(51, 78, 137, 17);
		kundeUI.add(lblNrCtrKundeUI);
		
		txtFldNrCtrKundeUI = new JTextField();
		txtFldNrCtrKundeUI.setColumns(10);
		txtFldNrCtrKundeUI.setBounds(183, 76, 314, 20);
		kundeUI.add(txtFldNrCtrKundeUI);
		
		lblActeAditionaleKundeUI = new JLabel("Acte Aditionale");
		lblActeAditionaleKundeUI.setBounds(51, 107, 115, 17);
		kundeUI.add(lblActeAditionaleKundeUI);
		
		txtFldActeAditionaleKundeUI = new JTextField();
		txtFldActeAditionaleKundeUI.setColumns(10);
		txtFldActeAditionaleKundeUI.setBounds(183, 107, 314, 20);
		kundeUI.add(txtFldActeAditionaleKundeUI);
		
		lblValabilitateCtrKundeUI = new JLabel("Valabilitate Contract");
		lblValabilitateCtrKundeUI.setBounds(571, 78, 137, 17);
		kundeUI.add(lblValabilitateCtrKundeUI);
		 
		//save Customer
		btnSalveazaClientKundeUI = new JButton("Salveaza Client");
		btnSalveazaClientKundeUI.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(true);
				kundeUI.setVisible(false);
				frmArcSolutions.setTitle("ARC Solutions");
				boolean updateFlag = false;
				
				//column model and table model
				TableColumnModel columnModel = tableProcenteKundeProcenteUI.getColumnModel();				
				TableModel tableModel = tableProcenteKundeProcenteUI.getModel();
				int rowCount = tableModel.getRowCount();
				int columnCount = tableModel.getColumnCount();
				System.out.println("row count" + rowCount);
				System.out.println("column count" + columnCount);
				String[][] prozenteSchema = new String[tableModel.getRowCount()+1][7];
				
				//insert header of table 
				for(int zl=0; zl<columnCount; zl++){
					prozenteSchema[0][zl] = columnModel.getColumn(zl).getHeaderValue().toString();
				}
				//insert body of table
				for (int zl1=1; zl1<=rowCount; zl1++){
					for(int zl2=0; zl2 < columnCount; zl2++){
						prozenteSchema[zl1][zl2] = tableModel.getValueAt(zl1-1, zl2).toString();
					}
				}
				
				//first row is the header tabel row
				for(int a = 0; a<rowCount; a++){
					for(int b = 0; b<columnCount; b++){
						System.out.print(prozenteSchema[a][b] +"   ");
					}
					System.out.println("");
				}
				
				
				
				//save or edit/update a customer
				if(!(txtFldDenumireClientKundeUI.getText().isEmpty() || txtFldNrCtrKundeUI.getText().isEmpty())){
					System.out.println(txtFldDenumireClientKundeUI.getText());
					Adresa adresa = new Adresa(txtFldStradaKundeKundeUI.getText(), txtFldNummerStrKundeUI.getText(),
							txtFldPLZKundeKundeUI.getText(),txtFldLocalitateKundeKundeUI.getText(),txtFldTaraKundeKundeUI.getText());
					Kundedomain kundeNou = new Kundedomain(txtFldDenumireClientKundeUI.getText(), txtFldNrCtrKundeUI.getText(), 
							txtFldActeAditionaleKundeUI.getText(), comboBoxValabilitateCtrKundeUI.getSelectedItem().toString(),
							textAreaContactClientKundeUI.getText(), txtFldCUIKundeKundeUI.getText(), txtFldNrONRCClientKundeUI.getText(), adresa, prozenteSchema);
					
					DBverbindung.dbconnect();
					if(angeklickteButton.equals("btnCreazaClient")){
						//create kunde
						int result = ks.createKunde(kundeNou);

						//TODO show Success Messages - move messages into message file
						if(result == 1){
							setMessageBar("Clientul a fost creat", None, MsgBarMainUI);
							updateFlag = true;
							DefaultTableModel newModel = getNewTableModel();
							tableProcenteKundeProcenteUI.setModel(newModel);
							prepareTableModelProzenteUI();
						}else{
							setMessageBar("Clientul nu a putut fi creat", Error, MsgBarMainUI);
							updateFlag = false;
						}
						
//						System.out.println("Button create pressed");
					}else if(angeklickteButton.equals("btnEditeazaClient")){
						//update kunde
						//TODO - updateKunde only when the customer is modified - performance issue??
						int result = ks.updateKunde(selectedKunde.getId(), kundeNou);

						//TODO show Success Messages - move messages into message file
						if(result == 1){
							setMessageBar("Clientul a fost actualizat", None, MsgBarMainUI);
							updateFlag = true;
						}else{
							setMessageBar("Clientul nu a putut fi actualizat", Error, MsgBarMainUI);
							updateFlag = false;
						}
							
//						System.out.println("Button edit pressed");
//						System.out.println(selectedKunde.getId());		
					}
					//refresh list after update or create new customer
					//only if update/create was successfully processed 
					if(updateFlag){
						ArrayList<Kundedomain> allKunden = ks.getAllKunden();
						listKundenInDB.setListData(allKunden.toArray());
					}
					DBverbindung.dbdisconect();
				}
				
				//clear all fields after save
				//clear only if save was successfully
				if(updateFlag)
					clearCustomerUI();
			}
		});
		btnSalveazaClientKundeUI.setBounds(541, 532, 151, 23);
		kundeUI.add(btnSalveazaClientKundeUI);
		
		//Cancel
		btnCancelKundeUI = new JButton("Cancel");
		btnCancelKundeUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(true);
				kundeUI.setVisible(false);
				frmArcSolutions.setTitle("ARC Solutions");
				
				//clear all fields by cancel
				clearCustomerUI();
			}
		});
		btnCancelKundeUI.setBounds(719, 532, 151, 23);
		kundeUI.add(btnCancelKundeUI);
		
		sep1KundeUI = new JSeparator();
		sep1KundeUI.setBounds(21, 57, 855, 12);
		kundeUI.add(sep1KundeUI);
		
		lblContactClientKundeUI = new JLabel("Contact Client");
		lblContactClientKundeUI.setBounds(51, 210, 129, 16);
		kundeUI.add(lblContactClientKundeUI);
		
		lblAdresaKundeKundeUI = new JLabel("Adresa");
		lblAdresaKundeKundeUI.setBounds(51, 330, 88, 16);
		kundeUI.add(lblAdresaKundeKundeUI);
		
		lblStradaKundeKundeUI = new JLabel("Strada");
		lblStradaKundeKundeUI.setBounds(81, 358, 85, 16);
		kundeUI.add(lblStradaKundeKundeUI);
		
		lblNummerStrKundeUI = new JLabel("Numar");
		lblNummerStrKundeUI.setBounds(81, 386, 61, 16);
		kundeUI.add(lblNummerStrKundeUI);
		
		lblLocalitateKundeKundeUI = new JLabel("Localitate");
		lblLocalitateKundeKundeUI.setBounds(81, 414, 72, 16);
		kundeUI.add(lblLocalitateKundeKundeUI);
		
		lblPLZKundeKundeUI = new JLabel("Cod Postal");
		lblPLZKundeKundeUI.setBounds(81, 442, 85, 16);
		kundeUI.add(lblPLZKundeKundeUI);
		
		lblTaraKundeKundeUI = new JLabel("Tara");
		lblTaraKundeKundeUI.setBounds(81, 470, 61, 16);
		kundeUI.add(lblTaraKundeKundeUI);
		
		txtFldStradaKundeKundeUI = new JTextField();
		txtFldStradaKundeKundeUI.setColumns(10);
		txtFldStradaKundeKundeUI.setBounds(183, 356, 314, 20);
		kundeUI.add(txtFldStradaKundeKundeUI);
		
		txtFldNummerStrKundeUI = new JTextField();
		txtFldNummerStrKundeUI.setColumns(10);
		txtFldNummerStrKundeUI.setBounds(183, 384, 314, 20);
		kundeUI.add(txtFldNummerStrKundeUI);
		
		txtFldLocalitateKundeKundeUI = new JTextField();
		txtFldLocalitateKundeKundeUI.setColumns(10);
		txtFldLocalitateKundeKundeUI.setBounds(183, 412, 314, 20);
		kundeUI.add(txtFldLocalitateKundeKundeUI);
		
		txtFldPLZKundeKundeUI = new JTextField();
		txtFldPLZKundeKundeUI.setColumns(10);
		txtFldPLZKundeKundeUI.setBounds(183, 440, 314, 20);
		kundeUI.add(txtFldPLZKundeKundeUI);
		
		txtFldTaraKundeKundeUI = new JTextField();
		txtFldTaraKundeKundeUI.setText("Romania");
		txtFldTaraKundeKundeUI.setColumns(10);
		txtFldTaraKundeKundeUI.setBounds(183, 468, 314, 20);
		kundeUI.add(txtFldTaraKundeKundeUI);
		
		String[] valabilitateCtr= {"Nedeterminat","Determinat"};
		comboBoxValabilitateCtrKundeUI = new JComboBox(valabilitateCtr);
		comboBoxValabilitateCtrKundeUI.setBounds(720, 74, 156, 27);
		kundeUI.add(comboBoxValabilitateCtrKundeUI);
		
		scrollPaneContactClientKundeUI = new JScrollPane();
		scrollPaneContactClientKundeUI.setBounds(184, 210, 313, 112);
		kundeUI.add(scrollPaneContactClientKundeUI);
		
		textAreaContactClientKundeUI = new JTextArea();
		scrollPaneContactClientKundeUI.setViewportView(textAreaContactClientKundeUI);
		
		sep2KundeUI = new JSeparator();
		sep2KundeUI.setBounds(21, 136, 855, 12);
		kundeUI.add(sep2KundeUI);
		
		lblCUIKundeKundeUI = new JLabel("CUI");
		lblCUIKundeKundeUI.setBounds(571, 180, 45, 16);
		kundeUI.add(lblCUIKundeKundeUI);
		
		txtFldCUIKundeKundeUI = new JTextField();
		txtFldCUIKundeKundeUI.setBounds(670, 178, 200, 20);
		kundeUI.add(txtFldCUIKundeKundeUI);
		txtFldCUIKundeKundeUI.setColumns(10);
		
		lblNrOrcKundeKundeUI = new JLabel("NR. ORNC");
		lblNrOrcKundeKundeUI.setBounds(571, 210, 87, 16);
		kundeUI.add(lblNrOrcKundeKundeUI);
		
		txtFldNrONRCClientKundeUI = new JTextField();
		txtFldNrONRCClientKundeUI.setBounds(670, 210, 200, 20);
		kundeUI.add(txtFldNrONRCClientKundeUI);
		txtFldNrONRCClientKundeUI.setColumns(10);
		
		JButton btnSchemaProcentKundeUI = new JButton("Schema Procente");
		btnSchemaProcentKundeUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kundeUI.setVisible(false);
				procenteKundeUI.setVisible(true);
				
				//set schemaProzente for selected customer
				String[][] schemaProzente = getSelectedCustomer().getProzenteSchema();
				if(schemaProzente.length == 0){
					DefaultTableModel newModel = getNewTableModel();
					tableProcenteKundeProcenteUI.setModel(newModel);
					prepareTableModelProzenteUI();
				}else{
					String[] header = new String[schemaProzente[0].length-2];
					String[][] data = new String[schemaProzente.length-1][schemaProzente[0].length-2];
					//first row is the header tabel row
					for(int a = 0; a<schemaProzente.length; a++){
						String [] row = new String[schemaProzente[0].length-2];
						for(int b = 0; b<schemaProzente[0].length-2; b++){
							System.out.print(schemaProzente[a][b] +"   ");
							row[b] = schemaProzente[a][b+2];
						}
						System.out.println("");
						if(a == 0){
							header = row;
						}else{
							data[a-1] = row;
						}
					}
					DefaultTableModel model = new DefaultTableModel(data, header);
					tableProcenteKundeProcenteUI.setModel(model);
					prepareTableModelProzenteUI();
				}
			}
		});
		btnSchemaProcentKundeUI.setBounds(718, 353, 152, 29);
		kundeUI.add(btnSchemaProcentKundeUI);
	}
	
	/**
	 * kundeverwaltungMainUI
	 */
	public void kundeverwaltungMainUI(){
//		Debitorenservice ds = new Debitorenservice();
		
		kundeverwaltungMainUI = new JPanel();
		frmArcSolutions.getContentPane().add(kundeverwaltungMainUI, "name_79084692757183");
		kundeverwaltungMainUI.setLayout(null);
		
		lblTitleDebMainUI = new JLabel("Client:");
		lblTitleDebMainUI.setBounds(29, 11, 43, 14);
		kundeverwaltungMainUI.add(lblTitleDebMainUI);
		
		//Cancel
		btnCancelDebMainUI = new JButton("Cancel");
		btnCancelDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainUI.setVisible(true);
				kundeverwaltungMainUI.setVisible(false);
				frmArcSolutions.setTitle("ARC Solutions");
				
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
				btnAdministreazaDebMainUI.setEnabled(false);
				btnAdministreazaDebMainUI.setVisible(false);
				
				//clear search field by cancel
				txtFldCautaDebitorDebMainUI.setText(null);
			}
		});
		btnCancelDebMainUI.setBounds(711, 601, 167, 23);
		kundeverwaltungMainUI.add(btnCancelDebMainUI);		
		
		lblClientSelectatDebMainUi = new JLabel("Client Selectat");
		lblClientSelectatDebMainUi.setBounds(157, 11, 442, 14);
		kundeverwaltungMainUI.add(lblClientSelectatDebMainUi);
		
		btnCautaDebitoriDebMainUI = new JButton("Cauta Debitori");
		btnCautaDebitoriDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String column = getColumnForSearchDebtor(comboBoxCautaDebDebMainUI.getSelectedIndex());
				String searchValue = getSerachFieldValueForSearchDebtor(comboBoxCautaDebDebMainUI.getSelectedIndex());
				
				DBverbindung.dbconnect();
				ArrayList<Debitorendomain> allDebitoren = ds.getAllDebitorenByKundenId(selectedKunde.getId(), column, searchValue);
				DBverbindung.dbdisconect();	
				
				listDebitorenInDbDebMainUI.setVisible(true);
				btnEditeazaDebitorDebMainUI.setVisible(true);
				btnAdministreazaDebMainUI.setVisible(true);
				scrollPaneListDebitoriInDB.setVisible(true);
				lblDebitoriInDbDebMainUI.setVisible(true);
				listDebitorenInDbDebMainUI.setListData(allDebitoren.toArray());
				btnEditeazaDebitorDebMainUI.setEnabled(false);
				btnAdministreazaDebMainUI.setEnabled(false);
			}
		});
		btnCautaDebitoriDebMainUI.setBounds(29, 102, 135, 23);
		kundeverwaltungMainUI.add(btnCautaDebitoriDebMainUI);
		
		//Edit debtor
		btnEditeazaDebitorDebMainUI = new JButton("Editeaza Debitor");
		btnEditeazaDebitorDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kundeverwaltungMainUI.setVisible(false);
				debitorUI.setVisible(true);
				frmArcSolutions.setTitle("ARC Solutions - Editeaza Debitor - " + getSelectedDebtor().getDenumireDebitor() + " (Client "+getSelectedCustomer().getDenumireClient().toString()+")");
				lblClientDebitorUI.setText(getSelectedCustomer().getDenumireClient());
				lblTitleDebitorUI.setText("Editeaza Debitor '"+ getSelectedDebtor().getDenumireDebitor() +"' pentru Clientul");
				
				txtFldDenumireDebitorDebitorUI.setText(getSelectedDebtor().getDenumireDebitor());
				txtFldCUIDebitorDebitorUI.setText(getSelectedDebtor().getCui());
				textAreaContactDebitorUI.setText(getSelectedDebtor().getContactDebitor());
				comboBoxStatusDebitorDebitorUI.setSelectedItem(getSelectedDebtor().getStatusDebitor().toString());
				comboBoxStatusDosarDebitorUI.setSelectedItem(getSelectedDebtor().getStatusDosar().toString());
				txtFldStradaDebitorUI.setText(getSelectedDebtor().getAdresa().getStrada());
				txtFldNumarStrDebitorUI.setText(getSelectedDebtor().getAdresa().getNummer());
				txtFldLocalitateDebitorUI.setText(getSelectedDebtor().getAdresa().getOras());
				txtFldCodPostalDebitorUI.setText(getSelectedDebtor().getAdresa().getCodPostal());
				txtFldTaraDebitorUI.setText(getSelectedDebtor().getAdresa().getCountry());
				
				//enable insert actiune only by create debtor
				setActiuneEnabled(false);
				angeklickteButton = "btnEditeazaDebitorDebMainUI";
			}
		});
		btnEditeazaDebitorDebMainUI.setBounds(136, 282, 167, 23);
		btnEditeazaDebitorDebMainUI.setEnabled(false);
		btnEditeazaDebitorDebMainUI.setVisible(false);
		kundeverwaltungMainUI.add(btnEditeazaDebitorDebMainUI);
		
		btnCreazaDebitorDebMainUI = new JButton("Creaza Debitor");
		btnCreazaDebitorDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kundeverwaltungMainUI.setVisible(false);
				debitorUI.setVisible(true);
				lblClientDebitorUI.setText(getSelectedCustomer().getDenumireClient().toString());
				
				//
				lblDescriptionActiuneDebitorUI.setEnabled(false);
				txtFldActiuneDebitorUI.setEnabled(false);
				textAreaActiuniDebitorUI.setEnabled(false);
				
				angeklickteButton = "btnCreazaDebitorDebMainUI";
				
			}
		});
		btnCreazaDebitorDebMainUI.setBounds(29, 137, 135, 23);
		kundeverwaltungMainUI.add(btnCreazaDebitorDebMainUI);
		
		txtFldCautaDebitorDebMainUI = new JTextField();
		txtFldCautaDebitorDebMainUI.setColumns(10);
		txtFldCautaDebitorDebMainUI.setBounds(300, 100, 578, 23);
		kundeverwaltungMainUI.add(txtFldCautaDebitorDebMainUI);
		
		scrollPaneListDebitoriInDB = new JScrollPane();
		scrollPaneListDebitoriInDB.setBounds(21, 316, 857, 273);
		scrollPaneListDebitoriInDB.setVisible(false);
		kundeverwaltungMainUI.add(scrollPaneListDebitoriInDB);
		
		listDebitorenInDbDebMainUI = new JList();
		listDebitorenInDbDebMainUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDebitorenInDbDebMainUI.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnEditeazaDebitorDebMainUI.setEnabled(true);
				btnAdministreazaDebMainUI.setEnabled(true);
			}
		});
		scrollPaneListDebitoriInDB.setViewportView(listDebitorenInDbDebMainUI);
		
		
		lblDebitoriInDbDebMainUI = new JLabel("Debitori in DB");
		lblDebitoriInDbDebMainUI.setBounds(21, 290, 111, 14);
		lblDebitoriInDbDebMainUI.setVisible(false);
		kundeverwaltungMainUI.add(lblDebitoriInDbDebMainUI);
		
		btnAdministreazaDebMainUI = new JButton("Administreaza");
		btnAdministreazaDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kundeverwaltungMainUI.setVisible(false);
				debitorenverwaltungMainUI.setVisible(true);
				frmArcSolutions.setTitle("ARC Solutions - Administreaza debitor - " +getSelectedDebtor().getDenumireDebitor());
				
				lblDebitorBillingMainUI.setText(getSelectedDebtor().getDenumireDebitor());
				btnEditeazaFacturaBillingMainUI.setVisible(true);
				btnEditeazaFacturaBillingMainUI.setEnabled(false);
			}
		});
		btnAdministreazaDebMainUI.setBounds(315, 279, 167, 29);
		btnAdministreazaDebMainUI.setEnabled(false);
		btnAdministreazaDebMainUI.setVisible(false);
		kundeverwaltungMainUI.add(btnAdministreazaDebMainUI);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(20, 37, 858, 12);
		kundeverwaltungMainUI.add(separator_2);
		
		String[] searchDebitorElement = {"Nume", "CUI", "Activ", "Inactiv", "Amiabil", "In instanza", "In executare"};
		comboBoxCautaDebDebMainUI = new JComboBox(searchDebitorElement);
		comboBoxCautaDebDebMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = comboBoxCautaDebDebMainUI.getSelectedIndex();
				if (selectedIndex > 1){
					txtFldCautaDebitorDebMainUI.setText(null);
					txtFldCautaDebitorDebMainUI.setEditable(false);
				} else {
					txtFldCautaDebitorDebMainUI.setText(null);
					txtFldCautaDebitorDebMainUI.setEditable(true);
				}
			}
		});
		comboBoxCautaDebDebMainUI.setBounds(171, 100, 117, 27);
		kundeverwaltungMainUI.add(comboBoxCautaDebDebMainUI);
		
		btnReportClientKundeVerwMainUI = new JButton("Raport Client");
		btnReportClientKundeVerwMainUI.setBounds(30, 49, 134, 29);
		kundeverwaltungMainUI.add(btnReportClientKundeVerwMainUI);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(20, 78, 858, 12);
		kundeverwaltungMainUI.add(separator_3);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(21, 645, 450, 12);
		kundeverwaltungMainUI.add(separator_7);
		
		lblMessageBarDebMainUI = new JLabel("");
		lblMessageBarDebMainUI.setBounds(21, 656, 450, 16);
		kundeverwaltungMainUI.add(lblMessageBarDebMainUI);
	}
	
	/**
	 * debitorUI
	 */
	public void debitorUI(){
		debitorUI = new JPanel();
		frmArcSolutions.getContentPane().add(debitorUI, "name_1409479611197372000");
		debitorUI.setLayout(null);
		
		lblTitleDebitorUI = new JLabel("Introduce Debitor nou pentru Clientul");
		lblTitleDebitorUI.setBounds(10, 31, 264, 14);
		debitorUI.add(lblTitleDebitorUI);
		
		btnCancelDebitorUI = new JButton("Cancel");
		btnCancelDebitorUI.setBounds(700, 620, 172, 29);
		btnCancelDebitorUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorUI.setVisible(false);
				kundeverwaltungMainUI.setVisible(true);
				frmArcSolutions.setTitle("ARC Solutions - Administreaza - "+ getSelectedCustomer().getDenumireClient().toString());
				
				//clear all fields by cancel
				clearDebitorUI();
				
				//set actiune enabled
				setActiuneEnabled(true);
				
				//remove value state denumire debtor
				txtFldDenumireDebitorDebitorUI.setBorder(txtFldCUIDebitorDebitorUI.getBorder());
			}
		});
		debitorUI.add(btnCancelDebitorUI);
		
		lblClientDebitorUI = new JLabel("Selected Customer...");
		lblClientDebitorUI.setBounds(286, 30, 205, 16);
		debitorUI.add(lblClientDebitorUI);
		
		lblDenumireDebitorDebitorUI = new JLabel("*Denumire Debitor");
		lblDenumireDebitorDebitorUI.setBounds(52, 81, 165, 16);
		debitorUI.add(lblDenumireDebitorDebitorUI);
		
		lblContactDebitorDebitorUI = new JLabel("Contact Debitor");
		lblContactDebitorDebitorUI.setBounds(52, 109, 165, 16);
		debitorUI.add(lblContactDebitorDebitorUI);
		
		JLabel lblAdresaDebitorUI = new JLabel("Adresa");
		lblAdresaDebitorUI.setBounds(52, 180, 165, 16);
		debitorUI.add(lblAdresaDebitorUI);
		
		JLabel lblStrasseDebitorUI = new JLabel("Strada");
		lblStrasseDebitorUI.setBounds(78, 208, 61, 16);
		debitorUI.add(lblStrasseDebitorUI);
		
		JLabel lblNumarDebitorUI = new JLabel("Numar");
		lblNumarDebitorUI.setBounds(78, 236, 61, 16);
		debitorUI.add(lblNumarDebitorUI);
		
		JLabel lblLocalitateDebitorUI = new JLabel("Localitate");
		lblLocalitateDebitorUI.setBounds(78, 264, 92, 16);
		debitorUI.add(lblLocalitateDebitorUI);
		
		JLabel lblCodPostalDebitorUI = new JLabel("Cod Postal");
		lblCodPostalDebitorUI.setBounds(78, 292, 92, 16);
		debitorUI.add(lblCodPostalDebitorUI);
		
		JLabel lblTaraDebitorUI = new JLabel("Tara");
		lblTaraDebitorUI.setBounds(78, 320, 61, 16);
		debitorUI.add(lblTaraDebitorUI);
		
		txtFldDenumireDebitorDebitorUI = new JTextField();
		txtFldDenumireDebitorDebitorUI.setBounds(204, 79, 350, 20);
		debitorUI.add(txtFldDenumireDebitorDebitorUI);
		txtFldDenumireDebitorDebitorUI.setColumns(10);
		
		txtFldStradaDebitorUI = new JTextField();
		txtFldStradaDebitorUI.setBounds(204, 206, 350, 20);
		debitorUI.add(txtFldStradaDebitorUI);
		txtFldStradaDebitorUI.setColumns(10);
		
		txtFldNumarStrDebitorUI = new JTextField();
		txtFldNumarStrDebitorUI.setBounds(204, 234, 350, 20);
		debitorUI.add(txtFldNumarStrDebitorUI);
		txtFldNumarStrDebitorUI.setColumns(10);
		
		txtFldLocalitateDebitorUI = new JTextField();
		txtFldLocalitateDebitorUI.setBounds(204, 262, 350, 20);
		debitorUI.add(txtFldLocalitateDebitorUI);
		txtFldLocalitateDebitorUI.setColumns(10);
		
		txtFldCodPostalDebitorUI = new JTextField();
		txtFldCodPostalDebitorUI.setBounds(204, 290, 350, 20);
		debitorUI.add(txtFldCodPostalDebitorUI);
		txtFldCodPostalDebitorUI.setColumns(10);
		
		txtFldTaraDebitorUI = new JTextField();
		txtFldTaraDebitorUI.setBounds(204, 318, 350, 20);
		debitorUI.add(txtFldTaraDebitorUI);
		txtFldTaraDebitorUI.setColumns(10);
		txtFldTaraDebitorUI.setText("Romania");
		
		
		scrollPaneContactDebitorUI = new JScrollPane();
		scrollPaneContactDebitorUI.setBounds(204, 109, 350, 77);
		debitorUI.add(scrollPaneContactDebitorUI);		
		textAreaContactDebitorUI = new JTextArea();
		scrollPaneContactDebitorUI.setViewportView(textAreaContactDebitorUI);
		
		btnSalveazaDebitorUI = new JButton("Salveaza Debitor");
		btnSalveazaDebitorUI.setBounds(516, 620, 172, 29);
		btnSalveazaDebitorUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtFldDenumireDebitorDebitorUI.getText().isEmpty()){
					//TODO set and remove error state
					System.out.println(txtFldDenumireDebitorDebitorUI.getBorder().toString());
					txtFldDenumireDebitorDebitorUI.setBorder(BorderFactory.createLineBorder(Color.decode("#FF0000")));
					return;
				}
				
				kundeverwaltungMainUI.setVisible(true);
				debitorUI.setVisible(false);
				frmArcSolutions.setTitle("ARC Solutions - Administreaza - "+ getSelectedCustomer().getDenumireClient().toString());
				boolean updateFlag = false;
				
				//save or edit/update a new debitor
				if(!(txtFldDenumireDebitorDebitorUI.getText().isEmpty())){
					Adresa adresa = new Adresa(txtFldStradaDebitorUI.getText(), txtFldNumarStrDebitorUI.getText(), txtFldCodPostalDebitorUI.getText(), txtFldLocalitateDebitorUI.getText(), txtFldTaraDebitorUI.getText());
					Actiune actiune;
					if(chckBoxActiuneDebitorStatus=="Selected"){
						actiune = new Actiune(txtFldActiuneDebitorUI.getText(), textAreaActiuniDebitorUI.getText());
					}else{
						actiune = null;
					}
					Debitorendomain debitor = new Debitorendomain(txtFldDenumireDebitorDebitorUI.getText(), txtFldCUIDebitorDebitorUI.getText(), textAreaContactDebitorUI.getText(), comboBoxStatusDebitorDebitorUI.getSelectedItem().toString(), comboBoxStatusDosarDebitorUI.getSelectedItem().toString(), adresa, actiune);
					
					DBverbindung.dbconnect();
					if(angeklickteButton.equals("btnCreazaDebitorDebMainUI")){
						System.out.println("btn Creaza Debitor geclicked");
	
						int result = ds.createDebitor(debitor, getSelectedCustomer().getId(), chckBoxActiuneDebitorStatus);
						
						//TODO show Success Messages - move messages into message file
						if(result == 1){
							setMessageBar("Debitorul a fost creat", None, MsgBarDebUI);
							updateFlag = true;
						}else{
							setMessageBar("Debitorul nu a putut fi creat", Error, MsgBarDebUI);
							updateFlag = false;
						}
					}else if(angeklickteButton.equals("btnEditeazaDebitorDebMainUI")){
						int result = ds.updateDebitor(getSelectedDebtor().getIdDeb(), debitor);
						
						//TODO show Success Messages - move messages into message file
						if(result == 1){
							setMessageBar("Debitorul a fost actualizat", None, MsgBarDebUI);
							updateFlag = true;
						}else{
							setMessageBar("Debitorul nu a putut fi actualizat", Error, MsgBarDebUI);
							updateFlag = false;
						}
					}
					if(updateFlag){
						ArrayList<Debitorendomain> allDebitoren = ds.getAllDebitorenByKundenId(selectedKunde.getId(), "DenumireDebitor", "");
						listDebitorenInDbDebMainUI.setListData(allDebitoren.toArray());
					}
					DBverbindung.dbdisconect();
				}
				//clear all fields after save
				//clear only if save was successfully
				if(updateFlag)
					clearDebitorUI();
			}
		});
		debitorUI.add(btnSalveazaDebitorUI);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(52, 348, 820, 12);
		debitorUI.add(separator);
		
		scrollPaneActiuniDebitorUI = new JScrollPane();
		scrollPaneActiuniDebitorUI.setBounds(130, 428, 742, 168);
		debitorUI.add(scrollPaneActiuniDebitorUI);
		textAreaActiuniDebitorUI = new JTextArea();
		scrollPaneActiuniDebitorUI.setViewportView(textAreaActiuniDebitorUI);
		
		lblCUIDebitorDebitorUI = new JLabel("CUI");
		lblCUIDebitorDebitorUI.setBounds(609, 81, 46, 16);
		debitorUI.add(lblCUIDebitorDebitorUI);
		
		txtFldCUIDebitorDebitorUI = new JTextField();
		txtFldCUIDebitorDebitorUI.setBounds(726, 79, 146, 20);
		debitorUI.add(txtFldCUIDebitorDebitorUI);
		txtFldCUIDebitorDebitorUI.setColumns(10);
		
		lblStatusDebitorDebitorUI = new JLabel("Status Debitor");
		lblStatusDebitorDebitorUI.setBounds(609, 113, 101, 16);
		debitorUI.add(lblStatusDebitorDebitorUI);
		
		lblStatusDosarDebitorDebitorUI = new JLabel("Status Dosar");
		lblStatusDosarDebitorDebitorUI.setBounds(609, 152, 86, 16);
		debitorUI.add(lblStatusDosarDebitorDebitorUI);
		
		comboBoxStatusDebitorDebitorUI = new JComboBox(statusDebitorElement);
		comboBoxStatusDebitorDebitorUI.setBounds(726, 109, 146, 27);
		debitorUI.add(comboBoxStatusDebitorDebitorUI);
		
		comboBoxStatusDosarDebitorUI = new JComboBox(statusDosarDebitorElement);
		comboBoxStatusDosarDebitorUI.setBounds(726, 148, 146, 27);
		debitorUI.add(comboBoxStatusDosarDebitorUI);
		
		lblDescriptionActiuneDebitorUI = new JLabel("Descriere Actiune");
		lblDescriptionActiuneDebitorUI.setBounds(145, 400, 121, 16);
		debitorUI.add(lblDescriptionActiuneDebitorUI);
		
		txtFldActiuneDebitorUI = new JTextField();
		txtFldActiuneDebitorUI.setBounds(278, 394, 594, 28);
		debitorUI.add(txtFldActiuneDebitorUI);
		txtFldActiuneDebitorUI.setColumns(10);
		txtFldActiuneDebitorUI.setEnabled(false);
		
		chckbxActiuneDebitorActiv = new JCheckBox("Introduce Actiune");
		chckbxActiuneDebitorActiv.setBounds(78, 365, 165, 23);
		debitorUI.add(chckbxActiuneDebitorActiv);
		chckbxActiuneDebitorActiv.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					txtFldActiuneDebitorUI.setEnabled(true);
					textAreaActiuniDebitorUI.setEnabled(true);
					lblDescriptionActiuneDebitorUI.setEnabled(true);
					chckBoxActiuneDebitorStatus = "Selected";
				}else {
					txtFldActiuneDebitorUI.setEnabled(false);
					textAreaActiuniDebitorUI.setEnabled(false);
					lblDescriptionActiuneDebitorUI.setEnabled(false);
					chckBoxActiuneDebitorStatus = "Deselected";
				}
			}
		});
	}
	
	/**
	 * billingMainUI
	 */
	public void billingMainUI(){
		debitorenverwaltungMainUI = new JPanel();
		debitorenverwaltungMainUI.setLayout(null);
		
		btnCancelBillingMainUI = new JButton("Cancel");
		btnCancelBillingMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorenverwaltungMainUI.setVisible(false);
				kundeverwaltungMainUI.setVisible(true);
				frmArcSolutions.setTitle("ARC Solutions - Administreaza - "+ getSelectedCustomer().getDenumireClient().toString());
				
				//empty list by cancel
				listResultsInDbBillingMainUI.removeAll();
				ArrayList<String> emptyArray = new ArrayList<String>();
				listResultsInDbBillingMainUI.setListData(emptyArray.toArray());
			}
		});
		btnCancelBillingMainUI.setBounds(755, 600, 117, 29);
		debitorenverwaltungMainUI.add(btnCancelBillingMainUI);
		
		lblTitleBillingMainUI = new JLabel("Administraza Debitor");
		lblTitleBillingMainUI.setBounds(35, 19, 171, 16);
		debitorenverwaltungMainUI.add(lblTitleBillingMainUI);
		
		lblDebitorBillingMainUI = new JLabel("");
		lblDebitorBillingMainUI.setBounds(226, 19, 248, 16);
		debitorenverwaltungMainUI.add(lblDebitorBillingMainUI);
		
		btnCautaFacturaBillingMainUI = new JButton("Cauta Factura");
		btnCautaFacturaBillingMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
				String statusF = comboBoxSearchStatusFactura.getSelectedItem().toString();
				DBverbindung.dbconnect();
				billings = bs.getFacturaByIdKundeAndIdDebitor(getSelectedCustomer().getId(), getSelectedDebtor().getIdDeb(), statusF);
				DBverbindung.dbdisconect();
				listResultsInDbBillingMainUI.setListData(billings.toArray());
				btnEditeazaFacturaBillingMainUI.setVisible(true);
				btnEditeazaFacturaBillingMainUI.setEnabled(false);
			}
		});
		btnCautaFacturaBillingMainUI.setBounds(148, 95, 153, 29);
		debitorenverwaltungMainUI.add(btnCautaFacturaBillingMainUI);
		
		btnAddBillingBillingMainUI = new JButton("Adauga Factura");
		btnAddBillingBillingMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorenverwaltungMainUI.setVisible(false);
				billingUI.setVisible(true);
				
				lblNumeCreditorBillingUI.setText(getSelectedCustomer().getDenumireClient());
				lblNumeDebitorBillingUI.setText(getSelectedDebtor().getDenumireDebitor());
				
				angeklickteButton = "btnAddBillingBillingMainUI";
			}
		});
		btnAddBillingBillingMainUI.setBounds(148, 136, 153, 29);
		debitorenverwaltungMainUI.add(btnAddBillingBillingMainUI);
		
		txtFldFindBillingBillingMainUI = new JTextField();
		txtFldFindBillingBillingMainUI.setBounds(452, 94, 420, 29);
		debitorenverwaltungMainUI.add(txtFldFindBillingBillingMainUI);
		txtFldFindBillingBillingMainUI.setColumns(10);
		
		lblRezultateBillingMainUI = new JLabel("Rezultate in DB");
		lblRezultateBillingMainUI.setBounds(77, 279, 117, 16);
		debitorenverwaltungMainUI.add(lblRezultateBillingMainUI);
		
		btnEditeazaFacturaBillingMainUI = new JButton("Editeaza Factura");
		btnEditeazaFacturaBillingMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorenverwaltungMainUI.setVisible(false);
				billingUI.setVisible(true);
				
				lblNumeCreditorBillingUI.setText(getSelectedCustomer().getDenumireClient());
				lblNumeDebitorBillingUI.setText(getSelectedDebtor().getDenumireDebitor());
				txtFldNrFacturaBillingUI.setText(getSelectedBilling().getNrFactura());
				txtFldSumaFacturaBillingUI.setText(getSelectedBilling().getSumaFactura().toString());
				comboBoxTagFacturaBillingUI.setSelectedItem(getSelectedBilling().getDataFactura().toString().substring(8, 10).toString());
				comboBoxJahresMonatBillingUI.setSelectedItem(getSelectedBilling().getDataFactura().toString().substring(5, 7).toString());
				comboBoxJahrBillingUI.setSelectedItem(getSelectedBilling().getDataFactura().toString().substring(0, 4).toString());
				comboBoxTagScadentaBillingUI.setSelectedItem(getSelectedBilling().getDataScadentaFactura().toString().substring(8, 10).toString());
				comboBoxMonatScadentaBillingUI.setSelectedItem(getSelectedBilling().getDataScadentaFactura().toString().substring(5, 7).toString());
				comboBoxJahrScadentaBillingUI.setSelectedItem(getSelectedBilling().getDataScadentaFactura().toString().substring(0, 4).toString());
				comboBoxStatusFakturaBillingUI.setSelectedItem(getSelectedBilling().getStatus().toString());
				comboBoxTagPreluareCreantaBillingUI.setSelectedItem(getSelectedBilling().getDataPreluareCreanta().toString().substring(8,10).toString());
				comboBoxMonatPreluareCreantaBillingUI.setSelectedItem(getSelectedBilling().getDataPreluareCreanta().toString().substring(5,7).toString());
				comboBoxJahrPreluareCreantaBillingUI.setSelectedItem(getSelectedBilling().getDataPreluareCreanta().toString().substring(0,4).toString());
				
				angeklickteButton = "btnEditeazaFacturaBillingMainUI";
			}
		});
		btnEditeazaFacturaBillingMainUI.setBounds(202, 274, 159, 29);
		debitorenverwaltungMainUI.add(btnEditeazaFacturaBillingMainUI);
		
		comboBoxSearchStatusFactura = new JComboBox(statusFactura);
		comboBoxSearchStatusFactura.setBounds(335, 96, 105, 27);
		debitorenverwaltungMainUI.add(comboBoxSearchStatusFactura);
		
		scrollPaneListResultsInDBDebitronVerwMainUI = new JScrollPane();
		scrollPaneListResultsInDBDebitronVerwMainUI.setBounds(77, 315, 795, 273);
		debitorenverwaltungMainUI.add(scrollPaneListResultsInDBDebitronVerwMainUI);
		
		listResultsInDbBillingMainUI = new JList();
		listResultsInDbBillingMainUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listResultsInDbBillingMainUI.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				btnEditeazaFacturaBillingMainUI.setEnabled(true);
			}
		});
		scrollPaneListResultsInDBDebitronVerwMainUI.setViewportView(listResultsInDbBillingMainUI);
		
		frmArcSolutions.getContentPane().add(debitorenverwaltungMainUI, "name_17654855574017");
		
		separator_1 = new JSeparator();
		separator_1.setBounds(20, 77, 852, 12);
		debitorenverwaltungMainUI.add(separator_1);
		
		btnAfisazaActiuniDebVerwMainUI = new JButton("Afisaza Actiuni");
		btnAfisazaActiuniDebVerwMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listResultsInDbBillingMainUI.setListData(getSelectedDebtor().getActiuni().toArray());
			}
		});
		btnAfisazaActiuniDebVerwMainUI.setBounds(452, 177, 153, 29);
		debitorenverwaltungMainUI.add(btnAfisazaActiuniDebVerwMainUI);
		
		btnAdaugaActiuneDebVerwMainUI = new JButton("Adauga Actiune");
		btnAdaugaActiuneDebVerwMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorenverwaltungMainUI.setVisible(false);
				actiuneUI.setVisible(true);
				frmArcSolutions.setTitle("ARC Solutions - Adauga Actiune - Debitor -> " +getSelectedDebtor().getDenumireDebitor());
				lblNumeDebitorActiuneUI.setText(getSelectedDebtor().getDenumireDebitor());
			}
		});
		btnAdaugaActiuneDebVerwMainUI.setBounds(452, 136, 153, 29);
		debitorenverwaltungMainUI.add(btnAdaugaActiuneDebVerwMainUI);
		
		JButton btnPlatesteFacturaDebVerwMainUI = new JButton("Achitare Factura");
		btnPlatesteFacturaDebVerwMainUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorenverwaltungMainUI.setVisible(false);
				payBillingUI.setVisible(true);
				//set default typ payBilling on Cronologic
				comboBoxTypPayBillingUI.setSelectedIndex(0);
				
				//
				ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
				
				DBverbindung.dbconnect();
				billings = bs.getFacturaByIdKundeAndIdDebitor(getSelectedCustomer().getId(), getSelectedDebtor().getIdDeb(), statusFacturaOpen);
				
				data = new String[billings.size()][6];
				for(int row = 0; row < billings.size(); row ++){
					Billingdomain billing = billings.get(row);
					data[row] = new String[6];
					data[row][0] = billing.getNrFactura();
					data[row][1] = String.valueOf(billing.getDataFactura()); 
					data[row][2] = String.valueOf(billing.getSumaFactura());
					data[row][3] = String.valueOf(billing.getRestPlata());
					data[row][4] = String.valueOf(billing.getStatus());
					data[row][5] = String.valueOf(billing.getDataScadentaFactura());
				}
				tableFacturiNeincasate = new JTable(data, spalten);
//				tableFacturiNeincasate.setEnabled(false);
				tableFacturiNeincasate.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
				scrollPanelFacturiNeincasate.setViewportView(tableFacturiNeincasate);
	
				DBverbindung.dbdisconect();
			}
		});
		btnPlatesteFacturaDebVerwMainUI.setBounds(148, 177, 153, 29);
		debitorenverwaltungMainUI.add(btnPlatesteFacturaDebVerwMainUI);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(20, 250, 852, 12);
		debitorenverwaltungMainUI.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(20, 33, 852, 12);
		debitorenverwaltungMainUI.add(separator_5);
		
		JButton btnReportDebitorDebVerwMauiUI = new JButton("Raport Debitor");
		btnReportDebitorDebVerwMauiUI.setBounds(77, 47, 153, 29);
		debitorenverwaltungMainUI.add(btnReportDebitorDebVerwMauiUI);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 645, 450, 12);
		debitorenverwaltungMainUI.add(separator);
		
		lblMsgBarDebitorenverwaltungUI = new JLabel("");
		lblMsgBarDebitorenverwaltungUI.setBounds(21, 656, 450, 16);
		debitorenverwaltungMainUI.add(lblMsgBarDebitorenverwaltungUI);
	}
	
	/**
	 * actiuneUI
	 */
	public void actiuneUI(){
		actiuneUI = new JPanel();
		frmArcSolutions.getContentPane().add(actiuneUI, "name_1549112413371");
		actiuneUI.setLayout(null);
		
		JLabel lblAdaugaActiuneActiuneUI = new JLabel("Adauga Actiune noua");
		lblAdaugaActiuneActiuneUI.setBounds(38, 23, 200, 23);
		actiuneUI.add(lblAdaugaActiuneActiuneUI);
		
		btnCancelActiuneUI = new JButton("Cancel");
		btnCancelActiuneUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actiuneUI.setVisible(false);
				debitorenverwaltungMainUI.setVisible(true);
				frmArcSolutions.setTitle("ARC Solutions - Administreaza debitor - ");
				
			}
		});
		btnCancelActiuneUI.setBounds(731, 546, 117, 29);
		actiuneUI.add(btnCancelActiuneUI);
		
		JButton btnSalveazaActiuneActiuneUI = new JButton("Salveaza");
		btnSalveazaActiuneActiuneUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				debitorenverwaltungMainUI.setVisible(true);
				actiuneUI.setVisible(false);
				frmArcSolutions.setTitle("ARC Solutions - Administreaza debitor - ");
				boolean updateFlag = false;
				
				Actiune actiune = new Actiune(txtFldKurzDescActiuneUI.getText(), textAreaActiuneUI.getText());
				
				DBverbindung.dbconnect();
				int res = ds.createActiune(actiune, getSelectedDebtor().getIdDeb());
				
				//TODO fill message bar
				if(res == 1){
					System.out.println("insert actiune ok");
					updateFlag = true;
				}else{
					updateFlag = false;
				}
				if(updateFlag){
					ArrayList <Actiune> actiuni = ds.getAllActiuniByDebitorId(getSelectedDebtor().getIdDeb());
					getSelectedDebtor().setActiuni(actiuni);
					listResultsInDbBillingMainUI.setListData(actiuni.toArray());
				}
				DBverbindung.dbdisconect();
			}
		});
		btnSalveazaActiuneActiuneUI.setBounds(587, 546, 117, 29);
		actiuneUI.add(btnSalveazaActiuneActiuneUI);
		
		lblNumeDebitorActiuneUI = new JLabel("Nume Debitor");
		lblNumeDebitorActiuneUI.setBounds(263, 30, 171, 16);
		actiuneUI.add(lblNumeDebitorActiuneUI);
		
		JLabel lblDescriptionActiuneActiuneUI = new JLabel("Descriere Actiune");
		lblDescriptionActiuneActiuneUI.setBounds(80, 80, 158, 16);
		actiuneUI.add(lblDescriptionActiuneActiuneUI);
		
		txtFldKurzDescActiuneUI = new JTextField();
		txtFldKurzDescActiuneUI.setBounds(263, 68, 585, 28);
		actiuneUI.add(txtFldKurzDescActiuneUI);
		txtFldKurzDescActiuneUI.setColumns(10);
		
		JScrollPane scrollPanelActiuneUI = new JScrollPane();
		scrollPanelActiuneUI.setBounds(80, 136, 768, 398);
		actiuneUI.add(scrollPanelActiuneUI);
		
		textAreaActiuneUI = new JTextArea();
		scrollPanelActiuneUI.setViewportView(textAreaActiuneUI);
	}
	
	/**
	 * billingUI
	 */
	private void billingUI(){
		billingUI = new JPanel();
		frmArcSolutions.getContentPane().add(billingUI, "name_3266953894185");
		billingUI.setLayout(null);
		
		JLabel lblTitelBillingUI = new JLabel("Adauga sau editeaza factura");
		lblTitelBillingUI.setBounds(26, 29, 226, 25);
		billingUI.add(lblTitelBillingUI);
		
		btnCancelBillinUI = new JButton("Cancel");
		btnCancelBillinUI.setBounds(735, 563, 117, 29);
		btnCancelBillinUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billingUI.setVisible(false);
				debitorenverwaltungMainUI.setVisible(true);
				
				//empty billingUI by cancel
				clearBillingUI();
			}
		});
		billingUI.add(btnCancelBillinUI);
		
		JLabel lblCreditorBillingUI = new JLabel("Creditor");
		lblCreditorBillingUI.setBounds(100, 84, 178, 16);
		billingUI.add(lblCreditorBillingUI);
		
		lblNumeCreditorBillingUI = new JLabel("Nume Creditor");
		lblNumeCreditorBillingUI.setBounds(350, 84, 178, 16);
		billingUI.add(lblNumeCreditorBillingUI);
		
		JLabel lblDebitorBillingUI = new JLabel("Debitor");
		lblDebitorBillingUI.setBounds(100, 112, 152, 16);
		billingUI.add(lblDebitorBillingUI);
		
		lblNumeDebitorBillingUI = new JLabel("Nume Debitor");
		lblNumeDebitorBillingUI.setBounds(350, 112, 178, 16);
		billingUI.add(lblNumeDebitorBillingUI);
		
		JLabel lblNrFaktura = new JLabel("Nr. Factura");
		lblNrFaktura.setBounds(100, 212, 146, 16);
		billingUI.add(lblNrFaktura);
		
		txtFldNrFacturaBillingUI = new JTextField();
		txtFldNrFacturaBillingUI.setBounds(326, 206, 287, 28);
		billingUI.add(txtFldNrFacturaBillingUI);
		txtFldNrFacturaBillingUI.setColumns(10);
		
		JLabel lblSumaFacturaBillingUI = new JLabel("Suma Factura");
		lblSumaFacturaBillingUI.setBounds(100, 240, 146, 16);
		billingUI.add(lblSumaFacturaBillingUI);
		
		txtFldSumaFacturaBillingUI = new JTextField();
		txtFldSumaFacturaBillingUI.setBounds(326, 234, 287, 28);
		billingUI.add(txtFldSumaFacturaBillingUI);
		txtFldSumaFacturaBillingUI.setColumns(10);
		
		JLabel lblDataEmitereFacturaBillingUI = new JLabel("Data Emitere Factura");
		lblDataEmitereFacturaBillingUI.setBounds(100, 268, 146, 16);
		billingUI.add(lblDataEmitereFacturaBillingUI);
		
		JButton btnSalveazaBillingUI = new JButton("Salveaza");
		btnSalveazaBillingUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				billingUI.setVisible(false);
				debitorenverwaltungMainUI.setVisible(true);
				boolean updateFlag = false;
				
				Double sumaFactura = Double.valueOf((txtFldSumaFacturaBillingUI.getText()));
				String date = comboBoxJahrBillingUI.getSelectedItem().toString()+"-"+comboBoxJahresMonatBillingUI.getSelectedItem().toString()+"-"+comboBoxTagFacturaBillingUI.getSelectedItem().toString();
				Date dateFactura = Date.valueOf(date);
				String dateScadenta = comboBoxJahrScadentaBillingUI.getSelectedItem().toString()+"-"+comboBoxMonatScadentaBillingUI.getSelectedItem().toString()+"-"+comboBoxTagScadentaBillingUI.getSelectedItem().toString();
				Date dataScadenza = Date.valueOf(dateScadenta);
				String datePreluareCreanta = comboBoxJahrPreluareCreantaBillingUI.getSelectedItem().toString()+"-"+comboBoxMonatPreluareCreantaBillingUI.getSelectedItem().toString()+"-"+comboBoxTagPreluareCreantaBillingUI.getSelectedItem().toString();
				Date datePreluareCreanza = Date.valueOf(datePreluareCreanta);
				Billingdomain billing = new Billingdomain(getSelectedCustomer().getId(), getSelectedCustomer().getDenumireClient(), getSelectedDebtor().getIdDeb(), getSelectedDebtor().getDenumireDebitor(), txtFldNrFacturaBillingUI.getText(), sumaFactura, dateFactura, dataScadenza, datePreluareCreanza);
				
				
				DBverbindung.dbconnect();
				if (angeklickteButton.equals("btnAddBillingBillingMainUI")){
					int resultCreateBilling = bs.createFactura(billing);
					
					//Clear billing fields if save was successfully
					if (resultCreateBilling == 1){
						System.out.println("Insert factura ok");
						setMessageBar("Factura a fost introdusa", None, MsgBarDebVerUI);
						updateFlag = true;
						clearBillingUI();
					}else{
						updateFlag = false;
						setMessageBar("Factura a putut fi introdusa", Error, MsgBarDebVerUI);
					}
				}else if (angeklickteButton.equals("btnEditeazaFacturaBillingMainUI")){
					billing.setStatus(comboBoxStatusFakturaBillingUI.getSelectedItem().toString());
					int resultUpdateBilling = bs.updateFactura(getSelectedBilling().getIdFactura(),billing);
					
					//Clear billing fields if save was successfully
					if (resultUpdateBilling == 1){
						System.out.println("Update factura ok");
						setMessageBar("Factura a fost modificata", None, MsgBarDebVerUI);
						updateFlag = true;
						clearBillingUI();
					}else{
						updateFlag = false;
						setMessageBar("Factura a putut fi modificata", Error, MsgBarDebVerUI);
					}
				}
				
				//refresh entry list if update was successfully
				if(updateFlag){
					ArrayList<Billingdomain> billings = bs.getFacturaByIdKundeAndIdDebitor(getSelectedCustomer().getId(), getSelectedDebtor().getIdDeb(), statusFacturaOpen);
					listResultsInDbBillingMainUI.setListData(billings.toArray());
				}
				DBverbindung.dbdisconect();
			}
		});
		btnSalveazaBillingUI.setBounds(606, 563, 117, 29);
		billingUI.add(btnSalveazaBillingUI);
		
		String[] monatsTagen = MonatsTagen();
		comboBoxTagFacturaBillingUI = new JComboBox(monatsTagen);
		comboBoxTagFacturaBillingUI.setBounds(326, 264, 89, 27);
		billingUI.add(comboBoxTagFacturaBillingUI);
		
		String[] monats = JahresMonats();
		comboBoxJahresMonatBillingUI = new JComboBox(monats);
		comboBoxJahresMonatBillingUI.setBounds(423, 264, 89, 27);
		billingUI.add(comboBoxJahresMonatBillingUI);
		
		String[] jahre = Jahre();
		comboBoxJahrBillingUI = new JComboBox(jahre);
		comboBoxJahrBillingUI.setBounds(524, 264, 89, 27);
		billingUI.add(comboBoxJahrBillingUI);
		
		JLabel lblDataScadentaFacturaBillingUI = new JLabel("Data Scadenta Factura");
		lblDataScadentaFacturaBillingUI.setBounds(100, 296, 146, 16);
		billingUI.add(lblDataScadentaFacturaBillingUI);
		
		comboBoxTagScadentaBillingUI = new JComboBox(monatsTagen);
		comboBoxTagScadentaBillingUI.setBounds(326, 296, 89, 27);
		billingUI.add(comboBoxTagScadentaBillingUI);
		
		comboBoxMonatScadentaBillingUI = new JComboBox(monats);
		comboBoxMonatScadentaBillingUI.setBounds(423, 296, 89, 27);
		billingUI.add(comboBoxMonatScadentaBillingUI);
		
		comboBoxJahrScadentaBillingUI = new JComboBox(jahre);
		comboBoxJahrScadentaBillingUI.setBounds(524, 296, 89, 27);
		billingUI.add(comboBoxJahrScadentaBillingUI);
		
		JLabel lblStatusFactura = new JLabel("Status Factura");
		lblStatusFactura.setBounds(606, 84, 117, 16);
		billingUI.add(lblStatusFactura);
		
		comboBoxStatusFakturaBillingUI = new JComboBox(statusFactura);
		comboBoxStatusFakturaBillingUI.setBounds(735, 80, 99, 27);
		billingUI.add(comboBoxStatusFakturaBillingUI);
		
		JLabel lblDataPreluareCreantaBillingUI = new JLabel("Data Preluare Creanta");
		lblDataPreluareCreantaBillingUI.setBounds(100, 324, 146, 16);
		billingUI.add(lblDataPreluareCreantaBillingUI);
		
		comboBoxTagPreluareCreantaBillingUI = new JComboBox(monatsTagen);
		comboBoxTagPreluareCreantaBillingUI.setBounds(326, 324, 89, 27);
		billingUI.add(comboBoxTagPreluareCreantaBillingUI);
		
		comboBoxMonatPreluareCreantaBillingUI = new JComboBox(monats);
		comboBoxMonatPreluareCreantaBillingUI.setBounds(423, 324, 89, 27);
		billingUI.add(comboBoxMonatPreluareCreantaBillingUI);
		
		comboBoxJahrPreluareCreantaBillingUI = new JComboBox(jahre);
		comboBoxJahrPreluareCreantaBillingUI.setBounds(524, 324, 89, 27);
		billingUI.add(comboBoxJahrPreluareCreantaBillingUI);
	}
	
	/**
	 * payBillingUI
	 */
	private void payBillingUI(){
		payBillingUI = new JPanel();
		frmArcSolutions.getContentPane().add(payBillingUI, "name_3770850380450");
		payBillingUI.setLayout(null);
		
		lblTitlePayBillingUI = new JLabel("Incaseaza factura");
		lblTitlePayBillingUI.setBounds(49, 46, 139, 23);
		payBillingUI.add(lblTitlePayBillingUI);
		
		btnCancelPayBillingUI = new JButton("Cancel");
		btnCancelPayBillingUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payBillingUI.setVisible(false);
				debitorenverwaltungMainUI.setVisible(true);
				
				//clear text field Suma Achitata
				txtFldSumaAchitata.setText(null);
			}
		});
		btnCancelPayBillingUI.setBounds(727, 590, 117, 29);
		payBillingUI.add(btnCancelPayBillingUI);
		
		String[] typPlata = { "Cronologic", "La Cerere"};
		comboBoxTypPayBillingUI = new JComboBox(typPlata);
		comboBoxTypPayBillingUI.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	//TODO hide/show lbl and txtfld nr factura
		        if(comboBoxTypPayBillingUI.getSelectedItem().toString().equals("Cronologic")){
		        	lblNrFacturaPayBillingUI.setVisible(false);
		        	txtFldNrFacturaPayBillingUI.setVisible(false);
		        }else if(comboBoxTypPayBillingUI.getSelectedItem().toString().equals("La Cerere")){
			        lblNrFacturaPayBillingUI.setVisible(true);
		        	txtFldNrFacturaPayBillingUI.setVisible(true);
		        }
		    }
		});
		comboBoxTypPayBillingUI.setBounds(213, 45, 139, 27);
		payBillingUI.add(comboBoxTypPayBillingUI);
		
		JLabel lblSumaAchitataBillingUI = new JLabel("Suma Achitata");
		lblSumaAchitataBillingUI.setBounds(49, 541, 139, 16);
		payBillingUI.add(lblSumaAchitataBillingUI);
		
		JLabel lblFacturiNeincasateBillingUI = new JLabel("Facturi neincasate");
		lblFacturiNeincasateBillingUI.setBounds(49, 124, 139, 16);
		payBillingUI.add(lblFacturiNeincasateBillingUI);
		
		scrollPanelFacturiNeincasate = new JScrollPane();
		scrollPanelFacturiNeincasate.setBounds(49, 152, 795, 365);
		payBillingUI.add(scrollPanelFacturiNeincasate);
		
//		tableFacturiNeincasate = new JTable(data, spalten);
		scrollPanelFacturiNeincasate.setViewportView(tableFacturiNeincasate);
		
		txtFldSumaAchitata = new JTextField();
		txtFldSumaAchitata.setBounds(213, 529, 134, 28);
		payBillingUI.add(txtFldSumaAchitata);
		txtFldSumaAchitata.setColumns(10);
		
		JButton btnSalveazaPayBillingUI = new JButton("Salveaza");
		btnSalveazaPayBillingUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//typ pay billing - cronologic
				if(comboBoxTypPayBillingUI.getSelectedItem().toString().equals("Cronologic")){
					
					if(txtFldSumaAchitata.getText().isEmpty() || (comboBoxMonatDataIncasarePayBillingUI.getSelectedItem().toString().equals("An") || comboBoxJahrDataIncasarePayBillingUI.getSelectedItem().toString().equals("Luna") || comboBoxTagDataIncasarePayBillingUI.getSelectedItem().toString().equals("Zi"))){
						setMessageBar("Suma Achitata si Data Incasarii trebuie introduse", Error, MsgBarPayBillingUI);
						return;
					}
					
					String dataIncasare = comboBoxJahrDataIncasarePayBillingUI.getSelectedItem().toString()+"-"+comboBoxMonatDataIncasarePayBillingUI.getSelectedItem().toString()+"-"+comboBoxTagDataIncasarePayBillingUI.getSelectedItem().toString();
					Date dataIncasareFactura = Date.valueOf(dataIncasare);
					
					Double sumaDePlata = Double.valueOf(txtFldSumaAchitata.getText());
					String locIncasare = comboBoxLocPlataPayBillingUI.getSelectedItem().toString();
					
					if(sumaDePlata > 0.0){
						//show confirmation dialog 
						Object[] options = {"Confirma", "Anuleaza"};
						int n = JOptionPane.showOptionDialog(null,
							    "Esti sigur ca vrei sa platesti: '"+sumaDePlata.toString() + "' RON?",
							    "Confirmare Plata",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,
							    options,
							    options[1]);
						//n = 1 -> cancel
						//n = 0 -> confirm
						//n = -1 -> frame close option
						
						if(n == 1 || n == -1){
							//by cancel or window close do nothing !
	//						return;
						}else if(n == 0){
							DBverbindung.dbconnect();
							int result = bs.payBillingSuccessive(selectedKunde.getId(), selectedKunde.getDenumireClient(), selectedDebtor.getIdDeb(), selectedDebtor.getDenumireDebitor(), sumaDePlata, dataIncasareFactura, locIncasare);
							if(result == 1){
								//clear text field Suma Achitata
								txtFldSumaAchitata.setText(null);
								comboBoxJahrDataIncasarePayBillingUI.setSelectedItem("An");
								comboBoxMonatDataIncasarePayBillingUI.setSelectedItem("Luna");
								comboBoxTagDataIncasarePayBillingUI.setSelectedItem("Zi");
	
								//navigate back to overview
								payBillingUI.setVisible(false);
								debitorenverwaltungMainUI.setVisible(true);
								
								//and refresh list of billings
								ArrayList<Billingdomain> billings = bs.getFacturaByIdKundeAndIdDebitor(getSelectedCustomer().getId(), getSelectedDebtor().getIdDeb(), statusFacturaOpen);
								listResultsInDbBillingMainUI.setListData(billings.toArray());
								
								// success message
								setMessageBar("Factura a fost achitata cu succes", None, MsgBarDebVerUI);
							}else{
								//clear text field Suma Achitata
								txtFldSumaAchitata.setText(null);
								comboBoxJahrDataIncasarePayBillingUI.setSelectedItem("An");
								comboBoxMonatDataIncasarePayBillingUI.setSelectedItem("Luna");
								comboBoxTagDataIncasarePayBillingUI.setSelectedItem("Zi");
								
								//navigate back to overview
								payBillingUI.setVisible(false);
								debitorenverwaltungMainUI.setVisible(true);
								
								// error message
								setMessageBar("Factura nu a putut fi achitata", Error, MsgBarDebVerUI);
							}
							DBverbindung.dbdisconect();
						}
					}else{
						setMessageBar("Suma Achitata trebuie sa fie mai mare decat zero", Error, MsgBarPayBillingUI);
					}
				}else if(comboBoxTypPayBillingUI.getSelectedItem().toString().equals("La Cerere")){
					//typ pay billing - La cerere
					
					if(txtFldSumaAchitata.getText().isEmpty() || txtFldNrFacturaPayBillingUI.getText().isEmpty() || (comboBoxMonatDataIncasarePayBillingUI.getSelectedItem().toString().equals("An") || comboBoxJahrDataIncasarePayBillingUI.getSelectedItem().toString().equals("Luna") || comboBoxTagDataIncasarePayBillingUI.getSelectedItem().toString().equals("Zi"))){
						setMessageBar("Suma Achitata si Nr Factura  si Data Incasarii trebuie introduse", Error, MsgBarPayBillingUI);
						return;
					}
					
					String dataIncasare = comboBoxJahrDataIncasarePayBillingUI.getSelectedItem().toString()+"-"+comboBoxMonatDataIncasarePayBillingUI.getSelectedItem().toString()+"-"+comboBoxTagDataIncasarePayBillingUI.getSelectedItem().toString();
					Date dataIncasareFactura = Date.valueOf(dataIncasare);
					
					Double sumaDePlata = Double.valueOf(txtFldSumaAchitata.getText());
					String nrFactura = txtFldNrFacturaPayBillingUI.getText();
					String locIncasare = comboBoxLocPlataPayBillingUI.getSelectedItem().toString();
					
					if(sumaDePlata > 0.0){
						//show confirmation dialog 
						Object[] options = {"Confirma", "Anuleaza"};
						int n = JOptionPane.showOptionDialog(null,
							    "Esti sigur ca vrei sa platesti: '"+sumaDePlata.toString() + "' RON?",
							    "Confirmare Plata",
							    JOptionPane.YES_NO_OPTION,
							    JOptionPane.QUESTION_MESSAGE,
							    null,
							    options,
							    options[1]);
						//n = 1 -> cancel
						//n = 0 -> confirm
						//n = -1 -> frame close option
						
						if(n == 1 || n == -1){
							//by cancel or window close do nothing !
	//						return;
						}else if(n == 0){
							DBverbindung.dbconnect();
							int result = bs.payBillingLaCerere(selectedKunde.getId(), selectedKunde.getDenumireClient(), selectedDebtor.getIdDeb(), selectedDebtor.getDenumireDebitor(), sumaDePlata, nrFactura, dataIncasareFactura, locIncasare);
							if(result == 1){
								//clear text field Suma Achitata
								txtFldSumaAchitata.setText(null);
								comboBoxJahrDataIncasarePayBillingUI.setSelectedItem("An");
								comboBoxMonatDataIncasarePayBillingUI.setSelectedItem("Luna");
								comboBoxTagDataIncasarePayBillingUI.setSelectedItem("Zi");
	
								//navigate back to overview
								payBillingUI.setVisible(false);
								debitorenverwaltungMainUI.setVisible(true);
								
								//and refresh list of billings
								ArrayList<Billingdomain> billings = bs.getFacturaByIdKundeAndIdDebitor(getSelectedCustomer().getId(), getSelectedDebtor().getIdDeb(), statusFacturaOpen);
								listResultsInDbBillingMainUI.setListData(billings.toArray());
								
								// success message
								setMessageBar("Factura a fost achitata cu succes", None, MsgBarDebVerUI);
							}else if(result == -2){
								// error message
								setMessageBar("Suma introdusa de achitat este prea mare", Error, MsgBarPayBillingUI);
							}else{
								//clear text field Suma Achitata
								txtFldSumaAchitata.setText(null);
								txtFldNrFacturaPayBillingUI.setText(null);
								comboBoxJahrDataIncasarePayBillingUI.setSelectedItem("An");
								comboBoxMonatDataIncasarePayBillingUI.setSelectedItem("Luna");
								comboBoxTagDataIncasarePayBillingUI.setSelectedItem("Zi");
								
								//navigate back to overview
								payBillingUI.setVisible(false);
								debitorenverwaltungMainUI.setVisible(true);
								
								// error message
								setMessageBar("Factura nu a putut fi achitata", Error, MsgBarDebVerUI);
							}
							DBverbindung.dbdisconect();
						}
					}else{
						setMessageBar("Suma Achitata trebuie sa fie mai mare decat zero", Error, MsgBarPayBillingUI);
					}
					
				}
			}
		});
		btnSalveazaPayBillingUI.setBounds(594, 590, 117, 29);
		payBillingUI.add(btnSalveazaPayBillingUI);
		
		JLabel lblDataIncasarii = new JLabel("Data incasarii");
		lblDataIncasarii.setBounds(49, 81, 123, 16);
		payBillingUI.add(lblDataIncasarii);
		
		String[] TagenDataIncasatrii = MonatsTagen();
		comboBoxTagDataIncasarePayBillingUI = new JComboBox(TagenDataIncasatrii);
		comboBoxTagDataIncasarePayBillingUI.setBounds(213, 81, 89, 27);
		payBillingUI.add(comboBoxTagDataIncasarePayBillingUI);
		
		String[] JahrDataIncasatrii = Jahre();
		String[] MonatDataIncasatrii = JahresMonats();
		comboBoxMonatDataIncasarePayBillingUI = new JComboBox(MonatDataIncasatrii);
		comboBoxMonatDataIncasarePayBillingUI.setBounds(314, 81, 89, 27);
		payBillingUI.add(comboBoxMonatDataIncasarePayBillingUI);
		
		comboBoxJahrDataIncasarePayBillingUI = new JComboBox(JahrDataIncasatrii);
		comboBoxJahrDataIncasarePayBillingUI.setBounds(411, 81, 89, 27);
		payBillingUI.add(comboBoxJahrDataIncasarePayBillingUI);
		
		String[] locPlata = { "Arc", "Client"};
		comboBoxLocPlataPayBillingUI = new JComboBox(locPlata);
		comboBoxLocPlataPayBillingUI.setBounds(364, 45, 136, 27);
		payBillingUI.add(comboBoxLocPlataPayBillingUI);
		
		lblNrFacturaPayBillingUI = new JLabel("Nr. Factura");
		lblNrFacturaPayBillingUI.setBounds(49, 569, 89, 16);
		lblNrFacturaPayBillingUI.setVisible(false);
		payBillingUI.add(lblNrFacturaPayBillingUI);
		
		txtFldNrFacturaPayBillingUI = new JTextField();
		txtFldNrFacturaPayBillingUI.setBounds(213, 563, 134, 28);
		txtFldNrFacturaPayBillingUI.setVisible(false);
		payBillingUI.add(txtFldNrFacturaPayBillingUI);
		txtFldNrFacturaPayBillingUI.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(49, 645, 450, 12);
		payBillingUI.add(separator);
		
		lblMsgBarPayBillingUI = new JLabel("");
		lblMsgBarPayBillingUI.setBounds(49, 656, 450, 16);
		payBillingUI.add(lblMsgBarPayBillingUI);
		
	}
	
	/**
	 * procenteKundeUI
	 */
	private void procenteKundeUI(){
		procenteKundeUI = new JPanel();
		frmArcSolutions.getContentPane().add(procenteKundeUI, "name_1258455318487");
		procenteKundeUI.setLayout(null);
		
		btnBackProcenteUI = new JButton("Back");
		btnBackProcenteUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				procenteKundeUI.setVisible(false);
				kundeUI.setVisible(true);
			}
		});
		btnBackProcenteUI.setBounds(777, 613, 117, 29);
		procenteKundeUI.add(btnBackProcenteUI);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 120, 817, 195);
		procenteKundeUI.add(scrollPane);
		
		DefaultTableModel newModel = this.getNewTableModel();		
		tableProcenteKundeProcenteUI = new JTable(newModel);
		prepareTableModelProzenteUI();
		scrollPane.setViewportView(tableProcenteKundeProcenteUI);
		
		btnAddLineProcenteUI = new JButton("Adauga Linie Noua");
		btnAddLineProcenteUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				DefaultTableModel model = (DefaultTableModel) tableProcenteKundeProcenteUI.getModel();
				model.addRow(new Object[]{"intervale zile", "0", "0", "0", "0", "0","0"});
			}
		});
		btnAddLineProcenteUI.setBounds(46, 79, 147, 29);
		procenteKundeUI.add(btnAddLineProcenteUI);
		
		btnDeleteLineProcenteUI = new JButton("Sterge Linie");
		btnDeleteLineProcenteUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableProcenteKundeProcenteUI.getSelectedRow();
				System.out.println(row);
				DefaultTableModel model = (DefaultTableModel) tableProcenteKundeProcenteUI.getModel();
				model.removeRow(row);
			}
		});
		btnDeleteLineProcenteUI.setEnabled(false);
		btnDeleteLineProcenteUI.setBounds(205, 79, 147, 29);
		procenteKundeUI.add(btnDeleteLineProcenteUI);
		
		alerteFacturiUI = new JPanel();
		frmArcSolutions.getContentPane().add(alerteFacturiUI, "name_3137812474999");
		alerteFacturiUI.setLayout(null);
		
		JButton btnCancelAlerteFacturiUI = new JButton("Cancel");
		btnCancelAlerteFacturiUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alerteFacturiUI.setVisible(false);
				mainUI.setVisible(true);
			}
		});
		btnCancelAlerteFacturiUI.setBounds(764, 620, 117, 29);
		alerteFacturiUI.add(btnCancelAlerteFacturiUI);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 37, 850, 12);
		alerteFacturiUI.add(separator);
		
		JLabel label_1 = new JLabel("ARC Solutions");
		label_1.setBounds(21, 21, 135, 14);
		alerteFacturiUI.add(label_1);
		
		JScrollPane scrollPaneAlerteFacturiUI = new JScrollPane();
		scrollPaneAlerteFacturiUI.setBounds(21, 61, 850, 547);
		alerteFacturiUI.add(scrollPaneAlerteFacturiUI);
		
		tableAlerteFacturiUI = new JTable();
		scrollPaneAlerteFacturiUI.setViewportView(tableAlerteFacturiUI);
	}
	
	/**
	 * situatie client UI
	 */
	public void situatieClientUI(){
		situatieClientUI = new JPanel();
		frmArcSolutions.getContentPane().add(situatieClientUI, "name_23962869812296");
		situatieClientUI.setLayout(null);
		
		JButton btnCancelSituatieClientUI = new JButton("Cancel");
		btnCancelSituatieClientUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				situatieClientUI.setVisible(false);
				mainUI.setVisible(true);
				frmArcSolutions.setTitle("ARC Solutions");
				
				comboBoxJahrSituatieClientUI.setSelectedItem("An");
				comboBoxMonatSituatieClientUI.setSelectedItem("Luna");
			}
		});
		btnCancelSituatieClientUI.setBounds(759, 610, 117, 29);
		situatieClientUI.add(btnCancelSituatieClientUI);
		
		JLabel label_1 = new JLabel("ARC Solutions");
		label_1.setBounds(21, 18, 135, 14);
		situatieClientUI.add(label_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 45, 850, 12);
		situatieClientUI.add(separator);
		
		lblSituatieGenerala = new JLabel("Situatie Generala");
		lblSituatieGenerala.setBounds(247, 69, 122, 16);
		situatieClientUI.add(lblSituatieGenerala);
		
		lblSituatieAnuala = new JLabel("Situatie Anuala");
		lblSituatieAnuala.setBounds(516, 69, 122, 16);
		situatieClientUI.add(lblSituatieAnuala);
		
		lblSituatieLunara = new JLabel("Situatie Lunara - Anul Curent");
		lblSituatieLunara.setBounds(680, 69, 191, 22);
		situatieClientUI.add(lblSituatieLunara);
		
		lblCreantePreluate = new JLabel("Creante Preluate");
		lblCreantePreluate.setBounds(21, 141, 122, 16);
		situatieClientUI.add(lblCreantePreluate);
		
		lblCreanteRecuperate = new JLabel("Creante Recuperate");
		lblCreanteRecuperate.setBounds(21, 169, 135, 16);
		situatieClientUI.add(lblCreanteRecuperate);
		
		lblRecuperat = new JLabel("% Recuperat");
		lblRecuperat.setBounds(21, 197, 135, 16);
		situatieClientUI.add(lblRecuperat);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(247, 97, 607, 12);
		situatieClientUI.add(separator_4);
		
		lblCreantePreluateSitGenSituatieClientUI = new JLabel("");
		lblCreantePreluateSitGenSituatieClientUI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreantePreluateSitGenSituatieClientUI.setBounds(247, 141, 122, 16);
		situatieClientUI.add(lblCreantePreluateSitGenSituatieClientUI);
		
		lblCreanteRecuperateSitGenSituatieClientUI = new JLabel("");
		lblCreanteRecuperateSitGenSituatieClientUI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreanteRecuperateSitGenSituatieClientUI.setBounds(247, 169, 122, 16);
		situatieClientUI.add(lblCreanteRecuperateSitGenSituatieClientUI);
		
		lblProcRecuperatSitGenSituatieClientUI = new JLabel("");
		lblProcRecuperatSitGenSituatieClientUI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProcRecuperatSitGenSituatieClientUI.setBounds(247, 197, 122, 16);
		situatieClientUI.add(lblProcRecuperatSitGenSituatieClientUI);
		
		lblCreantePreluateThisYearSitClientUI = new JLabel("");
		lblCreantePreluateThisYearSitClientUI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreantePreluateThisYearSitClientUI.setBounds(516, 141, 122, 16);
		situatieClientUI.add(lblCreantePreluateThisYearSitClientUI);
		
		lblCreantePreluateThisMonthSitClientUI = new JLabel("");
		lblCreantePreluateThisMonthSitClientUI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreantePreluateThisMonthSitClientUI.setBounds(732, 141, 122, 16);
		situatieClientUI.add(lblCreantePreluateThisMonthSitClientUI);
		
		lblCreanteRecuperateThisMonthSitClientUI = new JLabel("");
		lblCreanteRecuperateThisMonthSitClientUI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreanteRecuperateThisMonthSitClientUI.setBounds(732, 169, 122, 16);
		situatieClientUI.add(lblCreanteRecuperateThisMonthSitClientUI);
		
		lblCreanteRecuperateThisYearSitClientUI = new JLabel("");
		lblCreanteRecuperateThisYearSitClientUI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreanteRecuperateThisYearSitClientUI.setBounds(516, 169, 122, 16);
		situatieClientUI.add(lblCreanteRecuperateThisYearSitClientUI);
		
		JLabel lblDiferentaDeRecuperat = new JLabel("Diferenta de Recuperat");
		lblDiferentaDeRecuperat.setBounds(21, 225, 154, 16);
		situatieClientUI.add(lblDiferentaDeRecuperat);
		
		lblDifDeRecuperatSituatieClientUI = new JLabel("");
		lblDifDeRecuperatSituatieClientUI.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDifDeRecuperatSituatieClientUI.setBounds(247, 225, 122, 16);
		situatieClientUI.add(lblDifDeRecuperatSituatieClientUI);
		
		comboBoxJahrSituatieClientUI = new JComboBox(Jahre());
		comboBoxJahrSituatieClientUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedJahr = comboBoxJahrSituatieClientUI.getSelectedItem().toString();
				setDataSituatieUI(selectedJahr, "");
			}
		});
		comboBoxJahrSituatieClientUI.setBounds(516, 13, 95, 27);
		situatieClientUI.add(comboBoxJahrSituatieClientUI);
		
		comboBoxMonatSituatieClientUI = new JComboBox(JahresMonats());
		comboBoxMonatSituatieClientUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedMonat = comboBoxMonatSituatieClientUI.getSelectedItem().toString();
				setDataSituatieUI("", selectedMonat);
			}
		});
		comboBoxMonatSituatieClientUI.setBounds(749, 13, 95, 27);
		situatieClientUI.add(comboBoxMonatSituatieClientUI);
	}
	
	//Hilfsmethoden
		//get selected Customer
		/**
		 * get selected customer
		 * @return selected customer - object typ - Kundedomain
		 */
		private Kundedomain getSelectedCustomer(){
			Object selectedItem = listKundenInDB.getSelectedValue();
			selectedKunde = (Kundedomain) selectedItem;		
			return selectedKunde;
		}
		
		private Debitorendomain getSelectedDebtor(){
			Object selectedItem = listDebitorenInDbDebMainUI.getSelectedValue();
			selectedDebtor = (Debitorendomain) selectedItem;
			return selectedDebtor;
		}
		
		/**
		 * get selected billing
		 */
		private Billingdomain getSelectedBilling(){
			Object selectedItem = listResultsInDbBillingMainUI.getSelectedValue();
			selectedBilling = (Billingdomain) selectedItem;
			return selectedBilling;
		}
		
		/**
		 * clear all fields from customer UI
		 */
		private void clearCustomerUI(){
			txtFldDenumireClientKundeUI.setText(null);
			txtFldNrCtrKundeUI.setText(null);
			txtFldActeAditionaleKundeUI.setText(null);
			comboBoxValabilitateCtrKundeUI.setSelectedItem(null);
			txtFldCUIKundeKundeUI.setText(null);
			txtFldNrONRCClientKundeUI.setText(null);
			textAreaContactClientKundeUI.setText(null);
			txtFldStradaKundeKundeUI.setText(null);
			txtFldNummerStrKundeUI.setText(null);
			txtFldPLZKundeKundeUI.setText(null);
			txtFldLocalitateKundeKundeUI.setText(null);
			txtFldTaraKundeKundeUI.setText("Romania");
//			tableProcenteKundeProcenteUI.
		}
		
		/**
		 * clear all fields from debtor UI
		 */
		private void clearDebitorUI(){
			txtFldDenumireDebitorDebitorUI.setText(null);
			txtFldCUIDebitorDebitorUI.setText(null);
			textAreaContactDebitorUI.setText(null);
			comboBoxStatusDebitorDebitorUI.setSelectedItem("Activ");
			comboBoxStatusDosarDebitorUI.setSelectedItem("Amiabil");
			txtFldActiuneDebitorUI.setText(null);
			textAreaActiuniDebitorUI.setText(null);
			txtFldLocalitateDebitorUI.setText(null);
			txtFldCodPostalDebitorUI.setText(null);
			txtFldNumarStrDebitorUI.setText(null);
			txtFldStradaDebitorUI.setText(null);
			txtFldTaraDebitorUI.setText("Romania");
		}
		
		private void clearBillingUI(){
			txtFldNrFacturaBillingUI.setText(null);
			txtFldSumaFacturaBillingUI.setText(null);
			comboBoxJahrBillingUI.setSelectedItem("An");
			comboBoxJahresMonatBillingUI.setSelectedItem("Luna");
			comboBoxTagFacturaBillingUI.setSelectedItem("Zi");
			comboBoxJahrScadentaBillingUI.setSelectedItem("An");
			comboBoxMonatScadentaBillingUI.setSelectedItem("Luna");
			comboBoxTagScadentaBillingUI.setSelectedItem("Zi");
			comboBoxTagPreluareCreantaBillingUI.setSelectedItem("Zi");
			comboBoxMonatPreluareCreantaBillingUI.setSelectedItem("Luna");
			comboBoxJahrPreluareCreantaBillingUI.setSelectedItem("An");
		}
		
		private String[] MonatsTagen(){
			String[] tagen = new String[32];
			tagen[0] = "Zi";
			for(int zl = 1; zl <= 31; zl++){
				if (zl <= 9){
					tagen[zl] = "0" + zl;
				}else{
					tagen[zl] = "" + zl;
				}
			}	
			return tagen;
		}
		
		private String[] JahresMonats(){
			String[] monats = new String[13];
			monats[0] = "Luna";
			for(int zl = 1; zl <= 9; zl++){
				monats[zl] = "0" + zl;
			}
			monats[10] = "10";
			monats[11] = "11";
			monats[12] = "12";
			return monats;
		}
		
		private String[] Jahre(){
			String[] jahre = new String[21];
			jahre[0] = "An";
			DateFormat dateFormat = new SimpleDateFormat("yyyy");
			Calendar cal = Calendar.getInstance();
			int jahr = Integer.parseInt(dateFormat.format(cal.getTime()));
			for(int zl = 1; zl <= 20; zl++){
				int an = jahr-(zl-1);
				jahre[zl] = ""+an;
			}
			return jahre;
		}
		
		
		/**
		 * enable or disable actiune in create debtor
		 * @param status - boolean
		 */
		private void setActiuneEnabled(Boolean status){
			chckbxActiuneDebitorActiv.setEnabled(status);
			lblDescriptionActiuneDebitorUI.setEnabled(status);
			txtFldActiuneDebitorUI.setEnabled(status);
			textAreaActiuniDebitorUI.setEnabled(status);
		}
		
		/**
		 * set message bar
		 */
		private void setMessageBar(String message,String state, String MsgBar){
			Color error = new Color(224,33,39);
			Color none = new Color(0,0,0);
			Color color = new Color(237,237,237);
			
			if(state == "Error"){
				color = error;
				(new Thread(new ParallelThread())).start();
			}else if(state == "None"){
				color = none;
				(new Thread(new ParallelThread())).start();
			}
			
			if(MsgBar.equals("MainUI")){
				lblMessageBarMainUI.setText(message);
				lblMessageBarMainUI.setForeground(color);
			}else if(MsgBar.equals("DebUI")){
				lblMessageBarDebMainUI.setText(message);
				lblMessageBarDebMainUI.setForeground(color);
			}else if(MsgBar.equals("DebVerUI")){
				lblMsgBarDebitorenverwaltungUI.setText(message);
				lblMsgBarDebitorenverwaltungUI.setForeground(color);
			}else if(MsgBar.equals("PayBillingUI")){
				lblMsgBarPayBillingUI.setText(message);
				lblMsgBarPayBillingUI.setForeground(color);
			}
		}
		
		/**
		 * clear message bar
		 */
		public static void clearMessageBar(){
			lblMessageBarMainUI.setText(null);
			lblMessageBarDebMainUI.setText(null);
			lblMsgBarDebitorenverwaltungUI.setText(null);
			lblMsgBarPayBillingUI.setText(null);
		}
		
		/**
		 * get new table model
		 *
		 */
		public DefaultTableModel getNewTableModel(){

			dataProzente = new String[3][7];
			for(int row = 0; row < 3; row ++){
				dataProzente[row] = new String[7];
				dataProzente[row][0] = "intervale zile";
				dataProzente[row][1] = "0"; 
				dataProzente[row][2] = "0";
				dataProzente[row][3] = "0";
				dataProzente[row][4] = "0";
				dataProzente[row][5] = "0";
				dataProzente[row][6] = "0";
			}
			DefaultTableModel model = new DefaultTableModel(dataProzente, spaltenProzente);
			return model;
		}
		
		/**
		 * prepare tableModel
		 */
		public void prepareTableModelProzenteUI(){
			TableColumnModel columnModel = tableProcenteKundeProcenteUI.getColumnModel();
		    tableProcenteKundeProcenteUI.setTableHeader(new EditableHeader(columnModel));
		    tableProcenteKundeProcenteUI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		    tableProcenteKundeProcenteUI.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					btnDeleteLineProcenteUI.setEnabled(true);
				}
			});
		}
		
		/**
		 * get column for search debtor
		 */
		public String getColumnForSearchDebtor(int selectedIndex){
			String column = "";
			if(selectedIndex == 0){
				column = "DenumireDebitor";
			}else if (selectedIndex == 1){
				column = "Cui";
			}else if(selectedIndex == 2 || selectedIndex == 3){
				column = "StatusDebitor";
			}else if (selectedIndex == 4 || selectedIndex == 5 || selectedIndex == 6){
				column = "StatusDosar";
			}
			return column;
		}
		
		/**
		 * get serach field for search debtor
		 */
		public String getSerachFieldValueForSearchDebtor(int selectedIndex){
			String searchFieldValue = "";
			switch(selectedIndex){
				case 0 : 
					searchFieldValue = txtFldCautaDebitorDebMainUI.getText();
					break;
				case 1 : 
					searchFieldValue = txtFldCautaDebitorDebMainUI.getText();
					break;
				case 2 : 
					searchFieldValue = "Activ";
					break;
				case 3 : 
					searchFieldValue = "Inactiv";
					break;
				case 4 : 
					searchFieldValue = "Amiabil";
					break;
				case 5 : 
					searchFieldValue = "In instanza";
					break;
				case 6 : 
					searchFieldValue = "In executare";
					break;
			}
			return searchFieldValue;
		}
		
		/**
		 * set data for Situatie UI 
		 */
		public void setDataSituatieUI(String jahr, String monat){
			
//			//get current date
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//			Calendar cal = Calendar.getInstance();
//			String currentDateAsString = dateFormat.format(cal.getTime());
			
			//get all billings for this customer
			// and also get all payed billing for this customer
			DBverbindung.dbconnect();
			ArrayList<Billingdomain> allBillingsForThisCustomer = bs.getAllBillingsForOneCustomer(getSelectedCustomer().getId());
			ArrayList<Billingdomain> allPayedBillingsForThisCustomer = bs.getAllPayedBillingsForOneCustomer(getSelectedCustomer().getId());
			DBverbindung.dbdisconect();
			
			Double creantePreluateTotal= 0.0;
			Double creantePreluateThisYear = 0.0;
			Double creantePreluateThisMonth = 0.0;
			for(Billingdomain billing : allBillingsForThisCustomer){
				creantePreluateTotal += billing.getSumaFactura();
				//calculate creante preluate this year
				if(billing.getDataPreluareCreanta().toString().substring(0, 4).equals(jahr)){
					creantePreluateThisYear += billing.getSumaFactura();
				}
				//calculate creante preluate this month
				if(billing.getDataPreluareCreanta().toString().substring(5, 7).equals(monat)){
					creantePreluateThisMonth += billing.getSumaFactura();
				}
			}
			lblCreantePreluateSitGenSituatieClientUI.setText(creantePreluateTotal.toString());
			lblCreantePreluateThisYearSitClientUI.setText(creantePreluateThisYear.toString());
			lblCreantePreluateThisMonthSitClientUI.setText(creantePreluateThisMonth.toString());
			
			Double creanteRecuperateTotal = 0.0;
			Double creanteRecuperateThisYear = 0.0;
			Double creanteRecuperateThisMonth = 0.0;
			for(Billingdomain billing : allPayedBillingsForThisCustomer){
				//restPlata is here suma platita
				creanteRecuperateTotal += billing.getRestPlata();
				//calculate creante incasate this year
				//datePreluareCreanta is here data incasare
				if(billing.getDataPreluareCreanta().toString().substring(0, 4).equals(jahr)){
					creanteRecuperateThisYear += billing.getRestPlata();
				}
				//calculate creante incasate this month
				//datePreluareCreanta is here data incasare
				if(billing.getDataPreluareCreanta().toString().substring(5, 7).equals(monat)){
					creanteRecuperateThisMonth += billing.getRestPlata();
				}
			}
			lblCreanteRecuperateSitGenSituatieClientUI.setText(creanteRecuperateTotal.toString());
			lblCreanteRecuperateThisYearSitClientUI.setText(creanteRecuperateThisYear.toString());
			lblCreanteRecuperateThisMonthSitClientUI.setText(creanteRecuperateThisMonth.toString());
			
			//calculate % recuperat
			Double procRecuperat = (creanteRecuperateTotal * 100)/creantePreluateTotal;
			lblProcRecuperatSitGenSituatieClientUI.setText(new DecimalFormat("#.##").format(procRecuperat) + " %");
			
			Double difDeRecuperat = creantePreluateTotal- creanteRecuperateTotal;
			lblDifDeRecuperatSituatieClientUI.setText(difDeRecuperat.toString());
		}
		
		/**
		 * keine Ahnung was das ist
		 * @param component
		 * @param popup
		 */
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



