/**VERIFYING sORTING
 * @author SURYA
 *
 */

package com.loreal.automation.test.Shuuemura.PLP;



import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.loreal.automation.base.BaseTest;

import com.loreal.automation.pages.Shuuemura.HomePage;
import com.loreal.automation.pages.Shuuemura.ProductLandingPage;
import com.loreal.automation.utilities.EnvironmentTestData;
import com.relevantcodes.extentreports.LogStatus;


public class UQSU52 extends BaseTest {
	public UQSU52() {
		super("UQSU52");
	}

	public UQSU52(String testName, String browser) {

		super(testName, browser);
	}

	
	@BeforeTest
	public void before() {

		test = TestReportGenerator(report, this.getClass().getSimpleName(),"TEST CASE NAME: SORTING ");
	}
	@Test
	public void test() throws Exception {

		if (channel.equalsIgnoreCase("Desktop")) {

			HomePage homePageObject = new HomePage(driver,test);
			ProductLandingPage plp = new ProductLandingPage(driver,test);
			EnvironmentTestData objData = new EnvironmentTestData();
			objData.setTestData();
			test.log(LogStatus.PASS,"TEST CASE NAME: SORTING");
			Reporter.log("TEST CASE NAME: SORTING ");

			homePageObject.launchBasePage();
			homePageObject.hoverOnMainMenu(objData.mainmenu);
			homePageObject.clickSubMenuLink(objData.submenu);
			plp.SortByFunctionality();
			homePageObject=null;
			plp=null;
			System.gc();


		}
	}

}

