package com.cts.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.util.repo.automationFunctions;

//import LiveProject.QuestionTagging;

public class bulkUrlTest {
 static{
	        
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	        System.setProperty("current.date.time", dateFormat.format(new Date()));
	    }
	 
	automationFunctions af=new automationFunctions();
	private static Logger Log = Logger.getLogger(bulkUrlTest.class.getName());
	
	@Test(priority=2,  dataProvider = "urllist")
	public void bulkStudentCreation( String cdsid, String urls) throws Exception 
	{
		DOMConfigurator.configure("log4j.xml");
		URL url = new URL(urls);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();

		int code = connection.getResponseCode();
		Log.info(cdsid+" >>>  " +urls+"  >>> Response code  >>>"+code);
		System.out.println(cdsid+"  >>>  " +urls+"  >>> Response code  >>>"+code);
	}
	
	@DataProvider(name = "urllist")
	public Object[][] studentData() throws Exception 
	{
		return af.readXLSX("D:\\QA\\workspace\\LiveProjects\\src\\URLNodeText.xlsx", "Sheet1");
	}

}