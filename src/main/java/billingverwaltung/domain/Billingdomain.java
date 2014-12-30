package billingverwaltung.domain;

import java.sql.Date;

/**
 * 
 * @author mihaisava
 * 		privat attribute "Id"
 * 		public attribute "id"
 */
public class Billingdomain {
	private int IdFactura;
	private int IdKunde;
	private int IdDebitor;
	private String NrFactura;
	private Double SumaFactura;
	private Date DataFactura;
	
	public Billingdomain(int idFactura, int idKunde, int idDebitor,
			String nrFactura, Double sumaFactura, Date dataFactura) {
		super();
		IdFactura = idFactura;
		IdKunde = idKunde;
		IdDebitor = idDebitor;
		NrFactura = nrFactura;
		SumaFactura = sumaFactura;
		DataFactura = dataFactura;
	}

	public Billingdomain(int idKunde, int idDebitor, String nrFactura,
			Double sumaFactura, Date dataFactura) {
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

	@Override
	public String toString() {
		return "NrFactura: " + NrFactura + ", Suma Factura: "
				+ SumaFactura + ", DataFactura: " + DataFactura;
	}
}