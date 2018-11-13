package com.cts.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class setupDev {
 
 WebDriver driver;
 
 public setupDev(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT, using="Setup Device") 
 	WebElement clicklink; 
 	
 	@FindBy(how=How.ID, using="MainContent_AddSASDevice1_DeviceNameTextBox") 
 	WebElement devname; 
 	////a[contains(text(),'Create New')]
 	@FindBy(how=How.ID, using="MainContent_AddSASDevice1_DDRemote") 
 	WebElement remtype; 
 	
 	@FindBy(how=How.ID, using="MainContent_AddSASDevice1_DDPorts") 
 	WebElement port; 
 	
 	@FindBy(how=How.ID, using="MainContent_AddSASDevice1_BtnAdd") 
 	WebElement addbtn; 
 	
 	@FindBy(how=How.LINK_TEXT, using="Delete") 
 	WebElement del; 
 	//@FindBy(how=How.XPATH, using="/html/body/section[2]/div[2]/form/fieldset/div/div[5]/label[1]")
 	//WebElement classCheckbox; 
 	
 public void btnlinks(){
	 clicklink.click();
	   try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } 
 }
 
 public void setDevice(String sdevn){
	 devname.clear();
	 devname.sendKeys(sdevn);
 }
 
 public void setRemote(String srem){
	 Select dropdown= new Select(remtype);
	   dropdown.selectByVisibleText(srem);
 }
 
 public void setPort(String sport){
	 Select dropdown= new Select(port);
	   dropdown.selectByVisibleText(sport);
 }
 
 public void addb(){
	 addbtn.click();
 }
 
 
 public void dellink(){
	 int count=0;
 }
 }
 
