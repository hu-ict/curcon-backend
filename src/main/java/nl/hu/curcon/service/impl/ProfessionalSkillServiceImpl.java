package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dao.ProfessionalSkillDao;
import nl.hu.curcon.domain.ProfessionalSkill;
import nl.hu.curcon.dto.ActiviteitDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillTypesDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.service.ProfessionalSkillService;

/**
 * @author berend.wilkens
 *
 */
@Service
public class ProfessionalSkillServiceImpl extends GenericService implements ProfessionalSkillService {
	@Autowired
	private ProfessionalSkillDao professionalSkillDao;

	@Override
	public ProfessionalSkillDto create(ProfessionalSkillDto professionalSkillDto) {
		ProfessionalSkill professionalSkill = dto2DomainMapper.map(professionalSkillDto);
		return Domain2DtoMapper.map(professionalSkillDao.save(professionalSkill));
	}

	@Override
	public void delete(int id) {
		professionalSkillDao.delete(id);
	}

	@Override
	public ProfessionalSkillDto update(ProfessionalSkillDto professionalSkillDto) {
		ProfessionalSkill professionalSkill = dto2DomainMapper.map(professionalSkillDto);
		return Domain2DtoMapper.map(professionalSkillDao.update(professionalSkill));
	}

	@Override
	public ProfessionalSkillDto find(int id) {
		ProfessionalSkill d = professionalSkillDao.find(id);
		return Domain2DtoMapper.map(d);
	}

	@Override
	public List<ProfessionalSkillDto> findAll() {
		List<ProfessionalSkillDto> dtos = new ArrayList<ProfessionalSkillDto>();
		List<ProfessionalSkill> professionalSkills = professionalSkillDao.findAll();
		for (ProfessionalSkill d : professionalSkills) {
			dtos.add(Domain2DtoMapper.map(d));
		}
		return dtos;
	}

	@Override
	public ProfessionalSkillTypesDto findTypes() {
		ProfessionalSkillTypesDto professionalSkillTypesDto = new ProfessionalSkillTypesDto();
		// professionalSkillTypesDto.getActiviteiten().add(new ActiviteitDto(1,
		// "Leiderschap", "neem initiatief en vervul een leidende rol in een
		// team om de gestelde doelen te bereiken."));
		// professionalSkillTypesDto.getActiviteiten().add(new ActiviteitDto(2,
		// "Samenwerken", "draag actief bij aan het product of het resultaat van
		// het team."));
		// professionalSkillTypesDto.getActiviteiten().add(new ActiviteitDto(3,
		// "Planning en organisatie", "plan, beheers en evalueer het individuele
		// en het team-werk. Gebruik geschikte methodes om het eigen gedrag te
		// monitoren."));
		// professionalSkillTypesDto.getActiviteiten().add(new ActiviteitDto(4,
		// "Communicatie:", "Communicatie: spreek en schrijf vloeiend en correct
		// Nederlands [niveau: C1 - C2] en Engels [B2], zowel in gesproken als
		// geschreven taal. Neem deel aan vergaderingen, voer gesprekken, maak
		// project- documentatie, schrijf klantrapporten, houd presentaties en
		// maak bij de communicatie gebruik van relevante visuele ondersteuning.
		// Weet wanneer formeel en informeel taalgebruik gepast is."));
		// professionalSkillTypesDto.getActiviteiten().add(new ActiviteitDto(5,
		// "Analyse en informatieverwerking", "mobiliseer kennis rond een
		// kwestie; formuleer hierover hoofd- en deelvragen, kies en pas
		// geschikte onderzoeksmethoden toe; genereer, verzamel en analyseer
		// gegevens zorgvuldig en nauwkeurig; lever antwoorden op die samenhang
		// vertonen en taal- en rekenkundig kloppen."));
		// professionalSkillTypesDto.getActiviteiten().add(new ActiviteitDto(6,
		// "Creatief problemen oplossen", "Ontwikkel systematisch de aanpak van
		// een kwestie, gebruik hierbij (wetenschappelijk) onderbouwde methoden
		// èn creativiteit, werk vakkundig en evalueer (tussen)resultaten aan de
		// hand van kwaliteitscriteria."));
		// professionalSkillTypesDto.getActiviteiten().add(new ActiviteitDto(7,
		// "Leren en persoonlijke ontwikkeling", "Ken de eigen grenzen en de
		// sterke en zwakke kanten en ontwikkel jezelf door zelfreflectie en
		// zelfbeoordeling van de eigen (leer)resultaten. Neem
		// verantwoordelijkheid voor de eigen activiteiten, accepteer kritiek
		// van anderen en maak er goed gebruik van. Neem initiatief en werk
		// zelfstandig"));
		// professionalSkillTypesDto.getActiviteiten().add(new ActiviteitDto(8,
		// "Verantwoordelijkheid en zelfstandigheid", "Laat maatschappelijke,
		// normatieve en ethische aspecten meewegen in de oordeels- en
		// besluitvorming in de beroepspraktijk. Draagt verantwoordelijkheid
		// voor de eigen handelingen. Zorg dat jouw gedrag passend is binnen de
		// waarden, normen, cultuur, behoeften, prioriteiten en doelstellingen
		// van de organisatie en maatschappij waarin je werk en leeft."));

		professionalSkillTypesDto.getActiviteiten()
				.add(new ActiviteitDto(6, "LPO", "Leren & Persoonlijke Ontwikkeling"));
		professionalSkillTypesDto.getActiviteiten()
				.add(new ActiviteitDto(7, "OD", "Onderzoek doen"));
		professionalSkillTypesDto.getActiviteiten()
				.add(new ActiviteitDto(8, "LSC", "Leiderschap, Samenwerken, Communicatie"));
		professionalSkillTypesDto.getActiviteiten()
				.add(new ActiviteitDto(9, "POKe", "Planning, Organisatie, Kwaliteitsbewustzijn & Ethiek"));
		professionalSkillTypesDto.getActiviteiten()
				.add(new ActiviteitDto(10, "LPO", "Leren & Persoonlijke Ontwikkeling"));
		professionalSkillTypesDto.getNiveaus().add("T");
		professionalSkillTypesDto.getNiveaus().add("P");
		professionalSkillTypesDto.getNiveaus().add("S");

		return professionalSkillTypesDto;
	}

	@Override
	public ProfessionalSkillDto find(int activiteitId, String niveau) {
		ProfessionalSkill professionalSkill = professionalSkillDao.find(activiteitId, niveau);
		return Domain2DtoMapper.map(professionalSkill);
	}

}
