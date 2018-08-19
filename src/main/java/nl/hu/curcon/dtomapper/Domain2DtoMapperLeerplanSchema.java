package nl.hu.curcon.dtomapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.ProfessionalSkill;
import nl.hu.curcon.domain.hboi.BeroepsTaak;
import nl.hu.curcon.dto.CursusLeerplanSchemaDto;
import nl.hu.curcon.dto.LeerdoelOverzichtDto;
import nl.hu.curcon.dto.LeerplanSchemaDto;
import nl.hu.curcon.dto.LinkDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;

/**
 * @author berend.wilkens
 *
 */
@Component
public class Domain2DtoMapperLeerplanSchema {
	public LeerplanSchemaDto mapLeerplanSchema(Cohort cohort) {
		LeerplanSchemaDto dto = new LeerplanSchemaDto();
		dto.setId(cohort.getId());
		dto.setCohort(cohort.getJaar());
		dto.setNaam(cohort.getOpleidingsProfiel().getNaam());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(cohort));

		dto.setEindBT(new ArrayList<BeroepsTaakDto>());
		for (BeroepsTaak beroepsTaak : cohort.getOpleidingsProfiel().getEindBTs()) {
			dto.getEindBT().add(Domain2DtoMapper.map(beroepsTaak));
		}

		dto.setEindPS(new ArrayList<LinkDto>());
		for (ProfessionalSkill ps : cohort.getOpleidingsProfiel().getEindPSs()) {
			dto.getEindPS().add(Domain2DtoMapperLink.mapLink(ps));
		}

		dto.setCursussen(new ArrayList<CursusLeerplanSchemaDto>());
		for (Cursus cursus : cohort.getCursussen()) {
			dto.getCursussen().add(mapLeerplanSchema(cursus));
		}
		return dto;
	}
	
	public LeerdoelOverzichtDto mapLeerdoelOverzicht(Leerdoel leerdoel) {
		LeerdoelOverzichtDto dto = new LeerdoelOverzichtDto();
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(leerdoel));
		dto.setId(leerdoel.getId());
		dto.setOmschrijving(leerdoel.getOmschrijving());
		dto.setPeriodeCursus(leerdoel.getCursus().getPeriode());
		dto.setEctsGewicht(leerdoel.getCursus().getEuropeanCredits()*leerdoel.getGewicht()/100);
		dto.setBloomniveau(Domain2DtoMapperLink.mapLink(leerdoel.getBloomNiveau()));
		dto.setTrefwoord(Domain2DtoMapperLink.mapLink(leerdoel.getTrefwoord()));
		dto.setBeroepsTaak(Domain2DtoMapperLink.mapLink(leerdoel.getBeroepsTaak()));
		dto.setProfessionalSkill(Domain2DtoMapperLink.mapLink(leerdoel.getProfessionalSkill()));
		dto.setCursus(Domain2DtoMapperLink.mapLink(leerdoel.getCursus()));
		return dto;
		
	}
	
	private CursusLeerplanSchemaDto mapLeerplanSchema(Cursus cursus) {
		CursusLeerplanSchemaDto dto = new CursusLeerplanSchemaDto();
		dto.setId(cursus.getId());
		dto.setNaam(cursus.getNaam());
		dto.setEuropeanCredits(cursus.getEuropeanCredits());
		dto.setCode(cursus.getCursusCode());
		dto.setPeriode(cursus.getPeriode());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(cursus));

		dto.setEindBT(new ArrayList<LinkDto>());
		for (BeroepsTaak beroepsTaak : cursus.getEindBTs()) {
			dto.getEindBT().add(Domain2DtoMapperLink.mapLink(beroepsTaak));
		}

		dto.setEindPS(new ArrayList<LinkDto>());
		for (ProfessionalSkill ps : cursus.getEindPSs()) {
			dto.getEindPS().add(Domain2DtoMapperLink.mapLink(ps));
		}

		return dto;
	}

}
