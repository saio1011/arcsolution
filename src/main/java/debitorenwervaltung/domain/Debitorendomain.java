package debitorenwervaltung.domain;


import java.sql.Date;
import java.util.ArrayList;
import util.*;

/**
 * @author mihaisava
 * 		privat attribute "Id"
 * 		public attribute "id"
 */
public class Debitorendomain {
	
	private int IdDeb;
	private String DenumireDebitor;
	private String Cui;
	private String ContactDebitor;
	private String StatusDebitor;
	private String StatusDosar;
	private Adresa Adresa;
	private Actiune Actiune;
	private ArrayList<Actiune> Actiuni;

	public Debitorendomain(int idDeb, String denumireDebitor, String cui, String contactDebitor, String statusDebitor,
			String statusDosar, Adresa adresa, Actiune actiune) {
		super();
		this.IdDeb = idDeb;
		this.DenumireDebitor = denumireDebitor;
		this.Cui = cui;
		this.ContactDebitor = contactDebitor;
		this.StatusDebitor = statusDebitor;
		this.StatusDosar = statusDosar;
		this.Adresa = adresa;
		this.Actiune = actiune;
	}
	
	public Debitorendomain(int idDeb, String denumireDebitor, String cui, String contactDebitor, String statusDebitor,
			String statusDosar, Adresa adresa, ArrayList<Actiune> actiuni) {
		super();
		this.IdDeb = idDeb;
		this.DenumireDebitor = denumireDebitor;
		this.Cui = cui;
		this.ContactDebitor = contactDebitor;
		this.StatusDebitor = statusDebitor;
		this.StatusDosar = statusDosar;
		this.Adresa = adresa;
		this.Actiuni = actiuni;
	}
	
	public Debitorendomain(String denumireDebitor, String cui, String contactDebitor, String statusDebitor,
			String statusDosar, Adresa adresa, Actiune actiune) {
		super();
		this.DenumireDebitor = denumireDebitor;
		this.Cui = cui;
		this.ContactDebitor = contactDebitor;
		this.StatusDebitor = statusDebitor;
		this.StatusDosar = statusDosar;
		this.Adresa = adresa;
		this.Actiune = actiune;
	}

	public int getIdDeb() {
		return IdDeb;
	}

	public void setIdDeb(int idDeb) {
		IdDeb = idDeb;
	}

	public String getDenumireDebitor() {
		return DenumireDebitor;
	}

	public void setDenumireDebitor(String denumireDebitor) {
		DenumireDebitor = denumireDebitor;
	}

	public String getCui() {
		return Cui;
	}

	public void setCui(String cui) {
		Cui = cui;
	}

	public String getContactDebitor() {
		return ContactDebitor;
	}

	public void setContactDebitor(String contactDebitor) {
		ContactDebitor = contactDebitor;
	}

	public String getStatusDebitor() {
		return StatusDebitor;
	}

	public void setStatusDebitor(String statusDebitor) {
		StatusDebitor = statusDebitor;
	}

	public String getStatusDosar() {
		return StatusDosar;
	}

	public void setStatusDosar(String statusDosar) {
		StatusDosar = statusDosar;
	}

	//TODO 
	//to check if is correct implemented and if is needed 
	public Adresa getAdresa() {
		return Adresa;
	}

	public void setAdresa(Adresa adresaDebitor) {
		Adresa = adresaDebitor;
	}

	public Actiune getActiune() {
		return Actiune;
	}

	public void setActiune(Actiune actiune) {
		Actiune = actiune;
	}
	

	public ArrayList<Actiune> getActiuni() {
		return Actiuni;
	}

	public void setActiuni(ArrayList<Actiune> actiuni) {
		Actiuni = actiuni;
	}

	@Override
	public String toString() {
		return "DenumireDebitor=" + DenumireDebitor + ", Cui="
				+ Cui + ", ContactDebitor=" + ContactDebitor
				+ ", StatusDebitor=" + StatusDebitor + ", StatusDosar="
				+ StatusDosar;
	}
}
