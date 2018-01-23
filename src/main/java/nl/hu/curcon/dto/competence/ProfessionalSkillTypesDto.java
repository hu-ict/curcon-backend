package nl.hu.curcon.dto.competence;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalSkillTypesDto {
	private List<ActiviteitDto> activiteiten = new ArrayList<>();
	private List<String> niveaus = new ArrayList<>();
	
	public List<ActiviteitDto> getActiviteiten() {
		return activiteiten;
	}
	public void setActiviteiten(List<ActiviteitDto> activiteiten) {
		this.activiteiten = activiteiten;
	}
	public List<String> getNiveaus() {
		return niveaus;
	}
	public void setNiveaus(List<String> niveaus) {
		this.niveaus = niveaus;
	}

}
