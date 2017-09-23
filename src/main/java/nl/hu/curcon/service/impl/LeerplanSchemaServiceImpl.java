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
import nl.hu.curcon.dto.BeroepsTaakDto;
import nl.hu.curcon.dto.EctsGewichtNiveauDto;
import nl.hu.curcon.dto.LeerdoelOverzichtDto;
import nl.hu.curcon.dto.LeerplanSchemaDto;
import nl.hu.curcon.dto.ProfessionalSkillDto;
import nl.hu.curcon.dto.ProfielDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Domain2DtoMapperLeerplanSchema;
import nl.hu.curcon.service.LeerplanSchemaService;

@Component
public class LeerplanSchemaServiceImpl implements LeerplanSchemaService {

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
	public Map<Integer, Map<Integer, EctsGewichtNiveauDto>> calcEctsGewichtByCohortAndBeroepsTaak(int cohortId, int activiteitId,
			int architectuurlaagId) {
		List<Leerdoel> leerdoelen = cohortDao.findLeerdoelen(cohortId, activiteitId, architectuurlaagId);
		Map<Integer, Map<Integer, EctsGewichtNiveauDto>> perioden = new HashMap<>();
		for (int periode=1;periode<=16;periode++) {
			Map<Integer, EctsGewichtNiveauDto> niveaus = new HashMap<>();
			for (int niveau=1;niveau<=3;niveau++) {
				EctsGewichtNiveauDto ectsGewichtNiveauDto = new EctsGewichtNiveauDto();
				ectsGewichtNiveauDto.setNiveau(niveau);
				ectsGewichtNiveauDto.setCumulatiefEctsGewicht(0);
				niveaus.put(niveau, ectsGewichtNiveauDto);
			}
			perioden.put(periode, niveaus);
		}
		
		for (Leerdoel leerdoel : leerdoelen) {
			double ectsGewicht = leerdoel.getGewicht() * leerdoel.getCursus().getEuropeanCredits()/100;
			logger.info("ectsGewicht "+ ectsGewicht);
			logger.info("leerdoel.getCursus().getPeriode() "+ leerdoel.getCursus().getPeriode());
			Map<Integer, EctsGewichtNiveauDto> periode = perioden.get(leerdoel.getCursus().getPeriode());
			logger.info("periode "+ periode);
			logger.info("leerdoel.getBeroepsTaak().getNiveau() "+leerdoel.getBeroepsTaak().getNiveau());
			EctsGewichtNiveauDto ectsGewichtNiveauDto = periode.get(leerdoel.getBeroepsTaak().getNiveau());
			logger.info("ectsGewichtNiveauDto "+ ectsGewichtNiveauDto);
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
//				beroepsTaken.add(beroepsTaak);
				beroepsTaken = addBeroepsTaak(beroepsTaken, beroepsTaak);
			}
			for (ProfessionalSkill professionalSkill : cursus.getEindPSs()) {
				professionalSkills = addProfessionalSkill(professionalSkills, professionalSkill);
			}
		}
		profileDto.setNaam(cohort.getOpleidingsProfiel().getNaam() + " (" + cohort.getJaar() + ")");
		profileDto.setEcts(ects);

		profileDto.setEindBT(new ArrayList<BeroepsTaakDto>());
		for (BeroepsTaak beroepsTaak : beroepsTaken) {
			profileDto.getEindBT().add(Domain2DtoMapper.map(beroepsTaak));
		}

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
				if (professionalSkillNew.getNiveau().equals("P")
						&& professionalSkillIter.getNiveau().equals("T")) {
					professionalSkills.remove(professionalSkillIter);
					professionalSkills.add(professionalSkillNew);
					return professionalSkills;
				}
				if (professionalSkillNew.getNiveau().equals("S")
						&& (professionalSkillIter.getNiveau().equals("T") || professionalSkillIter.getNiveau().equals("P"))) {
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

}
