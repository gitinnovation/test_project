package com.ef.test;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ef.pages.createTeacher;
import com.ef.pages.efLoginpage;



public class Tests extends tetsBase{

	
	@Test(priority=1)
	public void init() throws Exception{
			//driver.get("https://www.facebook.com");
	 	efLoginpage loginpage = PageFactory.initElements(driver, efLoginpage.class);
			loginpage.setUsrID("admin");
			loginpage.setPass("admin@1");
			loginpage.btnClick();
			
			}
	
	@Test(priority=2)
	public void cTeacher() throws Exception{
		createTeacher cTeacher = PageFactory.initElements(driver, createTeacher.class);
		cTeacher.btnlinks();
		cTeacher.setUsrID("shiva.class3");
		cTeacher.setUsrName("Shiva Sharma1");
		cTeacher.setUsrPassword("shivashr@1");
		cTeacher.selectClass();	
		cTeacher.submit();
			}

}