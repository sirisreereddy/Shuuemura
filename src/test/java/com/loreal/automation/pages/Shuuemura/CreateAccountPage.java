package com.loreal.automation.pages.Shuuemura;

import org.openqa.selenium.WebDriver;

import com.loreal.automation.base.BasePage;
import com.loreal.automation.utilities.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;

public class CreateAccountPage extends BasePage{

	public CreateAccountPage(WebDriver driver,ExtentTest test) {
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


}
