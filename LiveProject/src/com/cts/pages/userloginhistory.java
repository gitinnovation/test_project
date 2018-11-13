package com.cts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class userloginhistory {
 
	WebDriver driver;
	 
	 public userloginhistory(WebDriver driver){ 
	                 this.driver=driver; 
	  }
	 
	// Link
		@FindBy(how=How.LINK_TEXT, using="User Login History") 
		WebElement LINK;
		
		@FindBy(how=How.XPATH, using="//input[@value='Monthly']") 
		WebElement duration;
		
		@FindBy(how=How.XPATH, using="//input[@value='Oct - Dec']") 
		WebElement month;
		
		@FindBy(how=How.XPATH, using="//input[@value='2018 - 2019']") 
		WebElement year;
		
		@FindBy(how=How.ID, using="MainContent_UserLoginHistory1_Button2")
		WebElement GOButton;
		
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
		 	public void duration(){
		 		duration.clear();
		 		duration.sendKeys("Quarterly");
		 		//duration.click();
		 	}
		 	public void month(){
		 		//month.clear();
		 		month.sendKeys("Jan - Mar");
		 		//month.click();
		 	}
		 	public void year(){
		 		//year.clear();
		 		year.sendKeys("2018 - 2019");
		 		//year.click();
		 	}
		 	public void go(){
		 		GOButton.click();
}
		 	}
