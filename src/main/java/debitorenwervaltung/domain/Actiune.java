package debitorenwervaltung.domain;

import java.sql.Date;

/**
 * @author mihaisava
 * 		privat attribute "Id"
 * 		public attribute "id"
 */
public class Actiune {
	
	private int IdActiune; 
	private String KurzBeschreibung;
	private String Beschreibung;
	
	public Actiune(int id, String kurzBeschreibung, String beschreibung){
		super();
		this.IdActiune = id;
		this.KurzBeschreibung = kurzBeschreibung;
		this.Beschreibung = beschreibung;
	}
	
	public Actiune(String kurzBeschreibung, String beschreibung){
		super();
		this.KurzBeschreibung = kurzBeschreibung;
		this.Beschreibung = beschreibung;
	}
	
	public Actiune(){
		super();
	}

	public int getIdActiune() {
		return IdActiune;
	}

	public void setIdActiune(int idActiune) {
		IdActiune = idActiune;
	}

	public String getKurzBeschreibung() {
		return KurzBeschreibung;
	}

	public void setKurzBeschreibung(String kurzBeschreibung) {
		KurzBeschreibung = kurzBeschreibung;
	}

	public String getBeschreibung() {
		return Beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		Beschreibung = beschreibung;
	}

	@Override
	public String toString() {
		StringBuilder actiune = new StringBuilder();
		actiune.append("Short Description: "+ KurzBeschreibung);
		actiune.append(System.getProperty("line.separator"));
		actiune.append("	Lang Description: " + Beschreibung);
		
		return actiune.toString();
	}
}
