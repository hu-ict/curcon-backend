package nl.hu.curcon.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.CohortDto;
import nl.hu.curcon.dto.LeerlijnDto;
import nl.hu.curcon.dto.OpleidingsProfielDto;
import nl.hu.curcon.dto.check.OpleidingBeroepsTaakValidatieDto;
import nl.hu.curcon.dto.competence.BeroepsTaakDto;
import nl.hu.curcon.dto.competence.ProfessionalSkillDto;
import nl.hu.curcon.dto.post.CohortPostDto;
import nl.hu.curcon.dto.post.IdPostDto;
import nl.hu.curcon.dto.post.OpleidingsProfielPostDto;
import nl.hu.curcon.service.OpleidingsProfielService;
import nl.hu.curcon.filter.FunctionChecker;

@Component
@Path("/opleidingsprofielen")
@Api(hidden = false, value = "[Opleidigsprofiel] Raadplegen en wijzigen van opleidingsprofielen")
public class OpleidingsProfielRestService {
	@Autowired
	OpleidingsProfielService opleidingsProfielService;
	@Autowired
	FunctionChecker functionChecker;

	@GET
	@Path("/{opleidingsProfielId}")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(hidden = false, value = "Geeft een opleidingsprofielen op basis van zijn id.")
	public OpleidingsProfielDto find(@PathParam("opleidingsProfielId") int id) {
		if (!functionChecker.functionInUser("opleidingsprofiel_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return opleidingsProfielService.find(id);
	}

	@PUT
	@Path("/{opleidingsProfielId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(hidden = false, value = "Wijzigt een opleidingsprofiel.")
	public Response update(@PathParam("opleidingsProfielId") int opleidingsProfielId,
			OpleidingsProfielPostDto opleidingsProfielDto) {
		if (!functionChecker.functionInUser("opleidingsprofiel_put")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (!opleidingsProfielService.update(opleidingsProfielId, opleidingsProfielDto)) {
			return Response.status(404).build();
		} else {
			return Response.status(200).build();
		}
	}

	@GET
	@Path("/{opleidingsProfielId}/cohorten")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Geeft alle cohorten binnen een opleidingsprofiel.")
	public Response findCohortenByOpleidingsProfiel(@PathParam("opleidingsProfielId") int opleidingsProfielId) {
		if (!functionChecker.functionInUser("opleidingsprofielcohorten_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<CohortDto> list = opleidingsProfielService.findCohortenByOpleidingsProfiel(opleidingsProfielId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{opleidingsProfielId}/cohorten")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Maakt een nieuw cohort binnen een opleidingsprofielen aan.")
	public Response createCohortByOpleidingsProfiel(@PathParam("opleidingsProfielId") int opleidingsProfielId,
			CohortPostDto cohortDto) {
		if (!functionChecker.functionInUser("opleidingsprofielcohort_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		int cohortId = opleidingsProfielService.createCohortByOpleidingsProfiel(opleidingsProfielId, cohortDto);
		UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl()).path("/cohorten/" + cohortId);
		URI uri = builder.build();
		return Response.status(201).contentLocation(uri).build();
	}

	@GET
	@Path("/{opleidingsProfielId}/beroepstaken")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Geeft de eindkwalificaties op het gebied van de HBO-i beroepstaken voor een opleidingsprofiel.")
	public Response findBeroepsTakenByOpleidingsProfiel(@PathParam("opleidingsProfielId") int opleidingsProfielId) {
		if (!functionChecker.functionInUser("opleidingsprofielberoepstaken_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<BeroepsTaakDto> list = opleidingsProfielService.findBeroepsTakenByOpleidingsProfiel(opleidingsProfielId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@GET
	@Path("/{opleidingsProfielId}/beroepstaken/validatie")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Geeft de validatie van eindkwalificaties op het gebied van de HBO-i beroepstaken voor een opleidingsprofiel.")
	public Response validateBeroepsTakenByOpleidingsProfiel(@PathParam("opleidingsProfielId") int opleidingsProfielId) {
		if (!functionChecker.functionInUser("opleidingsprofielberoepstaken_check")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		OpleidingBeroepsTaakValidatieDto opleidingBeroepsTaakValidatieDto = opleidingsProfielService.validateBeroepsTakenByOpleidingsProfiel(opleidingsProfielId);
		if (opleidingBeroepsTaakValidatieDto != null) {
			return Response.ok(opleidingBeroepsTaakValidatieDto).build();
		} else {
			return Response.status(404).build();
		}
	}

	@GET
	@Path("/{opleidingsProfielId}/professionalskills")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Geeft de eindkwalificaties op het gebied van professionalSkill voor een opleidingsprofiel.")
	public Response findProfessionalSkillsByOpleidingsProfiel(
			@PathParam("opleidingsProfielId") int opleidingsProfielId) {
		if (!functionChecker.functionInUser("opleidingsprofielprofessionals_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<ProfessionalSkillDto> list = opleidingsProfielService
				.findProfessionalSkillsByOpleidingsProfiel(opleidingsProfielId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@GET
	@Path("/{opleidingsProfielId}/leerlijnen")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value = "Geeft de leerlijnen binnen een opleidingsprofiel.")
	public Response findLeerlijnenByOpleidingsProfiel(@PathParam("opleidingsProfielId") int opleidingsProfielId) {
		if (!functionChecker.functionInUser("opleidingsprofielleerlijnen_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<LeerlijnDto> list = opleidingsProfielService.findLeerlijnenByOpleidingsProfiel(opleidingsProfielId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{opleidingsProfielId}/beroepstaken")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Voegt een nieuwe beroepstaak aan een opleidingsprofiel toe. [LINK]")
	public Response addBeroepsTaakToOpleidingsprofiel(@PathParam("opleidingsProfielId") int opleidingsProfielId,
			IdPostDto dto) { 
		if (!functionChecker.functionInUser("opleidingsprofielberoepstaak_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		//String s = "opleidingsProfielId: ["+opleidingsProfielId+"] dto: ["+dto.getId()+"]";
		if (opleidingsProfielService.addBeroepsTaakToOpleidingsProfiel(opleidingsProfielId, dto.getId())) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}

	@DELETE
	@Path("/{opleidingsProfielId}/beroepstaken/{beroepstaakId}")
	@Transactional
	@ApiOperation(value = "Verwijderd een beroepsTaak van een opleidingsprofiel. [LINK]")
	public Response removeBeroepsTaakFromOpleidingsprofiel(@PathParam("opleidingsProfielId") int opleidingsProfielId,
			@PathParam("beroepstaakId") int beroepstaakId) {
		if (!functionChecker.functionInUser("opleidingsprofielberoepstaak_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (opleidingsProfielService.removeBeroepsTaakFromOpleidingsProfiel(opleidingsProfielId, beroepstaakId)) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{opleidingsProfielId}/professionalskills")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Voegt een nieuwe professionalSkills aan een opleidingsprofiel toe. [LINK]")
	public Response addProfessionalSkillsIdToOpleidingsprofiel(@PathParam("opleidingsProfielId") int opleidingsProfielId,
			IdPostDto dto) { 
		if (!functionChecker.functionInUser("opleidingsprofielprofessional_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		//String s = "opleidingsProfielId: ["+opleidingsProfielId+"] dto: ["+dto.getId()+"]";
		if (opleidingsProfielService.addProfessionalSkillsToOpleidingsProfiel(opleidingsProfielId, dto.getId())) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
			//return Response.ok(s+" false").build();
		}
	}

	@DELETE
	@Path("/{opleidingsProfielId}/professionalskills/{professionalSkillsId}")
	@Transactional
	@ApiOperation(value = "Verwijderd een professionalSkills van een opleidingsprofiel. [LINK]")
	public Response removeProfessionalSkillsIdFromOpleidingsprofiel(@PathParam("opleidingsProfielId") int opleidingsProfielId,
			@PathParam("professionalSkillsId") int professionalSkillsId) {
		if (!functionChecker.functionInUser("opleidingsprofielprofessional_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (opleidingsProfielService.removeProfessionalSkillsFromOpleidingsProfiel(opleidingsProfielId, professionalSkillsId)) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}

}
