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
	private String NameKunde;
	private int IdDebitor;
	private String NameDebitor;
	private String NrFactura;
	private Double SumaFactura;
	private Double RestPlata;
	private Date DataFactura;
	private Date DataScadentaFactura;
	private Date DataPreluareCreanta;
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
	public Billingdomain(int idFactura, int idKunde, String nameKunde, int idDebitor, String nameDebitor,
			String nrFactura, Double sumaFactura, Double restPlata, Date dataFactura, Date dataScadentaFactura, Date dataPreluareCreanta, String status) {
		super();
		IdFactura = idFactura;
		IdKunde = idKunde;
		NameKunde = nameKunde;
		IdDebitor = idDebitor;
		NameDebitor = nameDebitor;
		NrFactura = nrFactura; 
		SumaFactura = sumaFactura;
		RestPlata = restPlata;
		DataFactura = dataFactura;
		DataScadentaFactura = dataScadentaFactura;
		DataPreluareCreanta = dataPreluareCreanta;
		Status = status;
	}

	public Billingdomain(int idKunde, String nameKunde, int idDebitor, String nameDebitor, String nrFactura, Double sumaFactura, Double restPlata, Date dataFactura, Date dataScadentaFactura, Date dataPreluareCreanta, String status) {
		super();
		IdKunde = idKunde;
		NameKunde = nameKunde;
		IdDebitor = idDebitor;
		NameDebitor = nameDebitor;
		NrFactura = nrFactura; 
		SumaFactura = sumaFactura;
		RestPlata = restPlata;
		DataFactura = dataFactura;
		DataScadentaFactura = dataScadentaFactura;
		DataPreluareCreanta = dataPreluareCreanta;
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
	public Billingdomain(int idKunde, String nameKunde, int idDebitor, String nameDebitor, String nrFactura, Double sumaFactura, Date dataFactura, Date dataScadentaFactura, Date dataPreluareCreanta) {
		super();
		IdKunde = idKunde;
		NameKunde = nameKunde;
		IdDebitor = idDebitor;
		NameDebitor = nameDebitor;
		NrFactura = nrFactura; 
		SumaFactura = sumaFactura;
		DataFactura = dataFactura;
		DataScadentaFactura = dataScadentaFactura;
		DataPreluareCreanta = dataPreluareCreanta;
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

	public Date getDataScadentaFactura() {
		return DataScadentaFactura;
	}

	public void setDataScadentaFactura(Date dataScadentaFactura) {
		DataScadentaFactura = dataScadentaFactura;
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

	public String getNameKunde() {
		return NameKunde;
	}

	public void setNameKunde(String nameKunde) {
		NameKunde = nameKunde;
	}

	public String getNameDebitor() {
		return NameDebitor;
	}

	public void setNameDebitor(String nameDebitor) {
		NameDebitor = nameDebitor;
	}

	public Date getDataPreluareCreanta() {
		return DataPreluareCreanta;
	}

	public void setDataPreluareCreanta(Date dataPreluareCreanta) {
		DataPreluareCreanta = dataPreluareCreanta;
	}

	@Override
	public String toString() {
		return "NrFactura: " + NrFactura + ", Suma Factura: "
				+ SumaFactura + ", DataFactura: " + DataFactura + ", DataScadenta: " + DataScadentaFactura;
	}
	
	@Override
	public int compareTo(Billingdomain billing){
		return getDataScadentaFactura().compareTo(billing.getDataScadentaFactura());
	}
}