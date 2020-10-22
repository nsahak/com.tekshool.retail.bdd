package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

public class Base {

	// In this class, we define property of below Classes and will use them to child
	// classes
	// WebDriver
	// Logger
	// Properties Class

	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;

	private String projectPropertyFilePath = ".\\src\\test\\resources\\InputData\\projectProp.properties";
	private String log4JFilePath = ".\\src\\test\\resources\\InputData\\log4j.properties";

	// We are creating a constructor here
	public Base() {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(projectPropertyFilePath));
			properties = new Properties();
			properties.load(reader);
			reader.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger = logger.getLogger("logger_file");
		PropertyConfigurator.configure(log4JFilePath);

	}

	/**
	 * This method will return value of browser name such as Chrome, FireFox, IE,
	 * and Headless browser
	 * 
	 * @return
	 */
	public static String getBrowserName() {
		String browserName = properties.getProperty("browser");
		return browserName;

	}
	/**
	 * This method will return URL of application we use for this Framework
	 * 
	 * @return
	 */

	public static String getURL() {
		String url = properties.getProperty("url");
		return url;
	}

	/**
	 * This method will return implicitly wait time and parse it to long data type
	 * as Implicitly wait method in selenium accepts long dataType
	 * 
	 * @return
	 */
	public static Long getImpWait() {
		String impWait = properties.getProperty("implicitlyWait");
		return Long.parseLong(impWait);
	}

	/**
	 * This method will return pageLoadTime Out wait time and parse it to long data
	 * type as pageLoadTime wait method in selenium accepts long dataType
	 * 
	 * @return
	 */
	public static Long getPageLoadTimeOut() {
		String pageLoadTimeOut = properties.getProperty("pageLoadTimeOut");
		return Long.parseLong(pageLoadTimeOut);

	}

	/**
	 * This method will initialize the WebDriver whenever we call it.
	 */
	public static void initializeDriver() {
		driver.get(getURL());
	}

	/**
	 * This method will Close and Quit all windows after each execution.
	 */
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
