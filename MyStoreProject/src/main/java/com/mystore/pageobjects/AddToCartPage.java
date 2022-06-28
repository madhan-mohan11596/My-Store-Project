/**
 * 
 */
package com.mystore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;

/**
 * @author ambul
 *
 */
public class AddToCartPage extends Baseclass {
    
	WebDriverWait wait = new WebDriverWait(getdriver(),Duration.ofSeconds(10));
	Action action = new Action();





	@FindBy(name = "qty")
	private WebElement quantity;
	
	@FindBy(name = "group_1")
	private WebElement size;
	
	@FindBy(name = "Green")
	private WebElement color;
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	private WebElement AddToCart;
	
	@FindBy(xpath="//i[@class='icon-ok']")
	private WebElement AddToCartSucess;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement ProceedToCheckout;
	
	
	public AddToCartPage() {
		PageFactory.initElements(getdriver(), this);
	}
	
	public boolean ValidateAddToCart() {
		return AddToCart.isDisplayed();
	}
	
	public void enterQuantity(String qnty) {
		quantity.clear();
		quantity.sendKeys(qnty);
	}
	
	public void selectSize(String sizes) {
		Select sizelist= new Select(size);
		sizelist.selectByVisibleText(sizes);
			
	}
	
	
	public void ClickOnAddToCart() {
		AddToCart.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-ok']")));
;

	
	}
	
	public boolean validateAddtocartSucees() {

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='icon-ok']")));

		return AddToCartSucess.isDisplayed();
	}
	public OrderPage ClickOnProceedToCheckout() {
		ProceedToCheckout.click();
		return new OrderPage();
	}
}
