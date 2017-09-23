package nl.hu.curcon.rest;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.BeroepsTaakDto;
import nl.hu.curcon.dto.BeroepsTaakTypesDto;
import nl.hu.curcon.service.BeroepsTaakService;

/**
 * @author berend.wilkens, 18 mei 2017
 */
@Component
@Path("/beroepstaken")
@Api(hidden = false, value = "[Beroepstaak] Beheer op de 75 beroepstaken. Alleen lezen en wijzigen, aanmaken en verwijderen zijn niet aan de orde.")
public class BeroepsTaakRestService {
    @Autowired
    BeroepsTaakService beroepsTaakService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<BeroepsTaakDto> findAll() {
		return beroepsTaakService.findAll();
	}
	
	@GET
	@Path("/{beroepsTaakId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public BeroepsTaakDto find(@PathParam("beroepsTaakId") int beroepsTaakId) {
		return beroepsTaakService.find(beroepsTaakId);
	}

 	@GET
 	@Path("/types")
	@Produces({ MediaType.APPLICATION_JSON })
	public BeroepsTaakTypesDto findTypes() {
		return beroepsTaakService.findTypes();
	}

	@GET
	@Path("/activiteiten/{activiteitId}/architectuurlagen/{architectuurLaagId}/niveaus/{niveau}")
	@Produces({ MediaType.APPLICATION_JSON })
	public BeroepsTaakDto find(@PathParam("activiteitId") int activiteitId, @PathParam("architectuurLaagId") int architectuurLaagId, @PathParam("niveau") int niveau) {
		return beroepsTaakService.find(activiteitId, architectuurLaagId, niveau);
	}

}
