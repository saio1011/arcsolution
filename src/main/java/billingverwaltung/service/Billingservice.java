package billingverwaltung.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import billingverwaltung.domain.Billingdomain;
import util.*;

/**
 * @author mihaisava
 */
public class Billingservice {
	
	/**
	 * get one billing by idkunde, iddebitor and nrfactura 
	 * 
	 * @param idKunde
	 * @param idDebitor
	 * @param nrFaktura
	 * 
	 * @return only one billing
	 * 
	 * @throws Exception "no billing found" and "to many billings fount"
	 */
	public Billingdomain getFacturaByIdKundeIdDebitorAndNrFactura(int idKunde, int idDebitor, String nrFaktura) throws Exception{
		ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
		Statement st = null;
		Billingdomain billing = null;
		try{
			st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM factura where idKunde = " + idKunde +" AND idDebitor = "+ idDebitor+" AND NrFaktura = '"+ nrFaktura+"'");	
			while (res.next()) {
				int idFactura = res.getInt("ID_Factura");
				int idClient = res.getInt("idKunde");
				String nameKunde = res.getString("nameKunde");
				int idDebtor = res.getInt("idDebitor");
				String nameDebitor = res.getString("nameDebitor");
				String nrFactura = res.getString("NrFaktura");
				Double sumFactura = res.getDouble("SumaFaktura");
				Double restPlata = res.getDouble("RestPlata");
				Date dateFactura = res.getDate("DataFaktura");
				Date dateScadentaFactura = res.getDate("DataScadentaFaktura");
				Date datePreluareCreanta = res.getDate("DataPreluareCreanta");
				String status = res.getString("Status");
				
				billing = new Billingdomain(idFactura, idClient,nameKunde, idDebtor, nameDebitor, nrFactura, sumFactura, restPlata, dateFactura, dateScadentaFactura,datePreluareCreanta, status);
				billings.add(billing);
			}
			st.close();
				
		}catch (Exception ex){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println(ex.getMessage());
		}
		if(billings.size() == 0){
			throw new Exception ("No billing fount");
		}else if(billings.size()>1){
			throw new Exception ("Too many billings found");
		}
		return billing;
	}
	
	/**
	 * get billings by idKunde and by idDebitor 
	 * 
	 * @param idKunde
	 * @param idDebitor
	 * @return array with billings
	 */
	public ArrayList<Billingdomain> getFacturaByIdKundeAndIdDebitor(int idKunde, int idDebitor, String statusF){
		ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
		Statement st = null;
		
		try{
			st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM factura where idKunde = " + idKunde +" AND idDebitor = "+ idDebitor+" AND Status = '"+ statusF+"'");
			while (res.next()) {
				int idFactura = res.getInt("ID_Factura");
				int idClient = res.getInt("idKunde");
				String nameKunde = res.getString("nameKunde");
				int idDebtor = res.getInt("idDebitor");
				String nameDebitor = res.getString("nameDebitor");
				String nrFactura = res.getString("NrFaktura");
				Double sumFactura = res.getDouble("SumaFaktura");
				Double restPlata = res.getDouble("RestPlata");
				Date dateFactura = res.getDate("DataFaktura");
				Date dateScadentaFactura = res.getDate("DataScadentaFaktura");
				Date datePreluareCreanta = res.getDate("DataPreluareCreanta");
				String status = res.getString("Status");
				
				Billingdomain billing = new Billingdomain(idFactura, idClient, nameKunde, idDebtor, nameDebitor, nrFactura, sumFactura, restPlata, dateFactura, dateScadentaFactura,datePreluareCreanta, status);
				billings.add(billing);
			}
			st.close();
				
		}catch (Exception ex){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println(ex.getMessage());
		}
		
		//sort list by "data scadenta"
		Collections.sort(billings);
		return billings;
	}
	
	/**
	 * get all billings with data prescriere < 60 days
	 */
	public ArrayList<Billingdomain> getBillingsForAlerteFacturi(Date dateRef){
		ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
		Statement st = null;
		String statusF = "Open";
		
		try{
			st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM factura where  Status = '"+ statusF+"' AND DataScadentaFaktura < '" + dateRef+ "'");
			while (res.next()) {
				int idFactura = res.getInt("ID_Factura");
				int idClient = res.getInt("idKunde");
				String nameKunde = res.getString("nameKunde");
				int idDebtor = res.getInt("idDebitor");
				String nameDebitor = res.getString("nameDebitor");
				String nrFactura = res.getString("NrFaktura");
				Double sumFactura = res.getDouble("SumaFaktura");
				Double restPlata = res.getDouble("RestPlata");
				Date dateFactura = res.getDate("DataFaktura");
				Date dateScadentaFactura = res.getDate("DataScadentaFaktura");
				Date datePreluareCreanta = res.getDate("DataPreluareCreanta");
				String status = res.getString("Status");
				
				Billingdomain billing = new Billingdomain(idFactura, idClient, nameKunde, idDebtor, nameDebitor, nrFactura, sumFactura, restPlata, dateFactura, dateScadentaFactura,datePreluareCreanta, status);
				billings.add(billing);
			}
			st.close();
				
		}catch (Exception ex){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println(ex.getMessage());
		}
		
		//sort list by "data scadenta"
		Collections.sort(billings);
		return billings;
	}
	
	/**
	 * get all billings for one customer
	 */
	public ArrayList<Billingdomain> getAllBillingsForOneCustomer(int idCustomer){
		ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
		Statement st = null;

		try{
			st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM factura where  idKunde = '"+ idCustomer+ "'");
			while (res.next()) {
				int idFactura = res.getInt("ID_Factura");
				int idClient = res.getInt("idKunde");
				String nameKunde = res.getString("nameKunde");
				int idDebtor = res.getInt("idDebitor");
				String nameDebitor = res.getString("nameDebitor");
				String nrFactura = res.getString("NrFaktura");
				Double sumFactura = res.getDouble("SumaFaktura");
				Double restPlata = res.getDouble("RestPlata");
				Date dateFactura = res.getDate("DataFaktura");
				Date dateScadentaFactura = res.getDate("DataScadentaFaktura");
				Date datePreluareCreanta = res.getDate("DataPreluareCreanta");
				String status = res.getString("Status");
				
				Billingdomain billing = new Billingdomain(idFactura, idClient, nameKunde, idDebtor, nameDebitor, nrFactura, sumFactura, restPlata, dateFactura, dateScadentaFactura,datePreluareCreanta, status);
				billings.add(billing);
			}
			st.close();
				
		}catch (Exception ex){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println(ex.getMessage());
		}
		
		//sort list by "data scadenta"
		Collections.sort(billings);
		return billings;
	}
	
	/**
	 * get all payed billings for one customer
	 */
	public ArrayList<Billingdomain> getAllPayedBillingsForOneCustomer(int idCustomer){
		ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
		Statement st = null;

		try{
			st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM facturiIncasate where  idKunde = '"+ idCustomer+ "'");
			while (res.next()) {
				int idFactura = res.getInt("ID_FacturaIncasata");
				int idClient = res.getInt("idKunde");
				String nameKunde = res.getString("nameKunde");
				int idDebtor = res.getInt("idDebitor");
				String nameDebitor = res.getString("nameDebitor");
				String nrFactura = res.getString("NrFaktura");
				Double sumFactura = res.getDouble("SumaFaktura");
				Double restPlata = res.getDouble("SumaPlatita"); //since this constructor does not have this field I use this field for suma incasata
				Date dateFactura = res.getDate("DataFaktura");
				Date dateScadentaFactura = res.getDate("DataFaktura"); // this field does not exist in facturi incasate // is only a dummy field
				Date datePreluareCreanta = res.getDate("DataIncasare"); // this field does not exist in facturi incasate // Iuse this field for data incasare
				String status = res.getString("nameKunde"); // this field does not exist in facturi incasate // is only a dummy field
				
				Billingdomain billing = new Billingdomain(idFactura, idClient, nameKunde, idDebtor, nameDebitor, nrFactura, sumFactura, restPlata, dateFactura, dateScadentaFactura,datePreluareCreanta, status);
				billings.add(billing);
			}
			st.close();
				
		}catch (Exception ex){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println(ex.getMessage());
		}
		
		//sort list by "data scadenta"
		Collections.sort(billings);
		return billings;
	}
	
	/**
	 * create billing 
	 * 
	 * @param billing
	 * @return result insert factura
	 */
	public int createFactura(Billingdomain billing){
		java.sql.Connection connection = null;
		Statement st = null;
		int resInsertFactura = -1;
		
		try{
			connection = DBverbindung.getConn();
			connection.setAutoCommit(false);
			st = connection.createStatement(Statement.CLOSE_ALL_RESULTS, Statement.RETURN_GENERATED_KEYS);
			resInsertFactura = st.executeUpdate("INSERT INTO factura (`idKunde`, `nameKunde`, `idDebitor`, `nameDebitor`, `NrFaktura`, `SumaFaktura`, `RestPlata`, `DataFaktura`, `DataScadentaFaktura`,`DataPreluareCreanta`, `Status`) VALUES "
								+ "('" + billing.getIdKunde()+"', '"+billing.getNameKunde()+"', '"+ billing.getIdDebitor()+"', '"+billing.getNameDebitor()+"', '"+billing.getNrFactura()
								+"', '"+ billing.getSumaFactura() +"', '"+ billing.getSumaFactura() +"', '"+billing.getDataFactura()+"', '"+billing.getDataScadentaFactura()+"', '"+ billing.getDataPreluareCreanta()+"', '"+"Open"+"')" ,Statement.RETURN_GENERATED_KEYS);
			
//			int counter = 0;
//			ResultSet generatedKeys = st.getGeneratedKeys();
//	        if(generatedKeys.next()){
//	        	counter++;
//	            System.out.println("ID Debitor nou: " + idDebitor);    
//	        }
			if(resInsertFactura != 1){
				throw new Exception("Create factura failed");
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
		
		return resInsertFactura;
	}
	
	/**
	 * update billing
	 */
	public int updateFactura(int idFactura, Billingdomain billing){
		java.sql.Connection connection = null;
		Statement st = null;
		int resUpdate = -1;
		try{
			connection = DBverbindung.getConn();
			connection.setAutoCommit(false);
			st = connection.createStatement();
			resUpdate = st.executeUpdate("UPDATE factura "
									+ "SET NrFaktura = '" + billing.getNrFactura() + "', "
									+ 	"SumaFaktura = '" + billing.getSumaFactura() + "', "
									+	"DataFaktura = '" + billing.getDataFactura()+ "', "
									+	"DataScadentaFaktura = '" + billing.getDataScadentaFactura() + "', "
									+	"DataPreluareCreanta = '" + billing.getDataPreluareCreanta() + "', "
									+	"Status = '" + billing.getStatus() + "'"
										+ " WHERE ID_Factura = " + idFactura );
			if(resUpdate != 1){
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
		
		return resUpdate;
	}
	
	
	/**
	 * pay billing successive
	 * 
	 * @param idKunde
	 * @param idDebitor
	 * @param amount
	 * 
	 * @return result pay last billing (1) or -1 if pay billing fail
	 */
	public int payBillingSuccessive(int idKunde, String nameKunde, int idDebitor, String nameDebitor, Double amount, Date dataIncasareFactura, String locIncasare){
		java.sql.Connection connection = null;
		Statement st = null;
		int res = -1;
		
		ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
		String statusOpen = "Open";
		String statusClosed = "Closed";
		Double restAmount = amount;
		try{
			connection = DBverbindung.getConn();
			connection.setAutoCommit(false);
			st = connection.createStatement();
			
			//all billings are already sorted by dataScadenta 
			billings = this.getFacturaByIdKundeAndIdDebitor(idKunde, idDebitor, statusOpen);
			
			for(int zl = 0; zl < billings.size(); zl ++){
				Billingdomain currentBilling = billings.get(zl); 
				//if restAmount is > than billing amount
				if(currentBilling.getRestPlata() <= restAmount ){	
					res = st.executeUpdate("UPDATE factura "
							+ "SET RestPlata = " + 0 + ", "
							+ 	"Status = '" + statusClosed + "'"
								+ " WHERE ID_Factura = " + currentBilling.getIdFactura() );
					
					restAmount = restAmount-currentBilling.getRestPlata();
					
				//insert payed billing into facturiIncasate
					if (res == 1){
						res = st.executeUpdate("INSERT INTO `facturiIncasate` (`idKunde`,`nameKunde`,`idDebitor`,`nameDebitor`,`NrFaktura`,`SumaFaktura`, `SumaPlatita`, `DataFaktura`,`DataIncasare`,`LocIncasare`) VALUES "
								+ "('" + currentBilling.getIdKunde() +"', '" + nameKunde + "', '" + currentBilling.getIdDebitor() +"', '"+nameDebitor+ "', '" + currentBilling.getNrFactura()
								+ "', '" + currentBilling.getSumaFactura() + "', '" + currentBilling.getRestPlata() + "', '" + currentBilling.getDataFactura()
								+ "', '" + dataIncasareFactura + "', '" + locIncasare +"')");
					}
					if(res != 1){
						throw new Exception("Pay billing failed");
					}
				//if restAmount > 0 but < billing amount 
				}else if(restAmount > 0 && currentBilling.getRestPlata() > restAmount){
					Double restPlata = currentBilling.getRestPlata() - restAmount;
					res = st.executeUpdate("UPDATE factura "
							+ "SET RestPlata = " + restPlata 
								+ " WHERE ID_Factura = " + currentBilling.getIdFactura() );
					
					//insert payed billing into facturiIncasate
					if (res == 1){
						res = st.executeUpdate("INSERT INTO `facturiIncasate` (`idKunde`,`nameKunde`,`idDebitor`,`nameDebitor`,`NrFaktura`,`SumaFaktura`, `SumaPlatita`, `DataFaktura`,`DataIncasare`,`LocIncasare`) VALUES "
								+ "('" + currentBilling.getIdKunde() +"', '" + nameKunde + "', '" + currentBilling.getIdDebitor() + "', '"+nameDebitor+ "', '" + currentBilling.getNrFactura()
								+ "', '" + currentBilling.getSumaFactura() + "', '" + restAmount + "', '" + currentBilling.getDataFactura()
								+ "', '" + dataIncasareFactura + "', '" + locIncasare +"')");
					}
					restAmount = 0.0;
					if(res != 1){
						throw new Exception("Pay billing failed");
					}
				}
				
				if(res != 1){
					throw new Exception("Pay billing failed");
				}
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
		
		return res;
	}
	
	/**
	 * pay billing la cerere
	 * 
	 * @param idKunde
	 * @param idDebitor
	 * @param amount
	 * @param nrFactura
	 * 
	 * @return 1 if pay billing ok, -1 if pay billing fail, 
			-2  if 	 amount is > than billing amount*/
	public int payBillingLaCerere(int idKunde, String nameKunde, int idDebitor, String nameDebitor, Double amount, String nrFactura, Date dataIncasareFactura, String locIncasare){
		java.sql.Connection connection = null;
		Statement st = null;
		String statusOpen = "Open";
		String statusClosed = "Closed";
		int res = -1;
		Double amountPlata = amount;
		
		try{
			connection = DBverbindung.getConn();
			connection.setAutoCommit(false);
			st = connection.createStatement();
			
			Billingdomain billing = this.getFacturaByIdKundeIdDebitorAndNrFactura(idKunde, idDebitor, nrFactura);
			
			//if amount is > than billing amount return -2
			if(billing.getRestPlata() < amountPlata){
				return -2;
				//if amount > 0 but < billing amount 
			}else if(billing.getRestPlata() > amountPlata){
				Double restPlata = billing.getRestPlata() - amountPlata;
				res = st.executeUpdate("UPDATE factura "
						+ "SET RestPlata = " + restPlata 
							+ " WHERE ID_Factura = " + billing.getIdFactura());
				
			}else{	//if amount is == than billing	
				res = st.executeUpdate("UPDATE factura "
						+ "SET RestPlata = " + 0 + ", "
						+ 	"Status = '" + statusClosed + "'"
							+ " WHERE ID_Factura = " + billing.getIdFactura() );
		
				
			}
			//insert payed billing into facturiIncasate
			if (res == 1){
				res = st.executeUpdate("INSERT INTO `facturiIncasate` (`idKunde`,`nameKunde`,`idDebitor`, `nameDebitor`,`NrFaktura`,`SumaFaktura`, `SumaPlatita`, `DataFaktura`,`DataIncasare`,`LocIncasare`) VALUES "
						+ "('" + billing.getIdKunde() +"', '" + nameKunde + "', '" + billing.getIdDebitor() + "', '"+nameDebitor+ "', '" + billing.getNrFactura()
						+ "', '" + billing.getSumaFactura() + "', '" + amount + "', '" + billing.getDataFactura()
						+ "', '" + dataIncasareFactura + "', '" + locIncasare +"')");
			}
			
			if(res != 1){
				throw new Exception("Pay billing failed");
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
		
		return res;
	}

}
