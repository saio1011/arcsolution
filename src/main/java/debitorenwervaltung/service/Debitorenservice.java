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
	 * @return array with all debtors
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

}
