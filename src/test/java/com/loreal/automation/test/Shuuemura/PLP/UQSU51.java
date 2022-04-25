/**VERIFYING PLP(HOVER,THEN CLICK)
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


public class UQSU51 extends BaseTest {
	public UQSU51() {
		super("UQSU51");
	}

	public UQSU51(String testName, String browser) {

		super(testName, browser);
	}

	
	@BeforeTest
	public void before() {

		test = TestReportGenerator(report, this.getClass().getSimpleName(),"TEST CASE NAME: VERIFY PLP");
	}
	@Test
	public void test() throws Exception {

		if (channel.equalsIgnoreCase("Desktop")) {

			HomePage homePageObject = new HomePage(driver,test);
			ProductLandingPage plp = new ProductLandingPage(driver,test);
			EnvironmentTestData objData = new EnvironmentTestData();
			objData.setTestData();
			test.log(LogStatus.PASS,"TEST CASE NAME: VERIFY PLP");
			Reporter.log("TEST CASE NAME: VERIFY PLP");

			homePageObject.launchBasePage();
			homePageObject.hoverOnMainMenu(objData.mainmenu3);
			homePageObject.clickSubMenuLink(objData.submenu3);
			plp.verifyBreadCrumb("travel size conditioners");
			plp.verifyPLPPage("travel size conditioners");
			homePageObject=null;
			plp=null;
			
			System.gc();

		}
	}

}
