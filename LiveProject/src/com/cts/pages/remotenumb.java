package com.cts.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class remotenumb {
	
	@FindBy(how=How.LINK_TEXT, using="Setup Remote No") 
	WebElement LINK;
	
	@FindBy(how=How.XPATH, using="//input[@value='[Select Class]']") 
	WebElement selectclass;
	
	@FindBy(how=How.XPATH, using="//input[@value='A']") 
	WebElement selectsection;
	
	@FindBy(how=How.ID, using="MainContent_SetupRemoteNumbers1_Button1")
	WebElement search;
	
	public void btnlinks(){
		LINK.click();
		   try {
	           Thread.sleep(3000);
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       } 
			 
	 }
	public void selectclass(){
		selectclass.clear();
		selectclass.sendKeys("Pre Nursery");
		//selectclass.click();
	}
	public void selectsection(){
		selectsection.clear();
		selectsection.sendKeys("A");
	}
	public void search(){
		search.click();
	}
}
