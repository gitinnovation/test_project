package com.cts.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.cts.pages.createPrincipal;
import com.cts.pages.createStudents;
import com.cts.pages.ctsLoginpage;

public class ctsTests extends ctsBase{

	
	@Test(priority=1)
	public void init() throws Exception{
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
	public void cStudent() throws Exception{
		createStudents cStudent = PageFactory.initElements(driver, createStudents.class);
		//cStudent.btnlinks();
		cStudent.btnlinksadd();
		cStudent.setUsrName("Shiva Sharma1");
		cStudent.selectClass("Class 5");
		cStudent.setUsrSec("A");
		cStudent.setUsrRemoteNo("3");
		cStudent.setUsrRollNo("3");
		cStudent.submit();
			}

}