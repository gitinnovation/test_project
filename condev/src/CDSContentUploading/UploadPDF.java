package CDSContentUploading;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import operation.ReadObject;


import SampleMetadata.readExcel;

public class UploadPDF {
	
	WebDriver driver;
	ReadObject object=new ReadObject();
	Properties P;
	public UploadPDF() throws IOException
	{
		P =  object.getObjectRepository();
	}
	
	@BeforeTest(alwaysRun = true)
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver.exe");
		driver = new ChromeDriver();
		//baseUrl = "http://textalyser.net";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get(baseUrl);
		driver.get(P.getProperty("url")+"/Account/Login.aspx");
		enterText(driver,P.getProperty("txtUserName"), P.getProperty("UserName"));
		enterText(driver,P.getProperty("txtPassword"), P.getProperty("Password"));
		clickBtn(driver, P.getProperty("btnLogin"));
		 }
	
	private void clickBtn(WebDriver driver, String Btn) {
		 driver.findElement(By.id(Btn)).click();
		
	}

	private void enterText(WebDriver driver, String Element, String Input) {
		
		driver.findElement(By.id(Element)).clear();
	    driver.findElement(By.id(Element)).sendKeys(Input);
	}
	
	

 /*	@DataProvider(name = "Input_DATA")
	public static Object[][] readExcel() throws Exception {
		readExcel re = new readExcel();
		return re.readXLSX("ExcelPath", "Extracted");
	}  */
	
	//@Test(priority = 1, dataProvider = "Input_DATA")
	@Test(priority = 1)
	public void UploadContent() throws Exception
	{
		driver.get(P.getProperty("url")+"/Lessons/Elements/HomeAssignment.aspx?RID=CDS2000101724668&Book=100009&ChapterID=109708&TopicID=229426&Type=HA&Book1=-1&Chapter1=-1&Topic1=-1&Board=3&Class=10&Subject=5&Source=Reedit&Preview=");
		
		driver.findElement(By.xpath(".//*[@id='btncontinuesave']")).click();
	}
	

}
