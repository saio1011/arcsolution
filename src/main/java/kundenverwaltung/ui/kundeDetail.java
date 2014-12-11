//package kundenverwaltung.ui;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JSeparator;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//
//import kundenverwaltung.domain.Kundedomain;
//import util.Adresa;
//import util.DBverbindung;
//
//public class kundeDetail {
//
//	kundeUI = new JPanel();
//	frmArcSolutions.getContentPane().add(kundeUI, "name_27327655750175");
//	kundeUI.setLayout(null);
//	
//	lblTitleKundeUI = new JLabel("Introduce Client Nou");
//	lblTitleKundeUI.setBounds(21, 30, 152, 14);
//	kundeUI.add(lblTitleKundeUI);
//	
//	lblDenumireClientKundeUI = new JLabel("*Denumire Client");
//	lblDenumireClientKundeUI.setBounds(51, 178, 137, 20);
//	kundeUI.add(lblDenumireClientKundeUI);
//	
//	txtFldDenumireClientKundeUI = new JTextField();
//	txtFldDenumireClientKundeUI.setColumns(10);
//	txtFldDenumireClientKundeUI.setBounds(183, 178, 314, 20);
//	kundeUI.add(txtFldDenumireClientKundeUI);
//	
//	lblNrCtrKundeUI = new JLabel("*Nr. Contract");
//	lblNrCtrKundeUI.setBounds(51, 78, 137, 17);
//	kundeUI.add(lblNrCtrKundeUI);
//	
//	txtFldNrCtrKundeUI = new JTextField();
//	txtFldNrCtrKundeUI.setColumns(10);
//	txtFldNrCtrKundeUI.setBounds(183, 76, 314, 20);
//	kundeUI.add(txtFldNrCtrKundeUI);
//	
//	lblActeAditionaleKundeUI = new JLabel("Acte Aditionale");
//	lblActeAditionaleKundeUI.setBounds(51, 107, 115, 17);
//	kundeUI.add(lblActeAditionaleKundeUI);
//	
//	txtFldActeAditionaleKundeUI = new JTextField();
//	txtFldActeAditionaleKundeUI.setColumns(10);
//	txtFldActeAditionaleKundeUI.setBounds(183, 107, 314, 20);
//	kundeUI.add(txtFldActeAditionaleKundeUI);
//	
//	lblValabilitateCtrKundeUI = new JLabel("Valabilitate Contract");
//	lblValabilitateCtrKundeUI.setBounds(571, 78, 137, 17);
//	kundeUI.add(lblValabilitateCtrKundeUI);
//	 
//	//save Customer
//	btnSalveazaClientKundeUI = new JButton("Salveaza Client");
//	btnSalveazaClientKundeUI.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			mainUI.setVisible(true);
//			kundeUI.setVisible(false);
//			frmArcSolutions.setTitle("ARC Solutions");
//			boolean updateFlag = false;
//			
//			//save or edit/update a customer
//			if(!(txtFldDenumireClientKundeUI.getText().isEmpty() || txtFldNrCtrKundeUI.getText().isEmpty())){
//				System.out.println(txtFldDenumireClientKundeUI.getText());
//				Adresa adresa = new Adresa(txtFldStradaKundeKundeUI.getText(), txtFldNummerStrKundeUI.getText(),
//						txtFldPLZKundeKundeUI.getText(),txtFldLocalitateKundeKundeUI.getText(),txtFldTaraKundeKundeUI.getText());
//				Kundedomain kundeNou = new Kundedomain(txtFldDenumireClientKundeUI.getText(), txtFldNrCtrKundeUI.getText(), 
//						txtFldActeAditionaleKundeUI.getText(), comboBoxValabilitateCtrKundeUI.getSelectedItem().toString(),
//						textAreaContactClientKundeUI.getText(), txtFldCUIKundeKundeUI.getText(), txtFldNrONRCClientKundeUI.getText(), adresa);
//				
//				DBverbindung.dbconnect();
//				if(angeklickteButton.equals("btnCreazaClient")){
//					//create kunde
//					int result = ks.createKunde(kundeNou);
//
//					//TODO show Success Messages - move messages into message file
//					if(result == 1){
//						setMessageBar("Clientul a fost creat", None, MsgBarMainUI);
//						updateFlag = true;
//					}else{
//						setMessageBar("Clientul nu a putut fi creat", Error, MsgBarMainUI);
//					}
//					
////					System.out.println("Button create pressed");
//				}else if(angeklickteButton.equals("btnEditeazaClient")){
//					//update kunde
//					//TODO - updateKunde only when the customer is modified - performance issue??
//					int result = ks.updateKunde(selectedKunde.getId(), kundeNou);
//
//					//TODO show Success Messages - move messages into message file
//					if(result == 1){
//						setMessageBar("Clientul a fost actualizat", None, MsgBarMainUI);
//						updateFlag = true;
//					}else{
//						setMessageBar("Clientul nu a putut fi actualizat", Error, MsgBarMainUI);
//					}
//						
////					System.out.println("Button edit pressed");
////					System.out.println(selectedKunde.getId());		
//				}
//				//refresh list after update or create new customer
//				//only if update/create was successfully processed 
//				if(updateFlag){
//					ArrayList<Kundedomain> allKunden = ks.getAllKunden();
//					listKundenInDB.setListData(allKunden.toArray());
//				}
//				DBverbindung.dbdisconect();
//			}
//			
//			//clear all fields after save
//			//clear only if save was successfully
//			if(updateFlag)
//				clearCustomerUI();
//		}
//	});
//	btnSalveazaClientKundeUI.setBounds(541, 532, 151, 23);
//	kundeUI.add(btnSalveazaClientKundeUI);
//	
//	//Cancel
//	btnCancelKundeUI = new JButton("Cancel");
//	btnCancelKundeUI.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			mainUI.setVisible(true);
//			kundeUI.setVisible(false);
//			frmArcSolutions.setTitle("ARC Solutions");
//			
//			//clear all fields by cancel
//			clearCustomerUI();
//		}
//	});
//	btnCancelKundeUI.setBounds(719, 532, 151, 23);
//	kundeUI.add(btnCancelKundeUI);
//	
//	sep1KundeUI = new JSeparator();
//	sep1KundeUI.setBounds(21, 57, 855, 12);
//	kundeUI.add(sep1KundeUI);
//	
//	lblContactClientKundeUI = new JLabel("Contact Client");
//	lblContactClientKundeUI.setBounds(51, 210, 129, 16);
//	kundeUI.add(lblContactClientKundeUI);
//	
//	lblAdresaKundeKundeUI = new JLabel("Adresa");
//	lblAdresaKundeKundeUI.setBounds(51, 330, 88, 16);
//	kundeUI.add(lblAdresaKundeKundeUI);
//	
//	lblStradaKundeKundeUI = new JLabel("Strada");
//	lblStradaKundeKundeUI.setBounds(81, 358, 85, 16);
//	kundeUI.add(lblStradaKundeKundeUI);
//	
//	lblNummerStrKundeUI = new JLabel("Numar");
//	lblNummerStrKundeUI.setBounds(81, 386, 61, 16);
//	kundeUI.add(lblNummerStrKundeUI);
//	
//	lblLocalitateKundeKundeUI = new JLabel("Localitate");
//	lblLocalitateKundeKundeUI.setBounds(81, 414, 72, 16);
//	kundeUI.add(lblLocalitateKundeKundeUI);
//	
//	lblPLZKundeKundeUI = new JLabel("Cod Postal");
//	lblPLZKundeKundeUI.setBounds(81, 442, 85, 16);
//	kundeUI.add(lblPLZKundeKundeUI);
//	
//	lblTaraKundeKundeUI = new JLabel("Tara");
//	lblTaraKundeKundeUI.setBounds(81, 470, 61, 16);
//	kundeUI.add(lblTaraKundeKundeUI);
//	
//	txtFldStradaKundeKundeUI = new JTextField();
//	txtFldStradaKundeKundeUI.setColumns(10);
//	txtFldStradaKundeKundeUI.setBounds(183, 356, 314, 20);
//	kundeUI.add(txtFldStradaKundeKundeUI);
//	
//	txtFldNummerStrKundeUI = new JTextField();
//	txtFldNummerStrKundeUI.setColumns(10);
//	txtFldNummerStrKundeUI.setBounds(183, 384, 314, 20);
//	kundeUI.add(txtFldNummerStrKundeUI);
//	
//	txtFldLocalitateKundeKundeUI = new JTextField();
//	txtFldLocalitateKundeKundeUI.setColumns(10);
//	txtFldLocalitateKundeKundeUI.setBounds(183, 412, 314, 20);
//	kundeUI.add(txtFldLocalitateKundeKundeUI);
//	
//	txtFldPLZKundeKundeUI = new JTextField();
//	txtFldPLZKundeKundeUI.setColumns(10);
//	txtFldPLZKundeKundeUI.setBounds(183, 440, 314, 20);
//	kundeUI.add(txtFldPLZKundeKundeUI);
//	
//	txtFldTaraKundeKundeUI = new JTextField();
//	txtFldTaraKundeKundeUI.setText("Romania");
//	txtFldTaraKundeKundeUI.setColumns(10);
//	txtFldTaraKundeKundeUI.setBounds(183, 468, 314, 20);
//	kundeUI.add(txtFldTaraKundeKundeUI);
//	
//	String[] valabilitateCtr= {"Nedeterminat","Determinat"};
//	comboBoxValabilitateCtrKundeUI = new JComboBox(valabilitateCtr);
//	comboBoxValabilitateCtrKundeUI.setBounds(720, 74, 156, 27);
//	kundeUI.add(comboBoxValabilitateCtrKundeUI);
//	
//	scrollPaneContactClientKundeUI = new JScrollPane();
//	scrollPaneContactClientKundeUI.setBounds(184, 210, 313, 112);
//	kundeUI.add(scrollPaneContactClientKundeUI);
//	
//	textAreaContactClientKundeUI = new JTextArea();
//	scrollPaneContactClientKundeUI.setViewportView(textAreaContactClientKundeUI);
//	
//	sep2KundeUI = new JSeparator();
//	sep2KundeUI.setBounds(21, 136, 855, 12);
//	kundeUI.add(sep2KundeUI);
//	
//	lblCUIKundeKundeUI = new JLabel("CUI");
//	lblCUIKundeKundeUI.setBounds(571, 180, 45, 16);
//	kundeUI.add(lblCUIKundeKundeUI);
//	
//	txtFldCUIKundeKundeUI = new JTextField();
//	txtFldCUIKundeKundeUI.setBounds(670, 178, 200, 20);
//	kundeUI.add(txtFldCUIKundeKundeUI);
//	txtFldCUIKundeKundeUI.setColumns(10);
//	
//	lblNrOrcKundeKundeUI = new JLabel("NR. ORNC");
//	lblNrOrcKundeKundeUI.setBounds(571, 210, 87, 16);
//	kundeUI.add(lblNrOrcKundeKundeUI);
//	
//	txtFldNrONRCClientKundeUI = new JTextField();
//	txtFldNrONRCClientKundeUI.setBounds(670, 210, 200, 20);
//	kundeUI.add(txtFldNrONRCClientKundeUI);
//	txtFldNrONRCClientKundeUI.setColumns(10);
//}
