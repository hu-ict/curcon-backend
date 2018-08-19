package nl.hu.curcon.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;


@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {
	public static ContainerRequestContext requestCtx;
	 @Autowired
	 FirebaseInit firebaseInit;
	
	@Override
	public void filter(ContainerRequestContext requestCtxNew) throws IOException {
		AuthenticationFilter.requestCtx = requestCtxNew;

		// Users are treated as guests, unless a valid token is provided
		boolean isSecure = requestCtxNew.getSecurityContext().isSecure();
		MySecurityContext msc = new MySecurityContext(null,null, isSecure);
		// Check if the HTTP Authorization header is present and formatted
		// correctly
		String authHeader = requestCtxNew.getHeaderString(HttpHeaders.AUTHORIZATION);
		System.out.println(authHeader + "44");
		if (authHeader != null) {// FIXME && authHeader.startsWith("Bearer ")) {
			// Extract the token from the HTTP Authorization header
			// FIXME String token =
			// authHeader.substring("Bearer".length()).trim();
			String idToken = authHeader;
			try {
				// Validate the token
				// FIXME init 1x in de applicatie laten gebeuren waar?
				firebaseInit.FirebaseInitialize();

				FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
				String user = decodedToken.getEmail();
				System.out.println("FILTER DECODED EMAIL" + user);

				msc = new MySecurityContext(user, "r0leUnused", isSecure);
				System.out.println("Testtest end of  verify token here");

			} catch (IllegalArgumentException e) {
				System.out.println("Invalid token, processing as guest!");
				 msc = getunknown();
			} catch (FirebaseAuthException e) {
				System.out.println("ERROR FIREBASEEXCEPTION was null");
				// TODO Auto-generated catch block
				e.printStackTrace();
				msc = getunknown();
			}
		}else{
			System.out.println("ERROR header was null");
			 msc = getunknown();
		}
		System.out.println(msc + "43");
		requestCtx.setSecurityContext(msc);
	}
	private MySecurityContext getunknown(){
		System.out.println("ERROR setting to unkownw");
		 return new MySecurityContext("Unknown", "guest", false);
	}
}
