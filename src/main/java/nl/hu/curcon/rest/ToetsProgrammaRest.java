package nl.hu.curcon.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.check.ConformiteitBeroepsTaakDto;
import nl.hu.curcon.dto.check.EctsBeroepsTaakDto;
import nl.hu.curcon.dto.check.EctsToetsVormDto;
import nl.hu.curcon.service.ToetsProgrammaService;

@Component
@Path("/toetsprogrammas")
@Api(value="[ToetsProgramma] Toetsprogramma's worden gecheckt")
public class ToetsProgrammaRest {
	@Autowired
	ToetsProgrammaService toetsProgrammaService;
	
	@GET
	@Path("/{cohortId}/vorm")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(hidden = false, value = "Geeft de spreiding van toetsvorm per tussen- en eindcompetentie voor een opleidingsprofiel voor een cohort.")
	public List<EctsToetsVormDto> getVorm(@PathParam("cohortId") int cohortId) {
		return toetsProgrammaService.getEctsToetsVorm(cohortId);
	}

	@GET
	@Path("/{cohortId}/ects")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(hidden = false, value = "Geeft de ects per tussen- en eindcompetentie voor een opleidingsprofiel voor een cohort.")
	public List<EctsBeroepsTaakDto> getEcts(@PathParam("cohortId") int cohortId) {
		return toetsProgrammaService.getEctsBroepsTaak(cohortId);
	}
	
	@GET
	@Path("/{cohortId}/profiel")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(hidden = false, value = "Geeft een berekend opleidingsprofiel voor een cohort.")
	public List<ConformiteitBeroepsTaakDto> calcProfiel(@PathParam("cohortId") int cohortId) {
		return toetsProgrammaService.calcProfile(cohortId);
	}
	



}
