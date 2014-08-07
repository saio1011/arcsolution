package kundenverwaltung.domain;

public class Kundedomain {
	private int ID;
	private String Name;
	private String KontraktNr;
	private String Actaditional;
	private String valabilitateCtr;
	
	public Kundedomain(int iD, String name, String kontraktNr, String actaditional,
			String valabilitateCrt) {
		super();
		ID = iD;
		Name = name;
		KontraktNr = kontraktNr;
		Actaditional = actaditional;
		this.valabilitateCtr = valabilitateCrt;
	}
	public Kundedomain(String name, String kontraktNr, String actaditional,
			String valabilitateCrt) {
		super();
		Name = name;
		KontraktNr = kontraktNr;
		Actaditional = actaditional;
		this.valabilitateCtr = valabilitateCrt;
	}

	public int getID() {
		return ID;
	}
	public String getIDString(){
		return ""+ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getKontraktNr() {
		return KontraktNr;
	}

	public void setKontraktNr(String kontraktNr) {
		KontraktNr = kontraktNr;
	}

	public String getActaditional() {
		return Actaditional;
	}

	public void setActaditional(String actaditional) {
		Actaditional = actaditional;
	}

	public String getValabilitateCrt() {
		return valabilitateCtr;
	}

	public void setValabilitateCrt(String valabilitateCrt) {
		this.valabilitateCtr = valabilitateCrt;
	}

	@Override
	public String toString() {
		return "Kundedomain [ID=" + ID + ", Name=" + Name + ", KontraktNr="
				+ KontraktNr + ", Actaditional=" + Actaditional
				+ ", valabilitateCtr=" + valabilitateCtr + "]";
	}
	
	
	
	
	

}
  