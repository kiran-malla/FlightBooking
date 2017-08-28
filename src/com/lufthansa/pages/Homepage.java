/**
 * Homepage - follows Page factory style of Pabe Object Model
 * 
 */
package com.lufthansa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lufthansa.utils.CommonMethods;

/**
 * This class has all the objects and methods to access the homepage UI page objects
 * @author kiran
 *
 */
public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#flightmanagerFlightsFormOrigin")
	WebElement originCity;
	
	@FindBy(css="#flightmanagerFlightsFormDestination")
	WebElement destinationCity;
	
	@FindBy(xpath="//input[@id='lhfaToggleRoundtrip']")
	WebElement oneway;
	
	@FindBy(css="#flightmanagerFlightsFormOutboundDateDisplay")
	WebElement calendar;
	
	/*Does not follow PageFactory as it cannot have variable name in xpath
	But still uses Page Object Model but in a different style*/
	//Compute current date + 2 days
	String sDate = CommonMethods.getDate(2);
	//select the right date in the current month out of the two months displayed in the calendar
	By bookingDate = By.xpath("(//button[contains(., '"+sDate+"')])[1]");
	
	@FindBy(css="#flightmanagerFlightsFormTraveldetailsBtn")
	WebElement passengerDetails;
	
	@FindBy(css="#traveldetailsCabin")
	WebElement travelClass;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement submit;
	
	@FindBy(xpath="//button[contains(.,'Search flights')]")
	WebElement searchFlights;
	
	@FindBy(xpath="//td[@data-ffnumber='2']")
	List<WebElement> priceList;
	
	@FindBy(xpath="//*[@id='flightmanagerFlightsFormAirportAtlasOrigin']")
	WebElement airportAtlas;
	
	String selectXpath="//input[@value='Select']";
	
		public WebElement airportAtlas(){
		return airportAtlas;
	}
	
	public String selectXpath(){
		return selectXpath;
	}
	public WebElement originCity(){
		return originCity;
	}
	
	public WebElement destinationCity(){
		return destinationCity;
	}
	
	public WebElement oneway(){
		return oneway;
	}
	
	public WebElement calendar(){
		return calendar;
	}
	
	public WebElement bookingDate(){
		System.out.println("Booking date is 2 days from today: "+ sDate);
		return driver.findElement(bookingDate);
	}
	
	public WebElement passengerDetails(){
		return passengerDetails;
	}
	
	public WebElement travelClass(){
		return travelClass;
	}
	
	public WebElement submit(){
		return submit;
	}
	
	public WebElement searchFlights(){
		return searchFlights;
	}
	
}
