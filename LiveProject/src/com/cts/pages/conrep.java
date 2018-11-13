package com.cts.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class conrep {
 
 WebDriver driver;
 
 public conrep(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT, using="Content Usage MIS Report") 
 	WebElement clickrep; 
 	
 	@FindBy(how=How.ID, using="MainContent_ContentUsageReport1_drpUserList") 
 	WebElement selusr; 
 	////a[contains(text(),'Create New')]
 	@FindBy(how=How.ID, using="MainContent_ContentUsageReport1_btnGo") 
 	WebElement Go; 
 	
 	@FindBy(how=How.ID, using="MainContent_ContentUsageReport1_GridView1_btnNext") 
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
 
 public void selUsrID(String sUSRID){
	 Select dropdown= new Select(selusr);
	   dropdown.selectByVisibleText(sUSRID);
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