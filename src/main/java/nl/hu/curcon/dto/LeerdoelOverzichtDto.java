package nl.hu.curcon.dto;

/**
 * @author berend.wilkens, 5 jun. 2017
 */
public class LeerdoelOverzichtDto extends HRefDto {
	private int id;
	private int periodeCursus;
	private double ectsGewicht;
	private String omschrijving;
	private LinkDto beroepsTaak;
	private LinkDto professionalSkill;
	private LinkDto bloomniveau;
	private LinkDto cursus;
	private LinkDto trefwoord;

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

	public int getPeriodeCursus() {
		return periodeCursus;
	}

	public void setPeriodeCursus(int periodeCursus) {
		this.periodeCursus = periodeCursus;
	}

	public LinkDto getCursus() {
		return cursus;
	}

	public void setCursus(LinkDto cursus) {
		this.cursus = cursus;
	}

	public LinkDto getBeroepsTaak() {
		return beroepsTaak;
	}

	public void setBeroepsTaak(LinkDto beroepsTaak) {
		this.beroepsTaak = beroepsTaak;
	}

	public LinkDto getProfessionalSkill() {
		return professionalSkill;
	}

	public void setProfessionalSkill(LinkDto professionalSkill) {
		this.professionalSkill = professionalSkill;
	}

	public double getEctsGewicht() {
		return ectsGewicht;
	}

	public void setEctsGewicht(double ectsGewicht) {
		this.ectsGewicht = ectsGewicht;
	}

}
