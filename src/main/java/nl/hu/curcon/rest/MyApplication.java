package nl.hu.curcon.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author berend.wilkens, 16 jun. 2017
 */
public class MyApplication extends ResourceConfig {
//	public static String BASE_URL = "http://curcon-huict.rhcloud.com/rest/";
	public static String BASE_URL = "http://localhost:8080/curcon/rest/";
	private static String baseUrl = null;

	public static String getBaseUrl() {
		baseUrl = BASE_URL;
		if (baseUrl == null) {
			Properties prop = new Properties();
			InputStream input = null;

			try {

				String filename = "config.properties";
				input = MyApplication.class.getClassLoader().getResourceAsStream(filename);
				if (input == null) {
					System.out.println("Sorry, unable to find " + filename);
					return null;
				}

				// load a properties file from class path, inside static method
				prop.load(input);

				// get the property value and print it out
				baseUrl = prop.getProperty("baseurl");

			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return baseUrl;
	}

	/**
	 * Register JAX-RS application components.
	 */
	public MyApplication() {
	    Logger logger = LoggerFactory.getLogger(MyApplication.class);
	    logger.info("Hello World");
	}
}
