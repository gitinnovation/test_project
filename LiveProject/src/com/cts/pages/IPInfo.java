package com.cts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class IPInfo {
	
	 WebDriver driver;
	 
	 public IPInfo(WebDriver driver){ 
	                 this.driver=driver; 
	        }
	
	 // Link
	@FindBy(how=How.LINK_TEXT, using="IP Address Information") 
 	WebElement LINK; 

	@FindBy(how=How.ID, using="MainContent_ipadd_det_fv_IPAddress_IPAddressTextBox") 
 	WebElement IPAddress; 
 	
 	@FindBy(how=How.ID, using="MainContent_ipadd_det_fv_IPAddress_NameTextBox")
 	WebElement Name; 
 	
 	@FindBy(how=How.ID, using="MainContent_ipadd_det_fv_IPAddress_InsertButton")
 	WebElement AddButton;
	
 	/*//EDIT
 	@FindBy(how=How.LINK_TEXT, using="Edit") 
 	WebElement EditLink;
 	
 	@FindBy(how=How.ID, using="MainContent_ipadd_list_GridView1_TextBox1_0") 
 	WebElement EditIPAddress;
 	
 	@FindBy(how=How.ID, using="MainContent_ipadd_list_GridView1_TextBox2_0") 
 	WebElement EditName;
 	
 	@FindBy(how=How.LINK_TEXT, using="Update") 
 	WebElement Update;
 	
 	@FindBy(how=How.LINK_TEXT, using="Cancel") 
 	WebElement Cancel;
 	
 	@FindBy(how=How.LINK_TEXT, using="Delete") 
 	WebElement EditDel;
 	
 	@FindBy(how=How.LINK_TEXT, using="Exclude") 
 	WebElement EditExclude;
 	*/
 	
 	 public void btnlinks(){
 		LINK.click();
 		   try {
 	           Thread.sleep(3000);
 	       } catch (InterruptedException e) {
 	           // TODO Auto-generated catch block
 	           e.printStackTrace();
 	       } 
 			 
 	 }
 	 
 	 public void setIP(String sIP){
 		IPAddress.clear();
 		IPAddress.sendKeys(sIP);
 	 }
 	 public void setName(String sName){
 		Name.clear();
 		Name.sendKeys(sName);
 	 }
 	 
 	 public void add(){
 		AddButton.click();
 	 }
	
}
