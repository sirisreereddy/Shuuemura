package com.loreal.automation.base;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.loreal.automation.exceptions.DataSheetException;


import com.loreal.automation.utilities.TestDataProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.remote.MobileCapabilityType;
import jxl.JXLException;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.biff.JxlWriteException;


/**
 * @author TCS
 * 
 */
public abstract class BaseTest {

	public static String databaseName;
	public static String databasePassword;
	public static String databaseServerIP;
	public static String databaseType;
	public static String databaseUserName;
	public static String testDataSource;
	public static ExtentReports report;
	public  ExtentTest test;
	public static String externalSheetPath;
	public static String propertyfilepath;
	public static String webdriverServerHostName;
	public static String webdriverServerPortName;
	public static String webdriverUrl;
	public int timeOut;
	public static String channel;
	public static String webdriverServerHostNameAppium;
	public static String webdriverServerPortNameAppiumAndroid;
	public static String webdriverServerPortNameAppiumIos;
	public WebDriver driver;
	public WebDriver getDriver() {
		return driver;
	}

	public LinkedHashMap<String, String> mapDataSheet;
	public TestDataProvider testDataProvider;
	public String testName;
	public String testBrowser;
	public static ResourceBundle globalProperties;
	public static ResourceBundle gridProperties;
	ResourceBundle browserProperties = getBrowserProperties();

	private static final Logger logger = LogManager.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

	//Data row count.
	//So that data can be written back to excel at the same row.
	public int rowCount;
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public BaseTest()  {
		this.testDataProvider = new TestDataProvider();
		getGridProperties();
		getGlobalProperties();

	}

	/**
	 * @param browser
	 * @param mapDataSheet
	 */
	public BaseTest(String testName, String browser) {
		this.testName = testName;
		this.testDataProvider = new TestDataProvider();
		this.testBrowser = browser;
		getGridProperties();
		getGlobalProperties();

	}
	public BaseTest(String testName) {
		this.testName = testName;
		getGridProperties();
		getGlobalProperties();
	}
	/*public BaseTest(String testName, String browser,
			LinkedHashMap<String, String> mapDataSheet) {
		this.testName = testName;
		this.testDataProvider = new TestDataProvider();
		this.testBrowser = browser;
		this.mapDataSheet = mapDataSheet;
		this.rowCount = Integer.parseInt(mapDataSheet.get("rowCount"));

	}*/
	public static ExtentTest TestReportGenerator(ExtentReports report,String testNameOfCurrentThread,String desc) {
		ExtentTest test= report.startTest(testNameOfCurrentThread, desc);
		return test;
	}
	@BeforeTest

	public void startReport() {
		String fileName = new SimpleDateFormat("dd MMMM yyyy").format(new Date());
	report = new ExtentReports("C:\\Shuuemura\\Stomme_Basic_Build1.0\\AutomationExtent\\Shuuemura"+fileName+"_"+System.currentTimeMillis()+".html");
	report.addSystemInfo("Host Name", "SHUUEMURA US");
	report.addSystemInfo("Browser", "Chrome");
	report.addSystemInfo("User Name", "Siri");
	report.loadConfig(new File("C:\\Shuuemura\\Stomme_Basic_Build1.0\\ExtentReport.xml"));
    }
	@AfterTest
	public void endReport() {
		report.endTest(test);
		report.flush();
	}

	/**
	 * This function initiate a web driver client
	 * @throws MalformedURLException 
	 * 
	 * @throws Exception
	 */

@Parameters("browser")
@BeforeMethod
	public WebDriver beforemethod(String browser) throws MalformedURLException{
		DesiredCapabilities driverCapability = null;

		if(!(browser==null))
		{
			
			
			String formattedTime = timeFormat.format(new Date()).toString(); 
			logger.info("\n" +
					"\nTest Case Name            :  "+testName+
					"\nStart time                :  "+formattedTime+
					"\n-------------------------------------------------------------------------------------------------------------------------------------");

			if (browser.equalsIgnoreCase("Firefox")
					|| browser.equalsIgnoreCase("InternetExplorer")
					|| browser.equalsIgnoreCase("Chrome")
					||browser.equalsIgnoreCase("Android")
					||browser.equalsIgnoreCase("iOS")
					||browser.equalsIgnoreCase("HeadlessChrome")
					||browser.equalsIgnoreCase("Edge")){
				
				if ("InternetExplorer".equalsIgnoreCase(browser)) {
					try {
						 
						System.setProperty("webdriver.ie.driver", browserProperties.getString("webdriver_ie_driver"));
						driver = new InternetExplorerDriver();
						driver.manage().window().maximize();
						channel="Desktop";
						
					}

					catch (IllegalStateException e) {
						logger.error(
								"The path to the driver executable must be set by the webdriver.ie.driver system property, Check IE driver path in Global.properties file",
								e.fillInStackTrace());
						throw new IllegalStateException(
								"The path to the driver executable must be set by the webdriver.ie.driver system property, Check IE driver path in Global.properties file");

					}
				}

				else if ("Firefox".equalsIgnoreCase(browser)) {

					driverCapability = DesiredCapabilities.firefox();
					driverCapability.setCapability("browserName", "firefox");
				}
				else if ("Edge".equalsIgnoreCase(browser)) {

					System.setProperty("webdriver.edge.driver", browserProperties.getString("webdriver_edge_driver"));
					EdgeOptions edgeOptions = new EdgeOptions();
					DesiredCapabilities capabilities = DesiredCapabilities.edge();
					capabilities.setCapability(ChromeOptions.CAPABILITY, edgeOptions);
					driver=new EdgeDriver(capabilities);
					channel="Desktop";
				}


				else if ("Chrome".equalsIgnoreCase(browser)) {
					try {

						System.setProperty("webdriver.chrome.driver", browserProperties.getString("webdriver_chrome_driver"));
						ChromeOptions options = new ChromeOptions();
						options.addArguments("--incognito");
						options.addArguments("--start-maximized");
						DesiredCapabilities capabilities = DesiredCapabilities.chrome();
						capabilities.setCapability(ChromeOptions.CAPABILITY, options);
						driver=new ChromeDriver(capabilities);
						channel="Desktop";
					}

					catch (IllegalStateException e) {
						logger.error(
								"The path to the driver executable must be set by the webdriver.ie.driver system property, Check IE driver path in Global.properties file",
								e.fillInStackTrace());
						throw new IllegalStateException(
								"The path to the driver executable must be set by the webdriver.ie.driver system property, Check IE driver path in Global.properties file");
					}
					
				}
				else if ("HeadlessChrome".equalsIgnoreCase(browser)) {
					try {

						System.setProperty("webdriver.chrome.driver", browserProperties.getString("webdriver_chrome_driver"));
						System.setProperty("webdriver.chrome.silentOutput", "true");
						ChromeOptions options = new ChromeOptions();
						options.addArguments("--incognito");
						options.addArguments("--headless");
						options.addArguments("--disabled-gpu");
						options.addArguments("--window-size=1600,900");
						DesiredCapabilities capabilities = DesiredCapabilities.chrome();
						capabilities.setCapability(ChromeOptions.CAPABILITY, options);
						driver=new ChromeDriver(capabilities);
						channel="Desktop";
					}

					catch (IllegalStateException e) {
						logger.error(
								"The path to the driver executable must be set by the webdriver.ie.driver system property, Check IE driver path in Global.properties file",
								e.fillInStackTrace());
						throw new IllegalStateException(
								"The path to the driver executable must be set by the webdriver.ie.driver system property, Check IE driver path in Global.properties file");
					}
					
				}
				else if ("Android".equalsIgnoreCase(browser)) {
					 try {
						 driverCapability=DesiredCapabilities.android();
						driverCapability.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
						driverCapability.setCapability(MobileCapabilityType.PLATFORM_VERSION, browserProperties.getString("android_version"));
						driverCapability.setCapability(MobileCapabilityType.DEVICE_NAME, browserProperties.getString("device_name"));
						driverCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
						driverCapability.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
						driverCapability.setCapability("autoAcceptAlerts", true);
						driverCapability.setCapability("chromedriverExecutable","C:\\chromedriver\\chromedriver.exe");
						driverCapability.setCapability("newCommandTimeout", "60");
						
						URL remoteServerUrlAppium = new URL("http://" + BaseTest.webdriverServerHostNameAppium + ":"
								+ BaseTest.webdriverServerPortNameAppiumAndroid + "/wd/hub");
						driver=new RemoteWebDriver(remoteServerUrlAppium, driverCapability);
						channel="Mobile";
					}
				 
					 catch(Exception e) {
						 e.printStackTrace();
					 }
				 }
				 else if ("iOS".equalsIgnoreCase(browser)) {
						try {

							driverCapability = new DesiredCapabilities();
							driverCapability.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
							driverCapability.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
							driverCapability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.2");
							driverCapability.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
							/*driverCapability.setCapability(MobileCapabilityType.AUTOMATION_NAME,
									AutomationName.IOS_XCUI_TEST);*/

							URL remoteServerUrlAppium = new URL("http://" + BaseTest.webdriverServerHostNameAppium + ":"
									+ BaseTest.webdriverServerPortNameAppiumIos + "/wd/hub");
							driver = new RemoteWebDriver(remoteServerUrlAppium, driverCapability);
							channel = "Mobile";
							Screen s=new Screen();
							Pattern image1=new Pattern("/Users/cpgdigital/Desktop/UD_USER");
							Pattern image2=new Pattern("/Users/cpgdigital/Desktop/UD_PASS");
							Pattern image3=new Pattern("/Users/cpgdigital/Desktop/UD_LOGIN");
							s.find(image1);
							s.type(image1,"storefront");
							s.click(image2);
							s.type(image2,"loreal1");
							s.click(image3);
							Thread.sleep(10000);
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

						} catch (Exception e) {
						}
					}
		}
			else{
				logger.error("Browser name"
						+ " '"
						+ testBrowser
						+ "' "
						+ "is invalid:Please give InternetExplorer, Chrome, Firefox, Android or PhantomJS");
			}
		}
		
return driver;

	}

	
@AfterMethod
public void getResult(ITestResult result){
	if(result.getStatus() == ITestResult.FAILURE)
	  {
	  test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
	  test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
   	  }
	else if(result.getStatus() == ITestResult.SUCCESS)
      {
      test.log(LogStatus.PASS, "Test Case Passed is "+result.getName());
      }
	else if(result.getStatus() == ITestResult.SKIP)
	  {
	  test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
	  test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getThrowable());
	  }
	takeScreenshot();
	driver.close();
	driver.quit();

	}

	
	/**
	 * This function reads Global properties
	 * @throws DataSheetException 
	 */
protected void getGlobalProperties() {

	globalProperties = ResourceBundle.getBundle("global");

	timeOut = Integer.parseInt(globalProperties.getString("time_out"));
	if (globalProperties.containsKey("test_data_source")) {
		testDataSource = globalProperties.getString("test_data_source");
	}
	if(testDataSource.equalsIgnoreCase("excel")){
		externalSheetPath = globalProperties.getString("external_sheet_path");
		System.out.println("Path : " + externalSheetPath);
		if(externalSheetPath.equals(""))
		{
			logger.error("Please provide a valid sheet path");
			Assert.fail();
		}
	}
	else if(testDataSource.equalsIgnoreCase("database")){

		databaseName = globalProperties.getString("database_name");
		databaseType = globalProperties.getString("database_type");
		databaseUserName = globalProperties.getString("database_username");
		databasePassword = globalProperties.getString("database_password");
		databaseServerIP = globalProperties.getString("database_ip");
	}
	
	else if(testDataSource.equalsIgnoreCase("PropertiesFile")){
		propertyfilepath = globalProperties.getString("properties_file_path");
		System.out.println("Path : " + propertyfilepath);
		if(propertyfilepath.equals(""))
		{
			logger.error("Please provide a valid file path");
			Assert.fail();
		}
	}
	
	else if(testDataSource.equalsIgnoreCase("TestDataClass")){
		System.out.println("TestData Source : Environment TestData Class");
	}
	else{
		logger.error("Please provide a valid test data source value");
		Assert.fail();
	}
}



	/**
	 * This function reads Grid properties
	 */
protected void getGridProperties() {

	gridProperties = ResourceBundle.getBundle("grid");
	webdriverServerHostName = gridProperties
			.getString("webdriver_hostname");
	webdriverServerPortName = gridProperties.getString("webdriver_port");
	webdriverUrl = gridProperties.getString("webdriver_defaultURL");
	webdriverServerHostNameAppium=gridProperties.getString("webdriver_hostname_Appium");
	webdriverServerPortNameAppiumAndroid=gridProperties.getString("webdriver_port_Appium_Android");
	webdriverServerPortNameAppiumIos=gridProperties.getString("webdriver_port_Appium_Ios");
}




	public static ResourceBundle getBrowserProperties() {

		ResourceBundle browserProperties = null;
		browserProperties = ResourceBundle.getBundle("global");
		return browserProperties;
	}
	/**
	 * This function retrieve the Base URL from Grid properties
	 * 
	 * @return - Returns the Application's Base URL
	 */
	public static String getBaseURL() {
		
		
		return webdriverUrl;
	}

	/**
	 * This method will return the browser names specified in global properties file
	 * 
	 * @return array of browser names
	 */
	public static String[] getBrowserName()
	{
		String[] browserArray = null;

		if (globalProperties.containsKey("browser_name")) {


			String browsers=globalProperties.getString("browser_name");
			if(browsers.contains(",")){
				browserArray = browsers.trim().split(",");
			}
			else{
				browserArray=browsers.trim().split(" ");
			}
			for (String browser : browserArray) {
				if(browser.equalsIgnoreCase("Firefox")||
				   browser.equalsIgnoreCase("InternetExplorer")||
				   browser.equalsIgnoreCase("Chrome")||
				   browser.equalsIgnoreCase("Android")||
				   browser.equalsIgnoreCase("iOS")){
					return browserArray;
				}
				else
				{
					logger.error("Browser name specified in global properties file is invalid. Please give InternetExplorer,Chrome ,Firefox,Android or PhantomJS");

				}
			}

		} else {
			logger.error("No browser name specified for the test execution");

		}
		return browserArray;
	}

	public static String getGlobalBrowserFlag()
	{
		return globalProperties.getString("use_global_browser_forExcel");

	}

	public void takeScreenshot() throws ScreenshotException {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(globalProperties.getString("screenshot.directory") + "\\" + testName
					+ "_" + System.nanoTime() + ".png"));
			logger.info("Screen shot has been taken");

		} catch (IOException e) {

			logger.error("The filename, directory name, or volume label syntax of screenshot is incorrect");
			e.printStackTrace();
		} catch (ScreenshotException e1) {

			throw new ScreenshotException("Unable to take screenshot");
		}

	}
	public String getValue(String key)
	{

		if(mapDataSheet.containsKey(key)){
			return mapDataSheet.get(key);
		}

		else
		{
			logger.info("Column heading '"+key+"' is not present in your data source \n Please Check the Column Headings of your TestCase's data in your data source (Excel / Database)");
			throw new NullPointerException("Column heading "+key+"is not present in your data source \n Please Check the Column Headings of your TestCase's data in your data source (Excel / Database)");
		}


	}

	public Alert isAlertPresent()
	{
		try
		{
			Alert alert = driver.switchTo().alert();

			return alert;
		} catch (NoAlertPresentException e) {

			return null;
		}

	}


	//Method to write back the data from a test method
	//stored as as a Linked-hash-map
	public void addDataToOutputExcel(LinkedHashMap<String, String> outputData) throws BiffException, IOException, JxlWriteException, JXLException
	{
		Workbook workbook = Workbook.getWorkbook(new File(externalSheetPath)); 
		WritableWorkbook copy = Workbook.createWorkbook(new File(externalSheetPath), workbook);

		WritableSheet sheet2 = copy.getSheet(testName);

		 WritableCellFormat cellFormat = new WritableCellFormat();
		 cellFormat.setBackground(Colour.VERY_LIGHT_YELLOW);
		 WritableCellFormat cellFormatHeading = new WritableCellFormat();
		 cellFormatHeading.setBackground(Colour.GRAY_25);
		
		int coloumn = sheet2.getColumns();
		int increment=0;
		for(String key: outputData.keySet())
		{	
			String data = outputData.get(key);
			boolean keyExist = false; 
			for(int i=0;i<coloumn; i++){
				String content = sheet2.getCell(i, 0).getContents();
				if(content.equalsIgnoreCase(key)){
					keyExist =true;
					//Updating Excel CValue
					Label label2 = new Label(i, rowCount, data,cellFormat);
					sheet2.addCell(label2);

					//Updating Hash-map
					if(mapDataSheet.containsKey(key)){
						mapDataSheet.put(key, data);
					}
					break;
				}//if
			}//for

			if(keyExist==false){
				//inserting a new key in excel
				Label label = new Label(coloumn+increment, 0, key,cellFormatHeading);
				Label label2 = new Label(coloumn+increment, rowCount, data,cellFormat);
				sheet2.addCell(label); 
				sheet2.addCell(label2);
				increment++;
				//Inserting new Key Value in HAshmap
				mapDataSheet.put(key, data);
			}//if
		}//for

		copy.write();
		copy.close();
		if(workbook != null)
		{
			workbook.close();
		}   

	}//addDataToOutputExcel
	
}