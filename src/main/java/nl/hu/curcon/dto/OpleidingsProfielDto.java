package nl.hu.curcon.dto;

/**
 * @author berend.wilkens, 23 mrt. 2017
 * OpleidingsProfielDto
 */
public class OpleidingsProfielDto extends HRefDto {
	private int id;
	private String naam;
	private HRefDto cohorten;
	private HRefDto leerlijnen;
	private HRefDto eindPS;
	private HRefDto eindBT;

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

	public HRefDto getCohorten() {
		return cohorten;
	}

	public void setCohorten(HRefDto cohorten) {
		this.cohorten = cohorten;
	}

	public HRefDto getLeerlijnen() {
		return leerlijnen;
	}

	public void setLeerlijnen(HRefDto leerlijnen) {
		this.leerlijnen = leerlijnen;
	}

	public HRefDto getEindPS() {
		return eindPS;
	}

	public void setEindPS(HRefDto eindPS) {
		this.eindPS = eindPS;
	}

	public HRefDto getEindBT() {
		return eindBT;
	}

	public void setEindBT(HRefDto eindBT) {
		this.eindBT = eindBT;
	}

}
