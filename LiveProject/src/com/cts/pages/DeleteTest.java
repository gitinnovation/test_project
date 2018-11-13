package com.cts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeleteTest {
	WebDriver driver;
	 
	 public DeleteTest(WebDriver driver){ 
	                 this.driver=driver; 
	        }
	 
	 //Using FindBy for locating elements class="form-control"

	 
	 @FindBy(how=How.LINK_TEXT, using="Delete Test") 
	 	WebElement deletebutton;
	 @FindBy(how=How.XPATH, using="//input[@value='[Select Class]']")
	  	WebElement selClass;
	 @FindBy(how=How.XPATH, using="//input[@value='[Select Subject]']") 
	 	WebElement selSubject;
	 @FindBy(how=How.XPATH, using="//input[@value='All']") 
	 	WebElement selAll;
	 @FindBy(how=How.ID, using="MainContent_DeleteTest1_btnSearch") 
	 	WebElement search;
	 		//Select Delete Test Link 
	 public void delTst(){
		 deletebutton.click();
	 }
	//Select Class from drop down	 
	 public void selclass(){
			//selClass.click();
			selClass.clear();
			selClass.sendKeys("Class 6");
		 }
		//Select Subject from drop down	 
	 public void selSub(){
				selSubject.clear();
				selSubject.sendKeys("Mathematics");
			 }
			//Select All/delete Test from drop down	 
	 public void All(){
			selAll.click();
				 }
		 //Search Selected Test
	 public void search(){
		 search.click();
	 }
//Pending Delete records process
}
