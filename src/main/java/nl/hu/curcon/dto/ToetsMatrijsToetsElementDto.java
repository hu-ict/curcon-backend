package nl.hu.curcon.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author berend.wilkens, 24 mrt. 2017
 * ToetsMatrijsToetsElementDto
 */
@XmlRootElement
public class ToetsMatrijsToetsElementDto extends HRefDto {
    private int id;
    private double gewicht;
    private IdLinkDto beoordelingsElement;
    private LinkDto bloomniveau;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGewicht() {
		return gewicht;
	}
	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}
	public IdLinkDto getBeoordelingsElement() {
		return beoordelingsElement;
	}
	public void setBeoordelingsElement(IdLinkDto beoordelingsElement) {
		this.beoordelingsElement = beoordelingsElement;
	}
	public LinkDto getBloomniveau() {
		return bloomniveau;
	}
	public void setBloomniveau(LinkDto bloomniveau) {
		this.bloomniveau = bloomniveau;
	}
}
