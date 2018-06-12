package nl.hu.curcon.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.ModuleService;

@Component
@Path("/modules")
@Api(hidden = true)
public class ModuleRestService {
	@Autowired
	ModuleService moduleService;

	@Autowired
	Domain2DtoMapper domain2DtoMapper;

	@Autowired
	Dto2DomainMapper dto2DomainMapper;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() {
		List<ModuleDto> list = moduleService.findAll();
		return Response.ok(list).build();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public ModuleDto find(@PathParam("id") int id) {
		return moduleService.find(id);
	}

	@GET
	@Path("/{id}/functions")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findOpleidingsProfielenByOrganisatie(@PathParam("id") int id) {
		List<FunctionDto> list = moduleService.findFunctionsByModuleId(id);
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
	}
}
