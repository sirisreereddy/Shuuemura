/**This test case contains all methods related to SHOPPING BAG page
 * @author SURYA
 *
 */
package com.loreal.automation.pages.Shuuemura;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.loreal.automation.base.BasePage;
import com.loreal.automation.utilities.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MyShoppingBag extends BasePage {

	public MyShoppingBag(WebDriver driver,ExtentTest test) {
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

	public void clickEditLnkInSb(String productName) throws Exception {
		objectRep.loadShoppingBagObjects();
		/*
		 * String priceBeforeEdit=getText(objectRep.productPriceInBag).trim();
		 * System.out.println("Product Price Before Edit is:" +priceBeforeEdit);
		 * test.log(LogStatus.PASS,""); Reporter.log("Product Price Before Edit is:" +priceBeforeEdit);
		 */
		// clickUsingJavascriptExecutor(objectRep.getEditLnkInShoppingBag(productName));
		clickUsingJavascriptExecutor(objectRep.editLnk);
		Thread.sleep(5000);
		selectDropDownByValue(objectRep.quantityInEditPopUp, "3");
		Thread.sleep(2000);
		clickUsingJavascriptExecutor(objectRep.updateBtn);
		Thread.sleep(5000);
		/*
		 * String priceAfterEdit=getText(objectRep.productPriceInBag).trim();
		 * System.out.println("Product Price Before Edit is:" +priceAfterEdit);
		 * test.log(LogStatus.PASS,""); Reporter.log("Product Price Before Edit is:" +priceAfterEdit);
		 */

		WebElement quantityDrop = driver
				.findElement(By.xpath("//select[@id='dwfrm_cart_shipments_i0_items_i0_quantity']"));
		Select obSelect = new Select(quantityDrop);
		WebElement Quantity = obSelect.getFirstSelectedOption();
		String defaultQuantity = Quantity.getText();
		System.out.println(defaultQuantity);
		if (defaultQuantity.contains("3")) {
			test.log(LogStatus.PASS,"Qunatity is Updated");
			Reporter.log("Qunatity is Updated");
		} else {

			throw new Exception("Quantity Is Not Updated");
		}
	}

	public void clickRemoveInSb() {
		try {
			isElementPresent(By.xpath("//span[contains(text(),'Remove')]"));
			clickUsingJavascriptExecutor(By.xpath("//span[contains(text(),'Remove')]"));
			test.log(LogStatus.PASS,"Remove Link Is clicked in SB"); 
			Reporter.log("Remove Link Is clicked in SB");
		} catch (Exception e) {
			test.log(LogStatus.PASS,"No Products In Shoping Bag");
			Reporter.log("No Products In Shoping Bag");
		}

	}

	public void verifyInvalidPromocode(String inValidPromoCode) throws Exception {
		objectRep.loadShoppingBagObjects();
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(objectRep.applyBtn);
		isElementVisible(objectRep.errorPromoCode);
		if (getText(objectRep.errorPromoCode).contains("Please enter a promo code")) {
			test.log(LogStatus.PASS,"error is displayed correctly" + getText(objectRep.errorPromoCode));
			Reporter.log("error is displayed correctly" + getText(objectRep.errorPromoCode));
		}
		else
			throw new Exception("Error is not displayed correctly" + getText(objectRep.errorPromoCode));
		type(objectRep.promoCode, inValidPromoCode);
		clickUsingJavascriptExecutor(objectRep.applyBtn);
		isElementVisible(objectRep.inValidPromoCode(inValidPromoCode));
		if (getText(objectRep.inValidPromoCode(inValidPromoCode))
				.contains("Promo code \"" + inValidPromoCode + "\" is unknown")) {
			test.log(LogStatus.PASS,"error is displayed correctly" + getText(objectRep.inValidPromoCode(inValidPromoCode))); 
			Reporter.log("error is displayed correctly" + getText(objectRep.inValidPromoCode(inValidPromoCode)));
		}
		else
			throw new Exception(
					"Error is not displayed correctly" + getText(objectRep.inValidPromoCode(inValidPromoCode)));

	}

	public void mouseHoverOnMenuItem(String menuName) throws InterruptedException {
		Thread.sleep(4000);
		mouseOver(objectRep.getMainMenuHeaderLink(menuName));
		test.log(LogStatus.PASS,"Mouse hovered on menu item"); 
		Reporter.log("Mouse hovered on menu item");

	}

	public void clickSubMenuItem(String submenu) {
		objectRep.loadHomePageObjects();
		clickUsingJavascriptExecutor(objectRep.getSubMenuLink(submenu));
		test.log(LogStatus.PASS,"Clicked on submenu link"); 
		Reporter.log("Clicked on submenu link");

	}

	public void addProductFromPLP(String productname) {
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.getProductLinkInPLPByName(productname));
		test.log(LogStatus.PASS,"added Product to Bag");
		Reporter.log("added Product to Bag");
		addExplicitWait(objectRep.addToCart, "visibility", 5);
		clickUsingJavascriptExecutor(objectRep.addToCart);
	}
	public void addProductFromPLPMobile(String productname) throws Exception {
		objectRep.loadCheckoutObj();
		clickUsingJavascriptExecutor(objectRep.getProductLinkInPLPByName(productname));
		test.log(LogStatus.PASS,"added Product to Bag");
		Reporter.log("added Product to Bag");
		Thread.sleep(5000);

		clickUsingJavascriptExecutor(objectRep.addToCartMobile);
	}

	public void verifyValidPromoCode(String promoCode) {
		objectRep.loadShoppingBagObjects();
		type(objectRep.promoCode, promoCode);
		clickUsingJavascriptExecutor(objectRep.applyBtn);
		test.log(LogStatus.PASS,"Apply Button is Clicked");
		Reporter.log("Apply Button is Clicked");
	}

	public void clickRemoveLnkInSb(String productName) throws Exception {

		//isElementVisible(objectRep.getRemoveLnkInShoppingBag(productName));
		//clickUsingJavascriptExecutor(objectRep.getRemoveLnkInShoppingBag(productName));
		clickUsingJavascriptExecutor(objectRep.getRemoveLnkInShoppingBag(productName));
		test.log(LogStatus.PASS,"Remove Link is Clicked in Shopping Bag Page");
		Reporter.log("Remove Link is Clicked in Shopping Bag Page");
		objectRep.loadShoppingBagObjects();
		Thread.sleep(3000);
		if (isElementVisible(objectRep.cartEmptyMsg)) {
			test.log(LogStatus.PASS,"Product is Removed from Shopping Bag"); 
			Reporter.log("Product is Removed from Shopping Bag");
		} else {

			throw new Exception("Product is Not Removed from Shopping Bag");
		}

	}

	public String getAvailableProductNameInPLP() {

		waitforPageLoad();
		
		addExplicitWait(By
						.xpath("//button[@title='Add to Bag' and not(@disabled)]//ancestor::div[@class='product_tile_wrapper b-product_tile-wrapper']//a[contains(@class,'product_name')]"), "presence", 50);
		return driver
				.findElement(By
						.xpath("//button[@title='Add to Bag' and not(@disabled)]//ancestor::div[@class='product_tile_wrapper b-product_tile-wrapper']//a[contains(@class,'product_name')]"))
				.getAttribute("title");

	}

	public String addPreOrderProductFromPLP() throws InterruptedException {
		Thread.sleep(3000);
		clickUsingJavascriptExecutor(By.xpath("//button[@title='Add to Bag' and not(@disabled)]//span[text()='Pre-Order']"));
		test.log(LogStatus.PASS,"Pre order product added successfully");
		Reporter.log("Pre order product added successfully");
		Thread.sleep(4000);
		return driver.findElement(By.xpath("//button[@title='Add to Bag' and not(@disabled)]//span[text()='Pre-Order']//ancestor::div[contains(@class,'product_tile')]//a[contains(@class,'product_name')]")).getAttribute("title");
		
	}

	public void checkAddedProduct(String productname) throws Exception {
		Thread.sleep(2000);
		if(isElementPresent(objectRep.getRemoveLnkInShoppingBag(productname))) {
			test.log(LogStatus.PASS,"product with pre order is added to bag");
			Reporter.log("product with pre order is added to bag");
		}
		else
			throw new Exception("product with pre order is not added to bag");
	}

	public void clickProductFromPLP(String productname) {
		clickUsingJavascriptExecutor(objectRep.getProductLinkInPLPByName(productname));
	}

}
