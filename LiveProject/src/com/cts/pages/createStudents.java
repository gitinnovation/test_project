package com.cts.pages;
 
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class createStudents {
 
 WebDriver driver;

 allComponentFunctions acf=new allComponentFunctions();
 public createStudents(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 	//Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT, using="Students") 
 	WebElement createStudents; 
 	 	
 	@FindBy(how=How.XPATH, using="//*[@id='Button1']") 
 	WebElement Add; 
 	
 	@FindBy(how=How.XPATH, using="//*[@id='MainContent_AddStudent1_FormView1_NameTextBox1']") 
 	WebElement UserName; 
 	 	
 	@FindBy(how=How.XPATH, using="//*[@id='MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster']/div/table/tbody/tr/td[2]/img")
 	WebElement clasimg; 
	
 	@FindBy(how=How.XPATH, using="//*[@id='MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster']/div/table/tbody/tr/td[1]/input")
 	WebElement clas;
	
 	
	@FindBy(how=How.XPATH, using="//div[@data-ig='x:1099320463.0:mkr:Target']//input[@type='text']")
 	WebElement Section; 
	
	
	@FindBy(how=How.XPATH, using="//img[@data-ig='x:1099320463.4:mkr:ButtonImage']")
 	WebElement secddimg; 
	
	
	@FindBy(how=How.XPATH, using="//*[@id='MainContent_AddStudent1_FormView1_SASRemotIDTextBox1']")
 	WebElement RemoteNumber; 
	
	@FindBy(how=How.XPATH, using="//*[@id='MainContent_AddStudent1_FormView1_RollNoTextBox1']")
 	WebElement RollNumber; 
	
	@FindBy(how=How.XPATH, using="//*[@id='MainContent_AddStudent1_FormView1_InsertButton']")
 	WebElement AddSubmit; 
	
    @FindBy(css = "#MainContent_AddStudents_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(1) a")
    @CacheLookup
    private WebElement selectClass;
    
    
	@FindBy(how=How.XPATH, using="//img[@class='igdd_DropDownButton']")
 	WebElement searchClass;
	
	@FindBy(how=How.XPATH, using="//img[@data-ig='x:551245284.4:mkr:ButtonImage']")
 	WebElement searchSection;
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_StudentDetails1_btnGo']")
 	WebElement GO;
  
    
	public void btnlinksadd(){
		 createStudents.click();
		   try {
	           Thread.sleep(3000);
	       } catch (InterruptedException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       } 
		   Add.click();
			 
	 }

	 public void setUsrName(String UsrNme){
		 UserName.clear();
		 UserName.sendKeys(UsrNme);
	 }
	 

	 public void selectClass(String sClass){
	 	 //Problem in this function not clicking correct class.	
		 acf.selectClass(clas, sClass);
	 }

	 public void setUsrSec(String sSection) {
		 Section.clear();
		 Section.sendKeys(sSection);	
		 secddimg.click();
 	}

	 public void setUsrRemoteNo(String remote){
		 	RemoteNumber.clear();
		 		
		 	RemoteNumber.sendKeys(remote);
		 }
	
		 public void setUsrRollNo(String roll){
		 RollNumber.clear();
		 RollNumber.sendKeys(roll);
	 }

	 public void submit() throws InterruptedException {
		 try{
			 Thread.sleep(1000);
		 new Actions(driver).moveToElement(AddSubmit).perform();
		 AddSubmit.click();	 
		 }catch(Exception we){
			 secddimg.click();
			 Thread.sleep(1000);
			 AddSubmit.click();	 
		 }
	 } 

	 public void verifyStudent(String sClass, String sSection, String UsrNme, String remote,String roll) {
		
		 searchClass.clear();
		 driver.findElement(By.linkText(sClass)).click();
		 secddimg.click();
 	}

	 
}