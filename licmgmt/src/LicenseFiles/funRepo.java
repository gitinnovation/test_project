package LicenseFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class funRepo {
	//define an Excel Work Book
	  HSSFWorkbook workbook;
	  //define an Excel Work sheet
	  HSSFSheet sheet;
	  //define a test result data object
	  Map<String, Object[]> testresultdata;
	
  /*	static{
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        System.setProperty("current.date.time", dateFormat.format(new Date()));
    }  */

	//private static Logger Log = Logger.getLogger(funRepo.class.getName());
	  
	  public void DefineExcelReport()
	  {
		//create a new work book
	      workbook = new HSSFWorkbook();
	      //create a new work sheet
	       sheet = workbook.createSheet("Test Result");
	      testresultdata = new LinkedHashMap<String, Object[]>();
	      //add test result excel file column header
	      //write the header in the first row
	      testresultdata.put("1", new Object[] {"Test Case Id", "ERP Code", "Server ID","ETECCount","ImplementedETEC","ContentETEC","HardwareETEC","ServiceETEC","AMCETEC","Expected Result","Actual Result", "QA Status"});
	      
	  }
	public  void loGin(Properties P, WebDriver driver) throws Exception  
	{
		
		//DOMConfigurator.configure("log4j.xml");
	//	Log.info("Initiate the Browser");
		driver.get(P.getProperty("url"));
	//	Log.info("Navigate to FGR Login page");
	    Thread.sleep(1000);
		Thread.sleep(1000);
	
		enterText(driver,P.getProperty("txtUserName"), P.getProperty("UserName"));
		enterText(driver,P.getProperty("txtPassword"), P.getProperty("Password"));
		clickBtn(driver, P.getProperty("btnLogin"));

	 }
	
	
	 public void ERPServerLinkage(Properties P, WebDriver driver,String ServerID,String ChildERPCode) throws Exception
	  {
		       clickLink(driver, "School Info");
		       // driver.findElement(By.linkText("School Info")).click();
			   Thread.sleep(1000);
			   
			   SelectOptions(driver,P.getProperty("DDSrchBySchlID"),"School ID");
			   Thread.sleep(1000);
			   
			   enterText(driver,P.getProperty("txtSrchSchl"), ServerID);
			   Thread.sleep(1000);
			   
			   clickBtn(driver, P.getProperty("btnSrchSchl"));
			   Thread.sleep(5000);
			   driver.findElement(By.linkText("Edit")).click();  
			   Thread.sleep(1000);
			
			   enterText(driver,P.getProperty("tagChildERP"), ChildERPCode);
			   Thread.sleep(5000); 
			 
			   SelectOptions(driver,P.getProperty("DDCountry"),"KSA");
			// SelectOptions(driver,P.getProperty("DDCountry"),"KSA");
			   Thread.sleep(5000);
			   SelectOptions(driver,P.getProperty("DDCountry"),"India");
			//  new Select(driver.findElement(By.id(P.getProperty("DDCountry")))).selectByVisibleText("India");
               
			   SelectOptions(driver,P.getProperty("DDState"),"Delhi");
			   Thread.sleep(5000);
			    
			   SelectOptions(driver,P.getProperty("DDCity"),"Delhi");
			   Thread.sleep(5000);
			    
			   clickBtn(driver, P.getProperty("BtnTagSchl"));
			   Thread.sleep(5000);
	  }
	 
	 public void GenerateLic(Properties P, WebDriver driver,String TC_No, String ServerID, String ERPCode,String ETECCount,String Implemented,String ContentETEC, String HardwareETEC, String ServiceETEC, String AMCETEC, String ExpectedResult, String errortype,int rn) throws Exception
	 {
		//EditERP(ERP,LastQtr,Expry,CustomerStatus,ActiveExpiryStatus,ERPLicenseCategory,ContentEtec,lastUsageCheck,LastUsageDate);
		   String ActualResult="Null";
		   String RowNO=Integer.toString(rn);
		   rn= rn +1 ;

		    driver.findElement(By.linkText("School Info")).click();
		   String Schoolinfo= driver.getCurrentUrl();
		   if(Schoolinfo.equals(P.getProperty("url")+"/Support/SchoolMaster.aspx")) {
			   System.out.println("Passed  : Navigated to School info List");
			 //  testresultdata.put("3", new Object[] {2d, "navigate to school Info or School list", "School List is  fetched","Pass"});
		   }
		   else { 
			   System.out.println("Failed  : School List are not fetched out.");
			//   testresultdata.put("3", new Object[] {2d, "navigate to school Info or School list", "School List is not fetched","Fail"});
			   driver.close();
		   }
		   
		   new Select(driver.findElement(By.id(P.getProperty("DDSrchBySchlID")))).selectByVisibleText("School ID");
		   Thread.sleep(1000);
		   
		
		   enterText(driver,P.getProperty("txtSrchSchl"), ServerID);
		   Thread.sleep(1000);
		   
		   clickBtn(driver, P.getProperty("btnSrchSchl"));
		   Thread.sleep(5000);
		   
		   
		   driver.findElement(By.id(P.getProperty("lnkManageKey"))).click();
		    
		    String LicenseURL= driver.getCurrentUrl();
		    if(LicenseURL.equals(P.getProperty("url")+"/Support/DownloadEncryptionKey.aspx?ID="+ServerID))
		    {  
		      	driver.findElement(By.linkText("Mark as Invalid")).click();
		      	enterText(driver,P.getProperty("txtLicInvalid"), "test");
		      	clickBtn(driver, P.getProperty("BtnLicInvalid"));
			    
		    	System.out.println("License Invalid page");
		    	LicenseURL =driver.getCurrentUrl();
		    }
		    if(LicenseURL.equals(P.getProperty("url")+"/Support/newGenerateLicenceKey_Mod.aspx?ID="+ServerID+"&&opcode=l"))
		    {
		    	System.out.println("License Generation page");
		  
		    	//String QA_Status=null;   BtnGenLicKey
		    	                                                       
		    	Boolean IsEnableLicGenBtn = driver.findElements(By.id(P.getProperty("BtnGenLicKey"))).size() > 0 ;
		    	if(IsEnableLicGenBtn) {
		    		
		    		Boolean IsERPContractLevel = driver.findElements(By.id(P.getProperty("lblERPContrct"))).size() > 0 ;   // .isDisplayed();
		    		if(IsERPContractLevel)
		    		{ 
		    			//System.out.println("ERPContractLevel : "+IsERPContractLevel);
		    			System.out.println("License Allowed : But ERP Contract Is Expired");
		    			ActualResult  = driver.findElement(By.id(P.getProperty("lblERPContrct"))).getText();
		    		
		    			System.out.println("Alert Message : "+ActualResult);
		    			
		    			 // if(ActualResult.equals(ExpectedResult))
		    				//  QA_Status="PASS";
		    			 // else 
		    			//	  QA_Status="FAIL";
		    				  
		    			TestResult(RowNO,TC_No,ERPCode,ServerID,ETECCount,Implemented,ContentETEC,HardwareETEC,ServiceETEC,AMCETEC,ExpectedResult,ActualResult);
		    			//  Assert.assertEquals(ActualResult, ExpectedResult);
		    			
		    		}
		    		else {
		    			
		    		//OS Selection
		    	    new Select(driver.findElement(By.id(P.getProperty("DD_OSSelection")))).selectByVisibleText("Windows");
		    	    
		    	    //Force Reset
		    	    clickBtn(driver, P.getProperty("rdBtnForceReset"));
			      

			        clickBtn(driver, P.getProperty("BtnGenLicKey"));
		    		Thread.sleep(5000);
		    		
		    		Boolean IsContentEtec = driver.findElement(By.xpath(P.getProperty("lblContentEtec"))).isDisplayed();   
		    		if(IsContentEtec)
		    		{
		    			
		    		    ActualResult  = driver.findElement(By.xpath(P.getProperty("lblContentEtec"))).getText();
		    		    System.out.println("Alert Message : "+ActualResult);
		    		    TestResult(RowNO,TC_No,ERPCode,ServerID,ETECCount,Implemented,ContentETEC,HardwareETEC,ServiceETEC,AMCETEC,ExpectedResult,ActualResult);
		    		}
		    		else 
		    		{
		    			//ctl00_ContentPlaceHolder1_hlDownload
		    			//Boolean IsLicExportbtn = driver.findElements(By.id("ctl00_ContentPlaceHolder1_Licencegenerate1_btnUpload")).size() > 0;
		    			Boolean IsLicExportbtn = driver.findElements(By.id(P.getProperty("BtnExportLicKey"))).size() > 0;
		    			if(IsLicExportbtn)
		    			{
		    				System.out.println("License Generated Successfully........");
		    				ActualResult="License Generated Successfully........";
		    				TestResult(RowNO,TC_No,ERPCode,ServerID,ETECCount,Implemented,ContentETEC,HardwareETEC,ServiceETEC,AMCETEC,ExpectedResult,ActualResult);
		    			}
		    			else
		    			{
		    				System.out.println("Timeout issue");
		    				ActualResult="Timeout Issue";
		    				TestResult(RowNO,TC_No,ERPCode,ServerID,ETECCount,Implemented,ContentETEC,HardwareETEC,ServiceETEC,AMCETEC,ExpectedResult,ActualResult);
		    			}
		    				
		    		}
		    	 
		    		}
		    		
		    		}
		    		
		    		
		    		
		    	else 
		    	{	
		    		System.out.println("License not allowed to the school");
		    		                                                    
		    	    ActualResult =driver.findElement(By.xpath(P.getProperty("lblLicRenewal"))).getText();
		    	    System.out.println("Alert Message : "+ActualResult);

		    	  TestResult(RowNO,TC_No,ERPCode,ServerID,ETECCount,Implemented,ContentETEC,HardwareETEC,ServiceETEC,AMCETEC,ExpectedResult,ActualResult);  

		    	}
		    	  
		    }
		  //  driver.close();
		    System.out.println("");
	 }

	
	public void enterText(WebDriver driver, String Element, String Input)
	{
		driver.findElement(By.id(Element)).clear();
	    driver.findElement(By.id(Element)).sendKeys(Input);
	    
	}
	
	public void SelectOptions(WebDriver driver, String Element, String input)
	{
		 new Select(driver.findElement(By.id(Element))).selectByVisibleText(input);
		 
	    
	}
	
	public void clickBtn(WebDriver driver, String Btn)
	{
	    driver.findElement(By.id(Btn)).click();
	}
	
	public void clickLink(WebDriver driver, String link)
	{
	    driver.findElement(By.linkText(link)).click();
	}
	
	public void TestResult(String RowNO, String TC_No,String ERPCode,String ServerID,String ETECCount,String Implemented,String ContentETEC, String HardwareETEC, String ServiceETEC, String AMCETEC, String ExpectedResult,  String ActualResult)
	{
		String QA_Status="NULL";
		if(ActualResult.equals(ExpectedResult))
  				  QA_Status="PASS";
  			  else 
  				QA_Status="FAIL";
		testresultdata.put(RowNO, new Object[] {TC_No,ERPCode,ServerID,ETECCount,Implemented,ContentETEC,HardwareETEC,ServiceETEC,AMCETEC,ExpectedResult,ActualResult,QA_Status});
	}
	
	/*
 public void EditERP(String ERP, String LastQtr, String Expry, String CustomerStatus, String ActiveExpiryStatus, String ERPLicenseCategory, String ContentEtec,String lastUsageCheck, String LastUsageDate) throws Exception {
         
		 driver.get(baseUrl+"/ERP/ERPMaster.aspx");
		  Thread.sleep(1000);
		  
		
		  
		  driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtERPCodeID")).clear();
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtERPCodeID")).sendKeys(ERP);
		    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnGetSearchData")).click();
		    Thread.sleep(5000);
			   
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastQtr")).clear();
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastQtr")).sendKeys(LastQtr);
			    Thread.sleep(500);
			    
			    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlCustomerStatus"))).selectByVisibleText(CustomerStatus);
			    Thread.sleep(5000);
			    
	
			    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlErpLicCategory"))).selectByVisibleText(ERPLicenseCategory);
			    Thread.sleep(1000);
			    
			    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlActiveExpiryStatus"))).selectByVisibleText(ActiveExpiryStatus);
			    Thread.sleep(1000);
			    
			//    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSchoolLicCategory"))).selectByVisibleText(SchoolLicenseCategory);
			//    Thread.sleep(1000);
			    
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_sdsContractExpiry_WebDateChooser_input")).clear();
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_sdsContractExpiry_WebDateChooser_input")).sendKeys(Expry);
			    Thread.sleep(500);
			    
			   driver.findElement(By.id("ctl00_ContentPlaceHolder1_txteteccontent")).clear();
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txteteccontent")).sendKeys(ContentEtec);
			    
			    Thread.sleep(500);
			    
			    
			    WebElement element=driver.findElement(By.id("ctl00_ContentPlaceHolder1_Chklastusagedate"));
			    
			    if(lastUsageCheck.equalsIgnoreCase("true")) {  
			   // if(lastUsageCheck.equals("true") {
			    if(element.isSelected()) {
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_dtLastUsageDate_WebDateChooser_input")).clear();
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_dtLastUsageDate_WebDateChooser_input")).sendKeys(LastUsageDate);
			    
			    }
			    else
			    {
			    	driver.findElement(By.id("ctl00_ContentPlaceHolder1_Chklastusagedate")).click();
			    	Thread.sleep(1000);
			    	driver.findElement(By.id("ctl00_ContentPlaceHolder1_dtLastUsageDate_WebDateChooser_input")).clear();
			    	driver.findElement(By.id("ctl00_ContentPlaceHolder1_dtLastUsageDate_WebDateChooser_input")).sendKeys(LastUsageDate);
	             }
			    }
			    
			    else
			    {
			    	if(element.isSelected()) {
			    		driver.findElement(By.id("ctl00_ContentPlaceHolder1_Chklastusagedate")).click();
					    
					    }
			    }
			    
			    
			    Thread.sleep(10000);
			    
			    driver.findElement(By.id("ctl00_ContentPlaceHolder1_BtnSaveClickViewPanel")).click();
			    Thread.sleep(2000);
		//	String msg= driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_sAlerts_pnlError']/div/div")).getText();
			//   System.out.println(msg);
		 
     }  */
	
	

	public void GenerateExcelReport() {
		Set<String> keyset = testresultdata.keySet();
	    int rownum = 0;
	    for (String key : keyset) {
	        Row row = sheet.createRow(rownum++);
	        Object [] objArr = testresultdata.get(key);
	        int cellnum = 0;
	        for (Object obj : objArr) {
	            Cell cell = row.createCell(cellnum++);
	            if(obj instanceof Date) 
	                cell.setCellValue((Date)obj);
	            else if(obj instanceof Boolean)
	                cell.setCellValue((Boolean)obj);
	            else if(obj instanceof String)
	                cell.setCellValue((String)obj);
	            else if(obj instanceof Double)
	                cell.setCellValue((Double)obj);
	        }
	    }
	    try {
	        FileOutputStream out =new FileOutputStream(new File("TestResult.xls"));
	        workbook.write(out);
	        out.close();
	        System.out.println("Excel written successfully..");
	         
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}

	
	
	

}
