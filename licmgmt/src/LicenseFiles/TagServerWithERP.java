package LicenseFiles;

import LicenseFiles.funRepo;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import operation.ReadObject;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.*;

public class TagServerWithERP {
	private WebDriver driver;
	
	funRepo fR = new funRepo();
	ReadObject object=new ReadObject();
	static Properties P;
	
	public TagServerWithERP() throws IOException
	{
		P =  object.getObjectRepository();
	}
	
	@BeforeClass(alwaysRun= true)
	public void setup() throws Exception  {
		System.setProperty("webdriver.chrome.driver","D:\\QA\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	//	System.setProperty("webdriver.gecko.driver", "D:\\eclipse\\geckodriver-v0.19.0-win64\\geckodriver.exe");
	//	driver = new FirefoxDriver();
		fR.loGin(P,driver);
	    
		  }
	
	
	@DataProvider(name="School")
	public static Object[][] readExcel() throws Exception {
		readExcel re = new readExcel();
		return re.readXLSX(P.getProperty("TestDataExcel"), P.getProperty("TagServerERPSheet"));
	}
  
	
	@Test(dataProvider="School", priority=1)
	public void ERPServerLinkage(String ServerID,String ChildERPCode)  throws Exception
		{
	
		fR.ERPServerLinkage(P,driver,ServerID, ChildERPCode);
		}

}