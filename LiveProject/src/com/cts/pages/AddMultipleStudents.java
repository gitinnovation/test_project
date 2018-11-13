package com.cts.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddMultipleStudents {
 
 WebDriver driver;
 
 public AddMultipleStudents(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT, using="Students") 
 	WebElement AddMultpleSt; 
 	
 	@FindBy(how=How.XPATH, using="//input[@value='[Select Class]']") 
 	WebElement SelClass; 
 	////a[contains(text(),'Add)]
 	@FindBy(how=How.XPATH, using="//table[@class='igdd_ControlFocus']//input[@type='text']") 
 	WebElement Sect; 
 	
 	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddStudents_btnSearch']") 
 	WebElement Sear; 
	
	@FindBy(how=How.XPATH, using="//td//tbody[@data-ig='x:1303269913.5:mkr:footingArea']//td//tbody//tr[@type='row']//td[2]")
 	WebElement StudName; 
 	 	
 	@FindBy(how=How.XPATH, using="//input[@class='igg_EditCell']")
 	WebElement StudentNameEdit;
	
	@FindBy(how=How.XPATH, using="//td//tbody[@data-ig='x:1303269913.5:mkr:footingArea']//td//tbody//tr[@type='row']//td[3]")
 	WebElement RemoteID; 
			 	
	@FindBy(how=How.XPATH, using="//input[@class='igg_EditCell']")
 	WebElement RemoteIDEdit; 
	
	@FindBy(how=How.XPATH, using="//input[@class='igg_EditCell']")
 	WebElement RemoteNumber; 
	
	@FindBy(how=How.XPATH, using="//td//td//div[@data-ig='x:1303269913.3:mkr:container']//tr[@type='row']//td[4]")
 	WebElement RollNumber; 
		
	@FindBy(how=How.XPATH, using="//td//tbody[@data-ig='x:1303269913.5:mkr:footingArea']//td//tbody//tr[@type='row']//td[4]")
 	WebElement RollNumberEdit; 
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddStudents_btnAdd']")
 	WebElement Save; 
	
        // Defining all the user actions (Methods) that can be performed in the Facebook home page
 	
 public void btnlinksAddMultpleStudents(){
	 AddMultpleSt.click();
	   try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } 
	   AddMultpleSt.click();
		 
 }
 
	 public void setClass(String SClass){
		 SelClass.clear();
		 SelClass.sendKeys(SClass);
 }
     public void setSection(String Sec){
     Sect.clear();
     Sect.sendKeys(Sec);
 }
 
     public void setSearch(){
	 Sear.clear();
	 Sear.sendKeys();
 }
 
     public void selectStudName(String StName){
     StudName.clear();
     StudName.sendKeys(StName);
 }
 
     public void selectStudentNameEdit(String StName){
     StudName.clear();
     StudName.sendKeys(StName);
 }
 
     public void selectRemoteID(String remote){
     RemoteNumber.clear();
     RemoteNumber.sendKeys(remote);
 }
 
     public void selectRemoteIDEdit(String remote){
     RemoteNumber.clear();
     RemoteNumber.sendKeys(remote);
 }
 
     public void selectRollNumber(String roll){
     RollNumber.clear();
     RollNumber.sendKeys(roll);
 }
 
     public void selectRollNumberEdit(String roll){
     RollNumber.clear();
     RollNumber.sendKeys(roll);
 }
 
 
     public void submit(){
	 Save.click();
 }
}