package nl.hu.curcon.rest.enumuration;
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

import nl.hu.curcon.dto.OsirisResultaatTypeDto;
import nl.hu.curcon.service.OsirisResultaatTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;

@Component
@Path("/osirisresultaattypen")
@Api(hidden = false, value = "CRUD operaties op het OsirisResultaatType.")
public class OsirisResultaatTypeRestService {
    @Autowired
    OsirisResultaatTypeService osirisResultaatTypeService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<OsirisResultaatTypeDto> findAll() {
		return osirisResultaatTypeService.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public OsirisResultaatTypeDto find(@PathParam("id") int id) {
		return osirisResultaatTypeService.find(id);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public OsirisResultaatTypeDto create(OsirisResultaatTypeDto osirisResultaatTypeDto) {
		return osirisResultaatTypeService.create(osirisResultaatTypeDto);
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON })
	public OsirisResultaatTypeDto update(OsirisResultaatTypeDto osirisResultaatTypeDto) {
		return osirisResultaatTypeService.update(osirisResultaatTypeDto);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		osirisResultaatTypeService.delete(id);
	}
}
