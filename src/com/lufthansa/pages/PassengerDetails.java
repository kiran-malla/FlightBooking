/**
 * Passenger Details - - follows Page factory style of Pabe Object Model
 */
package com.lufthansa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the objects and methods to access the Passenger Details UI page objects
 * @author kiran
 */
public class PassengerDetails {
	WebDriver driver;
	/**
	 * 
	 */
	public PassengerDetails(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='DATA_PASSENGERS_ADT_TITLE_0']/div/div/div[1]")
	WebElement titlePassenger1;
	
	public WebElement titlePassenger1(){
		return titlePassenger1;
	}
	
	@FindBy(xpath="//*[@id='PASSENGERS_ADT_TITLE_0-list-item1']/div/div")
	WebElement titleMr1;
	
	public WebElement titleMr1(){
		return titleMr1;
	}
	
	@FindBy(xpath="//*[@id='DATA_PASSENGERS_ADT_TITLE_1']/div/div/div[1]")
	WebElement titlePassenger2;
	
	public WebElement titlePassenger2(){
		return titlePassenger2;
	}
	
	@FindBy(xpath="//*[@id='PASSENGERS_ADT_TITLE_1-list-item1']/div/div")
	WebElement titleMr2;
	
	public WebElement titleMr2(){
		return titleMr2;
	}
	
	@FindBy(xpath="//input[@id='PASSENGERS_ADT_FIRST_NAME_0']")
	WebElement firstname1;
	
	public WebElement Firstname1(){
		return firstname1;
	}
	
	@FindBy(xpath="//input[@id='PASSENGERS_ADT_LAST_NAME_0']")
	WebElement lastname1;
	
	public WebElement Lastname1(){
		return lastname1;
	}
	
	@FindBy(xpath="//input[@id='CONTACT_DETAILS_PHONE_PHONE_AREA_0']")
	WebElement phoneArea;
	
	public WebElement phoneArea(){
		return phoneArea;
	}
	
	@FindBy(xpath="//input[@id='CONTACT_DETAILS_PHONE_PHONE_NUMBER_0']")
	WebElement phoneNumber;
	
	public WebElement phoneNumber(){
		return phoneNumber;
	}
	
	
	@FindBy(xpath="//input[@id='CONTACT_DETAILS_EMAIL_0']")
	WebElement email;
	
	public WebElement email(){
		return email;
	}
	
	
	@FindBy(xpath="//button[@id='TOOLBAR_CONTINUE_0']")
	WebElement continueButton;
	
	public WebElement continueButton(){
		return continueButton;
	}
}
