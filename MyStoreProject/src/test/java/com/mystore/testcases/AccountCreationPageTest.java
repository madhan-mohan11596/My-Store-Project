package com.mystore.testcases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;

public class AccountCreationPageTest extends Baseclass {
	
	Action action = new Action();
	
	IndexPage indexpage;
    SearchResultPage searchresultPage;
	AddToCartPage addtocartpage;
	OrderPage orderpage;
	LoginPage loginpage;
	AccountCreationPage accountCreationPage;
	HomePage homePage;
	AddressPage addressPage;

	@Parameters("browserName")
	@BeforeMethod(groups= {"Sanity","Smoke","Regression"})
	public void setup(String browserName) {
		launchapp(browserName);
	}
	
	@Test(groups= "Sanity",dataProvider="newAcountDetailsData",dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String ,String>Hashmapvalue) throws InterruptedException {
		
		Log.startTestCase("createAccountTest");
		
		indexpage = new IndexPage();
		loginpage = new LoginPage();
		accountCreationPage = new AccountCreationPage();
		homePage = new HomePage();
		
		Log.info("clicks on sign in of index page");
		loginpage = indexpage.clickonsignin();
		Log.info("login page opened");
		
        Log.info(" enters the  email of new customer");
		accountCreationPage =loginpage.CreateAnAccount(Hashmapvalue.get("email"));
        Log.info(" accountCreationPage opened ");
        
		Log.info("validating the accountCreationPage ");
		boolean result = accountCreationPage.validateCreateAnAccount();
		Assert.assertTrue(result);
		Log.info("Succsssfully landed into account detils ");
		
		Log.info("enters all details of new customer ");
		homePage = accountCreationPage.CreateNewAccount(
				Hashmapvalue.get("customer firstname"),
        		Hashmapvalue.get("customer lastname"),
        		Hashmapvalue.get("password"),
        		
        		Hashmapvalue.get("address"),
        		Hashmapvalue.get("address2"),
        		Hashmapvalue.get("state"),
        		Hashmapvalue.get("alias"));
        Log.info(" homePage opened after successful registration of new customer");
        
        Log.endTestCase("createAccountTest");


	}
	
	@Test(groups= "Sanity",dataProvider="DirectnewAcountDetailsData",dataProviderClass = DataProviders.class)
	public void createAccountAfterAddingToCartTest(HashMap<String ,String>Hashmapvalue) throws InterruptedException {
		
		Log.startTestCase("createAccountAfterAddingToCartTest");
		
		indexpage = new IndexPage();
		searchresultPage = new SearchResultPage();
		addtocartpage = new AddToCartPage();
		orderpage  = new OrderPage();
		loginpage = new LoginPage();
		accountCreationPage = new AccountCreationPage();
		addressPage = new AddressPage();
		
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
        
        Log.info("validating the accountCreationPage ");
		boolean result = accountCreationPage.validateCreateAnAccount();
		Assert.assertTrue(result);
		Log.info("Succsssfully landed into account detils ");
		
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
        
        Log.endTestCase("createAccountAfterAddingToCartTest");

	}
	
	@AfterMethod(groups= {"Sanity","Smoke","Regression"})
	public void teardown() {
		getdriver().quit();
	}

}


