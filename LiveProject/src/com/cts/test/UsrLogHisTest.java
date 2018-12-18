package com.cts.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.cts.pages.ctsLoginpage;
import com.cts.pages.userLoginHistory;


public class UsrLogHisTest extends ctsBase{
	
	
	@Test(priority=1)
	public void init() throws Exception{
			//driver.get("https://www.facebook.com");
		ctsLoginpage loginpage = PageFactory.initElements(driver, ctsLoginpage.class);
			loginpage.setUsrID("admin");
			loginpage.setPass("qa@123");
			loginpage.btnClick();
			}
	
	@Test(priority=2)
	public void cuserloginhistory1() throws Exception{
		userLoginHistory cuserloginhistory = PageFactory.initElements(driver, userLoginHistory.class);
		//cStudent.btnlinks();
		cuserloginhistory.btnlinks();
		cuserloginhistory.duration();
		cuserloginhistory.go();
	}
	
	/*@Test(priority=2)
	public void cuserloginhistory() throws Exception{
		userLoginHistory cuserloginhistory = PageFactory.initElements(driver, userLoginHistory.class);
		//cStudent.btnlinks();
		cuserloginhistory.btnlinks();
		cuserloginhistory.duration();
		cuserloginhistory.month();
		cuserloginhistory.year();
		cuserloginhistory.go();
	}*/
}
