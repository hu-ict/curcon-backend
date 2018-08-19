package nl.hu.curcon.dtomapper;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import nl.hu.curcon.domain.BeoordelingsElement;
import nl.hu.curcon.domain.Cursus;
import nl.hu.curcon.domain.Leerdoel;
import nl.hu.curcon.domain.Toets;
import nl.hu.curcon.domain.ToetsElement;
import nl.hu.curcon.dto.ToetsMatrijsBeoordelingsElementDto;
import nl.hu.curcon.dto.ToetsMatrijsDto;
import nl.hu.curcon.dto.ToetsMatrijsLeerdoelDto;
import nl.hu.curcon.dto.ToetsMatrijsToetsDto;
import nl.hu.curcon.dto.ToetsMatrijsToetsElementDto;
import nl.hu.curcon.rest.MyApplication;

/**
 * @author berend.wilkens
 *
 */
@Component
public class Domain2DtoMapperToetsMatrijs {
	public static ToetsMatrijsDto mapToetsMatrijs(Cursus cursus) {
		ToetsMatrijsDto dto = new ToetsMatrijsDto();
		dto.setId(cursus.getId());
		dto.setCode(cursus.getCursusCode());
		dto.setNaam(cursus.getNaam());
		dto.setHRef(MyApplication.getBaseUrl() + "toetsmatrijzen/" + cursus.getId());

		dto.setToetsen(new ArrayList<ToetsMatrijsToetsDto>());
		for (Toets toets : cursus.getToetsen()) {
			dto.getToetsen().add(map(toets));
		}

		dto.setLeerdoelen(new ArrayList<ToetsMatrijsLeerdoelDto>());
		for (Leerdoel leerdoel : cursus.getLeerdoelen()) {
			dto.getLeerdoelen().add(map(leerdoel));
		}

		return dto;
	}

	public static ToetsMatrijsLeerdoelDto map(Leerdoel leerdoel) {
		ToetsMatrijsLeerdoelDto dto = new ToetsMatrijsLeerdoelDto();
		dto.setId(leerdoel.getId());
		dto.setOmschrijving(leerdoel.getOmschrijving());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(leerdoel));
		dto.setBloomniveau(Domain2DtoMapperLink.mapLink(leerdoel.getBloomNiveau()));
		dto.setEindBT(Domain2DtoMapperLink.mapLink(leerdoel.getBeroepsTaak()));
		dto.setEindPS(Domain2DtoMapperLink.mapLink(leerdoel.getProfessionalSkill()));

		dto.setToetsElementen(new ArrayList<ToetsMatrijsToetsElementDto>());
		for (ToetsElement toetsElement : leerdoel.getToetsElementen()) {
			dto.getToetsElementen().add(map(toetsElement));
		}

		return dto;
	}

	public static ToetsMatrijsToetsDto map(Toets toets) {
		ToetsMatrijsToetsDto dto = new ToetsMatrijsToetsDto();
		dto.setId(toets.getId());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(toets));
		dto.setNaam(toets.getNaam());
		dto.setGewicht(toets.getGewicht());
		dto.setMillerNiveau(Domain2DtoMapperLink.mapLink(toets.getMillerNiveau()));
		dto.setBeoordelingsElementen(new ArrayList<ToetsMatrijsBeoordelingsElementDto>());
		for (BeoordelingsElement beoordelingsElement : toets.getBeoordelingsElementen()) {
			dto.getBeoordelingsElementen().add(map(beoordelingsElement));
		}
		return dto;
	}

	public static ToetsMatrijsBeoordelingsElementDto map(BeoordelingsElement beoordelingsElement) {
		ToetsMatrijsBeoordelingsElementDto dto = new ToetsMatrijsBeoordelingsElementDto();
		dto.setId(beoordelingsElement.getId());
		dto.setNaam(beoordelingsElement.getNaam());
		dto.setOmschrijving(beoordelingsElement.getOmschrijving());
		dto.setGewicht(beoordelingsElement.getGewicht());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(beoordelingsElement));
		return dto;
	}


	public static ToetsMatrijsToetsElementDto map(ToetsElement toetsElement) {
		ToetsMatrijsToetsElementDto dto = new ToetsMatrijsToetsElementDto();
		dto.setId(toetsElement.getId());
		dto.setGewicht(toetsElement.getGewicht());
		dto.setHRef(Domain2DtoMapperHRef.mapHRef(toetsElement));
		dto.setBloomniveau(Domain2DtoMapperLink.mapLink(toetsElement.getBloomNiveau()));
		dto.setBeoordelingsElement(Domain2DtoMapperIdLink.mapIdLink(toetsElement.getBeoordelingsElement()));
		return dto;
	}

}
