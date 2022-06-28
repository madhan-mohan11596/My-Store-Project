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

import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author ambul
 *
 */
public class SearchResultTest extends Baseclass{
	
	IndexPage indexpage;
    SearchResultPage searchresultPage;
	
	
	
    @Parameters("browserName")
    @BeforeMethod(groups= {"Sanity","Smoke","Regression"})
	public void setup(String browserName) {
		launchapp(browserName);
	}
	
	@Test(groups="Smoke")
	public void productAvailabilityTest() {
		
		Log.startTestCase("productAvailabilityTest");

		indexpage = new IndexPage();
		searchresultPage = new SearchResultPage();
		
		Log.info("enters the product name in the search box of index page");
		searchresultPage = indexpage.searchProduct(prop.getProperty("ProductName"));
        Log.info("validating  whether type of product is diplayed or not  ");

		boolean result = searchresultPage.ProductDisplayed();
		Assert.assertTrue(result);
		Log.info("search page with different type of same products opened");
		
        Log.endTestCase("productAvailabilityTest");

		
		
	}
	
	@AfterMethod(groups= {"Sanity","Smoke","Regression"})
	public void teardown() {
		getdriver().quit();
	}	

}
