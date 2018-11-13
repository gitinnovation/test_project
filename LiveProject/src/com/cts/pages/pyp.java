package com.cts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class pyp {
	
	WebDriver driver;
	 
	 public pyp(WebDriver driver){ 
	                 this.driver=driver; 
	 
	 }               
	                 @FindBy(how=How.LINK_TEXT, using="Previous Year Question Paper") 
	         		WebElement LINK;
	                 
	                 @FindBy(how=How.XPATH, using="//input[@value='Upload New File']") 
	              	WebElement UploadButton;
	                 
	                 @FindBy(how=How.XPATH, using="//input[@value='[Select Class]']") 
	         		WebElement selectclass;
	         		
	         		@FindBy(how=How.XPATH, using="//input[@id='MainContent_FileUploadPopup2_FromDate_txtDate']") 
	         		WebElement fromdate;
	         		
	         		@FindBy(how=How.XPATH, using="//input[@id='MainContent_FileUploadPopup2_ToDate_txtDate']")
	         		WebElement todate;
	         		
	         		@FindBy(how=How.ID, using="MainContent_FileUploadPopup2_txtFileName") 
	         		WebElement displayname;
	         		
	         		@FindBy(how=How.ID, using="MainContent_FileUploadPopup2_txtDesc") 
	         		WebElement description;
	         		
	         		@FindBy(how=How.ID, using="MainContent_FileUploadPopup2_Browse1_TxtBrowseFile")
	         		WebElement browse;
	         		
	         		@FindBy(how=How.ID, using="MainContent_FileUploadPopup2_btnSubmit")
	         		WebElement submit;

	                 public void btnlinks(){
	         	 		LINK.click();
	         	 		   try {
	         	 	           Thread.sleep(3000);
	         	 	       } catch (InterruptedException e) {
	         	 	           // TODO Auto-generated catch block
	         	 	           e.printStackTrace();
	         	 	       } 
	         	 		}
	                 
	                 public void upload(){
	                	 UploadButton.click();
	                 }
	                public void selectclass(){
	                	selectclass.clear();
	                	selectclass.sendKeys("Pre Nursery");
	                }
		            public void fromdate(){
		            	//fromdate.clear();
		            	fromdate.sendKeys("11/10/2018");
		            }
			        public void todate(){
			        	//todate.clear();
			        	todate.sendKeys("11/12/2018");
			        }
				    public void sdisplayname(String sdisp){
				    	displayname.clear();
				    	displayname.sendKeys(sdisp);
				    }
					public void sdescription(String sdesc){
						description.clear();
						description.sendKeys(sdesc);
					}
					public void browse(){
						browse.click();
					}
					public void submit(){
						submit.click();
					}
}
