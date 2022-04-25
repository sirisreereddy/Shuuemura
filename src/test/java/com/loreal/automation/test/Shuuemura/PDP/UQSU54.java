/**VERIFYING PRODUCT DETAILS IN  PDP
 * @author SURYA
 *
 */

package com.loreal.automation.test.Shuuemura.PDP;


import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.loreal.automation.base.BaseTest;

import com.loreal.automation.pages.Shuuemura.HomePage;
import com.loreal.automation.pages.Shuuemura.MyShoppingBag;
import com.loreal.automation.pages.Shuuemura.ProductDetailsPage;
import com.loreal.automation.pages.Shuuemura.ProductLandingPage;
import com.loreal.automation.utilities.EnvironmentTestData;
import com.relevantcodes.extentreports.LogStatus;


public class UQSU54 extends BaseTest {
	public UQSU54() 
	{
		super("UQSU54");
	}

	public UQSU54(String testName, String browser) {

		super(testName, browser);
	}

	
	@BeforeTest
	public void before() {

		test = TestReportGenerator(report, this.getClass().getSimpleName(),"VERIFYING PRODUCT DETAILS IN  PDP");
	}
	@Test
	public void test() throws Exception {

		if(channel.equalsIgnoreCase("Desktop")){

			HomePage homePageObject = new HomePage(driver,test);	
			ProductLandingPage plp = new ProductLandingPage(driver,test);
			ProductDetailsPage pdp = new ProductDetailsPage(driver,test);
			MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
			EnvironmentTestData objData = new EnvironmentTestData();
			objData.setTestData();
			test.log(LogStatus.PASS,"TEST CASE NAME: VERIFYING PRODUCT DETAILS IN PDP");
			Reporter.log("TEST CASE NAME: VERIFYING PRODUCT DETAILS IN PDP");

			homePageObject.launchBasePage();
			homePageObject.hoverOnMainMenu(objData.mainmenu1);	
			homePageObject.clickSubMenuLink(objData.submenu1);
			String productname = shoppingBag.getAvailableProductNameInPLP();
			plp.clickProductInPLP(productname);
			pdp.verifyProductDetailsInPDP();
			homePageObject=null;
			plp=null;
			pdp=null;
			System.gc();
			
		}
		else if(channel.equalsIgnoreCase("Mobile"))
		{	
			HomePage homePageObject = new HomePage(driver,test);	
			ProductLandingPage plp = new ProductLandingPage(driver,test);
			ProductDetailsPage pdp = new ProductDetailsPage(driver,test);
			EnvironmentTestData objData = new EnvironmentTestData();
			objData.setTestData();
			homePageObject.launchBasePageMobile();
			test.log(LogStatus.PASS,"TEST CASE NAME: VERIFYING PRODUCT DETAILS IN PDP");
			Reporter.log("TEST CASE NAME: VERIFYING PRODUCT DETAILS IN PDP");

			homePageObject.clickHamburgerMenuButtonInHeaderMobile();
			homePageObject.clickMainMenuLinkMobile(objData.mainmenu1);
			homePageObject.clickSubMenuLink(objData.submenu1);
			plp.clickProductInPLP(objData.productName1);
			pdp.verifyProductDetailsInPDP();
			homePageObject=null;
			plp=null;
			pdp=null;
			System.gc();

		}
	}

}



