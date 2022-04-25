/**VERIFYING THE CONTENTS IN HOME PAGE
 * @author SURYA
 *
 */

package com.loreal.automation.test.Shuuemura.HomePage;


import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.loreal.automation.base.BaseTest;
import com.loreal.automation.pages.Shuuemura.HomePage;
import com.loreal.automation.utilities.EnvironmentTestData;
import com.relevantcodes.extentreports.LogStatus;


public class UQSU73 extends BaseTest {
	public UQSU73() 
	{
		super("UQSU73");
	}

	public UQSU73(String testName, String browser) {

		super(testName, browser);
	}

	
	@BeforeTest
	public void before() {

		test = TestReportGenerator(report, this.getClass().getSimpleName(),"");
	}
	@Test
	public void test() throws Exception {

		if(channel.equalsIgnoreCase("Desktop")){

			HomePage homePageObject = new HomePage(driver,test);
			/*EnvironmentTestData objData = new EnvironmentTestData();
			objData.setTestData();*/
			test.log(LogStatus.PASS,"TEST CASE NAME: VERIFY HOMEPAGE CONTENT");
			Reporter.log("TEST CASE NAME: VERIFY HOMEPAGE CONTENT");
			homePageObject.launchBasePage();
			homePageObject.verifyHomePageContent();
			homePageObject=null;
			System.gc();
		}
		else if(channel.equalsIgnoreCase("Mobile"))
		{	
			HomePage homePageObject = new HomePage(driver,test);
			test.log(LogStatus.PASS,"TEST CASE NAME: VERIFY HOMEPAGE CONTENT");
			Reporter.log("TEST CASE NAME: VERIFY HOMEPAGE CONTENT");
			homePageObject.launchBasePageMobile();
			homePageObject.verifyHomePageContentMobile();
			homePageObject=null;
			System.gc();
		}

	}
}

