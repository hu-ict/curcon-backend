package nl.hu.curcon.dto;

/**
 * @author berend.wilkens, 5 jun. 2017
 */
public class LeerdoelDto extends HRefDto {
	private int id;
	private String naam;
	private String omschrijving;
	private double gewicht;
	private LinkDto eindBT;
	private LinkDto eindPS;
	private LinkDto bloomniveau;
	private LinkDto trefwoord;
	private HRefDto toetsElementen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public LinkDto getEindBT() {
		return eindBT;
	}

	public void setEindBT(LinkDto eindBT) {
		this.eindBT = eindBT;
	}

	public LinkDto getEindPS() {
		return eindPS;
	}

	public void setEindPS(LinkDto eindPS) {
		this.eindPS = eindPS;
	}

	public LinkDto getBloomniveau() {
		return bloomniveau;
	}

	public void setBloomniveau(LinkDto bloomniveau) {
		this.bloomniveau = bloomniveau;
	}

	public LinkDto getTrefwoord() {
		return trefwoord;
	}

	public void setTrefwoord(LinkDto trefwoord) {
		this.trefwoord = trefwoord;
	}

	public HRefDto getToetsElementen() {
		return toetsElementen;
	}

	public void setToetsElementen(HRefDto toetsElementen) {
		this.toetsElementen = toetsElementen;
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

}
