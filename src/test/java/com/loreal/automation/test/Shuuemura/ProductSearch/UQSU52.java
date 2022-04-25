/**Verify Search Result Page
 * @author SURYA
 *
 */
package com.loreal.automation.test.Shuuemura.ProductSearch;



import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import com.loreal.automation.base.BaseTest;

import com.loreal.automation.pages.Shuuemura.HomePage;
import com.loreal.automation.pages.Shuuemura.SearchPage;
import com.loreal.automation.utilities.EnvironmentTestData;
import com.relevantcodes.extentreports.LogStatus;


public class UQSU52 extends BaseTest
{
public UQSU52() 
{
	super("UQSU52");
}

public UQSU52(String testName, String browser) {

	super(testName, browser);
}


@BeforeTest
public void before() {

	test = TestReportGenerator(report, this.getClass().getSimpleName(),"Verify Search Result Page");
}
@Test
public void test() throws Exception {

	if(channel.equalsIgnoreCase("Desktop")){

		HomePage homePageObject = new HomePage(driver,test);	
	    SearchPage psObject=new SearchPage(driver,test);
	    EnvironmentTestData objData = new EnvironmentTestData();
		objData.setTestData();
		test.log(LogStatus.PASS,"TEST CASE NAME: PRODUCT RESEARCH");
		Reporter.log("TEST CASE NAME: PRODUCT RESEARCH");

		homePageObject.launchBasePage();
		homePageObject.clickSearchBtn(objData.keyword);
		psObject.verifySearchResultPage(objData.keyword);
		homePageObject=null;
		psObject=null;

		System.gc();
	
	}else 
		if(channel.equalsIgnoreCase("Mobile")){

			HomePage homePageObject = new HomePage(driver,test);	
		    SearchPage psObject=new SearchPage(driver,test);
		    EnvironmentTestData objData = new EnvironmentTestData();
			objData.setTestData();
			test.log(LogStatus.PASS,"TEST CASE NAME: PRODUCT RESEARCH");
			Reporter.log("TEST CASE NAME: PRODUCT RESEARCH");

			homePageObject.launchBasePageMobile();
			homePageObject.clickSearchBtnMobile(objData.keyword);
			psObject.verifySearchResultPage(objData.keyword);
			homePageObject=null;
			psObject=null;

			System.gc();
		}
}
}