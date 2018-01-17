package nl.hu.curcon.dto.check;

import java.util.List;

import nl.hu.curcon.dto.HRefDto;
import nl.hu.curcon.dto.LinkDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;

public class ProfielDto extends HRefDto {
	private String naam;
	private int ects;
	private List<ConformiteitBeroepsTaakDto> conformiteitBeroepsTaken;
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
	public List<ProfessionalSkillDto> getEindPS() {
		return eindPS;
	}
	public void setEindPS(List<ProfessionalSkillDto> eindPS) {
		this.eindPS = eindPS;
	}
	public List<ConformiteitBeroepsTaakDto> getConformiteitBeroepsTaken() {
		return conformiteitBeroepsTaken;
	}
	public void setConformiteitBeroepsTaken(List<ConformiteitBeroepsTaakDto> conformiteitBeroepsTaken) {
		this.conformiteitBeroepsTaken = conformiteitBeroepsTaken;
	}
}
