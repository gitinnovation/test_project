package com.cts.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class custSer {
 
 WebDriver driver;
 
 public custSer(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT, using="Customize Services") 
 	WebElement clicklink; 
 	
 	@FindBy(how=How.ID, using="MainContent_CustomizeServices_rblMCQ_0") 
 	WebElement ymcq; 
 	////a[contains(text(),'Create New')]
 	@FindBy(how=How.ID, using="MainContent_CustomizeServices_rblMCQ_1") 
 	WebElement nmcq; 
 	
 	@FindBy(how=How.ID, using="MainContent_CustomizeServices_rblSBook_0") 
 	WebElement ysb; 
 	////a[contains(text(),'Create New')]
 	@FindBy(how=How.ID, using="MainContent_CustomizeServices_rblSBook_1") 
 	WebElement nsb; 
 	
 	@FindBy(how=How.ID, using="MainContent_CustomizeServices_rblTools_0") 
 	WebElement ytool; 
 	////a[contains(text(),'Create New')]
 	@FindBy(how=How.ID, using="MainContent_CustomizeServices_rblTools_1") 
 	WebElement ntool; 
 	
 	@FindBy(how=How.ID, using="MainContent_CustomizeServices_btnSubmit") 
 	WebElement sbmt; 
 	//@FindBy(how=How.XPATH, using="/html/body/section[2]/div[2]/form/fieldset/div/div[5]/label[1]")
 	//WebElement classCheckbox; 
 	
 public void btnlinks(){
	 clicklink.click();
	   try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } 
 }
 
 public void selmcq(char ch){
	 if (ch=='Y' || ch=='y')
	 {
		 ymcq.click();
	 }
	 else
	 {
		 nmcq.click();
	 }
			 
 }
 public void selsbook(char ch){
	 if (ch=='Y' || ch=='y')
	 {
		 ysb.click();
	 }
	 else
	 {
		 nsb.click();
	 }
			 
 }
 public void seltool(char ch){
	 if (ch=='Y' || ch=='y')
	 {
		 ytool.click();
	 }
	 else
	 {
		 ntool.click();
	 }
			 
 }
 
 public void submit(){
	 sbmt.click();
	 driver.switchTo().alert().accept();
 }
 
 }
 
