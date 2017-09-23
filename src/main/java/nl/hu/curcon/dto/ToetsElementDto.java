package nl.hu.curcon.dto;

/**
 * @author berend.wilkens, 1 jun. 2017
 */
public class ToetsElementDto extends HRefDto {
    private int id;
    private double gewicht;
    private LinkDto beoordelingsElement;
    private LinkDto leerdoel;
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
	public LinkDto getBeoordelingsElement() {
		return beoordelingsElement;
	}
	public void setBeoordelingsElement(LinkDto beoordelingsElement) {
		this.beoordelingsElement = beoordelingsElement;
	}
	public LinkDto getLeerdoel() {
		return leerdoel;
	}
	public void setLeerdoel(LinkDto leerdoel) {
		this.leerdoel = leerdoel;
	}

}
