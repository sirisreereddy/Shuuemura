/**ADD SHIPPING ADDRESS IN CHECKOUT AS REGISTERED USER
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


public class UQSU66 extends BaseTest
{
public UQSU66() 
{
	super("UQSU66");
}

public UQSU66(String testName, String browser) {

	super(testName, browser);
}


@BeforeTest
public void before() {

	test = TestReportGenerator(report, this.getClass().getSimpleName(),"ADD SHIPPING ADDRESS IN CHECKOUT AS REGISTERED USER");
}

@Test
public void test() throws Exception {

	if(channel.equalsIgnoreCase("Desktop")){

		HomePage homePageObject = new HomePage(driver,test);	
		EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();

		MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
		test.log(LogStatus.PASS,"TEST CASE NAME:ADD SHIPPING ADDRESS IN CHECKOUT AS REGISTERED USER");
		Reporter.log("TEST CASE NAME:ADD SHIPPING ADDRESS IN CHECKOUT AS REGISTERED USER");

		homePageObject.launchBasePage();
		CheckoutPage cp = new CheckoutPage(driver,test);
		UserRegistrationPage ur=new UserRegistrationPage(driver,test);
		homePageObject.signIn1();
		shoppingBag.mouseHoverOnMenuItem(objData.mainmenu);
		shoppingBag.clickSubMenuItem(objData.submenu);
		String productname = shoppingBag.getAvailableProductNameInPLP();
		shoppingBag.addProductFromPLP(productname);
		try{
			isElementVisible(By.xpath("//div[contains(text(),'You can add maximum (5) quantity of a full size pr')]"));
			cp.clickBag();
		}catch(Exception e) {
			Reporter.log("Shopping bag will be clicked");
		}
		cp.clickBag();
		cp.clickCheckout();
		cp.clickSamples(objData.sample1,objData.sample2);
		cp.clickContinueToContact();
		String fname=ur.randomFnameGen();
		try{
		cp.selectOptionChooseSavedAddress();
		
		cp.enterShippingDetails(fname,objData.lname,objData.address,objData.State,objData.city,objData.zipcode,objData.phone,objData.username);
		cp.saveThisAddress();
		cp.clickContinueToShipping();
		cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		}catch(Exception e){
			cp.clickEditAddresses();
			cp.selectOptionChooseSavedAddress();
			cp.enterShippingDetails(fname,objData.lname,objData.address,objData.State,objData.city,objData.zipcode,objData.phone,objData.username);
			cp.saveThisAddress();
			cp.clickContinueToShipping();
			cp.clickSaveAndContinueBtnInShippingAddrPopUp();
			
		}
		//cp.selectCardDetailsRegistered();
		cp.clickshuimage();
		cp.clickMyAccount();
		cp.clickAddressBook();
		cp.verifyAddedAddress(fname);
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
		test.log(LogStatus.PASS,"TEST CASE NAME:ADD SHIPPING ADDRESS IN CHECKOUT AS REGISTERED USER");
		Reporter.log("TEST CASE NAME:ADD SHIPPING ADDRESS IN CHECKOUT AS REGISTERED USER");

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
		String fname=urObj.randomFnameGen();
		try{
		cp.selectOptionChooseSavedAddress();
		
		cp.enterShippingDetails(fname,objData.lname,objData.address,objData.State,objData.city,objData.zipcode,objData.phone,objData.username);
		cp.saveThisAddress();
		cp.clickContinueToShipping();
		cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		}catch(Exception e){
			cp.clickEditAddresses();
			cp.selectOptionChooseSavedAddress();
			cp.enterShippingDetails(fname,objData.lname,objData.address,objData.State,objData.city,objData.zipcode,objData.phone,objData.username);
			cp.saveThisAddress();
			cp.clickContinueToShipping();
			cp.clickSaveAndContinueBtnInShippingAddrPopUp();
			
		}
		//cp.selectCardDetailsRegistered();
		homePageObject=null;
		cp=null;
		shoppingBag=null;
		System.gc();
	}

}

private void isElementVisible(By xpath) {
	
}

}

