package nl.hu.curcon.dto.competence;

import nl.hu.curcon.dto.HRefDto;

/**
 * @author berend.wilkens, 23 mei 2017
 */
public class TrefwoordDto extends HRefDto {
    private int id;
    private String naam;
    private String omschrijving;
    private HRefDto cursussen;
    private HRefDto leerdoelen;
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
	public HRefDto getLeerdoelen() {
		return leerdoelen;
	}
	public void setLeerdoelen(HRefDto leerdoelen) {
		this.leerdoelen = leerdoelen;
	}
	public HRefDto getCursussen() {
		return cursussen;
	}
	public void setCursussen(HRefDto cursussen) {
		this.cursussen = cursussen;
	}
}
