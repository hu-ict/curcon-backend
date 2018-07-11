package nl.hu.curcon.filter;

import java.security.Principal;
import java.util.List;

import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.service.UserService;

@Service
public class FunctionChecker {
	@Autowired
	UserService userService;
	
	public boolean functionInUser(String function) {
		String user = null;
		while (user == null) {
			try {
				SecurityContext ctx= AuthenticationFilter.requestCtx.getSecurityContext();
				Principal principal=ctx.getUserPrincipal();
				user=principal.getName();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// String user =
		// AuthenticationFilter.requestCtx.getSecurityContext().getUserPrincipal().getName();

		System.out.println("functionChecker:" + function + "&user" + user);

		List<FunctionDto> functions = userService.findFunctionsByUsername(user);
		if (functions == null) {
			System.out.println("gebruiker heeft geen functions en mag helemaal niks!");
			return false;
		}
		for (FunctionDto fDto : functions) {
			if (fDto.getName().equals(function)) {
				return true;
			}

		}
		return false;
	}
}
