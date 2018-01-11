package nl.hu.curcon.dtomapper;

import org.springframework.stereotype.Component;

import nl.hu.curcon.domain.BeoordelingsElement;
import nl.hu.curcon.domain.BeroepsTaak;
import nl.hu.curcon.domain.BloomNiveau;
import nl.hu.curcon.domain.Cohort;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Docent;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.MillerNiveau;
import nl.hu.curcon.domain.OpleidingsProfiel;
import nl.hu.curcon.domain.ProfessionalSkill;
import nl.hu.curcon.domain.Toets;
import nl.hu.curcon.domain.Trefwoord;
import nl.hu.curcon.dto.LinkDto;

/**
 * Created by jayfeurich on 26/06/15.
 */
@Component
public class Domain2DtoMapperLink {

	public static LinkDto mapLink(BeoordelingsElement domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getNaam());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}

	public static LinkDto mapLink(BeroepsTaak domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getVerkort());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}

	public static LinkDto mapLink(BloomNiveau domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getNiveau());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}

	public static LinkDto mapLink(Cohort domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getJaar());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}

	public static LinkDto mapLink(Cursus domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getNaam());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}

	public static LinkDto mapLink(Docent domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getNaam());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}

	public static LinkDto mapLink(Leerdoel domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getOmschrijving());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}

	public static LinkDto mapLink(MillerNiveau domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getNiveau());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}

	public static LinkDto mapLink(OpleidingsProfiel domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getNaam());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}

	public static LinkDto mapLink(ProfessionalSkill domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getVerkort());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}

	public static LinkDto mapLink(Toets domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getNaam());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}
	public static LinkDto mapLink(Trefwoord domain) {
		if (domain == null) {return null;}
		LinkDto dto = new LinkDto();
		dto.setId(domain.getId());
		dto.setNaam(domain.getNaam());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;
	}
}
