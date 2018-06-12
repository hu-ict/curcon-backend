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
import nl.hu.curcon.dto.HRefDto;
import nl.hu.curcon.dto.LinkDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.RoleService;
import nl.hu.curcon.service.UserService;

@Component
@Path("/users")
@Api(hidden = true)
public class UserRestService {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    
	@Autowired
	Domain2DtoMapper domain2DtoMapper;

	@Autowired
	Dto2DomainMapper dto2DomainMapper;

	//FIXME
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() {
		List<UserDto> list= userService.findAll();
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/{username}")
	@Produces({ MediaType.APPLICATION_JSON })
	public UserDto find(@PathParam("username") String username) {
		return userService.find(username);
	}
	@GET
	@Path("{username}/role")
	@Produces({ MediaType.APPLICATION_JSON })
	public HRefDto findRole(@PathParam("username") String username) {
		return userService.find(username).getRole();
	}
	@GET
	@Path("{username}/functions")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findFunctionsbyuser(@PathParam("username") String username) {
		//List<FunctionDto> list = moduleService.findFunctionsByModuleId(id);

		List<FunctionDto> list= userService.findFunctionsByUsername(username);
		for (FunctionDto f :list){
			System.out.println(f.getName());
		}
		if (list != null) {
			return Response.ok(list).build();
		} else {
			return Response.status(404).build();
		}
		
	}
	
}