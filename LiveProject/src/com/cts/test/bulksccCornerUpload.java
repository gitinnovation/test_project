package com.cts.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.util.repo.automationFunctions;

public class bulksccCornerUpload extends ctsBase{

	ctsRegression alltest = new ctsRegression();
	automationFunctions af = new automationFunctions();
	
	@Test(priority=1)
	public void login() throws Exception
	{
	alltest.login();
	}
	
	@Test(priority=2,  dataProvider = "sccUpload")
	public void bulkStudentCreation(String Class, String from_Date, String to_Date, String display_Name, String Description,String Locate_File) throws Exception 
	{
			alltest.SCCCorners( Class,  from_Date,  to_Date,  display_Name,  Description, Locate_File);
				}
	
	@DataProvider(name = "sccUpload")
	public Object[][] studentData() throws Exception 
	{

		return af.readXLSX("D:\\Automation\\AutoitScripts\\Automation\\eclipse-jee-neon-R-win32\\eclipse\\workspace\\LiveProjects\\src\\SCC_DATA.xlsx", "SCC_DATA");
	}

}

