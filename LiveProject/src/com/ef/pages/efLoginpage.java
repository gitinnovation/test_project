package com.ef.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class efLoginpage {
 
 WebDriver driver;
 
 public efLoginpage(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

	@FindBy(how=How.XPATH, using="//input[@class='form-control'][@id='UsrID']") 
 	WebElement usernameTextBox;

 	@FindBy(how=How.XPATH, using="//input[@class='form-control'][@id='UsrPassword']") 
 	WebElement passwordTextBox;

 	@FindBy(how=How.XPATH, using="//*[@type='submit'][@value='SIGN IN']") 
 	WebElement signinButton;

        // Defining all the user actions (Methods) that can be performed in the Facebook home page
 
        // This method is to set Email in the email text box
 public void setUsrID(String strUSRID){
	 usernameTextBox.clear();
	 usernameTextBox.sendKeys(strUSRID);
 }

 public void setPass(String pass){
	 passwordTextBox.clear();
	 passwordTextBox.sendKeys(pass);
 }

 // This method is to click on Login Button
 public void btnClick(){
	 signinButton.click();
	 driver.manage().window().maximize();
 }



}