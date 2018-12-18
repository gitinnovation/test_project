package com.cts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ExcludeBooks {
	WebDriver driver;
	 
	 public ExcludeBooks(WebDriver driver){ 
	                 this.driver=driver; 
	        }
	 
	 //Using FindBy for locating elements class="form-control"

	 
	 @FindBy(how=How.LINK_TEXT, using="Exclude Books") 
	 	WebElement Exclude;
	 @FindBy(how=How.XPATH, using="//input[@value='[Select Class]']") 
	 	WebElement selClass;
	 @FindBy(how=How.ID, using="MainContent_SchoolBookMapping2_btnGo") 
	 	WebElement Go;
	 @FindBy(how=How.XPATH, using="//input[@value='[All]']") 
	 	WebElement selAll;
	 @FindBy(how=How.ID, using="MainContent_DeleteTest1_btnSearch") 
	 	WebElement search;
	 @FindBy(how=How.XPATH, using="//input[@id='MainContent_SchoolBookMapping2_lstBooks_chkBook_0']")
	  WebElement chkbtn;
	 @FindBy(how=How.XPATH, using="//input[@id='MainContent_SchoolBookMapping2_btnSubmit']")
	  WebElement savebtn;
	//input[@id='MainContent_SchoolBookMapping2_lstBooks_chkBook_0']
	//input[@id='MainContent_SchoolBookMapping2_btnSubmit']
	//Select Delete Test Link 
	 public void exBooks(){
		 Exclude.click();
	 }
	//Select Class from drop down	 
	 public void selclass(){
			selClass.clear();
			selClass.sendKeys("Class 6");
		 }
		//Select Subject from drop down	 
	 public void viewbooks(){
				Go.click();
			 }
	 public void selectbook() {
		 chkbtn.click();
	 }
	 
	 public void save() {
		 savebtn.click();
	 }
	 
			//Select All/delete Test from drop down	 
	 //public void All(){
		//	selAll.click();
		//		 }
		 //Search Selected Test
	// public void search(){
		// search.click();
	// }


}
