package nl.hu.curcon.dto.competence;

/**
 * @author berend.wilkens, 6 sep. 2017
 */
public class Werkveld {

	private int id;
	private String architectuurlaag;
	private int architectuurlaagId;
	private String activiteit;
	private int activiteitId;
	private String omschrijving;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArchitectuurlaag() {
		return architectuurlaag;
	}

	public void setArchitectuurlaag(String architectuurlaag) {
		this.architectuurlaag = architectuurlaag;
	}

	public String getActiviteit() {
		return activiteit;
	}

	public void setActiviteit(String activiteit) {
		this.activiteit = activiteit;
	}

	public int getArchitectuurlaagId() {
		return architectuurlaagId;
	}

	public void setArchitectuurlaagId(int architectuurlaagId) {
		this.architectuurlaagId = architectuurlaagId;
	}

	public int getActiviteitId() {
		return activiteitId;
	}

	public void setActiviteitId(int activiteitId) {
		this.activiteitId = activiteitId;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
}
