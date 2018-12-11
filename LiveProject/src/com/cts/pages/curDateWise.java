package com.cts.pages;
 
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.util.repo.automationFunctions;

import org.openqa.selenium.interactions.Actions;
//import com.cts.test.Actions;

public class curDateWise {
 
 WebDriver driver;
 static Properties Pro;
 public curDateWise(WebDriver driver) throws IOException{ 
                 //this.driver=driver; 
                 this.driver=driver; 
                 Pro =  af.getObjectRepository("\\src\\com\\util\\repo\\userLoginHisto.properties");
        
        }
 
 //Using FindBy for locating elements class="form-control"
 automationFunctions af=new automationFunctions(); 
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Reports')]") 
	WebElement Report; 
 
 	//@FindBy(how=How.LINK_TEXT, using="Content Usage MIS Report Date wise") 
	@FindBy(how=How.LINK_TEXT, using="Content Usage MIS Datewise") 
 	WebElement clickrep; 
 	
 	@FindBy(how=How.XPATH, using="//input[@value='Monthly']") 
 	WebElement datetype; 
 	////a[contains(text(),'Create New')]

 	@FindBy(how=How.XPATH, using="//img[contains(@data-ig,'x:482398686.4:mkr:ButtonImage')]") 
 	WebElement month; 
 	
    @FindBy(how=How.LINK_TEXT, using="Oct - Dec")
    WebElement mm;
  //input[@id='']
	@FindBy(how=How.XPATH, using="//*[@id='MainContent_ContentUsageReportDatewise1_gDateRange1_BetweenSelect_SingleDateSelectorStartDate_ImageButton1']") 
	WebElement calender_Start;
	
	@FindBy(how=How.XPATH, using="//*[@id='MainContent_ContentUsageReportDatewise1_gDateRange1_BetweenSelect_SingleDateSelectorEndDate_ImageButton1']") 
	WebElement calender_End;
	
	@FindBy(how=How.XPATH, using="//div[@class='ajax__calendar_title']") 
	WebElement title_Start;

	@FindBy(how=How.XPATH, using="//div[@id='MainContent_ContentUsageReportDatewise1_gDateRange1_BetweenSelect_SingleDateSelectorEndDate_CalendarExtender1_title']") 
	WebElement title_End;
	
	
	
	
	//@FindBy(how=How.XPATH, using="//*[@id='MainContent_FileUploadPopup2_FromDate_ImageButton1']")
	@FindBy(how=How.ID, using="MainContent_ContentUsageReportDatewise1_gDateRange1_BetweenSelect_SingleDateSelectorStartDate_ImageButton1")
 	WebElement FromDate; 
											
	//@FindBy(how=How.XPATH, using="//*[@id='MainContent_FileUploadPopup2_ToDate_ImageButton1']")
	@FindBy(how=How.ID, using="MainContent_ContentUsageReportDatewise1_gDateRange1_BetweenSelect_SingleDateSelectorEndDate_ImageButton1")
 	WebElement ToDate; 
    
 	@FindBy(how=How.ID, using="MainContent_ContentUsageReportDatewise1_gDateRange1_BetweenSelect_SingleDateSelectorStartDate_txtDate") 
 	WebElement from; 
 	@FindBy(how=How.ID, using="MainContent_ContentUsageReportDatewise1_gDateRange1_BetweenSelect_SingleDateSelectorEndDate_txtDate") 
 	WebElement to; 
 	
 	@FindBy(how=How.ID, using="MainContent_ContentUsageReportDatewise1_GoButton") 
 	WebElement Go; 
 	@FindBy(how=How.ID, using="MainContent_ContentUsageReportDatewise1_GridView1_btnNext") 
 	WebElement np; 
 	
 	//@FindBy(how=How.XPATH, using="/html/body/section[2]/div[2]/form/fieldset/div/div[5]/label[1]")
 	//WebElement classCheckbox; 
 	
 public void btnlinks(){
	 //WebElement element = driver.findElement(By.linkText("Reports"));
	 
     Actions action = new Actions(driver);

     action.moveToElement(Report).build().perform();

     //driver.findElement(By.linkText("iPads")).click();
	 clickrep.click();
	   try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } 
 }
 
 public void seldatetype(){
	 datetype.clear();
	 datetype.sendKeys("Between");
	 //from.clear();
	 //from.click();
	 //from.sendKeys("11/1/2018");
	 //to.clear();
	 //to.click();
	 //to.sendKeys("11/1/2018");
	 //month.click();
	 //mm.clear();
	 //mm.sendKeys("Oct - Dec");
	 //mm.click();
 }
 public void FromDate(String Year,String month, String day) throws Exception{
	 //FromDate.click();
	 System.out.println(Pro.getProperty("curDTFrm_year")+"   ->    "+Pro.getProperty("curDTFrm_month")+"   ->    "+ Pro.getProperty("curDTFrm_day"));
	 af.calenderControl(driver,calender_Start,title_Start, Pro.getProperty("curDTFrm_year"), Pro.getProperty("curDTFrm_month"), Pro.getProperty("curDTFrm_day"), Year, month, day);
} 
public void ToDate(String Year,String month, String day) throws Exception{
	//ToDate.click();
	System.out.println("");
	af.calenderControl(driver,calender_End,title_End, Pro.getProperty("curDTTo_year"), Pro.getProperty("curDTTo_month"), Pro.getProperty("curDTTo_day"), Year, month, day);
 }
 public void gob(){
	 Go.click();
 }
 public void nextpage(){
	while(true)
	{
		if(np.isEnabled())
			 np.click();
		else
			break;
	}
 }
 
}