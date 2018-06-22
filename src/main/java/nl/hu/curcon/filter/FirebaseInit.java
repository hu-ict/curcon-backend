package nl.hu.curcon.filter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import nl.hu.curcon.domain.Function;
import nl.hu.curcon.dto.FunctionDto;
import nl.hu.curcon.service.UserService;

@Service
public class FirebaseInit {
	@Autowired 
	UserService userService; 
	// This is to connect to the firebase Console App/ Project where Only ADMINS should login
	public void FirebaseInitialize() throws IOException {
		// Only initializes an app if none exist yet.
		System.out.println("FIREBASEAPPS" + FirebaseApp.getApps().size());
		if (FirebaseApp.getApps().size() == 0) {
			// FIXME This is an aboslute path
			String path = "curconhu-firebase-adminsdk-gbgvn-e48f9044b6.json";

			InputStream serviceAccount = getClass().getResourceAsStream(path);
			//FileInputStream serviceAccount = new getResourceAsStream(path);

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					// .setDatabaseUrl("https://curconhu.firebaseio.com")
					.build();

			FirebaseApp.initializeApp(options);
		}
	}

	public boolean functionInUser(String function) {
		// FIXME dit gebeurt nu in het filter
		// FirebaseInit();
		String user = AuthenticationFilter.requestCtx.getSecurityContext().getUserPrincipal().getName();
		
		System.out.println("FirebaseCheck for function:" + function + "&user" + user);
		
		List<FunctionDto> functions=userService.findFunctionsByUsername(user);
		if (functions == null){
			System.out.println("gebruiker heeft geen functions en mag helemaal niks!");
			return false;
		}
		for(FunctionDto fDto : functions){
			if (fDto.getName().equals(function)){
				return true;
			}
			
		}
		return false;
	}

}