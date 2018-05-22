package nl.hu.curcon.dto.post;

/**
 * @author berend.wilkens, 16 mei 2017
 */
public class BeoordelingsElementPostDto  {
    private String naam;
    private String omschrijving;
    private int gewicht;
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getGewicht() {
		return gewicht;
	}
	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}
}
