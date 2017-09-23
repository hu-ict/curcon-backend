package nl.hu.curcon.dto.post;

/**
 * @author berend.wilkens, 16 jun. 2017
 */
public class LeerdoelPostDto {
	private String naam;
	private String omschrijving;
	private double gewicht;
	private int eindBT;
	private int eindPS;
	private int bloomniveau;
	
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public int getEindBT() {
		return eindBT;
	}
	public void setEindBT(int eindBT) {
		this.eindBT = eindBT;
	}
	public int getEindPS() {
		return eindPS;
	}
	public void setEindPS(int eindPS) {
		this.eindPS = eindPS;
	}
	public int getBloomniveau() {
		return bloomniveau;
	}
	public void setBloomniveau(int bloomniveau) {
		this.bloomniveau = bloomniveau;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public double getGewicht() {
		return gewicht;
	}
	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}
}