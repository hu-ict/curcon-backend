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
import io.swagger.annotations.ApiOperation;
import nl.hu.curcon.dto.ModuleDto;
import nl.hu.curcon.dto.OpleidingsProfielDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.RoleService;

	@Component
	@Path("/roles")
	@Api(hidden = true)
	public class RoleRestService {
	    @Autowired
	    RoleService roleService;

		@Autowired
		Domain2DtoMapper domain2DtoMapper;

		@Autowired
		Dto2DomainMapper dto2DomainMapper;

		@GET
		@Path("/{id}")
		@Produces({ MediaType.APPLICATION_JSON })
		public RoleDto find(@PathParam("id") int id) {
			return roleService.find(id);
		}
		@GET
		@Path("/{id}/modules")
		@Produces({ MediaType.APPLICATION_JSON })
		public Response findOpleidingsProfielenByOrganisatie(@PathParam("id") int id) {
			roleService.find(id).getModules();
			List<ModuleDto> list = roleService.findModulesByRoleId(id);
			if (list != null) {
				return Response.ok(list).build();
			} else {
				return Response.status(404).build();
			}
		}
	}
