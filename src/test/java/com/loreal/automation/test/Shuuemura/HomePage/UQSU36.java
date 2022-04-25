/**VERIFY THAT HOME PAGE HAS ALL MAJOR NAVIGATION
 * @author SURYA
 *
 */

package com.loreal.automation.test.Shuuemura.HomePage;

import java.util.ArrayList;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.loreal.automation.base.BaseTest;

import com.loreal.automation.pages.Shuuemura.HomePage;
import com.loreal.automation.utilities.EnvironmentTestData;
import com.relevantcodes.extentreports.LogStatus;


public class UQSU36 extends BaseTest {
		public UQSU36() 
		{
			super("UQSU36");
		}

		public UQSU36(String testName, String browser) {

			super(testName, browser);
		}

		/*@Factory(dataProvider = "dataSheet")
		public Object[] testCreator(LinkedHashMap<String, String> mapDataSheet) {
			return new Object[] { new UQSU36(this.getClass().getSimpleName(), mapDataSheet.get("Browser"), mapDataSheet) };
		}

		@DataProvider(name = "dataSheet", parallel = true)
		public Object[][] getTestData() throws BiffException, IOException, InvalidBrowserException, DataSheetException {
			return testDataProvider.getTestDataFromExcel(externalSheetPath, this.getClass().getSimpleName());
		}*/
		@BeforeTest
		public void before() {

			test = TestReportGenerator(report, this.getClass().getSimpleName(),"VERIFY THAT HOME PAGE HAS ALL MAJOR NAVIGATION");
		}
		@Test
		public void test() throws Exception {

			if(channel.equalsIgnoreCase("Desktop")){

				HomePage homePageObject = new HomePage(driver,test);	
				EnvironmentTestData objData = new EnvironmentTestData();
				objData.setTestData();
				test.log(LogStatus.PASS,"TEST CASE NAME:HOME PAGE,VERIFYING MENU LINKS");
				Reporter.log("TEST CASE NAME:HOME PAGE,VERIFYING MENU LINKS");

				homePageObject.launchBasePage();
				ArrayList<String> menu = new ArrayList<String>();
				menu=EnvironmentTestData.menu;
				int menuItems=Integer.parseInt(objData.menuItems);
				for(int i=0;i<menuItems;i++) {
					homePageObject.verifyMainMenuHeaderLinks(menu.get(i));
				}
				homePageObject=null;
				System.gc();
			}
			else if(channel.equalsIgnoreCase("Mobile"))
			{	
				HomePage homePageObject = new HomePage(driver,test);
				EnvironmentTestData objData = new EnvironmentTestData();
				homePageObject.launchBasePageMobile();
				test.log(LogStatus.PASS,"TEST CASE NAME:HOME PAGE,VERIFYING MENU LINKS");
				Reporter.log("TEST CASE NAME:HOME PAGE,VERIFYING MENU LINKS");

				homePageObject.clickHamburgerMenuButtonInHeaderMobile();
				ArrayList<String> menu = new ArrayList<String>();
				menu=EnvironmentTestData.menu;
				int menuItems=Integer.parseInt(objData.menuItems);
				for(int i=0;i<menuItems;i++) {
					homePageObject.verifyMainMenuHeaderLinks(menu.get(i));
				}
				homePageObject=null;
				System.gc();
			}

		}
	}
