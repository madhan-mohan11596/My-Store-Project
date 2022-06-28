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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author ambul
 *
 */
public class HomepageTest extends Baseclass{
	

	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	
	@Parameters("browserName")
	@BeforeMethod(groups= {"Sanity","Smoke","Regression"})
	public void setup(String browserName) {
		launchapp(browserName);
	}
	@Test(groups="Smoke")
	public void WishlistTest() {
		
		Log.startTestCase("WishlistTest");

		indexpage = new IndexPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		
		Log.info("clicks on sign of index page");
		loginpage = indexpage.clickonsignin();
		Log.info("login page opened");
		
        Log.info("enters the username and password ");
        Log.info("clicks on login button ");
		homepage = loginpage.loginFrame(prop.getProperty("username"),prop.getProperty("password"));
		Log.info("Home page opened");

		Log.info("validating the whether MyWhishLists displayed or not ");
	    boolean result = homepage.validateMyWishListsPage();
		Assert.assertTrue(result);
		Log.info("MyWhishLists displayed sucessfully ");
		
        Log.endTestCase("WishlistTest");


	}
	@Test(groups="Smoke")
	public void OrderHistoryTest() {
		
		Log.startTestCase("OrderHistoryTest");

		indexpage = new IndexPage();
		loginpage = new LoginPage();
		homepage = new HomePage();
		
		Log.info("clicks on signin of index page");
		loginpage = indexpage.clickonsignin();
		Log.info("login page opened");
		
        Log.info("enters the username and password ");
        Log.info("clicks on login button ");
		homepage = loginpage.loginFrame(prop.getProperty("username"),prop.getProperty("password"));
		Log.info("Home page opened");

		Log.info("validating the whether OrderHistory displayed or not ");
	    boolean result = homepage.validateMyWishListsPage();
		Assert.assertTrue(result);
		Log.info("OrderHistory displayed sucessfully ");
		
        Log.endTestCase("OrderHistoryTest");

		
		
	}
	@AfterMethod(groups= {"Sanity","Smoke","Regression"})
	public void teardown() {
		getdriver().quit();
	}

}
