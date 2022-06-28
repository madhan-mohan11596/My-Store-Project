/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

/**
 * @author ambul
 *
 */
public class SearchResultPage  extends Baseclass{
	
	@FindBy(xpath = "//p[starts-with(text(),'Printed chiffon')]/preceding-sibling::h5/child::a")
	private WebElement productinfo;
	
	public SearchResultPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean ProductDisplayed() {
		return productinfo.isDisplayed();
	}
	
	public AddToCartPage productSelection() {
		productinfo.click();
		return new AddToCartPage();
	}

}
