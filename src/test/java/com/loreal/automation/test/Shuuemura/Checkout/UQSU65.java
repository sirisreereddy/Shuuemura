/**GUEST USER PAYPAL CHECKOUT FROM BAG
 * @author SURYA
 *
 */
package com.loreal.automation.test.Shuuemura.Checkout;



import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.loreal.automation.base.BaseTest;

import com.loreal.automation.pages.Shuuemura.CheckoutPage;
import com.loreal.automation.pages.Shuuemura.HomePage;
import com.loreal.automation.pages.Shuuemura.MyShoppingBag;
import com.loreal.automation.pages.Shuuemura.ProductDetailsPage;
import com.loreal.automation.pages.Shuuemura.ProductLandingPage;
import com.loreal.automation.pages.Shuuemura.UserRegistrationPage;
import com.loreal.automation.utilities.EnvironmentTestData;
import com.relevantcodes.extentreports.LogStatus;


public class UQSU65 extends BaseTest
{
public UQSU65() 
{
	super("UQSU65");
}

public UQSU65(String testName, String browser) {

	super(testName, browser);
}


@BeforeTest
public void before() {

	test = TestReportGenerator(report, this.getClass().getSimpleName(),"GUEST USER PAYPAL CHECKOUT FROM BAG");
}

@Test
public void test() throws Exception {

	if(channel.equalsIgnoreCase("Desktop")){

		HomePage homePageObject = new HomePage(driver,test);	
		MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
		EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();
		test.log(LogStatus.PASS,"TEST CASE NAME:GUEST USER PAYPAL CHECKOUT FROM BAG");
		Reporter.log("TEST CASE NAME:GUEST USER PAYPAL CHECKOUT FROM BAG");

		homePageObject.launchBasePage();
		CheckoutPage cp = new CheckoutPage(driver,test);
		shoppingBag.mouseHoverOnMenuItem(objData.mainmenu);
		shoppingBag.clickSubMenuItem(objData.submenu);
		String productname = shoppingBag.getAvailableProductNameInPLP();
		shoppingBag.addProductFromPLP(productname);
		cp.clickBag();
		//String winHandleBefore = driver.getWindowHandle();
		cp.clickPaypalInBag();
		cp.clickSamples(objData.sample1,objData.sample2);
		
		cp.clickPayPalBtn();
		String winHandleBefore = driver.getWindowHandle();
		cp.switchToWindow();
		cp.loginWithPayPalAccounts(objData.payPalEmail, objData.payPalPassword);
		cp.clickContinueInPayPal();
		driver.switchTo().window(winHandleBefore);
		cp.clickPlaceOrder();
		cp.displayOrderNumber();
		Reporter.log("user is able to place the order successfully using paypal");
		homePageObject=null;
		cp=null;
		shoppingBag=null;
		System.gc();
			}
	else if(channel.equalsIgnoreCase("Mobile"))
	{	
		


		HomePage homePageObject = new HomePage(driver,test);	
		MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
		homePageObject.launchBasePageMobile();
		UserRegistrationPage urObj = new UserRegistrationPage(driver,test);
		CheckoutPage cp = new CheckoutPage(driver,test);
		ProductDetailsPage pdpObject=new ProductDetailsPage(driver,test);
		MyShoppingBag sbObject=new MyShoppingBag(driver,test);
		ProductLandingPage plp = new ProductLandingPage(driver,test);
		test.log(LogStatus.PASS,"TEST CASE NAME:GUEST USER PAYPAL CHECKOUT FROM BAG");
		Reporter.log("TEST CASE NAME:GUEST USER PAYPAL CHECKOUT FROM BAG");

		EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();
		
		homePageObject.clickHamburgerMenuButtonInHeaderMobile();
		homePageObject.clickMainMenuLinkMobile(objData.mainmenu1);
		homePageObject.clickSubMenuLink(objData.submenu1);
		String productname = sbObject.getAvailableProductNameInPLP();
		plp.clickProductInPLP(productname);
		pdpObject.clickAddToBag();
		homePageObject.clickBagLnkMobile();
		//String winHandleBefore = driver.getWindowHandle();
		cp.clickPaypalInBag();
		cp.clickSamples(objData.sample1,objData.sample2);
		
		cp.clickPayPalBtn();
		String winHandleBefore = driver.getWindowHandle();
		cp.switchToWindow();
		cp.loginWithPayPalAccountMobile(objData.payPalEmail, objData.payPalPassword);
		cp.clickContinueInPayPal();
		driver.switchTo().window(winHandleBefore);
		cp.clickPlaceOrder();
		cp.displayOrderNumber();
		Reporter.log("user is able to place the order successfully using paypal");
		homePageObject=null;
		cp=null;
		shoppingBag=null;
		System.gc();
			
	}

}

}

