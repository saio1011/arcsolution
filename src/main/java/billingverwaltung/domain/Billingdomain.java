package billingverwaltung.domain;

import java.sql.Date;

/**
 * 
 * @author mihaisava
 * 		privat attribute "Id"
 * 		public attribute "id"
 */
public class Billingdomain implements Comparable<Billingdomain>{
	private int IdFactura;
	private int IdKunde;
	private int IdDebitor;
	private String NrFactura;
	private Double SumaFactura;
	private Double RestPlata;
	private Date DataFactura;
	private String Status;
	
	/**
	 * Constructor 
	 * 
	 * @param idFactura
	 * @param idKunde
	 * @param idDebitor
	 * @param nrFactura
	 * @param sumaFactura
	 * @param restPlata
	 * @param dataFactura
	 * @param status
	 */
	public Billingdomain(int idFactura, int idKunde, int idDebitor,
			String nrFactura, Double sumaFactura, Double restPlata, Date dataFactura, String status) {
		super();
		IdFactura = idFactura;
		IdKunde = idKunde;
		IdDebitor = idDebitor;
		NrFactura = nrFactura; 
		SumaFactura = sumaFactura;
		RestPlata = restPlata;
		DataFactura = dataFactura;
		Status = status;
	}

	public Billingdomain(int idKunde, int idDebitor, String nrFactura, Double sumaFactura, Double restPlata, Date dataFactura, String status) {
		super();
		IdKunde = idKunde;
		IdDebitor = idDebitor;
		NrFactura = nrFactura; 
		SumaFactura = sumaFactura;
		RestPlata = restPlata;
		DataFactura = dataFactura;
		Status = status;
	}
	
	/**
	 * Constructor without restplata(at the begin = sumaFaktura) and status(at the begin = Open)
	 * 
	 * @param idKunde
	 * @param idDebitor
	 * @param nrFactura
	 * @param sumaFactura
	 * @param dataFactura
	 */
	public Billingdomain(int idKunde, int idDebitor, String nrFactura, Double sumaFactura, Date dataFactura) {
		super();
		IdKunde = idKunde;
		IdDebitor = idDebitor;
		NrFactura = nrFactura; 
		SumaFactura = sumaFactura;
		DataFactura = dataFactura;
	}

	public int getIdFactura() {
		return IdFactura;
	}

	public void setIdFactura(int idFactura) {
		IdFactura = idFactura;
	}

	public int getIdKunde() {
		return IdKunde;
	}

	public void setIdKunde(int idKunde) {
		IdKunde = idKunde;
	}

	public int getIdDebitor() {
		return IdDebitor;
	}

	public void setIdDebitor(int idDebitor) {
		IdDebitor = idDebitor;
	}

	public String getNrFactura() {
		return NrFactura;
	}

	public void setNrFactura(String nrFactura) {
		NrFactura = nrFactura;
	}

	public Double getSumaFactura() {
		return SumaFactura;
	}

	public void setSumaFactura(Double sumaFactura) {
		SumaFactura = sumaFactura;
	}

	public Date getDataFactura() {
		return DataFactura;
	}

	public void setDataFactura(Date dataFactura) {
		DataFactura = dataFactura;
	}

	public Double getRestPlata() {
		return RestPlata;
	}

	public void setRestPlata(Double restPlata) {
		RestPlata = restPlata;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "NrFactura: " + NrFactura + ", Suma Factura: "
				+ SumaFactura + ", DataFactura: " + DataFactura;
	}
	
	@Override
	public int compareTo(Billingdomain billing){
		return getDataFactura().compareTo(billing.getDataFactura());
	}
}