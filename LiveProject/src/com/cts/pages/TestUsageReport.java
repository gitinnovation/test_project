package com.cts.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TestUsageReport {
 
 WebDriver driver;
 
 public TestUsageReport(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT , using="TestUsageReport") 
 	WebElement TestUsageRepo; 
 	
 	@FindBy(how=How.LINK_TEXT , using="Oct-Dec") 
 	WebElement Mo; 
 	
 	@FindBy(how=How.LINK_TEXT , using="2018-2019") 
 	WebElement Ye; 
 	
 	
 	@FindBy(how=How.XPATH, using="//img[@class='igdd_DropDownButton']") 
 	WebElement SelQuarter; 
 	////a[contains(text(),'Month)]
 	@FindBy(how=How.XPATH, using="//table[@class='igdd_ControlFocus']//img[@class='igdd_DropDownButton']") 
 	WebElement SelMonth; 
 	
 	@FindBy(how=How.XPATH, using="//table[@class='igdd_ControlFocus ig_Hover igdd_ControlHover']//img[@class='igdd_DropDownButton']") 
 	WebElement SelYear; 
	 	
 	@FindBy(how=How.XPATH, using="//input[@id='MainContent_SASUsageReport1_GoButton']")
 	WebElement Go;
	
		
        // Defining all the user actions (Methods) that can be performed in the Facebook home page
 	
 public void btnlinksTestUsageReport(){
	 TestUsageRepo.click();
	   try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } 
	   TestUsageRepo.click();
		 
 }
 
	 public void SelQuarte(){
	 SelQuarter.click();
	 //SelQuarter.click();
 }
     public void SelMont(){
     SelMonth.click();
     Mo.click();
 }
     public void SelYe(){
     SelYear.click();
     Ye.click();
 }
     public void Go(){
	 Go.click();
 }
}