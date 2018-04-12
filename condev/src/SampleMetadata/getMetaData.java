package SampleMetadata;

import java.util.concurrent.TimeUnit;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class getMetaData {
	private WebDriver driver;
	  private String baseUrl;
	//  private boolean acceptNextAlert = true;
	//  private StringBuffer verificationErrors = new StringBuffer();
	  String Metadata1="";
	//  String Metadata2="";
	  int rowindex=1;
	//static String xlpath="D:\\Automation\\SampleMetadata.xlsx";
	static String xlpath="D:\\inder_shared\\Utilities\\KeywordGeneration\\logs\\20180409_test\\Success.xlsx";
	static String xlsheet="Success";
	 

 @BeforeTest(alwaysRun = true)
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://textalyser.net";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		 }
	
	@DataProvider(name = "Input_DATA")
	public static Object[][] readExcel() throws Exception {
		readExcel re = new readExcel();
		return re.readXLSX(xlpath, xlsheet);
	}

	
	@Test(priority = 1, dataProvider = "Input_DATA")
	public void enterTxt(@Optional String Sno, @Optional String CMSID, @Optional String DisplayName, @Optional String Type,@Optional String Subject,@Optional String DBKeywords, String FileKeywordsMethod1,String FileKeywordsMethod2, String Frame, @Optional String Result,@Optional String NewKeywordsMethod1,@Optional String NewKeywordsMethod2) throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/form/textarea")).clear();
		driver.findElement(By.xpath("/html/body/form/textarea")).sendKeys(FileKeywordsMethod1);
		driver.findElement(By.xpath("/html/body/form/input")).click();
		 //Get number of rows In table.
		// int Row_count = driver.findElements(By.xpath("//table[9]//following-sibling::tr[1]/td[1]")).size();
		 List<WebElement> metadata1=driver.findElements(By.xpath("//table[9]//following-sibling::tr[1]/td[1]"));
		 for (WebElement webElement : metadata1) {
	            
	            Metadata1=Metadata1+webElement.getText()+", ";
	        }
		 
		/* 
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("/html/body/form/textarea")).clear();
		 driver.findElement(By.xpath("/html/body/form/textarea")).sendKeys(FileKeywordsMethod2);
		 driver.findElement(By.xpath("/html/body/form/input")).click();
	     //Get number of rows In table.
		 // int Row_count = driver.findElements(By.xpath("//table[9]//following-sibling::tr[1]/td[1]")).size();
	     List<WebElement> metadata2=driver.findElements(By.xpath("//table[9]//following-sibling::tr[1]/td[1]"));
		 for (WebElement webElement : metadata2) {
		            
		            Metadata2=Metadata2+webElement.getText()+", ";
		 }
		 
		*/
		 
		WriteExcel write= new WriteExcel();
		//write.writeXLSX(xlpath, xlsheet, Metadata1,Metadata2, rowindex, 10,11);
		write.writeXLSX(xlpath, xlsheet, Metadata1, rowindex, 10);
		//write.writeXLSX(xlpath, "Sheet1",Metadata,  rowindex, 5);
		rowindex=rowindex+1;

	    Metadata1="";
	  //  Metadata2="";
	}
	
	 @AfterTest
	 public void tearDown() throws Exception { 

	   driver.quit();
	     } 
}
