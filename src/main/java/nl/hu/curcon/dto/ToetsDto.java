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
    private LinkDto osirisResultaatType;
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
	public LinkDto getOsirisResultaatType() {
		return osirisResultaatType;
	}
	public void setOsirisResultaatType(LinkDto osirisResultaatType) {
		this.osirisResultaatType = osirisResultaatType;
	}
	public List<BeoordelingsElementDto> getBeoordelingsElementen() {
		return beoordelingsElementen;
	}
	public void setBeoordelingsElementen(List<BeoordelingsElementDto> beoordelingsElementen) {
		this.beoordelingsElementen = beoordelingsElementen;
	}

}
