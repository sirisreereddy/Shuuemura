
package com.loreal.automation.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * @author TCS
 * 
 */
public class WebDriverFactory {

	/**
	 * This function initialize a WebDriver object using on the Browser type and
	 * remoteServerUrl
	 * 
	 * @param browserType
	 * @param remoteServerUrl
	 * @return RemoteWebdriver
	 * @throws MalformedURLException
	 */
	public static RemoteWebDriver getWebdriver(String browserType, URL remoteServerUrl) throws MalformedURLException {

		Logger logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
		logger.info("Browser type is:" + browserType);
		RemoteWebDriver webdriver = null;
		DesiredCapabilities driverCapability = null;
		ResourceBundle browserProperties = getBrowserProperties();

		if ("InternetExplorer".equalsIgnoreCase(browserType)) {
			try {

				System.setProperty("webdriver.ie.driver", browserProperties.getString("webdriver_ie_driver"));
				driverCapability = DesiredCapabilities.internetExplorer();
				driverCapability.setCapability("browserName", "internet explorer");
				driverCapability.setCapability("acceptSslCerts", "true");
				driverCapability.setCapability("javascriptEnabled", "true");
				driverCapability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);

				logger.info("getWebDriver - Setting webdriver.ie.driver system property as: "
						+ System.getProperty("webdriver.ie.driver"));
			}

			catch (IllegalStateException e) {
				logger.error(
						"The path to the driver executable must be set by the webdriver.ie.driver system property, Check IE driver path in Global.properties file",
						e.fillInStackTrace());
				throw new IllegalStateException(
						"The path to the driver executable must be set by the webdriver.ie.driver system property, Check IE driver path in Global.properties file");

			}
		}

		else if ("Firefox".equalsIgnoreCase(browserType)) {

			driverCapability = DesiredCapabilities.firefox();
			driverCapability.setCapability("browserName", "firefox");
		}
		else if ("Edge".equalsIgnoreCase(browserType)) {

			driverCapability = DesiredCapabilities.edge();
			driverCapability.setCapability("browserName", "edge");
		}

		else if ("Chrome".equalsIgnoreCase(browserType)) {
			try {

				System.setProperty("webdriver.chrome.driver", "D://chromedriver_win32//chromedriver.exe");
				driverCapability = DesiredCapabilities.chrome();

				driverCapability.setCapability("browserName", "chrome");

				driverCapability.setCapability("acceptSslCerts", "true");
				driverCapability.setCapability("javascriptEnabled", "true");
			}

			catch (IllegalStateException e) {
				logger.error(
						"The path to the driver executable must be set by the webdriver.ie.driver system property, Check IE driver path in Global.properties file",
						e.fillInStackTrace());
				throw new IllegalStateException(
						"The path to the driver executable must be set by the webdriver.ie.driver system property, Check IE driver path in Global.properties file");
			}
			driverCapability.setCapability("acceptSslCerts", true);
			driverCapability.setJavascriptEnabled(true);
		} else if ("PhantomJS".equalsIgnoreCase(browserType)) {

			System.setProperty("phantomjs.binary.path", browserProperties.getString("phantomjs_binary_path"));
			driverCapability = DesiredCapabilities.phantomjs();
			driverCapability.setJavascriptEnabled(true);
			driverCapability.setCapability("takesScreenshot", false);
		} else if ("Android".equalsIgnoreCase(browserType)) {
			driverCapability.setCapability("BROWSER_NAME", browserProperties.getString("mBrowser_name"));
			driverCapability.setCapability("VERSION", browserProperties.getString("android_version"));
			driverCapability.setCapability("deviceName", browserProperties.getString("device_name"));
			driverCapability.setCapability("platformName", "Android");
			driverCapability.setCapability("appPackage", "com.calculator");
			driverCapability.setCapability("appActivity", "com.calculator.Main");
		}

		else if (browserType == null) {
			logger.error(
					"DesiredCapabilities is null , Unable to instantiate new webDriver. Unrecognised browser identifier. "
							+ browserType
							+ "/n possible causes, \n\t1.'EXECUTION STATUS' column in data sheet is empty for all fields\n\t2.'EXECUTION STATUS' column in data sheet is 'N' for all fields");
		}

		else {
			logger.error(
					"DesiredCapabilities is null , Unable to instantiate new webDriver. Unrecognised browser identifier. "
							+ browserType);

		}
		System.out.print("Out of loop");
		webdriver = new RemoteWebDriver(remoteServerUrl, driverCapability);
	return webdriver;

	}

	/**
	 * This function reads Browser path from Global properties
	 * 
	 * @return Browser Properties
	 */
	public static ResourceBundle getBrowserProperties() {

		ResourceBundle browserProperties = null;
		browserProperties = ResourceBundle.getBundle("global");
		return browserProperties;

	}
}
