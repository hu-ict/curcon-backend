package nl.hu.curcon.generic;

import java.net.InetAddress;

import org.springframework.web.context.support.XmlWebApplicationContext;

public class PerHostXmlWebApplicationContext extends XmlWebApplicationContext {

	protected String[] getDefaultConfigLocations() {
		String hostname = "localhost";
		try {
			hostname = InetAddress.getLocalHost().getHostName();
		} catch (Exception e) {
		}

		String perHostConfiguration = DEFAULT_CONFIG_LOCATION_PREFIX
				+ "applicationContext-" + hostname
				+ DEFAULT_CONFIG_LOCATION_SUFFIX;

		logger.debug("Adding per host configuration file: "
				+ perHostConfiguration);

		if (getNamespace() != null) {
			return new String[] {
					DEFAULT_CONFIG_LOCATION_PREFIX + getNamespace()
							+ DEFAULT_CONFIG_LOCATION_SUFFIX,
					perHostConfiguration };
		} else {
			return new String[] { DEFAULT_CONFIG_LOCATION, perHostConfiguration };
		}
	}
}