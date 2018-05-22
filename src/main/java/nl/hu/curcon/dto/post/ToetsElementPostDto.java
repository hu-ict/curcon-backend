package nl.hu.curcon.dto.post;

/**
 * @author berend.wilkens, 23 mei 2017
 */
public class ToetsElementPostDto  {
    private double gewicht;
    private int beoordelingsElement;
	public double getGewicht() {
		return gewicht;
	}
	public void setGewicht(double gewicht) {
		this.gewicht = gewicht;
	}
	public int getBeoordelingsElement() {
		return beoordelingsElement;
	}
	public void setBeoordelingsElement(int beoordelingsElement) {
		this.beoordelingsElement = beoordelingsElement;
	}
}
