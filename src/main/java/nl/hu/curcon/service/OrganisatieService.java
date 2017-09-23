package nl.hu.curcon.service;

import java.util.List;

import nl.hu.curcon.dto.BeroepsTaakDto;
import nl.hu.curcon.dto.CursusDto;
import nl.hu.curcon.dto.DocentDto;
import nl.hu.curcon.dto.OpleidingsProfielDto;
import nl.hu.curcon.dto.OrganisatieDto;
import nl.hu.curcon.dto.post.CursusPostDto;
import nl.hu.curcon.dto.post.DocentPostDto;
import nl.hu.curcon.dto.post.OpleidingsProfielPostDto;
import nl.hu.curcon.dto.post.OrganisatiePostDto;

/**
 * Created by jayfeurich on 26/04/15.
 */

public interface OrganisatieService {
	int create(OrganisatiePostDto organisatieDto);

	boolean delete(int organisatieId);

	boolean update(int organisatieId, OrganisatiePostDto organisatieDto);

	OrganisatieDto find(int organisatieId);

	List<OrganisatieDto> findAll();
	// public Long count();

	List<DocentDto> findDocentenByOrganisatie(int organisatieId);

	List<CursusDto> findCursussenByOrganisatie(int organisatieId);

	List<OpleidingsProfielDto> findOpleidingsProfielenByOrganisatie(int organisatieId);

	int createCursusByOrganisatie(int organisatieId, CursusPostDto cursusDto);

	int createOpleidingsProfielByOrganisatie(int organisatieId, OpleidingsProfielPostDto opleidingsProfielDto);

	int createDocentByOrganisatie(int organisatieId, DocentPostDto docentDto);

	List<BeroepsTaakDto> findBeroepsTakenByOrganisatie(int organisatieId);

}
