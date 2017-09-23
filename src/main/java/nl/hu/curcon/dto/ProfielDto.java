package nl.hu.curcon.dto;

import java.util.List;

public class ProfielDto extends HRefDto {
	private String naam;
	private int ects;
	private List<BeroepsTaakDto> eindBT;
	private List<ProfessionalSkillDto> eindPS;
	private List<LinkDto> leerlijnen;
	
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects = ects;
	}
	public List<LinkDto> getLeerlijnen() {
		return leerlijnen;
	}
	public void setLeerlijnen(List<LinkDto> leerlijnen) {
		this.leerlijnen = leerlijnen;
	}
	public List<BeroepsTaakDto> getEindBT() {
		return eindBT;
	}
	public void setEindBT(List<BeroepsTaakDto> eindBT) {
		this.eindBT = eindBT;
	}
	public List<ProfessionalSkillDto> getEindPS() {
		return eindPS;
	}
	public void setEindPS(List<ProfessionalSkillDto> eindPS) {
		this.eindPS = eindPS;
	}
}
