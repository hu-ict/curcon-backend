package nl.hu.curcon.dtomapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import nl.hu.curcon.domain.BeoordelingsElement;
import nl.hu.curcon.domain.BloomNiveau;
import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Docent;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.Leerlijn;
import nl.hu.curcon.domain.MillerNiveau;
import nl.hu.curcon.domain.OpleidingsProfiel;
import nl.hu.curcon.domain.Organisatie;
import nl.hu.curcon.domain.Periode;
import nl.hu.curcon.domain.ProfessionalSkill;
import nl.hu.curcon.domain.Toets;
import nl.hu.curcon.domain.ToetsElement;
import nl.hu.curcon.domain.ToetsPlanning;
import nl.hu.curcon.domain.Trefwoord;
import nl.hu.curcon.domain.hboi.BeroepsTaak;
import nl.hu.curcon.dto.BeoordelingsElementDto;
import nl.hu.curcon.dto.BloomNiveauDto;
import nl.hu.curcon.dto.CohortDto;
import nl.hu.curcon.dto.CursusDto;
import nl.hu.curcon.dto.DocentDto;
import nl.hu.curcon.dto.HRefDto;
import nl.hu.curcon.dto.LeerdoelDto;
import nl.hu.curcon.dto.LeerlijnDto;
import nl.hu.curcon.dto.MillerNiveauDto;
import nl.hu.curcon.dto.OpleidingsProfielDto;
import nl.hu.curcon.dto.OrganisatieDto;
import nl.hu.curcon.dto.PeriodeDto;
import nl.hu.curcon.dto.ToetsDto;
import nl.hu.curcon.dto.ToetsElementDto;
import nl.hu.curcon.dto.ToetsPlanningDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.competence.TrefwoordDto;
import nl.hu.curcon.rest.MyApplication;

/**
 * @author berend.wilkens
 *
 */
@Component
public class Domain2DtoMapper {
	public static BeoordelingsElementDto map(BeoordelingsElement beoordelingsElement) {
		if (beoordelingsElement == null) { return null; }
		BeoordelingsElementDto dto = new BeoordelingsElementDto();
		dto.setId(beoordelingsElement.getId());
		dto.setNaam(beoordelingsElement.getNaam());
		dto.setOmschrijving(beoordelingsElement.getOmschrijving());
		dto.setGewicht(beoordelingsElement.getGewicht());
		HRefDto hRefDto = new HRefDto();
		hRefDto.setHRef(MyApplication.getBaseUrl() + "beoordelingselementen/" + beoordelingsElement.getId()+"/toetselementen");
		dto.setToetsElementen(hRefDto);
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(beoordelingsElement));
		return dto;
	}

	public static BeroepsTaakDto map(BeroepsTaak beroepsTaak) {
		if (beroepsTaak == null) { return null; }
		BeroepsTaakDto dto = new BeroepsTaakDto();
		dto.setId(beroepsTaak.getId());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(beroepsTaak));
		dto.setActiviteit(beroepsTaak.getActiviteit().getNaam());
		dto.setActiviteitId(beroepsTaak.getActiviteit().getId());
		dto.setArchitectuurlaag(beroepsTaak.getArchitectuurlaag().getNaam());
		dto.setArchitectuurlaagId(beroepsTaak.getArchitectuurlaag().getId());
		dto.setNiveau(beroepsTaak.getNiveau());
		dto.setOmschrijving(beroepsTaak.getBeschrijving());
		return dto;
	}

	public static BloomNiveauDto map(BloomNiveau bloomNiveau) {
		if (bloomNiveau == null) { return null; }
		BloomNiveauDto dto = new BloomNiveauDto();
		dto.setId(bloomNiveau.getId());
		dto.setNiveau(bloomNiveau.getNiveau());
		dto.setOmschrijving(bloomNiveau.getOmschrijving());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(bloomNiveau));
		return dto;
	}

	public static CohortDto map(Cohort cohort) {
		if (cohort == null) { return null; }
		CohortDto dto = new CohortDto();
		dto.setId(cohort.getId());
		dto.setJaar(cohort.getJaar());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(cohort));

		HRefDto hRefDtoC = new HRefDto();
		hRefDtoC.setHRef(MyApplication.getBaseUrl() + "cohorten/" + cohort.getId()+"/cursussen");
		dto.setCursussen(hRefDtoC);

		return dto;
	}

	public static CursusDto map(Cursus cursus) {
		if (cursus == null) { return null; }
		CursusDto dto = new CursusDto();
		dto.setId(cursus.getId());
		dto.setNaam(cursus.getNaam());
		dto.setEuropeanCredits(cursus.getEuropeanCredits());
		dto.setCode(cursus.getCursusCode());
		dto.setPeriode(cursus.getPeriode());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(cursus));

		dto.setCoordinator(Domain2DtoMapperLink.mapLink(cursus.getCursuscoordinator()));

		HRefDto hRefDtoBT = new HRefDto();
		hRefDtoBT.setHRef(MyApplication.getBaseUrl() + "cursussen/" + cursus.getId()+"/beroepstaken");
		dto.setEindBT(hRefDtoBT);
		
		HRefDto hRefDtoLD = new HRefDto();
		hRefDtoLD.setHRef(MyApplication.getBaseUrl() + "cursussen/" + cursus.getId()+"/leerdoelen");
		dto.setLeerdoelen(hRefDtoLD);

		HRefDto hRefDtoT = new HRefDto();
		hRefDtoT.setHRef(MyApplication.getBaseUrl() + "cursussen/" + cursus.getId()+"/toetsen");
		dto.setToetsen(hRefDtoT);

		HRefDto hRefDtoPS = new HRefDto();
		hRefDtoPS.setHRef(MyApplication.getBaseUrl() + "cursussen/" + cursus.getId()+"/professionalskills");
		dto.setEindPS(hRefDtoPS);

		return dto;
	}

	public static DocentDto map(Docent docent) {
		if (docent == null) { return null; }
		DocentDto dto = new DocentDto();
		dto.setId(docent.getId());
		dto.setNaam(docent.getNaam());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(docent));
		return dto;
	}

	public static LeerdoelDto map(Leerdoel leerdoel) {
		if (leerdoel == null) { return null; }
		LeerdoelDto dto = new LeerdoelDto();
		dto.setId(leerdoel.getId());
		dto.setNaam(leerdoel.getNaam());
		dto.setOmschrijving(leerdoel.getOmschrijving());
		dto.setGewicht(leerdoel.getGewicht());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(leerdoel));
		dto.setBloomniveau(Domain2DtoMapperLink.mapLink(leerdoel.getBloomNiveau()));
		dto.setEindBT(Domain2DtoMapperLink.mapLink(leerdoel.getBeroepsTaak()));
		dto.setEindPS(Domain2DtoMapperLink.mapLink(leerdoel.getProfessionalSkill()));
		dto.setToetsElementen(new HRefDto(MyApplication.getBaseUrl() + "leerdoelen/" + leerdoel.getId()+"/toetselementen"));
		dto.setTrefwoord(Domain2DtoMapperLink.mapLink(leerdoel.getTrefwoord()));
		return dto;
	}

	public static LeerlijnDto map(Leerlijn leerlijn) {
		if (leerlijn == null) { return null; }
		LeerlijnDto dto = new LeerlijnDto();
		dto.setId(leerlijn.getId());
		dto.setNaam(leerlijn.getNaam());
		dto.setTrefwoorden(new HRefDto(MyApplication.getBaseUrl() + "trefwoorden" + dto.getId()));
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(leerlijn));
		return dto;
	}

	public static MillerNiveauDto map(MillerNiveau millerNiveau) {
		MillerNiveauDto dto = new MillerNiveauDto();
		dto.setId(millerNiveau.getId());
		dto.setNiveau(millerNiveau.getNiveau());
		dto.setOmschrijving(millerNiveau.getOmschrijving());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(millerNiveau));
		return dto;
	}

	public static TrefwoordDto map(Trefwoord trefwoord) {
		if (trefwoord == null) { return null; }
		TrefwoordDto dto = new TrefwoordDto();
		dto.setId(trefwoord.getId());
		dto.setNaam(trefwoord.getNaam());
		dto.setOmschrijving(trefwoord.getOmschrijving());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(trefwoord));
		return dto;
	}

	public static OpleidingsProfielDto map(OpleidingsProfiel opleidingsProfiel) {
		if (opleidingsProfiel == null) { return null; }
		OpleidingsProfielDto dto = new OpleidingsProfielDto();
		dto.setId(opleidingsProfiel.getId());
		dto.setNaam(opleidingsProfiel.getNaam());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(opleidingsProfiel));
		
		HRefDto hRefDtoC = new HRefDto();
		hRefDtoC.setHRef(MyApplication.getBaseUrl() + "opleidingsprofielen/" + dto.getId()+"/cohorten");
		dto.setCohorten(hRefDtoC);
		
		HRefDto hRefDtoBT = new HRefDto();
		hRefDtoBT.setHRef(MyApplication.getBaseUrl() + "opleidingsprofielen/" + dto.getId()+"/beroepstaken");
		dto.setEindBT(hRefDtoBT);

		HRefDto hRefDtoPS = new HRefDto();
		hRefDtoPS.setHRef(MyApplication.getBaseUrl() + "opleidingsprofielen/" + dto.getId()+"/professionalskills");
		dto.setEindPS(hRefDtoPS);

		return dto;
	}

	public static OrganisatieDto map(Organisatie organisatie) {
		if (organisatie == null) { return null; }
		OrganisatieDto dto = new OrganisatieDto();
		dto.setId(organisatie.getId());
		dto.setNaam(organisatie.getNaam());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(organisatie));

		HRefDto hRefDtoOP = new HRefDto();
		hRefDtoOP.setHRef(MyApplication.getBaseUrl() + "organisaties/" + organisatie.getId()+"/opleidingsprofielen");
		dto.setOpleidingsProfielen(hRefDtoOP);

		HRefDto hRefDtoC = new HRefDto();
		hRefDtoC.setHRef(MyApplication.getBaseUrl() + "organisaties/" + organisatie.getId()+"/cursussen");
		dto.setCursussen(hRefDtoC);

		HRefDto hRefDtoD = new HRefDto();
		hRefDtoD.setHRef(MyApplication.getBaseUrl() + "organisaties/" + organisatie.getId()+"/docenten");
		dto.setDocenten(hRefDtoD);

		return dto;
	}

	public static PeriodeDto map(Periode periode) {
		if (periode == null) { return null; }
		PeriodeDto dto = new PeriodeDto();
		dto.setId(periode.getId());
		dto.setPeriode(periode.getPeriode());
		return dto;
	}

	public static ProfessionalSkillDto map(ProfessionalSkill professionalSkill) {
		if (professionalSkill == null) { return null; }
		ProfessionalSkillDto dto = new ProfessionalSkillDto();
		dto.setId(professionalSkill.getId());
		dto.setCode(professionalSkill.getCode());
		dto.setNiveau(professionalSkill.getNiveau());
		dto.setBeschrijving(professionalSkill.getBeschrijving());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(professionalSkill));
		return dto;
	}

	public static ToetsDto map(Toets toets) {
		if (toets == null) { return null; }
		ToetsDto dto = new ToetsDto();
		dto.setId(toets.getId());
		dto.setNaam(toets.getNaam());
		dto.setGewicht(toets.getGewicht());
		dto.setOmschrijving(toets.getOmschrijving());

		dto.setMillerNiveau(Domain2DtoMapperLink.mapLink(toets.getMillerNiveau()));
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(toets));
		dto.setBeoordelingsElementen(new ArrayList<BeoordelingsElementDto>());
		for (BeoordelingsElement beoordelingsElement : toets.getBeoordelingsElementen()) {
			dto.getBeoordelingsElementen().add(map(beoordelingsElement));
		}
		return dto;
	}

	public static ToetsElementDto map(ToetsElement toetsElement) {
		if (toetsElement == null) { return null; }
		ToetsElementDto dto = new ToetsElementDto();
		dto.setId(toetsElement.getId());
		dto.setGewicht(toetsElement.getGewicht());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(toetsElement));
		dto.setLeerdoel(Domain2DtoMapperLink.mapLink(toetsElement.getLeerdoel()));
		dto.setBeoordelingsElement(Domain2DtoMapperLink.mapLink(toetsElement.getBeoordelingsElement()));
		return dto;
	}

	public static ToetsPlanningDto map(ToetsPlanning toetsPlanning) {
		if (toetsPlanning == null) { return null; }
		ToetsPlanningDto dto = new ToetsPlanningDto();
		dto.setId(toetsPlanning.getId());
		return dto;
	}

}
