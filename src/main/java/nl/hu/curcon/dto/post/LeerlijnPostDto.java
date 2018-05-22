package nl.hu.curcon.dto.post;

/**
 * @author berend.wilkens, 23 mei 2017
 */
public class LeerlijnPostDto {
    private String naam;
    private String omschrijving;
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
}
