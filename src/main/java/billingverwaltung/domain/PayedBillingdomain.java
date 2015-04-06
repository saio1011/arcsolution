//package billingverwaltung.domain;
//
//import java.sql.Date;
//
///**
// * 
// * @author mihaisava
// * 		privat attribute "Id"
// * 		public attribute "id"
// */
//public class PayedBillingdomain extends Billingdomain{
//	private Date DataPlataFactura;
//
//	
//	/**
//	 * Constructor 
//	 * 
//	 * @param idFactura
//	 * @param idKunde
//	 * @param idDebitor
//	 * @param nrFactura
//	 * @param sumaFactura
//	 * @param restPlata
//	 * @param DataPlataFactura
//	 * @param status
//	 */
//	public PayedBillingdomain(Date dataPlataFactura) {
//		super();
//		DataPlataFactura = DataPlataFactura;
//
//	}
//
////	public PayedBillingdomain(int idKunde, int idDebitor, String nrFactura, Double sumaFactura, Double restPlata, Date DataPlataFactura, String status) {
////		super();
////		IdKunde = idKunde;
////		IdDebitor = idDebitor;
////		NrFactura = nrFactura; 
////		SumaFactura = sumaFactura;
////		RestPlata = restPlata;
////		DataPlataFactura = DataPlataFactura;
////		Status = status;
////	}
////	
////	/**
////	 * Constructor without restplata(at the begin = sumaFaktura) and status(at the begin = Open)
////	 * 
////	 * @param idKunde
////	 * @param idDebitor
////	 * @param nrFactura
////	 * @param sumaFactura
////	 * @param DataPlataFactura
////	 */
////	public PayedBillingdomain(int idKunde, int idDebitor, String nrFactura, Double sumaFactura, Date DataPlataFactura) {
////		super();
////		IdKunde = idKunde;
////		IdDebitor = idDebitor;
////		NrFactura = nrFactura; 
////		SumaFactura = sumaFactura;
////		DataPlataFactura = DataPlataFactura;
////	}
//
//	
//}