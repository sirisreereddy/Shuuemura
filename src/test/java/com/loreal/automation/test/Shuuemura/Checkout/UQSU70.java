/**ADD BILLING ADDRESS AT CHECKOUT AS REGISTERED USER
 * @author SURYA
 *
 */
package com.loreal.automation.test.Shuuemura.Checkout;



import org.openqa.selenium.By;
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


public class UQSU70 extends BaseTest
{
public UQSU70() 
{
	super("UQSU70");
}

public UQSU70(String testName, String browser) {

	super(testName, browser);
}

@BeforeTest
public void before() {

	test = TestReportGenerator(report, this.getClass().getSimpleName(),"ADD BILLING ADDRESS AT CHECKOUT AS REGISTERED USER");
}

@Test
public void test() throws Exception {

	if(channel.equalsIgnoreCase("Desktop")){

		HomePage homePageObject = new HomePage(driver,test);	
		MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
		EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();
		test.log(LogStatus.PASS,"TEST CASE NAME:ADD BILLING ADDRESS AT CHECKOUT AS REGISTERED USER");
		Reporter.log("TEST CASE NAME:ADD BILLING ADDRESS AT CHECKOUT AS REGISTERED USER");

		homePageObject.launchBasePage();
		CheckoutPage cp = new CheckoutPage(driver,test);
		
		homePageObject.signIn();
		shoppingBag.mouseHoverOnMenuItem(objData.mainmenu);
		shoppingBag.clickSubMenuItem(objData.submenu);
		String productname = shoppingBag.getAvailableProductNameInPLP();
		shoppingBag.addProductFromPLP(productname);
		cp.clickBag();
		cp.clickCheckout();
		cp.clickSamples(objData.sample1,objData.sample2);
		cp.clickContinueToContact();
		try{
			cp.clickEditAddresses();
			cp.enterShippingDetailsForReg(objData.fname,objData.lname,objData.address,objData.State,objData.city,objData.zipcode,objData.phone);
		}catch(Exception e){
			cp.enterShippingDetailsForReg(objData.fname,objData.lname,objData.address,objData.State,objData.city,objData.zipcode,objData.phone);
		}
		
		cp.unCheckSameAsShippingAdd();
		
		
		//cp.verifyEmptyBillingAddress();
		cp.enterBillingDetails(objData.firstname,objData.lastname,objData.Billingaddress,objData.billing_city,objData.billing_zipcode,objData.phone,objData.billing_State);
		cp.clickContinueToShipping();
		cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		cp.verifyBillingAddress(objData.Billingaddress);
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
		test.log(LogStatus.PASS,"TEST CASE NAME:ADD BILLING ADDRESS AT CHECKOUT AS REGISTERED USER");
		Reporter.log("TEST CASE NAME:ADD BILLING ADDRESS AT CHECKOUT AS REGISTERED USER");

		EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();
		urObj.clickRegisterLnk();
		urObj.signInMobile(objData.Username, objData.password);
		homePageObject.clickBagLnkMobile();
		sbObject.clickRemoveInSb();
		homePageObject.clickHamburgerMenuButtonInHeaderMobile();
		homePageObject.clickMainMenuLinkMobile(objData.mainmenu1);
		homePageObject.clickSubMenuLink(objData.submenu1);
		String productname = sbObject.getAvailableProductNameInPLP();
		plp.clickProductInPLP(productname);
		pdpObject.clickAddToBag();
		homePageObject.clickBagLnkMobile();
		cp.clickCheckout();
		cp.clickSamples(objData.sample1,objData.sample2);
		cp.clickContinueToContact();
			cp.clickEditAddresses();
			cp.enterShippingDetailsForReg(objData.fname,objData.lname,objData.address,objData.State,objData.city,objData.zipcode,objData.phone);
		   cp.unCheckSameAsShippingAdd();
		
		
		//cp.verifyEmptyBillingAddress();
		cp.enterBillingDetails(objData.firstname,objData.lastname,objData.Billingaddress,objData.billing_city,objData.billing_zipcode,objData.phone,objData.billing_State);
		cp.clickContinueToShipping();
		cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		//cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		cp.verifyBillingAddress(objData.Billingaddress);
		homePageObject=null;
		cp=null;
		shoppingBag=null;
		System.gc();
	}

}

private void isElementVisible(By xpath) {
	// TODO Auto-generated method stub
	
}

}

