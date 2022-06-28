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
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

/**
 * @author ambul
 *
 */
public class EndtoEndTest extends Baseclass {
	
	IndexPage indexpage;
    SearchResultPage searchresultPage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginpage;
	AccountCreationPage accountCreationPage;
	HomePage homePage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
	@Parameters("browserName")
	@BeforeMethod(groups= {"Sanity","Smoke","Regression"})
	public void setup(String browserName) {
		launchapp(browserName);
	}
	
	
	@Test(groups="Regression",dataProvider="DirectnewAcountDetailsData",dataProviderClass = DataProviders.class)
	public void EndToEndTestForNewCustomers(HashMap<String ,String>Hashmapvalue) throws InterruptedException {
		
		Log.startTestCase("EndToEndTestForNewCustomers");

		indexpage = new IndexPage();
		searchresultPage = new SearchResultPage();
		addtocartpage = new AddToCartPage();
		orderpage  = new OrderPage();
		loginpage = new LoginPage();
		accountCreationPage = new AccountCreationPage();
		homePage = new HomePage();
		addressPage = new AddressPage();
		shippingPage = new ShippingPage();
		paymentPage = new PaymentPage();
		orderSummaryPage = new OrderSummaryPage();
		orderConfirmationPage = new OrderConfirmationPage();
		
		
        
        Log.info("enters the product name in the search box of index page");
		searchresultPage = indexpage.searchProduct(Hashmapvalue.get("Product"));
		Log.info("search page with different type of same products opened");
		
		Log.info("selects the product needed");
		addtocartpage = searchresultPage.productSelection();
		Log.info("add to cart page opened and product selected");
		
		Log.info("add to cart page opened and enters quantity");
	    addtocartpage.enterQuantity(Hashmapvalue.get("Quantity"));;
	    Log.info("quantity entered");
	    
	    Log.info("enters size");
        addtocartpage.selectSize(Hashmapvalue.get("Size"));;
        Log.info("size entered");
        
        Log.info("clicks on add to cart");
        addtocartpage.ClickOnAddToCart();
        Log.info("added to cart");
        
        Log.info("clicks on proceed to checkout button");
        orderpage = addtocartpage.ClickOnProceedToCheckout();
        Log.info("order page opened ");
        
        Log.info("clicks on proceed to checkout button");
        loginpage = orderpage.clickonProceedToCheckout();
        Log.info("login page opened");
        
        Log.info(" enters the  email of new customer");
		accountCreationPage =loginpage.CreateAnAccount(Hashmapvalue.get("email"));
        Log.info(" accountCreationPage opened ");
        
		Log.info("enters all details of new customer ");
        addressPage = accountCreationPage.CreateNewAccountAfterAddToCart(
        		Hashmapvalue.get("customer firstname"),
        		Hashmapvalue.get("customer lastname"),
        		Hashmapvalue.get("password"),
        		
        		Hashmapvalue.get("address"),
        		Hashmapvalue.get("address2"),
        		Hashmapvalue.get("state"),
        		Hashmapvalue.get("alias"));
        Log.info(" addressPage opened after successful registration of new customer");
        
        Log.info("clicks on proceed to checkout button");
        shippingPage = addressPage.clickonProceedToCheckout();
        Log.info("shipping page opened");

        Log.info("clicks on Check box of shippment page after verifying all the details");
        shippingPage.clickonCheckBox();
        
        Log.info("clicks on proceed to checkout button");
        paymentPage = shippingPage.clickonProceedToCheckout();
        Log.info("payment page opened");
        
        Log.info("clicks on pay by wire method");
        orderSummaryPage = paymentPage.clickonwireMethod();
        Log.info("orderSummary page opened");

        Log.info("clicks on Confirm My Order ");
        orderConfirmationPage = orderSummaryPage.clickonConfirmMyOrder();
        Log.info("orderConfirmation page opened");

		Log.info("validating finally whether all the details correct or not in the order confirmation page");
        boolean wireConfirmationMsg = orderConfirmationPage.confirmDetails();
        Assert.assertTrue(wireConfirmationMsg);
        Log.info("Order confirmed ");
        
        Log.endTestCase("EndToEndTestForNewCustomers");

   
	}
	
	@Test(groups="Regression",dataProvider="DirectnewAcountDetailsData",dataProviderClass = DataProviders.class)

	public void EndToEndTestForOldCustomers(HashMap<String ,String>Hashmapvalue) throws InterruptedException {
		
		Log.startTestCase("EndToEndTestForOldCustomers");

		indexpage = new IndexPage();
		searchresultPage = new SearchResultPage();
		addtocartpage = new AddToCartPage();
		orderpage  = new OrderPage();
		loginpage = new LoginPage();
		accountCreationPage = new AccountCreationPage();
		homePage = new HomePage();
		addressPage = new AddressPage();
		shippingPage = new ShippingPage();
		paymentPage = new PaymentPage();
		orderSummaryPage = new OrderSummaryPage();
		orderConfirmationPage = new OrderConfirmationPage();
		
		
        Log.info("enters the product name in the search box of index page");
		searchresultPage = indexpage.searchProduct(Hashmapvalue.get("Product"));
		Log.info("search page with different type of same products opened");
		
		Log.info("selects the product needed");
		addtocartpage = searchresultPage.productSelection();
		Log.info("add to cart page opened and product selected");
		
		Log.info("add to cart page opened and enters quantity");
	    addtocartpage.enterQuantity(Hashmapvalue.get("Quantity"));;
	    Log.info("quantity entered");
	    
	    Log.info("enters size");
        addtocartpage.selectSize(Hashmapvalue.get("Size"));;
        Log.info("size entered");
        
        Log.info("clicks on add to cart");
        addtocartpage.ClickOnAddToCart();
        Log.info("added to cart");
        
        Log.info("clicks on proceed to checkout button");
        orderpage = addtocartpage.ClickOnProceedToCheckout();
        Log.info("order page opened ");
        
        Log.info("clicks on proceed to checkout button");
        loginpage = orderpage.clickonProceedToCheckout();
        Log.info("login page opened");
        
        Log.info("enters the username and password ");
        Log.info("clicks on login button ");
        addressPage = loginpage.loginFrame1(Hashmapvalue.get("email"),Hashmapvalue.get("password"));
		Log.info(" sucessfully logged in and navigated to address page");
        
        Log.info("clicks on proceed to checkout button");
        shippingPage = addressPage.clickonProceedToCheckout();
        Log.info("shipping page opened");

        Log.info("clicks on Check box of shippment page after verifying all the details");
        shippingPage.clickonCheckBox();
        
        Log.info("clicks on proceed to checkout button");
        paymentPage = shippingPage.clickonProceedToCheckout();
        Log.info("payment page opened");
        
        Log.info("clicks on pay by wire method");
        orderSummaryPage = paymentPage.clickonwireMethod();
        Log.info("orderSummary page opened");

        Log.info("clicks on Confirm My Order ");
        orderConfirmationPage = orderSummaryPage.clickonConfirmMyOrder();
        Log.info("orderConfirmation page opened");

		Log.info("validating finally whether all the details correct or not in the order confirmation page");
        boolean wireConfirmationMsg = orderConfirmationPage.confirmDetails();
        Assert.assertTrue(wireConfirmationMsg);
        Log.info("Order confirmed ");
        
        Log.endTestCase("EndToEndTestForOldCustomers");
        
	}
	
	@AfterMethod(groups= {"Sanity","Smoke","Regression"})
	public void teardown() {
		getdriver().quit();
	}


}
