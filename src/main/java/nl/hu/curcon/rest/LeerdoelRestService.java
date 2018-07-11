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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.LeerdoelDto;
import nl.hu.curcon.dto.ToetsElementDto;
import nl.hu.curcon.dto.post.LeerdoelPostDto;
import nl.hu.curcon.dto.post.ToetsElementPostDto;
import nl.hu.curcon.service.LeerdoelService;
import nl.hu.curcon.filter.FunctionChecker;

@Component
@Path("/leerdoelen")
@Api(hidden = false, value="[Leerdoel] Beheer van de leerdoelen.")
public class LeerdoelRestService {
	@Autowired
	LeerdoelService leerdoelService;
	@Autowired
	FunctionChecker functionChecker;

	@GET
	@Path("/{leerdoelId}")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	public Response find(@PathParam("leerdoelId") int leerdoelId) {
		if (!functionChecker.functionInUser("leerdoel_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		LeerdoelDto dto = leerdoelService.find(leerdoelId);
		if (dto != null) {
			return Response.ok(dto).build();
		} else {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("/{leerdoelId}")
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Wijzigt een leerdoel op basis van Id.")
	public Response update(@PathParam("leerdoelId") int leerdoelId, LeerdoelPostDto leerdoelDto) {
		if (!functionChecker.functionInUser("leerdoel_put")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		if (leerdoelService.update(leerdoelId, leerdoelDto)) {
			return Response.status(200).build();
		} else {
			return Response.status(412).build();
		}
	}

	@DELETE
	@Path("/{leerdoelId}")
	@Transactional
	@ApiOperation(value = "Verwijdert een leerdoel.")
	public Response delete(@PathParam("leerdoelId") int leerdoelId) {
		if (!functionChecker.functionInUser("leerdoel_delete")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		LeerdoelDto dto = leerdoelService.find(leerdoelId);
		if (dto != null) {
			leerdoelService.delete(dto.getId());
			return Response.status(200).build();
		} else {
			return Response.status(404).build();
		}

	}	
	
	@GET
	@Path("/{leerdoelId}/toetselementen")
	@Transactional
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(value = "Geeft alle toetselementen bij een leerdoel.")
	public Response findToetElementenByLeerdoel(@PathParam("leerdoelId") int leerdoelId) {
		if (!functionChecker.functionInUser("leerdoeltoetselementen_get")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		List<ToetsElementDto> list = leerdoelService.getToetslementenByLeerdoel(leerdoelId);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON })
	@Path("/{leerdoelId}/toetselementen")
	@ApiOperation(value = "Maakt een nieuw toetselement bij een leerdoel.")
	public Response createToetElementByLeerdoel(@PathParam("leerdoelId") int leerdoelId, ToetsElementPostDto toetsElementDto) {
		if (!functionChecker.functionInUser("leerdoeltoetselement_post")) {
			//Niet Geauthoriseerd
			return Response.status(403).build();
		}
		int toetsElementId = leerdoelService.createToetsElementByLeerdoel(leerdoelId, toetsElementDto);
		if (toetsElementId == 0) {
			return Response.status(404).build();
		}
		UriBuilder builder = UriBuilder.fromPath(MyApplication.getBaseUrl()).path("toetselementen/" + toetsElementId);
		URI uri = builder.build();
		return Response.status(201).contentLocation(uri).build();
	}


}
