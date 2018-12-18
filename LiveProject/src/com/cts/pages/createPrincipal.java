package com.cts.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class createPrincipal {
 
 WebDriver driver;
 
 public createPrincipal(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT, using="Principal") 
 	WebElement createTeacher; 
 	
 	@FindBy(how=How.XPATH, using="//input[@id='Button1']") 
 	WebElement createNEW; 
 	////a[contains(text(),'Create New')]
 	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddPrincipal1_txtUsrID']") 
 	WebElement UserId; 
 	
 	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddPrincipal1_txtUsrName']") 
 	WebElement UserName; 
 	
 	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddPrincipal1_UsrPasswordTextBox']")
 	WebElement UsrPassword; 
 	
 	//@FindBy(how=How.XPATH, using="/html/body/section[2]/div[2]/form/fieldset/div/div[5]/label[1]")
 	//WebElement classCheckbox; 
 	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddPrincipal1_btnSave']")
 	WebElement Submit; 
        // Defining all the user actions (Methods) that can be performed in the Facebook home page
 	
 public void btnlinks(){
	 createTeacher.click();
	   try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } 
		 createNEW.click();
		 
 }
 
 public void setUsrID(String sUSRID){
	 UserId.clear();
	 UserId.sendKeys(sUSRID);
 }
 public void setUsrName(String UsrNme){
	 UserName.clear();
	 UserName.sendKeys(UsrNme);
 }
 
 public void setUsrPassword(String passWord){
	 UsrPassword.clear();
	 UsrPassword.sendKeys(passWord);
 }
 
 /*public void selectClass(){
	 classCheckbox.click();
 }*/
 
 public void submit(){
	 Submit.click();
 }
}