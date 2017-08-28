/**
 * Payment Details - follows Page factory style of Pabe Object Model
 */
package com.lufthansa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the objects and methods to access the Payment Details UI page objects
 * @author kiran
 * 
 */
public class PaymentDetails {
	WebDriver driver;
	/**
	 * 
	 */
	public PaymentDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1[contains(.,'Your Payment Details')]")
	WebElement headingPaymentDetails;
	
	public WebElement headingPaymentDetails(){
		return headingPaymentDetails;
	}
	

}
