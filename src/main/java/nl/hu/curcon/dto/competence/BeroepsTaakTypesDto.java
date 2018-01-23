package nl.hu.curcon.dto.competence;

import java.util.ArrayList;
import java.util.List;

public class BeroepsTaakTypesDto {
	private List<ArchitectuurLaagDto> architectuurLagen = new ArrayList<>();
	private List<ActiviteitDto> activiteiten = new ArrayList<>();
	private List<Integer> niveaus = new ArrayList<>();

	public List<ArchitectuurLaagDto> getArchitectuurLagen() {
		return architectuurLagen;
	}

	public void setArchitectuurLagen(List<ArchitectuurLaagDto> architectuurLagen) {
		this.architectuurLagen = architectuurLagen;
	}

	public List<ActiviteitDto> getActiviteiten() {
		return activiteiten;
	}

	public void setActiviteiten(List<ActiviteitDto> activiteiten) {
		this.activiteiten = activiteiten;
	}

	public List<Integer> getNiveaus() {
		return niveaus;
	}

	public void setNiveaus(List<Integer> niveaus) {
		this.niveaus = niveaus;
	}



}