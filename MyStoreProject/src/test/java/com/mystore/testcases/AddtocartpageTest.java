/**
 * 
 */
package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author ambul
 *
 */
public class AddtocartpageTest extends Baseclass{
	IndexPage indexpage;
    SearchResultPage searchresultPage;
	AddToCartPage addtocartpage;
	
	@Parameters("browserName")
	@BeforeMethod(groups= {"Sanity","Smoke","Regression"})
	public void setup(String browserName) {
		launchapp(browserName);
	}
	
	@Test(groups={"Sanity","Regression"},dataProvider="DirectnewAcountDetailsData",dataProviderClass = DataProviders.class)
	public void AddtocartTest(HashMap< String,String>HashMapvalue) {
		
		Log.startTestCase("AddtocartTest");

		indexpage = new IndexPage();
		searchresultPage = new SearchResultPage();
		addtocartpage = new AddToCartPage();
		
		Log.info("enters the product name in the search box of index page");
		searchresultPage = indexpage.searchProduct(HashMapvalue.get("Product"));
		Log.info("search page with different type of same products opened");
		
		Log.info("selects the product needed");
		addtocartpage = searchresultPage.productSelection();
		
		Log.info("validating the whether add to cart page opened or not ");
		boolean result = addtocartpage.ValidateAddToCart();
	    Assert.assertTrue(result);
		Log.info("add to cart page opened with the selected product ");
		
        Log.endTestCase("AddtocartTest");


	}
	
	@Test(groups={"Sanity","Regression"},dataProvider="DirectnewAcountDetailsData",dataProviderClass = DataProviders.class)
	public void AddtocartSucessTest(HashMap< String,String>HashMapvalue) throws InterruptedException {
		
		Log.startTestCase("AddtocartSucessTest");

		indexpage = new IndexPage();
		searchresultPage = new SearchResultPage();
		addtocartpage = new AddToCartPage();
		
        Log.info("enters the product name in the search box of index page");
		searchresultPage = indexpage.searchProduct(HashMapvalue.get("Product"));
		Log.info("search page with different type of same products opened");
		
		Log.info("selects the product needed");
		addtocartpage = searchresultPage.productSelection();
		Log.info("add to cart page opened with the selected product");
		
		Log.info("enters quantity");
	    addtocartpage.enterQuantity(HashMapvalue.get("Quantity"));;
	    Log.info("quantity entered");
	    
	    Log.info("enters size");
        addtocartpage.selectSize(HashMapvalue.get("Size"));;
        Log.info("size entered");
        
        Log.info("clicks on add to cart");
        addtocartpage.ClickOnAddToCart();
        
        Log.info("validating the whether product added to cart or not ");
	    boolean result = addtocartpage.validateAddtocartSucees();
	    Assert.assertTrue(result);
	    Log.info("product sucessfully added to cart");
	    
        Log.endTestCase("AddtocartSucessTest");

	    
	}
	
	@AfterMethod(groups= {"Sanity","Smoke","Regression"})
	public void teardown() {
		getdriver().quit();
	}

}
