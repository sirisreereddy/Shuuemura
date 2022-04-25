/**VERIFY QUICK VIEW OF PRODUCT
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


public class UQSU53 extends BaseTest {
	public UQSU53() 
	{
		super("UQSU53");
	}

	public UQSU53(String testName, String browser) {

		super(testName, browser);
	}

	
	@BeforeTest
	public void before() {

		test = TestReportGenerator(report, this.getClass().getSimpleName(),"VERIFY QUICK VIEW OF PRODUCT");
	}
	@Test
	public void test() throws Exception {

		if(channel.equalsIgnoreCase("Desktop")){

			HomePage homePageObject = new HomePage(driver,test);	
			ProductLandingPage plp = new ProductLandingPage(driver,test);
			ProductDetailsPage pdp = new ProductDetailsPage(driver,test);
			EnvironmentTestData objData = new EnvironmentTestData();
			objData.setTestData();

			MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
			test.log(LogStatus.PASS,"TEST CASE NAME: VERIFY QUICK VIEW OF PRODUCT");
			Reporter.log("TEST CASE NAME: VERIFY QUICK VIEW OF PRODUCT");
			homePageObject.launchBasePage();
			homePageObject.hoverOnMainMenu(objData.mainmenu);	
			homePageObject.clickSubMenuLink(objData.submenu);
			//String productname = shoppingBag.getAvailableProductNameInPLP();
			plp.hoverOnProductInPLP(objData.productName1);
			plp.clickQuickViewButtonForProduct(objData.productName1);
			pdp.verifyProductDetailsInQuickView();
			homePageObject=null;
			plp=null;
			pdp=null;
			System.gc();
			
		}
	}

}

