package com.cts.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ctsLoginpage {
 
 WebDriver driver;
 
 public ctsLoginpage(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.XPATH, using="//input[@id='LoginUser_UserName']") 
 	WebElement usernameTextBox;

 	@FindBy(how=How.XPATH, using="//input[@id='LoginUser_Password']") 
 	WebElement passwordTextBox;

 	@FindBy(how=How.XPATH, using="//input[@id='LoginButton']") 
 	WebElement signinButton;
 
        // Defining all the user actions (Methods) that can be performed in the Facebook home page
 
        // This method is to set Email in the email text box
 public void setUsrID(String strUSRID){
	 usernameTextBox.clear();
	 usernameTextBox.sendKeys(strUSRID);
 }

 // This method is to set Password in the password text box
 public void setPass(String strPassword){
	 passwordTextBox.sendKeys(strPassword);
 }
 // This method is to click on Login Button
 public void btnClick(){
	 signinButton.click();
 }

} 
