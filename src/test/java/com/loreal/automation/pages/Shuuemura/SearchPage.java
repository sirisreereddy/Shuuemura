package com.loreal.automation.pages.Shuuemura;


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.loreal.automation.base.BasePage;
import com.loreal.automation.utilities.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;

public class SearchPage extends BasePage {

	public SearchPage(WebDriver driver,ExtentTest test) {
		super(driver,test);
	}

	String searchkeyword = "//*[@id='q']";

	@Override
	public boolean hasPageLoaded() {
		
		return false;
	}

	@Override
	public String getPageUrl() {
		return null;
	}

	ObjectRepository objRep = new ObjectRepository();
   
	public void verifySearchResultPage(String keyword) throws Exception
	{   
		
		isElementVisible(objRep.getSearchResult(keyword));
		Reporter.log("Keyword Results are found");
		if(getText(objRep.getSearchResult(keyword)).contains(keyword))
			Reporter.log("Search Results are displayed");
		else
			throw new Exception("Search Results are not  displayed");
	}

	

}
