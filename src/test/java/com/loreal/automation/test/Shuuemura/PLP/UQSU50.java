/**VERIFYING PLP DETAILS(CLICK)
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


public class UQSU50 extends BaseTest {
	public UQSU50() 
	{
		super("UQSU50");
	}

	public UQSU50(String testName, String browser) {

		super(testName, browser);
	}

	
	@BeforeTest
	public void before() {

		test = TestReportGenerator(report, this.getClass().getSimpleName(),"VERIFYING PLP DETAILS(CLICK)");
	}
	@Test
	public void test() throws Exception {

		if(channel.equalsIgnoreCase("Desktop")){

			HomePage homePageObject = new HomePage(driver,test);	
			ProductLandingPage plp = new ProductLandingPage(driver,test);
			EnvironmentTestData objData = new EnvironmentTestData();
			objData.setTestData();
			test.log(LogStatus.PASS,"TEST CASE NAME: VERIFYING PLP PAGE");
			Reporter.log("TEST CASE NAME: VERIFYING PLP PAGE");

			homePageObject.launchBasePage();
			homePageObject.hoverOnMainMenu(objData.mainmenu3);
			homePageObject.clickSubMenuLink(objData.submenu3);
			//homePageObject.clickMainMenuLink("menu");
			//homePageObject.clickSubMenuLink("submenu");
			plp.verifyBreadCrumb("conditioners");
			plp.verifyPLPPage("conditioners");
			plp.verifyPLP("conditioners");
			homePageObject=null;
			plp=null;
			System.gc();
			
		}
		else if(channel.equalsIgnoreCase("Mobile"))
		{	
			HomePage homePageObject = new HomePage(driver,test);	
			ProductLandingPage plp = new ProductLandingPage(driver,test);
			EnvironmentTestData objData = new EnvironmentTestData();
			objData.setTestData();
			homePageObject.launchBasePageMobile();
			test.log(LogStatus.PASS,"TEST CASE NAME: VERIFYING PLP PAGE");
			Reporter.log("TEST CASE NAME: VERIFYING PLP PAGE");

			homePageObject.clickHamburgerMenuButtonInHeaderMobile();
			homePageObject.clickMainMenuLinkMobile(objData.mainmenu1);
			homePageObject.clickSubMenuLink(objData.submenu1);
			//homePageObject.clickMainMenuLink("menu");
			//homePageObject.clickSubMenuLink("submenu");
			plp.verifyBreadCrumb("hair oil shampoos");
			plp.verifyPLPPage("hair oil shampoos");
			plp.verifyPLP("hair oil shampoos");
			homePageObject=null;
			plp=null;
			System.gc();
		}
	}

}

