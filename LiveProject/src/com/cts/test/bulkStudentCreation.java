package com.cts.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.util.repo.automationFunctions;

public class bulkStudentCreation extends ctsBase{

	ctsRegression alltest = new ctsRegression();
	automationFunctions af = new automationFunctions();
	
	@Test(priority=1)
	public void login() throws Exception
	{
	alltest.login();
	}
	
	@Test(priority=2,  dataProvider = "cStudents")
	public void bulkStudentCreation(String sName, String sClass, String sSection, @Optional String sRemoteno, String sRollno) throws Exception 
	{
			alltest.cStudent(sName, sClass, sSection, sRemoteno, sRollno);
			//alltest.cStudent("Kelila Verna", "Class 1", "A", "13", "1");
	}
	
	@DataProvider(name = "cStudents")
	public Object[][] studentData() throws Exception 
	{
		return af.readXLSX("D:\\Automation\\AutoitScripts\\Automation\\eclipse-jee-neon-R-win32\\eclipse\\workspace\\LiveProjects\\src\\Student_8D.xlsx", "STUDENT_DATA");
	}

}