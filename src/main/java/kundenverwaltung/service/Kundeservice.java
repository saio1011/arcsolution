package kundenverwaltung.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import com.mysql.jdbc.Connection;

import kundenverwaltung.domain.*;
import util.*;

public class Kundeservice {
	
	public ArrayList<Kundedomain> getAllKunden(){
		ArrayList<Kundedomain> kunden = new ArrayList<Kundedomain>();
//		DBverbindung.dbconnect();
		try{
			Statement st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM kunde"); 
			while (res.next()) {
				int iD = res.getInt("ID"); 
				String name = res.getString("Name");
				String valabilitateCtr = res.getString("Valabilitatectr");
				String kontraktNr = res.getString("Kontraktnr");
				String actaditional = res.getString("Actaditional");
				
				Kundedomain tmp = new Kundedomain(iD, name, kontraktNr, actaditional, valabilitateCtr);
				
				kunden.add(tmp);
			}
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
//		DBverbindung.dbdisconect();
		return kunden;
	}
	
	public ArrayList<Kundedomain> findKundenByName(String name){
		ArrayList<Kundedomain> kunden = new ArrayList<Kundedomain>();
//		DBverbindung.dbconnect();
		try{
			Statement st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM kunde where name like\""+ name + "%\""); 
			while (res.next()) {
				int iD = res.getInt("ID"); 
				String nname = res.getString("Name");
				String valabilitateCtr = res.getString("Valabilitatectr");
				String kontraktNr = res.getString("Kontraktnr");
				String actaditional = res.getString("Actaditional");
				
				Kundedomain tmp = new Kundedomain(iD, nname, kontraktNr, actaditional, valabilitateCtr);
				
				kunden.add(tmp);
			}
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
//		DBverbindung.dbdisconect();
		return kunden;
	}
	
}
