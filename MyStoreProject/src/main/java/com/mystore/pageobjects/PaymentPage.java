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
public class PaymentPage extends Baseclass {
	
	@FindBy(xpath="//a[@title = 'Pay by bank wire']")
	private WebElement wireMethod;
	
	@FindBy(xpath="//a[@title = 'Pay by check.']")
	private WebElement Bycheck;
	
	public PaymentPage() 
	{
		PageFactory.initElements(getdriver(), this);
	}
	
	public OrderSummaryPage clickonwireMethod() {
		wireMethod.click();
		return new OrderSummaryPage();
		
	}
	public OrderSummaryPage clickonBycheck() {
		Bycheck.click();
		return new OrderSummaryPage();
		
	}

}
