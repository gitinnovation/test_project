package LicenseFiles;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import operation.ReadObject;
import java.io.IOException;
import java.util.Properties;



public class GenerateLicense {
 
	private WebDriver driver;
	int rn=2;
	
	  
	  funRepo fR = new funRepo();
		ReadObject object=new ReadObject();
		static Properties P;
		
		public GenerateLicense() throws IOException
		{
			P =  object.getObjectRepository();
		}
	
	  @DataProvider(name="ERP_DATA")
	  public static Object[][] readExcel() throws Exception {
			readExcel re = new readExcel();
			return re.readXLSX(P.getProperty("TestDataExcel"), P.getProperty("GenerateLicenseSheet"));
		}
	  
	  
	@BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\QA\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "D:\\eclipse\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
        fR.loGin(P,driver);
	    
        fR.DefineExcelReport();
    
	  }
	
	@Test(priority=1)
	public void CheckLogIn() throws Exception {
		
	    String Homepage=P.getProperty("url")+"/pub/help/AboutUS.aspx";
	    String CurrentURL=driver.getCurrentUrl();
	    if(CurrentURL.equals(Homepage))
	    {
	    	System.out.println("Successfully Login on FGR");
	    	
	    }
	    else {
	    	System.out.println("Login failed");
	    	driver.close();
	    }
	    
	}
	

	@Test(dataProvider="ERP_DATA", priority=2)
	  public void LicGeneration(String TC_No, String ServerID, String ERPCode,String ETECCount,String Implemented,String ContentETEC, String HardwareETEC, String ServiceETEC, String AMCETEC, String ExpectedResult, String errortype) throws Exception {
		
		fR.GenerateLic(P,driver,TC_No,  ServerID,  ERPCode, ETECCount, Implemented, ContentETEC, HardwareETEC, ServiceETEC, AMCETEC, ExpectedResult, errortype,rn);

	  }
	
	
	@Test(priority=3)
	public void LogOut() throws Exception {
		
		driver.findElement(By.id("ctl00_loginStatus1")).click();
		String LogInPage=P.getProperty("url")+"/Logon.aspx";
		if(driver.getCurrentUrl().equals(LogInPage))
			System.out.println("Successfully Logout from fgr");
		else 
			System.out.println("Logout Failed !");
		driver.close();
	}
	

	 
	 @AfterClass
	  public void setupAfterSuite() {
		  fR.GenerateExcelReport();
	
	  }
	
	
}
