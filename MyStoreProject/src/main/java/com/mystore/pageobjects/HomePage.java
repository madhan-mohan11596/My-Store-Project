/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

/**
 * @author ambul
 *
 */
public class HomePage extends Baseclass{
	Action action = new Action();
	
	@FindBy(xpath = "//a[@title = 'My wishlists']")
	private WebElement MyWishLists;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement OrderHistory;
	
	
	public HomePage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean validateMyWishListsPage() {
		
		return MyWishLists.isDisplayed();
	}
	
	public boolean ValidateOrderHistory() {
		
		return OrderHistory.isDisplayed();
	}
	
	public String getcurUrl() {
		String currenturl = getdriver().getCurrentUrl();
		return currenturl;
	}

}
