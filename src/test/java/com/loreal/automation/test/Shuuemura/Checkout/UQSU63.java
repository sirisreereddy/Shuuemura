/**GUEST USER CARD CHECKOUT
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


public class UQSU63 extends BaseTest
{
public UQSU63() 
{
	super("UQSU63");
}

public UQSU63(String testName, String browser) {

	super(testName, browser);
}


@BeforeTest
public void before() {

	test = TestReportGenerator(report, this.getClass().getSimpleName(),"GUEST USER CARD CHECKOUT");
}

@Test
public void test() throws Exception {

	if(channel.equalsIgnoreCase("Desktop")){

		HomePage homePageObject = new HomePage(driver,test);	
		MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
		EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();
		test.log(LogStatus.PASS,"TEST CASE NAME:GUEST USER CARD CHECKOUT");
		Reporter.log("TEST CASE NAME:GUEST USER CARD CHECKOUT");

		homePageObject.launchBasePage();
		CheckoutPage cp = new CheckoutPage(driver,test);
		
		shoppingBag.mouseHoverOnMenuItem(objData.mainmenu);
		shoppingBag.clickSubMenuItem(objData.submenu);
		String productname = shoppingBag.getAvailableProductNameInPLP();
		shoppingBag.addProductFromPLP(productname);
		cp.clickBag();
		cp.clickCheckout();
		cp.clickCheckoutAsGuestInPopUp();
		cp.clickSamples(objData.sample1,objData.sample2);
		cp.clickContinueToContact();
		cp.enterShippingDetails(objData.fname,objData.lname,objData.address,objData.State,objData.city,objData.zipcode,objData.phone,objData.email);
		cp.clickContinueToShipping();
		cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		//cp.clickCreditCardRbtn();
		cp.enterCreditCardDetails(objData.cardholdername,objData.cardtype,objData.cardnumber,objData.Expirymonth,objData.Expiryyear,objData.CVV);
		cp.clickSubmitOrder();
		cp.displayOrderNumber();
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
		test.log(LogStatus.PASS,"TEST CASE NAME:GUEST USER CARD CHECKOUT");
		Reporter.log("TEST CASE NAME:GUEST USER CARD CHECKOUT");

		EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();
		
		homePageObject.clickHamburgerMenuButtonInHeaderMobile();
		homePageObject.clickMainMenuLinkMobile(objData.mainmenu1);
		homePageObject.clickSubMenuLink(objData.submenu1);
		String productname = sbObject.getAvailableProductNameInPLP();
		plp.clickProductInPLP(productname);
		pdpObject.clickAddToBag();
		homePageObject.clickBagLnkMobile();
		cp.clickCheckout();
		cp.clickCheckoutAsGuestInPopUp();
		cp.clickSamples(objData.sample1,objData.sample2);
		cp.clickContinueToContact();
		cp.enterShippingDetails(objData.fname,objData.lname,objData.address,objData.State,objData.city,objData.zipcode,objData.phone,objData.email);
		cp.clickContinueToShipping();
		cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		//cp.clickCreditCardRbtn();
		cp.enterCreditCardDetails(objData.cardholdername,objData.cardtype,objData.cardnumber,objData.Expirymonth,objData.Expiryyear,objData.CVV);
		cp.clickSubmitOrder();
		cp.displayOrderNumber();
		homePageObject=null;
		cp=null;
		shoppingBag=null;
		System.gc();
	}

}

}

