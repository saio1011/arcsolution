package debitorenwervaltung.domain;

public class Adresa {
	
	private int ID_Adresa; 
	private String Strada; 
	private String Nummer; 
	private String CodPostal;
	private String Oras; 
	private String Judet; 
	private String Country; 
	private int ID_Deb;
	public Adresa(int iD_Adresa, String strada, String nummer,
			String codPostal, String oras, String judet, String country,
			int iD_Deb) {
		super();
		ID_Adresa = iD_Adresa;
		Strada = strada;
		Nummer = nummer;
		CodPostal = codPostal;
		Oras = oras;
		Judet = judet;
		Country = country;
		ID_Deb = iD_Deb;
	}
	public int getID_Adresa() {
		return ID_Adresa;
	}
	public void setID_Adresa(int iD_Adresa) {
		ID_Adresa = iD_Adresa;
	}
	public String getStrada() {
		return Strada;
	}
	public void setStrada(String strada) {
		Strada = strada;
	}
	public String getNummer() {
		return Nummer;
	}
	public void setNummer(String nummer) {
		Nummer = nummer;
	}
	public String getCodPostal() {
		return CodPostal;
	}
	public void setCodPostal(String codPostal) {
		CodPostal = codPostal;
	}
	public String getOras() {
		return Oras;
	}
	public void setOras(String oras) {
		Oras = oras;
	}
	public String getJudet() {
		return Judet;
	}
	public void setJudet(String judet) {
		Judet = judet;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getID_Deb() {
		return ID_Deb;
	}
	public void setID_Deb(int iD_Deb) {
		ID_Deb = iD_Deb;
	} 
	
	

}
