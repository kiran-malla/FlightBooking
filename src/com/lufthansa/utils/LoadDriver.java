/**
 * Has methods used to load approprite browser from external files
 * 
 */
package com.lufthansa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

/**
 * LoadDriver loads the appropriate drivers based on the browser
 * There are no downloaded browser drivers, uses bonigarcia dependancy to do it
 * Specific version of drivers have been downloaded based the browser versions. Version() method in the setup() calls below can be removed to get latest drivers
 * @author kiran
 *
 */
public class LoadDriver {
	
	public static WebDriver driver;
	public LoadDriver(String browser){
		if(browser.equalsIgnoreCase("firefox")){
			System.out.println("Firefox browser selected");	
			FirefoxDriverManager.getInstance().version("0.15.0").setup();
			driver = new FirefoxDriver();
		}
		if(browser.equalsIgnoreCase("chrome")){
			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("edge")){
			EdgeDriverManager.getInstance().version("3.14393").setup();
			DesiredCapabilities capabilities = DesiredCapabilities.edge();
			driver = new EdgeDriver(capabilities);
		}
	}
}
