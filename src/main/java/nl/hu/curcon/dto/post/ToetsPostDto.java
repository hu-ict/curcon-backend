package nl.hu.curcon.dto.post;

/**
 * @author berend.wilkens, 3 mei 2017
 */
public class ToetsPostDto {
    private String naam;
    private double gewicht;
    private int osirisResultaatType;
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
	public int getOsirisResultaatType() {
		return osirisResultaatType;
	}
	public void setOsirisResultaatType(int osirisResultaatType) {
		this.osirisResultaatType = osirisResultaatType;
	}

}
