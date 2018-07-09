package nl.hu.curcon.filter;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInit {

	// This is to connect to the firebase Console App/ Project where Only ADMINS
	// should login
	public void FirebaseInitialize() throws IOException {
		// Only initializes an app if none exist yet.
		System.out.println("FIREBASEAPPS" + FirebaseApp.getApps().size());
		if (FirebaseApp.getApps().size() == 0) {
			// FIXME This is an aboslute path
			String path = "curconhu-firebase-adminsdk-gbgvn-e48f9044b6.json";

			InputStream serviceAccount = getClass().getResourceAsStream(path);
			// FileInputStream serviceAccount = new getResourceAsStream(path);

			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					// .setDatabaseUrl("https://curconhu.firebaseio.com")
					.build();

			FirebaseApp.initializeApp(options);
		}
	}

}