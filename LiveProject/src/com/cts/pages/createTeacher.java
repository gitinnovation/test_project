package com.ef.pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class createTeacher {
 
 WebDriver driver;
 
 public createTeacher(WebDriver driver){ 
                 this.driver=driver; 
        }
 
 //Using FindBy for locating elements class="form-control"

 	@FindBy(how=How.LINK_TEXT, using="Teacher") 
 	WebElement createTeacher; 
 	
 	@FindBy(how=How.XPATH, using="//input[@id='Button1']") 
 	WebElement createNEW; 
 	////a[contains(text(),'Create New')]
 	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddTeacher1_Wizard1_UserMasterAddEdit1_UsrIDTextBox1']") 
 	WebElement UserId; 
 	
 	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddTeacher1_Wizard1_UserMasterAddEdit1_UsrNameTextBox1']") 
	WebElement UserName; 
 	
 	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddTeacher1_Wizard1_UserMasterAddEdit1_UsrPasswordTextBox']")
 	WebElement UsrPassword; 
 	
 	@FindBy(how=How.XPATH, using="//label[@for='MainContent_AddTeacher1_Wizard1_BoardCheckBoxList1_RadioButtonList1_0']")
 	WebElement selectBoard; 
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddTeacher1_Wizard1_BoardCheckBoxList1_cbl_Boards_2']")
 	WebElement selectCBSE;
 	
	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddTeacher1_Wizard1_StartNavigationTemplateContainerID_btnStartNext']")
        WebElement selectNext;

	@FindBy(how=How.XPATH, using="//label[@for='MainContent_AddTeacher1_Wizard1_ClassCheckBoxList1_RadioButtonList1_0']")
 	WebElement selectClasses;
 	
	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddTeacher1_Wizard1_ClassCheckBoxList1_cbl_Classes_4']")
 	WebElement selectClass_second;

	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddTeacher1_Wizard1_StepNavigationTemplateContainerID_StepNextButton']")
 	WebElement selectStepNext;

	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddTeacher1_Wizard1_SubjectCheckBoxList1_RadioButtonList1_0']")
 	WebElement selectSubjects;

	@FindBy(how=How.XPATH, using="//input[@id='MainContent_AddTeacher1_Wizard1_FinishNavigationTemplateContainerID_FinishButton']']")
 	WebElement selectFinish;

	// @FindBy(how=How.XPATH, using="//input[@id='MainContent_AddPrincipal1_btnSave']")
 	 // WebElement Submit; 
        // Defining all the user actions (Methods) that can be performed in the Facebook home page
 	
 public void btnlinks(){
	createTeacher.click();
	   try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } 
		 createNEW.click();
		 
 }
 
 public void setUsr_ID(String sUSRID){
	 UserId.clear();
	 UserId.sendKeys(sUSRID);
 }
 public void setUsr_Name(String UsrNme){
	 UserName.clear();
	 UserName.sendKeys(UsrNme);
 }
 
 public void setUsr_Password(String passWord){
	 UsrPassword.clear();
	 UsrPassword.sendKeys(passWord);
 }
 
 /*public void selectClass(){
	 classCheckbox.click();
 }*/

 public void select_Board(){
	selectBoard.click();
 }

  public void select_CBSE(){
	selectCBSE.click();
 }
 
 public void select_Next(){
	selectNext.click();
 }

 public void select_Classes(){
	selectClasses.click();
 }


 public void  selectStep_Next(){
	 selectStepNext.click();
 }

 public void  select_Subjects(){
	selectSubjects.click();
 }

 public void  Finish(){
	selectFinish.click();
 }

 /*public void submit(){
	 Submit.click();
 }*/
}