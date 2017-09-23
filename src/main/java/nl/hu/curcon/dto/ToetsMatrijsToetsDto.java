package nl.hu.curcon.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author berend.wilkens
 *
 */
@XmlRootElement
public class ToetsMatrijsToetsDto extends HRefDto {
    private int id;
    private String naam;
    private double gewicht;
    private LinkDto osirisResultaatType;
    private List<ToetsMatrijsBeoordelingsElementDto> beoordelingsElementen;
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
	public List<ToetsMatrijsBeoordelingsElementDto> getBeoordelingsElementen() {
		return beoordelingsElementen;
	}
	public void setBeoordelingsElementen(List<ToetsMatrijsBeoordelingsElementDto> beoordelingsElementen) {
		this.beoordelingsElementen = beoordelingsElementen;
	}

}
