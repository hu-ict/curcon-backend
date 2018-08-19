package nl.hu.curcon.rest;

import javax.ws.rs.GET;
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
import nl.hu.curcon.dto.ToetsMatrijsDto;
import nl.hu.curcon.service.ToetsMatrijsService;
import nl.hu.curcon.filter.FunctionChecker;

@Component
@Path("/toetsmatrijzen")
@Api(value="[Toetsmatrijs] Voor het raadplegen van toetsmatrijzen.")
public class ToetsMatrijsRestService {
	@Autowired
	ToetsMatrijsService toetsMatrijsService;
	@Autowired
	FunctionChecker functionChecker;

	@GET
	@Path("/{cursus_id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Transactional
	@ApiOperation(value="Geeft een toetsmatrijs op basis van het cursusId.")
	public ToetsMatrijsDto find(@PathParam("cursus_id") int cursus_id) {
		if (!functionChecker.functionInUser("toetsmatrijs_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return toetsMatrijsService.find(cursus_id);
	}
	
}
