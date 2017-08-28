/**
 * Base Test 
 */
package com.lufthansa.tests;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.lufthansa.data.LoadData;
import com.lufthansa.utils.CommonMethods;
import com.lufthansa.utils.LoadDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Base Test is the base test class which has all the initialization and tear down methods.
 * Every Test class extends this base class to access the commonly needed properties across Test classes
 * @author kiran
 *
 */
public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = LoadData.loadData();
	public static String url = prop.getProperty("url");
	public static Long implicitTimeout = Long.parseLong(prop.getProperty("implicitTimeout"));
	public static Long threadSleepValue = Long.parseLong(prop.getProperty("threadSleepValue"));
	public static ExtentReports report;
	public static ExtentTest logger;
	public static String browser_name;
	
	/**
	 * This is the first method that is called when test is executed
	 * Initializes all required objects like ExtentReports, driver etc
	 * Browser value is passed to this method from testng.xml
	 * 
	 * @param browser
	 */
	@BeforeSuite
	@Parameters("browser")
	public static void init(String browser) {
		try {
			File reportPath = new File(".\\ExtentReports\\"+browser);
			if(reportPath.exists()){
		        FileUtils.deleteDirectory(reportPath);
			}
			reportPath.mkdir();
			report = new ExtentReports(reportPath+"\\Lufthansa.html");
			browser_name=browser;
			System.out.println("Browser selected: "+browser);
			new LoadDriver(browser);
			driver = LoadDriver.driver;
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(implicitTimeout,TimeUnit.SECONDS);
			Thread.sleep(threadSleepValue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Initializes the ExtentReport object
	 * Called before method i.e. beffore every test case
	 * @param method
	 */
	@BeforeMethod
	public static void beforeMethod(Method method){
		
		//if you want to get the class name in before method
//	    String classname = getClass().getSimpleName();
		//IF you want to get the method name in the before method 
	    String methodName = method.getName();
	    logger=report.startTest(methodName);
	}
	
	/**
	 * Take screenshot and log it in reports on failure
	 * called after every method i.e. test case
	 * @param result
	 */
	@AfterMethod
	public static void afterMethod(ITestResult result){
		if (result.getStatus()==ITestResult.FAILURE){
			String scr = CommonMethods.captureScreenShot(driver, result.getName());
			logger.log(LogStatus.FAIL, result.getTestName(), "<a target='_blank' href='"+scr+"'>"+scr+"</a>");
		}
		report.endTest(logger);
	}
	
	
	/**
	 * After suite - clean up (Not cleaning up driver to keep the browsers open for verification)
	 */
	@AfterSuite
	public void cleanup() {
	  //driver.quit();
		report.flush();
	}

}
