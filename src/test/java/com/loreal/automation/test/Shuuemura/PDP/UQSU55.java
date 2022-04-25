/**VERIFYING AUTOREPLINSHMENT DETAILS OF PRODUCT
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


public class UQSU55 extends BaseTest {
	public UQSU55() 
	{
		super("UQSU55");
	}

	public UQSU55(String testName, String browser) {

		super(testName, browser);
	}

	
	@BeforeTest
	public void before() {

		test = TestReportGenerator(report, this.getClass().getSimpleName(),"VERIFYING AUTOREPLINSHMENT DETAILS OF PRODUCT");
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
			test.log(LogStatus.PASS,"TEST CASE NAME: VERIFYING AUTOREPLINSHMENT DETAILS");
			Reporter.log("TEST CASE NAME: VERIFYING AUTOREPLINSHMENT DETAILS");

			homePageObject.launchBasePage();
			homePageObject.hoverOnMainMenu(objData.arMainmenu);	
			homePageObject.clickSubMenuLink(objData.arSubmenu);
			String productname = shoppingBag.getAvailableProductNameInPLP();
			plp.clickProductInPLP(productname);
			pdp.applyAutoReplenishment(objData.frequency);
			pdp.clickAddToBag();
			pdp.clickShoppingBagLink();
			pdp.verifyAutoreplenishmentInBag(productname);
			homePageObject=null;
			plp=null;
			pdp=null;
			shoppingBag=null;
			System.gc();
		}
		else if(channel.equalsIgnoreCase("Mobile"))
		{	
			HomePage homePageObject = new HomePage(driver,test);	
			ProductLandingPage plp = new ProductLandingPage(driver,test);
			ProductDetailsPage pdp = new ProductDetailsPage(driver,test);
			MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
			EnvironmentTestData objData = new EnvironmentTestData();
			objData.setTestData();
			homePageObject.launchBasePageMobile();
			test.log(LogStatus.PASS,"TEST CASE NAME: VERIFYING AUTOREPLINSHMENT DETAILS");
			Reporter.log("TEST CASE NAME: VERIFYING AUTOREPLINSHMENT DETAILS");

			homePageObject.clickSubMenuLink(objData.arSubmenu);
			String productname = shoppingBag.getAvailableProductNameInPLP();
			plp.clickProductInPLP(productname);
			pdp.applyAutoReplenishment(objData.frequency);
			pdp.clickAddToBag();
			pdp.clickShoppingBagLink();
			pdp.verifyAutoreplenishmentInBag(productname);
			homePageObject=null;
			plp=null;
			pdp=null;
			shoppingBag=null;
			System.gc();
		}
	}

}


