package nl.hu.curcon.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.hu.curcon.dao.CohortDao;
import nl.hu.curcon.dao.CursusDao;
import nl.hu.curcon.domain.BeroepsTaak;
import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.ProfessionalSkill;
import nl.hu.curcon.dto.LeerdoelOverzichtDto;
import nl.hu.curcon.dto.LeerplanSchemaDto;
import nl.hu.curcon.dto.ProfessionalSkillDto;
import nl.hu.curcon.dto.ProfielDto;
import nl.hu.curcon.dto.check.EctsGewichtNiveauDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Domain2DtoMapperLeerplanSchema;
import nl.hu.curcon.service.LeerplanSchemaService;
import nl.hu.curcon.service.ToetsProgrammaService;

@Component
public class LeerplanSchemaServiceImpl implements LeerplanSchemaService {

	@Autowired
	ToetsProgrammaService toetsProgrammaService;
	@Autowired
	CohortDao cohortDao;
	@Autowired
	CursusDao cursusDao;
	@Autowired
	Domain2DtoMapperLeerplanSchema domain2DtoMapperLeerplanSchema;

	Logger logger = LoggerFactory.getLogger(LeerplanSchemaServiceImpl.class);

	@Override
	public LeerplanSchemaDto find(int cohortId) {
		Cohort co = cohortDao.find(cohortId);
		LeerplanSchemaDto leerplanSchemaDto = domain2DtoMapperLeerplanSchema.mapLeerplanSchema(co);
		return leerplanSchemaDto;
	}

	@Override
	public List<LeerdoelOverzichtDto> findLeerdoelenByCohortAndBeroepsTaak(int cohortId, int activiteitId,
			int architectuurlaagId) {
		List<LeerdoelOverzichtDto> leerdoelDtos = new ArrayList<>();
		List<Leerdoel> leerdoelen = cohortDao.findLeerdoelen(cohortId, activiteitId, architectuurlaagId);
		for (Leerdoel leerdoel : leerdoelen) {
			leerdoelDtos.add(domain2DtoMapperLeerplanSchema.mapLeerdoelOverzicht(leerdoel));
		}
		return leerdoelDtos;
	}

	@Override
	public Map<Integer, Map<Integer, EctsGewichtNiveauDto>> calcEctsGewichtByCohortAndBeroepsTaak(int cohortId,
			int activiteitId, int architectuurlaagId) {
		List<Leerdoel> leerdoelen = cohortDao.findLeerdoelen(cohortId, activiteitId, architectuurlaagId);
		Map<Integer, Map<Integer, EctsGewichtNiveauDto>> perioden = new HashMap<>();
		for (int periode = 1; periode <= 16; periode++) {
			Map<Integer, EctsGewichtNiveauDto> niveaus = new HashMap<>();
			for (int niveau = 1; niveau <= 3; niveau++) {
				EctsGewichtNiveauDto ectsGewichtNiveauDto = new EctsGewichtNiveauDto();
				ectsGewichtNiveauDto.setNiveau(niveau);
				ectsGewichtNiveauDto.setCumulatiefEctsGewicht(0);
				niveaus.put(niveau, ectsGewichtNiveauDto);
			}
			perioden.put(periode, niveaus);
		}

		for (Leerdoel leerdoel : leerdoelen) {
			double ectsGewicht = leerdoel.getGewicht() * leerdoel.getCursus().getEuropeanCredits() / 100;
			logger.info("ectsGewicht " + ectsGewicht);
			logger.info("leerdoel.getCursus().getPeriode() " + leerdoel.getCursus().getPeriode());
			Map<Integer, EctsGewichtNiveauDto> periode = perioden.get(leerdoel.getCursus().getPeriode());
			logger.info("periode " + periode);
			logger.info("leerdoel.getBeroepsTaak().getNiveau() " + leerdoel.getBeroepsTaak().getNiveau());
			EctsGewichtNiveauDto ectsGewichtNiveauDto = periode.get(leerdoel.getBeroepsTaak().getNiveau());
			logger.info("ectsGewichtNiveauDto " + ectsGewichtNiveauDto);
			ectsGewichtNiveauDto.addEctsGewicht(ectsGewicht);
		}
		return perioden;
	}

	@Override
	public ProfielDto getCalcProfile(int cohortId) {
		ProfielDto profileDto = new ProfielDto();
		Cohort cohort = cohortDao.find(cohortId);
		int ects = 0;
		List<BeroepsTaak> beroepsTaken = new ArrayList<>();
		List<ProfessionalSkill> professionalSkills = new ArrayList<>();
		for (Cursus cursus : cohort.getCursussen()) {
			ects = ects + cursus.getEuropeanCredits();
			for (BeroepsTaak beroepsTaak : cursus.getEindBTs()) {
				// beroepsTaken.add(beroepsTaak);
				beroepsTaken = addBeroepsTaak(beroepsTaken, beroepsTaak);
			}
			for (ProfessionalSkill professionalSkill : cursus.getEindPSs()) {
				professionalSkills = addProfessionalSkill(professionalSkills, professionalSkill);
			}
		}
		profileDto.setNaam(cohort.getOpleidingsProfiel().getNaam() + " (" + cohort.getJaar() + ")");
		profileDto.setEcts(ects);

		profileDto.setConformiteitBeroepsTaken(toetsProgrammaService.calcProfile(cohortId));

		profileDto.setEindPS(new ArrayList<ProfessionalSkillDto>());
		for (ProfessionalSkill professionalSkill : professionalSkills) {
			profileDto.getEindPS().add(Domain2DtoMapper.map(professionalSkill));
		}

		return profileDto;

	}

	private List<BeroepsTaak> addBeroepsTaak(List<BeroepsTaak> beroepsTaken, BeroepsTaak beroepsTaakNew) {
		if (beroepsTaken.size() == 0) {
			beroepsTaken.add(beroepsTaakNew);
			return beroepsTaken;
		}
		for (BeroepsTaak beroepsTaakIter : beroepsTaken) {
			if (beroepsTaakNew.getActiviteit().getId() == beroepsTaakIter.getActiviteit().getId()
					&& beroepsTaakNew.getArchitectuurlaag().getId() == beroepsTaakIter.getArchitectuurlaag().getId()) {
				if (beroepsTaakNew.getNiveau() > beroepsTaakIter.getNiveau()) {
					beroepsTaken.remove(beroepsTaakIter);
					beroepsTaken.add(beroepsTaakNew);
					return beroepsTaken;
				}
			} else {
				beroepsTaken.add(beroepsTaakNew);
				return beroepsTaken;
			}
		}
		return beroepsTaken;
	}

	private List<ProfessionalSkill> addProfessionalSkill(List<ProfessionalSkill> professionalSkills,
			ProfessionalSkill professionalSkillNew) {
		if (professionalSkills.size() == 0) {
			professionalSkills.add(professionalSkillNew);
			return professionalSkills;
		}
		for (ProfessionalSkill professionalSkillIter : professionalSkills) {
			if (professionalSkillNew.getActiviteit().getId() == professionalSkillIter.getActiviteit().getId()) {
				if (professionalSkillNew.getNiveau().equals("P") && professionalSkillIter.getNiveau().equals("T")) {
					professionalSkills.remove(professionalSkillIter);
					professionalSkills.add(professionalSkillNew);
					return professionalSkills;
				}
				if (professionalSkillNew.getNiveau().equals("S") && (professionalSkillIter.getNiveau().equals("T")
						|| professionalSkillIter.getNiveau().equals("P"))) {
					professionalSkills.remove(professionalSkillIter);
					professionalSkills.add(professionalSkillNew);
					return professionalSkills;
				}
			} else {
				professionalSkills.add(professionalSkillNew);
				return professionalSkills;
			}
		}
		return professionalSkills;
	}

	@Override
	public List<String> checkProfiel(int cohortId) {
		List<String> opmerkingen = new ArrayList<>();
		Cohort cohort = cohortDao.find(cohortId);
		if (cohort.getOpleidingsProfiel().getEindBTs().size() == 0) {
			opmerkingen.add(
					"[" + cohort.getOpleidingsProfiel().getNaam() + "] Opleiding heeft geen gekoppelde beroepstaken.");
		} else {
			int niveau1 = 0;
			int niveau2 = 0;
			int niveau3 = 0;
			for (BeroepsTaak beroepsTaak : cohort.getOpleidingsProfiel().getEindBTs()) {
				switch (beroepsTaak.getNiveau()) {
				case 1:
					niveau1++;
					break;
				case 2:
					niveau2++;
					break;
				case 3:
					niveau3++;
					break;
				}
			}
			if (niveau1 < 2) {
				opmerkingen.add(
						"[" + cohort.getOpleidingsProfiel().getNaam() + "] Opleiding heeft minder ("+niveau1+") dan 7 beroepstaken op niveau 1.");
			}
			if (niveau2 < 4) {
				opmerkingen.add(
						"[" + cohort.getOpleidingsProfiel().getNaam() + "] Opleiding heeft minder ("+niveau2+") dan 4 beroepstaken op niveau 2.");
			}
			if (niveau3 < 2) {
				opmerkingen.add(
						"[" + cohort.getOpleidingsProfiel().getNaam() + "] Opleiding heeft minder ("+niveau3+") dan 2 beroepstaken op niveau 3.");
			}
		}
		if (cohort.getCursussen().size() == 0) {
			opmerkingen.add("[" + cohort.getJaar() + "] Profiel heeft geen gekoppelde cursussen.");
		} else {
			int totaalEcts = 0;
			for (Cursus cursus : cohort.getCursussen()) {
				totaalEcts += cursus.getEuropeanCredits();
			}
			if (totaalEcts < 240) {
				opmerkingen.add("[" + cohort.getJaar() + "] Het opleidingsprofiel heeft minder (" + totaalEcts
						+ ") dan 240 ects");
			}
			
		}
		
		if (cohort.getOpleidingsProfiel().getEindBTs().size() > 0 && cohort.getCursussen().size() > 0) {
			for (BeroepsTaak beroepsTaakOpleiding : cohort.getOpleidingsProfiel().getEindBTs()) {
				boolean found = false;
				for (Cursus cursus : cohort.getCursussen()) {
					for (BeroepsTaak beroepsTaakCursus : cursus.getEindBTs()) {
						if (beroepsTaakOpleiding.equals(beroepsTaakCursus)) {
							found = true;
							break;
						}
					}
					if (found) {
						break;
					}
				}
				if (!found) {
					opmerkingen.add("[" + cohort.getOpleidingsProfiel().getNaam() + "] In opleiding wordt beroepstaak (" + beroepsTaakOpleiding
							+ ") niet aan een cursus toegewezen");
				}
			}
		}

	return opmerkingen;
}

}
