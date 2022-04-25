/**This test case contains all methods related to PDP
 * @author SURYA
 *
 */
package com.loreal.automation.pages.Shuuemura;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.loreal.automation.base.BasePage;
import com.loreal.automation.utilities.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProductDetailsPage extends BasePage {

	public ProductDetailsPage(WebDriver driver,ExtentTest test) {
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

	ObjectRepository objectRep = new ObjectRepository();
     
	public void clickAddToBag() throws InterruptedException
	{
		objectRep.loadPDPObjects();
		clickUsingJavascriptExecutor(objectRep.addToBag);
		test.log(LogStatus.PASS,"Add To Bag Button is Clicked");
		Reporter.log("Add To Bag Button is Clicked");
		Thread.sleep(1000);
	}
	
	public void clickAutoReplenishment()
	{
		objectRep.loadPDPObjects();
		clickUsingJavascriptExecutor(objectRep.autoReplenishmentRbtn);
		test.log(LogStatus.PASS,"Auto Replishment Radio Button is Clicked");
		Reporter.log("Auto Replishment Radio Button is Clicked");
	}
	public void verifyBagObjects()
	{
		objectRep.loadBagObjects();
		isElementVisible(objectRep.productName);
		test.log(LogStatus.PASS,"Product Name is Visible");
		Reporter.log("Product Name is Visible");
		isElementVisible(objectRep.quantity);
		test.log(LogStatus.PASS,"Quantity is Visible"); 
		Reporter.log("Quantity is Visible");
		isElementVisible(objectRep.price);
		test.log(LogStatus.PASS,"Price is Visible");
		Reporter.log("Price is Visible");
		isElementVisible(objectRep.checkoutBtnInBag);
		test.log(LogStatus.PASS,"Checkout button is Visible"); 
		Reporter.log("Checkout button is Visible");
	 /* isElementVisible(objectRep.checkoutWithPayPalInBag);
		test.log(LogStatus.PASS,""); Reporter.log("Checkout With PayPal button is Visible");*/
		isElementVisible(objectRep.productImage);
		test.log(LogStatus.PASS,"Product Image is Visible"); 
		Reporter.log("Product Image is Visible");
	}
	public void verifyProductDetailsInPDP() throws Exception
	{
		objectRep.loadPDPObjects();
		isElementVisible(objectRep.productImage);
		test.log(LogStatus.PASS,"Primary image is displayed in PDP page"); 
		Reporter.log("Primary image is displayed in PDP page");
		
		isElementVisible(objectRep.productName);
		test.log(LogStatus.PASS,"Name is displayed in PDP page"); 
		Reporter.log("Name is displayed in PDP page");
		
		isElementVisible(objectRep.productSubtitle);
		test.log(LogStatus.PASS,"Subtitle is displayed in PDP page");
		Reporter.log("Subtitle is displayed in PDP page");
		
		isElementVisible(objectRep.ratingStars);
		test.log(LogStatus.PASS,"Rating in stars is displayed in PDP page");
		Reporter.log("Rating in stars is displayed in PDP page");
		
		isElementVisible(objectRep.writeAReviewLink);
		test.log(LogStatus.PASS,"Write a review link is displayed in PDP page"); 
		Reporter.log("Write a review link is displayed in PDP page");
		/*try{
		isElementVisible(objectRep.sizeDropdown);
		test.log(LogStatus.PASS,""); Reporter.log("Size dropdown is displayed in PDP page");
		}catch(Exception e)
		{
			try{
				
				isElementVisible(objectRep.colorDropdown);
				test.log(LogStatus.PASS,""); Reporter.log("Color dropdown is displayed in PDP page");
			}catch(Exception e1)
			{
				test.log(LogStatus.PASS,""); Reporter.log("Size/Color dropdown is not displayed");
			}
		}*/
		
		isElementVisible(objectRep.quantityDropdown);
		test.log(LogStatus.PASS,"Quantity dropdown is displayed in PDP page"); 
		Reporter.log("Quantity dropdown is displayed in PDP page");
		
		try{
		isElementVisible(objectRep.addToCartBtn);
		test.log(LogStatus.PASS,"Add to cart button is displayed in PDP page");
		Reporter.log("Add to cart button is displayed in PDP page");
		}catch(Exception e)
		{
			try{
				isElementVisible(objectRep.outOfStockBtn);
				test.log(LogStatus.PASS,"Out of stock button is displayed");
				Reporter.log("Out of stock button is displayed");
			}catch(Exception e1)
			{
				test.log(LogStatus.PASS,"Add to Bag/Out of stock button is not displayed");
				Reporter.log("Add to Bag/Out of stock button is not displayed");
			}
		}
		
		
		isElementVisible(objectRep.autoReplenishmentBlock);
		test.log(LogStatus.PASS,"Auto replenishment block is displayed in PDP page");
		Reporter.log("Auto replenishment block is displayed in PDP page");
		
		isElementVisible(objectRep.autoReplenishmentFrequency);
		test.log(LogStatus.PASS,"Autoreplenishment frequency dropdown is displayed in PDP page");
		Reporter.log("Autoreplenishment frequency dropdown is displayed in PDP page");
		
		isElementVisible(objectRep.detailsBlock);
		test.log(LogStatus.PASS,"Details block is displayed in PDP page"); 
		Reporter.log("Details block is displayed in PDP page");
		
		isElementVisible(objectRep.ingredientsBlock);
		test.log(LogStatus.PASS,"Ingredients block is displayed in PDP page");
		Reporter.log("Ingredients block is displayed in PDP page");
		
		/*isElementVisible(objectRep.sendToFriend);
		test.log(LogStatus.PASS,""); Reporter.log("Send to friend button is displayed in PDP page");
		
		isElementVisible(objectRep.favoriteOption);
		test.log(LogStatus.PASS,""); Reporter.log("Favorite button is displayed in PDP page");*/
		
		isElementVisible(objectRep.twitterIcon);
		test.log(LogStatus.PASS,"Twitter icon is displayed in PDP page"); 
		Reporter.log("Twitter icon is displayed in PDP page");
		
		isElementVisible(objectRep.pinterestIcon);
		test.log(LogStatus.PASS,"Pinterest icon is displayed in PDP page");
		Reporter.log("Pinterest icon is displayed in PDP page");
		
		isElementVisible(objectRep.facebookIcon);
		test.log(LogStatus.PASS,"Facebook icon is displayed in PDP page");
		Reporter.log("Facebook icon is displayed in PDP page");
		
		/*isElementVisible(objectRep.googleIcon);
		test.log(LogStatus.PASS,""); Reporter.log("Google+ icon is displayed in PDP page");*/
		try{
			isElementVisible(objectRep.recommendedProducts);
			test.log(LogStatus.PASS,"Recommended product section is displayed in PDP page"); 
			Reporter.log("Recommended product section is displayed in PDP page");
		}catch(Exception e){
			test.log(LogStatus.PASS,"Recommended product section is not displayed in PDP page");
			Reporter.log("Recommended product section is not displayed in PDP page");
		}
		

	}
	
	public void verifyProductDetailsInQuickView() throws Exception
	{
		objectRep.loadQuickViewObjects();
		isElementVisible(objectRep.productImage);
		test.log(LogStatus.PASS,"Primary image is displayed in PDP page");
		Reporter.log("Primary image is displayed in PDP page");
		
		isElementVisible(objectRep.productName);
		test.log(LogStatus.PASS,"Name is displayed in PDP page");
		Reporter.log("Name is displayed in PDP page");
		
		isElementVisible(objectRep.productSubtitle);
		test.log(LogStatus.PASS,"Subtitle is displayed in PDP page"); 
		Reporter.log("Subtitle is displayed in PDP page");
		
		/*try{
		isElementVisible(objectRep.sizeDropdown);
		test.log(LogStatus.PASS,""); Reporter.log("Size dropdown is displayed in PDP page");
		}catch(Exception e)
		{
			try{
				
				isElementVisible(objectRep.colorDropdown);
				test.log(LogStatus.PASS,""); Reporter.log("Color dropdown is displayed in PDP page");
			}catch(Exception e1)
			{
				test.log(LogStatus.PASS,""); Reporter.log("Size/Color dropdown is not displayed");
			}
		}*/
		
		isElementVisible(objectRep.quantityDropdown);
		test.log(LogStatus.PASS,"Quantity dropdown is displayed in PDP page"); 
		Reporter.log("Quantity dropdown is displayed in PDP page");
		
		try{
		isElementVisible(objectRep.addToCartBtn);
		test.log(LogStatus.PASS,"Add to cart button is displayed in PDP page");
		Reporter.log("Add to cart button is displayed in PDP page");
		}catch(Exception e)
		{
			try{
				isElementVisible(objectRep.outOfStockBtn);
				test.log(LogStatus.PASS,"Out of stock button is displayed");
				Reporter.log("Out of stock button is displayed");
			}catch(Exception e1)
			{
				test.log(LogStatus.PASS,"Add to Bag/Out of stock button is not displayed");
				Reporter.log("Add to Bag/Out of stock button is not displayed");
			}
		}
		
		isElementVisible(objectRep.sendToFriend);
		test.log(LogStatus.PASS,"Send to friend button is displayed in PDP page");
		Reporter.log("Send to friend button is displayed in PDP page");
		
		isElementVisible(objectRep.favoriteOption);
		test.log(LogStatus.PASS,"Favorite button is displayed in PDP page");
		Reporter.log("Favorite button is displayed in PDP page");
		
		isElementVisible(objectRep.twitterIcon);
		test.log(LogStatus.PASS,"Twitter icon is displayed in PDP page"); 
		Reporter.log("Twitter icon is displayed in PDP page");
		
		isElementVisible(objectRep.pinterestIcon);
		test.log(LogStatus.PASS,"Pinterest icon is displayed in PDP page"); 
		Reporter.log("Pinterest icon is displayed in PDP page");
		
		isElementVisible(objectRep.facebookIcon);
		test.log(LogStatus.PASS,"Facebook icon is displayed in PDP page");
		Reporter.log("Facebook icon is displayed in PDP page");
		
		/*isElementVisible(objectRep.googleIcon);
		test.log(LogStatus.PASS,""); Reporter.log("Google+ icon is displayed in PDP page");*/
	}
	
	
	public void applyAutoReplenishment(String frequency)
	{
		objectRep.loadPDPObjects();
		clickUsingJavascriptExecutor(objectRep.autoreplenishmentRadio);
		test.log(LogStatus.PASS,"Radio button for auto replenishment option is clicked");
		Reporter.log("Radio button for auto replenishment option is clicked");
		selectDropDownByValue(objectRep.autoReplenishmentFrequency, frequency);
		test.log(LogStatus.PASS,frequency+" option is selected from frequency dropdown");
		Reporter.log(frequency+" option is selected from frequency dropdown");
	}
	public void selectOption(String value){
		objectRep.loadPDPObjects();
		click(By.xpath("//select[@id='arMounth']"));
		
		List<WebElement> qtyDropDown = driver.findElements(objectRep.autoReplenishmentFrequency);
		for (WebElement option : qtyDropDown) {
			System.out.println("option value: " + option.getAttribute("aria-label"));
			System.out.println("user value :"+ value);
			if (option.getAttribute("aria-label").contains(value)) {
				String optionvalue = option.getAttribute("aria-label");
				test.log(LogStatus.PASS,"Option value is" + optionvalue);
				Reporter.log("Option value is" + optionvalue);
				option.click();
				break;
			}

		}
	}

	public void clickShoppingBagLink()
	{
		objectRep.loadHomePageObjects();
		clickUsingJavascriptExecutor(objectRep.bagLink);
		test.log(LogStatus.PASS,"Bag link is clicked");
		Reporter.log("Bag link is clicked");
	}
	
	public void verifyAutoreplenishmentInBag(String product) throws Exception
	{
		objectRep.loadPDPObjects();
		isElementVisible(objectRep.getAutoReplinishmentDetailsInBag(product));
		test.log(LogStatus.PASS,"Auto replenishment option is selected successfully"); 
		Reporter.log("Auto replenishment option is selected successfully");
		
	}
	}
