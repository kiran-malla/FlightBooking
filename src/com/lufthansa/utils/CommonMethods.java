/**
 * This has all the utilities methods
 */
package com.lufthansa.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.lufthansa.tests.BaseTest;

/**
 * All common methods are in this class
 * @author kiran
 *
 */
public class CommonMethods {
	
	/***
	 * increments or decrements the curent date based on the parameter passe, returns the date in 'dd' format, 
	 * returns today's date if 0 is passed as parameter
	 * 
	 * @param change
	 * @return
	 */
	public static String getDate(int change){
		String dt;
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		if(change!=0){
			cal.add(Calendar.DATE, change);
		}
		dt = dateFormat.format(cal.getTime());
		return dt;
	}
	
	/**
	 * Captures screenshot and saves it in the reports folder
	 * @param driver
	 * @param fileName
	 * @return
	 */
	public static String captureScreenShot(WebDriver driver, String fileName){
		// Take screenshot and store as a file format             
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
		 File f = new File(".\\ExtentReports\\"+BaseTest.browser_name+"\\"+fileName+".png");
		try {
		// now copy the  screenshot to desired location using copyFile method
		FileUtils.copyFile(src, f);
		} catch (IOException e)
		 
		{
		  System.out.println(e.getMessage()); 
		 }
		return f.getName(); 
	}
	
	// **** Javascript page load wait function, Not working for Firefox
	/*public static void waitForPageload(WebDriver driver, int timeout){
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	}*/
}
