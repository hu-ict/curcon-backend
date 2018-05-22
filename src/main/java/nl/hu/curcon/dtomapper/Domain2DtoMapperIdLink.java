package nl.hu.curcon.dtomapper;

import nl.hu.curcon.domain.BeoordelingsElement;
import nl.hu.curcon.domain.Module;
import nl.hu.curcon.domain.Role;
import nl.hu.curcon.dto.IdLinkDto;

public class Domain2DtoMapperIdLink {

	public static IdLinkDto mapIdLink(BeoordelingsElement domain) {
		if (domain == null) {return null;}
		IdLinkDto dto = new IdLinkDto();
		dto.setId(domain.getId());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;

	}
	public static IdLinkDto mapIdLink(Role domain) {
		if (domain == null) {return null;}
		IdLinkDto dto = new IdLinkDto();
		dto.setId(domain.getId());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;

	}
	public static IdLinkDto mapIdLink(Module domain) {
		if (domain == null) {return null;}
		IdLinkDto dto = new IdLinkDto();
		dto.setId(domain.getId());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(domain));
		return dto;

	}

}
