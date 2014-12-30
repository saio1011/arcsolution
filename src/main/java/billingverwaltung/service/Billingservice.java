package billingverwaltung.service;

import java.sql.*;
import java.util.ArrayList;

import billingverwaltung.domain.Billingdomain;
import util.*;

/**
 * @author mihaisava
 */
public class Billingservice {
	
	/**
	 * get billings by idKunde and by idDebitor 
	 * @param idKunde
	 * @param idDebitor
	 * @return array with billings
	 */
	public ArrayList<Billingdomain> getFacturaByIdKundeAndIdDebitor(int idKunde, int idDebitor){
		ArrayList<Billingdomain> billings = new ArrayList<Billingdomain>();
		Statement st = null;
		
		try{
			st = DBverbindung.getConn().createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM factura where idKunde = " + idKunde +" AND idDebitor = "+ idDebitor);
			while (res.next()) {
				int idFactura = res.getInt("ID_Factura");
				int idClient = res.getInt("idKunde");
				int idDebtor = res.getInt("idDebitor");
				String nrFactura = res.getString("NrFaktura");
				Double sumFactura = res.getDouble("SumaFaktura");
				Date dateFactura = res.getDate("DataFaktura");
				
				Billingdomain billing = new Billingdomain(idFactura, idClient, idDebtor, nrFactura, sumFactura, dateFactura);
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
			resInsertFactura = st.executeUpdate("INSERT INTO factura (`idKunde`, `idDebitor`, `NrFaktura`, `SumaFaktura`, `DataFaktura`) VALUES "
								+ "('" + billing.getIdKunde()+"', '"+ billing.getIdDebitor()+"', '"+billing.getNrFactura()
								+"', '"+ billing.getSumaFactura() +"', '"+billing.getDataFactura()+"')" ,Statement.RETURN_GENERATED_KEYS);
			
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

}
