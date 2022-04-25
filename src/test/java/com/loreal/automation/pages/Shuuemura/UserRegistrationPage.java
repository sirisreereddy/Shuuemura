/**This test case contains all methods related to User Registration page
 * @author SURYA
 *
 */
package com.loreal.automation.pages.Shuuemura;

import java.security.SecureRandom;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.loreal.automation.base.BasePage;
import com.loreal.automation.utilities.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserRegistrationPage extends BasePage {
    public static String tempFirstName;
    public static String tempLastName;

	public UserRegistrationPage(WebDriver driver,ExtentTest test) {
		super(driver,test);
	}

	@Override
	public boolean hasPageLoaded() {
		return false;
	}

	@Override
	public String getPageUrl() {
		return null;
	}

	ObjectRepository objRep = new ObjectRepository();

	public void clickRegisterLnk() {
		objRep.loadHomePageObjects();
		clickUsingJavascriptExecutor(objRep.registerLnk);
		test.log(LogStatus.PASS,"Clicked on Register link"); 
		Reporter.log("Clicked on Register link");

	}
	
	public void clickOnCreateAcc(){
		clickUsingJavascriptExecutor(By.xpath("//span[contains(text(),'Create an Account')]"));
		test.log(LogStatus.PASS,"Clicked on create account link"); 
		Reporter.log("Clicked on create account link");
	}

	public void createNewAccount(String fname, String lname,  String password,String address,String city,String state, String zip, String phone,String month,
			String date, String year) throws Exception {
		objRep.loadCreateAccountObjects();
		objRep.loadHomePageObjects();
		type(objRep.ca_firstName, fname);
		type(objRep.ca_lastName, lname);
		String ranEmail=randomEmailGen();
		type(objRep.ca_email, ranEmail);
		type(objRep.ca_confirmEmail,ranEmail);
		type(objRep.ca_pwd, password);
		type(objRep.ca_confirmPwd, password);
		type(objRep.ca_address, address);
		type(objRep.ca_city, city);
		selectDropDownByValue(objRep.ca_state,state);
		type(objRep.ca_ZIP, zip);
		type(objRep.ca_phone,phone);
		selectDropDownByVisibleText(objRep.ca_month, month);
		selectDropDownByVisibleText(objRep.ca_date, date);
		selectDropDownByVisibleText(objRep.ca_year, year);
		clickUsingJavascriptExecutor(objRep.submitBtn);
		if (isElementVisible(objRep.welcomeMsg)) {
			test.log(LogStatus.PASS,"Account is created successfully with email id" + ranEmail); 
			Reporter.log("Account is created successfully with email id" + ranEmail);
		}
		else {
			test.log(LogStatus.PASS,"Account is not created"); 
			Reporter.log("Account is not created");
			throw new Exception("Account is not created");
		}

	}

	public void createNewAccountMobile(String fname, String lname,  String password,String address,String city,String state, String zip, String phone,String month,
			String date, String year) throws Exception {
		objRep.loadCreateAccountObjects();
		objRep.loadHomePageObjects();
		type(objRep.ca_firstName, fname);
		type(objRep.ca_lastName, lname);
		String ranEmail=randomEmailGen();
		type(objRep.ca_email, ranEmail);
		type(objRep.ca_confirmEmail,ranEmail);
		type(objRep.ca_pwd, password);
		type(objRep.ca_confirmPwd, password);
		type(objRep.ca_address, address);
		type(objRep.ca_city, city);
		selectDropDownByValue(objRep.ca_state,state);
		type(objRep.ca_ZIP, zip);
		type(objRep.ca_phone,phone);
		selectDropDownByVisibleText(objRep.ca_month, month);
		selectDropDownByVisibleText(objRep.ca_date, date);
		selectDropDownByVisibleText(objRep.ca_year, year);
		clickUsingJavascriptExecutor(objRep.submitBtn);
			test.log(LogStatus.PASS,"Account is created successfully with email id" + ranEmail); 
			Reporter.log("Account is created successfully with email id" + ranEmail);

	}

	
	public void validateCreateAccountForm() throws Exception {
		objRep.loadCreateAccountObjects();
		clickUsingJavascriptExecutor(objRep.submitBtn);
		compareActualWithExpected(getText(objRep.ca_firstNameErr), "Please enter your first name");
		compareActualWithExpected(getText(objRep.ca_lastNameErr), "Please enter your last name");
		compareActualWithExpected(getText(objRep.ca_emailErr), "Please enter your email address");
		compareActualWithExpected(getText(objRep.ca_pwdErr), "Please enter your password");
		compareActualWithExpected(getText(objRep.ca_confirmPwdErr), "Please enter your password");
		compareActualWithExpected(getText(objRep.ca_ZIPerr), "Please enter your Zip Code");
		compareActualWithExpected(getText(objRep.ca_monthErr), "Please enter your month of birth");
		compareActualWithExpected(getText(objRep.ca_dateErr), "Please enter your date of birth");
		compareActualWithExpected(getText(objRep.ca_yearErr), "Please enter your year of birth");

	}

	public void compareActualWithExpected(String actual, String expected) throws Exception {
		if (actual.contains(expected)) {
			test.log(LogStatus.PASS,"String is as expected. Actual msg:" + actual + "Expected msg:" + expected);
			Reporter.log("String is as expected. Actual msg:" + actual + "Expected msg:" + expected);
		} else {
			test.log(LogStatus.PASS,"Acutal is not same as expected Actual msg:" + actual + "Expected msg:" + expected);
			Reporter.log("Acutal is not same as expected Actual msg:" + actual + "Expected msg:" + expected);
			throw new Exception("Acutal is not same as expected Actual msg:" + actual + "Expected msg:" + expected);
		}

	}

	public void validateFandLname(String invalidname) throws Exception {
		objRep.loadCreateAccountObjects();
		objRep.loadUserRegistrationObjects();
		type(objRep.ca_firstName, invalidname);
		type(objRep.ca_lastName, invalidname);
		type(objRep.ca_email, randomEmailGen());
		type(objRep.ca_pwd, "123456789");
		type(objRep.ca_confirmPwd, "123456789");
		type(objRep.ca_ZIP, "10001");
/*		selectDropDownByVisibleText(objRep.ca_month, "April");
		selectDropDownByVisibleText(objRep.ca_date, "10");
		selectDropDownByVisibleText(objRep.ca_year, "1999");*/
		if(isElementPresent(objRep.editState))
		selectDropDownByVisibleText(objRep.editState, "New York");
		if(isElementPresent(objRep.editPhone))
		type(objRep.editPhone, "8521458796");
		clickUsingJavascriptExecutor(objRep.submitBtn);
		addExplicitWait(objRep.ca_firstNameErr, "presence", 20);
		System.out.println(getText(objRep.ca_firstNameErr));
		System.out.println(getText(objRep.ca_lastNameErr));	
		
		compareActualWithExpected(getText(objRep.ca_firstNameErr), "Please enter valid first name");
		compareActualWithExpected(getText(objRep.ca_lastNameErr), "Please enter valid last name");
	}

	public void validateEmailInCreateAccountForm(String invalidemail) throws Exception {
		objRep.loadCreateAccountObjects();
		Thread.sleep(5000);
		type(objRep.ca_email, invalidemail);
		type(objRep.ca_firstName, "abcd");
		test.log(LogStatus.PASS,"entered email address: " + invalidemail); 
		Reporter.log("entered email address: " + invalidemail);
		Thread.sleep(5000);
		compareActualWithExpected(getText(objRep.ca_invalidEmailErr), "The email address is invalid");
	}

	public void validatePwdFieldsInCreateAccountForm(String invalidPwd) throws Exception {
		objRep.loadCreateAccountObjects();
		type(objRep.ca_pwd, invalidPwd);
		test.log(LogStatus.PASS,"entered password: " + invalidPwd);
		Reporter.log("entered password: " + invalidPwd);
		type(objRep.ca_firstName, "abcd");
		compareActualWithExpected(getText(objRep.ca_invalidPwdErr), "Enter 8-25 characters");

	}

	public void validatePwdFieldsWithDifferenctInputs() throws Exception {
		objRep.loadCreateAccountObjects();
		type(objRep.ca_pwd, "123456789");
		test.log(LogStatus.PASS,"entered password: 123456789");
		Reporter.log("entered password: 123456789");
		type(objRep.ca_confirmPwd, "8745963214");
		type(objRep.ca_firstName, "abcd");
		test.log(LogStatus.PASS,"entered password in confirm password field: 8745963214"); 
		Reporter.log("entered password in confirm password field: 8745963214");
		compareActualWithExpected(getText(objRep.ca_notConfirmPwdErr), "Does not match password");
	}

	public void validateZipInCreateAccountForm(String zip) throws Exception {
		objRep.loadCreateAccountObjects();
		type(objRep.ca_ZIP, zip);
		type(objRep.ca_firstName, "abcd");
		test.log(LogStatus.PASS,"Entered zip code as: " + zip); 
		Reporter.log("Entered zip code as: " + zip);
		compareActualWithExpected(getText(objRep.ca_invalidZipErr), "Please enter a valid value");
	}

	public void signIn(String username, String password) throws Exception {
		objRep.loadCreateAccountObjects();
		try {
			if (isElementPresent(By.xpath("//button[@title='close']")))
				clickUsingJavascriptExecutor(By.xpath("//button[@title='close']"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		type(objRep.signInEmail, username);
		type(objRep.signInPwd, password);
		clickUsingJavascriptExecutor(objRep.signInBtn);
		Thread.sleep(5000);
		isElementVisible(By.xpath("//div[@class='myaccount_welcome']"));
	    By objWelcomeMsg = By.xpath("//div[@class='myaccount_welcome']");
		WebElement ele = driver.findElement(objWelcomeMsg);
        String completeWelcomeText = ele.getText();
        System.out.println("Complete welcome text is: " + completeWelcomeText);
        String[] welcomeTextElements = completeWelcomeText.split(" ");
        tempFirstName = welcomeTextElements[1];
        System.out.println("Logged In successfully with email id: " + username);
        Reporter.log("First name is: " + welcomeTextElements[1]);
        test.log(LogStatus.PASS, "First name is: " + welcomeTextElements[1]);
        Reporter.log("Logged in successfully with email id: " + username);
        test.log(LogStatus.PASS, "Logged in successfully with email id: " + username);
    }

	
	
    public void confirmLoggedInUser(String username, String password) throws Exception {
		objRep.loadCreateAccountObjects();

        System.out.println("email is: " + username);
		type(objRep.signInEmail, username);
		type(objRep.signInPwd, password);
		clickUsingJavascriptExecutor(objRep.signInBtn);
		Thread.sleep(5000);
		isElementVisible(By.xpath("//div[@class='myaccount_welcome']"));
	    By objWelcomeMsg = By.xpath("//div[@class='myaccount_welcome']");
		WebElement ele = driver.findElement(objWelcomeMsg);
        String completeWelcomeText = ele.getText();
        System.out.println("Complete welcome text is: " + completeWelcomeText);
        String[] welcomeTextElements = completeWelcomeText.split(" ");
        System.out.println("verifyFirstName is: " + tempFirstName);
        if (welcomeTextElements[1].equalsIgnoreCase(tempFirstName)) {
            System.out.println("Name mismatch");
            Reporter.log("Name mismatch");
            test.log(LogStatus.FAIL, "Name mismatch");
            throw new Exception("Issue in logging in with email " + username);
        } else {
            System.out.println("Logged In successfully with email id: " + username);
            Reporter.log("First name is: " + welcomeTextElements[1]);
            test.log(LogStatus.PASS, "First name is: " + welcomeTextElements[1]);
            Reporter.log("Logged in successfully with email id: " + username);
            test.log(LogStatus.PASS, "Logged in successfully with email id: " + username);
        }
    }
    
    public void clickLogOutLnk() {
        clickUsingJavascriptExecutor(By.xpath("//a[contains(text(),'logout')]"));
        Reporter.log("Log out link is clicked");
        test.log(LogStatus.PASS, "Log out link is clicked");
    }

	public void validateSignInForm() throws Exception {
		objRep.loadCreateAccountObjects();
		type(objRep.signInEmail, "adsadfertjingle@gmail.com");
		type(objRep.signInPwd, "8745125896");
		clickUsingJavascriptExecutor(objRep.signInBtn);
		test.log(LogStatus.PASS,"Entered invalid username and password");
		Reporter.log("Entered invalid username and password");
		Thread.sleep(3000);
		if (isElementPresent(objRep.recordMisMatchErr)) {
			test.log(LogStatus.PASS,"Error is displayed as :" + getText(objRep.recordMisMatchErr));
			Reporter.log("Error is displayed as :" + getText(objRep.recordMisMatchErr));
		}
		else {
			test.log(LogStatus.PASS,"Error is not displayed when signed in with invalid credentials");
			Reporter.log("Error is not displayed when signed in with invalid credentials");
			throw new Exception("Error is not displayed when signed in with invalid credentials");
		}
	}

	public void forgotPassword(String email) throws Exception {
		objRep.loadCreateAccountObjects();
		clickUsingJavascriptExecutor(objRep.forgotPwdLnk);
		type(objRep.forgotPwdEmail, email);
		clickUsingJavascriptExecutor(objRep.sendBtn);
		if (isElementVisible(objRep.resetPwdSuccessMsg)) {
			test.log(LogStatus.PASS,"Message is displayed as : " + getText(objRep.resetPwdSuccessMsg)); 
			Reporter.log("Message is displayed as : " + getText(objRep.resetPwdSuccessMsg));
		}
		else
			throw new Exception("Forgot password functionality is not working");

	}
	
	public void openGmail() {
		
		driver.get("https://www.gmail.com");
	}

	public void EnterGmailCredentials(String username, String password) throws InterruptedException {
		
		objRep.loadEmailObjects();
		type(objRep.gmailUsername,username);
		clickUsingJavascriptExecutor(objRep.nextButton);
		Thread.sleep(5000);
		type(objRep.gmailPassword,password);
		clickUsingJavascriptExecutor(objRep.nextButton);
	}

	public void verifyInbox(String brandName) throws Exception {
		

		Thread.sleep(2000);
		// now talking un-read email form inbox into a list
		
		List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span"));
	    System.out.println(a.size());
	    for (int i = 0; i < a.size(); i++) {
	        System.out.println(a.get(i).getText());
	        if (a.get(i).getText().equals(brandName)) //to click on a specific mail.
	            {      
	        	a.get(i).click();
	           test.log(LogStatus.PASS,"Mail has been received to reset password");
	           Reporter.log("Mail has been received to reset password");  
	           break;}
	        else
	        {
	        	test.log(LogStatus.PASS,"no Mail");
	        	Reporter.log("no Mail");
	        //	throw new Exception("No email");
	        }
	        
	    
	}
	    
	}

	public void clickpasswordResetLink() {
		objRep.loadEmailObjects();
		clickUsingJavascriptExecutor(objRep.clickpwdResetLink);
		
	}

	public void resetpassword(String newPwd) throws InterruptedException
	{
		objRep.loadEmailObjects();
		switchToWindow();
		type(objRep.objResetPwd,newPwd);
		type(objRep.objConfirmPwd,newPwd);
		Thread.sleep(5000);
		clickUsingJavascriptExecutor(objRep.objapplyBtn);
		Thread.sleep(3000);
	}

	public void signInusingNewPwd(String email,String newPwd) throws Exception
	{
		objRep.loadCreateAccountObjects();
		type(objRep.signInEmail, email);
		type(objRep.signInPwd, newPwd);
		clickUsingJavascriptExecutor(objRep.signInBtn);
		if(isElementVisible(objRep.signInEmail))
		{
			throw new Exception("password is not updated");
		}
		else
		{
			test.log(LogStatus.PASS,"Password is updated successfully and user is able to login using new password"); 
			Reporter.log("Password is updated successfully and user is able to login using new password");
		}

		//clickUsingJavascriptExecutor(objectRep.objlogInBtn);
	}





	public void clickMyAccountLnk() {
		objRep.loadHomePageObjects();
		clickUsingJavascriptExecutor(objRep.welcomeMsg);
		test.log(LogStatus.PASS,"Clicked on My Account link");
		Reporter.log("Clicked on My Account link");
	}

	public void clickViewEditPersonalInfoLnk() {
		objRep.loadUserRegistrationObjects();
		clickUsingJavascriptExecutor(objRep.editPersonalInfoLnk);
		test.log(LogStatus.PASS,"Clicked on View/Edit Personal Info link");
		Reporter.log("Clicked on View/Edit Personal Info link");

	}

	public void editAccountInfo(String firstname, String lastname, String email, String password, String state,String Address,
			String phone,String city) throws Exception {
		objRep.loadCreateAccountObjects();
		objRep.loadUserRegistrationObjects();
		type(objRep.ca_firstName, firstname);
		type(objRep.ca_lastName, lastname);
		type(objRep.ca_email, email);
		type(objRep.ca_confirmemail,email);
		type(objRep.ca_pwd, password);
		type(objRep.ca_confirmPwd, password);
		type(objRep.ca_address,Address);
		selectDropDownByVisibleText(objRep.editState, state);
		type(objRep.editPhone, phone);
		type(objRep.ca_city,city);
		clickUsingJavascriptExecutor(objRep.submitBtn);
		Thread.sleep(5000);
		/*
		 * String updated = getText( By.xpath(
		 * "//div[@class='myaccount_personal_info myaccount_block']//div[@class='inner']"
		 * ));
		 */
	String updatedfname = driver.findElement(objRep.ca_firstName).getAttribute("value");
		String updatedlname = driver.findElement(objRep.ca_lastName).getAttribute("value");
		if (updatedfname.contains(firstname)) {
			test.log(LogStatus.PASS,"first name is updated in Account info"); 
			Reporter.log("first name is updated in Account info");
		}
		else
			throw new Exception("first name is not updated in Account info");
		if (updatedlname.contains(lastname)) {
			test.log(LogStatus.PASS,"last name is updated in Account info"); 
			Reporter.log("last name is updated in Account info");
		}
		else
			throw new Exception("last name is not updated in Account info");

	}

	public void validateEditAccountInfoForm() throws Exception {
		objRep.loadCreateAccountObjects();
		objRep.loadUserRegistrationObjects();
		clear(objRep.ca_firstName);
		clear(objRep.ca_lastName);
		clear(objRep.ca_email);
		clear(objRep.ca_pwd);
		clear(objRep.ca_confirmPwd);
		
		clear(objRep.editPhone);
		clear(objRep.ca_ZIP);
		clickUsingJavascriptExecutor(objRep.submitBtn);
		compareActualWithExpected(getText(objRep.ca_firstNameErr), "Please enter your first name");
		compareActualWithExpected(getText(objRep.ca_lastNameErr), "Please enter your last name");
		compareActualWithExpected(getText(objRep.ca_emailErr), "Please enter your email address");
		compareActualWithExpected(getText(objRep.ca_pwdErr), "Please enter your password");
		compareActualWithExpected(getText(objRep.ca_confirmPwdErr), "Please enter your password");
		//compareActualWithExpected(getText(objRep.editStateErr), "Please select state");
		compareActualWithExpected(getText(objRep.ca_ZIPerr), "Please enter your Zip Code");
		//compareActualWithExpected(getText(objRep.editPhoneErr), "Please enter the phone");

	}

	public String randomEmailGen() {

		String alphabets = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int len = 3;
		SecureRandom rndm = new SecureRandom();
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(alphabets.charAt(rndm.nextInt(alphabets.length())));
		result.append(sb);
		sb.append(alphabets.charAt(rndm.nextInt(alphabets.length())));
		sb.reverse();
		result.append(sb);
		result.append("@gmail.com");
		System.out.println(result);
		return result.toString();

	}
	public String randomFnameGen() {

		String alphabets = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int len = 3;
		SecureRandom rndm = new SecureRandom();
		StringBuilder result = new StringBuilder();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(alphabets.charAt(rndm.nextInt(alphabets.length())));
		result.append(sb);
		sb.append(alphabets.charAt(rndm.nextInt(alphabets.length())));
		sb.reverse();
		result.append(sb);
		System.out.println(result);
		return result.toString();

	}

	public void clickEditAddressLnk() {
		objRep.loadUserRegistrationObjects();
		clickUsingJavascriptExecutor(objRep.editAddressLnk);
		test.log(LogStatus.PASS,"Clicked on edit address link"); 
		Reporter.log("Clicked on edit address link");
	}

	public void clickAddNewAddressLnk() {
		objRep.loadUserRegistrationObjects();
		clickUsingJavascriptExecutor(objRep.addNewAddress);
		test.log(LogStatus.PASS,"Clicked on add address link"); 
		Reporter.log("Clicked on add address link");

	}

	public void addNewAddress(String addname, String fname, String lname, String add1, String state, String city,
			String zip, String phone) throws Exception {
		objRep.loadUserRegistrationObjects();
		type(objRep.newAddName, addname);
		type(objRep.newAddFirstName, fname);
		type(objRep.newAddLastName, lname);
		type(objRep.newAddAdd1, add1);
		selectDropDownByVisibleText(objRep.newAddState, state);
		type(objRep.newAddCity, city);
		type(objRep.newAddZip, zip);
		type(objRep.newAddPhone, phone);
		clickUsingJavascriptExecutor(objRep.submitBtn);
		if (isElementVisible(objRep.getAddName(addname))) {
			test.log(LogStatus.PASS,"Address is added with name: " + addname); 
			Reporter.log("Address is added with name: " + addname);
		}
		else
			throw new Exception("Issue in Adding Address");
	}

	public void validateAddAddressForm() throws Exception {
		objRep.loadUserRegistrationObjects();
		clickUsingJavascriptExecutor(objRep.submitBtn);
		compareActualWithExpected(getText(objRep.newAddNameErr), "Please enter the address name");
		compareActualWithExpected(getText(objRep.newAddFirstNameErr), "Please enter first name");
		compareActualWithExpected(getText(objRep.newAddLastNameErr), "Please enter last name");
		compareActualWithExpected(getText(objRep.newAddAdd1Err), "Please enter address 1");
		compareActualWithExpected(getText(objRep.newAddStateErr), "Please select state");
		compareActualWithExpected(getText(objRep.newAddCityErr), "Please enter city");
		compareActualWithExpected(getText(objRep.newAddZipErr), "Please enter ZIP code");
		compareActualWithExpected(getText(objRep.newAddPhoneErr), "Please enter the phone");
		type(objRep.newAddCity, "k");
		type(objRep.newAddZip, "12345");
		compareActualWithExpected(getText(objRep.newAddCitysErr), "Please enter at least 2 characters");
	}

	public void validateZipInAddAddressForm(String zip) throws Exception {
		objRep.loadUserRegistrationObjects();
		type(objRep.newAddZip, zip);
		type(objRep.newAddPhone, "5247412589");
		test.log(LogStatus.PASS,"Entered zip value :" + zip);
		Reporter.log("Entered zip value :" + zip);
		compareActualWithExpected(getText(objRep.newAddZipErr), "Please enter a valid value");

	}

	public void validatePhoneInAddAddressForm(String phone) throws Exception {
		objRep.loadUserRegistrationObjects();
		type(objRep.newAddPhone, phone);
		type(objRep.newAddZip, "85241");
		test.log(LogStatus.PASS,"Entered phone value :" + phone); 
		Reporter.log("Entered phone value :" + phone);
		compareActualWithExpected(getText(objRep.newAddInvalidPhoneErr), "Please enter the valid phone number");
	}

	public void editAddress(String addname, String newname) {
		objRep.loadUserRegistrationObjects();
		clickUsingJavascriptExecutor(objRep.getEditAddLnk(addname));
		type(objRep.newAddName, newname);
		clickUsingJavascriptExecutor(objRep.submitBtn);
		if (isElementVisible(objRep.getAddName(newname))) {
			test.log(LogStatus.PASS,"Address name is edited from " + addname + " to " + newname);
			Reporter.log("Address name is edited from " + addname + " to " + newname);
		}
		else
			test.log(LogStatus.PASS,""); Reporter.log("Address name is not edited from " + addname + " to " + newname);
	}

	public void clickEditCardLnk() {
		objRep.loadUserRegistrationObjects();
		clickUsingJavascriptExecutor(objRep.editPaymentInfoLnk);
		test.log(LogStatus.PASS,"Clicked on edit payment info link");
		Reporter.log("Clicked on edit payment info link");

	}

	public void clickAddNewCardLnk() {
		objRep.loadUserRegistrationObjects();
		clickUsingJavascriptExecutor(objRep.addNewCardLnk);
		test.log(LogStatus.PASS,"Clicked add new card link"); 
		Reporter.log("Clicked add new card link");

	}

	public void addNewCard(String cardname, String cardholder, String cardtype, String cardnumber, String month,
			String year) throws Exception {
		objRep.loadUserRegistrationObjects();
		type(objRep.cardNickName, cardname);
		type(objRep.creditCardName, cardholder);
		selectDropDownByVisibleText(objRep.cardType, cardtype);
		type(objRep.creditCardNum, cardnumber);
		selectDropDownByVisibleText(objRep.expMonth, month);
		selectDropDownByVisibleText(objRep.expYear, year);
		clickUsingJavascriptExecutor(objRep.submitCard);
		if (isElementVisible(objRep.getRemoveCardLnk(cardname))) {
			test.log(LogStatus.PASS,"Card is Added");
			Reporter.log("Card is Added");
		}
		else {
			throw new Exception("Card could not be added");
		}
	}

	public void clickSubmit() {
		objRep.loadUserRegistrationObjects();
		clickUsingJavascriptExecutor(objRep.submitCard);
		test.log(LogStatus.PASS,"The card details are validated");
		Reporter.log("The card details are validated");

	}

	public void validateCardDetails() throws Exception {
		objRep.loadUserRegistrationObjects();
		//selectDropDownByVisibleText(objRep.expMonth, "Exp. Month *");
		clickUsingJavascriptExecutor(objRep.submitCard);
		compareActualWithExpected(getText(objRep.creditCardNameErr), "Please enter the cardholder name");
		compareActualWithExpected(getText(objRep.creditCardNumErr), "Please enter the credit card number");
		compareActualWithExpected(getText(objRep.cardNickNameErr), "Please enter the name on card");
		compareActualWithExpected(getText(objRep.expYearErr), "Please select a Expiration Year");
		test.log(LogStatus.PASS,"The card details are validated");
		Reporter.log("The card details are validated");

	}

	public void validateWithInvalidcardNum(String cardnum) throws Exception {
		objRep.loadUserRegistrationObjects();
		type(objRep.creditCardNum, cardnum);
		clickUsingJavascriptExecutor(objRep.submitCard);
		try {
			compareActualWithExpected(getText(objRep.creditCardNumErr), "Please enter the credit card number");
		} catch (Exception e) {
			compareActualWithExpected(getText(objRep.creditCardNumErrr), "Wrong credit card number");
		}

	}

	public void removeCard(String cardname) throws Exception {
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(objRep.getRemoveCardLnk(cardname));
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		if (isElementPresent(objRep.getRemoveCardLnk(cardname)))
			throw new Exception("Card is not removed ");
		else {
			test.log(LogStatus.PASS,"Card is removed");
			Reporter.log("Card is removed");
		}

	}
	
	public void removeAddress(String addname) throws Exception {
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(objRep.deketeAddLnk(addname));
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		if (isElementPresent(objRep.deketeAddLnk(addname)))
			throw new Exception("address is not removed ");
		else {
			test.log(LogStatus.PASS,"address is removed");
			Reporter.log("address is removed");
		}

	}

	public void removeCardMobile(String cardname) throws Exception {
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(objRep.getRemoveCardLnk(cardname));
		Thread.sleep(3000);

		clickUsingJavascriptExecutor(By.xpath("//button[contains(text(),'ok']"));

		//driver.switchTo().alert().accept();
		if (isElementPresent(objRep.getRemoveCardLnk(cardname)))
			throw new Exception("Card is not removed ");
		else {
			test.log(LogStatus.PASS,"Card is removed");
			Reporter.log("Card is removed");
		}

	}

	public void removeAddressMobile(String addressname) throws Exception {
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(objRep.deketeAddLnk(addressname));
		Thread.sleep(3000);

		clickUsingJavascriptExecutor(By.xpath("//button[contains(text(),'ok']"));

		//driver.switchTo().alert().accept();
		if (isElementPresent(objRep.deketeAddLnk(addressname)))
			throw new Exception("address is not removed ");
		else {
			test.log(LogStatus.PASS,"address is removed");
			Reporter.log("address is removed");
		}

	}

	public void signInMobile(String username, String password) throws Exception {

		objRep.loadCreateAccountObjects();
		type(objRep.signInEmail, username);
		type(objRep.signInPwd, password);
		clickUsingJavascriptExecutor(objRep.signInBtn);
		test.log(LogStatus.PASS,"Entered username and password");
		Reporter.log("Entered username and password");
			test.log(LogStatus.PASS,"logged in successfully with username " + username); 
			Reporter.log("logged in successfully with username " + username);

	}

	public void validateOrderStatusForm() {
		objRep.loadCreateAccountObjects();
		type(objRep.trackOrderNumber, "874521");
		type(objRep.trackOrderEmail, "abcd@gmail.com");
		type(objRep.trackOrderZip, "10001");
		clickUsingJavascriptExecutor(objRep.checkStatusBtn);
		if (isElementVisible(objRep.orderRecordMisMatchErr)) {
			test.log(LogStatus.PASS,"Record mismatch error is displayed");
			Reporter.log("Record mismatch error is displayed");
		}
		else
			test.log(LogStatus.PASS,"Record mismatch error is not displayed"); 
		Reporter.log("Record mismatch error is not displayed");
	}

	public void checkOrderStatus(String ordernumber, String emailid, String zip) throws Exception {
		objRep.loadCreateAccountObjects();
		type(objRep.trackOrderNumber, ordernumber);
		type(objRep.trackOrderEmail, emailid);
		type(objRep.trackOrderZip, zip);
		clickUsingJavascriptExecutor(objRep.checkStatusBtn);
		String actualTitle = getPageTitle();
		if (actualTitle.contains("Check Order")) {
			test.log(LogStatus.PASS,"Order Details are displayed"); 
			Reporter.log("Order Details are displayed");
		}
		else
			throw new Exception("Order Details are not displayed");

	}

}
