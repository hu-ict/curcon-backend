package nl.hu.curcon.rest;

//import java.security.Key;
//import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
/* import com.fasterxml.classmate.util.ResolvedTypeCache.Key; */
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import nl.hu.curcon.domain.User;

//import com.google.common.net.HttpHeaders;

//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.curcon.dto.UserDto;
import nl.hu.curcon.service.UserService;

@Path("/authentication/{username}/{password}")
public class AuthenticationRestService {
//	public static final Key key = MacProvider.generateKey(); 
	@Autowired
	UserService userService;
	
	 @POST   
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)   
	 public Response authenticateUser(@PathParam("username") String username,                                     
			 						  @PathParam("password") String password) {     
		 try {  
			 UserDto userDto = userService.find(username, password);            
			 	
			 if (userDto == null) { 
				 throw new IllegalArgumentException("No user found!");  
			 }               
			
			 // Issue a token for the user       
//			 Calendar expiration = Calendar.getInstance();       
//			 expiration.add(Calendar.MINUTE, 30);          
//			 String token =  Jwts.builder()         
//					 .setSubject(username)         
//					 .claim("role", userDto)         
//					 .setExpiration(expiration.getTime())         
//					 .signWith(SignatureAlgorithm.HS512, key)         
//					 .compact(); 
		 
			 // Return the token on the response
			 
			 //String token = authHeader.substring("Bearer".length()).trim(); 
			return Response.status(300).build();
	 
	    } //catch (JwtException | IllegalArgumentException e) {
		 catch (IllegalArgumentException e) {
			 e.printStackTrace();
	    	return Response.status(Response.Status.UNAUTHORIZED).build();     
    	}   
	}
}
