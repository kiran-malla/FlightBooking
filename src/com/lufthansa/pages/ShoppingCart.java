/**
 * Shopping Cart page - follows Page factory style of Pabe Object Model
 * 
 */
package com.lufthansa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the objects and methods to access the Shopping Cart UI page objects
 * @author kiran
 * 
 */
public class ShoppingCart {
	WebDriver driver;
	
	public ShoppingCart(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[@id='CART_CONTINUE_0']")
	WebElement continueButton;
	
	public WebElement continueButton(){
		return continueButton;
	}
	
	@FindBy(xpath="//button[@id='IRC_FLIGHTS_IRC_FLIGHTS_DELETE_0']")
	WebElement deleteButton;
	
	public WebElement deleteButton(){
		return deleteButton;
	}
}
