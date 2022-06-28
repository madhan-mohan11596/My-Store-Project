/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

/**
 * @author ambul
 *
 */
public class IndexPageTest extends Baseclass{
	

	IndexPage indexpage;
	
	
	@Parameters("browserName")
	@BeforeMethod(groups= {"Sanity","Smoke","Regression"})
	public void setup(String browserName) {
		launchapp(browserName);
	}
	
	@Test(groups="Smoke")
	public void verifylogo() {
		
		Log.startTestCase("verifylogo");

		indexpage = new IndexPage();
		
		Log.info("Index page opened");

		Log.info("validating the whether MyStoreLogo displayed or not ");
		boolean result = indexpage.validateLogo();
		Assert.assertTrue(result);
		Log.info("MyStoreLogo displayed ");

		
        Log.endTestCase("verifylogo");

		
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() {
		
		Log.startTestCase("verifyTitle");

		indexpage = new IndexPage();
		
		Log.info("Index page opened");

		Log.info("validating the whether Title displayed correct or wrong ");
		String actualTitle = indexpage.GetTitle();
		Assert.assertEquals(actualTitle, "My Store");
		Log.info("Title displayed correctly");

		
        Log.endTestCase("verifyTitle");

	}
	
	@AfterMethod(groups= {"Sanity","Smoke","Regression"})
	public void teardown() {
		getdriver().quit();
	}
	

}
