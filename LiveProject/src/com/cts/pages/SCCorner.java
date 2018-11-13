package com.cts.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SCCCorner {
 
 WebDriver driver;
 
 public SCCCorner(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT, using="SCCCorner") 
 	WebElement SCCCorner; 
 	
 	@FindBy(how=How.XPATH, using="//*[@id=\\\"MainContent_RCCornerControl1_ddClass_ddClassMaster\\\"]/div/table/tbody/tr/td[2]/img")
    WebElement clas; 
    
    @FindBy(how=How.LINK_TEXT, using="Class 10")
    WebElement clas10;

 	
 	@FindBy(how=How.XPATH, using="//*[@id=\\’MainContent_RCCornerControl1_ddClass_ddClassMaster\\’]/div/table/tbody/tr/td[2]/img") 
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
		
	@FindBy(how=How.LINK_TEXT, using="Class 10")
    WebElement class10;
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_FileUploadPopup2_FromDate_txtDate']")
 	WebElement FromDate; 
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_FileUploadPopup2_ToDate_txtDate']")
 	WebElement ToDate; 
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_FileUploadPopup2_txtFileName']")
 	WebElement DisplayName; 
	
	@FindBy(how=How.XPATH, using="//textarea[@id='MainContent_FileUploadPopup2_txtDesc']")
 	WebElement Description; 
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_FileUploadPopup2_Browse1_TxtBrowseFile']")
 	WebElement BrowseFile; 
	
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_FileUploadPopup2_btnSubmit']")
 	WebElement Submit; 
	
	
        // Defining all the user actions (Methods) that can be performed in the Facebook home page
 	
 public void btnlinksSCCCorner(){
	 SCCCorner.click();
	   try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } 
	   SCCCorner.click();
		 
 }
 
 public void selectClass(String cls){
	 clas.sendKeys(cls);
 }
 
 public void SelYea(){
	 Year.click();
	// SelYear.click();
 }
 
 public void setStudentName(String StuName){
	 StudName.clear();
	 StudName.sendKeys(StuName);
 }
 
 public void setSearch(){
 Search.clear();
 Search.sendKeys();
}
 
 public void FromDate(String ToDa){
 ToDate.clear();
 ToDate.sendKeys(ToDa);
} 
    public void ToDate(String FromDa){
    FromDate.clear();
    FromDate.sendKeys(FromDa);
 }
 
      
     public void DisplayName(String Display){
    	 DisplayName.clear();
    	 DisplayName.sendKeys(Display);
 }
 
     public void Description(String Descrip){
    	 Description.clear();
    	 Description.sendKeys(Descrip);
 }
 
 
 
     public void BrowseFile(){
     BrowseFile.clear();
     BrowseFile.sendKeys();
 }
 
 
     public void submit(){
     Submit.click();
 }
}