/**REGISTERED USER CARD CHECKOUT
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


public class UQSU60 extends BaseTest
{
public UQSU60() 
{
	super("UQSU60");
}

public UQSU60(String testName, String browser) {

	super(testName, browser);
}


@BeforeTest
public void before() {

	test = TestReportGenerator(report, this.getClass().getSimpleName(),"REGISTERED USER CARD CHECKOUT");
}


@Test
public void test() throws Exception {

	if(channel.equalsIgnoreCase("Desktop")){

		HomePage homePageObject = new HomePage(driver,test);	
		MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
		EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();
		test.log(LogStatus.PASS,"TEST CASE NAME:REGISTERED USER CARD CHECKOUT");
		Reporter.log("TEST CASE NAME:REGISTERED USER CARD CHECKOUT");

		homePageObject.launchBasePage();
		CheckoutPage cp = new CheckoutPage(driver,test);

		homePageObject.signIn1();
		shoppingBag.mouseHoverOnMenuItem(objData.mainmenu);
		shoppingBag.clickSubMenuItem(objData.submenu);
		String productname = shoppingBag.getAvailableProductNameInPLP();
		shoppingBag.addProductFromPLP(productname);
		try{
			isElementVisible(By.xpath("//div[contains(text(),'You can add maximum (5) quantity of a full size pr')]"));
			cp.clickBag();
		}catch(Exception s) {
			Reporter.log("Shopping bag will be clicked");
		}
		cp.clickBag();
		cp.clickCheckout();
		cp.clickContinueToContact();
		try{
			cp.clickContinueToShipping();
			cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		}catch(Exception e){
			cp.editAddresses();
		}
		//cp.clickCreditCardRbtn();
		cp.selectOptionselectfromSaveCards();
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
		ProductDetailsPage pdpObject=new ProductDetailsPage(driver,test);
		MyShoppingBag sbObject=new MyShoppingBag(driver,test);
		ProductLandingPage plp = new ProductLandingPage(driver,test);
		UserRegistrationPage urObj = new UserRegistrationPage(driver,test);

		HomePage homePageObject = new HomePage(driver,test);	
		MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
		CheckoutPage cp = new CheckoutPage(driver,test);EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();
		test.log(LogStatus.PASS,"TEST CASE NAME:REGISTERED USER CARD CHECKOUT");
		Reporter.log("TEST CASE NAME:REGISTERED USER CARD CHECKOUT");

		homePageObject.launchBasePageMobile();
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
		cp.clickContinueToContact();
		try{
			cp.clickContinueToShipping();
			cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		}catch(Exception e){
			cp.editAddresses();
		}
		//cp.clickCreditCardRbtn();
		cp.selectOptionselectfromSaveCards();
		cp.enterCreditCardDetails(objData.cardholdername,objData.cardtype,objData.cardnumber,objData.Expirymonth,objData.Expiryyear,objData.CVV);
		cp.clickSubmitOrder();
		cp.displayOrderNumber();	
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

