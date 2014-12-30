package debitorenwervaltung.service;

import java.sql.*;
import java.util.ArrayList;

import util.*;
import debitorenwervaltung.domain.*;

public class Debitorenservice {
	
//	Debitorendomain tmpDebitoren;
//	Debitorendomain tmpDebitorenMock;
	
//	@SuppressWarnings("deprecation")
	/**
	 * get all debtors 
	 * @param kundeID
	 * @return array with all debtors by idKunde
	 */
	public ArrayList<Debitorendomain> getAllDebitorenByKundenId(int kundeID){
		Statement st = null;
		Statement stAdrDeb = null;
		Statement stActiuneDeb = null;
		ArrayList<Debitorendomain> debitori = new ArrayList<Debitorendomain>();
//		ArrayList<Debitorendomain> debitoriMock = new ArrayList<Debitorendomain>();
		
		try{
		    st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM debitor where IdKunde = " + kundeID); 
			while (res.next()) {
				int idDeb = res.getInt("IdDeb"); 
				String denumireDebitor = res.getString("DenumireDebitor");
				String cui = res.getString("Cui");
				String contactDebitor = res.getString("ContactDebitor");
				String statusDebitor = res.getString("StatusDebitor");
				String statusDosar = res.getString("StatusDosar");
				int idKunde = res.getInt("IdKunde");
				
				Adresa adresa = new Adresa();
				stAdrDeb = DBverbindung.getConn().createStatement();
				ResultSet resAdresa = stAdrDeb.executeQuery("SELECT * FROM adresaDebitor where ID_Debitor = \"" + idDeb + "\"");
				while(resAdresa.next()){
					adresa = new Adresa(resAdresa.getString("Strada"), resAdresa.getString("Nummer"), resAdresa.getString("CodPostal"), 
							resAdresa.getString("Oras"), resAdresa.getString("Country"));
				}
				stAdrDeb.close();
				
				ArrayList<Actiune> actiuni = new ArrayList<Actiune>();
				Actiune actiune = new Actiune();
				stActiuneDeb = DBverbindung.getConn().createStatement();
				ResultSet resActiune = stActiuneDeb.executeQuery("SELECT * FROM actiuni where ID_Deb = \"" + idDeb + "\"");
				while(resActiune.next()){
					actiune = new Actiune(resActiune.getString("KurzBeschreibung"), resActiune.getString("Beschreibung"));
					actiuni.add(actiune);
				}
				stActiuneDeb.close();
				
				Debitorendomain tmp = new Debitorendomain(idDeb, denumireDebitor, cui, contactDebitor, statusDebitor, statusDosar, adresa, actiuni);
				debitori.add(tmp);
			}
			st.close();
		}catch (Exception ex){
			try {
				st.close();
				stAdrDeb.close();
				stActiuneDeb.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println(ex.getMessage());
		}
		
//		DBverbindung.dbdisconect();
		return debitori;
	}
	
	/**
	 * create debitor
	 * @param debitor
	 * @param kundeId
	 * @return
	 */
	public int createDebitor(Debitorendomain debitor, int kundeId, String chckBoxActiuneDebitorStatus){
		java.sql.Connection connection = null;
		Statement st = null;
		int resInsertDebitor = -1;
		int resAdresaDebitor = -1;
		int resActiuneDebitor = -1;
		try{
			connection = DBverbindung.getConn();
			connection.setAutoCommit(false);
			st = connection.createStatement(Statement.CLOSE_ALL_RESULTS, Statement.RETURN_GENERATED_KEYS);
			resInsertDebitor = st.executeUpdate("INSERT INTO debitor (`DenumireDebitor`, `Cui`, `ContactDebitor`, `StatusDebitor`, `StatusDosar`, `IdKunde`) VALUES "
								+ "('"+debitor.getDenumireDebitor()+"', '"+ debitor.getCui() + "', '"+ debitor.getContactDebitor()
								+ "', '" + debitor.getStatusDebitor() + "', '" + debitor.getStatusDosar() +"', '" + kundeId +"')" ,Statement.RETURN_GENERATED_KEYS);
			
			int counter = 0;
			int idDebitor = -1;
			ResultSet generatedKeys = st.getGeneratedKeys();
	        if(generatedKeys.next()){
	        	idDebitor = generatedKeys.getInt(1);
	        	counter++;
	            System.out.println("ID Debitor nou: " + idDebitor);    
	        }
	        
			if(resInsertDebitor == 1){
				if(counter == 1 && idDebitor != -1){
					resAdresaDebitor = st.executeUpdate("INSERT INTO adresaDebitor (`Strada`, `Nummer`, `CodPostal`, `Oras`, `Country`, `ID_Debitor`) VALUES "
							+ "('" +debitor.getAdresa().getStrada()+"', '"+debitor.getAdresa().getNummer()+"', '"+ debitor.getAdresa().getCodPostal()
							+"', '"+debitor.getAdresa().getOras()+"', '"+debitor.getAdresa().getCountry()+"', '"+idDebitor+"')");
					
					if(chckBoxActiuneDebitorStatus == "Selected" && resAdresaDebitor == 1){
						resActiuneDebitor = st.executeUpdate("INSERT INTO actiuni (`KurzBeschreibung`, `Beschreibung`, `ID_Deb`) VALUES "
								+ "('" + debitor.getActiune().getKurzBeschreibung() + "', '"+ debitor.getActiune().getBeschreibung()
								+"', '" + idDebitor+"')");
					}
				}else{
					throw new Exception("Create debitor failed");
				}
			}else{
				throw new Exception("Create debitor failed");
			}
			connection.commit();
			st.close();
		}catch(Exception ex){
			try{
				connection.rollback();
				st.close();
			}catch (SQLException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ex.getMessage());
			System.out.println(st.toString());
		}
		if(chckBoxActiuneDebitorStatus == "Selected"){
			return resActiuneDebitor;
		}else{
			return resAdresaDebitor;
		}
	}
	
	/**
	 * update debtor
	 */
	public int updateDebitor(int id, Debitorendomain debitor){
		java.sql.Connection connection = null;
		Statement st = null;
		int res = -1;
		int resAdr = -1;
		try{
			connection = DBverbindung.getConn();
			connection.setAutoCommit(false);
			st = connection.createStatement();
			res = st.executeUpdate("UPDATE debitor "
									+ "SET DenumireDebitor = '" + debitor.getDenumireDebitor() + "', "
									+ 	"Cui = '" + debitor.getCui() + "', "
									+	"ContactDebitor = '" + debitor.getContactDebitor() + "', "
									+	"StatusDebitor = '" + debitor.getStatusDebitor() + "', "
									+	"StatusDosar = '" + debitor.getStatusDosar() + "'"
										+ " WHERE IdDeb = " + id );
			if(res == 1){
				resAdr = st.executeUpdate("UPDATE adresaDebitor "
						+ "SET Strada = '" + debitor.getAdresa().getStrada() + "', "
						+ 	"Nummer = '" + debitor.getAdresa().getNummer() + "', "
						+	"CodPostal = '" + debitor.getAdresa().getCodPostal() + "', "
						+	"Oras = '" + debitor.getAdresa().getOras() + "', "
						+	"Country = '" + debitor.getAdresa().getCountry() + "'"
							+ " WHERE ID_Debitor = " + id);	
				if(resAdr != 1){
					throw new Exception("Update debitor failed");
				}
			}else{
				throw new Exception("Update debitor failed");
			}
			connection.commit();
			st.close();
		}catch(Exception ex){
			try {
				connection.rollback();
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ex.getMessage());
		}
		
		return resAdr;
	}
	
	/**
	 * insert new actiune
	 * 
	 * @param actiune
	 * @param idDeb
	 * @return 1 if insert was successfully 
	 */
	public int createActiune(Actiune actiune, int idDeb){
		java.sql.Connection connection = null;
		Statement st = null;
		int resInsertActiune = -1;
		
		try{
			connection = DBverbindung.getConn();
			connection.setAutoCommit(false);
			st = connection.createStatement();
			resInsertActiune = st.executeUpdate("INSERT INTO actiuni (`KurzBeschreibung`, `Beschreibung`, `ID_Deb`) VALUES "
					+ "('" + actiune.getKurzBeschreibung() + "', '"+ actiune.getBeschreibung()
					+"', '" + idDeb+"')");
			if(resInsertActiune == 1){
				connection.commit();
				st.close();
			}else{
				throw new Exception("Insert Actiune failed");
			}
		}catch (Exception e) {
			try {
				connection.rollback();
				st.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		}
		return resInsertActiune;
	}
	
	/**
	 * get all Actiuni by DebitorID
	 * @param idDeb
	 * @return array with all actiuni 
	 */
	public ArrayList<Actiune> getAllActiuniByDebitorId(int idDeb){
		Statement st = null;
		ArrayList<Actiune> actiuni = new ArrayList<Actiune>();
		
		try{
			st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM actiuni where ID_Deb = " + idDeb); 
			while (res.next()) {
				int IDActiuni = res.getInt("ID_Actiuni"); 
				String kurzBeschreibung = res.getString("KurzBeschreibung");
				String beschreibung = res.getString("Beschreibung");
	//			int ID_Deb = res.getInt("ID_Deb"); 
	
				Actiune actiune = new Actiune(IDActiuni, kurzBeschreibung, beschreibung);
				actiuni.add(actiune);		
			}
			st.close();
		}catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		return actiuni;
	}

}
