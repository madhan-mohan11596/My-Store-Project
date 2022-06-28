package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

public class IndexPage extends Baseclass {
	Action action = new Action();
	
	@FindBy(xpath = "//a[@class  = 'login']")
	private WebElement SigninBtn;
	
	@FindBy(id = "search_query_top")
	private WebElement SearchBox;
	
	@FindBy(xpath = "//img[@class = 'logo img-responsive']")
	private WebElement MyStoreLogo;
	
	@FindBy(name = "submit_search")
	private WebElement SearchBtn;
	
	
	
	public IndexPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public LoginPage clickonsignin() {
		action.fluentWait(getdriver(), SigninBtn, 10);
		SigninBtn.click();
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return MyStoreLogo.isDisplayed();
	}
	
	public String GetTitle() {
	    String MyStoreTitle =	getdriver().getTitle();
	    return MyStoreTitle;
	}
	
	public SearchResultPage searchProduct(String ProductName) {
		
		SearchBox.sendKeys(ProductName);
		action.fluentWait(getdriver(),SearchBtn , 10);

		SearchBtn.click();
		return new SearchResultPage();
	}
	

}
