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
public class OrderConfirmationPage extends Baseclass {
	
	@FindBy(xpath="//div[@class='box']")
	private WebElement WireconfirmationMsg;
	
	public OrderConfirmationPage() 
	{
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean confirmDetails() {
		
		return WireconfirmationMsg.isDisplayed();
	}

}
