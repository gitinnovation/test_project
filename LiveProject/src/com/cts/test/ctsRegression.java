package com.cts.test;

import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.cts.pages.createPrincipal;
import com.cts.pages.createStudents;
import com.cts.pages.ctsLoginpage;
import com.cts.pages.SCCCorner;
import com.cts.pages.curDateWise;
import com.cts.pages.pyp;
import com.util.repo.automationFunctions;

public class ctsRegression extends ctsBase{
	
	@Test(priority=1)
	public void login() throws Exception{
			//driver.get("https://www.facebook.com");
		ctsLoginpage loginpage = PageFactory.initElements(driver, ctsLoginpage.class);
			loginpage.setUsrID("admin");
			loginpage.setPass("qa@123");
			loginpage.btnClick();
			}
	
	
	@Test(priority=2)
	public void cPrincipal() throws Exception{
		createPrincipal cPrincipal = PageFactory.initElements(driver, createPrincipal.class);
		cPrincipal.btnlinks();
		cPrincipal.setUsrID("shiva.class3");
		cPrincipal.setUsrName("Shiva Sharma1");
		cPrincipal.setUsrPassword("shivashr@1");
		//cPrincipal.selectClass();	
		cPrincipal.submit();
			}
	
	@Test(priority=3)
	public void cStudent(String sName,String sClass, String sSection, String sRemoteno, String sRollno) throws Exception
	{
		createStudents cStudent = PageFactory.initElements(driver, createStudents.class);
		cStudent.btnlinksadd();
		cStudent.setUsrName(sName);
		cStudent.selectClass(sClass);
		Thread.sleep(1000);
		cStudent.setUsrSec(sSection);
		Thread.sleep(1000);
		cStudent.setUsrRemoteNo(sRemoteno);
		Thread.sleep(1000);
		cStudent.setUsrRollNo(sRollno);
		cStudent.submit();
		}
	
	@Test(priority=2)
	public void curDateWise() throws Exception{
		curDateWise crd=PageFactory.initElements(driver, curDateWise.class);
		crd.btnlinks();
		crd.seldatetype();
		crd.FromDate("2016", "Dec", "1");
		crd.ToDate("2018", "Dec", "3");
		crd.gob();
		crd.nextpage();
	}

	@Test(priority=2)
    public void SCCCorners(String Class,String fd, String td,String display_Name, String Description,String Locate_File) throws Exception{
    SCCCorner cSCCCorner = PageFactory.initElements(driver, SCCCorner.class);
    cSCCCorner.btnlinksSCCCorner();
    cSCCCorner.uploadNewFile();
    cSCCCorner.selectClass(Class);
    Thread.sleep(5000);
    String[] fdd = fd.split("-", 3);
    String[] tdd = td.split("-", 3);
    cSCCCorner.FromDate(fdd[0],fdd[1],fdd[2]);
    cSCCCorner.ToDate(tdd[0], tdd[1], tdd[2]);
    cSCCCorner.DisplayName(display_Name);
    cSCCCorner.Description(Description);
    cSCCCorner.browseFile(Locate_File);
    cSCCCorner.submit();
           }

	

}