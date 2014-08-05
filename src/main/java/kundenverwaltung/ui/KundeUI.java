package kundenverwaltung.ui;
import util.MainUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import kundenverwaltung.test.*;

import javax.swing.SpringLayout;

import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.miginfocom.swing.MigLayout;

public class KundeUI extends JPanel {

	private JFrame frame;
	private JTextField textField;
	private JTextField kundeUIDenumireClientTxtFld;
	private JTextField kundeUINrCtrTxtFld;
	private JTextField kundeUIActeAditionaleTxtFld;
	private JTextField kundeUIValabilitateCtrTxtFld;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KundeUI window = new KundeUI();
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
	public KundeUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 601, 439);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JLabel kundeUIIntroduceClientLbl = new JLabel("Introduce Client Nou");
		
		JLabel kundeUIDenumireClientLbl = new JLabel("Denumire Client");
		
		JLabel kundeUINrContractLbl = new JLabel("Nr. Contract");
		
		JLabel kundeUIActeAditionaleLbl = new JLabel("Acte Aditionale");
		
		JLabel kundeUIValabilitateCtrLbl = new JLabel("Valabilitate Contract");
		frame.getContentPane().setLayout(new MigLayout("", "[99px][97px][49.00][168.00,grow]", "[14px][68.00][][14.00px][14px][14px][14px][][]"));
		frame.getContentPane().add(kundeUIIntroduceClientLbl, "cell 0 0,alignx left,aligny top");
		frame.getContentPane().add(kundeUIDenumireClientLbl, "cell 1 3,alignx left,aligny top");
		
		kundeUIDenumireClientTxtFld = new JTextField();
		frame.getContentPane().add(kundeUIDenumireClientTxtFld, "cell 3 3,growx");
		kundeUIDenumireClientTxtFld.setColumns(10);
		frame.getContentPane().add(kundeUINrContractLbl, "cell 1 4,alignx left,aligny top");
		
		kundeUINrCtrTxtFld = new JTextField();
		frame.getContentPane().add(kundeUINrCtrTxtFld, "cell 3 4,growx");
		kundeUINrCtrTxtFld.setColumns(10);
		frame.getContentPane().add(kundeUIActeAditionaleLbl, "cell 1 5,alignx left,aligny top");
		
		kundeUIActeAditionaleTxtFld = new JTextField();
		frame.getContentPane().add(kundeUIActeAditionaleTxtFld, "cell 3 5,growx");
		kundeUIActeAditionaleTxtFld.setColumns(10);
		frame.getContentPane().add(kundeUIValabilitateCtrLbl, "cell 1 6,alignx left,aligny top");
		
		kundeUIValabilitateCtrTxtFld = new JTextField();
		kundeUIValabilitateCtrTxtFld.setText("");
		frame.getContentPane().add(kundeUIValabilitateCtrTxtFld, "cell 3 6,growx");
		kundeUIValabilitateCtrTxtFld.setColumns(10);
		
		JButton kundeUISaveKundeBtn = new JButton("Salveaza Client");
		kundeUISaveKundeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		frame.getContentPane().add(kundeUISaveKundeBtn, "cell 3 8");

	}
}
