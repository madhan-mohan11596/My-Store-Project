
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

/**
 * @author ambul
 *
 */
public class AccountCreationPage extends Baseclass {
	
	Action action = new Action();

	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement CreateAnAccount;
	
	@FindBy(id="id_gender1")
	private WebElement idgender;
	
	@FindBy(id="customer_firstname")
	private WebElement customer_firstname;
	
	@FindBy(id="customer_lastname")
	private WebElement customer_lastname;
	
	@FindBy(id="passwd")
	private WebElement passwd;
	
	@FindBy(id="firstname")
	private WebElement firstname;
	
	@FindBy(id="lastname")
	private WebElement lastname;
	
	@FindBy(id="address1")
	private WebElement address;
	
	@FindBy(id="address2")
	private WebElement address2;
	
	@FindBy(xpath="//input[@id='city']")
	private WebElement city;
	
	@FindBy(xpath="//select[@id='id_state']")
	private WebElement state;
		
	@FindBy(id="postcode")
	private WebElement postcode;
	
	@FindBy(id="phone_mobile")
	private WebElement mobile_No;
	
	@FindBy(id="alias")
	private WebElement alias;
	
	@FindBy(id="submitAccount")
	private WebElement Register;
	
	
	
	
	
	
	public AccountCreationPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean validateCreateAnAccount() {
		 return CreateAnAccount.isDisplayed();
	}
	public HomePage CreateNewAccount(String CFn,String CLn,String Pwd,String Ads ,String Ads2 ,String St,String Als) throws InterruptedException {
	
	    idgender.click();
	    action.type(firstname, CFn);
		action.type(lastname, CLn);
		action.type(passwd, Pwd);
		//action.selectByValue(days, day);
		//action.selectByValue(months, month);
		//action.selectByValue(years, year);
		//action.type(companyName, comPany);
		action.type(address, Ads);
		action.type(address2, Ads2);

		action.type(city,prop.getProperty("city"));
		action.selectByVisibleText(St, state);
		action.type(postcode,prop.getProperty("postcode"));
		//action.selectByVisibleText(countryName, country);
		
		action.type(mobile_No,prop.getProperty("mobile_No"));
		Register.click();
		return new HomePage();
		
	  }
	  
	public AddressPage CreateNewAccountAfterAddToCart(String CFn,String CLn,String Pwd ,String Ads ,String Ads2 ,String St,String Als) throws InterruptedException {
		Thread.sleep(3000);
	    idgender.click();
		Thread.sleep(3000);

		customer_firstname.sendKeys(CFn);
		Thread.sleep(3000);

		customer_lastname.sendKeys(CLn);
		Thread.sleep(3000);

		passwd.sendKeys(Pwd);
		Thread.sleep(3000);

		
		address.sendKeys(Ads);
		Thread.sleep(3000);
		
		address2.sendKeys(Ads2);
		Thread.sleep(3000);

		city.sendKeys(prop.getProperty("city"));
		Thread.sleep(3000);

		state.click();
		Select statesDropdown = new  Select(state);
		Thread.sleep(3000);


		
		statesDropdown.selectByVisibleText(St);
		Thread.sleep(3000);

		postcode.sendKeys(prop.getProperty("postcode"));
		Thread.sleep(3000);

		mobile_No.sendKeys(prop.getProperty("mobile_No"));
		Thread.sleep(3000);

		alias.clear();
		Thread.sleep(3000);

		alias.sendKeys(Als);
		Thread.sleep(3000);

		Register.click();
		Thread.sleep(3000);

		return new AddressPage();
		
	  }
		 
	
}






