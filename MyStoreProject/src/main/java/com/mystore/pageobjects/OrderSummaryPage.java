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
public class OrderSummaryPage extends Baseclass {
	
	@FindBy(xpath="//span[text()='I confirm my order']")
	private WebElement confirmOrder;
	
	public OrderSummaryPage() 
	{
		PageFactory.initElements(getdriver(), this);
	}
	
	public OrderConfirmationPage clickonConfirmMyOrder() {
		confirmOrder.click();
		return new OrderConfirmationPage();
		
	}
	

}
