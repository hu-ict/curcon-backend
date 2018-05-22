package nl.hu.curcon.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author berend.wilkens, 25 aug. 2017
 */
@XmlRootElement
public class ToetsMatrijsBeoordelingsElementDto extends HRefDto {
    private int id;
    private String naam;
    private String omschrijving;
    private int gewicht;

    public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
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

    public int getId() {
        return id;
    }

}
