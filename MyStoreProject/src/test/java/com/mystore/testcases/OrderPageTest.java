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
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

/**
 * @author ambul
 *
 */
public class OrderPageTest extends Baseclass{

	
	IndexPage indexpage;
    SearchResultPage searchresultPage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	
	
	@Parameters("browserName")
	@BeforeMethod(groups= {"Sanity","Smoke","Regression"})
	public void setup(String browserName) {
		launchapp(browserName);
	}
	
	
	@Test(groups="Regression")
	public void priceTest() throws InterruptedException {
		
		Log.startTestCase("priceTest");

		indexpage = new IndexPage();
		searchresultPage = new SearchResultPage();
		addtocartpage = new AddToCartPage();
		orderpage  = new OrderPage();
		
		Log.info("enters the product name in the search box of index page");
		searchresultPage = indexpage.searchProduct(prop.getProperty("ProductName"));
		Log.info("search page with different type of same products opened");
		
		Log.info("selects the product needed");
		addtocartpage = searchresultPage.productSelection();
		Log.info("add to cart page opened with the selected product");
		
		Log.info("enters quantity");
	    addtocartpage.enterQuantity(prop.getProperty("quantity"));;
	    Log.info("quantity entered");
	    
	    Log.info("enters size");
        addtocartpage.selectSize(prop.getProperty("sizes"));;
        Log.info("size entered");
        
        Log.info("clicks on add to cart");
        addtocartpage.ClickOnAddToCart();
	    Log.info("product sucessfully added to cart");
       
	    Log.info("clicks on proceed to checkout");
        orderpage = addtocartpage.ClickOnProceedToCheckout();
	    Log.info("order page opened ");
	    
	    Log.info("gets unit price from order page ");
	    double Unitprice = orderpage.getUnitPrice();
	    
	    Log.info("gets quantity from order page ");
	    double quantity = orderpage.getQuantity();
	    
	    Log.info("gets shippingcharge price from order page ");
	    double shippingcharge = orderpage.getshippingcharge();
	   
	    Log.info("gets total_tax price from order page ");
	    double total_tax = orderpage.gettotal_tax();
	    
	    Log.info("gets Total price displayed from order page ");
	    double actualTotalprice = orderpage.getTotalPrice();
	    
	    Log.info("caluculates the expectedTotalprice ");
        double expectedTotalprice = ((Unitprice*quantity+shippingcharge+total_tax)*100.0/100.0) ;
        
        Log.info("validating the whether Totalprice displayed & expectedTotalprice is correct or wrong ");
        Assert.assertEquals(actualTotalprice, expectedTotalprice);	
        Log.info("Totalprice displayed & expectedTotalprice are same ");

	    
        Log.endTestCase("priceTest");
		
	    
        
       
        



        
        

        
        


	    
	}
	
	@AfterMethod(groups= {"Sanity","Smoke","Regression"})
	public void teardown() {
		getdriver().quit();
	}

}
