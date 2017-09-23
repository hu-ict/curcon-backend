package nl.hu.curcon.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.BeoordelingsElementDto;
import nl.hu.curcon.dto.ToetsElementDto;
import nl.hu.curcon.dto.post.BeoordelingsElementPostDto;
import nl.hu.curcon.service.BeoordelingsElementService;

@Component
@Path("/beoordelingselementen")
@Api(hidden = false)
public class BeoordelingsElementRestService {
	@Autowired
	BeoordelingsElementService beoordelingsElementService;

	@GET
	@Path("/{beoordelingsElementId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response find(@PathParam("beoordelingsElementId") int beoordelingsElementId) {
		BeoordelingsElementDto beoordelingsElementDto = beoordelingsElementService.find(beoordelingsElementId);
		if (beoordelingsElementDto != null) {
			return Response.ok(beoordelingsElementDto).build();
		} else {
			return Response.status(404).build();
		}
	}

	@ApiOperation(hidden = false, value = "Wijzigen van een beoordelingselement")
	@PUT
	@Path("/{beoordelingsElementId}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response update(@PathParam("beoordelingsElementId") int beoordelingsElementId,
			BeoordelingsElementPostDto beoordelingsElementPostDto) {
		if (beoordelingsElementService.update(beoordelingsElementId, beoordelingsElementPostDto)) {
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}
	}

	@DELETE
	@Path("/{beoordelingsElementId}")
	public Response delete(@PathParam("beoordelingsElementId") int beoordelingsElementId) {
		if (beoordelingsElementService.delete(beoordelingsElementId)) {
			return Response.ok().build();
		} else {
			return Response.status(404).build();
		}
	}

	@GET
	@Path("/{beoordelingsElementId}/toetselementen")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft alle toetselementen bij een beoordelingelement.")
	public Response findToetElementenByLeerdoel(@PathParam("beoordelingsElementId") int beoordelingsElementId) {
		List<ToetsElementDto> list = beoordelingsElementService
				.getToetslementenByBeoordelingsElement(beoordelingsElementId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

}
