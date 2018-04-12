package SQAUpload;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import java.util.Properties;
import operation.ReadObject;


public class CreateSQA {

	private static Logger Log = Logger.getLogger(CreateSQA.class.getName());
	private WebDriver driver;
	int i=1;
	String str_BookID=null;
	String str_Chapter=null;
	String str_DisplayName=null;
	String str_Keyword=null;
	funRepo fR=new funRepo();
	ReadObject object=new ReadObject();
	
	
	@BeforeClass(alwaysRun= true)
		public void setup() throws Exception  {
		Properties allObject= object.getObjectRepository();
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\SQAUpload\\chromedriver.exe");
		driver = new ChromeDriver();
		fR.loGin(allObject,driver);		
			
			  }
	
	@Test(priority=1,dataProvider="SQA_DATA")
    public void CreateQuestion(String Board,String Class, String Subject, String Book, String BookId,String Chapter, String ChapterId, String Question,String Answer,String Keyword, String DisplayName, String BloomLevel, String Complexity, @Optional String QuestionImage, @Optional String AnswerImages) throws Exception {
		Properties allObject= object.getObjectRepository();
	
		if(str_BookID !=BookId && str_Chapter !=Chapter && i!=1)
		{
			i=1;
			fR.SaveSQA(allObject,driver,str_DisplayName,str_Keyword);
		}
		
		if(i==1)
		{
			fR.editSQA( allObject,driver, BookId,  Chapter); 
			Thread.sleep(5000);
		/*	 boolean CheckSQAEdit=false;
			 CheckSQAEdit=driver.findElement(By.cssSelector(".body_genp")).isDisplayed();
			 System.out.println("Is SQA Element is enable : "+CheckSQAEdit);
			  if(CheckSQAEdit) {
			    	fR.AddQuestins(allObject,driver,Question,Answer,QuestionImage,BloomLevel,Complexity, i);
			  } */
			
		}
		
	    fR.AddQuestins(allObject,driver,Question,Answer,QuestionImage,BloomLevel,Complexity, i);
	    i++;
	      
	      
	      str_BookID=BookId;
	      str_Chapter=Chapter;
	      str_DisplayName=DisplayName;
	  	  str_Keyword=Keyword;
	         
	      
	}

	
	 @DataProvider(name="SQA_DATA")
		public static Object[][] readExcel() throws  Exception {
		 
		 readExcel re = new readExcel();
			return re.readXLSX("D:\\Automation\\SQA.xlsx", "Sheet6"); 
	
		}
	
	
	@Test(priority=2)
    public void LogOut() throws Exception {
		Properties allObject= object.getObjectRepository();
		fR.SaveSQA(allObject,driver,str_DisplayName,str_Keyword);
		Thread.sleep(5000);
		driver.findElement(By.xpath(allObject.getProperty("LogoutBtn"))).click();
	}
		
	
	
	
}
