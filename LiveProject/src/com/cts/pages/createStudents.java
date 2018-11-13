package com.cts.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class createStudents {
 
 WebDriver driver;
 
 public createStudents(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT, using="Students") 
 	WebElement createStudents; 
 	
 	//@FindBy(how=How.XPATH, using="//a[contains(text(),'Create New')]") 
 	//WebElement createNEW; 
 	////a[contains(text(),'Add)]
 	@FindBy(how=How.XPATH, using="//*[@id='Button1']") 
 	WebElement Add; 
 	
 	@FindBy(how=How.XPATH, using="//*[@id='MainContent_AddStudent1_FormView1_NameTextBox1']") 
 	WebElement UserName; 
 	 	
 	@FindBy(how=How.XPATH, using="//table[@class='igdd_ControlArea']//tbody//tr")
 	WebElement clas; 
		 	
	@FindBy(how=How.XPATH, using="//table[@class='igdd_ControlArea']//input[@type='text']")
 	WebElement Section; 
	
	@FindBy(how=How.XPATH, using="//*[@id='MainContent_AddStudent1_FormView1_SASRemotIDTextBox1']")
 	WebElement RemoteNumber; 
	
	@FindBy(how=How.XPATH, using="//*[@id='MainContent_AddStudent1_FormView1_RollNoTextBox1']")
 	WebElement RollNumber; 
	
	@FindBy(how=How.XPATH, using="//*[@id='MainContent_AddStudent1_FormView1_InsertButton']")
 	WebElement AddSubmit; 
	
//	@FindBy(how=How.XPATH, using="//table[@class='igdd_ControlArea']//tbody//tr")
// 	WebElement clas; 
	
	
	
	/*@FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(5) a")
    @CacheLookup
    private WebElement class1;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(14) a")
    @CacheLookup
    private WebElement class10;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(15) a")
    @CacheLookup
    private WebElement class11;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(16) a")
    @CacheLookup
    private WebElement class12;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(6) a")
    @CacheLookup
    private WebElement class2;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(7) a")
    @CacheLookup
    private WebElement class3;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(8) a")
    @CacheLookup
    private WebElement class4;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(9) a")
    @CacheLookup
    private WebElement class5;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(10) a")
    @CacheLookup
    private WebElement class6;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(11) a")
    @CacheLookup
    private WebElement class7;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(12) a")
    @CacheLookup
    private WebElement class8;

    @FindBy(css = "#MainContent_AddStudent1_FormView1_ClassSectionSelection1_ddClassMaster div div div.igdd_DropDownListContainer. div ul.igdd_DropDownList. li:nth-of-type(13) a")
    @CacheLookup
    private WebElement class9;*/
        // Defining all the user actions (Methods) that can be performed in the Facebook home page
 	

	public void btnlinksadd(){
		 createStudents.click();
		   try {
	           Thread.sleep(3000);
	       } catch (InterruptedException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       } 
		   Add.click();
			 
	 }

	 public void setUsrName(String UsrNme){
		 UserName.clear();
		 UserName.sendKeys(UsrNme);
	 }
	 


 public void setUsrRemoteNo(String remote){
	 	RemoteNumber.clear();
	 	RemoteNumber.sendKeys(remote);
 }

 public void setUsrRollNo(String roll){
	 RollNumber.clear();
	 RollNumber.sendKeys(roll);
 }
 
 public void selectClass(String cls){
	 //clas.clear();
	 clas.sendKeys(cls);
 } 
 
 public void setUsrSec(String Sec){
	 //Select section = new Select(Section);
	 //section.selectByVisibleText(Sec);
	 Section.sendKeys(Sec);
 }
 public void submit(){
	 AddSubmit.click();
 }
}