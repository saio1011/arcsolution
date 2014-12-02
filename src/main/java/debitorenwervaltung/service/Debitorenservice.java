package debitorenwervaltung.service;

import java.sql.*;
import java.util.ArrayList;

import util.*;
import debitorenwervaltung.domain.*;

public class Debitorenservice {
	
	Debitorendomain tmpDebitoren;
	Debitorendomain tmpDebitorenMock;
	
//	@SuppressWarnings("deprecation")
//	public ArrayList<Debitorendomain> getAllDebitorenByKundenId(int kundeID){
//		ArrayList<Debitorendomain> debitori = new ArrayList<Debitorendomain>();
//		ArrayList<Debitorendomain> debitoriMock = new ArrayList<Debitorendomain>();
//		/*
//		try{
//			Statement st = DBverbindung.getConn().createStatement();
//			ResultSet res = st.executeQuery("SELECT * FROM debitor where ID_Kunde = " + kundeID); 
//			while (res.next()) {
//				int idDeb = res.getInt("ID_Deb"); 
//				String nname = res.getString("Name");
//				double valCreanta = res.getDouble("ValoareCranta");
//				Date datNotif = res.getDate("DataNotificare");
//				Date datConfPrimire = res.getDate("DataConfPrimire");
//				Date datNotUltimo = res.getDate("DataNotifUltimativa");
//				Date datNotUltimoPrimire = res.getDate("DataNotifConfPrimire");
//				int idKunde = res.getInt("ID_Kunde");
//				*/
//				
//				//MockDaten simuliren
//				tmpDebitorenMock = new Debitorendomain(1, "Debitor1", 22.01, new Date(2001, 03, 21), new Date(2001, 03, 21), new Date(2001, 03, 21), new Date(2001, 03, 21), 5);
//				
//				
////				Debitorendomain tmp = new Debitorendomain(idDeb, nname, valCreanta, datNotif, datConfPrimire, datNotUltimo, datNotUltimoPrimire, idKunde);
//				//tmpDebitoren = new Debitorendomain(idDeb, nname, valCreanta, datNotif, datConfPrimire, datNotUltimo, datNotUltimoPrimire, idKunde);
//				
//				
//				debitori.add(tmpDebitoren);
//				debitoriMock.add(tmpDebitorenMock);
////			}
////		}catch (Exception ex){
////			System.out.println(ex.getMessage());
////		}
//		
////		DBverbindung.dbdisconect();
//		return debitoriMock;
//	}
	
//	public void getAllActiunibyDebitor(int idDebit){
//		try{
//			Statement st = DBverbindung.getConn().createStatement();
//			ResultSet res = st.executeQuery("SELECT * FROM actiuni where ID_Deb = " + idDebit); 
//			while (res.next()) {
//				int IDActiuni = res.getInt("ID_Actiuni"); 
//				String Beschreibung = res.getString("Beschreibung");
//				Date DataBeschreibung = res.getDate("Datum");
//				int ID_Deb = res.getInt("ID_Deb"); 
//				
//				Actiuni tmp = new Actiuni(IDActiuni, Beschreibung, DataBeschreibung, ID_Deb);
//				
//				tmpDebitoren.setListActiuni(tmp);
//				
//			}
//		}catch (Exception ex){
//			System.out.println(ex.getMessage());
//		}
//	}
	
	/**
	 * create debitor
	 * @param debitor
	 * @param kundeId
	 * @return
	 */
	//TODO extend signatur with actiuni flag
	public int createDebitor(Debitorendomain debitor, int kundeId){
		Statement st = null;
		int resInsertDebitor = -1;
		
		try{
			st = DBverbindung.getConn().createStatement();
			resInsertDebitor = st.executeUpdate("INSERT INTO debitor (`DenumireDebitor`, `Cui`, `ContactDebitor`, `StatusDebitor`, `StatusDosar`) VALUES "
								+ "('"+debitor.getDenumireDebitor()+"', '"+ debitor.getCui() + "', '"+ debitor.getContactDebitor()
								+ "', '" + debitor.getStatusDebitor() + "', '" + debitor.getStatusDosar() + "')");
			
			if(resInsertDebitor == 1){
				
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			System.out.println(st.toString());
		}
		
		return 1;
	}

}
