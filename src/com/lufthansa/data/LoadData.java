/**
 * Load Data loads the data from external files to access the data
 * 
 */
package com.lufthansa.data;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Loads data from property file in the project folder
 * @author kiran
 *
 */
public class LoadData {

	static Properties prop= new Properties();
	/**
	 * loads propertes file
	 */
	public static Properties loadData(){
		
		FileInputStream fis;
		try {
			fis = new FileInputStream("data.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
}
