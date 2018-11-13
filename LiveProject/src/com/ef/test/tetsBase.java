/**
 * 
 */
package com.ef.test;

/**
 * @author Vipul
 *
 */

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class tetsBase {
	
	public static WebDriver driver = null;
	
	@BeforeSuite
	public void initialize() throws IOException{
			
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\drivers\\chromedriver.exe");
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
	    driver = new ChromeDriver();		
		//To maximize browser 
                //driver.manage().window().maximize();
	        //Implicit wait
        	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//To open facebook
                driver.get("http://englishforever.com/");
		
	}
	
	@AfterSuite
	//Test cleanup
	public void TeardownTest()
    {
		//tetsBase.driver.quit();
    }

}