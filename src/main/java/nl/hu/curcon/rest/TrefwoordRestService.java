package nl.hu.curcon.rest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.competence.TrefwoordDto;
import nl.hu.curcon.dto.post.TrefwoordPostDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.TrefwoordService;
import nl.hu.curcon.filter.FunctionChecker;

@Component
@Path("/trefwoorden")
@Api(hidden = true)
public class TrefwoordRestService {
    @Autowired
    TrefwoordService trefwoordService;
	@Autowired
	FunctionChecker functionChecker;

	@Autowired
	Domain2DtoMapper domain2DtoMapper;

	@Autowired
	Dto2DomainMapper dto2DomainMapper;

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public TrefwoordDto find(@PathParam("id") int id) {
		if (!functionChecker.functionInUser("trefwoord_get")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return trefwoordService.find(id);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public boolean update(TrefwoordPostDto trefwoordDto) {
		if (!functionChecker.functionInUser("trefwoord_put")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		return trefwoordService.update(trefwoordDto);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		if (!functionChecker.functionInUser("trefwoord_delete")) {
			//Niet Geauthoriseerd
			throw new WebApplicationException(Response.status(403).build());
		}
		trefwoordService.delete(id);
	}

}
