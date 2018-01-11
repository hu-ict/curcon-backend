package nl.hu.curcon.dto;

import java.util.List;

/**
 * @author berend.wilkens
 *
 */
public class ToetsDto extends HRefDto {
    private int id;
    private String naam;
    private double gewicht;
    private String omschrijving;
    private LinkDto millerNiveau;
    private List<BeoordelingsElementDto> beoordelingsElementen;
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
	public double getGewicht() {
		return gewicht;
	}
	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}
	public List<BeoordelingsElementDto> getBeoordelingsElementen() {
		return beoordelingsElementen;
	}
	public void setBeoordelingsElementen(List<BeoordelingsElementDto> beoordelingsElementen) {
		this.beoordelingsElementen = beoordelingsElementen;
	}
	public LinkDto getMillerNiveau() {
		return millerNiveau;
	}
	public void setMillerNiveau(LinkDto millerNiveau) {
		this.millerNiveau = millerNiveau;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
}
