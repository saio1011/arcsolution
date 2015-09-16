package kundenverwaltung.domain;

import java.util.ArrayList;

public class Prozentedomain {
	private Prozenteheader header;
	private ArrayList<Prozenterow> rows;
	
	public Prozenteheader getHeader() {
		return header;
	}
	public void setHeader(Prozenteheader header) {
		this.header = header;
	}
	public ArrayList<Prozenterow> getRows() {
		return rows;
	}
	public void setRows(ArrayList<Prozenterow> rows) {
		this.rows = rows;
	}
}
