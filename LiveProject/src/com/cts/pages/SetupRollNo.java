package com.cts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SetupRollNo {
	WebDriver driver;
	 public SetupRollNo(WebDriver driver){ 
         this.driver=driver; 
}
	 
	 @FindBy(how=How.LINK_TEXT, using="Exclude Books") 
	 	WebElement Exclude;
	 @FindBy(how=How.XPATH, using="//input[@value='[Select Class]']") 
	 	WebElement selClass;
	//table[@class='igdd_ControlArea']//input[@type='text']
	 @FindBy(how=How.ID, using="//table[@class='igdd_ControlArea']//input[@type='text']") 
	 	WebElement section;
	 @FindBy(how=How.XPATH, using="//input[@id='MainContent_SetupRollNumbers1_Button1']") 
	 	WebElement search;
	
	 @FindBy(how=How.XPATH, using="//input[@id='MainContent_SetupRollNumbers1_Button2']")
	  WebElement save;
	 
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
	 public void selSec(){
				section.clear();
				section.sendKeys("A");
			 }
	 public void selectbook() {
		 search.click();
	 }
	 
	 public void save() {
		 save.click();
	 }

}
