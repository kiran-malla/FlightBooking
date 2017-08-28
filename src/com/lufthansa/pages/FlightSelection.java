/**
 * Flight selection page - follows Page factory style of Pabe Object Model
 * 
 */
package com.lufthansa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class has all the objects and methods to access the Flight Selection UI page objects
 * @author kiran
 *
 */
public class FlightSelection {
	WebDriver driver;
	public FlightSelection(WebDriver driver){	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(.,'Please choose your flights')]")
	WebElement chooseFlightsHeader;
	
	@FindBy(xpath="//input[@class='price']")
	List<WebElement> priceList;
	
	@FindBy(xpath=".//*[@id='DATA_FLIGHTS_FLIGHTS_SORTING_0']/div/div/div[1]")
	WebElement sortArrow;
	
	String sortByPricexPath = "html/body/ul/li[5]/div/div";
	String sortByPrice2xPath = "//*[@id='FLIGHTS_FLIGHTS_SORTING_0-list-item4']/div/div";
	
	String lowsetBaseFarexpath="//input[@id='flightRadio_0_0_WWWWC3RC0E']";
	
	@FindBy(xpath="//input[@id='flightRadio_0_0_WWWWC4FF0E']")
	WebElement lowsetFlexFare;
	
	@FindBy(xpath="//button[@id='CART_CONTINUE_0']")
	WebElement continueButton;
	
	public WebElement continueButton(){
		return continueButton;
	}
	
	public String lowsetBaseFarexpath(){
		return lowsetBaseFarexpath;
	}
	
	public WebElement lowsetFlexFare(){
		return lowsetFlexFare;
	}
	
	public String sortByPricexPath(){
		return sortByPricexPath;
	}
	
	public String sortByPrice2xPath(){
		return sortByPrice2xPath;
	}

	public WebElement sortArrow(){
		return sortArrow;
	}

	public List<WebElement> priceList(){
		return priceList;
	}
	
	public WebElement chooseFlightsHeader(){
		return chooseFlightsHeader;
	}
}
