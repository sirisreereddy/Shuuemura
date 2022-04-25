package com.loreal.automation.pages.Shuuemura;

import org.openqa.selenium.WebDriver;
import com.loreal.automation.base.BasePage;
import com.loreal.automation.utilities.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;

public class ShopRunnerPage extends BasePage{

	public ShopRunnerPage(WebDriver driver,ExtentTest test) {
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
	
	

}
