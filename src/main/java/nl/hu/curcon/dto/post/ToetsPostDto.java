package nl.hu.curcon.dto.post;

/**
 * @author berend.wilkens, 3 mei 2017
 */
public class ToetsPostDto {
    private String naam;
    private String omschrijving;
    private double gewicht;
    private int millerNiveau;
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
	public int getMillerNiveau() {
		return millerNiveau;
	}
	public void setMillerNiveau(int millerNiveau) {
		this.millerNiveau = millerNiveau;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
}
