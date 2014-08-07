package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import debitorenwervaltung.domain.Debitorendomain;
import debitorenwervaltung.service.Debitorenservice;
import util.*;
import kundenverwaltung.*;
import kundenverwaltung.domain.Kundedomain;
import kundenverwaltung.service.Kundeservice;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Kundeservice ks = new Kundeservice();
		Debitorenservice deb = new Debitorenservice();
		
		DBverbindung.dbconnect();
//		ArrayList<Kundedomain> allKunden = ks.findKundenByName("t");
		ArrayList<Kundedomain> allKunden1 = ks.getAllKunden();
		ArrayList<Debitorendomain> allDebitoren = deb.getAllDebitorenByKundenId(1);
		
		
		Kundedomain kundeNou = new Kundedomain("test6", "ctr6", "actaditional6", "determinat");
		Kundedomain tmp = ks.createKunde(kundeNou);
		
		DBverbindung.dbdisconect();
		
//		for (int i = 0 ; i < allKunden.size(); i++ ) {
//			System.out.println(allKunden.get(i).toString());
//		}
		for (int i = 0 ; i < allDebitoren.size(); i++ ) {
			System.out.println(allDebitoren.get(i).toString());
//			allDebitoren.get(i).getIDDeb()
		}
		
//		System.out.println("create Kunde "+ tmp.toString());

	}

}
