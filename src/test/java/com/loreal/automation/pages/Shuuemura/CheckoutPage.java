/**This test case contains all methods related to CHECKOUT page
 * @author SURYA
 *
 */
package com.loreal.automation.pages.Shuuemura;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;

import com.loreal.automation.base.BasePage;
import com.loreal.automation.utilities.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver,ExtentTest test) {
		super(driver,test);
	}

	public boolean hasPageLoaded() {
		return false;
	}

	@Override
	public String getPageUrl() {
		return null;
	}

	ObjectRepository objectRep = new ObjectRepository();

	/**This method is about Card checkOut As Guest
	 * @param menu
	 * @param submenu
	 * @param product
	 * @param firstname
	 * @param lastname
	 * @param address
	 * @param State
	 * @param city
	 * @param zipcode
	 * @param phone
	 * @param email
	 * @param nameoncreditcard
	 * @param type
	 * @param creditcardnum
	 * @param month
	 * @param year
	 * @param cvv
	 * @param billing_State
	 * @param billing_city
	 * @param billing_zipcode
	 * @param country
	 * @throws Exception
	 */
	public void checkOutAsGuest(String menu, String submenu, String product, String firstname, String lastname,
			String address, String State, String city, String zipcode, String phone,String email, String nameoncreditcard,String type,
			String creditcardnum, String month, String year, String cvv, String billing_State, String billing_city,
			String billing_zipcode, String country) throws Exception {
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.getMenuItem(menu));
		clickUsingJavascriptExecutor(objectRep.getSubMenuItem(submenu));
		clickUsingJavascriptExecutor(objectRep.getProductLnk(product));
		clickUsingJavascriptExecutor(objectRep.addToCart);
		clickUsingJavascriptExecutor(By.xpath("//a[@title = 'View Cart']"));
		moveMouseTipAndClick(By.xpath("//a[@title = 'View Cart']"));
		Thread.sleep(2000);
		clickUsingJavascriptExecutor(objectRep.checkoutBtn);
		type(objectRep.guestEmail, "shu@gmail.com");
		clickUsingJavascriptExecutor(objectRep.continueBtn);
		Thread.sleep(2000);
		enterShippingDetails(firstname, lastname, address, State, city, zipcode, phone,email);
		clickUsingJavascriptExecutor(objectRep.billing_chkbox);
		Thread.sleep(2000);
		enterBillingDetails(firstname, lastname, address, billing_State, billing_city, billing_zipcode, phone);
		clickUsingJavascriptExecutor(objectRep.creditCardBtn);
		enterCreditCardDetails(nameoncreditcard,type, creditcardnum, month, year, cvv);
		clickUsingJavascriptExecutor(objectRep.reviewOrderBtn);
		clickUsingJavascriptExecutor(objectRep.saveAndContinueBtn);
		clickUsingJavascriptExecutor(objectRep.submitOrder);
		String orderNum = getText(By.xpath("//div[@class='order_number']//span[@class='value']"));
		if (!(orderNum).isEmpty()) {
			System.out.println("Order has been Placed");
		} else {
			throw new Exception("Error in Placing order");
		}
	}

	/**This method is aboutAdd Shipping address
	 * @param firstname 
	 * @param lastname
	 * @param address
	 * @param State
	 * @param city
	 * @param zipcode
	 * @param phone
	 * @param email
	 * @throws InterruptedException
	 */
	public void enterShippingDetails(String firstname, String lastname, String address, String State, String city,
			String zipcode, String phone,String email) throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(2000);
		try {
			type(objectRep.s_firstName, firstname);
			type(objectRep.s_lastName, lastname);
			type(objectRep.s_address1, address);
			clickUsingJavascriptExecutor(objectRep.s_states);
			selectDropDownByVisibleText(objectRep.s_states, State);
			type(objectRep.s_city, city);
			type(objectRep.s_zip, zipcode);
			type(objectRep.s_phone, phone);
			type(objectRep.s_email,email);
		} catch (WebDriverException e) {
			try {
				if (isElementPresent(By.xpath("//button[@title='close']")))
					clickUsingJavascriptExecutor(By.xpath("//button[@title='close']"));
			} catch (InterruptedException e1) {
				
				e.printStackTrace();
			}
			type(objectRep.s_firstName, firstname);
			type(objectRep.s_lastName, lastname);
			type(objectRep.s_address1, address);
			clickUsingJavascriptExecutor(objectRep.s_states);
			selectDropDownByVisibleText(objectRep.s_states, State);
			type(objectRep.s_city, city);
			type(objectRep.s_zip, zipcode);
			type(objectRep.s_phone, phone);
		}
	}
	
	/**This method is about enter Shipping Details For Reg User
	 * @param firstname
	 * @param lastname
	 * @param address
	 * @param State
	 * @param city
	 * @param zipcode
	 * @param phone
	 * @throws InterruptedException
	 */
	public void enterShippingDetailsForReg(String firstname, String lastname, String address, String State, String city,
			String zipcode, String phone) throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(2000);
		try {
			type(objectRep.s_firstName, firstname);
			type(objectRep.s_lastName, lastname);
			type(objectRep.s_address1, address);
			clickUsingJavascriptExecutor(objectRep.s_states);
			selectDropDownByVisibleText(objectRep.s_states, State);
			type(objectRep.s_city, city);
			type(objectRep.s_zip, zipcode);
			type(objectRep.s_phone, phone);
		} catch (WebDriverException e) {
			try {
				if (isElementPresent(By.xpath("//button[@title='close']")))
					clickUsingJavascriptExecutor(By.xpath("//button[@title='close']"));
			} catch (InterruptedException e1) {
			
				e.printStackTrace();
			}
			Thread.sleep(3000);
			type(objectRep.s_firstName, firstname);
			type(objectRep.s_lastName, lastname);
			type(objectRep.s_address1, address);
			clickUsingJavascriptExecutor(objectRep.s_states);
			selectDropDownByVisibleText(objectRep.s_states, State);
			type(objectRep.s_city, city);
			type(objectRep.s_zip, zipcode);
			type(objectRep.s_phone, phone);
		}
	}

	/**This method is about	 Add Billing address
	 * @param firstname 
	 * @param lastname
	 * @param address
	 * @param city
	 * @param zipcode
	 * @param phone
	 * @param State
	 * @throws InterruptedException
	 */
	public void enterBillingDetails(String firstname, String lastname, String address,String city,
			String zipcode, String phone,String State ) throws InterruptedException {
		objectRep.loadCheckoutObj();
		try {
			type(objectRep.b_firstName, firstname);
			type(objectRep.b_lastName, lastname);
			type(objectRep.b_address1, address);
			type(objectRep.b_city, city);
			type(objectRep.b_zip, zipcode);
			type(objectRep.b_phone, phone);
			clickUsingJavascriptExecutor(objectRep.b_states);
			selectDropDownByVisibleText(objectRep.b_states, State);
		} catch (WebDriverException e1) {
			try {
				if (isElementPresent(By.xpath("//button[@title='close']")))
					clickUsingJavascriptExecutor(By.xpath("//button[@title='close']"));
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			type(objectRep.b_firstName, firstname);
			type(objectRep.b_lastName, lastname);
			type(objectRep.b_address1, address);
			type(objectRep.b_city, city);
			type(objectRep.b_zip, zipcode);
			type(objectRep.b_phone, phone);
			clickUsingJavascriptExecutor(objectRep.b_states);
			selectDropDownByVisibleText(objectRep.b_states, State);
		}
	}

	/**This method is about enter Credit Card Details
	 * @param nameoncreditcard
	 * @param type
	 * @param creditcardnum
	 * @param month
	 * @param year
	 * @param cvv
	 * @throws InterruptedException
	 */
	public void enterCreditCardDetails(String nameoncreditcard,String type, String creditcardnum, String month, String year,
			String cvv) throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(5000);
			type(objectRep.cardName, nameoncreditcard);
			selectDropDownByVisibleText(objectRep.cardtype, type);
			type(objectRep.cardNum, creditcardnum);
			clickUsingJavascriptExecutor(objectRep.cardMonth);
			selectDropDownByVisibleText(objectRep.cardMonth, month);
			clickUsingJavascriptExecutor(objectRep.cardYear);
			selectDropDownByVisibleText(objectRep.cardYear, year);
			type(objectRep.cvv, cvv);
		test.log(LogStatus.PASS,"Card details entered");
		Reporter.log("Card details entered");
	}

	/**This method is about click Bag
	 * @throws InterruptedException
	 */
	public void clickBag() throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(5000);
		mouseOver(By.xpath("//span[contains(@class,'mini_cart_quantity')]"));
		clickUsingJavascriptExecutor(objectRep.cartLnk);
	test.log(LogStatus.PASS,"shopping bag is Clicked"); 
	Reporter.log("shopping bag is Clicked");
		TimeUnit.SECONDS.sleep(2);

	}
	/**This method is about click Bag
	 * @throws InterruptedException
	 */
	public void clickBagAgain() throws InterruptedException {
		objectRep.loadCheckoutObj();
	     doubleClick(objectRep.cartLnkk);
	 test.log(LogStatus.PASS,"shopping bag is Clicked");
	 Reporter.log("shopping bag is Clicked");
		TimeUnit.SECONDS.sleep(2);

	}
	

	/**This method is about Adding Samples to Bag
	 * @param sample1
	 * @param sample2
	 * @throws InterruptedException
	 */
	public void clickSamples(String sample1, String sample2) throws InterruptedException {
		objectRep.loadCheckoutObj();
		System.out.println(sample1);
		try {
		clickUsingJavascriptExecutor(objectRep.getSampleProduct(sample1));
		Thread.sleep(2000);
		}
		catch(Exception r) {
		clickUsingJavascriptExecutor(objectRep.getSampleProduct(sample2));
		}
		test.log(LogStatus.PASS,"Sample is selected"); 
		Reporter.log("Sample is selected");
		Thread.sleep(3000);
	}

	/**This method is about click Checkout
	 * @throws InterruptedException
	 */
	public void clickCheckout() throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(3000);
		//mouseOver(objectRep.checkoutBtn);
		clickUsingJavascriptExecutor(objectRep.checkoutBtn);
		test.log(LogStatus.PASS,"Checkout button in shopping bag is Clicked");
		Reporter.log("Checkout button in shopping bag is Clicked");
		Thread.sleep(2000);
	}
	/**This method is about click Continue To Contact
	 * @throws InterruptedException
	 */
	public void clickContinueToContact() throws InterruptedException{
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.continue_to_contact);
		test.log(LogStatus.PASS,"continue to contact button is clicked");
		Reporter.log("continue to contact button is clicked");
		Thread.sleep(2000);
	}

	/**This method is aboutclick Paypal In Bag
	 * 
	 */
	public void clickPaypalInBag() {
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.paypalBtn);
		test.log(LogStatus.PASS,"Paypal button in shopping bag is Clicked"); 
		Reporter.log("Paypal button in shopping bag is Clicked");
	}

	/**This method is aboutclick Checkout As Guest In PopUp
	 * @throws InterruptedException
	 */
	public void clickCheckoutAsGuestInPopUp() throws InterruptedException {
		Thread.sleep(2000);
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.continueBtn);
		test.log(LogStatus.PASS,"Continue As Guest button in pop up is Clicked");
		Reporter.log("Continue As Guest button in pop up is Clicked");
		Thread.sleep(3000);
	}

	/**This method is aboutclick Checkout With PayPal Button
	 * 
	 */
	public void clickCheckoutWithPayPalBtn() {
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.paypalBtn);
		test.log(LogStatus.PASS,"Clicked on check out with paypal butto");
		Reporter.log("Clicked on check out with paypal button");

	}
	
	/**This method is aboutclick Continue To Shipping
	 * 
	 */
	public void clickContinueToShipping(){
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.continue_to_shipping);
		test.log(LogStatus.PASS,"clicked on continue to shipping button");
		Reporter.log("clicked on continue to shipping button");
	}
	/**This method is aboutsave This Address
	 * 
	 */
	public void saveThisAddress(){
		objectRep.loadCheckoutObj();
		addExplicitWait(objectRep.saveAddressButton, "clickable", 300);
		clickUsingJavascriptExecutor(objectRep.saveAddressButton);
		test.log(LogStatus.PASS,"clicked on save this address to my account"); 
		Reporter.log("clicked on save this address to my account");	
	}
	/**This method is aboutedit Addresses
	 * @throws InterruptedException
	 */
	public void editAddresses() throws InterruptedException{
		objectRep.loadCheckoutObj();
		Thread.sleep(2000);
		isElementVisible(By.xpath("//div[contains(@class,'js_checkout_sections checkout_sections')]/div[3]//span[contains(text(),'Edit')]"));
		test.log(LogStatus.PASS,"edit for the shipping button");
		Reporter.log("edit for the shipping button");
	}
	
	/**This method is aboutclick Edit Addresses
	 * @throws InterruptedException
	 */
	public void clickEditAddresses() throws InterruptedException{
		objectRep.loadCheckoutObj();
		Thread.sleep(2000);
		isElementVisible(By.xpath("//div[contains(@class,'js_checkout_sections checkout_sections')]/div[3]//span[contains(text(),'Edit')]"));
		clickUsingJavascriptExecutor(By.xpath("//div[contains(@class,'js_checkout_sections checkout_sections')]/div[3]//span[contains(text(),'Edit')]"));
		test.log(LogStatus.PASS,"edit for the shipping button is clicked"); 
		Reporter.log("edit for the shipping button is clicked");
	}
	/**This method is aboutEdit Addresses
	 * @throws InterruptedException
	 */
	public void EditAddresses() throws InterruptedException{
		objectRep.loadCheckoutObj();
		Thread.sleep(2000);
		isElementVisible(By.xpath("//div[contains(@class,'js_checkout_sections checkout_sections')]/div[3]//span[contains(text(),'Edit')]"));
		test.log(LogStatus.PASS,"edit for the shipping button is clicked"); 
		Reporter.log("edit for the shipping button is clicked");
	}
	/**This method is aboutclick Save And Continue Button In Shipping Address PopUp
	 * 
	 */
	public void clickSaveAndContinueBtnInShippingAddrPopUp() {
		objectRep.loadCheckoutObj();
		try{
			Thread.sleep(10000);
			clickUsingJavascriptExecutor(By.xpath("//button[@name='dwfrm_singleshipping_shippingAddress_useSuggested']"));
			
		test.log(LogStatus.PASS,"Yes use this address is clicked"); 
		Reporter.log("Yes use this address is clicked");
		Thread.sleep(5000);}
		catch(Exception e)
		{
			test.log(LogStatus.PASS,"No Address confirmation popup since edit link is clicked");
			Reporter.log("No Address confirmation popup since edit link is clicked");
		}
	}
	/**This method is about click Credit Card Radio button
	 * @throws InterruptedException
	 */
	public void clickCreditCardRbtn() throws InterruptedException {
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.creditCardBtn);
		test.log(LogStatus.PASS,"Credit card Radio Button is Clicked"); 
		Reporter.log("Credit card Radio Button is Clicked");
		Thread.sleep(3000);
	}

	/**This method is aboutclick PayPal Radio button
	 * @throws InterruptedException
	 */
	public void clickPayPalRbtn() throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(objectRep.paypalRBtn);
		test.log(LogStatus.PASS,"PayPal Radio Button is Clicked"); 
		Reporter.log("PayPal Radio Button is Clicked");
	}

	/**This method is aboutlogin With PayPal Account
	 * @param email
	 * @param password
	 * @throws InterruptedException
	 */
	public void loginWithPayPalAccount(String email, String password) throws InterruptedException {
		objectRep.loadPaypalObjects();
		try {
			clickUsingJavascriptExecutor(objectRep.payPalEmailChange);

		}
		catch(Exception e) {
			
		}
		Thread.sleep(4000);
		clickUsingJavascriptExecutor(objectRep.payPalEmail);
		type(objectRep.payPalEmail, email);
		try {
		clickUsingJavascriptExecutor(objectRep.payPalNext);
		}
		catch(Exception e) {
			
		}
		clickUsingJavascriptExecutor(objectRep.payPalPassword);
		type(objectRep.payPalPassword, password);
		Thread.sleep(4000);
		clickUsingJavascriptExecutor(objectRep.payPalLogInBtn);
		test.log(LogStatus.PASS,"PayPal Login Button is Clicked");
		Reporter.log("PayPal Login Button is Clicked");
		TimeUnit.SECONDS.sleep(5);

	}
	
	public void loginWithPayPalAccountMobile(String email, String password) throws InterruptedException {
		objectRep.loadPaypalObjects();
		try {
			clickUsingJavascriptExecutor(objectRep.payPalEmailChange);

		}
		catch(Exception e) {
			
		}
		Thread.sleep(4000);
		clickUsingJavascriptExecutor(objectRep.payPalEmail);
		type(objectRep.payPalEmail, email);
		try {
		clickUsingJavascriptExecutor(objectRep.payPalNext);
		}
		catch(Exception e) {
			
		}
		clickUsingJavascriptExecutor(objectRep.payPalPassword);
		type(objectRep.payPalPassword, password);
		Thread.sleep(4000);
		clickUsingJavascriptExecutor(objectRep.payPalLogInBtnMobile);
		test.log(LogStatus.PASS,"PayPal Login Button is Clicked");
		Reporter.log("PayPal Login Button is Clicked");
		TimeUnit.SECONDS.sleep(5);

	}

	/**This method is aboutlogin With PayPal Accounts
	 * @param email
	 * @param password
	 * @throws InterruptedException
	 */
	public void loginWithPayPalAccounts(String email, String password) throws InterruptedException
	{
	objectRep.loadPaypalObjects();
	TimeUnit.SECONDS.sleep(10);
	clickUsingJavascriptExecutor(objectRep.payPalEmail);
	type(objectRep.payPalEmail, email);
	try{
		clickUsingJavascriptExecutor(By.xpath("//button[@id='btnNext']"));
		Thread.sleep(2000);
	}catch(Exception e)
	{
		test.log(LogStatus.PASS,"Next Button is not present"); 
		Reporter.log("Next Button is not present" );
	}
	clickUsingJavascriptExecutor(objectRep.payPalPassword);
	Thread.sleep(2000);
	type(objectRep.payPalPassword, password);
	clickUsingJavascriptExecutor(objectRep.payPalLogInBtn);
	test.log(LogStatus.PASS,"PayPal sign in button is clicked"); 
	Reporter.log("PayPal sign in button is clicked");
	Thread.sleep(6000);
	}
	

	/**This method is aboutclick Continue In PayPal
	 * @throws InterruptedException
	 */
	public void clickContinueInPayPal() throws InterruptedException {
		objectRep.loadPaypalObjects();
		Thread.sleep(5000);
		scrollToElementUsingJavascriptExecutor(objectRep.paypalContinueBtn);
		if (isElementPresent(objectRep.paypalContinueBtn)) {
			Thread.sleep(3000);
			clickUsingJavascriptExecutor(objectRep.paypalContinueBtn);
			test.log(LogStatus.PASS,"PayPal Continue Button is Clicked");
			Reporter.log("PayPal Continue Button is Clicked");
			Thread.sleep(3000);
		}

	}
	/**This method is aboutclick PayPal Button
	 * @throws InterruptedException
	 */
	public void clickPayPalBtn() throws InterruptedException{
		Thread.sleep(6000);
		switchToFrameByWebElement(By.xpath("//iframe[@title='PayPal']"));
		clickUsingJavascriptExecutor(By.xpath("//span[@class='paypal-button-text' and contains(text(),'Checkout')]"));
		test.log(LogStatus.PASS,"paypal is clicked");
		Reporter.log("paypal is clicked");
		Thread.sleep(3000);
		
	}

	/**This method is aboutclick Review Order
	 * 
	 */
	public void clickReviewOrder() {
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.reviewOrderBtn);
		test.log(LogStatus.PASS,"Review Order is Clicked");
		Reporter.log("Review Order is Clicked");
	}

	/**This method is aboutclick Continue Button In PopUp
	 * 
	 */
	public void clickContinueBtnInPopUp() {
		objectRep.loadCheckoutObj();
		try {
			clickUsingJavascriptExecutor(By.xpath("//span[text()='Continue >']"));
			// clickUsingJavascriptExecutor(objectRep.saveAndContinueBtn);
			test.log(LogStatus.PASS,"Continue button in Shipping and Billing Verification Pop Up is Clicked"); 
			Reporter.log("Continue button in Shipping and Billing Verification Pop Up is Clicked");
		} catch (Exception e) {
			try {
				clickUsingJavascriptExecutor(objectRep.saveAndContinueBtn);
				test.log(LogStatus.PASS,"Save and Continue button in Shipping and Billing Verification Pop Up is Clicked"); 
				Reporter.log("Save and Continue button in Shipping and Billing Verification Pop Up is Clicked");
			} catch (Exception e1) {

			}
		}
	}

	/**This method is aboutclick Submit Order
	 * @throws InterruptedException
	 */
	public void clickSubmitOrder() throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(5000);
		clickUsingJavascriptExecutor(objectRep.submitOrder);
		test.log(LogStatus.PASS,"Submit Order is Clicked"); 
		Reporter.log("Submit Order is Clicked");
			}
	
	
	public void clickSubmitOrderMobile() throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(5000);
		clickUsingJavascriptExecutor(objectRep.submitOrderMobile);
		test.log(LogStatus.PASS,"Submit Order is Clicked"); 
		Reporter.log("Submit Order is Clicked");
			}
	/**This method is about click shuimage
	 * 
	 */
	public void clickshuimage(){
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.clickImage);
		//doubleClick(objectRep.clickImage);
		test.log(LogStatus.PASS,"Shuumera image is clicked");
		Reporter.log("Shuumera image is clicked");
		
	}
	/**This method is about click My Account
	 * 
	 */
	public void clickMyAccount(){
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.myaccLnk);
		test.log(LogStatus.PASS,"My account is clicked"); 
		Reporter.log("My account is clicked");
	}
	/**This method is aboutclick Address Book
	 * 
	 */
	public void clickAddressBook(){
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.addressBook);
		test.log(LogStatus.PASS,"My account is clicked"); 
		Reporter.log("My account is clicked");
	}
	
	/**This method is aboutverify Added Address
	 * @param fname
	 * @throws InterruptedException
	 */
	public void verifyAddedAddress(String fname) throws InterruptedException{
		objectRep.loadCheckoutObj();
		Thread.sleep(3000);
		isElementVisible(By.xpath("//div[contains(@class,'mini_address_name') and contains(text(),'"+fname+"')]"));
		test.log(LogStatus.PASS,"the added address is visible");
		Reporter.log("the added address is visible");
		Thread.sleep(2000);
	}
	/**This method is aboutclick Place Order
	 * @throws InterruptedException
	 */
	public void clickPlaceOrder() throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(4000);
		clickUsingJavascriptExecutor(objectRep.placeOrder);
		test.log(LogStatus.PASS,"Place Order is Clicked"); 
		Reporter.log("Place Order is Clicked");
			}

	/**This method is about display Order Number
	 * @throws InterruptedException
	 */
	public void displayOrderNumber() throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(5000);
		isElementVisible(objectRep.orderNum);
		test.log(LogStatus.PASS,"Order Number is" +getText(objectRep.orderNum)); 
		Reporter.log("Order Number is" +getText(objectRep.orderNum));
		Thread.sleep(3000);
	}

	/**This method is aboutverify Order Confirmation
	 * @throws Exception
	 */
	public void verifyOrderConfirmation() throws Exception {
		objectRep.loadCheckoutObj();
		String confirmation = getText(objectRep.orderConfirmationMsg);
		if (confirmation.equalsIgnoreCase("THANK YOU! YOUR ORDER HAS BEEN PLACED")) {
			test.log(LogStatus.PASS,"Order is placed succesfully " + getText(objectRep.orderConfirmationMsg));
			Reporter.log("Order is placed succesfully " + getText(objectRep.orderConfirmationMsg));
		}
		else {
			test.log(LogStatus.PASS,"Order is not placed succesfully " + getText(objectRep.orderConfirmationMsg)); 
			Reporter.log("Order is not placed succesfully " + getText(objectRep.orderConfirmationMsg));
			throw new Exception("Order is not placed succesfully " + getText(objectRep.orderConfirmationMsg));
		}

	}

	/**This method is about verify Review Order Details
	 * @param address1
	 * @throws Exception
	 */
	public void verifyReviewOrderDetails(String address1) throws Exception {
		objectRep.loadCheckoutObj();
		if (getText(objectRep.sa1InreviewPage).equalsIgnoreCase(address1)) {
			test.log(LogStatus.PASS,"Shipping details is displayed corretly");
			Reporter.log("Shipping details is displayed corretly");
		} else {
			test.log(LogStatus.PASS,"Shipping is displayed incorrect");
			Reporter.log("Shipping is displayed incorrect");
			throw new Exception("Shipping is displayed incorrect");
		}
		if (getText(objectRep.ba1InreviewPage).equalsIgnoreCase(address1)) {
			test.log(LogStatus.PASS,"Billing details is displayed corretly");
			Reporter.log("Billing details is displayed corretly");
		} else {
			test.log(LogStatus.PASS,"Shipping is displayed incorrect");
			Reporter.log("Shipping is displayed incorrect");
			throw new Exception("Billing details is displayed incorrect");
		}
		
	}

	/**This method is about choose Billing Address Registred
	 * @throws InterruptedException
	 */
	public void chooseBillingAddressRegistred() throws InterruptedException {
		objectRep.loadCheckoutObj();
		selectDropDownByValue(objectRep.b_addr_dropdwn,"10 Hudson yards");

/*		selectDropDownByIndex(objectRep.b_addr_dropdwn, 1);
*/		Thread.sleep(3000);
		test.log(LogStatus.PASS,"Selected address with name from drop down"); 
		Reporter.log("Selected address with name from drop down");

	}

	/**This method is about choose Shipping Address Registered
	 * @throws InterruptedException
	 */
	public void chooseShippingAddressRegistred() throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(4000);
/*		selectDropDownByIndex(objectRep.s_addr_dropdwn, 0);
*/		selectDropDownByValue(objectRep.s_addr_dropdwn,"10 Hudson yards");
        //selectDropDownByValue(objectRep.s_addr_dropdwn,"Choose a saved address");
		test.log(LogStatus.PASS,"Selected address with name from drop down"); 
		Reporter.log("Selected address with name from drop down");
	}

	/**This method is about select Option Choose Saved Address
	 * @throws InterruptedException
	 */
	public void selectOptionChooseSavedAddress() throws InterruptedException {
		objectRep.loadCheckoutObj();
/*		selectDropDownByIndex(objectRep.s_addr_dropdwn, 0);
*/      selectDropDownByVisibleText(objectRep.s_addr_dropdwn, "Choose a saved address");
		Thread.sleep(2000);
		/*clear(objectRep.s_firstName);
		clear(objectRep.s_firstName);
		clear(objectRep.s_lastName);
		clear(objectRep.s_address1);
		clickUsingJavascriptExecutor(objectRep.s_states);
		selectDropDownByVisibleText(objectRep.s_states, "Select State *");
		clear(objectRep.s_city);
		clear(objectRep.s_zip);
		clear(objectRep.s_phone);*/

	}

	/**This method is aboutselect Same As Shipping Address
	 * 
	 */
	public void selectSameAsShippingAdd() {
		objectRep.loadCheckoutObj();
		String checked = driver.findElement(objectRep.billing_chkbox).getAttribute("checked");
		if (checked == null) {
			test.log(LogStatus.PASS,"same as Shipping address checkbox is selected by default");
			Reporter.log("same as Shipping address checkbox is selected by default");
			clickUsingJavascriptExecutor(objectRep.billing_chkbox);
		}

		else {
			test.log(LogStatus.PASS,"same as Shipping address checkbox is selected by default"); 
			Reporter.log("same as Shipping address checkbox is selected by default");
		}

	}

	/**This method is aboutunCheck Same As Shipping Address
	 * @throws InterruptedException
	 */
	public void unCheckSameAsShippingAdd() throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(5000);
		String checked = driver.findElement(objectRep.billing_chkbox).getAttribute("checked");

		System.out.println(" checked  " + checked);
		boolean b1 = Boolean.parseBoolean(checked);
		if (b1 == true) {
			test.log(LogStatus.PASS,"same as Shipping address checkbox is selected by defaul");
			Reporter.log("same as Shipping address checkbox is selected by default");
			clickUsingJavascriptExecutor(objectRep.billing_chkbox);
		}

		else {
			test.log(LogStatus.PASS,"same as Shipping address checkbox is not selected by default");
			Reporter.log("same as Shipping address checkbox is not selected by default");
		}
		/*clear(objectRep.b_firstName);
		clear(objectRep.b_lastName);
		clear(objectRep.b_address1);
		clear(objectRep.b_city);
		clear(objectRep.b_zip);
		clear(objectRep.b_phone);*/

	}

	/**This method is about select Card Details Registered User
	 * @throws InterruptedException
	 */
	public void selectCardDetailsRegistered() throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(3000);
/*		selectDropDownByIndex(objectRep.selectCardList, 1);
*/		//selectDropDownByVisibleText(objectRep.selectCardList, "(Amex) ***********1347 - 08.2027");
		type(objectRep.cvv, "123");
		test.log(LogStatus.PASS,"credit card added successfully");
		Reporter.log("credit card added successfully");
		Thread.sleep(3000);
	}

	/**This method is about select Option select from Save Cards
	 * 
	 */
	public void selectOptionselectfromSaveCards() {
		objectRep.loadCheckoutObj();
/*		selectDropDownByIndex(objectRep.selectCardList, 0);
*/		selectDropDownByVisibleText(objectRep.selectCardList, "Select from Saved Cards");

	}

	/**This method is about edit Billing Address
	 * 
	 */
	public void editBillingAddr() {
		objectRep.loadCheckoutObj();
		
		type(objectRep.b_address1, "edited billing adress");
		clickUsingJavascriptExecutor(objectRep.s_addToAddrBook);
	}

	/**This method is aboutedit Billing Address In Review Order Page
	 * @throws Exception
	 */
	public void editBillingAddrInReviewOrderPage() throws Exception {
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.editBillingAddr);
		type(objectRep.b_address1, "billing adddress edited");

		clickUsingJavascriptExecutor(objectRep.b_addToAddrBook);

	}

	/**This method is aboutedit Shipping Address
	 * @param fname
	 * @throws InterruptedException
	 */
	public void editShippingAddr(String fname) throws InterruptedException {
		objectRep.loadCheckoutObj();
		Thread.sleep(4000);
		clickUsingJavascriptExecutor(By.xpath("//div[contains(@class,'js_checkout_sections checkout_sections')]/div[3]//span[contains(text(),'Edit')]"));
		type(objectRep.s_firstName, fname);
		clickUsingJavascriptExecutor(objectRep.s_addToAddrBook);
	}

	/**This method is about add To Address Book
	 * 
	 */
	public void addToAddressBook() {
		clickUsingJavascriptExecutor(objectRep.s_addToAddrBook);
	}

	/**This method is about edit Shipping In Review Order Page
	 * 
	 */
	public void editShippingInReviewOrderPage() {
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.editBillingAddr);
		type(objectRep.s_address1, "asasdsa");
		clickUsingJavascriptExecutor(objectRep.s_addToAddrBook);
	}

	/**This method is about verify Shipping Address In Review Order Page
	 * @param fname
	 * @throws Exception
	 */
	public void verifyShippingAddressInReviewOrderPage(String fname) throws Exception {
		objectRep.loadCheckoutObj();
		Thread.sleep(3000);
		scrollToElementUsingJavascriptExecutor(By.xpath("//div[contains(@class,'chmodule_shippingaddress')]//div[contains(@class,'mini_address_name')][contains(text(),'"+fname+"')]"));
		isElementVisible(By.xpath("//div[contains(@class,'chmodule_shippingaddress')]//div[contains(@class,'mini_address_name')][contains(text(),'"+fname+"')]"));
		
			test.log(LogStatus.PASS,"Shipping Address is update");
			Reporter.log("Shipping Address is updated");
		
	}

	/**This method is about verify Shipping Address
	 * @param address
	 * @throws Exception
	 */
	public void verifyShippingAddress(String address) throws Exception {
		objectRep.loadCheckoutObj();
		String addr = getText(objectRep.sa1InreviewPage);
		System.out.println(" addr in revire apge  " + addr);
		if (getText(objectRep.sa1InreviewPage).equalsIgnoreCase(address)) {
			test.log(LogStatus.PASS,"Shipping Address updated in review order page");
			Reporter.log("Shipping Address updated in review order page");
		} else {
			throw new Exception("Shipping Address is not updated in review order page");
		}
		clickUsingJavascriptExecutor(objectRep.myaccLnk);
		clickUsingJavascriptExecutor(objectRep.editAddrLnk);
		try {
			if (isElementVisible(objectRep.getaddrValInEditLnk(addr))) {
				test.log(LogStatus.PASS,"Address updated"); 
				Reporter.log("Address updated");
			}
		} catch (Exception e) {
			throw new Exception("Address is not added in address book");
		}
	}

	/**This method is about verify Billing Address In Review Order Page
	 * @param address
	 * @throws Exception
	 */
	public void verifyBillingAddressInReviewOrderPage(String address) throws Exception {
		objectRep.loadCheckoutObj();
		String addr = getText(objectRep.ba1InreviewPage);
		System.out.println(" addr in revire apge  " + addr);
		if (getText(objectRep.ba1InreviewPage).toLowerCase().equalsIgnoreCase(address)) {
			test.log(LogStatus.PASS,"Billing address is added"); 
			Reporter.log("Billing address is added");
		} else {
			// test.log(LogStatus.PASS,""); Reporter.log("");
			throw new Exception("Billing address is not added");
		}
	}

	/**This method is aboutverify Billing Address
	 * @param address
	 * @throws Exception
	 */
	public void verifyBillingAddress(String address) throws Exception {
		objectRep.loadCheckoutObj();
		Thread.sleep(4000);
		String addr = getText(objectRep.ba1InreviewPage);
		System.out.println(" addr in revire apge  " + addr);
		if (getText(objectRep.ba1InreviewPage).toLowerCase().equalsIgnoreCase(address.toLowerCase())) {
			test.log(LogStatus.PASS,"Billing address is added");
			Reporter.log("Billing address is added");
		} else {
			throw new Exception("Billing address is not added");
		}
		
		
	}

	/**This method is about verify Empty Billing Address
	 * @throws Exception
	 */
	public void verifyEmptyBillingAddress() throws Exception {
		objectRep.loadCheckoutObj();
		if (getText(objectRep.b_firstName_error).contains("Please enter first name")) {
			test.log(LogStatus.PASS,"\"Error displayed corretly\" + getText(objectRep.b_firstName_error)");
			Reporter.log("Error displayed corretly" + getText(objectRep.b_firstName_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly");
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}

		if (getText(objectRep.b_lastName_error).contains("Please enter last name")) {
			test.log(LogStatus.PASS,"Error displayed corretly" + getText(objectRep.b_lastName_error)); 
			Reporter.log("Error displayed corretly" + getText(objectRep.b_lastName_error));
		} else {
			test.log(LogStatus.PASS,"\"Error displayed incorretly\"");
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}

		if (getText(objectRep.b_address1_error).contains("Please enter address 1")) {
			test.log(LogStatus.PASS,"Error displayed corretly" + getText(objectRep.b_address1_error));
			Reporter.log("Error displayed corretly" + getText(objectRep.b_address1_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly");
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}
		
		if (getText(objectRep.b_city_error).contains("Please enter city")) {
			test.log(LogStatus.PASS,"Error displayed corretly" + getText(objectRep.b_city_error));
			Reporter.log("Error displayed corretly" + getText(objectRep.b_city_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly");
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}
		if (getText(objectRep.b_zip_error).contains("Please enter ZIP code")) {
			test.log(LogStatus.PASS,"Error displayed corretly" + getText(objectRep.b_zip_error)); 
			Reporter.log("Error displayed corretly" + getText(objectRep.b_zip_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly"); 
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}
		if (getText(objectRep.b_phone_error).contains("Please enter the phone")) {
			test.log(LogStatus.PASS,"Error displayed corretly" + getText(objectRep.b_phone_error));
			Reporter.log("Error displayed corretly" + getText(objectRep.b_phone_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly");
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}
	}

	/**This method is aboutverify Empty Shipping Address
	 * @throws Exception
	 */
	public void verifyEmptyShippingAddress() throws Exception {
		objectRep.loadCheckoutObj();
		if (getText(objectRep.s_firstName_error).contains("Please enter first name")) {
			test.log(LogStatus.PASS,"Error displayed corretly" + getText(objectRep.s_firstName_error));
			Reporter.log("Error displayed corretly" + getText(objectRep.s_firstName_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly");
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}

		if (getText(objectRep.s_lastName_error).contains("Please enter last name")) {
			test.log(LogStatus.PASS,"Error displayed corretly" + getText(objectRep.s_lastName_error));
			Reporter.log("Error displayed corretly" + getText(objectRep.s_lastName_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly"); 
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}

		if (getText(objectRep.s_address1_error).contains("Please enter address 1")) {
			test.log(LogStatus.PASS,"Error displayed corretly" + getText(objectRep.s_address1_error));
			Reporter.log("Error displayed corretly" + getText(objectRep.s_address1_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly"); 
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}

		
		if (getText(objectRep.s_city_error).contains("Please enter city")) {
			test.log(LogStatus.PASS,"\"Error displayed corretly\" + getText(objectRep.s_city_error)");
			Reporter.log("Error displayed corretly" + getText(objectRep.s_city_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly");
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}
		if (getText(objectRep.s_zip_error).contains("Please enter ZIP code")) {
			test.log(LogStatus.PASS,"Error displayed corretly" + getText(objectRep.s_zip_error));
			Reporter.log("Error displayed corretly" + getText(objectRep.s_zip_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly");
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}
		if (getText(objectRep.s_phone_error).contains("Please enter the phone")) {
			test.log(LogStatus.PASS,"Error displayed corretly" + getText(objectRep.s_phone_error));
			Reporter.log("Error displayed corretly" + getText(objectRep.s_phone_error));
		} else {
			test.log(LogStatus.PASS,"Error displayed incorretly");
			Reporter.log("Error displayed incorretly");
			throw new Exception("Error displayed incorretly");
		}
	}

	/**This method is aboutclick Edit Payment Info Link
	 * 
	 */
	public void clickEditPaymentInfoLnk() {
		clickUsingJavascriptExecutor(By.xpath("//button[@name='dwfrm_summary_payment']"));

	}

	/**This method is aboutvalidate Shipping Methods
	 * @throws InterruptedException
	 * @throws Exception
	 */
	public void validateShippingMethods() throws InterruptedException, Exception {
		Thread.sleep(5000);
		if (changeShippingMethod("Next Day Shipping")) {
			test.log(LogStatus.PASS,"Shipping price is changed when next day shipping method is selected"); 
			Reporter.log("Shipping price is changed when next day shipping method is selected");
		}
		else
			throw new Exception("Shipping price is not changed when next day shipping method is selected");
		if (changeShippingMethod("3 Day Shipping")) {
			test.log(LogStatus.PASS,"Shipping price is changed when 3 Days shipping method is selected"); 
			Reporter.log("Shipping price is changed when 3 Days shipping method is selected");
		}
		else
			throw new Exception("Shipping price is not changed when next day shipping method is selected");
		if (changeShippingMethod("Ground Shipping")) {
			test.log(LogStatus.PASS,"Shipping price is changed when Ground shipping method is selected"); 
			Reporter.log("Shipping price is changed when Ground shipping method is selected");
		}
		else
			throw new Exception("Shipping price is not changed when Ground shipping method is selected");
		if (changeShippingMethod("2 Day Shipping")) {
			test.log(LogStatus.PASS,"Shipping price is changed when 2nd Day shipping method is selected");
			Reporter.log("Shipping price is changed when 2nd Day shipping method is selected");
		}
		else
			throw new Exception("Shipping price is not changed when 2nd Day shipping method is selected");

	}

	/**This method is aboutchange Shipping Method
	 * @param methodname
	 * @return
	 * @throws InterruptedException
	 */
	public boolean changeShippingMethod(String methodname) throws InterruptedException {
		String beforechange = getText(
				By.xpath("//td[contains(text(),'Shipping')]//following-sibling::td/parent::tr[contains(@class,'first')]"));
		Thread.sleep(4000);
		if (isElementPresent(By.xpath("//input[contains(@data-shipping-name,'" + methodname + "')]")))
			clickUsingJavascriptExecutor(By.xpath("//input[contains(@data-shipping-name,'" + methodname + "')]"));
		
		else
			return true;
		Thread.sleep(4000);
		String afterchange = getText(
				By.xpath("//td[contains(text(),'Shipping')]//following-sibling::td/parent::tr[contains(@class,'first')]"));
		
		if (!beforechange.equalsIgnoreCase(afterchange))
			return true;
		
		else
			return false;
	}
}
