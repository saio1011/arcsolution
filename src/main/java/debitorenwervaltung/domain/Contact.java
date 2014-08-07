package debitorenwervaltung.domain;

public class Contact {
	
	private int IDContact;
	private String NumeContact;
	private String TelContact;
	private int ID_Deb;
	public Contact(int iDContact, String numeContact, String telContact,
			int iD_Deb) {
		super();
		IDContact = iDContact;
		NumeContact = numeContact;
		TelContact = telContact;
		ID_Deb = iD_Deb;
	}
	public int getIDContact() {
		return IDContact;
	}
	public void setIDContact(int iDContact) {
		IDContact = iDContact;
	}
	public String getNumeContact() {
		return NumeContact;
	}
	public void setNumeContact(String numeContact) {
		NumeContact = numeContact;
	}
	public String getTelContact() {
		return TelContact;
	}
	public void setTelContact(String telContact) {
		TelContact = telContact;
	}
	public int getID_Deb() {
		return ID_Deb;
	}
	public void setID_Deb(int iD_Deb) {
		ID_Deb = iD_Deb;
	} 
	
	
}
