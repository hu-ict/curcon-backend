package nl.hu.curcon.rest.enumuration;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import nl.hu.curcon.dto.MillerNiveauDto;
import nl.hu.curcon.service.MillerNiveauService;

@Component
@Path("/millerniveaus")
@Api(hidden = false, value="[MillerNiveau] Raadplegen van de Millerniveaus")
public class MillerNiveauRestService {
    @Autowired
    MillerNiveauService millerNiveauService;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<MillerNiveauDto> findAll() {
		return millerNiveauService.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public MillerNiveauDto find(@PathParam("id") int id) {
		return millerNiveauService.find(id);
	}

}
