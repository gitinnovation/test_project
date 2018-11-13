package com.cts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class schoollogo {

	WebDriver driver;
	 
	 public schoollogo(WebDriver driver){ 
	                 this.driver=driver; 
	        }
	
	 // Link
	@FindBy(how=How.LINK_TEXT, using="School Logo") 
	WebElement LINK; 

	@FindBy(how=How.ID, using="MainContent_UploadSchoolLogo1_Browse1_TxtBrowseFile") 
	WebElement BrowseImage; 
	
	@FindBy(how=How.ID, using="MainContent_UploadSchoolLogo1_btnSubmit")
	WebElement SubmitButton; 
		
	 public void btnlinks(){
		LINK.click();
		   try {
	           Thread.sleep(3000);
	       } catch (InterruptedException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       } 
			 
	 }
	 
	 public void submit(){
		 SubmitButton.click();
	 }
}
