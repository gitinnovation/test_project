package com.cts.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class conrepdate {
 
 WebDriver driver;
 
 public conrepdate(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT, using="Content Usage MIS Report Date wise") 
 	WebElement clickrep; 
 	
 	@FindBy(how=How.XPATH, using="//input[@value='Monthly']") 
 	WebElement datetype; 
 	////a[contains(text(),'Create New')]

 	@FindBy(how=How.XPATH, using="//img[contains(@data-ig,'x:482398686.4:mkr:ButtonImage')]") 
 	WebElement month; 
 	
    @FindBy(how=How.LINK_TEXT, using="Oct - Dec")
    WebElement mm;
 	
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
	 from.click();
	 from.sendKeys("11/1/2018");
	 //to.clear();
	 to.click();
	 to.sendKeys("11/1/2018");
	 //month.click();
	 //mm.clear();
	 //mm.sendKeys("Oct - Dec");
	 //mm.click();
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