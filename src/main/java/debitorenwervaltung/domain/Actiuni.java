package debitorenwervaltung.domain;

import java.sql.Date;

public class Actiuni {
	
	private int IDActiuni; 
	private String Beschreibung;
	private Date DataBeschreibung;
	private int ID_Deb;
	public Actiuni(int iDActiuni, String beschreibung, Date dataBeschreibung,
			int iD_Deb) {
		super();
		IDActiuni = iDActiuni;
		Beschreibung = beschreibung;
		DataBeschreibung = dataBeschreibung;
		ID_Deb = iD_Deb;
	}
	public int getIDActiuni() {
		return IDActiuni;
	}
	public void setIDActiuni(int iDActiuni) {
		IDActiuni = iDActiuni;
	}
	public String getBeschreibung() {
		return Beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
	}
	public Date getDataBeschreibung() {
		return DataBeschreibung;
	}
	public void setDataBeschreibung(Date dataBeschreibung) {
		DataBeschreibung = dataBeschreibung;
	}
	public int getID_Deb() {
		return ID_Deb;
	}
	public void setID_Deb(int iD_Deb) {
		ID_Deb = iD_Deb;
	}
	
	

}
