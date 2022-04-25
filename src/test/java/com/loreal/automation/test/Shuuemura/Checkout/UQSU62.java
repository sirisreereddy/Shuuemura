/**REGISTERED USER PAYAPAL CHECKOUT FROM CHECKOUT PAGE
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


public class UQSU62 extends BaseTest
{
public UQSU62() 
{
	super("UQSU62");
}

public UQSU62(String testName, String browser) {

	super(testName, browser);
}


@BeforeTest
public void before() {

	test = TestReportGenerator(report, this.getClass().getSimpleName(),"REGISTERED USER PAYAPAL CHECKOUT FROM CHECKOUT PAGE");
}

@Test
public void test() throws Exception {

	if(channel.equalsIgnoreCase("Desktop")){

		HomePage homePageObject = new HomePage(driver,test);	
		MyShoppingBag shoppingBag = new MyShoppingBag(driver,test);
		EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();

		CheckoutPage cp = new CheckoutPage(driver,test);
		test.log(LogStatus.PASS,"TEST CASE NAME:REGEISTERED USER PAYPAL CHECKOUT FROM CHECKOUT PAGE");
		Reporter.log("TEST CASE NAME:REGEISTERED USER PAYPAL CHECKOUT FROM CHECKOUT PAGE");

		homePageObject.launchBasePage();
		homePageObject.signIn();
		shoppingBag.mouseHoverOnMenuItem(objData.mainmenu);
		shoppingBag.clickSubMenuItem(objData.submenu);
		String productname = shoppingBag.getAvailableProductNameInPLP();
		shoppingBag.addProductFromPLP(productname);
		/*try{
			isElementVisible(By.xpath("//div[contains(text(),'You can add maximum (5) quantity of a full size product!')]"));
			cp.clickBag();
		}catch(Exception e) {
			Reporter.log("Shopping bag will be clicked");
		}*/
		cp.clickBag();
		cp.clickCheckout();
		cp.clickSamples(objData.sample1,objData.sample2);
		cp.clickContinueToContact();
		try{
			cp.clickContinueToShipping();
			cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		}catch(Exception e){
			cp.editAddresses();
		}
		cp.clickPayPalRbtn();
		cp.clickPayPalBtn();
		String winHandleBefore = driver.getWindowHandle();
		cp.switchToWindow();
		cp.loginWithPayPalAccount(objData.payPalEmail, objData.payPalPassword);
		cp.clickContinueInPayPal();
		driver.switchTo().window(winHandleBefore);
		cp.clickPlaceOrder();
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
		test.log(LogStatus.PASS,"TEST CASE NAME:REGEISTERED USER PAYPAL CHECKOUT FROM CHECKOUT PAGE");
		Reporter.log("TEST CASE NAME:REGEISTERED USER PAYPAL CHECKOUT FROM CHECKOUT PAGE");

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
		try{
			cp.clickContinueToShipping();
			cp.clickSaveAndContinueBtnInShippingAddrPopUp();
		}catch(Exception e){
			cp.editAddresses();
		}
		cp.clickPayPalRbtn();
		cp.clickPayPalBtn();
		String winHandleBefore = driver.getWindowHandle();
		cp.switchToWindow();
		cp.loginWithPayPalAccountMobile(objData.payPalEmail, objData.payPalPassword);
		cp.clickContinueInPayPal();
		driver.switchTo().window(winHandleBefore);
		cp.clickPlaceOrder();
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

