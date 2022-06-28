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
public class AddressPage extends Baseclass {
	
	@FindBy(name="processAddress")
	private WebElement ProceedToCheckOut;
	
	public AddressPage() 
	{
		PageFactory.initElements(getdriver(), this);
	}
	
	public ShippingPage clickonProceedToCheckout() {
		ProceedToCheckOut.click();
		return new ShippingPage();
	}

}
