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
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author ambul
 *
 */
public class LoginPageTest extends Baseclass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	
	@Parameters("browserName")
	@BeforeMethod(groups= {"Sanity","Smoke","Regression"})
	public void setup(String browserName) {
		launchapp(browserName);
	}
	
	@Test(groups={"Smoke","Sanity"},dataProvider="Credentials",dataProviderClass = DataProviders.class)
	public void verifylogin(String uname,String pswd) throws InterruptedException {
		
		Log.startTestCase("verifylogin");

		indexpage = new IndexPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		
		Log.info("clicks on signin of index page");
		loginpage = indexpage.clickonsignin();
		Thread.sleep(3000);
		Log.info("login page opened");
		
        Log.info("enters the username and password ");
        Log.info("clicks on login button ");
//		homepage = loginpage.loginFrame(prop.getProperty("username"),prop.getProperty("password"));
		homepage = loginpage.loginFrame(uname,pswd);

		Log.info("validating the whether login is success or not ");
	    
		String actualUrl = homepage.getcurUrl();
		String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info(" sucessfully logged in and navigated to Home page");
		
        Log.endTestCase("verifylogin");


	}
	
	@AfterMethod(groups= {"Sanity","Smoke","Regression"})
	public void teardown() {
		getdriver().quit();
	}	

}
