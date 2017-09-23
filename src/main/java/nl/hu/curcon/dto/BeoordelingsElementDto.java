package nl.hu.curcon.dto;

import javax.xml.bind.annotation.XmlType;

/**
 * @author berend.wilkens, 24 mrt. 2017
 */
@XmlType(propOrder={"id", "hRef"})
public class BeoordelingsElementDto extends HRefDto {
    private int id;
    private String naam;
    private String omschrijving;
    private int gewicht;
	private HRefDto toetsElementen;

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

    public int getGewicht() {
		return gewicht;
	}

	public void setGewicht(int gewicht) {
		this.gewicht = gewicht;
	}

	public HRefDto getToetsElementen() {
		return toetsElementen;
	}

	public void setToetsElementen(HRefDto hRefDto) {
		this.toetsElementen = hRefDto;
	}


}
