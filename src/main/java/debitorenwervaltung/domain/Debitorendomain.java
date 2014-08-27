package debitorenwervaltung.domain;


import java.sql.Date;
import java.util.ArrayList;

public class Debitorendomain {
	
	private int IDDeb;
	private String Name;
	private double ValoareCranta;
	private Date DataNotificare;
	private Date DataConfPrimire;
	private Date DataNotifUltimativa;
	private Date DataNotifConfPrimire;
//	private String Beschreibung;
//	private String DataBeschreibung;
//	private String NumeContact;
//	private String TelContact;
//	private String AdresaContact;
	private int IDKunde;
//	private int IDContact;
//	private int IDActiuni;
//	private int IDAdresa;
	public ArrayList<Actiuni> listActiuni;
	public ArrayList<Contact> listContact;
	public ArrayList<Adresa> listAdresa;
	public Debitorendomain(int iDDeb, String name, double valoareCranta,
			Date dataNotificare, Date dataConfPrimire,
			Date dataNotifUltimativa, Date dataNotifConfPrimire, int iDKunde) {
		super();
		IDDeb = iDDeb;
		Name = name;
		ValoareCranta = valoareCranta;
		DataNotificare = dataNotificare;
		DataConfPrimire = dataConfPrimire;
		DataNotifUltimativa = dataNotifUltimativa;
		DataNotifConfPrimire = dataNotifConfPrimire;
		IDKunde = iDKunde;
	}
	public int getIDDeb() {
		return IDDeb;
	}
	public void setIDDeb(int iDDeb) {
		IDDeb = iDDeb;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getValoareCranta() {
		return ValoareCranta;
	}
	public void setValoareCranta(double valoareCranta) {
		ValoareCranta = valoareCranta;
	}
	public Date getDataNotificare() {
		return DataNotificare;
	}
	public void setDataNotificare(Date dataNotificare) {
		DataNotificare = dataNotificare;
	}
	public Date getDataConfPrimire() {
		return DataConfPrimire;
	}
	public void setDataConfPrimire(Date dataConfPrimire) {
		DataConfPrimire = dataConfPrimire;
	}
	public Date getDataNotifUltimativa() {
		return DataNotifUltimativa;
	}
	public void setDataNotifUltimativa(Date dataNotifUltimativa) {
		DataNotifUltimativa = dataNotifUltimativa;
	}
	public Date getDataNotifConfPrimire() {
		return DataNotifConfPrimire;
	}
	public void setDataNotifConfPrimire(Date dataNotifConfPrimire) {
		DataNotifConfPrimire = dataNotifConfPrimire;
	}
	public int getIDKunde() {
		return IDKunde;
	}
	public void setIDKunde(int iDKunde) {
		IDKunde = iDKunde;
	}
	public ArrayList<Actiuni> getListActiuni() {
		return listActiuni;
	}
	public void setListActiuni(Actiuni actiune) {
		listActiuni.add(actiune);
	}
	public ArrayList<Contact> getListContact() {
		return listContact;
	}
	public void setListContact(Contact contact) {
		listContact.add(contact);
	}
	public ArrayList<Adresa> getListAdresa() {
		return listAdresa;
	}
	public void setListAdresa(Adresa adresa) {
		listAdresa.add(adresa);
	}
	
	
	
	
	
	

}
