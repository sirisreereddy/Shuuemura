/**This test case contains all methods related to PLP
 * @author SURYA
 *
 */
package com.loreal.automation.pages.Shuuemura;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.loreal.automation.base.BasePage;
import com.loreal.automation.utilities.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ProductLandingPage extends BasePage {

	public ProductLandingPage(WebDriver driver,ExtentTest test) {
		super(driver,test);
	}

	ObjectRepository objectRep = new ObjectRepository();

	@Override
	public boolean hasPageLoaded() {
		
		return false;
	}

	@Override
	public String getPageUrl() {
		
		return null;
	}

	ObjectRepository objRep = new ObjectRepository();
	
	public void hoverOnProductInPLP(String product)
	{
		mouseOver(By.xpath("//a[@title='gentle radiance cleansing oil shampoo' and @class='product_name ']"));
		mouseOver(objectRep.getProductImageByProductName(product));
		test.log(LogStatus.PASS,"Mouse hover is performed on product "+product);
		Reporter.log("Mouse hover is performed on product "+product);
	}
	
	public void clickQuickViewButtonForProduct(String product) throws InterruptedException
	{
		//clickUsingJavascriptExecutor(objectRep.getQuickViewButtonByProductName(product));
		clickUsingJavascriptExecutor(By.xpath("//a[@title='gentle radiance cleansing oil shampoo' and @class='quickviewbutton']"));
		test.log(LogStatus.PASS,"Quick view button for "+product+" is clicked"); 
		Reporter.log("Quick view button for "+product+" is clicked");
	}
	
	public void verifyBreadCrumb(String menu) throws Exception
	{
		objectRep.loadPLPObjects();
		String breadcrumb = getText(objectRep.breadcrumbCurrentPage).trim();
		System.out.println(breadcrumb);
		if(breadcrumb.contains(menu.toLowerCase())) {
			test.log(LogStatus.PASS,"Breadcrumb is displayed correctly"); 
			Reporter.log("Breadcrumb is displayed correctly");
		}
		else
			throw new Exception("Breadcrumb is not displayed properly");
	}
	
	public void verifyPLPPage(String menu) throws Exception
	{
		objectRep.loadPLPObjects();
		isElementVisible(objectRep.getPLPBanner());
		test.log(LogStatus.PASS,"Appropriate banner for "+menu+" is displayed");
		Reporter.log("Appropriate banner for "+menu+" is displayed");
		List<WebElement> productList = driver.findElements(objectRep.productThumbnailList);
		int listSize = productList.size();
		if(listSize>0) {
			test.log(LogStatus.PASS,"products list is displayed in selected menu");
			Reporter.log("products list is displayed in selected menu");
		}
		else
			throw new Exception("No products displayed");
	}
	
	public void verifyPLP(String menu)
	{
		objectRep.loadPLPObjects();
		isElementVisible(objectRep.getproductTypeFilterinPLP());
		test.log(LogStatus.PASS,"Product filter for :" + menu + " is Displayed"); 
		Reporter.log("Product filter for :" + menu + " is Displayed");
		isElementVisible(objectRep.getavailableSizesFilterinPLP());
		test.log(LogStatus.PASS,"Size filter for :" + menu + " is Displayed");
		Reporter.log("Size filter for :" + menu + " is Displayed");
		isElementVisible(objectRep.getpriceFilterinPLP());
		test.log(LogStatus.PASS,"Price filter for :" + menu + " is Displayed");
		Reporter.log("Price filter for :" + menu + " is Displayed");

		
	}
	
	public void clickProductInPLP(String product)
	
	{
		
		clickUsingJavascriptExecutor(objectRep.getProductLinkInPLPByName(product));
		test.log(LogStatus.PASS,product+" is clicked");
		Reporter.log(product+" is clicked");
	}
	public void selectSortOption(By locator) throws InterruptedException {
		objectRep.loadPLPObjects();
		try { 
			isElementVisible(By.xpath("//button[@title='close']"));
			clickUsingJavascriptExecutor(By.xpath("//button[@title='close']"));
		}
		catch(Exception e) {
			Reporter.log("No Pop up");
			test.log(LogStatus.INFO, "No Pop up");
		}
		clickUsingJavascriptExecutor(objectRep.sortBy);
		Thread.sleep(15000);
		List<WebElement> options = driver.findElements(locator);
		for (WebElement option : options) {
			System.out.println(option.getText().trim());
			Thread.sleep(1000);
			if (option.getAttribute("aria-label").trim().contains("Price")) {
				option.click();
				Reporter.log("Price(High To Low) is selected");
				test.log(LogStatus.PASS, "Price(High To Low) is selected");
				break;
			}
		}

	}
	

	public void SortByFunctionality() throws Exception {
		objectRep.loadPLPObjects();
		selectSortOption(objectRep.sortByDropDown);
		Thread.sleep(10000);
		ArrayList<String> list = new ArrayList<String>();

		List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'price b-price')]//p"));

		for (WebElement priceOptions : options) {
			list.add((priceOptions.getText().trim().replace('$','0').replace(' ','0').replaceFirst("^0+(?!$)","")));
		}
		System.out.println(list);
	if (list.size() >= 2) {
			double priceOfSecondSortedProduct = Double.parseDouble(list.get(0));
			double priceOfThirdSortedProduct = Double.parseDouble(list.get(1));
			Reporter.log("Price of second sorted product:" + priceOfSecondSortedProduct);
			test.log(LogStatus.PASS, "Price of second sorted product:" + priceOfSecondSortedProduct);
			Reporter.log("Price of third sorted product:" + priceOfThirdSortedProduct);
			test.log(LogStatus.PASS, "Price of third sorted product:" + priceOfThirdSortedProduct);
          	if (priceOfSecondSortedProduct >= priceOfThirdSortedProduct) {
				Reporter.log("Products sorted according to Price high to low option");
          	test.log(LogStatus.PASS, "Products sorted according to Price high to low option");
          	}
			else
				throw new Exception("Products are not sorted accordingly");
		} 
	  else {
			Reporter.log("Only one product is available");
			test.log(LogStatus.PASS, "Only one product is available");
		}
	}

	
	
}
