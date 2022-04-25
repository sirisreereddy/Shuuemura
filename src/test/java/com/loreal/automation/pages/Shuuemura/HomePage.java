/**This test case contains all methods related to HOME page
 * @author SURYA
 *
 */
package com.loreal.automation.pages.Shuuemura;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.loreal.automation.base.BasePage;
import com.loreal.automation.utilities.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver,ExtentTest test) {
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

	/**launch BasePage
	 * @throws InterruptedException
	 */
	public void launchBasePage() throws InterruptedException {
		launchBaseURL();
		maximizeWindow();
		test.log(LogStatus.PASS,"Application is Launched Successfully");
		Reporter.log("Application is Launched Successfully");
/*if(isElementPresent(By.xpath("//a[text()='Accept']")))
	clickUsingJavascriptExecutor(By.xpath("//a[text()='Accept']"));
		maximizeWindow();
	}*/
	}

	/**launch BasePage Mobile
	 * 
	 */
	public void launchBasePageMobile() {
		launchBaseURL();
		test.log(LogStatus.PASS,"Application is Launched Successfully");
		Reporter.log("Application is Launched Successfully");

	}

	/**hover Menu Item
	 * @param menu
	 */
	public void hoverMenuItem(String menu) {
		mouseOver(objRep.getMainMenuHeaderLink(menu));
		test.log(LogStatus.PASS,"Mouse Hover is performed on Menu Item");
		Reporter.log("Mouse Hover is performed on Menu Item");
	}

	/**click SubMenu
	 * @param submenu
	 */
	public void clickSubMenu(String submenu) {
		clickUsingJavascriptExecutor(objRep.getSubMenuLink(submenu));
		test.log(LogStatus.PASS,"Sub Menu is clicked"); 
		Reporter.log("Sub Menu is clicked");
	}

	/**click Product In Plp
	 * @param productname
	 */
	public void clickProductInPlp(String productname) {
		objRep.loadHomeBagObjects();
		mouseOver(objRep.bagLnk);
		clickUsingJavascriptExecutor(objRep.getProductLnk(productname));
		test.log(LogStatus.PASS,"Product is Clicked In PLP");
		Reporter.log("Product is Clicked In PLP");
	}

	/**hover bag
	 * @throws InterruptedException
	 */
	public void hoverbag() throws InterruptedException {
		objRep.loadHomeBagObjects();
		mouseOver(objRep.bagLnk);
		test.log(LogStatus.PASS,"Mouse Hover is performed in Bag"); 
		Reporter.log("Mouse Hover is performed in Bag");
		Thread.sleep(5000);
	}

	/**click Bag Link
	 * @throws InterruptedException
	 */
	public void clickBagLnk() throws InterruptedException {
		objRep.loadHomeBagObjects();
		Thread.sleep(3000);
		mouseOver(objRep.bagHeaderLnk);
		clickUsingJavascriptExecutor(objRep.bagHeaderLnk);
		test.log(LogStatus.PASS,"Bag Header link is clicked");
		Reporter.log("Bag Header link is clicked");
	}
	
	/**click Header Logo
	 * @throws InterruptedException
	 */
	public void clickHeaderLogo() throws InterruptedException {
		objRep.loadHomeBagObjects();
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(objRep.clickLogo);
		test.log(LogStatus.PASS,"Bag Header link is clicke"); 
		Reporter.log("Bag Header link is clicked");
	}

	/**click Bag Link Mobile
	 * 
	 */
	public void clickBagLnkMobile() {
		objRep.loadHomeBagObjects();
		clickUsingJavascriptExecutor(objRep.bagHeaderLnk);
		test.log(LogStatus.PASS,"Bag Header link is clicked");
		Reporter.log("Bag Header link is clicked");
	}

	/**click Checkout In Bag
	 * 
	 */
	public void clickCheckoutInBag() {
		objRep.loadBagObjects();
		clickUsingJavascriptExecutor(objRep.checkoutBtnInBag);
		test.log(LogStatus.PASS,"Checkout button in Hovering Bag  is clicked");
		Reporter.log("Checkout button in Hovering Bag  is clicked");
	}

	/**click Search Button
	 * @param keyword
	 */
	public void clickSearchBtn(String keyword) {
		objRep.loadHomePageObjects();
		type(objRep.searchToggle, keyword);
		clickUsingJavascriptExecutor(objRep.searchBtn);
		test.log(LogStatus.PASS,"Search Button is clicked");
		Reporter.log("Search Button is clicked");

	}
	/**click Search Button Mobile
	 * @param keyword
	 * @throws InterruptedException
	 */
	public void clickSearchBtnMobile(String keyword) throws InterruptedException {
		objRep.loadHomePageObjects();
		clickUsingJavascriptExecutor(objRep.searchBtnMobile);
		Thread.sleep(2000);
		type(objRep.searchToggle, keyword);
		clickUsingJavascriptExecutor(objRep.searchInfoBtn);
		test.log(LogStatus.PASS,"Search Button is clicked and typed");
		Reporter.log("Search Button is clicked and typed");

	}

	/**click Menu Button In Header Mobile
	 * 
	 */
	public void clickMenuButtonInHeaderMobile() {
		clickUsingJavascriptExecutor(By.xpath("//h2[@class='navigation_header class.navigation.header']"));
		// clickUsingJavascriptExecutor(By.xpath(""));
		test.log(LogStatus.PASS,"Menu button is clicked");
		Reporter.log("Menu button is clicked");
	}
	
	
	public void clickHamburgerMenuButtonInHeaderMobile() {
		clickUsingJavascriptExecutor(By.xpath("//a[@id='hgnavtoggle']"));
		// clickUsingJavascriptExecutor(By.xpath(""));
		test.log(LogStatus.PASS,"Hamburger Menu button is clicked");
		Reporter.log("HamburgerMenu button is clicked");
	}

	/**verify Main Menu Header Links
	 * @param menu
	 * @throws Exception
	 */
	public void verifyMainMenuHeaderLinks(String menu) throws Exception {
		try {
			isElementVisible(objRep.getMainMenuHeaderLink(menu));
			test.log(LogStatus.PASS,menu + " link is displayed in header"); 
			Reporter.log(menu + " link is displayed in header");
		} catch (Exception e) {
			throw new Exception(menu + " is not displayed in header");
		}
	}

	/**verify HomePage Content
	 * 
	 */
	public void verifyHomePageContent() {
		objRep.loadHomePageObjects();
		isElementVisible(objRep.homepageCarousel);
		test.log(LogStatus.PASS,"Carousel is displayed in home page");
		Reporter.log("Carousel is displayed in home page");
		isElementVisible(objRep.newBanner);
		test.log(LogStatus.PASS,"New Banner is displayed in home pag"); 
		Reporter.log("New Banner is displayed in home page");
		/*isElementVisible(objRep.galleryOfStyleBanner);
		test.log(LogStatus.PASS,""); Reporter.log("Gallery of Style Banner is displayed in home page");*/
		isElementVisible(objRep.newShuBanner);
		test.log(LogStatus.PASS,"New Shu Banner is displayed in home page"); 
		Reporter.log("New Shu Banner is displayed in home page");
		isElementVisible(objRep.bestSellingProducts);
		test.log(LogStatus.PASS,"Best selling products section is displayed in home page"); 
		Reporter.log("Best selling products section is displayed in home page");
		isElementVisible(objRep.socialImages);
		test.log(LogStatus.PASS,"Social Image section is displayed in home page");
		Reporter.log("Social Image section is displayed in home page");
		test.log(LogStatus.PASS,"Home Page is opened with all details"); 
		Reporter.log("Home Page is opened with all details");
	}

	public void verifyHomePageContentMobile() {
		objRep.loadHomePageObjects();
		isElementVisible(objRep.homepageCarousel);
		test.log(LogStatus.PASS,"Carousel is displayed in home page");
		Reporter.log("Carousel is displayed in home page");
		isElementVisible(objRep.newBannerMobile);
		test.log(LogStatus.PASS,"New Banner is displayed in home pag"); 
		Reporter.log("New Banner is displayed in home page");
		/*isElementVisible(objRep.galleryOfStyleBanner);
		test.log(LogStatus.PASS,""); Reporter.log("Gallery of Style Banner is displayed in home page");*/
		isElementVisible(objRep.newShuBannerMobile);
		test.log(LogStatus.PASS,"New Shu Banner is displayed in home page"); 
		Reporter.log("New Shu Banner is displayed in home page");
	}

	/**click Main Menu Link
	 * @param menu
	 * @throws InterruptedException
	 */
	public void clickMainMenuLink(String menu) throws InterruptedException {
		//mouseOver(objRep.getMainMenuHeaderLink(menu));
		//clickUsingJavascriptExecutor(By.xpath("//a[contains(@class,'level_1_list_item') and contains(text(),'"+menu+"')]"));
 clickUsingJavascriptExecutor(By.xpath("//a[@class='level_1_list_item_link category_link shampoos']"));
		doubleClick(By.xpath("//a[@class='level_1_list_item_link category_link shampoos']"));
test.log(LogStatus.PASS,menu + " is clicked");
Reporter.log(menu + " is clicked");
	}

	/**click Main Menu Link Mobile
	 * @param menu
	 */
	public void clickMainMenuLinkMobile(String menu) {
		clickUsingJavascriptExecutor(objRep.getMainMenuHeaderLinkMobile(menu));
		test.log(LogStatus.PASS,menu + " is clicked");
		Reporter.log(menu + " is clicked");
	}

	/**click SubMenu Link
	 * @param submenu
	 */
	public void clickSubMenuLink(String submenu) {
		clickUsingJavascriptExecutor(objRep.getSubMenuLink(submenu));
		test.log(LogStatus.PASS,submenu + " is clicked");
		Reporter.log(submenu + " is clicked");
	}

	/**hover On Main Menu
	 * @param mainmenu
	 */
	public void hoverOnMainMenu(String mainmenu) {
		mouseOver(objRep.getMainMenuHeaderLink(mainmenu));
		test.log(LogStatus.PASS,"Mouse Hover is perfromed on" + mainmenu); 
		Reporter.log("Mouse Hover is perfromed on" + mainmenu);
	}

	/**sign In
	 * @throws InterruptedException
	 */
	public void signIn() throws InterruptedException {
waitforPageLoad();
		clickUsingJavascriptExecutor(
				By.xpath("//a[@title='Sign in']"));
		Thread.sleep(2000);
		try {
			if (isElementPresent(By.xpath("//button[@title='close']")))
				clickUsingJavascriptExecutor(By.xpath("//button[@title='close']"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		type(By.xpath("//input[contains(@id,'dwfrm_login_username')]"), "lorealtcs@gmail.com");
		type(By.xpath("//input[@id='dwfrm_login_password']"), "123456789");
		clickUsingJavascriptExecutor(By.xpath("//button[@name='dwfrm_login_login']"));

	}
	public void signIn1() throws InterruptedException {
		waitforPageLoad();
				clickUsingJavascriptExecutor(
						By.xpath("//a[@title='Sign in']"));
				Thread.sleep(2000);
				try {
					if (isElementPresent(By.xpath("//button[@title='close']")))
						clickUsingJavascriptExecutor(By.xpath("//button[@title='close']"));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				type(By.xpath("//input[contains(@id,'dwfrm_login_username')]"), "lorealtcs2021@gmail.com");
				type(By.xpath("//input[@id='dwfrm_login_password']"), "123456789");
				clickUsingJavascriptExecutor(By.xpath("//button[@name='dwfrm_login_login']"));

			}

	/**sign In Mobile
	 * 
	 */
	public void signInMobile() {
		clickUsingJavascriptExecutor(
				By.xpath("//a[@class='account_navigation_link login_link'][contains(text(),'My Account')]"));
		clickUsingJavascriptExecutor(
				By.xpath("//a[@class='account_navigation_link login_link'][contains(text(),'Sign in')]"));
		type(By.xpath("//input[contains(@id,'dwfrm_login_username')]"), "ac@gmail.com");
		type(By.xpath("//input[@id='dwfrm_login_password']"), "123456789");
		clickUsingJavascriptExecutor(By.xpath("//span[contains(text(),'Sign In')]"));

	}

	/**launch Staging BasePage
	 * @throws InterruptedException
	 */
	public void launchStagingBasePage() throws InterruptedException {
		driver.get("https://storefront:loreal1@shuuemura.lorastagingus.com");
		if (isElementPresent(By.xpath("//a[contains(text(),'Accept')]")))
			clickUsingJavascriptExecutor(By.xpath("//a[contains(text(),'Accept')]"));
		test.log(LogStatus.PASS,"Application is Launched Successfully");
		Reporter.log("Application is Launched Successfully");
		maximizeWindow();
	}

	/**verify Menu Navigation
	 * @param menuname
	 * @throws Exception
	 */
	public void verifyMenuNavigation(String menuname) throws Exception {
		clickUsingJavascriptExecutor(objRep.getMainMenuHeaderLink(menuname));

		if (isElementPresent(By.xpath("//li//span[contains(text(),'" + menuname + "')]"))) {
			test.log(LogStatus.PASS,"Navigated to correct page when clicked on menu \" + menuname"); 
			Reporter.log("Navigated to correct page when clicked on menu " + menuname);
		}
		else
			throw new Exception("Did not navigate to correct page when clicked on menu " + menuname);

	}

	/**verify GTM
	 * @param value
	 * @throws Exception
	 */
	public void verifyGTM(String value) throws Exception {
		objRep.loadHomePageObjects();
		// addExplicitWait(objectRep.kiehlsLogo, "visibility", 30);
		String pageTitle = driver.getTitle();
		System.out.println("Current page title is " + pageTitle);
		test.log(LogStatus.PASS,"Current page title is " + pageTitle); 
		Reporter.log("Current page title is " + pageTitle);
		checkGTM(value);

	}

	public void checkGTM(String value) throws Exception {
		Thread.sleep(1000);
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		Object title = javaScriptExecutor.executeScript("return window.app.customGoogleTagManagerID");
		System.out.println("GTM is " + title);
		test.log(LogStatus.PASS,"GTM is " + title);
		Reporter.log("GTM is " + title);
		if (title == null)
			throw new Exception("GTM is null");
		else if (title.equals(value)) {
			test.log(LogStatus.PASS,"GTM ID verified successfully " + title); 
			Reporter.log("GTM ID verified successfully " + title);

		} else {
			test.log(LogStatus.PASS,"GTM ID verification failed");
			Reporter.log("GTM ID verification failed");
			throw new Exception("GTM failed");
		}
	}

}
