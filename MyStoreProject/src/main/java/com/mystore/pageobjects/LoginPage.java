package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class LoginPage  extends Baseclass{
	
	Action action = new Action();
	
	@FindBy(id= "email")
	private WebElement username;
	
	@FindBy(id = "passwd")
	private WebElement Password;
	
	@FindBy(name = "SubmitLogin")
	private WebElement LoginBtn;
	
	@FindBy(id = "email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(xpath = "//button[@name='SubmitCreate']")
	private WebElement CreateBtn;
	
	public LoginPage() {
		PageFactory.initElements(getdriver(), this);
	}
	public HomePage loginFrame(String uname, String pswd) {
		action.scrollByVisibilityOfElement(getdriver(), username);
		action.type(username, uname);
		action.type(Password, pswd);
		action.JSClick(getdriver(), LoginBtn);
		
		return new HomePage();
	}
	
	public AddressPage loginFrame1(String uname, String pswd) {
		action.scrollByVisibilityOfElement(getdriver(), username);
		action.type(username, uname);
		action.type(Password, pswd);
		action.JSClick(getdriver(), LoginBtn);
		
		return new AddressPage();
		
	}	
	public AccountCreationPage CreateAnAccount(String email) {
		action.scrollByVisibilityOfElement(getdriver(), emailForNewAccount);
		action.type(emailForNewAccount, email);
		action.JSClick(getdriver(), CreateBtn);
		
		return new AccountCreationPage();
	}
	

}
