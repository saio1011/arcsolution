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
	
	public Billingdomain getFacturaByIdKundeIdDebitorAndNrFactura(int idKunde, int idDebitor, String nrFaktura) throws Exception{
		ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
		Statement st = null;
		Billingdomain billing = null;
		try{
			st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM factura where idKunde = " + idKunde +" AND idDebitor = "+ idDebitor+" AND ID_Factura = '"+ nrFaktura+"'");	
			while (res.next()) {
				int idFactura = res.getInt("ID_Factura");
				int idClient = res.getInt("idKunde");
				int idDebtor = res.getInt("idDebitor");
				String nrFactura = res.getString("NrFaktura");
				Double sumFactura = res.getDouble("SumaFaktura");
				Double restPlata = res.getDouble("RestPlata");
				Date dateFactura = res.getDate("DataFaktura");
				String status = res.getString("Status");
				
				billing = new Billingdomain(idFactura, idClient, idDebtor, nrFactura, sumFactura, restPlata, dateFactura, status);
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
			throw new Exception ("Two match billings found");
		}
		return billing;
	}
	
	/**
	 * get billings by idKunde and by idDebitor 
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
				int idDebtor = res.getInt("idDebitor");
				String nrFactura = res.getString("NrFaktura");
				Double sumFactura = res.getDouble("SumaFaktura");
				Double restPlata = res.getDouble("RestPlata");
				Date dateFactura = res.getDate("DataFaktura");
				String status = res.getString("Status");
				
				Billingdomain billing = new Billingdomain(idFactura, idClient, idDebtor, nrFactura, sumFactura, restPlata, dateFactura, status);
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
		
		//sort list by date
		Collections.sort(billings);
		return billings;
	}
	
	/**
	 * create billing 
	 * @param billing
	 * @return
	 */
	public int createFactura(Billingdomain billing){
		java.sql.Connection connection = null;
		Statement st = null;
		int resInsertFactura = -1;
		
		try{
			connection = DBverbindung.getConn();
			connection.setAutoCommit(false);
			st = connection.createStatement(Statement.CLOSE_ALL_RESULTS, Statement.RETURN_GENERATED_KEYS);
			resInsertFactura = st.executeUpdate("INSERT INTO factura (`idKunde`, `idDebitor`, `NrFaktura`, `SumaFaktura`, `RestPlata`, `DataFaktura`, `Status`) VALUES "
								+ "('" + billing.getIdKunde()+"', '"+ billing.getIdDebitor()+"', '"+billing.getNrFactura()
								+"', '"+ billing.getSumaFactura() +"', '"+ billing.getSumaFactura() +"', '"+billing.getDataFactura()+"', '"+"Open"+"')" ,Statement.RETURN_GENERATED_KEYS);
			
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
	
	public int payBillingSuccessive(int idKunde, int idDebitor, Double amount){
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
				//if restAmount > 0 but < billing amount 
				}else if(restAmount > 0 && currentBilling.getRestPlata() > restAmount){
					Double restPlata = currentBilling.getRestPlata() - restAmount;
					res = st.executeUpdate("UPDATE factura "
							+ "SET RestPlata = " + restPlata 
								+ " WHERE ID_Factura = " + currentBilling.getIdFactura() );
					
					restAmount = 0.0;
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
	
	
	public int payBillingLaCerere(int idKunde, int idDebitor, Double amount, String nrFactura){
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
			//if amount is == than billing
			}else if(billing.getRestPlata() == amountPlata){	
				res = st.executeUpdate("UPDATE factura "
						+ "SET RestPlata = " + 0 + ", "
						+ 	"Status = '" + statusClosed + "'"
							+ " WHERE ID_Factura = " + billing.getIdFactura() );
		
				//if amount > 0 but < billing amount 
			}else if(amountPlata > 0 && billing.getRestPlata() > amountPlata){
				Double restPlata = billing.getRestPlata() - amountPlata;
				res = st.executeUpdate("UPDATE factura "
						+ "SET RestPlata = " + restPlata 
							+ " WHERE ID_Factura = " + billing.getIdFactura());
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
