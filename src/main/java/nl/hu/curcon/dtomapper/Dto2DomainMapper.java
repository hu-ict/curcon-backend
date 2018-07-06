package nl.hu.curcon.dtomapper;

import org.springframework.stereotype.Component;

import nl.hu.curcon.domain.BeoordelingsElement;
import nl.hu.curcon.domain.BloomNiveau;
import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Docent;
import nl.hu.curcon.domain.Function;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.Leerlijn;
import nl.hu.curcon.domain.Module;
import nl.hu.curcon.domain.OpleidingsProfiel;
import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.domain.Periode;
import nl.hu.curcon.domain.ProfessionalSkill;
import nl.hu.curcon.domain.Role;
import nl.hu.curcon.domain.Toets;
import nl.hu.curcon.domain.ToetsElement;
import nl.hu.curcon.domain.ToetsPlanning;
import nl.hu.curcon.domain.Trefwoord;
import nl.hu.curcon.domain.User;
import nl.hu.curcon.dto.BloomNiveauDto;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.PeriodeDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dto.ToetsPlanningDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.post.BeoordelingsElementPostDto;
import nl.hu.curcon.dto.post.CohortPostDto;
import nl.hu.curcon.dto.post.CursusPostDto;
import nl.hu.curcon.dto.post.DocentPostDto;
import nl.hu.curcon.dto.post.FunctionPostDto;
import nl.hu.curcon.dto.post.LeerdoelPostDto;
import nl.hu.curcon.dto.post.LeerlijnPostDto;
import nl.hu.curcon.dto.post.ModulePostDto;
import nl.hu.curcon.dto.post.OpleidingsProfielPostDto;
import nl.hu.curcon.dto.post.OrganisatiePostDto;
import nl.hu.curcon.dto.post.RolePutDto;
import nl.hu.curcon.dto.post.ToetsElementPostDto;
import nl.hu.curcon.dto.post.ToetsPostDto;
import nl.hu.curcon.dto.post.TrefwoordPostDto;
import nl.hu.curcon.dto.post.UserPostDto;

/**
 * @author berend.wilkens, 30 mei 2017
 */
@Component
public class Dto2DomainMapper {

	public Docent map(DocentPostDto dto) {
		Docent domain = new Docent();
		domain.setNaam(dto.getNaam());
		return domain;
	}

	public BeoordelingsElement map(BeoordelingsElementPostDto dto) {
		BeoordelingsElement domain = new BeoordelingsElement();
		domain.setNaam(dto.getNaam());
		domain.setOmschrijving(dto.getOmschrijving());
		domain.setGewicht(dto.getGewicht());
		return domain;
	}

//	public BeroepsTaak map(BeroepsTaakDto dto) {
//		BeroepsTaak domain = new BeroepsTaak();
//		domain.setId(dto.getId());
//		domain.setActiviteit(dto.getActiviteit());
//		domain.setArchitectuurlaag(dto.getArchitectuurlaag());
//		domain.setNiveau(dto.getNiveau());
//		return domain;
//	}

	public BloomNiveau map(BloomNiveauDto dto) {
		return null;
	}

	public Cohort map(CohortPostDto dto) {
		Cohort domain = new Cohort();
		domain.setJaar(dto.getJaar());
		return domain;
	}

	public Cursus map(CursusPostDto dto) {
		Cursus domain = new Cursus();
		domain.setCursusCode(dto.getCode());
		domain.setEuropeanCredits(dto.getEuropeanCredits());
		domain.setNaam(dto.getNaam());
		domain.setPeriode(dto.getPeriode());
		return domain;
	}

	public Leerdoel map(LeerdoelPostDto dto) {
		Leerdoel domain = new Leerdoel();
		domain.setOmschrijving(dto.getOmschrijving());
		domain.setGewicht(dto.getGewicht());
		return domain;
	}

	public Leerlijn map(LeerlijnPostDto dto) {
		Leerlijn domain = new Leerlijn();
		domain.setNaam(dto.getNaam());
		domain.setOmschrijving(dto.getOmschrijving());
		return domain;
	}

	public Trefwoord map(TrefwoordPostDto dto) {
		Trefwoord domain = new Trefwoord();
		domain.setNaam(dto.getNaam());
		domain.setOmschrijving(dto.getOmschrijving());
		return domain;
	}

	public OpleidingsProfiel map(OpleidingsProfielPostDto dto) {
		OpleidingsProfiel domain = new OpleidingsProfiel();
		domain.setNaam(dto.getNaam());
		return domain;
	}

	public Organisatie map(OrganisatiePostDto dto) {
		Organisatie domain = new Organisatie();
		domain.setNaam(dto.getNaam());
		return domain;
	}

	public Periode map(PeriodeDto dto) {
		return null;
	}

	public ProfessionalSkill map(ProfessionalSkillDto dto) {
		return null;
	}

	public ToetsElement map(ToetsElementPostDto dto) {
		ToetsElement domain = new ToetsElement();
		domain.setGewicht(dto.getGewicht());
		return domain;
	}

	public ToetsPlanning map(ToetsPlanningDto dto) {
		return null;
	}

	public Toets map(ToetsPostDto dto) {
		Toets domain = new Toets();
		domain.setNaam(dto.getNaam());
		domain.setGewicht(dto.getGewicht());
		domain.setOmschrijving(dto.getOmschrijving());
		return domain;
	}
	public User map(UserDto dto) {
		User domain = new User();
		domain.setUsername(dto.getUsername());
		return domain;
	}
	public Role map(RoleDto dto) {
		Role domain = new Role();
		domain.setName(dto.getName());;
		return domain;
	}
	public Module map(ModuleDto dto) {
		Module domain = new Module();
		domain.setName(dto.getName());

		return domain;
	}
	public Function map(FunctionDto dto) {
		Function domain = new Function();
		domain.setName(dto.getName());
		return domain;
	}

	public Module map(ModulePostDto dto) {
		Module domain = new Module();
		domain.setName(dto.getName());

		return domain;
	}

	public Function map(FunctionPostDto dto) {
		Function domain = new Function();
		domain.setName(dto.getName());

		return domain;
	}

	public Role map(RolePutDto dto) {
		Role domain = new Role();
		domain.setName(dto.getName());
		return domain;
	}
	public User map(UserPostDto dto) {
		User domain = new User();
		domain.setUsername(dto.getUsername());
		return domain;
	}
}
