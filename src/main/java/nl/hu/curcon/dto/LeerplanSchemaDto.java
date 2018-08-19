package nl.hu.curcon.dto;

import java.util.List;

import nl.hu.curcon.dto.competence.BeroepsTaakDto;

/**
 * @author berend.wilkens
 *
 */
public class LeerplanSchemaDto extends HRefDto {
	private int id;
	private String naam;
	private String cohort;
	private List<LinkDto> leerlijnen;
	private List<LinkDto> eindPS;
	private List<BeroepsTaakDto> eindBT;
	private List<CursusLeerplanSchemaDto> cursussen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<CursusLeerplanSchemaDto> getCursussen() {
		return cursussen;
	}

	public void setCursussen(List<CursusLeerplanSchemaDto> cursussen) {
		this.cursussen = cursussen;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getCohort() {
		return cohort;
	}

	public void setCohort(String cohort) {
		this.cohort = cohort;
	}

	public List<LinkDto> getLeerlijnen() {
		return leerlijnen;
	}

	public void setLeerlijnen(List<LinkDto> leerlijnen) {
		this.leerlijnen = leerlijnen;
	}

	public List<LinkDto> getEindPS() {
		return eindPS;
	}

	public void setEindPS(List<LinkDto> eindPS) {
		this.eindPS = eindPS;
	}

	public List<BeroepsTaakDto> getEindBT() {
		return eindBT;
	}

	public void setEindBT(List<BeroepsTaakDto> eindBT) {
		this.eindBT = eindBT;
	}
}
