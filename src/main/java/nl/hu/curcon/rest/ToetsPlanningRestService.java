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
import javax.ws.rs.core.MediaType;

import nl.hu.curcon.dto.ToetsPlanningDto;
import nl.hu.curcon.service.ToetsPlanningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;

@Component
@Path("/toetsplanningselementen")
@Api(hidden = true)
public class ToetsPlanningRestService {
    @Autowired
    ToetsPlanningService toetsPlanningService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<ToetsPlanningDto> findAll() {
		return toetsPlanningService.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ToetsPlanningDto find(@PathParam("id") int id) {
		return toetsPlanningService.find(id);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces(MediaType.APPLICATION_JSON)
	public ToetsPlanningDto create(ToetsPlanningDto toetsPlanningDto) {
		return toetsPlanningService.create(toetsPlanningDto);
	}

	@PUT
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public ToetsPlanningDto update(ToetsPlanningDto toetsPlanningDto) {
		return toetsPlanningService.update(toetsPlanningDto);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		toetsPlanningService.delete(id);
	}

}
