package com.cts.pages;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.repo.*;

public class userLoginHistory {
 
	WebDriver driver;
	 static Properties Pro;
	automationFunctions af=new automationFunctions(); 
	
	 public userLoginHistory(WebDriver driver) throws IOException{ 
	                 this.driver=driver; 
	                 Pro =  af.getObjectRepository("src\\com\\util\\repo\\userLoginHistory.properties");
	  }
	 
		@FindBy(how=How.LINK_TEXT, using="User Login History") 
		WebElement LINK;
		
		@FindBy(how=How.XPATH, using="//*[@id='MainContent_UserLoginHistory1_gDateRange1_cmbcycle']/div/table/tbody/tr/td[2]/img") 
		WebElement select_date;
		
		@FindBy(how=How.XPATH, using="//*[@id='MainContent_UserLoginHistory1_gDateRange1_AsOfDate_SingleDateSelectorStartDate_ImageButton1']") 
		WebElement calender;
		
		@FindBy(how=How.XPATH, using="//div[@class='ajax__calendar_title']") 
		WebElement title;
		
		@FindBy(how=How.XPATH, using="//div[@id='MainContent_UserLoginHistory1_gDateRange1_AsOfDate_SingleDateSelectorStartDate_CalendarExtender1_title']") 
		WebElement month;

		@FindBy(how=How.ID, using="MainContent_UserLoginHistory1_Button2")
		WebElement GOButton;
		
		@FindBy(how=How.LINK_TEXT, using="As Of...")
	 	WebElement asof;

		
		public void btnlinks(){
	 		LINK.click();
	 		   try {
	 	           Thread.sleep(3000);
	 	       } catch (InterruptedException e) {
	 	           // TODO Auto-generated catch block
	 	           e.printStackTrace();
	 	       } 
	 		}
		 
			public void LINK(){
				LINK.click();
			} 
		 	public void duration() throws Exception{
		 		select_date.click();
		 		asof.click();
		 		asOf();
		 		
		 	}

		 	public void asOf() throws Exception
		 	{
		 		//asof.click();

		 		/*WebDriverWait wait_calender = new WebDriverWait(driver, 10);
		 		wait_calender.until(ExpectedConditions.visibilityOf(calender));
		 		calender.click();
		 		
		 		WebDriverWait wait_title = new WebDriverWait(driver, 10);
		 		wait_title.until(ExpectedConditions.visibilityOf(title));		 				 				 		
		 		title.click();
		 		Thread.sleep(1000);
		 		title.click();*/

	 		
		 		af.calenderControl(driver, calender,title,Pro.getProperty("years"), Pro.getProperty("months"), Pro.getProperty("dates"), "2013", "Oct", "13");

		 	}
		 	public void go(){
		 		GOButton.click();
}
		 	}
