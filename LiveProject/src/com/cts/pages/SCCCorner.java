package com.cts.pages;
 
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.util.repo.automationFunctions;

public class SCCCorner {
 
 WebDriver driver;
 static Properties Pro;
 public SCCCorner(WebDriver driver) throws IOException{ 
                 this.driver=driver; 
                 Pro =  af.getObjectRepository("\\src\\com\\util\\repo\\userLoginHisto.properties");
        }
 allComponentFunctions acf=new allComponentFunctions();
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.XPATH, using="//button[contains(text(),'SCC Corner')]") 
 	WebElement SCCCorner; 
 	
 	
 	@FindBy(how=How.XPATH, using="//input[@value='Upload New File']") 
 	WebElement uploadNewFile;
 
 	
 	@FindBy(how=How.XPATH, using="//input[@value='[Select Class]']")
    WebElement clas;
 	
 	@FindBy(how=How.XPATH, using="//img[@class='igdd_DropDownButton']")
    WebElement clasimg;
    
  	@FindBy(how=How.XPATH, using="//*[@id=\\'MainContent_RCCornerControl1_ddClass_ddClassMaster\\']/div/table/tbody/tr/td[2]/img") 
 	WebElement Yearly; 
	
	@FindBy(how=How.XPATH, using="//td//tbody[@data-ig='x:1303269913.5:mkr:footingArea']//td//tbody//tr[@type='row']//td[2]")
 	WebElement StudName; 
 	 	
 	//@FindBy(how=How.XPATH, using="//input[@id='MainContent_RCCornerControl1_gDateRange1_AsOfDate_SingleDateSelectorStartDate_ImageButton1']")
 	//WebElement Calender;
	
	@FindBy(how=How.XPATH, using="//table[contains(@class,'igdd_ControlFocus')]//img[contains(@class,'igdd_DropDownButton')]")
 	WebElement Year; 
			 	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_RCCornerControl1_btnSearch']")
 	WebElement Search; 
	
	@FindBy(how=How.XPATH, using="//input[contains(@value,'Upload New File')]")
 	WebElement UploadNewFile; 
	
	@FindBy(how=How.XPATH, using="//img[@class='igdd_DropDownButton']")
 	WebElement Class; 
		
	//@FindBy(how=How.LINK_TEXT, using="Class 10")
    //WebElement class10;

	
	@FindBy(how=How.XPATH, using="//div[@id='MainContent_FileUploadPopup2_FromDate_CalendarExtender1_title']") 
	WebElement title_From;

	@FindBy(how=How.XPATH, using="//div[@id='MainContent_FileUploadPopup2_ToDate_CalendarExtender1_title']") 
	WebElement title_To;
	
	
	@FindBy(how=How.XPATH, using="//*[@id='MainContent_FileUploadPopup2_FromDate_ImageButton1']")
 	WebElement FromDate; 
											
	@FindBy(how=How.XPATH, using="//*[@id='MainContent_FileUploadPopup2_ToDate_ImageButton1']")
 	WebElement ToDate; 
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_FileUploadPopup2_txtFileName']")
 	WebElement DisplayName; 
	
	@FindBy(how=How.XPATH, using="//textarea[@id='MainContent_FileUploadPopup2_txtDesc']")
 	WebElement Description; 
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_FileUploadPopup2_Browse1_TxtBrowseFile']")
 	WebElement BrowseFile; 
	
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_FileUploadPopup2_btnSubmit']")
 	WebElement Submit; 
	
	automationFunctions af=new automationFunctions(); 
        // Defining all the user actions (Methods) that can be performed in the Facebook home page
 	
 public void btnlinksSCCCorner(){
 
	 SCCCorner.click();
		 
 }
 
 
 public void uploadNewFile(){
	 uploadNewFile.click();
	 
 }
 
 public void selectClass(String sClass){	 
	 acf.selectClass(clas, sClass);
	 driver.findElement(By.linkText(sClass)).click();
	 //class10.click();
 									}	

 /*public void selectClass(String sClass){
 	 clas.clear();
 	clas.sendKeys(sClass);
 	//clasimg.click();
 	 driver.findElement(By.linkText(sClass)).click() ;
 }	*/
 
 public void FromDate(String Year,String month, String day) throws Exception{
	 //FromDate.click();
	 af.calenderControl(driver, FromDate,title_From,Pro.getProperty("sccFrm_year"), Pro.getProperty("sccFrm_month"), Pro.getProperty("sccFrm_day"), Year, month, day);
		
} 

 public void ToDate(String Year,String month, String day) throws Exception{
	//ToDate.click();
	//System.out.println("");
	af.calenderControl(driver,ToDate,title_To, Pro.getProperty("sccTo_year"), Pro.getProperty("sccTo_month"), Pro.getProperty("sccTo_day"), Year, month, day);
 }
 public void DisplayName(String Display){
    	 DisplayName.clear();
    	 DisplayName.sendKeys(Display);
 }
    public void Description(String Descrip){
    	 Description.clear();
    	 Description.sendKeys(Descrip);
 }

    public void browseFile(String filepath) throws Exception{
    	acf.browseFile(BrowseFile, filepath);
} 
    public void submit(){
     Submit.click();
 }
}