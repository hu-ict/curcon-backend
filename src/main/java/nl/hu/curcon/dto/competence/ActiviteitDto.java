package nl.hu.curcon.dto.competence;

public class ActiviteitDto {
	private int id;
	private String naam;
	private String omschrijving;

	public ActiviteitDto() {
		super();
	};

	public ActiviteitDto(int id, String naam, String omschrijving) {
		this.id = id;
		this.naam = naam;
		this.omschrijving = omschrijving;
	};

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

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

}
