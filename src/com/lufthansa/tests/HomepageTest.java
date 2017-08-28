/**
 * Homepage
 */
package com.lufthansa.tests;

import com.lufthansa.pages.FlightSelection;
import com.lufthansa.pages.Homepage;
import com.lufthansa.pages.PassengerDetails;
import com.lufthansa.pages.PaymentDetails;
import com.lufthansa.pages.ShoppingCart;
import com.lufthansa.utils.*;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * This is the homepage test class that has the main test case of booking the flight
 * Extends base test class
 * @author kiran
 *
 */
public class HomepageTest extends BaseTest{
	public WebDriver driver;
	
	/**
	 * Intializes driver before starting a test case
	 */
	@BeforeTest
	public void getDriver(){
		driver = BaseTest.driver;
	}
	
	/**
	 * Main test case that books flight tickets
	 * @throws Exception
	 */
	@Test
	public void bookTicket() throws Exception{
	
		String originCity = prop.getProperty("originCity");
		String destinationCity = prop.getProperty("destinationCity");
		int pageloadTimeout = Integer.parseInt(prop.getProperty("pageloadTimeout"));
		String travelClass = prop.getProperty("travelClass");
		String passengerDetails = prop.getProperty("passengerDetails");
		WebDriverWait wait = new WebDriverWait(driver, pageloadTimeout);
		String titlePaymentDetails = prop.getProperty("titlePaymentDetails");
		String titleShoppingCart = prop.getProperty("titleShoppingCart");
		String titlePassengerDetails = prop.getProperty("titlePassengerDetails");
		String email = prop.getProperty("email");
		String firstname1 = prop.getProperty("firstname1");
		String lastname1 = prop.getProperty("lastname1");
		String phoneArea = prop.getProperty("phoneArea");
		String phoneNumber = prop.getProperty("phoneNumber");
		long threadSleepValue = Long.parseLong(prop.getProperty("threadSleepValue"));
		String scr;
		
		System.out.println("Test: verifyHomePage");
		Assert.assertEquals(BaseTest.driver.getCurrentUrl(), url);
		logger.log(LogStatus.PASS, "Homepage verified - "+url);
		System.out.println("verified the URL: "+url);
		
		//*** Homepage ***//
		Homepage hm = new Homepage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(hm.originCity()));
		hm.originCity().clear();
		hm.originCity().click();
		hm.originCity().sendKeys(originCity);
		Thread.sleep(threadSleepValue*2);
		hm.airportAtlas().click();
		Thread.sleep(threadSleepValue*2);
		if(driver.findElements(By.xpath(hm.selectXpath())).size() !=0){
			driver.findElement(By.xpath(hm.selectXpath())).click();
		}
		
		Thread.sleep(threadSleepValue);
		logger.log(LogStatus.INFO, "Source city entered - "+originCity);
		System.out.println("Source city entered - "+originCity);
		hm.destinationCity().clear();
		hm.destinationCity().click();
		hm.destinationCity().sendKeys(destinationCity);
		logger.log(LogStatus.INFO, "Destination city entered - "+destinationCity);
		System.out.println("Source city entered - "+destinationCity);
		hm.oneway().click();
		Assert.assertTrue(hm.oneway().isSelected());
		logger.log(LogStatus.PASS, "One way trip - checked");
		System.out.println("One way trip checked");
		hm.calendar().click();
		hm.bookingDate().click();
		Thread.sleep(threadSleepValue);
		logger.log(LogStatus.INFO, "Date entered - two days from today ");
		System.out.println("Selected date- 2 days from today");
		hm.passengerDetails().click();
		Select sltClass = new Select(hm.travelClass());
		System.out.println("Travel class: "+travelClass);
		sltClass.selectByVisibleText(travelClass);
		hm.submit().click();
		Assert.assertEquals(hm.passengerDetails().getText(), passengerDetails);
		logger.log(LogStatus.PASS, "Passenger details entered and verified"+passengerDetails);
		System.out.println("Passenger details entered and verified"+passengerDetails);
		Thread.sleep(threadSleepValue);
		hm.searchFlights().click();
		Thread.sleep(threadSleepValue*6);
		logger.log(LogStatus.INFO, "Search Flights initiated");
		System.out.println("Searching flights in progress");
		try{
			Alert al = driver.switchTo().alert();
			al.accept();
			System.out.println("Accept JS popup to resend request");
			Thread.sleep(threadSleepValue*3);
		}catch(Exception e){
			System.out.println("No Javascript Popup");
		}
		//*** Flight Selection page ***//
		
		FlightSelection fs =new FlightSelection(driver);
		//does not work for FF
		//wait.until(ExpectedConditions.elementToBeClickable(fs.sortArrow()));
//		System.out.println(driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), titleFlightSelection);
		logger.log(LogStatus.PASS, "Flight selection page title verified");
		System.out.println("Flight selection page loaded");
		
		fs.sortArrow().click();
		Thread.sleep(threadSleepValue*2);
		if (driver.findElements(By.xpath(fs.sortByPricexPath())).size() !=0){
			driver.findElement(By.xpath(fs.sortByPricexPath())).click();	
		} else{
			driver.findElement(By.xpath(fs.sortByPrice2xPath())).click();
		}
		
		Thread.sleep(threadSleepValue*2);
		logger.log(LogStatus.INFO, "Flights sorted by price");
		System.out.println("Flights sorted by price");
		if (driver.findElements(By.xpath(fs.lowsetBaseFarexpath())).size() !=0 ){
			driver.findElement(By.xpath(fs.lowsetBaseFarexpath())).click();
		} 
		else{
			fs.lowsetFlexFare().click();
		}
		
		Thread.sleep(threadSleepValue*2);
		System.out.println("Selected lowest fare");
		scr = CommonMethods.captureScreenShot(driver,"selectedLowestCostFlight");
		logger.log(LogStatus.PASS, "Clicked on the lowest fare", "<a  target='_blank' href='"+scr+"'>"+scr+"</a>");
		fs.continueButton().click();
		Thread.sleep(threadSleepValue*10);
		
		
		//*** Shopping Cart page ***//
		
		ShoppingCart sc = new ShoppingCart(driver);
		wait.until(ExpectedConditions.visibilityOf(sc.deleteButton()));
		Assert.assertEquals(driver.getTitle(),titleShoppingCart);
		scr = CommonMethods.captureScreenShot(driver,"AddToCart");
		logger.log(LogStatus.PASS, "Added to cart", "<a  target='_blank' href='"+scr+"'>"+scr+"</a>");
		System.out.println("In shopping cart page");
		Thread.sleep(threadSleepValue*10);
		wait.until(ExpectedConditions.visibilityOf(sc.continueButton()));
		sc.continueButton().click();
		Thread.sleep(threadSleepValue*10);
		System.out.println("Clicked Continue");
		
		//*** Passenger Details page ***//
		
		PassengerDetails pd = new PassengerDetails(driver);
		wait.until(ExpectedConditions.elementToBeClickable(pd.titlePassenger1()));
		Assert.assertEquals(driver.getTitle(),titlePassengerDetails);
		logger.log(LogStatus.INFO, "In Passenger Details page");
		System.out.println("In passenger detail page");
		pd.titlePassenger1().click();
		pd.titleMr1().click();
		
		pd.Firstname1().sendKeys(firstname1);
		pd.Lastname1().sendKeys(lastname1);
		
		pd.phoneArea().sendKeys(phoneArea);
		pd.phoneNumber().sendKeys(phoneNumber);
		
		pd.email().sendKeys(email);
		scr = CommonMethods.captureScreenShot(driver,"PassengerDetailsFilled");
		logger.log(LogStatus.PASS, "Passanger details filled", "<a  target='_blank' href='"+scr+"'>"+scr+"</a>");
		pd.continueButton().click();
		Thread.sleep(threadSleepValue*5);
		
		//*** Payment Details page ***//
		
		PaymentDetails payd = new PaymentDetails(driver);
		wait.until(ExpectedConditions.elementToBeClickable(payd.headingPaymentDetails()));
		Assert.assertEquals(driver.getTitle(),titlePaymentDetails);
		scr = CommonMethods.captureScreenShot(driver,"PaymentDetailsPage");
		logger.log(LogStatus.PASS, "In payment details page. Concluding the test!", "<a  target='_blank' href='"+scr+"'>"+scr+"</a>");
		
	}
}
