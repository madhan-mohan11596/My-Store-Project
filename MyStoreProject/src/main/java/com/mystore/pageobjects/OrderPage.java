/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

/**
 * @author ambul
 *
 */
public class OrderPage extends Baseclass
{
    Action action = new Action();
;	
	WebDriverWait wait = new WebDriverWait(getdriver(),Duration.ofSeconds(20));

	
	@FindBy(xpath = "//td[@class='cart_unit']/child::span/child::span[1]")
	private WebElement unitPrice;
	
	@FindBy(xpath="//td[@class='cart_quantity text-center']/child::input[2]")
	private WebElement Quantity;
	
	@FindBy(id = "total_shipping")
	private WebElement Shippingcharge;
	
	@FindBy(id = "total_tax")
	private WebElement tax;
	
	@FindBy(id = "total_price")
	private WebElement Totalprice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement ProceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public double getUnitPrice() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='cart_unit']/child::span/child::span[1]")));

		String unitprice1 = unitPrice.getText();
		String unitprice2 = unitprice1.replaceAll("[^a-zA-Z0-9]", "");
		double  finalunitprice = Double.parseDouble(unitprice2);
		return finalunitprice/100;
	}
	public double getQuantity() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='cart_quantity text-center']/child::input[2]")));

		String Quantity1 = Quantity.getAttribute("value");
		double  finalQuantity = Double.parseDouble(Quantity1);
		return finalQuantity;
	}
	
	
	
	public double getshippingcharge() 
	{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-ok']")));

		String shippingcharge1 = Shippingcharge.getText();
		String shippingcharge2 = shippingcharge1.replaceAll("[^a-zA-Z0-9]", "");
		double  finalShippingcharge = Double.parseDouble(shippingcharge2);
		return finalShippingcharge/100;
	}
	
	public double gettotal_tax() 
	{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-ok']")));

		String total_tax1 = tax.getText();
		String total_tax2 = total_tax1.replaceAll("[^a-zA-Z0-9]", "");
		double  finaltotal_tax = Double.parseDouble(total_tax2);
		return finaltotal_tax/100;
	}
	public double getTotalPrice() 
	{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-ok']")));

		String Totalprice1 = Totalprice.getText();
		String Totalprice2 = Totalprice1.replaceAll("[^a-zA-Z0-9]", "");
		double  finalTotalprice = Double.parseDouble(Totalprice2);
		return finalTotalprice/100;
	}
	
	public AddressPage clickonProceedToCheckOut() 
	{
		ProceedToCheckOut.click();
		return new AddressPage();
			
	}
	public LoginPage clickonProceedToCheckout()
	{
		ProceedToCheckOut.click();
		return new LoginPage();
	}	
}
