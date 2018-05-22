package nl.hu.curcon.dto;

/**
 * @author berend.wilkens, 30 apr. 2017
 */
public class OrganisatieDto extends HRefDto {
    private int id;
    private String naam;
    private HRefDto opleidingsProfielen;
    private HRefDto cursussen;
    private HRefDto docenten;
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
	public HRefDto getOpleidingsProfielen() {
		return opleidingsProfielen;
	}
	public void setOpleidingsProfielen(HRefDto opleidingsProfielen) {
		this.opleidingsProfielen = opleidingsProfielen;
	}
	public HRefDto getCursussen() {
		return cursussen;
	}
	public void setCursussen(HRefDto cursussen) {
		this.cursussen = cursussen;
	}
	public HRefDto getDocenten() {
		return docenten;
	}
	public void setDocenten(HRefDto docenten) {
		this.docenten = docenten;
	}
}
