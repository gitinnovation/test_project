package com.cts.pages;

import org.openqa.selenium.WebElement;

public class allComponentFunctions {

	 public void selectClass(WebElement clas,String sClass){
	 	 //Problem in this function not clicking correct class.	
		 clas.clear();
		 clas.sendKeys(sClass);
		 try {
	           Thread.sleep(3000);
	       } catch (InterruptedException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       } 
		 clas.sendKeys(sClass);
	 }

	 
	  public void browseFile(WebElement browseBtn,String filepath) throws Exception{
		  	browseBtn.click();
	 		Runtime.getRuntime().exec("D:\\Automation\\AutoitScripts\\Automation\\eclipse-jee-neon-R-win32\\eclipse\\workspace\\LiveProjects\\src\\FileUpload.exe "+filepath);
	 		Thread.sleep(10000);
	     
	 }

}
