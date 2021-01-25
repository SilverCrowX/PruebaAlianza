package com.alianza.rs.utilities;


import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class FLog {

	private static final String LOG_PROPERTIES_FILE = "log4j.properties";

	private static FLog loggerManagerFactory;

	private Logger lMSystem;

	private FLog() {
		
		Properties logProperties = new Properties();
		try {
			logProperties.load(new FileInputStream(LOG_PROPERTIES_FILE));
			PropertyConfigurator.configure(logProperties);
			initLogger();
		} catch (Exception e) {
			System.out.println("Unable to load logging property "
					+ LOG_PROPERTIES_FILE);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private void initLogger() {
		lMSystem = Logger.getLogger("sys");
	}


	private synchronized static FLog getInstance() {
		if (loggerManagerFactory == null) {
			loggerManagerFactory = new FLog();
		}
		return loggerManagerFactory;
	}


	public static Logger getLogger() {
		return getInstance().lMSystem;
	}

}