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
    private LinkDto millerNiveau;
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
	public List<ToetsMatrijsBeoordelingsElementDto> getBeoordelingsElementen() {
		return beoordelingsElementen;
	}
	public void setBeoordelingsElementen(List<ToetsMatrijsBeoordelingsElementDto> beoordelingsElementen) {
		this.beoordelingsElementen = beoordelingsElementen;
	}
	public LinkDto getMillerNiveau() {
		return millerNiveau;
	}
	public void setMillerNiveau(LinkDto millerNiveau) {
		this.millerNiveau = millerNiveau;
	}

}
