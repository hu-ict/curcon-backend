package nl.hu.curcon.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.LinkDto;
import nl.hu.curcon.dto.RoleDto;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.dtomapper.Domain2DtoMapper;
import nl.hu.curcon.dtomapper.Dto2DomainMapper;
import nl.hu.curcon.service.UserService;

@Component
@Path("/users")
@Api(hidden = true)
public class UserRestService {
    @Autowired
    UserService userService;

	@Autowired
	Domain2DtoMapper domain2DtoMapper;

	@Autowired
	Dto2DomainMapper dto2DomainMapper;

	@GET
	@Path("/{username}/{password}")
	@Produces({ MediaType.APPLICATION_JSON })
	public UserDto find(@PathParam("username") String username) {
		return userService.find(username);
	}
	@GET
	@Path("{username}/role")
	@Produces({ MediaType.APPLICATION_JSON })
	public LinkDto findRole(@PathParam("username") String username) {
		return userService.find(username).getRole();
	}
}