package nl.hu.curcon.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.FunctionService;

@Component
@Path("/functions")
@Api(hidden = true)
public class FunctionRestService {
    @Autowired
    FunctionService functionService;

	@Autowired
	Domain2DtoMapper domain2DtoMapper;

	@Autowired
	Dto2DomainMapper dto2DomainMapper;

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public FunctionDto find(@PathParam("id") int id) {
		return functionService.find(id);
	}
}
