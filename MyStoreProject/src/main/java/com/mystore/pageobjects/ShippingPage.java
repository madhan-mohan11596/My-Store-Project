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
public class ShippingPage extends Baseclass{
	
	@FindBy(name="processCarrier")
	private WebElement ProceedToCheckOut;
	
	@FindBy(id="cgv")
	private WebElement checkbox;
	
	public ShippingPage() 
	{
		PageFactory.initElements(getdriver(), this);
	}
	
	public void clickonCheckBox() {
		checkbox.click();
		
	}
	public PaymentPage clickonProceedToCheckout() {
		ProceedToCheckOut.click();
		return new PaymentPage();
	}	

}
