package util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import util.*;
import kundenverwaltung.*;
import kundenverwaltung.domain.Kundedomain;
import kundenverwaltung.service.Kundeservice;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Kundeservice ks = new Kundeservice();
		
		DBverbindung.dbconnect();
		ArrayList<Kundedomain> allKunden = ks.findKundenByName(" ");
		ArrayList<Kundedomain> allKunden1 = ks.getAllKunden();
		DBverbindung.dbdisconect();
		
		for (int i = 0 ; i < allKunden.size(); i++ ) {
			System.out.println(allKunden.get(i).toString());
		}
		for (int i = 0 ; i < allKunden1.size(); i++ ) {
			System.out.println(allKunden1.get(i).toString());
		}

	}

}
