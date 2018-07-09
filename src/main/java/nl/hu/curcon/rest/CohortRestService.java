package nl.hu.curcon.rest;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.CohortDto;
import nl.hu.curcon.dto.CursusDto;
import nl.hu.curcon.dto.post.CohortPostDto;
import nl.hu.curcon.dto.post.IdPostDto;
import nl.hu.curcon.service.CohortService;
import nl.hu.curcon.filter.FunctionChecker;

@Path("/cohorten")
@Component
@Api(value="[Cohort] Raadplegen, aanmaken en wijzigen van cohorten ook wel examenprogramma genoemd.")
public class CohortRestService {
	@Autowired
	CohortService cohortService;
	@Autowired
	FunctionChecker functionChecker;
	
	@GET
	@Path("/{cohortId}")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(hidden=false, value = "Geeft een cohort op basis van zijn id")
	public CohortDto find(@PathParam("cohortId") int id) {
		if (!functionChecker.functionInUser("cohort_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return cohortService.find(id);
	}

	@ApiOperation(hidden = true, value = "Wijzigd een cohort")
	@PUT
	@Path("/{cohortId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(@PathParam("cohortId") int cohortId, CohortPostDto cohortDto) {
		if (!functionChecker.functionInUser("cohort_put")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (cohortService.update(cohortId, cohortDto)) {
			return Response.status(404).build();
		} else {
			return Response.status(200).build();
		}
	}
	
	@GET
	@Path("/{cohortId}/cursussen")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft alle cursussen van een cohort (examenprogramma)")
	public Response findLeerdoelenByCursus(@PathParam("cohortId") int cohortId) {
		if (!functionChecker.functionInUser("cohortcursussen_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<CursusDto> list = cohortService.getCursussenByCohort(cohortId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Path("/{cohortId}/cursussen")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Koppelt een cursus aan een cohort (examenprogramma)")
	public Response addCursusToCohort(@PathParam("cohortId") int cohortId, IdPostDto dto) {
		if (!functionChecker.functionInUser("cohortcursus_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (cohortService.addCursusToCohort(cohortId, dto.getId())) {
			return Response.status(201).build();
		} else {
			return Response.status(404).build();
		}
	}

	@DELETE
	@Path("/{cohortId}/cursussen/{cursusId}")
	@Transactional
	@ApiOperation(value = "Verwijdert een cursus uit een cohort (examenprogramma), cursus zelf wordt niet verwijderd.")
	public Response removeCursusFromCohort(@PathParam("cohortId") int cohortId, @PathParam("cursusId") int cursusId) {
		if (!functionChecker.functionInUser("cohortcursus_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (cohortService.removeCursusFromCohort(cohortId, cursusId)) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}


}
