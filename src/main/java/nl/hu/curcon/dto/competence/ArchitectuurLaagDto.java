package nl.hu.curcon.dto.competence;

public class ArchitectuurLaagDto {
	private int id;
	private String naam;
	private String omschrijving;

	public ArchitectuurLaagDto() {
		super();
	};

	public ArchitectuurLaagDto(int id, String naam, String omschrijving) {
		this.id = id;
		this.naam = naam;
		this.setOmschrijving(omschrijving);
	};

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

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

}
