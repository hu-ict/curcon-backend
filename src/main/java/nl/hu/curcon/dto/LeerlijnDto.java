package nl.hu.curcon.dto;

/**
 * @author berend.wilkens, 23 mei 2017
 */
public class LeerlijnDto extends HRefDto {
    private int id;
    private String naam;
    private String omschrijving;
    private HRefDto trefwoorden;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public HRefDto getTrefwoorden() {
		return trefwoorden;
	}
	public void setTrefwoorden(HRefDto trefwoorden) {
		this.trefwoorden = trefwoorden;
	}
}
